package model;

import java.util.ArrayList;
import java.util.List;

public class Partida {
    private long id;
    private String resultado;
    private String recompensa;
    private Usuario usuario;
    private Bot bot;
    private List<Batalha> listBatalha;
    public Partida() {
        super();
        id = 0;
        resultado = "";
        recompensa = "";
        usuario = new Usuario();
        bot = new Bot();
        listBatalha = new ArrayList<>();
    }
    public Partida(long id, String resultado, String recompensa, Usuario usuario, Bot bot, List<Batalha> listBatalha) {
        this.id = id;
        this.resultado = resultado;
        this.recompensa = recompensa;
        this.usuario = usuario;
        this.bot = bot;
        this.listBatalha = listBatalha;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public List<Batalha> getListBatalha() {
        return listBatalha;
    }

    public void setListBatalha(List<Batalha> listBatalha) {
        this.listBatalha = listBatalha;
    }
    @Override
    public String toString() {
        return "Partida{" +
                "id=" + id +
                ", resultado='" + resultado + '\'' +
                ", recompensa='" + recompensa + '\'' +
                ", usuario=" + usuario +
                ", bot=" + bot +
                ", listBatalha=" + listBatalha +
                '}';
    }
}