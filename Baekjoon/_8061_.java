import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _8061_ { // Bitmap
	static int result[][];
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		boolean arr[][] = new boolean[n][m];
		result = new int[n][m];

		for (int i = 0; i < n; i++) {
			String str = bf.readLine();
			for (int j = 0; j < m; j++) {
				if (str.charAt(j) - '0' == 0) {
					arr[i][j] = true;
					result[i][j] = Integer.MAX_VALUE;
				} 
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!arr[i][j]) {
					arr[i][j] = true;
					bfs(i, j);
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				bw.write(result[i][j] + " ");
			}
			bw.write("\n");
		}
		bw.flush();
	}

	private static void bfs(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { i, j });

		while (!queue.isEmpty()) {
			int temp[] = queue.poll();
			for (int k = 0; k < 4; k++) {
				int x = temp[0] + dx[k];
				int y = temp[1] + dy[k];
				if (x >= 0 && x < result.length && y >= 0 && y < result[0].length && result[x][y] != 0
						&& result[x][y] > result[temp[0]][temp[1]] + 1) {
					result[x][y] = result[temp[0]][temp[1]] + 1;
					queue.add(new int[] { x, y });
				}
			}
		}
	}
}
