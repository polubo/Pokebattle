package model;

public class UsuarioMoeda {
    private long id;
    private Usuario usuario;
    private Moeda moeda;
    public UsuarioMoeda() {
        super();
        id = 0;
        usuario = new Usuario();
        moeda = new Moeda();
    }
    public UsuarioMoeda(long id, Usuario usuario, Moeda moeda) {
        this.id = id;
        this.usuario = usuario;
        this.moeda = moeda;
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

    public Moeda getMoeda() {
        return moeda;
    }

    public void setMoeda(Moeda moeda) {
        this.moeda = moeda;
    }
    @Override
    public String toString() {
        return "UsuarioMoeda{" +
                "id=" + id +
                ", usuario=" + usuario +
                ", moeda=" + moeda +
                '}';
    }
}