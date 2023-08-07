import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _11559_ { // Puyo Puyo
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };
	static char arr[][];
	static int cnt, result;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		arr = new char[12][6];
		boolean[][] visited = new boolean[12][6];
		boolean[][] check = new boolean[12][6];

		for (int i = 0; i < 12; i++) {
			String str = bf.readLine();
			for (int j = 0; j < 6; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		result = 0;
		boolean flag = false;

		while (true) {
			for (int i = 11; i >= 0; i--) {
				for (int j = 0; j < 6; j++) {
					if (arr[i][j] != '.' && !visited[i][j]) {
						bfs(i, j, arr[i][j], visited, check);
						if (cnt >= 4) {
							flag = true;
							boom(check);
						}
						init(check);
					}
				}
			}
			if (!flag) {
				break;
			} else {
				result += 1;
				flag = false;
			}
			
			init(visited);
			gravity();
		}
		System.out.println(result);
	}

	private static void gravity() {
		for (int i = 0; i < 6; i++) {
			int idx = -1;
			for (int j = 11; j >= 0; j--) {
				if (idx == -1 & arr[j][i] == '.') {
					idx = j;
				} else if (idx != -1 && arr[j][i] != '.') {
					arr[idx][i] = arr[j][i];
					arr[j][i] = '.';
					idx -= 1;
				}
			}
		}
	}

	private static void bfs(int i, int j, char color, boolean visited[][], boolean check[][]) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { i, j });
		visited[i][j] = true;
		check[i][j] = true;
		cnt = 1;

		while (!queue.isEmpty()) {
			int temp[] = queue.poll();
			for (int k = 0; k < 4; k++) {
				int x = temp[0] + dx[k];
				int y = temp[1] + dy[k];
				if (x >= 0 && x < 12 && y >= 0 && y < 6 && !visited[x][y] && arr[x][y] == color) {
					visited[x][y] = true;
					check[x][y] = true;
					queue.add(new int[] { x, y });
					cnt += 1;
				}
			}
		}
	}

	private static void boom(boolean[][] check) {
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 6; j++) {
				if (check[i][j]) {
					arr[i][j] = '.';
				}
			}
		}
	}

	private static void init(boolean[][] check) {
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 6; j++) {
				check[i][j] = false;
			}
		}
	}
}
