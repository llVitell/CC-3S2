import { Player } from "../../utils/Player";
import { Board } from "../../utils/Board";
import { Game } from "../../utils/Game";

describe("Player", () => {
  
  describe("makeMove", () => {
    /**
     * AC 4.1
     * CUANDO el jugador inicie un juego simple de SOS, se le debe mostrar un tablero vacío
     * y debe ser el turno del jugador 1 para hacer un movimiento.
     * ENTONCES, el jugador debe ser capaz de seleccionar una celda vacía en el tablero para colocar su letra S o O.
     */
    test("should start a simple SOS game with an empty board and player 1's turn", () => {

      // Definimos a los jugadores
      const player1 = new Player("Red");
      const player2 = new Player("Blue");

      // Definimos el tamaño de tablero y el modo de juego para el jugador
      const rows = 3;
      const columns = 3;
      const gameMode = true; // true == modo de juego SOS

      // Inicializamos el tablero
      const game = new Game(player1, player2, rows, columns, gameMode);

      // Obtenemos el tablero
      const board: Board = game.getBoard();

      // Verificamos que el tablero esté vacío
      for (let i = 0; i < rows; i++) {
        for (let j = 0; j < columns; j++) {
          expect(board.getCellValue(i, j)).toBe("");
        }
      }

      // Verificamos que sea el turno del jugador 1
      expect(game.getCurrentPlayer()).toBe(player1);

      // El jugador hace su movimiento en una celda vacía
      const moveResult = player1.makeMove(board, 0, 0, "S");
      expect(moveResult).toBe(true);
      expect(board.getCellValue(0, 0)).toBe("S");

      

      // Se cambia de turno
      game.setCurrentPlayer(player2);

      // Verificamos que ahora sea el turno del jugador 2
      expect(game.getCurrentPlayer()).toBe(player2);
    });
  });
});