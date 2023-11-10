package model;

public class Ataque {
    private long id;
    private String nome;
    private String dano;
    public Ataque() {
        super();
        id = 0;
        nome = "";
        dano = "";
    }
    public Ataque(long id, String nome, String dano) {
        this.id = id;
        this.nome = nome;
        this.dano = dano;
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
}
