import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _18404_ { // 현명한 나이트
	static boolean visited[][];
	static int arr[][], result[], n, cnt;
	static int dx[] = { -2, -2, -1, -1, 1, 1, 2, 2 };
	static int dy[] = { -1, 1, -2, 2, -2, 2, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		visited = new boolean[n][n];
		cnt = 0;

		st = new StringTokenizer(bf.readLine());
		int x = Integer.parseInt(st.nextToken()) - 1;
		int y = Integer.parseInt(st.nextToken()) - 1;

		arr = new int[m][2];
		result = new int[m];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			arr[i][0] = a;
			arr[i][1] = b;
		}

		bfs(x, y);

		for (int i = 0; i < m; i++) {
			bw.write(result[i] + " ");
		}
		bw.flush();
	}

	private static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { x, y, 0 });
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			int temp[] = queue.poll();
			for (int i = 0; i < 8; i++) {
				int a = temp[0] + dx[i];
				int b = temp[1] + dy[i];
				if (a >= 0 && a < n && b >= 0 && b < n && !visited[a][b]) {
					visited[a][b] = true;
					for (int j = 0; j < arr.length; j++) {
						if (a == arr[j][0] && b == arr[j][1]) {
							result[j] = temp[2] + 1;
							cnt += 1;
							break;
						}
					}
					queue.add(new int[] { a, b, temp[2] + 1 });
				}
				if (cnt == result.length)
					break;
			}
			if (cnt == result.length)
				break;
		}
	}
}
