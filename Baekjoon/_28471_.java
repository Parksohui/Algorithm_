import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _28471_ { // W키가 빠진 성원이
	static int dx[] = { -1, 0, 0, -1, 1, -1, 1 };
	static int dy[] = { 0, -1, 1, 1, 1, -1, -1 };
	static int n;
	static boolean visited[][];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(bf.readLine());

		char arr[][] = new char[n][n];
		visited = new boolean[n][n];
		int x = 0, y = 0;

		for (int i = 0; i < n; i++) {
			String str = bf.readLine();
			for (int j = 0; j < n; j++) {
				arr[i][j] = str.charAt(j);
				if (arr[i][j] == 'F') {
					x = i;
					y = j;
					visited[x][y] = true;
				} else if (arr[i][j] == '#') {
					visited[i][j] = true;
				}
			}
		}

		System.out.println(bfs(x, y));
	}

	private static int bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { x, y });
		int cnt = 0;

		while (!queue.isEmpty()) {
			int temp[] = queue.poll();
			for (int i = 0; i < 7; i++) {
				int a = temp[0] + dx[i];
				int b = temp[1] + dy[i];

				if (a >= 0 && a < n && b >= 0 && b < n) {
					if (!visited[a][b]) {
						cnt += 1;
						visited[a][b] = true;
						queue.add(new int[] { a, b });
					}
				}
			}
		}
		return cnt;
	}
}
