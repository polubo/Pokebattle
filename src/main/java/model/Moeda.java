package model;

public class Moeda {
    private long id;
    private String nome;
    private String valor;
    public Moeda() {
        super();
        id = 0;
        nome = "";
        valor = "";
    }
    public Moeda(long id, String nome, String valor) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
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

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
