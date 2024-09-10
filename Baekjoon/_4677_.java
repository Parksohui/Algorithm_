import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _4677_ { // Oil Deposits
	static boolean visited[][];
	static int result;
	static int dx[] = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int dy[] = { 0, 0, -1, 1, -1, 1, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		while (a != 0 && b != 0) {
			visited = new boolean[a][b];
			result = 0;

			for (int i = 0; i < a; i++) {
				String str = bf.readLine();
				for (int j = 0; j < b; j++) {
					if (str.charAt(j) == '*') {
						visited[i][j] = true;
					}
				}
			}

			for (int i = 0; i < a; i++) {
				for (int j = 0; j < b; j++) {
					if (!visited[i][j]) {
						result += 1;
						visited[i][j] = true;
						bfs(i, j);
					}
				}
			}
			bw.write(result + "\n");
			st = new StringTokenizer(bf.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
		}
		bw.flush();
	}

	private static void bfs(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { i, j });

		while (!queue.isEmpty()) {
			int temp[] = queue.poll();
			for (int k = 0; k < 8; k++) {
				int a = temp[0] + dx[k];
				int b = temp[1] + dy[k];
				if (a >= 0 && a < visited.length && b >= 0 && b < visited[0].length && !visited[a][b]) {
					visited[a][b] = true;
					queue.add(new int[] { a, b });
				}
			}
		}

	}

}
