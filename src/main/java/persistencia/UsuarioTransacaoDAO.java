package persistencia;

import model.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioTransacaoDAO {
    private ConexaoMysql conexao;

    public UsuarioTransacaoDAO() {
        this.conexao = new ConexaoMysql("root", "lucasgremio", "localhost", "3306", "pokemonbd");
    }

    public UsuarioTransacao salvar(UsuarioTransacao usuarioTransacao) {
        this.conexao.abrirConexao();
        String sql = "INSERT INTO usuario_transacao VALUES(null, ?, ?)";
        try {
            PreparedStatement statement = conexao.getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setLong(1, usuarioTransacao.getUsuario().getId());
            statement.setLong(2, usuarioTransacao.getTransacao().getId());
            int linhasAfetadas = statement.executeUpdate();
            if (linhasAfetadas > 0) {
                ResultSet rs = statement.getGeneratedKeys();
                if(rs.next()) {
                    // SE ENTRAR AQUI � PQ RETORNOU UMA CHAVE GERADA NO BD
                    usuarioTransacao.setId(rs.getLong(1));
                }
                // OBJETIVO � PEGAR O ID GERADO NO BANCO
            }
            // JA TEM ID NO BANCO
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
        return usuarioTransacao;
    }

    public void editar(UsuarioTransacao usuarioTransacao) {
        this.conexao.abrirConexao();
        String sql = "UPDATE usuario_transacao SET id_usuario = ?, id_transacao = ? WHERE id_usuario_transacao = ?";
        try {
            PreparedStatement statement = conexao.getConexao().prepareStatement(sql);
            statement.setLong(1, usuarioTransacao.getUsuario().getId());
            statement.setLong(2, usuarioTransacao.getTransacao().getId());
            statement.setLong(3, usuarioTransacao.getId());
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
        String sql = "DELETE FROM usuario_transacao WHERE id_usuario_transacao = ?";
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
    public UsuarioTransacao buscarPorId(long id) {
        UsuarioTransacao usuarioTransacao = null;
        this.conexao.abrirConexao();
        String sql = "SELECT * FROM usuario_transacao WHERE id_usuario_transacao = ?";
        PreparedStatement statement;
        try {
            statement = conexao.getConexao().prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();

            // PRECISAMOS CONVERTER UM RESULTSET EM UM OBJETO USUARIO
            if (rs.next()) {
                // ENTRA APENAS SE O SELECT RETORNOU ALGO
                usuarioTransacao = new UsuarioTransacao();
                usuarioTransacao.setId(rs.getLong("id_usuario_transacao"));
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                Usuario usuario = usuarioDAO.buscarPorId(rs.getLong("id_usuario"));
                usuarioTransacao.setUsuario(usuario);
                TransacaoDAO transacaoDAO = new TransacaoDAO();
                Transacao transacao = transacaoDAO.buscarPorId(rs.getLong("id_transacao"));
                usuarioTransacao.setTransacao(transacao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
        return usuarioTransacao;
    }

    public List<UsuarioTransacao> buscarTodos() {
        List<UsuarioTransacao> listaUsuarioTransacao= new ArrayList<>();
        UsuarioTransacao usuarioTransacao = null;
        this.conexao.abrirConexao();
        String sql = "SELECT * FROM usuario_transacao";
        PreparedStatement statement;
        try {
            statement = conexao.getConexao().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            // PRECISAMOS CONVERTER UM RESULTSET EM UM OBJETO USUARIO
            while(rs.next()) {
                // ENTRA APENAS SE O SELECT RETORNOU ALGO
                usuarioTransacao = new UsuarioTransacao();
                usuarioTransacao.setId(rs.getLong("id_usuario_transacao"));
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                Usuario usuario = usuarioDAO.buscarPorId(rs.getLong("id_usuario"));
                usuarioTransacao.setUsuario(usuario);
                TransacaoDAO transacaoDAO = new TransacaoDAO();
                Transacao transacao = transacaoDAO.buscarPorId(rs.getLong("id_transacao"));
                usuarioTransacao.setTransacao(transacao);
                // ADICIONAMOS O USUARIO NA LISTA
                listaUsuarioTransacao.add(usuarioTransacao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
        return listaUsuarioTransacao;
    }
}