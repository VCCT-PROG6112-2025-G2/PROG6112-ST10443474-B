/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package game;

/**
 *
 * @author luke
 */

public class Archer extends Character {

    public Archer(String name) {
        super(name, 100, 18, 7);
    }

    @Override
    public void specialAbility(Character opponent) {
        int crit = (int) (Math.random() * 10); // 0..9
        int damage = getAttackPower() + crit;
        opponent.takeDamage(damage);
        System.out.println(getName() + " fires CRITICAL ARROW at " + opponent.getName()
                + " for " + damage + " damage!");
    }
}
