package model;

public class UsuarioTransacao {
    private long id;
    private Usuario usuario;
    private Transacao transacao;
    public UsuarioTransacao() {
        super();
        id = 0;
        usuario = new Usuario();
        transacao = new Transacao();
    }
    public UsuarioTransacao(long id, Usuario usuario, Transacao transacao) {
        this.id = id;
        this.usuario = usuario;
        this.transacao = transacao;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Transacao getTransacao() {
        return transacao;
    }

    public void setTransacao(Transacao transacao) {
        this.transacao = transacao;
    }
    @Override
    public String toString() {
        return "UsuarioTransacao{" +
                "id=" + id +
                ", usuario=" + usuario +
                ", transacao=" + transacao +
                '}';
    }
}
