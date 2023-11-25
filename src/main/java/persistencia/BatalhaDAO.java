package persistencia;

import model.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BatalhaDAO {
    private ConexaoMysql conexao;

    public BatalhaDAO() {
        this.conexao = new ConexaoMysql("root", "lucasgremio", "localhost", "3306", "pokemonbd");
    }

    public Batalha salvar(Batalha batalha) {
        this.conexao.abrirConexao();
        String sql = "INSERT INTO batalha VALUES(null, ?, ?)";
        try {
            PreparedStatement statement = conexao.getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setLong(1, batalha.getPartida().getId());
            statement.setLong(2, batalha.getDeck().getId());
            int linhasAfetadas = statement.executeUpdate();
            if (linhasAfetadas > 0) {
                ResultSet rs = statement.getGeneratedKeys();
                if(rs.next()) {
                    // SE ENTRAR AQUI � PQ RETORNOU UMA CHAVE GERADA NO BD
                    batalha.setId(rs.getLong(1));
                }
                // OBJETIVO � PEGAR O ID GERADO NO BANCO
            }
            // JA TEM ID NO BANCO
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
        return batalha;
    }

    public void editar(Batalha batalha) {
        this.conexao.abrirConexao();
        String sql = "UPDATE batalha SET id_partida = ?, id_deck = ? WHERE id_batalha = ?";
        try {
            PreparedStatement statement = conexao.getConexao().prepareStatement(sql);
            statement.setLong(1, batalha.getPartida().getId());
            statement.setLong(2, batalha.getDeck().getId());
            statement.setLong(3, batalha.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
    }

    // DELETE FROM usuario WHERE id_usuario = ?
    public void excluir(long id) {
        this.conexao.abrirConexao();
        String sql = "DELETE FROM batalha WHERE id_batalha = ?";
        try {
            PreparedStatement statement = conexao.getConexao().prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
    }

    // BUSCAR UM USUARIO PELO ID
    public Batalha buscarPorId(long id) {
        Batalha batalha = null;
        this.conexao.abrirConexao();
        String sql = "SELECT * FROM batalha WHERE id_batalha = ?";
        PreparedStatement statement;
        try {
            statement = conexao.getConexao().prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();

            // PRECISAMOS CONVERTER UM RESULTSET EM UM OBJETO USUARIO
            if (rs.next()) {
                // ENTRA APENAS SE O SELECT RETORNOU ALGO
                batalha = new Batalha();
                batalha.setId(rs.getLong("id_batalha"));
                PartidaDAO partidaDAO = new PartidaDAO();
                Partida partida = partidaDAO.buscarPorId(rs.getLong("id_partida"));
                batalha.setPartida(partida);
                DeckDAO deckDAO = new DeckDAO();
                Deck deck = deckDAO.buscarPorId(rs.getLong("id_deck"));
                batalha.setDeck(deck);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
        return batalha;
    }

    public List<Batalha> buscarTodos() {
        List<Batalha> listaBatalha= new ArrayList<>();
        Batalha batalha = null;
        this.conexao.abrirConexao();
        String sql = "SELECT * FROM batalha";
        PreparedStatement statement;
        try {
            statement = conexao.getConexao().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            // PRECISAMOS CONVERTER UM RESULTSET EM UM OBJETO USUARIO
            while(rs.next()) {
                // ENTRA APENAS SE O SELECT RETORNOU ALGO
                batalha = new Batalha();
                batalha.setId(rs.getLong("id_batalha"));
                // ADICIONAMOS O USUARIO NA LISTA
                listaBatalha.add(batalha);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
        return listaBatalha;
    }
}