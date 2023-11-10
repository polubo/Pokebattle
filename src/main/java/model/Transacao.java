package model;

public class Transacao {
    private long id;
    private String valor_transacao;
    private String item;
    public Transacao() {
        super();
        id = 0;
        valor_transacao = "";
        item = "";
    }
    public Transacao(long id, String valor_transacao, String item) {
        this.id = id;
        this.valor_transacao = valor_transacao;
        this.item = item;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getValor_transacao() {
        return valor_transacao;
    }

    public void setValor_transacao(String valor_transacao) {
        this.valor_transacao = valor_transacao;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
