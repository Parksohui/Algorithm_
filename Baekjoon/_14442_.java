import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _14442_ { // 벽 부수고 이동하기 2
	static int arr[][], n, m, k;
	static boolean visited[][][];

	static class Pair {
		int x, y, d, w;

		public Pair(int x, int y, int d, int w) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.w = w;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		visited = new boolean[k + 1][n][m];

		for (int i = 0; i < n; i++) {
			String str = bf.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}

		if (n == 1 && m == 1) {
			System.out.println(1);
		} else {
			System.out.println(bfs());
		}

	}

	private static int bfs() {
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(0, 0, 1, 0));
		visited[0][0][0] = true;

		int dx[] = { -1, 1, 0, 0 };
		int dy[] = { 0, 0, -1, 1 };

		while (!queue.isEmpty()) {
			Pair pair = queue.poll();
			for (int i = 0; i < 4; i++) {
				int x = pair.x + dx[i];
				int y = pair.y + dy[i];
				if (x >= 0 && x < n && y >= 0 && y < m) {
					if (arr[x][y] == 0 && !visited[pair.w][x][y]) {
						if (x == n - 1 && y == m - 1) {
							return pair.d + 1;
						}
						visited[pair.w][x][y] = true;
						queue.add(new Pair(x, y, pair.d + 1, pair.w));
					} else if (arr[x][y] == 1 && pair.w + 1 <= k && !visited[pair.w + 1][x][y]) {
						if (x == n - 1 && y == m - 1) {
							return pair.d + 1;
						}
						visited[pair.w + 1][x][y] = true;
						queue.add(new Pair(x, y, pair.d + 1, pair.w + 1));
					}
				}
			}
		}
		return -1;
	}
}
