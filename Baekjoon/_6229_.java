import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _6229_ { // Bronze Lilypad Pond
	static boolean arr[][];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int M1 = Integer.parseInt(st.nextToken());
		int M2 = Integer.parseInt(st.nextToken());

		arr = new boolean[M][N];
		int x1 = -1, x2 = -1, y1 = -1, y2 = -1;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (num == 0 || num == 2) {
					arr[i][j] = true;
				} else if (num == 3) {
					x1 = i;
					y1 = j;
				} else if (num == 4) {
					x2 = i;
					y2 = j;
				}
			}
		}
		System.out.println(bfs(M1, M2, x1, x2, y1, y2));
	}

	private static int bfs(int m1, int m2, int x1, int x2, int y1, int y2) {
		int dx[] = { -m1, -m1, m1, m1, -m2, -m2, m2, m2 };
		int dy[] = { -m2, m2, -m2, m2, -m1, m1, -m1, m1 };

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { x1, y1, 0 });
		arr[x1][y1] = true;
		int result = 0;

		while (!queue.isEmpty()) {
			int temp[] = queue.poll();
			for (int i = 0; i < 8; i++) {
				int x = temp[0] + dx[i];
				int y = temp[1] + dy[i];
				if (x >= 0 && x < arr.length && y >= 0 && y < arr[0].length && !arr[x][y]) {
					if (x == x2 && y == y2) {
						return temp[2] + 1;
					}
					arr[x][y] = true;
					queue.add(new int[] { x, y, temp[2] + 1 });
				}
			}
		}
		return result;
	}
}
