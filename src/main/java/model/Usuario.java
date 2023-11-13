package model;

public class Usuario {
    private long id;
    private String nome;
    private String email;
    private String senha;
    private String nivel;
    private Loja loja;
    private Deck deck;

    public Usuario() {
        super();
        id = 0;
        nome = "";
        email = "";
        senha = "";
        nivel = "";
        loja = new Loja();
        deck = new Deck();
    }
    public Usuario(long id, String nome, String email, String senha, String nivel, Loja loja, Deck deck) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.nivel = nivel;
        this.loja = loja;
        this.deck = deck;
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
                '}';
    }
}


