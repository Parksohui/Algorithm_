import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _8598_ { // Zając
	static int dx[] = { 1, 1, -1, -1, 2, 2, -2, -2 };
	static int dy[] = { 2, -2, 2, -2, 1, -1, 1, -1 };
	static boolean arr[][];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		arr = new boolean[n][m];
		int x1 = -1, x2 = -1, y1 = -1, y2 = -1;
		for (int i = 0; i < n; i++) {
			String str = bf.readLine();
			for (int j = 0; j < m; j++) {
				if (str.charAt(j) == 'x') {
					arr[i][j] = true;
				} else if (str.charAt(j) == 'z') {
					x1 = i;
					y1 = j;
				} else if (str.charAt(j) == 'n') {
					x2 = i;
					y2 = j;
				}
			}
		}
		int result = bfs(x1, y1, x2, y2);
		if (result == -1) {
			System.out.println("NIE");
		} else {
			System.out.println(result);
		}
	}

	private static int bfs(int x1, int y1, int x2, int y2) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { x1, y1, 0 });
		arr[x1][y1] = true;

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
		return -1;
	}
}
