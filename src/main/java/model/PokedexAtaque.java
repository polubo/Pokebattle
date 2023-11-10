package model;

public class PokedexAtaque {
    private long id;
    private Ataque ataque;
    private Pokedex pokedex;
    private String nomePokemon;
    private String nome;
    public PokedexAtaque() {
        super();
        id = 0;
        ataque = new Ataque();
        pokedex = new Pokedex();
        nomePokemon = "";
        nome = "";
    }

    public PokedexAtaque(long id, Ataque ataque, Pokedex pokedex, String nomePokemon, String nome) {
        this.id = id;
        this.ataque = ataque;
        this.pokedex = pokedex;
        this.nomePokemon = nomePokemon;
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Ataque getAtaque() {
        return ataque;
    }

    public void setAtaque(Ataque ataque) {
        this.ataque = ataque;
    }

    public Pokedex getPokedex() {
        return pokedex;
    }

    public void setPokedex(Pokedex pokedex) {
        this.pokedex = pokedex;
    }

    public String getNomePokemon() {
        return nomePokemon;
    }

    public void setNomePokemon(String nomePokemon) {
        this.nomePokemon = nomePokemon;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
