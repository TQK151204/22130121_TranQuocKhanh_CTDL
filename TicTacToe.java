package Lab_5;

public class TicTacToe {
	private static final char EMPTY = ' ';
	private char[][] board;

	public boolean checkRows() {
		for (int row = 0; row < 3; row++) {
			char firstCell = board[row][0];
			if (firstCell != EMPTY && board[row][1] == firstCell && board[row][2] == firstCell) {
				return true;
			}
		}
		return false;
	}

	public boolean checkDiagonals() {
		char topLeftCell = board[0][0];
		if (topLeftCell != EMPTY && board[1][1] == topLeftCell && board[2][2] == topLeftCell) {
			return true;
		}
		char bottomLeftCell = board[2][0];
		if (bottomLeftCell != EMPTY && board[1][1] == bottomLeftCell && board[0][2] == bottomLeftCell) {
			return true;
		}

		return false;

	}
	 public boolean checkRows2() {
	        int n = board.length; // Get the size of the board (n x n)

	        for (int row = 0; row < n; row++) {
	            char firstCell = board[row][0];
	            if (firstCell != EMPTY) {
	                boolean isWinningRow = true;
	                for (int col = 1; col < n; col++) {
	                    if (board[row][col] != firstCell) {
	                        isWinningRow = false;
	                        break;
	                    }
	                }
	                if (isWinningRow) {
	                    return true;
	                }
	            }
	        }

	        return false;
	    }

	    public boolean checkDiagonals2() {
	        int n = board.length; // Get the size of the board (n x n)

	        char topLeftCell = board[0][0];
	        char bottomLeftCell = board[n - 1][0];

	        if (topLeftCell != EMPTY) {
	            boolean isWinningDiagonal1 = true;
	            boolean isWinningDiagonal2 = true;

	            for (int i = 1; i < n; i++) {
	                if (board[i][i] != topLeftCell) {
	                    isWinningDiagonal1 = false;
	                }
	                if (board[i][n - 1 - i] != bottomLeftCell) {
	                    isWinningDiagonal2 = false;
	                }
	            }

	            if (isWinningDiagonal1 || isWinningDiagonal2) {
	                return true;
	            }
	        }

	        return false;
	    }

	public static void main(String[] args) {
		
		TicTacToe game = new TicTacToe();
		char[][] board = { { 'X', 'O', 'X' }, { 'O', 'X', 'O' }, { 'X', 'O', 'X' } };

		game.board = board;

		boolean hasWinningRow = game.checkRows();
		System.out.println("Win row: " + hasWinningRow); 

		boolean hasWinningDiagonal = game.checkDiagonals();
		System.out.println("Win diagonal: " + hasWinningDiagonal); 
		
		boolean hasWinningRow2 = game.checkRows2();
		System.out.println("Win row: " + hasWinningRow2); 

		boolean hasWinningDiagonal2 = game.checkDiagonals2();
		System.out.println("Win diagonal: " + hasWinningDiagonal2); 
		
	}
	

}
