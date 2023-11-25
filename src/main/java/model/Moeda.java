package model;

import java.util.ArrayList;
import java.util.List;

public class Moeda {
    private long id;
    private String nome;
    private String valor;
    private List<UsuarioMoeda> listUsuarioMoeda;
    public Moeda() {
        super();
        id = 0;
        nome = "";
        valor = "";
        listUsuarioMoeda = new ArrayList<>();
    }
    public Moeda(long id, String nome, String valor, List<UsuarioMoeda> listUsuarioMoeda) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.listUsuarioMoeda = listUsuarioMoeda;
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

    public List<UsuarioMoeda> getListUsuarioMoeda() {
        return listUsuarioMoeda;
    }

    public void setListUsuarioMoeda(List<UsuarioMoeda> listUsuarioMoeda) {
        this.listUsuarioMoeda = listUsuarioMoeda;
    }
    @Override
    public String toString() {
        return "Moeda{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", valor='" + valor + '\'' +
                ", listUsuarioMoeda=" + listUsuarioMoeda +
                '}';
    }
}
