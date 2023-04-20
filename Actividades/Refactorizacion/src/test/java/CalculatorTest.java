import Calculator.Calculadora;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private static Calculadora calculadora;

    @BeforeAll
public static void init(){
	calculadora = new Calculadora();
}

    @Test
    public void whenCalculatorInitializedThenReturnTrue() {
        Calculadora calculadora = new Calculadora();

        assertTrue(calculadora.getStatus());
    }

    @Test
public void whenAdditionTwoNumberThenReturnCorrectAnswer() {
	Calculadora calculadora = new Calculadora();
   	 
	assertEquals( 5, calculadora.addition(2,3));
}

    // Requisito 3:
    // La calculadora debe tener función de división.
    @Test
public void whenDivisionThenReturnCorrectAnswer() {
	assertEquals(2, calculadora.division(8, 4));
}

    // Excepcion cuando alguien divide por cero
    @Test
public void whenDivisionByZeroThenThrowException() {
	Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
    	calculadora.division(5, 0);
	});
	assertEquals("No se puede divisor por  cero", exception.getMessage());
}

}
