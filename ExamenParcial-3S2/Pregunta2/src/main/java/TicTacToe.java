public class TicTacToe {
    private static final int BOARD_ROWS = 3;
    private static final int BOARD_COLUMNS = 3;

    public enum Cell {
        EMPTY, CROSS, NOUGHT
    }

    private Cell[][] grid;
    private char currentTurn;

    public enum GameState {
        PLAYING, DRAW, CROSS_WON, NOUGHT_WON
    }

    private GameState currentGameState;

    public TicTacToe() {
        grid = new Cell[BOARD_ROWS][BOARD_COLUMNS];
        initGame();
    }

    private void initGame() {
        for (int row = 0; row < BOARD_ROWS; ++row) {
            for (int col = 0; col < BOARD_COLUMNS; ++col) {
                grid[row][col] = Cell.EMPTY;
            }
        }
        currentGameState = GameState.PLAYING;
        currentTurn = 'X';
    }

    public void resetGame() {
        initGame();
    }

    public int getTotalRows() {
        return BOARD_ROWS;
    }

    public int getTotalColumns() {
        return BOARD_COLUMNS;
    }

    public Cell getCell(int row, int column) {
        if (row >= 0 && row < BOARD_ROWS && column >= 0 && column < BOARD_COLUMNS) {
            return grid[row][column];
        } else {
            return null;
        }
    }

    public char getTurn() {
        return currentTurn;
    }

    public void makeMove(int row, int column) {
        if (row >= 0 && row < BOARD_ROWS && column >= 0 && column < BOARD_COLUMNS && grid[row][column] == Cell.EMPTY) {
            grid[row][column] = (currentTurn == 'X') ? Cell.CROSS : Cell.NOUGHT;
            updateGameState(currentTurn, row, column);
            currentTurn = (currentTurn == 'X') ? 'O' : 'X';
        }
    }

    private void updateGameState(char turn, int row, int column) {
        if (hasWon(turn, row, column)) {
            currentGameState = (turn == 'X') ? GameState.CROSS_WON : GameState.NOUGHT_WON;
        } else if (isDraw()) {
            currentGameState = GameState.DRAW;
        }
    }

    private boolean isDraw() {
        for (int row = 0; row < BOARD_ROWS; ++row) {
            for (int col = 0; col < BOARD_COLUMNS; ++col) {
                if (grid[row][col] == Cell.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean hasWon(char turn, int row, int column) {
        Cell token = (turn == 'X') ? Cell.CROSS : Cell.NOUGHT;
        return (grid[row][0] == token
                && grid[row][1] == token && grid[row][2] == token
                || grid[0][column] == token
                && grid[1][column] == token && grid[2][column] == token
                || row == column
                && grid[0][0] == token && grid[1][1] == token && grid[2][2] == token
                || row + column == 2
                && grid[0][2] == token && grid[1][1] == token && grid[2][0] == token);
    }

    public GameState getGameState() {
        return currentGameState;
    }
}