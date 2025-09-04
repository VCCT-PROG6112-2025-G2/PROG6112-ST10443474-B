# PROG6112-ST10443474-B

# ⚔Battle Arena Game

A Java-based battle simulation game where different character types fight in an arena.  
Each character has unique stats and a special ability, and battles are run automatically to determine a champion.  
The project also includes JUnit 5 tests to validate battle mechanics.

---

## Project Structure
src/
└── game/
├── Archer.java # Archer character class
├── BattleArena.java # Runs battles, tracks stats, generates report
├── BattleArenaTest.java # JUnit 5 tests for the arena
├── Character.java # Abstract base class for all characters
├── GameApp.java # Main app entry point
├── Mage.java # Mage character class
├── Warrior.java # Warrior character class

---

## Class Overview

### `Character.java`
- Abstract base class for all fighters.
- Fields: `name`, `health`, `attackPower`, `defense`.
- Methods:  
  - `takeDamage(int damage)` (reduces HP, never below 0)  
  - `isAlive()` (checks if still fighting)  
  - `specialAbility(Character opponent)` (abstract, implemented by subclasses)  

---

### `Warrior.java`
- High health and defense fighter.  
- **Special ability:** *Power Strike* → `(attackPower * 2) - opponentDefense` damage.  

### `Mage.java`
- Glass cannon with high attack but low health.  
- **Special ability:** *Fireball* → `(attackPower + 15)` fixed damage.  

### `Archer.java`
- Balanced fighter with critical damage potential.  
- **Special ability:** *Critical Arrow* → `attackPower + random(0..9)` damage.  

---

### `BattleArena.java`
- Runs and manages fights between characters.  
- Tracks stats for each player:
  - Wins
  - Losses
  - Total damage dealt  
- Methods:
  - `startBattles()` → Runs sequential fights.  
  - `fight(int a, int b)` → Simulates one fight, returns winner index.  
  - `getStatsCopy()` → Returns a copy of the stats array.  
  - `buildReport()` → Builds a formatted tournament report.  

---

### `GameApp.java`
- The **entry point** of the program.  
- Creates characters and starts a tournament:  
  ```java
  Character[] players = {
      new Warrior("Thabo"),
      new Mage("Aisha"),
      new Archer("Liam"),
      new Warrior("Naledi")
  };
  BattleArena arena = new BattleArena(players);
  arena.startBattles();
  System.out.println(arena.buildReport());

---

## BattleArenaTest.java
- Unit tests for battle mechanics using JUnit 5.
- Validates:
  - Special abilities reduce opponent health.
  - Each fight produces a winner.
  - Stats (wins/losses) update correctly after fights.
 
---

## How to Run
- Open the project in NetBeans or any Java IDE.
- Compile and run GameApp.java.
- Battles will run automatically and a tournament report will be displayed in the console.

---

## How to Test
- Ensure JUnit 5 is included in your project libraries.
- Run BattleArenaTest.java.
- All tests should pass if the battle logic works correctly.
