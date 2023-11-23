package persistencia;

import model.Deck;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeckDAO {
    private ConexaoMysql conexao;

    public DeckDAO() {
        this.conexao = new ConexaoMysql("root", "lucasgremio", "localhost", "3306", "pokemonbd");
    }

    public Deck salvar(Deck deck) {
        this.conexao.abrirConexao();
        String sql = "INSERT INTO deck VALUES(null, ?, ?)";
        try {
            PreparedStatement statement = conexao.getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, deck.getNome());
            statement.setString(2, deck.getPokemon());
            int linhasAfetadas = statement.executeUpdate();
            if (linhasAfetadas > 0) {
                ResultSet rs = statement.getGeneratedKeys();
                if(rs.next()) {
                    // SE ENTRAR AQUI � PQ RETORNOU UMA CHAVE GERADA NO BD
                    deck.setId(rs.getLong(1));
                }
                // OBJETIVO � PEGAR O ID GERADO NO BANCO
            }
            // JA TEM ID NO BANCO
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
        return deck;
    }

    public void editar(Deck deck) {
        this.conexao.abrirConexao();
        String sql = "UPDATE deck SET nome_deck = ?, lista_pokemon = ? WHERE id_deck = ?";
        try {
            PreparedStatement statement = conexao.getConexao().prepareStatement(sql);
            statement.setString(1, deck.getNome());
            statement.setString(2, deck.getPokemon());
            statement.setLong(3, deck.getId());
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
        String sql = "DELETE FROM deck WHERE id_deck = ?";
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
    public Deck buscarPorId(long id) {
        Deck deck = null;
        this.conexao.abrirConexao();
        String sql = "SELECT * FROM deck WHERE id_deck = ?";
        PreparedStatement statement;
        try {
            statement = conexao.getConexao().prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();

            // PRECISAMOS CONVERTER UM RESULTSET EM UM OBJETO USUARIO
            if (rs.next()) {
                // ENTRA APENAS SE O SELECT RETORNOU ALGO
                deck = new Deck();
                deck.setId(rs.getLong("id_deck"));
                deck.setNome(rs.getString("lista_pokemon"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
        return deck;
    }

    public List<Deck> buscarTodos() {
        List<Deck> listaDeck= new ArrayList<>();
        Deck deck = null;
        this.conexao.abrirConexao();
        String sql = "SELECT * FROM deck";
        PreparedStatement statement;
        try {
            statement = conexao.getConexao().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            // PRECISAMOS CONVERTER UM RESULTSET EM UM OBJETO USUARIO
            while(rs.next()) {
                // ENTRA APENAS SE O SELECT RETORNOU ALGO
                deck = new Deck();
                deck.setId(rs.getLong("id_ataque"));
                deck.setNome(rs.getString("lista_pokemon"));
                // ADICIONAMOS O USUARIO NA LISTA
                listaDeck.add(deck);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
        return listaDeck;
    }
}