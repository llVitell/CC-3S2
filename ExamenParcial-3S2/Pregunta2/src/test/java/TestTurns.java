import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestTurns {

    private TicTacToe game;

    @BeforeEach
    public void setUp() throws Exception {
        game = new TicTacToe();
        game.makeMove(1, 1);
    }

    // Requisito 2: Agregar soporte para 2 jugadores

    // Prueba - X juega primero
    @Test
    public void testFirstTurn() {
        game.makeMove(0, 0);
        assertEquals(game.getTurn(), 'X');
        // Retorna X por que es el primero en jugar
    }

    // Prueba - O juega justo después de X
    @Test
    public void testSecondTurn() {
        game.makeMove(0, 0);
        game.makeMove(1, 0);
        assertEquals(game.getTurn(), 'O');
        // Retorna O por que es el segundo en jugar
    }

    // Prueba - X juega justo después de O
    @Test
    public void testThirdTurn() {
        game.makeMove(0, 0);
        game.makeMove(1, 0);
        game.makeMove(2, 0);
        assertEquals(game.getTurn(), 'X');
        // Retorna X por que es el tercero en jugar
    }
}