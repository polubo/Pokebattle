package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoMysql {
    private String login;
    private String senha;
    private String ip;
    private String porta;
    private String nomeBd;
    private Connection conexao;

    public ConexaoMysql() {
        super();
    }

    public ConexaoMysql(String login, String senha, String ip, String porta, String nomeBd) {
        super();
        this.login = login;
        this.senha = senha;
        this.ip = ip;
        this.porta = porta;
        this.nomeBd = nomeBd;
    }

    public Connection getConexao() {
        return conexao;
    }

    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }

    public void abrirConexao() {
        String url = "jdbc:mysql://" + ip + ":" + porta + "/" + nomeBd;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conexao = DriverManager.getConnection(url, login, senha);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void fecharConexao() {
        try {
            if (this.conexao != null && !this.conexao.isClosed()) {
                this.conexao.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}