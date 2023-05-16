import { Board } from "./Board";
import { Player } from "./Player";

export class Game {

  private readonly player1: Player;
  private readonly player2: Player;
  private readonly board: Board;

  private currentPlayer: Player;

  constructor (player1: Player, player2: Player, rows: number, columns: number, gameMode: boolean) {
    this.player1 = player1;
    this.player2 = player2;
    this.board = new Board(rows, columns, gameMode);
    this.currentPlayer = this.player1;
  }

  public getBoard(): Board {
    return this.board;
  }

  public getPlayers(): Player[] {
    return [this.player1, this.player2];
  }

  public getCurrentPlayer(): Player {
    return this.currentPlayer;
  }

  public setCurrentPlayer(player: Player): void {
    this.currentPlayer = player;
  }

}