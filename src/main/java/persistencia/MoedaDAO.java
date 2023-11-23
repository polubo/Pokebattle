package persistencia;

import model.Moeda;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MoedaDAO {
    private ConexaoMysql conexao;

    public MoedaDAO() {
        this.conexao = new ConexaoMysql("root", "lucasgremio", "localhost", "3306", "pokemonbd");
    }

    public Moeda salvar(Moeda moeda) {
        this.conexao.abrirConexao();
        String sql = "INSERT INTO moeda VALUES(null, ?, ?)";
        try {
            PreparedStatement statement = conexao.getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setString(1, moeda.getNome());
            statement.setString(2, moeda.getValor());
            int linhasAfetadas = statement.executeUpdate();
            if (linhasAfetadas > 0) {
                ResultSet rs = statement.getGeneratedKeys();
                if(rs.next()) {
                    // SE ENTRAR AQUI � PQ RETORNOU UMA CHAVE GERADA NO BD
                    moeda.setId(rs.getLong(1));
                }
                // OBJETIVO � PEGAR O ID GERADO NO BANCO
            }
            // JA TEM ID NO BANCO
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
        return moeda;
    }

    public void editar(Moeda moeda) {
        this.conexao.abrirConexao();
        String sql = "UPDATE moeda SET nome_moeda = ?, valor_moeda = ? WHERE id_moeda = ?";
        try {
            PreparedStatement statement = conexao.getConexao().prepareStatement(sql);
            statement.setString(1, moeda.getNome());
            statement.setString(2, moeda.getValor());
            statement.setLong(3, moeda.getId());
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
        String sql = "DELETE FROM moeda WHERE id_moeda = ?";
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
    public Moeda buscarPorId(long id) {
        Moeda moeda = null;
        this.conexao.abrirConexao();
        String sql = "SELECT * FROM moeda WHERE id_moeda = ?";
        PreparedStatement statement;
        try {
            statement = conexao.getConexao().prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();

            // PRECISAMOS CONVERTER UM RESULTSET EM UM OBJETO USUARIO
            if (rs.next()) {
                // ENTRA APENAS SE O SELECT RETORNOU ALGO
                moeda = new Moeda();
                moeda.setId(rs.getLong("id_moeda"));
                moeda.setNome(rs.getString("nome_moeda"));
                moeda.setValor(rs.getString("valor_moeda"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
        return moeda;
    }

    public List<Moeda> buscarTodos() {
        List<Moeda> listaMoeda= new ArrayList<>();
        Moeda moeda = null;
        this.conexao.abrirConexao();
        String sql = "SELECT * FROM moeda";
        PreparedStatement statement;
        try {
            statement = conexao.getConexao().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            // PRECISAMOS CONVERTER UM RESULTSET EM UM OBJETO USUARIO
            while(rs.next()) {
                // ENTRA APENAS SE O SELECT RETORNOU ALGO
                moeda = new Moeda();
                moeda.setId(rs.getLong("id_moeda"));
                moeda.setNome(rs.getString("nome_valor"));
                moeda.setValor(rs.getString("valor_moeda"));
                // ADICIONAMOS O USUARIO NA LISTA
                listaMoeda.add(moeda);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
        return listaMoeda;
    }
}