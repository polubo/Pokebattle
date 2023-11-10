package model;

public class Pokedex {
    private long id;
    private pokemonPokedexAtaqueDeckUsuario pokemonpokedexataquedeckusuario;
    private String nome;
    private String tipoPokemon;
    private String vidaPokemon;
    private String danoPokemon;
    public Pokedex() {
        super();
        id = 0;
        pokemonpokedexataquedeckusuario = new pokemonPokedexAtaqueDeckUsuario();
        nome = "";
        tipoPokemon = "";
        vidaPokemon = "";
        danoPokemon = "";
    }
    public Pokedex(long id,
                   pokemonPokedexAtaqueDeckUsuario pokemonpokedexataquedeckusuario,
                   String nome,
                   String tipoPokemon,
                   String vidaPokemon,
                   String danoPokemon) {
        this.id = id;
        this.pokemonpokedexataquedeckusuario = pokemonpokedexataquedeckusuario;
        this.nome = nome;
        this.tipoPokemon = tipoPokemon;
        this.vidaPokemon = vidaPokemon;
        this.danoPokemon = danoPokemon;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public pokemonPokedexAtaqueDeckUsuario getPokemonpokedexataquedeckusuario() {
        return pokemonpokedexataquedeckusuario;
    }

    public void setPokemonpokedexataquedeckusuario(pokemonPokedexAtaqueDeckUsuario pokemonpokedexataquedeckusuario) {
        this.pokemonpokedexataquedeckusuario = pokemonpokedexataquedeckusuario;
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
}
