import { Board } from "../../utils/Board";
import { Player } from "../../utils/Player";

describe("Board", () => {
  describe("Requisito 1: Colocación de piezas", () => {
    test("Prueba Límites del tablero I", () => {
      const rows = 3;
      const columns = 3;

      const board = new Board(rows, columns, true);
      const player1 = new Player("Red");

      expect(player1.makeMove(board,2,5,"S")).toBe("Cell position out of bonds");

      // Verificamos que cada fila del tablero tenga el tamaño correcto
      board.getGrid().forEach(row => expect(row).toHaveLength(columns));
    });

    test("Pruebas Límites del tablero II", () => {
      // Definimos el modo de juego para el tablero de prueba
      const gameMode = false; // false == modo de juego general

      // Creamos un nuevo tablero con el modo de juego especificado
      const board = new Board(3, 3, gameMode);

      // Verificamos que el tablero tenga el modo de juego especificado
      
      expect(board.getGameMode()).toBe(gameMode);
    });

    test("Prueba lugar ocupado",() => {

    });
  });
});