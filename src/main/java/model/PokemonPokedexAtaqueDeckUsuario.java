package model;

public class PokemonPokedexAtaqueDeckUsuario {
    private long id;
    private Pokedex pokedex;
    private String nomePokemon;
    private String nome;
    private Ataque ataque;
    private Deck deck;
    private Usuario usuario;
    public PokemonPokedexAtaqueDeckUsuario() {
        super();
        id = 0;
        pokedex = new Pokedex();
        nomePokemon = "";
        nome = "";
        ataque = new Ataque();
        deck = new Deck();
        usuario = new Usuario();
    }

    public PokemonPokedexAtaqueDeckUsuario(long id,
                                           Pokedex pokedex,
                                           String nomePokemon,
                                           String nome,
                                           Ataque ataque,
                                           Deck deck,
                                           Usuario usuario) {
        this.id = id;
        this.pokedex = pokedex;
        this.nomePokemon = nomePokemon;
        this.nome = nome;
        this.ataque = ataque;
        this.deck = deck;
        this.usuario = usuario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Ataque getAtaque() {
        return ataque;
    }

    public void setAtaque(Ataque ataque) {
        this.ataque = ataque;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}

