import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class _6832_ { // Maze
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };
	static char arr[][];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine());
		for (int i = 0; i < t; i++) {
			int r = Integer.parseInt(bf.readLine());
			int c = Integer.parseInt(bf.readLine());

			arr = new char[r][c];
			for (int j = 0; j < r; j++) {
				String str = bf.readLine();
				for (int k = 0; k < c; k++) {
					arr[j][k] = str.charAt(k);
				}
			}
			if (r == 1 && c == 1 && arr[0][0]!='*') {
				bw.write("1\n");
			} else {
				bw.write(bfs() + "\n");
			}
		}
		bw.flush();
	}

	private static int bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { 0, 0, 1 });

		boolean visited[][] = new boolean[arr.length][arr[0].length];
		visited[0][0] = true;

		while (!queue.isEmpty()) {
			int temp[] = queue.poll();

			if (arr[temp[0]][temp[1]] == '+') {
				for (int k = 0; k < 4; k++) {
					int x = temp[0] + dx[k];
					int y = temp[1] + dy[k];
					if (x >= 0 && x < arr.length && y >= 0 && y < arr[0].length && arr[x][y] != '*' && !visited[x][y]) {
						if (x == arr.length - 1 && y == arr[0].length - 1) {
							return temp[2] + 1;
						}
						visited[x][y] = true;
						queue.add(new int[] { x, y, temp[2] + 1 });
					}
				}
			} else if (arr[temp[0]][temp[1]] == '-') {
				for (int k = 2; k < 4; k++) {
					int x = temp[0] + dx[k];
					int y = temp[1] + dy[k];
					if (x >= 0 && x < arr.length && y >= 0 && y < arr[0].length && arr[x][y] != '*' && !visited[x][y]) {
						if (x == arr.length - 1 && y == arr[0].length - 1) {
							return temp[2] + 1;
						}
						visited[x][y] = true;
						queue.add(new int[] { x, y, temp[2] + 1 });
					}
				}
			} else if (arr[temp[0]][temp[1]] == '|') {
				for (int k = 0; k < 2; k++) {
					int x = temp[0] + dx[k];
					int y = temp[1] + dy[k];
					if (x >= 0 && x < arr.length && y >= 0 && y < arr[0].length && arr[x][y] != '*' && !visited[x][y]) {
						if (x == arr.length - 1 && y == arr[0].length - 1) {
							return temp[2] + 1;
						}
						visited[x][y] = true;
						queue.add(new int[] { x, y, temp[2] + 1 });
					}
				}

			}
		}
		return -1;
	}
}
