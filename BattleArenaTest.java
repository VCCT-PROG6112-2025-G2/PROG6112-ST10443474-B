/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

/**
 *
 * @author Luke
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BattleArenaTest {

    private BattleArena arena;
    private Character[] players;

    @BeforeEach
    public void setUp() {
        players = new Character[]{
            new Warrior("TesterWarrior"),
            new Mage("TesterMage")
        };
        arena = new BattleArena(players);
    }

    @Test
    public void specialAbilityReducesHealth() {
        Character w = players[0];
        Character m = players[1];
        int before = m.getHealth();
        w.specialAbility(m);
        assertTrue(m.getHealth() < before, "Mage health should drop after Warrior attack");
    }

    @Test
    public void fightProducesAWinner() {
        int winnerIdx = arena.fight(0, 1);
        assertTrue(winnerIdx == 0 || winnerIdx == 1, "Winner must be one of the two fighters");
        assertTrue(players[winnerIdx].isAlive(), "Winner must be alive");
    }

    @Test
    public void statsUpdateAfterFight() {
        arena.fight(0, 1);
        int[][] stats = arena.getStatsCopy();
        int wins = stats[0][0] + stats[1][0];
        int losses = stats[0][1] + stats[1][1];
        assertEquals(1, wins, "Exactly one win expected after one fight");
        assertEquals(1, losses, "Exactly one loss expected after one fight");
    }
}
