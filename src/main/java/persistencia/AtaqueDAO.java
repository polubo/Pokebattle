package persistencia;

import model.Ataque;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AtaqueDAO {
    private ConexaoMysql conexao;

    public AtaqueDAO() {
        this.conexao = new ConexaoMysql("root", "lucasgremio", "localhost", "3306", "pokemonbd");
    }

    public Ataque salvar(Ataque ataque) {
        this.conexao.abrirConexao();
        String sql = "INSERT INTO ataque VALUES(null, ?, ?)";
        try {
            PreparedStatement statement = conexao.getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, ataque.getNome());
            statement.setString(2, ataque.getDano());
            int linhasAfetadas = statement.executeUpdate();
            if (linhasAfetadas > 0) {
                ResultSet rs = statement.getGeneratedKeys();
                if(rs.next()) {
                    // SE ENTRAR AQUI � PQ RETORNOU UMA CHAVE GERADA NO BD
                    ataque.setId(rs.getLong(1));
                }
                // OBJETIVO � PEGAR O ID GERADO NO BANCO
            }
            // JA TEM ID NO BANCO
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
        return ataque;
    }

    public void editar(Ataque ataque) {
        this.conexao.abrirConexao();
        String sql = "UPDATE ataque SET nome = ?, dano = ? WHERE id_ataque = ?";
        try {
            PreparedStatement statement = conexao.getConexao().prepareStatement(sql);
            statement.setString(1, ataque.getNome());
            statement.setString(2, ataque.getDano());
            statement.setLong(3, ataque.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
    }

    // DELETE FROM usuario WHERE id_usuario = ?
    public void excluir(long id) {
        this.conexao.abrirConexao();
        String sql = "DELETE FROM ataque WHERE id_ataque = ?";
        try {
            PreparedStatement statement = conexao.getConexao().prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
    }

    // BUSCAR UM USUARIO PELO ID
    public Ataque buscarPorId(long id) {
        Ataque ataque = null;
        this.conexao.abrirConexao();
        String sql = "SELECT * FROM ataque WHERE id_ataque = ?";
        PreparedStatement statement;
        try {
            statement = conexao.getConexao().prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();

            // PRECISAMOS CONVERTER UM RESULTSET EM UM OBJETO USUARIO
            if (rs.next()) {
                // ENTRA APENAS SE O SELECT RETORNOU ALGO
                ataque = new Ataque();
                ataque.setId(rs.getLong("id_ataque"));
                ataque.setNome(rs.getString("nome"));
                ataque.setDano(rs.getString("dano"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
        return ataque;
    }

    public List<Ataque> buscarTodos() {
        List<Ataque> listaAtaque= new ArrayList<>();
        Ataque ataque = null;
        this.conexao.abrirConexao();
        String sql = "SELECT * FROM ataque";
        PreparedStatement statement;
        try {
            statement = conexao.getConexao().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            // PRECISAMOS CONVERTER UM RESULTSET EM UM OBJETO USUARIO
            while(rs.next()) {
                // ENTRA APENAS SE O SELECT RETORNOU ALGO
                ataque = new Ataque();
                ataque.setId(rs.getLong("id_ataque"));
                ataque.setNome(rs.getString("nome"));
                ataque.setDano(rs.getString("dano"));
                // ADICIONAMOS O USUARIO NA LISTA
                listaAtaque.add(ataque);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
        return listaAtaque;
    }
}