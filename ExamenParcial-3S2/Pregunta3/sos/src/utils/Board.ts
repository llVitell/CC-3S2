export class Board {
  private readonly rows: number;
  private readonly columns: number;
  private readonly grid: string[][];

  private gameMode: boolean = true;

  constructor(rows: number, columns: number, gameMode: boolean) {
    this.rows = rows;
    this.columns = columns;
    this.gameMode = gameMode;
    this.grid = new Array(rows);
    for (let i = 0; i < rows; i++) {
      this.grid[i] = new Array(columns).fill("");
    }
  }

  public getGrid(): string[][] {
    return this.grid;
  }

  public getRows(): number {
    return this.rows;
  }

  public getColumns(): number {
    return this.columns;
  }

  public getGameMode(): boolean {
    return this.gameMode;
  }

  public getCellValue(row: number, column: number): string {
    if (row < 0 || row >= this.rows || column < 0 || column >= this.columns) {
      throw new Error("Cell position out of bounds.");
    }
    return this.grid[row][column];
  }

  public setCellValue(row: number, column: number, value: string): void {
    if (row < 0 || row >= this.rows || column < 0 || column >= this.columns) {
      throw new Error("Cell position out of bounds.");
    }
    if (this.grid[row][column] !== "") {
      throw new Error("Cell already occupied.");
    }
    this.grid[row][column] = value;
  }
}
