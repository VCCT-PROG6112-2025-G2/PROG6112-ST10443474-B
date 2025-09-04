/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

/**
 *
 * @author luke
 */

public class GameApp {

    public static void main(String[] args) {
        Character[] players = new Character[]{
            new Warrior("Thabo"),
            new Mage("Aisha"),
            new Archer("Liam"),
            new Warrior("Naledi")
        };

        BattleArena arena = new BattleArena(players);
        arena.startBattles();
        String report = arena.buildReport();
        System.out.println(report);
    }
}
