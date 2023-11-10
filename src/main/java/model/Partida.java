package model;

public class Partida {
    private long id;
    private Usuario usuario;
    private Bot bot;
    private String resultado;
    private String recompensa;
    public Partida() {
        super();
        id = 0;
        resultado = "";
        recompensa = "";
        usuario = new Usuario();
        bot = new Bot();
    }
    public Partida(long id, Usuario usuario, Bot bot, String resultado, String recompensa) {
        this.id = id;
        this.usuario = usuario;
        this.bot = bot;
        this.resultado = resultado;
        this.recompensa = recompensa;
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

    public Bot getBot() {
        return bot;
    }

    public void setBot(Bot bot) {
        this.bot = bot;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(String recompensa) {
        this.recompensa = recompensa;
    }
}
