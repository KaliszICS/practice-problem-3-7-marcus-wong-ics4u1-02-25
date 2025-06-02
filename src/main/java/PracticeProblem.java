public class PracticeProblem {

	public static void main(String args[]) {

	}

	public static int searchMazeMoves(String[][] arr) {
		
		int col = 0;
		int row = arr.length - 1;
		int moves = 0;

		

		return mazeHelper(arr, col, row, moves);
	}

	public static int mazeHelper(String[][] arr, int col, int row, int moves) {
		
		if (row < 0 || col < 0 || row >= arr.length || col >= arr[0].length || arr[row][col].equals("*")) {
			return -1;
		}

		if (arr[row][col].equals("F")) {
			return moves;
		}

		String temp = arr[row][col];
		arr[row][col] = "*";

		int minMoves = -1;
		
		int up = mazeHelper(arr, col, row - 1, moves + 1);
		if (up != -1 && (minMoves == -1 || up < minMoves)) {
			minMoves = up;
		}

		int down = mazeHelper(arr, col, row + 1, moves + 1);
		if (down != -1 && (minMoves == -1 || down < minMoves)) {
			minMoves = down;
		}

		int left = mazeHelper(arr, col - 1, row, moves + 1);
		if (left != -1 && (minMoves ==  -1 || left < minMoves)) {
			minMoves = left;
			
		}

		int right = mazeHelper(arr, col + 1, row, moves + 1);
		if (right != -1 && (minMoves == -1 || right < minMoves)) {
			minMoves = right;
		}
		
		arr[row][col] = temp;
		return minMoves;
	} 
}