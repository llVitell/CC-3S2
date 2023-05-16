export class Score {
  
  private score: number;

  constructor() {
    this.score = 0;
  }

  public getScore(): number {
    return this.score;
  }

  public updateScore(result: string): void {
    if (result !== 'S' && result !== 'O' && result !== 'SS' && result !== 'OO') {
      throw new Error('Invalid result provided.');
    }
    if (result === 'S' || result === 'O') {
      this.score++;
    } else if (result === 'SS' || result === 'OO') {
      this.score += 2;
    }
  }

}