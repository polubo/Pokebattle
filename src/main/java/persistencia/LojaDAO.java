package persistencia;

import model.Loja;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LojaDAO {
    private ConexaoMysql conexao;

    public LojaDAO() {
        this.conexao = new ConexaoMysql("root", "lucasgremio", "localhost", "3306", "pokemonbd");
    }

    public Loja salvar(Loja loja) {
        this.conexao.abrirConexao();
        String sql = "INSERT INTO loja VALUES(null, ?, ?)";
        try {
            PreparedStatement statement = conexao.getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, loja.getPokemon());
            statement.setString(2, loja.getPreco());
            int linhasAfetadas = statement.executeUpdate();
            if (linhasAfetadas > 0) {
                ResultSet rs = statement.getGeneratedKeys();
                if(rs.next()) {
                    // SE ENTRAR AQUI � PQ RETORNOU UMA CHAVE GERADA NO BD
                    loja.setId(rs.getLong(1));
                }
                // OBJETIVO � PEGAR O ID GERADO NO BANCO
            }
            // JA TEM ID NO BANCO
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
        return loja;
    }

    public void editar(Loja loja) {
        this.conexao.abrirConexao();
        String sql = "UPDATE loja SET pokemon = ?, preco_pokemon = ? WHERE id_ataque = ?";
        try {
            PreparedStatement statement = conexao.getConexao().prepareStatement(sql);
            statement.setString(1, loja.getPokemon());
            statement.setString(2, loja.getPreco());
            statement.setLong(3, loja.getId());
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
        String sql = "DELETE FROM loja WHERE id_loja = ?";
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
    public Loja buscarPorId(long id) {
        Loja loja = null;
        this.conexao.abrirConexao();
        String sql = "SELECT * FROM loja WHERE id_loja = ?";
        PreparedStatement statement;
        try {
            statement = conexao.getConexao().prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();

            // PRECISAMOS CONVERTER UM RESULTSET EM UM OBJETO USUARIO
            if (rs.next()) {
                // ENTRA APENAS SE O SELECT RETORNOU ALGO
                loja = new Loja();
                loja.setId(rs.getLong("id_loja"));
                loja.setPokemon(rs.getString("pokemon"));
                loja.setPreco(rs.getString("preco_pokemon"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
        return loja;
    }

    public List<Loja> buscarTodos() {
        List<Loja> listaLoja= new ArrayList<>();
        Loja loja = null;
        this.conexao.abrirConexao();
        String sql = "SELECT * FROM loja";
        PreparedStatement statement;
        try {
            statement = conexao.getConexao().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            // PRECISAMOS CONVERTER UM RESULTSET EM UM OBJETO USUARIO
            while(rs.next()) {
                // ENTRA APENAS SE O SELECT RETORNOU ALGO
                loja = new Loja();
                loja.setId(rs.getLong("id_loja"));
                loja.setPokemon(rs.getString("pokemon"));
                loja.setPreco(rs.getString("preco_pokemon"));
                // ADICIONAMOS O USUARIO NA LISTA
                listaLoja.add(loja);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
        return listaLoja;
    }
}