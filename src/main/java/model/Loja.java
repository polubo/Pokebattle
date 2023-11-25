package model;

import java.util.ArrayList;
import java.util.List;

public class Loja {
    private long id;
    private String pokemon;
    private String preco;
    private List<Usuario> listUsuario;
    private List<LojaTransacao> listLojaTransacao;
    public Loja() {
        super();
        id = 0;
        pokemon = "";
        preco = "";
        listUsuario = new ArrayList<>();
        listLojaTransacao = new ArrayList<>();
    }
    public Loja(long id, String pokemon, String preco, List<Usuario> listUsuario, List<LojaTransacao> listLojaTransacao) {
        this.id = id;
        this.pokemon = pokemon;
        this.preco = preco;
        this.listUsuario = listUsuario;
        this.listLojaTransacao = listLojaTransacao;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPokemon() {
        return pokemon;
    }

    public void setPokemon(String pokemon) {
        this.pokemon = pokemon;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public List<Usuario> getListUsuario() {
        return listUsuario;
    }

    public void setListUsuario(List<Usuario> listUsuario) {
        this.listUsuario = listUsuario;
    }

    public List<LojaTransacao> getListLojaTransacao() {
        return listLojaTransacao;
    }

    public void setListLojaTransacao(List<LojaTransacao> listLojaTransacao) {
        this.listLojaTransacao = listLojaTransacao;
    }
    @Override
    public String toString() {
        return "Loja{" +
                "id=" + id +
                ", pokemon='" + pokemon + '\'' +
                ", preco='" + preco + '\'' +
                ", listUsuario=" + listUsuario +
                ", listLojaTransacao=" + listLojaTransacao +
                '}';
    }
}
