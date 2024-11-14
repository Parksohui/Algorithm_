import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _16390_ { // Sheba’s Amoebas
	static boolean arr[][];
	static int dx[] = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int dy[] = { 0, 0, -1, 1, -1, 1, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		arr = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			String str = bf.readLine();
			for (int j = 0; j < n; j++) {
				if (str.charAt(j) == '#') {
					arr[i][j] = true;
				}
			}
		}

		int result = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j]) {
					result += 1;
					bfs(i, j);
				}
			}
		}
		System.out.println(result);
	}

	private static void bfs(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { i, j });
		arr[i][j] = false;

		while (!queue.isEmpty()) {
			int temp[] = queue.poll();
			for (int k = 0; k < 8; k++) {
				int x = temp[0] + dx[k];
				int y = temp[1] + dy[k];
				if (x >= 0 && x < arr.length && y >= 0 && y < arr[0].length && arr[x][y]) {
					arr[x][y] = false;
					queue.add(new int[] { x, y });
				}
			}
		}
	}
}
