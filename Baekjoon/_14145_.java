import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class _14145_ { // Žetva
	static int arr[][], result[][];
	static boolean visited[][];
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			String str = bf.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}

		visited = new boolean[n][m];
		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 1 && !visited[i][j]) {
					visited[i][j] = true;
					queue.add(new int[] { findArea(i, j), i, j });
				}
			}
		}

		result = new int[n][m];
		int idx = 1;
		while (!queue.isEmpty()) {
			int temp[] = queue.poll();
			bfs(temp[1], temp[2], idx++);
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				bw.write(result[i][j] + "");
			}
			bw.write("\n");
		}
		bw.flush();
	}

	private static void bfs(int i, int j, int idx) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { i, j });

		visited[i][j] = false;
		result[i][j] = idx;

		while (!queue.isEmpty()) {
			int temp[] = queue.poll();
			for (int k = 0; k < 4; k++) {
				int x = temp[0] + dx[k];
				int y = temp[1] + dy[k];
				if (x >= 0 && x < visited.length && y >= 0 && y < visited[0].length && visited[x][y]
						&& arr[x][y] == 1) {
					visited[x][y] = false;
					result[x][y] = idx;
					queue.add(new int[] { x, y });
				}
			}
		}
	}

	private static int findArea(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { i, j });
		int cnt = 1;

		while (!queue.isEmpty()) {
			int temp[] = queue.poll();
			for (int k = 0; k < 4; k++) {
				int x = temp[0] + dx[k];
				int y = temp[1] + dy[k];
				if (x >= 0 && x < visited.length && y >= 0 && y < visited[0].length && !visited[x][y]
						&& arr[x][y] == 1) {
					visited[x][y] = true;
					cnt += 1;
					queue.add(new int[] { x, y });
				}
			}
		}
		return cnt;
	}
}
