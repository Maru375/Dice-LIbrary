package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import main.Dice;
import main.DiceCalculator;

@TestInstance(Lifecycle.PER_CLASS)
public class DiceJunitTest {

    private Dice first;
    private Dice second;

    @BeforeEach
    void setUp() {
        first = new Dice(6);
        second = new Dice(2);
    }

    @Test
    @DisplayName("addDice 성공")

    void addDice() {
        DiceCalculator.addDice(first, second);
        assertEquals(DiceCalculator.addDice(first, second), 8);
    }

    @Test
    @DisplayName("subDice 성공")

    void subDice() {
        DiceCalculator.subDice(first, second);
        assertEquals(DiceCalculator.subDice(first, second), 4);
    }

    @Test
    @DisplayName("mulDice 성공")

    void mulDice() {
        DiceCalculator.mulDice(first, second);
        assertEquals(DiceCalculator.mulDice(first, second), 12);
    }

    @Test
    @DisplayName("divDice 성공")

    void divDice() {
        DiceCalculator.divDice(first, second);
        assertEquals(DiceCalculator.divDice(first, second), 4);
    }

    @Test
    @DisplayName("음수값 -> 에러 던짐")

    void negativeDice_throwIllegalArgumentException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Dice(-1));
        assertEquals(exception.getMessage(), "1 미만 또는 6 초과 주사위는 생성할 수 없습니다.");
    }

    @AfterAll
    void done() {
        System.out.println("done");
    }
}
