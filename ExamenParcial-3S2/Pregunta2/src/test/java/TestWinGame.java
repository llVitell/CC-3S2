import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestWinGame {

    private TicTacToe game;
    @BeforeEach
    public void setUp() throws Exception {
        game = new TicTacToe();
    }

    @AfterEach
    public void tearDown() throws Exception {
    }

    // Requisito 3: Agregar condiciones ganadoras

    // Prueba por defecto no hay ganador
    @Test
    public void noWinner() {
        assertEquals(game.getGameState(), TicTacToe.GameState.PLAYING);
        // Retorna el estado "PLAYING" por que no hay ganador
    }

    // Prueba condición ganadora I
    @Test
    public void testXWonHorizontally() {
        game.makeMove(0, 0);
        game.makeMove(1, 2);
        game.makeMove(0, 1);
        game.makeMove(1, 1);
        game.makeMove(0, 2);
        assertEquals(game.getGameState(), TicTacToe.GameState.CROSS_WON);
        // Retorna el estado "CROSS_WON" por que X formó una linea de 3 horizontal
    }

    // Prueba condición ganadora II
    @Test
    public void testXWonVertically() {
        game.makeMove(0, 0);
        game.makeMove(0, 2);
        game.makeMove(1, 0);
        game.makeMove(1, 1);
        game.makeMove(2, 0);
        assertEquals(game.getGameState(), TicTacToe.GameState.CROSS_WON);
        // Retorna el estado "CROSS_WON" por que X formó una linea de 3 vertical
    }

    // Prueba condición ganadora III
    @Test
    public void testXWonDiagonally() {
        game.makeMove(0, 0);
        game.makeMove(0, 2);
        game.makeMove(1, 1);
        game.makeMove(1, 2);
        game.makeMove(2, 2);
        assertEquals(game.getGameState(), TicTacToe.GameState.CROSS_WON);
        /* Retorna el estado "CROSS_WON" por que X formó una linea diagonal desde
         la parte superior izquierda hasta la parte inferior derecha */
    }

    // Prueba condición ganadora IV
    @Test
    public void testXWonDiagonallyInverted() {
        game.makeMove(2, 0);
        game.makeMove(0, 1);
        game.makeMove(1, 1);
        game.makeMove(1, 2);
        game.makeMove(0, 2);
        assertEquals(game.getGameState(), TicTacToe.GameState.CROSS_WON);
        /* Retorna el estado "CROSS_WON" por que X formó una linea diagonal desde
         la parte inferior izquierda hasta la parte superior derecha */
    }

    // Requisito 4: condiciones de empate

    // Prueba manejo de una situación de empate
    @Test
    public void testDraw(){
        game.makeMove(0, 0);
        game.makeMove(0, 1);
        game.makeMove(1, 1);
        game.makeMove(1, 0);
        game.makeMove(1, 2);
        game.makeMove(0, 2);
        game.makeMove(2, 1);
        game.makeMove(2, 2);
        game.makeMove(2,0);
        assertEquals(game.getGameState(),TicTacToe.GameState.DRAW);
        // Retorna el estado de juego "DRAW" por que hubo un empate
    }
}