package apresentacao;

import persistencia.AtaqueDAO;

public class TesteAtaque {
    public static void main(String[] args) {

        // TESTE DE EXCLUIR
        AtaqueDAO aDAO = new AtaqueDAO();
        aDAO.excluir(1);
    }
}
