
package persistencia;

import model.Deck;
import model.Loja;
import model.Usuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private ConexaoMysql conexao;

    public UsuarioDAO() {
        this.conexao = new ConexaoMysql("root", "lucasgremio", "localhost", "3306", "pokemonbd");
    }

    public Usuario salvar(Usuario usuario) {
        this.conexao.abrirConexao();
        String sql = "INSERT INTO usuario VALUES(null, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = conexao.getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getEmail());
            statement.setString(3, usuario.getSenha());
            statement.setString(4, usuario.getNivel());
            statement.setLong(5, usuario.getLoja().getId());
            statement.setLong(6, usuario.getDeck().getId());

            int linhasAfetadas = statement.executeUpdate();
            if (linhasAfetadas > 0) {
                ResultSet rs = statement.getGeneratedKeys();
                if(rs.next()) {
                    // SE ENTRAR AQUI � PQ RETORNOU UMA CHAVE GERADA NO BD
                    usuario.setId(rs.getLong(1));
                }
                // OBJETIVO � PEGAR O ID GERADO NO BANCO
            }
            // JA TEM ID NO BANCO
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
        return usuario;
    }

    public void editar(Usuario usuario) {
        this.conexao.abrirConexao();
        String sql = "UPDATE usuario SET nome_usuario = ?, email_usuario = ?, senha_usuario = ?, nivel_usuario = ?, id_loja = ?, id_deck = ? WHERE id_usuario = ?";
        try {
            PreparedStatement statement = conexao.getConexao().prepareStatement(sql);
            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getEmail());
            statement.setString(3, usuario.getSenha());
            statement.setString(4, usuario.getNivel());
            statement.setLong(5, usuario.getLoja().getId());
            statement.setLong(6, usuario.getDeck().getId());
            statement.setLong(7, usuario.getId());
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
        String sql = "DELETE FROM usuario WHERE id_usuario = ?";
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
    public Usuario buscarPorId(long id) {
        Usuario usuario = null;
        this.conexao.abrirConexao();
        String sql = "SELECT * FROM usuario WHERE id_usuario = ?";
        PreparedStatement statement;
        try {
            statement = conexao.getConexao().prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();

            // PRECISAMOS CONVERTER UM RESULTSET EM UM OBJETO USUARIO
            if (rs.next()) {
                // ENTRA APENAS SE O SELECT RETORNOU ALGO
                usuario = new Usuario();
                usuario.setId(rs.getLong("id_usuario"));
                usuario.setNome(rs.getString("nome_usuario"));
                usuario.setEmail(rs.getString("email_usuario"));
                usuario.setSenha(rs.getString("senha_usuario"));
                usuario.setNivel(rs.getString("nivel_usuario"));
                LojaDAO lojaDAO = new LojaDAO();
                Loja loja = lojaDAO.buscarPorId(rs.getLong("id_loja"));
                usuario.setLoja(loja);
                DeckDAO deckDAO = new DeckDAO();
                Deck deck = deckDAO.buscarPorId(rs.getLong("id_deck"));
                usuario.setDeck(deck);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
        return usuario;
    }

    public List<Usuario> buscarTodos() {
        List<Usuario> listaUsuarios = new ArrayList<>();
        Usuario usuario = null;
        this.conexao.abrirConexao();
        String sql = "SELECT * FROM usuario";
        PreparedStatement statement;
        try {
            statement = conexao.getConexao().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            // PRECISAMOS CONVERTER UM RESULTSET EM UM OBJETO USUARIO
            while(rs.next()) {
                // ENTRA APENAS SE O SELECT RETORNOU ALGO
                usuario = new Usuario();
                usuario.setId(rs.getLong("id_usuario"));
                usuario.setNome(rs.getString("nome_usuario"));
                usuario.setEmail(rs.getString("email_usuario"));
                usuario.setSenha(rs.getString("senha_usuario"));
                usuario.setNivel(rs.getString("nivel_usuario"));
                LojaDAO lojaDAO = new LojaDAO();
                Loja loja = lojaDAO.buscarPorId(rs.getLong("id_loja"));
                usuario.setLoja(loja);
                DeckDAO deckDAO = new DeckDAO();
                Deck deck = deckDAO.buscarPorId(rs.getLong("id_deck"));
                usuario.setDeck(deck);
                // ADICIONAMOS O USUARIO NA LISTA
                listaUsuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
        return listaUsuarios;
    }
}