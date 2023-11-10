package model;

public class Deck {
    private long id;
    private String nome;
    private String pokemon;
    public Deck() {
        super();
        id = 0;
        nome = "";
        pokemon = "";
    }
    public Deck(long id, String nome, String pokemon) {
        this.id = id;
        this.nome = nome;
        this.pokemon = pokemon;
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
}
