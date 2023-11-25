package model;

import java.util.ArrayList;
import java.util.List;

public class Ataque {
    private long id;
    private String nome;
    private String dano;
    private List<PokedexAtaque> listPokedexAtaque;
    private List<PokemonPokedexAtaqueDeckUsuario> listPokemonPokedexAtaqueDeckUsuario;

    public Ataque() {
        super();
        id = 0;
        nome = "";
        dano = "";
        listPokedexAtaque = new ArrayList<>();
        listPokemonPokedexAtaqueDeckUsuario = new ArrayList<>();

    }
    public Ataque(long id,
                  String nome,
                  String dano,
                  List<PokedexAtaque> listPokedexAtaque,
                  List<PokemonPokedexAtaqueDeckUsuario> listPokemonPokedexAtaqueDeckUsuario) {
        this.id = id;
        this.nome = nome;
        this.dano = dano;
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

    public String getDano() {
        return dano;
    }

    public void setDano(String dano) {
        this.dano = dano;
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
        return "Ataque{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dano='" + dano + '\'' +
                ", listPokedexAtaque=" + listPokedexAtaque +
                ", listPokemonPokedexAtaqueDeckUsuario=" + listPokemonPokedexAtaqueDeckUsuario +
                '}';
    }
}