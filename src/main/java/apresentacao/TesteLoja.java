package apresentacao;

import model.Loja;
import persistencia.LojaDAO;

public class TesteLoja {
    public static void main(String[] args) {
        // TESTE DO SALVAR
        Loja l = new Loja();
        l.setPokemon("Pikachu");
        l.setPreco("140pokecoins");

        LojaDAO lDAO = new LojaDAO();
		l = lDAO.salvar(l);
		System.out.println(l.toString());

        //		TESTE DO EXCLUIR
//        Loja lDAO = new Loja();
//		lDAO.excluir(1);
    }
}
