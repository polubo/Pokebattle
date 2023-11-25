package persistencia;

import model.Moeda;
import model.Usuario;
import model.UsuarioMoeda;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioMoedaDAO {
    private ConexaoMysql conexao;

    public UsuarioMoedaDAO() {
        this.conexao = new ConexaoMysql("root", "lucasgremio", "localhost", "3306", "pokemonbd");
    }

    public UsuarioMoeda salvar(UsuarioMoeda usuarioMoeda) {
        this.conexao.abrirConexao();
        String sql = "INSERT INTO usuario_moeda VALUES(null, ?, ?)";
        try {
            PreparedStatement statement = conexao.getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setLong(1, usuarioMoeda.getUsuario().getId());
            statement.setLong(2, usuarioMoeda.getMoeda().getId());
            int linhasAfetadas = statement.executeUpdate();
            if (linhasAfetadas > 0) {
                ResultSet rs = statement.getGeneratedKeys();
                if(rs.next()) {
                    // SE ENTRAR AQUI � PQ RETORNOU UMA CHAVE GERADA NO BD
                    usuarioMoeda.setId(rs.getLong(1));
                }
                // OBJETIVO � PEGAR O ID GERADO NO BANCO
            }
            // JA TEM ID NO BANCO
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
        return usuarioMoeda;
    }

    public void editar(UsuarioMoeda usuarioMoeda) {
        this.conexao.abrirConexao();
        String sql = "UPDATE usuario_moeda SET id_usuario = ?, id_moeda = ? WHERE id_usuario_moeda = ?";
        try {
            PreparedStatement statement = conexao.getConexao().prepareStatement(sql);
            statement.setLong(1, usuarioMoeda.getUsuario().getId());
            statement.setLong(2, usuarioMoeda.getMoeda().getId());
            statement.setLong(3, usuarioMoeda.getId());
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
        String sql = "DELETE FROM usuario_moeda WHERE id_usuario_moeda = ?";
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
    public UsuarioMoeda buscarPorId(long id) {
        UsuarioMoeda usuarioMoeda = null;
        this.conexao.abrirConexao();
        String sql = "SELECT * FROM usuario_moeda WHERE id_ataque = ?";
        PreparedStatement statement;
        try {
            statement = conexao.getConexao().prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();

            // PRECISAMOS CONVERTER UM RESULTSET EM UM OBJETO USUARIO
            if (rs.next()) {
                // ENTRA APENAS SE O SELECT RETORNOU ALGO
                usuarioMoeda = new UsuarioMoeda();
                usuarioMoeda.setId(rs.getLong("id_usuario_moeda"));
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                Usuario usuario = usuarioDAO.buscarPorId(rs.getLong("id_usuario"));
                usuarioMoeda.setUsuario(usuario);
                MoedaDAO moedaDAO = new MoedaDAO();
                Moeda moeda = moedaDAO.buscarPorId(rs.getLong("id_moeda"));
                usuarioMoeda.setMoeda(moeda);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
        return usuarioMoeda;
    }

    public List<UsuarioMoeda> buscarTodos() {
        List<UsuarioMoeda> listaUsuarioMoeda= new ArrayList<>();
        UsuarioMoeda usuarioMoeda = null;
        this.conexao.abrirConexao();
        String sql = "SELECT * FROM usuario_moeda";
        PreparedStatement statement;
        try {
            statement = conexao.getConexao().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            // PRECISAMOS CONVERTER UM RESULTSET EM UM OBJETO USUARIO
            while(rs.next()) {
                // ENTRA APENAS SE O SELECT RETORNOU ALGO
                usuarioMoeda = new UsuarioMoeda();
                usuarioMoeda.setId(rs.getLong("id_usuario_moeda"));
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                Usuario usuario = usuarioDAO.buscarPorId(rs.getLong("id_usuario"));
                usuarioMoeda.setUsuario(usuario);
                MoedaDAO moedaDAO = new MoedaDAO();
                Moeda moeda = moedaDAO.buscarPorId(rs.getLong("id_moeda"));
                usuarioMoeda.setMoeda(moeda);
                // ADICIONAMOS O USUARIO NA LISTA
                listaUsuarioMoeda.add(usuarioMoeda);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
        return listaUsuarioMoeda;
    }
}