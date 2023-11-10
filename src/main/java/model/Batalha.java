package model;

public class Batalha {
    private long id;
    private Partida partida;
    private Deck deck;
    public Batalha() {
        super();
        id = 0;
        partida = new Partida();
        deck = new Deck();
    }
    public Batalha(long id, Partida partida, Deck deck) {
        this.id = id;
        this.partida = partida;
        this.deck = deck;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }
}
