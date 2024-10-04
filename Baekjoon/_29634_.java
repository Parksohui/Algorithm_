import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _29634_ { // Hotel
	static boolean arr[][];
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		arr = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			String str = bf.readLine();
			for (int j = 0; j < m; j++) {
				if (str.charAt(j) == '*') {
					arr[i][j] = true;
				}
			}
		}

		int answer = -1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!arr[i][j]) {
					answer = Math.max(answer, bfs(i, j));
				}
			}
		}
		System.out.println(answer);
	}

	private static int bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { x, y });
		arr[x][y] = true;
		int cnt = 1;

		while (!queue.isEmpty()) {
			int temp[] = queue.poll();
			for (int i = 0; i < 4; i++) {
				int a = temp[0] + dx[i];
				int b = temp[1] + dy[i];
				if (a >= 0 && a < arr.length && b >= 0 && b < arr[0].length && !arr[a][b]) {
					cnt += 1;
					arr[a][b] = true;
					queue.add(new int[] { a, b });
				}
			}
		}
		return cnt;
	}
}
