import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _6186_ { // Best Grass
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };
	static boolean visited[][];
	static int r, c;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		visited = new boolean[r][c];
		for (int i = 0; i < r; i++) {
			String str = bf.readLine();
			for (int j = 0; j < c; j++) {
				if (str.charAt(j) == '.') {
					visited[i][j] = true;
				}
			}
		}

		int result = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (!visited[i][j]) {
					result += 1;
					bfs(i, j);
				}
			}
		}
		System.out.println(result);
	}

	private static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { x, y });

		while (!queue.isEmpty()) {
			int temp[] = queue.poll();

			for (int i = 0; i < 4; i++) {
				int a = temp[0] + dx[i];
				int b = temp[1] + dy[i];
				if (a >= 0 && a < r && b >= 0 && b < c && !visited[a][b]) {
					visited[a][b] = true;
					queue.add(new int[] { a, b });
				}
			}
		}
	}
}
