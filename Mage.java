/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

/**
 *
 * @author luke
 */

public class Mage extends Character {

    public Mage(String name) {
        super(name, 80, 25, 5);
    }

    @Override
    public void specialAbility(Character opponent) {
        int damage = getAttackPower() + 15;
        if (damage < 1) {
            damage = 1;
        }
        opponent.takeDamage(damage);
        System.out.println(getName() + " casts FIREBALL on " + opponent.getName()
                + " for " + damage + " damage!");
    }
}
