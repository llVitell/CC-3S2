import { Player } from "../../utils/Player";
import { Board } from "../../utils/Board";
import { Game } from "../../utils/Game";

describe("Score", () => {
    let game: Game;
    let board: Board;
    let players: Player[];
    let rows: number = 3;
    let columns: number = 3;
  
    beforeEach(() => {
      board = new Board(rows,columns,true);
      players = [
        new Player("Red"),
        new Player("Blue")
      ];
      game = new Game(board, players);
    });
  describe("Requisito 3: Agregar condiciones ganadoras", () => {
    test("Prueba por defecto no hay ganador", () => {
        expect(() => game.getWinner()).toThrow("Draw");
    });

    test("Prueba condición ganadora I", () => {
        players[0].makeMove(board,0,0,"S");
        players[0].makeMove(board,0,1,"O");
        players[0].makeMove(board,0,2,"S");
        expect(game.getWinner()).toBe("Red");
    });
    
    test("Prueba condición ganadora II", () => {
      
    });
    test("Prueba condición ganadora III", () => {
      const board = new Board(3, 3, true);
      
    });
    test("Prueba condición ganadora IV", () => {
      const board = new Board(3, 3, true);
      
    });
    test("Prueba manejo de una situación de empate", () => {
      const board = new Board(3, 3, true);
        
    });
  });
});
