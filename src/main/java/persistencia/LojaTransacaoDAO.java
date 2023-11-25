package persistencia;

import model.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LojaTransacaoDAO {
    private ConexaoMysql conexao;

    public LojaTransacaoDAO() {
        this.conexao = new ConexaoMysql("root", "lucasgremio", "localhost", "3306", "pokemonbd");
    }

    public LojaTransacao salvar(LojaTransacao lojaTransacao) {
        this.conexao.abrirConexao();
        String sql = "INSERT INTO loja_transacao VALUES(null, ?, ?)";
        try {
            PreparedStatement statement = conexao.getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setLong(1, lojaTransacao.getLoja().getId());
            statement.setLong(2, lojaTransacao.getTransacao().getId());
            int linhasAfetadas = statement.executeUpdate();
            if (linhasAfetadas > 0) {
                ResultSet rs = statement.getGeneratedKeys();
                if(rs.next()) {
                    // SE ENTRAR AQUI � PQ RETORNOU UMA CHAVE GERADA NO BD
                    lojaTransacao.setId(rs.getLong(1));
                }
                // OBJETIVO � PEGAR O ID GERADO NO BANCO
            }
            // JA TEM ID NO BANCO
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
        return lojaTransacao;
    }

    public void editar(LojaTransacao lojaTransacao) {
        this.conexao.abrirConexao();
        String sql = "UPDATE loja_transacao SET id_loja = ?, id_transacao = ? WHERE id_loja_transacao = ?";
        try {
            PreparedStatement statement = conexao.getConexao().prepareStatement(sql);
            statement.setLong(1, lojaTransacao.getLoja().getId());
            statement.setLong(2, lojaTransacao.getTransacao().getId());
            statement.setLong(3, lojaTransacao.getId());
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
        String sql = "DELETE FROM loja_transacao WHERE id_loja_transacao = ?";
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
    public LojaTransacao buscarPorId(long id) {
        LojaTransacao lojaTransacao = null;
        this.conexao.abrirConexao();
        String sql = "SELECT * FROM loja_transacao WHERE id_loja_transacao = ?";
        PreparedStatement statement;
        try {
            statement = conexao.getConexao().prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();

            // PRECISAMOS CONVERTER UM RESULTSET EM UM OBJETO USUARIO
            if (rs.next()) {
                // ENTRA APENAS SE O SELECT RETORNOU ALGO
                lojaTransacao = new LojaTransacao();
                lojaTransacao.setId(rs.getLong("id_loja_transacao"));
                LojaDAO lojaDAO = new LojaDAO();
                Loja loja = lojaDAO.buscarPorId(rs.getLong("id_loja"));
                lojaTransacao.setLoja(loja);
                TransacaoDAO transacaoDAO = new TransacaoDAO();
                Transacao transacao = transacaoDAO.buscarPorId(rs.getLong("id_transacao"));
                lojaTransacao.setTransacao(transacao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
        return lojaTransacao;
    }

    public List<LojaTransacao> buscarTodos() {
        List<LojaTransacao> listaLojaTransacao= new ArrayList<>();
        LojaTransacao lojaTransacao = null;
        this.conexao.abrirConexao();
        String sql = "SELECT * FROM loja_transacao";
        PreparedStatement statement;
        try {
            statement = conexao.getConexao().prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            // PRECISAMOS CONVERTER UM RESULTSET EM UM OBJETO USUARIO
            while(rs.next()) {
                // ENTRA APENAS SE O SELECT RETORNOU ALGO
                lojaTransacao = new LojaTransacao();
                lojaTransacao.setId(rs.getLong("id_loja_transacao"));
                LojaDAO lojaDAO = new LojaDAO();
                Loja loja = lojaDAO.buscarPorId(rs.getLong("id_loja"));
                lojaTransacao.setLoja(loja);
                TransacaoDAO transacaoDAO = new TransacaoDAO();
                Transacao transacao = transacaoDAO.buscarPorId(rs.getLong("id_transacao"));
                lojaTransacao.setTransacao(transacao);
                // ADICIONAMOS O USUARIO NA LISTA
                listaLojaTransacao.add(lojaTransacao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.conexao.fecharConexao();
        }
        return listaLojaTransacao;
    }
}