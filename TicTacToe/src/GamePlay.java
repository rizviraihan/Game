import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GamePlay {

	static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
	static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();

	public static void main(String[] args) {

		char[][] board = { { ' ', '|', ' ', '|', ' ' }, { '-', '+', '-', '+', '-' }, { ' ', '|', ' ', '|', ' ' },
				{ '-', '+', '-', '+', '-' }, { ' ', '|', ' ', '|', ' ' } };

		// 00 02 04
		// 20 22 24
		// 40 42 44

		boardUi(board);
		playerInput(board);

	}

	public static void boardUi(char[][] board) {
		for (char[] row : board) {

			for (char column : row) {
				System.out.print(column);
			}

			System.out.println();
		}
	}

	public static void playerInput(char[][] board) {

		Scanner scan;
		while (true) {

			// take input from human // only take integers (1-9)
			scan = new Scanner(System.in);
			System.out.println("Enter your choice (1-9):");

			if (scan.hasNextInt()) {
				int playerPosition = scan.nextInt();

				if (playerPositions.contains(playerPosition) || cpuPositions.contains(playerPosition)) {
					System.out.println("This position is taken, please try again");
					continue;
				}

				if (playerPosition > 9 || playerPosition == 0) {
					System.out.println("Please enter between 1-9..");
					continue;
				}

				placeInput(board, playerPosition, "player");

				String result = checkResult();
				if (result.length() > 0) {
					System.out.println();
					boardUi(board);
					System.out.println(result);
					break;
				}
			} else {
				System.out.println("Only integer (1-9) is accepted..");
				continue;
			}

			Random rand = new Random();
			int cpuPosition = rand.nextInt(9) + 1;
			while (playerPositions.contains(cpuPosition) || cpuPositions.contains(cpuPosition)) {
				// System.out.println("This position is taken, please try again");
				cpuPosition = rand.nextInt(9) + 1;
			}

			placeInput(board, cpuPosition, "cpu");
			boardUi(board);

			String result = checkResult();
			if (result.length() > 0) {
				System.out.println();
				System.out.println(result);
				break;
			}

		}
		scan.close();

	}

	public static void placeInput(char[][] board, int pos, String user) {

		char symbol = ' ';

		if (user.equals("player")) {
			symbol = 'X';
			playerPositions.add(pos);
		} else if (user.equals("cpu")) {
			symbol = 'O';
			cpuPositions.add(pos);
		}

		switch (pos) {
		case 1:
			board[0][0] = symbol;
			break;
		case 2:
			board[0][2] = symbol;
			break;
		case 3:
			board[0][4] = symbol;
			break;
		case 4:
			board[2][0] = symbol;
			break;
		case 5:
			board[2][2] = symbol;
			break;
		case 6:
			board[2][4] = symbol;
			break;
		case 7:
			board[4][0] = symbol;
			break;
		case 8:
			board[4][2] = symbol;
			break;
		case 9:
			board[4][4] = symbol;
			break;
		default:
			break;
		}

	}

	public static String checkResult() {

		List<Integer> topRow = Arrays.asList(1, 2, 3);
		List<Integer> middleRow = Arrays.asList(4, 5, 6);
		List<Integer> bottomRow = Arrays.asList(7, 8, 9);

		List<Integer> leftColumn = Arrays.asList(1, 4, 7);
		List<Integer> middleColumn = Arrays.asList(2, 5, 8);
		List<Integer> rightColumn = Arrays.asList(3, 6, 9);

		List<Integer> diagonalOne = Arrays.asList(1, 5, 9);
		List<Integer> diagonalTwo = Arrays.asList(7, 5, 3);

		List<List<Integer>> winPatternList = new ArrayList<List<Integer>>();

		winPatternList.add(topRow);
		winPatternList.add(middleRow);
		winPatternList.add(bottomRow);

		winPatternList.add(leftColumn);
		winPatternList.add(middleColumn);
		winPatternList.add(rightColumn);

		winPatternList.add(diagonalOne);
		winPatternList.add(diagonalTwo);

		for (List<Integer> patternList : winPatternList) {
			if (playerPositions.containsAll(patternList)) {
				return "You won.";
			} else if (cpuPositions.containsAll(patternList)) {
				return "CPU won.";
			}
		}

		if (playerPositions.size() + cpuPositions.size() == 9) {
			return "Match Tie.";
		}

		return "";
	}

}
