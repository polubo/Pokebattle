package model;

public class Loja {
    private long id;
    private String pokemon;
    private String preco;
    public Loja() {
        super();
        id = 0;
        pokemon = "";
        preco = "";
    }
    public Loja(long id, String pokemon, String preco) {
        this.id = id;
        this.pokemon = pokemon;
        this.preco = preco;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPokemon() {
        return pokemon;
    }

    public void setPokemon(String pokemon) {
        this.pokemon = pokemon;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

}
