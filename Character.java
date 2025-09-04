/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

/**
 *
 * @author luke
 */

public abstract class Character {

    private final String name;
    private int health;
    private final int attackPower;
    private final int defense;

    public Character(String name, int health, int attackPower, int defense) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.defense = defense;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getDefense() {
        return defense;
    }

    /**
     * Reduce HP but never below zero (encapsulation).
     */
    public void takeDamage(int damage) {
        if (damage < 0) {
            damage = 0;
        }
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
    }

    /**
     * True while still in the fight.
     */
    public boolean isAlive() {
        return health > 0;
    }

    /**
     * Each subclass must define its special attack.
     */
    public abstract void specialAbility(Character opponent);
}
