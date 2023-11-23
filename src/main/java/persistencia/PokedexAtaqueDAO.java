package persistencia;

import model.PokedexAtaque;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PokedexAtaqueDAO {
    private ConexaoMysql conexao;

    public PokedexAtaqueDAO() {
        this.conexao = new ConexaoMysql("root", "lucasgremio", "localhost", "3306", "pokemonbd");
    }

    public PokedexAtaque salvar(PokedexAtaque pokedexAtaque) {
        this.conexao.abrirConexao();
        String sql = "INSERT INTO ataque VALUES(null, null, null, ?, ?)";
        try {
            PreparedStatement statement = conexao.getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, pokedexAtaque.getNomePokemon());
            statement.setString(2, pokedexAtaque.getNome());
            int linhasAfetadas = statement.executeUpdate();
            if (linhasAfetadas > 0) {
                ResultSet rs = statement.getGeneratedKeys();
                if(rs.next()) {
                    // SE ENTRAR AQUI � PQ RETORNOU UMA CHAVE GERADA NO BD
                    pokedexAtaque.setId(rs.getLong(1));
                }
                // OBJETIVO � PEGAR O ID GERADO NO BANCO
            }
            // JA TEM ID NO BANCO
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
        return pokedexAtaque;
    }

    public void editar(PokedexAtaque pokedexAtaque) {
        this.conexao.abrirConexao();
        String sql = "UPDATE pokedex_ataque SET nome_pokemon = ?, nome = ? WHERE id_pokedex_ataque = ?";
        try {
            PreparedStatement statement = conexao.getConexao().prepareStatement(sql);
            statement.setString(1, pokedexAtaque.getNomePokemon());
            statement.setString(2, pokedexAtaque.getNome());
            statement.setLong(3, pokedexAtaque.getId());
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
        String sql = "DELETE FROM pokedex_ataque WHERE id_pokedex_ataque = ?";
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
    public PokedexAtaque buscarPorId(long id) {
        PokedexAtaque pokedexAtaque = null;
        this.conexao.abrirConexao();
        String sql = "SELECT * FROM pokedex_ataque WHERE id_pokedex_ataque = ?";
        PreparedStatement statement;
        try {
            statement = conexao.getConexao().prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();

            // PRECISAMOS CONVERTER UM RESULTSET EM UM OBJETO USUARIO
            if (rs.next()) {
                // ENTRA APENAS SE O SELECT RETORNOU ALGO
                pokedexAtaque = new PokedexAtaque();
                pokedexAtaque.setId(rs.getLong("id_pokedex_ataque"));
                pokedexAtaque.setNomePokemon(rs.getString("nome_pokemon"));
                pokedexAtaque.setNome(rs.getString("nome"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
        return pokedexAtaque;
    }

    public List<PokedexAtaque> buscarTodos() {
        List<PokedexAtaque> listaPokedexAtaque= new ArrayList<>();
        PokedexAtaque pokedexAtaque = null;
        this.conexao.abrirConexao();
        String sql = "SELECT * FROM pokedex_ataque";
        PreparedStatement statement;
        try {
            statement = conexao.getConexao().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            // PRECISAMOS CONVERTER UM RESULTSET EM UM OBJETO USUARIO
            while(rs.next()) {
                // ENTRA APENAS SE O SELECT RETORNOU ALGO
                pokedexAtaque = new PokedexAtaque();
                pokedexAtaque.setId(rs.getLong("id_pokedex_ataque"));
                pokedexAtaque.setNomePokemon(rs.getString("nome_pokemon"));
                pokedexAtaque.setNome(rs.getString("nome"));
                // ADICIONAMOS O USUARIO NA LISTA
                listaPokedexAtaque.add(pokedexAtaque);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
        return listaPokedexAtaque;
    }
}