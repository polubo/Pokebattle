package model;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    private long id;
    private String nome;
    private String pokemon;
    private List<Usuario> listUsuario;
    private List<Batalha> listBatalha;
    private List<PokemonPokedexAtaqueDeckUsuario> listPokemonPokedexAtaqueDeckUsuario;


    public Deck() {
        super();
        id = 0;
        nome = "";
        pokemon = "";
        listUsuario = new ArrayList<>();
        listBatalha = new ArrayList<>();
        listPokemonPokedexAtaqueDeckUsuario = new ArrayList<>();
    }
    public Deck(long id,
                String nome,
                String pokemon,
                List<Usuario> listUsuario,
                List<Batalha> listBatalha,
                List<PokemonPokedexAtaqueDeckUsuario> listPokemonPokedexAtaqueDeckUsuario) {
        this.id = id;
        this.nome = nome;
        this.pokemon = pokemon;
        this.listUsuario = listUsuario;
        this.listBatalha = listBatalha;
        this.listPokemonPokedexAtaqueDeckUsuario = listPokemonPokedexAtaqueDeckUsuario;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPokemon() {
        return pokemon;
    }

    public void setPokemon(String pokemon) {
        this.pokemon = pokemon;
    }

    public List<Usuario> getListUsuario() {
        return listUsuario;
    }

    public void setListUsuario(List<Usuario> listUsuario) {
        this.listUsuario = listUsuario;
    }

    public List<Batalha> getListBatalha() {
        return listBatalha;
    }

    public void setListBatalha(List<Batalha> listBatalha) {
        this.listBatalha = listBatalha;
    }
    public List<PokemonPokedexAtaqueDeckUsuario> getListPokemonPokedexAtaqueDeckUsuario() {
        return listPokemonPokedexAtaqueDeckUsuario;
    }

    public void setListPokemonPokedexAtaqueDeckUsuario(List<PokemonPokedexAtaqueDeckUsuario> listPokemonPokedexAtaqueDeckUsuario) {
        this.listPokemonPokedexAtaqueDeckUsuario = listPokemonPokedexAtaqueDeckUsuario;
    }
    @Override
    public String toString() {
        return "Deck{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", pokemon='" + pokemon + '\'' +
                ", listUsuario=" + listUsuario +
                ", listBatalha=" + listBatalha +
                ", listPokemonPokedexAtaqueDeckUsuario=" + listPokemonPokedexAtaqueDeckUsuario +
                '}';
    }
}