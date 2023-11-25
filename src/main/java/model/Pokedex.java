package model;

import java.util.ArrayList;
import java.util.List;

public class Pokedex {
    private long id;
    private String nome;
    private String tipoPokemon;
    private String vidaPokemon;
    private String danoPokemon;
    private List<PokedexAtaque> listPokedexAtaque;
    private List<PokemonPokedexAtaqueDeckUsuario> listPokemonPokedexAtaqueDeckUsuario;

    public Pokedex() {
        super();
        id = 0;
        nome = "";
        tipoPokemon = "";
        vidaPokemon = "";
        danoPokemon = "";
        listPokedexAtaque = new ArrayList<>();
        listPokemonPokedexAtaqueDeckUsuario = new ArrayList<>();
    }
    public Pokedex(long id,
                   String nome,
                   String tipoPokemon,
                   String vidaPokemon,
                   String danoPokemon,
                   List<PokedexAtaque> listPokedexAtaque,
                   List<PokemonPokedexAtaqueDeckUsuario> listPokemonPokedexAtaqueDeckUsuario) {
        this.id = id;
        this.nome = nome;
        this.tipoPokemon = tipoPokemon;
        this.vidaPokemon = vidaPokemon;
        this.danoPokemon = danoPokemon;
        this.listPokedexAtaque = listPokedexAtaque;
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

    public String getTipoPokemon() {
        return tipoPokemon;
    }

    public void setTipoPokemon(String tipoPokemon) {
        this.tipoPokemon = tipoPokemon;
    }

    public String getVidaPokemon() {
        return vidaPokemon;
    }

    public void setVidaPokemon(String vidaPokemon) {
        this.vidaPokemon = vidaPokemon;
    }

    public String getDanoPokemon() {
        return danoPokemon;
    }

    public void setDanoPokemon(String danoPokemon) {
        this.danoPokemon = danoPokemon;
    }

    public List<PokedexAtaque> getListPokedexAtaque() {
        return listPokedexAtaque;
    }

    public void setListPokedexAtaque(List<PokedexAtaque> listPokedexAtaque) {
        this.listPokedexAtaque = listPokedexAtaque;
    }
    public List<PokemonPokedexAtaqueDeckUsuario> getListPokemonPokedexAtaqueDeckUsuario() {
        return listPokemonPokedexAtaqueDeckUsuario;
    }

    public void setListPokemonPokedexAtaqueDeckUsuario(List<PokemonPokedexAtaqueDeckUsuario> listPokemonPokedexAtaqueDeckUsuario) {
        this.listPokemonPokedexAtaqueDeckUsuario = listPokemonPokedexAtaqueDeckUsuario;
    }
    @Override
    public String toString() {
        return "Pokedex{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", tipoPokemon='" + tipoPokemon + '\'' +
                ", vidaPokemon='" + vidaPokemon + '\'' +
                ", danoPokemon='" + danoPokemon + '\'' +
                ", listPokedexAtaque=" + listPokedexAtaque +
                ", listPokemonPokedexAtaqueDeckUsuario=" + listPokemonPokedexAtaqueDeckUsuario +
                '}';
    }
}