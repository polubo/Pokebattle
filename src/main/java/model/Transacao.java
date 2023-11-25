package model;

import java.util.ArrayList;
import java.util.List;

public class Transacao {
    private long id;
    private String valor_transacao;
    private String item;
    private List<UsuarioTransacao> listUsuarioTransacao;

    public Transacao() {
        super();
        id = 0;
        valor_transacao = "";
        item = "";
        listUsuarioTransacao = new ArrayList<>();
    }
    public Transacao(long id, String valor_transacao, String item, List<UsuarioTransacao> listUsuarioTransacao) {
        this.id = id;
        this.valor_transacao = valor_transacao;
        this.item = item;
        this.listUsuarioTransacao = listUsuarioTransacao;
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

    public List<UsuarioTransacao> getListUsuarioTransacao() {
        return listUsuarioTransacao;
    }

    public void setListUsuarioTransacao(List<UsuarioTransacao> listUsuarioTransacao) {
        this.listUsuarioTransacao = listUsuarioTransacao;
    }
    @Override
    public String toString() {
        return "Transacao{" +
                "id=" + id +
                ", valor_transacao='" + valor_transacao + '\'' +
                ", item='" + item + '\'' +
                ", listUsuarioTransacao=" + listUsuarioTransacao +
                '}';
    }
}