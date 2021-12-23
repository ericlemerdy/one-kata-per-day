package name.lemerdy.eric.tennis.model;

import static com.google.common.collect.Iterables.find;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;

import io.cucumber.java.PendingException;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Lorsque;
import io.cucumber.java.fr.Étantdonné;
import name.lemerdy.eric.tennis.model.TennisGameInitialization;

public class StepDef {
    private Set<String> players = new HashSet<String>();
    private TennisGameInitialization tennisGameInitialization;

    @Étantdonné("un joueur {string}")
    public void un_joueur(String playerName) {
        players.add(playerName);
    }

    @Étantdonné("{string} gagne le tirage au sort")
    public void gagne_le_tirage_au_sort(String playerName) {
        assertThat(playerName).isIn(players);
        tennisGameInitialization = new TennisGameInitialization(playerName, find(players, p -> !p.equals(playerName)));
    }

    @Lorsque("{string} choisit de servir ou recevoir dans le premier jeu de la partie")
    public void choisit_de_servir_ou_recevoir_dans_le_premier_jeu_de_la_partie(String winnerPlayerName) {
        assertThat(tennisGameInitialization.winner()).isEqualTo(winnerPlayerName);
        tennisGameInitialization.winnerChooseToServeOrReceive();
    }

    @Lorsque("{string} choisit le côté de terrain dans le premier jeu de la partie")
    public void choisit_le_côté_de_terrain_dans_le_premier_jeu_de_la_partie(String winnerPlayerName) {
        assertThat(tennisGameInitialization.winner()).isEqualTo(winnerPlayerName);
        tennisGameInitialization.winnerChooseTheFieldSize();
    }

    @Alors("{string} doit choisir le côté de terrain dans le premier jeu de la partie")
    public void doit_choisir_le_côté_de_terrain_dans_le_premier_jeu_de_la_partie(String looserPlayerName) {
        assertThat(tennisGameInitialization.looser()).isEqualTo(looserPlayerName);
        assertThat(tennisGameInitialization.looserMustChooseFieldSide()).isTrue();
    }

    @Alors("{string} doit choisir de servir ou recevoir dans le premier jeu de la partie")
    public void doit_choisir_de_servir_ou_recevoir_dans_le_premier_jeu_de_la_partie(String looserPlayerName) {
        assertThat(tennisGameInitialization.looser()).isEqualTo(looserPlayerName);
        assertThat(tennisGameInitialization.looserMustChooseToServerOrReceive()).isTrue();
    }

    @Lorsque("{string} choisit de donner le choix à son adversaire")
    public void choisit_de_donner_le_choix_à_son_adversaire(String arg1) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Alors("{string} doit faire un choix")
    public void doit_faire_un_choix(String arg1) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Lorsque("{string} choisit de {string} dans le premier jeu de la partie")
    public void choisit_de_dans_le_premier_jeu_de_la_partie(String arg1, String arg2) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Alors("{string} doit {string} dans le premier jeu de la partie")
    public void doit_dans_le_premier_jeu_de_la_partie(String arg1, String arg2) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Lorsque("{string} choisit le côté de terrain à {string} de l'arbitre dans le premier jeu de la partie")
    public void choisit_le_côté_de_terrain_à_de_l_arbitre_dans_le_premier_jeu_de_la_partie(String arg1, String arg2)
            {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Alors("{string} doit jouer sur le côté de terrain à {string} de l'arbitre dans le premier jeu de la partie")
    public void doit_jouer_sur_le_côté_de_terrain_à_de_l_arbitre_dans_le_premier_jeu_de_la_partie(String arg1,
            String arg2) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}