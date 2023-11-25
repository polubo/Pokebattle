package persistencia;

import model.*;

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
        String sql = "INSERT INTO ataque VALUES(null, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement statement = conexao.getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setLong(1, pokemonPokedexAtaqueDeckUsuario.getPokedex().getId());
            statement.setString(2, pokemonPokedexAtaqueDeckUsuario.getNomePokemon());
            statement.setString(3, pokemonPokedexAtaqueDeckUsuario.getNome());
            statement.setLong(4, pokemonPokedexAtaqueDeckUsuario.getAtaque().getId());
            statement.setLong(5, pokemonPokedexAtaqueDeckUsuario.getDeck().getId());
            statement.setLong(6, pokemonPokedexAtaqueDeckUsuario.getUsuario().getId());
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
        String sql = "UPDATE pokemon_pokedex_ataque_deck_usuario SET id_pokedex = ?, nome_pokemon = ?, nome = ?, id_ataque = ?, id_deck = ?, id_usuario = ? WHERE id_Pokemon_pokedex_ataque_deck_usuario = ?";
        try {
            PreparedStatement statement = conexao.getConexao().prepareStatement(sql);
            statement.setLong(1, pokemonPokedexAtaqueDeckUsuario.getPokedex().getId());
            statement.setString(2, pokemonPokedexAtaqueDeckUsuario.getNomePokemon());
            statement.setString(3, pokemonPokedexAtaqueDeckUsuario.getNome());
            statement.setLong(4, pokemonPokedexAtaqueDeckUsuario.getAtaque().getId());
            statement.setLong(5, pokemonPokedexAtaqueDeckUsuario.getDeck().getId());
            statement.setLong(6, pokemonPokedexAtaqueDeckUsuario.getUsuario().getId());
            statement.setLong(7, pokemonPokedexAtaqueDeckUsuario.getId());
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
                PokedexDAO pokedexDAO = new PokedexDAO();
                Pokedex pokedex = pokedexDAO.buscarPorId(rs.getLong("id_pokedex"));
                pokemonPokedexAtaqueDeckUsuario.setPokedex(pokedex);
                pokemonPokedexAtaqueDeckUsuario.setNomePokemon(rs.getString("nome_pokemon"));
                pokemonPokedexAtaqueDeckUsuario.setNome(rs.getString("nome"));
                AtaqueDAO ataqueDAO = new AtaqueDAO();
                Ataque ataque = ataqueDAO.buscarPorId(rs.getLong("id_ataque"));
                pokemonPokedexAtaqueDeckUsuario.setAtaque(ataque);
                DeckDAO deckDAO = new DeckDAO();
                Deck deck = deckDAO.buscarPorId(rs.getLong("id_deck"));
                pokemonPokedexAtaqueDeckUsuario.setDeck(deck);
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                Usuario usuario = usuarioDAO.buscarPorId(rs.getLong("id_usuario"));
                pokemonPokedexAtaqueDeckUsuario.setUsuario(usuario);
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
                PokedexDAO pokedexDAO = new PokedexDAO();
                Pokedex pokedex = pokedexDAO.buscarPorId(rs.getLong("id_pokedex"));
                pokemonPokedexAtaqueDeckUsuario.setPokedex(pokedex);
                pokemonPokedexAtaqueDeckUsuario.setNomePokemon(rs.getString("nome_pokemon"));
                pokemonPokedexAtaqueDeckUsuario.setNome(rs.getString("nome"));
                AtaqueDAO ataqueDAO = new AtaqueDAO();
                Ataque ataque = ataqueDAO.buscarPorId(rs.getLong("id_ataque"));
                pokemonPokedexAtaqueDeckUsuario.setAtaque(ataque);
                DeckDAO deckDAO = new DeckDAO();
                Deck deck = deckDAO.buscarPorId(rs.getLong("id_deck"));
                pokemonPokedexAtaqueDeckUsuario.setDeck(deck);
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                Usuario usuario = usuarioDAO.buscarPorId(rs.getLong("id_usuario"));
                pokemonPokedexAtaqueDeckUsuario.setUsuario(usuario);
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