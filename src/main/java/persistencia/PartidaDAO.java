package persistencia;

import model.Partida;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PartidaDAO {
    private ConexaoMysql conexao;

    public PartidaDAO() {
        this.conexao = new ConexaoMysql("root", "lucasgremio", "localhost", "3306", "pokemonbd");
    }

    public Partida salvar(Partida partida) {
        this.conexao.abrirConexao();
        String sql = "INSERT INTO partida VALUES(null, null, null ?, ?)";
        try {
            PreparedStatement statement = conexao.getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, partida.getResultado());
            statement.setString(2, partida.getRecompensa());
            int linhasAfetadas = statement.executeUpdate();
            if (linhasAfetadas > 0) {
                ResultSet rs = statement.getGeneratedKeys();
                if (rs.next()) {
                    // SE ENTRAR AQUI � PQ RETORNOU UMA CHAVE GERADA NO BD
                    partida.setId(rs.getLong(1));
                }
                // OBJETIVO � PEGAR O ID GERADO NO BANCO
            }
            // JA TEM ID NO BANCO
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
        return partida;
    }

    public void editar(Partida partida) {
        this.conexao.abrirConexao();
        String sql = "UPDATE partida SET resultado = ?, recompensa = ? WHERE id_partida = ?";
        try {
            PreparedStatement statement = conexao.getConexao().prepareStatement(sql);
            statement.setString(1, partida.getResultado());
            statement.setString(2, partida.getRecompensa());
            statement.setLong(3, partida.getId());
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
        String sql = "DELETE FROM partida WHERE id_partida = ?";
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
    public Partida buscarPorId(long id) {
        Partida partida = null;
        this.conexao.abrirConexao();
        String sql = "SELECT * FROM partida WHERE id_partida = ?";
        PreparedStatement statement;
        try {
            statement = conexao.getConexao().prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();

            // PRECISAMOS CONVERTER UM RESULTSET EM UM OBJETO USUARIO
            if (rs.next()) {
                // ENTRA APENAS SE O SELECT RETORNOU ALGO
                partida = new Partida();
                partida.setId(rs.getLong("id_partida"));
                partida.setResultado(rs.getString("resultado"));
                partida.setRecompensa(rs.getString("recompensa"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
        return partida;
    }

    public List<Partida> buscarTodos() {
        List<Partida> listaPartida = new ArrayList<>();
        Partida partida = null;
        this.conexao.abrirConexao();
        String sql = "SELECT * FROM partida";
        PreparedStatement statement;
        try {
            statement = conexao.getConexao().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            // PRECISAMOS CONVERTER UM RESULTSET EM UM OBJETO USUARIO
            while (rs.next()) {
                // ENTRA APENAS SE O SELECT RETORNOU ALGO
                partida = new Partida();
                partida.setId(rs.getLong("id_partida"));
                partida.setResultado(rs.getString("resultado"));
                partida.setRecompensa(rs.getString("recompensa"));
                // ADICIONAMOS O USUARIO NA LISTA
                listaPartida.add(partida);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
        return listaPartida;
    }
}