import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _6031_ { // Feeding Time
	static boolean arr[][];
	static int result;
	static int dx[] = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int dy[] = { 0, 0, -1, 1, -1, 1, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());

		arr = new boolean[h][w];
		for (int i = 0; i < h; i++) {
			String str = bf.readLine();
			for (int j = 0; j < w; j++) {
				if (str.charAt(j) == '*') {
					arr[i][j] = true;
				}
			}
		}

		result = 0;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (!arr[i][j]) {
					arr[i][j] = true;
					bfs(i, j);
				}

			}
		}
		System.out.println(result);
	}

	private static void bfs(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { i, j });

		int cnt = 1;
		while (!queue.isEmpty()) {
			int temp[] = queue.poll();
			for (int k = 0; k < 8; k++) {
				int x = temp[0] + dx[k];
				int y = temp[1] + dy[k];
				if (x >= 0 && x < arr.length && y >= 0 && y < arr[0].length && !arr[x][y]) {
					arr[x][y] = true;
					cnt += 1;
					queue.add(new int[] { x, y });
				}
			}
		}
		result = Math.max(result, cnt);
	}
}
