package apresentacao;

import model.Deck;
import persistencia.DeckDAO;

public class TesteDeck {
    public static void main(String[] args) {
        // TESTE DO SALVAR
        Deck d = new Deck();
        d.setNome("deck tank");
        d.setPokemon("pikachu, bulbassauro, pidgey");

        DeckDAO dDAO = new DeckDAO();
        d = dDAO.salvar(d);
        System.out.println(d.toString());

        //		TESTE DO EXCLUIR
//        Loja lDAO = new Loja();
//		lDAO.excluir(1);

    }
}