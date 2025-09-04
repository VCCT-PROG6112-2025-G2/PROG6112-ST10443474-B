/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

/**
 *
 * @author luke
 */

import java.util.Arrays; 

/**
 * Runs battles between characters and produces a report.
 */
public class BattleArena {

    private final Character[] players;   // contestants
    // stats[playerIndex][0]=wins, [1]=losses, [2]=totalDamageDealt
    private final int[][] stats;

    public BattleArena(Character[] players) {
        this.players = players;
        this.stats = new int[players.length][3];
    }

    public int[][] getStatsCopy() {
        int[][] copy = new int[stats.length][];
        for (int i = 0; i < stats.length; i++) {
            copy[i] = Arrays.copyOf(stats[i], stats[i].length);
        }
        return copy;
    }

    public void startBattles() {
        System.out.println("\n=== BATTLE ARENA START ===");
        for (int i = 0; i < players.length - 1; i++) {
            fight(i, i + 1);
        }
        System.out.println("=== BATTLE ARENA ENDS ===\n");
    }

    public int fight(int a, int b) {
        Character p1 = players[a];
        Character p2 = players[b];

        System.out.println("\n--- " + p1.getName() + " VS " + p2.getName() + " ---");

        int round = 1;
        int p1Damage = 0, p2Damage = 0;
        final int MAX_ROUNDS = 20;

        while (p1.isAlive() && p2.isAlive() && round <= MAX_ROUNDS) {
            int before = p2.getHealth();
            p1.specialAbility(p2);
            p1Damage += Math.max(0, before - p2.getHealth());
            if (!p2.isAlive()) {
                break;
            }

            before = p1.getHealth();
            p2.specialAbility(p1);
            p2Damage += Math.max(0, before - p1.getHealth());

            round++;
        }

        int winnerIndex = p1.isAlive() ? a : b;
        int loserIndex = p1.isAlive() ? b : a;
        stats[winnerIndex][0]++;   // wins
        stats[loserIndex][1]++;    // losses
        stats[a][2] += p1Damage;
        stats[b][2] += p2Damage;

        Character winner = players[winnerIndex];
        Character loser = players[loserIndex];
        System.out.println("WINNER: " + winner.getName() + " with "
                + winner.getHealth() + " HP left.  (" + loser.getName() + " fell.)");

        return winnerIndex;
    }

    public String buildReport() {
        String[] columns = {"Wins", "Losses", "TotalDamage"};
        StringBuilder sb = new StringBuilder();
        sb.append("============== TOURNAMENT REPORT ==============\n");
        sb.append(String.format("%-15s %8s %8s %14s%n", "Player", columns[0], columns[1], columns[2]));
        sb.append("------------------------------------------------------------\n");

        int bestIdx = 0;
        for (int i = 0; i < players.length; i++) {
            sb.append(String.format("%-15s %8d %8d %14d%n",
                    players[i].getName(), stats[i][0], stats[i][1], stats[i][2]));
            if (stats[i][0] > stats[bestIdx][0]) {
                bestIdx = i;
            }
        }
        sb.append("------------------------------------------------------------\n");
        sb.append("CHAMPION: ").append(players[bestIdx].getName())
                .append(" (").append(stats[bestIdx][0]).append(" wins)\n");
        sb.append("============================================================\n");
        return sb.toString();
    }
}
