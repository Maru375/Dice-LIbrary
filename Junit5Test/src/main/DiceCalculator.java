package main;
public class DiceCalculator {

    public static int addDice(Dice first, Dice second) {
        return first.getNumber() + second.getNumber();
    }

    public static int mulDice(Dice first, Dice second) {
        return first.getNumber() * second.getNumber();
    }

    public static int subDice(Dice first, Dice second) {
        return first.getNumber() - second.getNumber();
    }

    public static int divDice(Dice first, Dice second) {
        return first.getNumber() - second.getNumber();
    }

    public static boolean isOdd(Dice dice) {
        return dice.getNumber() % 2 != 0;
    }
    
    public static boolean isEven(Dice dice) {
        return dice.getNumber() % 2 == 0;
    }
}
