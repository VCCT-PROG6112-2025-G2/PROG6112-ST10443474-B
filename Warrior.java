/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

/**
 *
 * @author luke
 */

public class Warrior extends Character {

    public Warrior(String name) {
        super(name, 120, 20, 10);
    }

    @Override
    public void specialAbility(Character opponent) {
        int damage = (getAttackPower() * 2) - opponent.getDefense();
        if (damage < 1) {
            damage = 1;
        }
        opponent.takeDamage(damage);
        System.out.println(getName() + " uses POWER STRIKE on " + opponent.getName()
                + " for " + damage + " damage!");
    }
}
