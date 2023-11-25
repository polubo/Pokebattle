package model;

public class LojaTransacao {
    private long id;
    private Loja loja;
    private Transacao transacao;
    public LojaTransacao() {
        super();
        id = 0;
        loja = new Loja();
        transacao = new Transacao();
    }
    public LojaTransacao(long id, Loja loja, Transacao transacao) {
        this.id = id;
        this.loja = loja;
        this.transacao = transacao;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public Transacao getTransacao() {
        return transacao;
    }

    public void setTransacao(Transacao transacao) {
        this.transacao = transacao;
    }
    @Override
    public String toString() {
        return "LojaTransacao{" +
                "id=" + id +
                ", loja=" + loja +
                ", transacao=" + transacao +
                '}';
    }
}