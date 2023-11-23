package persistencia;

import model.Transacao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransacaoDAO {
    private ConexaoMysql conexao;

    public TransacaoDAO() {
        this.conexao = new ConexaoMysql("root", "lucasgremio", "localhost", "3306", "pokemonbd");
    }

    public Transacao salvar(Transacao transacao) {
        this.conexao.abrirConexao();
        String sql = "INSERT INTO transacao VALUES(null, ?, ?)";
        try {
            PreparedStatement statement = conexao.getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, transacao.getValor_transacao());
            statement.setString(2, transacao.getItem());
            int linhasAfetadas = statement.executeUpdate();
            if (linhasAfetadas > 0) {
                ResultSet rs = statement.getGeneratedKeys();
                if(rs.next()) {
                    // SE ENTRAR AQUI � PQ RETORNOU UMA CHAVE GERADA NO BD
                    transacao.setId(rs.getLong(1));
                }
                // OBJETIVO � PEGAR O ID GERADO NO BANCO
            }
            // JA TEM ID NO BANCO
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
        return transacao;
    }

    public void editar(Transacao transacao) {
        this.conexao.abrirConexao();
        String sql = "UPDATE transacao SET valor_transacao = ?, item = ? WHERE id_transacao = ?";
        try {
            PreparedStatement statement = conexao.getConexao().prepareStatement(sql);
            statement.setString(1, transacao.getValor_transacao());
            statement.setString(2, transacao.getItem());
            statement.setLong(3, transacao.getId());
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
        String sql = "DELETE FROM transacao WHERE id_transacao = ?";
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
    public Transacao buscarPorId(long id) {
        Transacao transacao = null;
        this.conexao.abrirConexao();
        String sql = "SELECT * FROM transacao WHERE id_transacao = ?";
        PreparedStatement statement;
        try {
            statement = conexao.getConexao().prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();

            // PRECISAMOS CONVERTER UM RESULTSET EM UM OBJETO USUARIO
            if (rs.next()) {
                // ENTRA APENAS SE O SELECT RETORNOU ALGO
                transacao = new Transacao();
                transacao.setId(rs.getLong("id_transacao"));
                transacao.setValor_transacao(rs.getString("valor_transacao"));
                transacao.setItem(rs.getString("item"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
        return transacao;
    }

    public List<Transacao> buscarTodos() {
        List<Transacao> listaTransacao= new ArrayList<>();
        Transacao transacao = null;
        this.conexao.abrirConexao();
        String sql = "SELECT * FROM transacao";
        PreparedStatement statement;
        try {
            statement = conexao.getConexao().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            // PRECISAMOS CONVERTER UM RESULTSET EM UM OBJETO USUARIO
            while(rs.next()) {
                // ENTRA APENAS SE O SELECT RETORNOU ALGO
                transacao = new Transacao();
                transacao.setId(rs.getLong("id_transacao"));
                transacao.setValor_transacao(rs.getString("valor_transacao"));
                transacao.setItem(rs.getString("item"));
                // ADICIONAMOS O USUARIO NA LISTA
                listaTransacao.add(transacao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
        return listaTransacao;
    }
}