import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _5931_ { // Cow Beauty Pageant
	static int result[][], answer;
	static boolean visited[][];
	static Queue<int[]> position;
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		visited = new boolean[n][m];
		result = new int[n][m];
		int startX = -1, startY = -1;
		for (int i = 0; i < n; i++) {
			String str = bf.readLine();
			for (int j = 0; j < m; j++) {
				if (str.charAt(j) == 'X') {
					visited[i][j] = true;
				}
				if (visited[i][j] && startX == -1 && startY == -1) {
					startX = i;
					startY = j;
				}
				result[i][j] = -1;
			}
		}

		position = new LinkedList<>();
		findSpot(startX, startY);

		answer = Integer.MAX_VALUE;
		bfs();

		System.out.println(answer);

	}

	private static void bfs() {
		while (!position.isEmpty()) {
			int temp[] = position.poll();

			for (int i = 0; i < 4; i++) {
				int x = temp[0] + dx[i];
				int y = temp[1] + dy[i];
				if (x >= 0 && x < result.length && y >= 0 && y < result[0].length
						&& (result[x][y] == -1 || result[temp[0]][temp[1]] + 1 < result[x][y])) {
					if (result[temp[0]][temp[1]] > 0 && visited[x][y]) {
						answer = Math.min(answer, result[temp[0]][temp[1]]);
						break;
					}
					result[x][y] = result[temp[0]][temp[1]] + 1;
					position.add(new int[] { x, y });
				}
			}
		}
	}

	private static void findSpot(int startX, int startY) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { startX, startY });
		position.add(new int[] { startX, startY });
		visited[startX][startY] = false;
		result[startX][startY] = 0;

		while (!queue.isEmpty()) {
			int temp[] = queue.poll();
			for (int i = 0; i < 4; i++) {
				int x = temp[0] + dx[i];
				int y = temp[1] + dy[i];
				if (x >= 0 && x < visited.length && y >= 0 && y < visited[0].length && visited[x][y]) {
					visited[x][y] = false;
					result[x][y] = 0;
					queue.add(new int[] { x, y });
					position.add(new int[] { x, y });
				}
			}
		}
	}
}
