import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestBoardLimits {

    private TicTacToe game;
    @BeforeEach
    public void setUp() throws Exception {
        game = new TicTacToe();
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    // Requisito 1: Colocación de piezas

    // Prueba limites del tablero I
    @Test
    public void testInvalidRow() {
        game.makeMove(5, 2);
        assertEquals(game.getCell(5,2), null);
        // Retorna null por que no existe la fila
    }

    // Prueba limites del tablero II
    @Test
    public void testInvalidColumn() {
        game.makeMove(2, 5);
        assertEquals(game.getCell(2,5), null);
        // Retorna null por que no existe la columna
    }

    // Prueba lugar ocupado
    @Test
    public void testInvalidCell(){
        game.makeMove(1,1);
        assertEquals(game.getCell(1,1), TicTacToe.Cell.CROSS);
        // Retorna Cell por que ya la celda está ocupada
    }
}