package model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private long id;
    private String nome;
    private String email;
    private String senha;
    private String nivel;
    private Loja loja;
    private Deck deck;
    private List<Partida> listPartida;
    private List<UsuarioMoeda> listUsuarioMoeda;
    private List<UsuarioTransacao> listUsuarioTransacao;
    private List<PokemonPokedexAtaqueDeckUsuario> listPokemonPokedexAtaqueDeckUsuario;

    public Usuario() {
        super();
        id = 0;
        nome = "";
        email = "";
        senha = "";
        nivel = "";
        loja = new Loja();
        deck = new Deck();
        listPartida = new ArrayList<>();
        listUsuarioMoeda = new ArrayList<>();
        listUsuarioTransacao = new ArrayList<>();
        listPokemonPokedexAtaqueDeckUsuario = new ArrayList<>();
    }
    public Usuario(long id,
                   String nome,
                   String email,
                   String senha,
                   String nivel,
                   Loja loja,
                   Deck deck,
                   List<Partida> listPartida,
                   List<UsuarioMoeda> listUsuarioMoeda,
                   List<UsuarioTransacao> listUsuarioTransacao,
                   List<PokemonPokedexAtaqueDeckUsuario> listPokemonPokedexAtaqueDeckUsuario) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.nivel = nivel;
        this.loja = loja;
        this.deck = deck;
        this.listPartida = listPartida;
        this.listUsuarioMoeda = listUsuarioMoeda;
        this.listUsuarioTransacao = listUsuarioTransacao;
        this.listPokemonPokedexAtaqueDeckUsuario = listPokemonPokedexAtaqueDeckUsuario;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Loja getLoja() {
        return loja;
    }

    public void setLoja(Loja loja) {
        this.loja = loja;
    }

    public Deck getDeck() {
        return deck;
    }

    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public List<Partida> getListPartida() {
        return listPartida;
    }

    public void setListPartida(List<Partida> listPartida) {
        this.listPartida = listPartida;
    }

    public List<UsuarioMoeda> getListUsuarioMoeda() {
        return listUsuarioMoeda;
    }

    public void setListUsuarioMoeda(List<UsuarioMoeda> listUsuarioMoeda) {
        this.listUsuarioMoeda = listUsuarioMoeda;
    }

    public List<UsuarioTransacao> getListUsuarioTransacao() {
        return listUsuarioTransacao;
    }

    public void setListUsuarioTransacao(List<UsuarioTransacao> listUsuarioTransacao) {
        this.listUsuarioTransacao = listUsuarioTransacao;
    }
    public List<PokemonPokedexAtaqueDeckUsuario> getListPokemonPokedexAtaqueDeckUsuario() {
        return listPokemonPokedexAtaqueDeckUsuario;
    }

    public void setListPokemonPokedexAtaqueDeckUsuario(List<PokemonPokedexAtaqueDeckUsuario> listPokemonPokedexAtaqueDeckUsuario) {
        this.listPokemonPokedexAtaqueDeckUsuario = listPokemonPokedexAtaqueDeckUsuario;
    }
    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", nivel='" + nivel + '\'' +
                ", loja=" + loja +
                ", deck=" + deck +
                ", listPartida=" + listPartida +
                ", listUsuarioMoeda=" + listUsuarioMoeda +
                ", listUsuarioTransacao=" + listUsuarioTransacao +
                ", listPokemonPokedexAtaqueDeckUsuario=" + listPokemonPokedexAtaqueDeckUsuario +
                '}';
    }
}