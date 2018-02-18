import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TheMaze {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int numRows = Integer.parseInt(br.readLine());
		String ithRow = br.readLine();
		int numCols = ithRow.length();

		char maze[][] = new char[numRows][numCols];
		char cellType;
		int beginX = 0, beginY = 0;

		for (int j = 0; j < numCols; j++) {
			cellType = ithRow.charAt(j);
			maze[0][j] = cellType;
			if (cellType == 'S')
				beginY = j;
		}

		for (int i = 1; i < numRows; i++) {
			ithRow = br.readLine();
			for (int j = 0; j < numCols; j++) {
				cellType = ithRow.charAt(j);
				maze[i][j] = cellType;
				if (cellType == 'S') {
					beginX = i;
					beginY = j;
				}

			}

		}

		printPath(beginX, beginY, maze, "");

		br.close();

	}

	public static void printPath(int x, int y, char[][] maze, String command) {

		if (maze[x][y] == 'F') {
			System.out.println(command);
			return;
		}

		maze[x][y] = '@';

		if (x > 0 && maze[x - 1][y] != '@')
			printPath(x - 1, y, maze, command + "U");

		if (x < maze.length - 1 && maze[x + 1][y] != '@')
			printPath(x + 1, y, maze, command + "D");

		if (y > 0 && maze[x][y - 1] != '@')
			printPath(x, y - 1, maze, command + "L");

		if (y < maze[0].length - 1 && maze[x][y + 1] != '@')
			printPath(x, y + 1, maze, command + "R");

	}
}
