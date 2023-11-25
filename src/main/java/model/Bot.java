package model;

import java.util.ArrayList;
import java.util.List;

public class Bot {
    private long id;
    private String nome;
    private List<Partida> listPartida;
    public Bot() {
        super();
        id = 0;
        nome = "";
        listPartida = new ArrayList<>();
    }
    public Bot(long id, String nome, List<Partida> listPartida) {
        this.id = id;
        this.nome = nome;
        this.listPartida = listPartida;
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
    public List<Partida> getListPartida() {
        return listPartida;
    }
    public void setListPartida(List<Partida> listPartida) {
        this.listPartida = listPartida;
    }
    @Override
    public String toString() {
        return "Bot{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", listPartida=" + listPartida +
                '}';
    }
}