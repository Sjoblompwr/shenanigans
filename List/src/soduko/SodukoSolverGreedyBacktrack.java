package soduko;

public class SodukoSolverGreedyBacktrack {

	public static void main(String[] args) {
		int[][] soduko = {
				{3,6,0,0,7,1,2,0,0},
				{0,5,0,0,0,0,1,8,0},
				{0,0,9,2,0,4,7,0,0},
				{0,0,0,0,1,3,0,2,8},
				{4,0,0,5,0,2,0,0,9},
				{2,7,0,4,6,0,0,0,0},
				{0,0,5,3,0,8,9,0,0},
				{0,8,3,0,0,0,0,6,0},
				{0,0,7,6,9,0,0,4,3},
		};
	}

	private static boolean vertical(int[] vertical, int indexToCheck) {
		for (int i = 0; i < 10; i++) {
			if (vertical[indexToCheck] == vertical[i] && indexToCheck != i) {
				return false;
			}

		}
		return true;
	}

	private static boolean horizontal(int[] horizontal, int indexToCheck) {
		for (int i = 0; i < 10; i++) {
			if (horizontal[indexToCheck] == horizontal[i] && indexToCheck != i) {
				return false;
			}

		}
		return true;
	}

	private static boolean box(int[] box, int indexToCheck) {
		int j = 0;
		for (int i = 0; i < 3; i++) {
			if (box[indexToCheck] == box[i + 3 * j] && indexToCheck != i + 3 * j) {
				return false;
			}
			j++;
		}
		return true;
	}
}
