import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _6189_ { // Munching
	static int R, C;
	static boolean arr[][];
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = new boolean[R][C];

		int x = -1, y = -1, x2 = -1, y2 = -1;
		for (int i = 0; i < R; i++) {
			String str = bf.readLine();
			for (int j = 0; j < C; j++) {
				if (str.charAt(j) == '*') {
					arr[i][j] = true;
				} else if (str.charAt(j) == 'C') {
					x = i;
					y = j;
				} else if (str.charAt(j) == 'B') {
					x2 = i;
					y2 = j;
				}
			}
		}

		System.out.println(bfs(x, y, x2, y2));
	}

	private static int bfs(int x, int y, int x2, int y2) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { x, y, 1 });
		arr[x][y] = true;

		while (!queue.isEmpty()) {
			int temp[] = queue.poll();
			for (int i = 0; i < 4; i++) {
				int a = temp[0] + dx[i];
				int b = temp[1] + dy[i];
				if (a >= 0 && a < R && b >= 0 && b < C && !arr[a][b]) {
					if (a == x2 && b == y2) {
						return temp[2];
					}
					arr[a][b] = true;
					queue.add(new int[] { a, b, temp[2] + 1 });
				}
			}
		}
		return -1;
	}
}
