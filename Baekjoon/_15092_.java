import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _15092_ { // Sheba’s Amoebas
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
				if (str.charAt(j) == '.') {
					arr[i][j] = true;
				}
			}
		}

		int result = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!arr[i][j]) {
					result += 1;
					bfs(i, j);
				}
			}
		}
		System.out.println(result);
	}

	private static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { x, y });
		arr[x][y] = true;

		while (!queue.isEmpty()) {
			int temp[] = queue.poll();
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					int a = temp[0] + dx[i];
					int b = temp[1] + dy[i];
					if (a >= 0 && a < arr.length && b >= 0 && b < arr[0].length && !arr[a][b]) {
						arr[a][b] = true;
						queue.add(new int[] { a, b });
					}
				}
			}
		}
	}
}
