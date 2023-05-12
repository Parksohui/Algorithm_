import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1261_ { // 알고스팟
	static int arr[][], m, n, result;
	static int visited[][];

	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		visited = new int[n][m];
		result=0;

		for (int i = 0; i < n; i++) {
			String s = bf.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = s.charAt(j)-'0';
				visited[i][j] = -1;
			}
		}
		bfs();
		System.out.println(result);
	}

	private static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { 0, 0 });
		visited[0][0] = 0;
		boolean flag = false;

		while (!queue.isEmpty()) {
			int temp[] = queue.poll();
			for (int i = 0; i < 4; i++) {
				int x = temp[0] + dx[i];
				int y = temp[1] + dy[i];
				if (x >= 0 && x < n && y >= 0 && y < m) {
					if (arr[x][y] == 0 && (visited[x][y]==-1 ||visited[x][y]>visited[temp[0]][temp[1]])) {
						flag = true;
						visited[x][y] = visited[temp[0]][temp[1]];
					} else {
						if (visited[x][y] == -1 || visited[temp[0]][temp[1]] + 1 < visited[x][y]) {
							visited[x][y] = visited[temp[0]][temp[1]] + 1;
							flag = true;
						}
					}
					if (flag) {
						queue.add(new int[] { x, y });
						flag=false;
					}
				}
			}
		}
		result=visited[n-1][m-1];

	}
}
