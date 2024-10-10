import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _9781_ { // Knight Moves
	static boolean arr[][];
	static int dx[] = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int dy[] = { -2, -1, 1, 2, 2, 1, -1, -2 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		arr = new boolean[n][m];
		int x1 = -1, y1 = -1, x2 = -1, y2 = -1;
		for (int i = 0; i < n; i++) {
			String str = bf.readLine();
			for (int j = 0; j < m; j++) {
				if (str.charAt(j) == '#') {
					arr[i][j] = true;
				} else if (str.charAt(j) == 'K') {
					x1 = i;
					y1 = j;
				} else if (str.charAt(j) == 'X') {
					x2 = i;
					y2 = j;
				}
			}
		}
		System.out.println(bfs(x1, y1, x2, y2));
	}

	private static int bfs(int x1, int y1, int x2, int y2) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { x1, y1, 0 });
		arr[x1][y1] = true;

		while (!queue.isEmpty()) {
			int temp[] = queue.poll();
			for (int i = 0; i < 8; i++) {
				int a = temp[0] + dx[i];
				int b = temp[1] + dy[i];
				if (a >= 0 && a < arr.length && b >= 0 && b < arr[0].length && !arr[a][b]) {
					if (a == x2 && b == y2) {
						return temp[2] + 1;
					}
					arr[a][b] = true;
					queue.add(new int[] { a, b, temp[2] + 1 });
				}
			}
		}
		return -1;
	}
}
