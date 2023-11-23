package persistencia;

import model.PokemonPokedexAtaqueDeckUsuario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PokemonPokedexAtaqueDeckUsuarioDAO {
    private ConexaoMysql conexao;

    public PokemonPokedexAtaqueDeckUsuarioDAO() {
        this.conexao = new ConexaoMysql("root", "lucasgremio", "localhost", "3306", "pokemonbd");
    }

    public PokemonPokedexAtaqueDeckUsuario salvar(PokemonPokedexAtaqueDeckUsuario pokemonPokedexAtaqueDeckUsuario) {
        this.conexao.abrirConexao();
        String sql = "INSERT INTO ataque VALUES(null, null, ?, ?, null, null, null)";
        try {
            PreparedStatement statement = conexao.getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, pokemonPokedexAtaqueDeckUsuario.getNomePokemon());
            statement.setString(2, pokemonPokedexAtaqueDeckUsuario.getNome());
            int linhasAfetadas = statement.executeUpdate();
            if (linhasAfetadas > 0) {
                ResultSet rs = statement.getGeneratedKeys();
                if(rs.next()) {
                    // SE ENTRAR AQUI � PQ RETORNOU UMA CHAVE GERADA NO BD
                    pokemonPokedexAtaqueDeckUsuario.setId(rs.getLong(1));
                }
                // OBJETIVO � PEGAR O ID GERADO NO BANCO
            }
            // JA TEM ID NO BANCO
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
        return pokemonPokedexAtaqueDeckUsuario;
    }

    public void editar(PokemonPokedexAtaqueDeckUsuario pokemonPokedexAtaqueDeckUsuario) {
        this.conexao.abrirConexao();
        String sql = "UPDATE pokemon_pokedex_ataque_deck_usuario SET nome_pokemon = ?, nome = ? WHERE id_Pokemon_pokedex_ataque_deck_usuario = ?";
        try {
            PreparedStatement statement = conexao.getConexao().prepareStatement(sql);
            statement.setString(1, pokemonPokedexAtaqueDeckUsuario.getNomePokemon());
            statement.setString(2, pokemonPokedexAtaqueDeckUsuario.getNome());
            statement.setLong(3, pokemonPokedexAtaqueDeckUsuario.getId());
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
        String sql = "DELETE FROM pokemon_pokedex_ataque_deck_usuario WHERE id_Pokemon_pokedex_ataque_deck_usuario = ?";
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
    public PokemonPokedexAtaqueDeckUsuario buscarPorId(long id) {
        PokemonPokedexAtaqueDeckUsuario pokemonPokedexAtaqueDeckUsuario = null;
        this.conexao.abrirConexao();
        String sql = "SELECT * FROM pokemon_pokedex_ataque_deck_usuario WHERE id_Pokemon_pokedex_ataque_deck_usuario = ?";
        PreparedStatement statement;
        try {
            statement = conexao.getConexao().prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();

            // PRECISAMOS CONVERTER UM RESULTSET EM UM OBJETO USUARIO
            if (rs.next()) {
                // ENTRA APENAS SE O SELECT RETORNOU ALGO
                pokemonPokedexAtaqueDeckUsuario = new PokemonPokedexAtaqueDeckUsuario();
                pokemonPokedexAtaqueDeckUsuario.setId(rs.getLong("id_Pokemon_pokedex_ataque_deck_usuario"));
                pokemonPokedexAtaqueDeckUsuario.setNomePokemon(rs.getString("nome_pokemon"));
                pokemonPokedexAtaqueDeckUsuario.setNome(rs.getString("nome"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
        return pokemonPokedexAtaqueDeckUsuario;
    }

    public List<PokemonPokedexAtaqueDeckUsuario> buscarTodos() {
        List<PokemonPokedexAtaqueDeckUsuario> listaPokemon_pokedex_ataque_deck_usuario= new ArrayList<>();
        PokemonPokedexAtaqueDeckUsuario pokemonPokedexAtaqueDeckUsuario = null;
        this.conexao.abrirConexao();
        String sql = "SELECT * FROM pokemon_pokedex_ataque_deck_usuario";
        PreparedStatement statement;
        try {
            statement = conexao.getConexao().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            // PRECISAMOS CONVERTER UM RESULTSET EM UM OBJETO USUARIO
            while(rs.next()) {
                // ENTRA APENAS SE O SELECT RETORNOU ALGO
                pokemonPokedexAtaqueDeckUsuario = new PokemonPokedexAtaqueDeckUsuario();
                pokemonPokedexAtaqueDeckUsuario.setId(rs.getLong("id_Pokemon_pokedex_ataque_deck_usuario"));
                pokemonPokedexAtaqueDeckUsuario.setNomePokemon(rs.getString("nome_pokemon"));
                pokemonPokedexAtaqueDeckUsuario.setNome(rs.getString("nome"));
                // ADICIONAMOS O USUARIO NA LISTA
                listaPokemon_pokedex_ataque_deck_usuario.add(pokemonPokedexAtaqueDeckUsuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
        return listaPokemon_pokedex_ataque_deck_usuario;
    }
}