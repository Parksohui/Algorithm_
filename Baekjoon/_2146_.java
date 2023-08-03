import java.io.*;
import java.util.*;

public class _2146_ { // 다리 만들기
	static int arr[][], n, result;
	static boolean visited[][];
	static Queue<int[]> land;
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		n = Integer.parseInt(bf.readLine());
		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visited = new boolean[n][n];
		land = new LinkedList<>();
		result = -1;

		int idx = 2;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 1) {
					arr[i][j] = idx;
					findLand(i, j, idx);
					bfs();
					init();
					idx += 1;
				}
			}
		}
		System.out.println(result);

	}

	private static void findLand(int i, int j, int idx) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { i, j });

		while (!queue.isEmpty()) {
			int temp[] = queue.poll();
			boolean flag = false;
			for (int k = 0; k < 4; k++) {
				int x = temp[0] + dx[k];
				int y = temp[1] + dy[k];
				if (x >= 0 && x < n && y >= 0 && y < n) {
					if (arr[x][y] == 1) {
						arr[x][y] = idx;
						queue.add(new int[] { x, y });
					} else if (arr[x][y] == 0 && !flag) {
						land.add(new int[] { temp[0], temp[1], arr[temp[0]][temp[1]], 0 });
						flag = true;
					}
				}
			}
		}
	}

	private static void bfs() {
		boolean flag = false;

		while (!land.isEmpty()) {
			int temp[] = land.poll();
			for (int i = 0; i < 4; i++) {
				int x = temp[0] + dx[i];
				int y = temp[1] + dy[i];
				if (x >= 0 && x < n && y >= 0 && y < n && !visited[x][y] && arr[x][y] != temp[2]) {
					if (arr[x][y] != 0) {
						if (result == -1 || result > temp[3]) {
							result = temp[3];
						}
						flag = true;
						break;

					}
					visited[x][y] = true;
					land.add(new int[] { x, y, temp[2], temp[3] + 1 });
				}
			}
			if (flag) {
				land.clear();
				break;
			}
		}
	}

	private static void init() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				visited[i][j] = false;
			}
		}
	}
}
