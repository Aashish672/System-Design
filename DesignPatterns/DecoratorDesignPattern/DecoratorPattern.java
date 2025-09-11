package DesignPatterns.DecoratorDesignPattern;

//Componenet Interface: defines a common interface for Mario and all power-up decorators
interface Character {
    String getAbilities();
}

// Concrete component : Basic Mario character with no power ups
class Mario implements Character {
    @Override
    public String getAbilities() {
        return "Mario";
    }
}

// Abstract Decorator: CharacterDecorator "is-a" Character and "has-a"
abstract class CharacterDecorator implements Character {
    protected Character character;

    public CharacterDecorator(Character c) {
        this.character = c;
    }
}

// Concrete Decorator: Height-Increasing Power-Up
class HeightUp extends CharacterDecorator {
    public HeightUp(Character c) {
        super(c);
    }

    public String getAbilities() {
        return character.getAbilities() + "with HeightUp";
    }
}
// Concrete Decorator: Gun Shooting Power-Up

class GunPowerUp extends CharacterDecorator {
    public GunPowerUp(Character c) {
        super(c);
    }

    public String getAbilities() {
        return character.getAbilities() + "with Gun";
    }
}

// Concrete Decorator: Start Power Up(temporary ability)
class StarPowerUp extends CharacterDecorator {
    public StarPowerUp(Character c) {
        super(c);
    }

    public String getAbilities() {
        return character.getAbilities() + "with Start Power (Limited Time)";
    }
}

public class DecoratorPattern {
    public static void main(String[] args) {
        // Create a basic Mario Character
        Character mario = new Mario();
        System.out.println("Basic Character:" + mario.getAbilities());

        // Decorate Mario with a HeightUp power-up
        mario = new HeightUp(mario);
        System.out.println("After HeightUp: " + mario.getAbilities());

        // Decorate Mario further with a GunPowerUp
        mario = new GunPowerUp(mario);
        System.out.println("After GunPowerUp: " + mario.getAbilities());

        // Finally add a StarPowerUp decoration
        mario = new StarPowerUp(mario);
        System.out.println("After StarPowerUp: " + mario.getAbilities());
    }
}
