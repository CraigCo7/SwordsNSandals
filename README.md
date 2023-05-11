# SwordsNSandals

A simple CLI-based Java game. Fight for your freedom as a gladiator!

# Setup

1. cd into the 'SwordsNSandals' directory
2. 'javac SwordsNSandals.java'

# Running

1. 'java SwordsNSandals.java'
2. Enjoy the game!

# Game

## Gameplay

## Attributes

### Player Attributes

### Item Attributes

## Items

### Weapons

### Armor

// To Do:

1. In Player.java Storage class, edit the function below to make sure it can compare objects. (add equals functions for objects)

   public void removeItem(Equipment equipment) {
   if (items.contains(equipment)) {
   System.out.println("Cannot have 2 of the same item.");
   } else {
   items.add(equipment);
   }
   }

2. Add description to items.
3. Problem with typing 0 when leaving the equip items menu.
4. ValidEntry in input class prints extra /
