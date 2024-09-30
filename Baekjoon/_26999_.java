import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _26999_ { // Satellite Photographs
	static boolean arr[][];
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		arr = new boolean[H][W];
		for (int i = 0; i < H; i++) {
			String str = bf.readLine();
			for (int j = 0; j < W; j++) {
				if (str.charAt(j) == '.') {
					arr[i][j] = true;
				}
			}
		}

		int result = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (!arr[i][j]) {
					result = Math.max(bfs(i, j), result);
				}
			}
		}
		System.out.println(result);
	}

	private static int bfs(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { i, j });
		arr[i][j] = true;
		int cnt = 1;

		while (!queue.isEmpty()) {
			int temp[] = queue.poll();
			for (int k = 0; k < 4; k++) {
				int x = temp[0] + dx[k];
				int y = temp[1] + dy[k];
				if (x >= 0 && x < arr.length && y >= 0 && y < arr[0].length && !arr[x][y]) {
					cnt += 1;
					arr[x][y] = true;
					queue.add(new int[] { x, y });
				}
			}
		}
		return cnt;
	}
}
