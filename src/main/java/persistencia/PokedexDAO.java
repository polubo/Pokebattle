package persistencia;

import model.Pokedex;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PokedexDAO {
    private ConexaoMysql conexao;

    public PokedexDAO() {
        this.conexao = new ConexaoMysql("root", "lucasgremio", "localhost", "3306", "pokemonbd");
    }

    public Pokedex salvar(Pokedex pokedex) {
        this.conexao.abrirConexao();
        String sql = "INSERT INTO pokedex VALUES(null, null, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = conexao.getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, pokedex.getNome());
            statement.setString(2, pokedex.getTipoPokemon());
            statement.setString(3, pokedex.getVidaPokemon());
            statement.setString(4, pokedex.getDanoPokemon());
            int linhasAfetadas = statement.executeUpdate();
            if (linhasAfetadas > 0) {
                ResultSet rs = statement.getGeneratedKeys();
                if(rs.next()) {
                    // SE ENTRAR AQUI � PQ RETORNOU UMA CHAVE GERADA NO BD
                    pokedex.setId(rs.getLong(1));
                }
                // OBJETIVO � PEGAR O ID GERADO NO BANCO
            }
            // JA TEM ID NO BANCO
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
        return pokedex;
    }

    public void editar(Pokedex pokedex) {
        this.conexao.abrirConexao();
        String sql = "UPDATE pokedex SET nome_pokemon = ?, tipo_pokemon = ?, vida_pokemon = ?, dano_pokemon = ? WHERE id_pokedex = ?";
        try {
            PreparedStatement statement = conexao.getConexao().prepareStatement(sql);
            statement.setString(1, pokedex.getNome());
            statement.setString(2, pokedex.getTipoPokemon());
            statement.setString(3, pokedex.getVidaPokemon());
            statement.setString(4, pokedex.getDanoPokemon());
            statement.setLong(5, pokedex.getId());
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
        String sql = "DELETE FROM pokedex WHERE id_pokedex = ?";
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
    public Pokedex buscarPorId(long id) {
        Pokedex pokedex = null;
        this.conexao.abrirConexao();
        String sql = "SELECT * FROM pokedex WHERE id_pokedex = ?";
        PreparedStatement statement;
        try {
            statement = conexao.getConexao().prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();

            // PRECISAMOS CONVERTER UM RESULTSET EM UM OBJETO USUARIO
            if (rs.next()) {
                // ENTRA APENAS SE O SELECT RETORNOU ALGO
                pokedex = new Pokedex();
                pokedex.setId(rs.getLong("id_usuario"));
                pokedex.setNome(rs.getString("nome"));
                pokedex.setTipoPokemon(rs.getString("TipoPokemon"));
                pokedex.setVidaPokemon(rs.getString("VidaPokemon"));
                pokedex.setDanoPokemon(rs.getString("DanoPokemon"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
        return pokedex;
    }

    public List<Pokedex> buscarTodos() {
        List<Pokedex> listaPokedex = new ArrayList<>();
        Pokedex pokedex = null;
        this.conexao.abrirConexao();
        String sql = "SELECT * FROM pokedex";
        PreparedStatement statement;
        try {
            statement = conexao.getConexao().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            // PRECISAMOS CONVERTER UM RESULTSET EM UM OBJETO USUARIO
            while(rs.next()) {
                // ENTRA APENAS SE O SELECT RETORNOU ALGO
                pokedex = new Pokedex();
                pokedex.setId(rs.getLong("id_usuario"));
                pokedex.setNome(rs.getString("nome"));
                pokedex.setTipoPokemon(rs.getString("TipoPokemon"));
                pokedex.setVidaPokemon(rs.getString("VidaPokemon"));
                pokedex.setDanoPokemon(rs.getString("DanoPokemon"));
                // ADICIONAMOS O USUARIO NA LISTA
                listaPokedex.add(pokedex);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
        return listaPokedex;
    }
}