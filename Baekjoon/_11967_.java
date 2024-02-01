import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _11967_ { // 불켜기
	static boolean visited[][];
	static Room[][] arr;
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	static class Room {
		private boolean light;
		private ArrayList<int[]> link;

		public Room(Boolean light, ArrayList<int[]> link) {
			this.light = light;
			this.link = link;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		arr = new Room[n + 1][n + 1];
		visited = new boolean[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				arr[i][j] = new Room(false, new ArrayList<>());
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			arr[x][y].link.add(new int[] { a, b });
		}

		arr[1][1].light = true;
		visited[1][1] = true;

		System.out.println(bfs(1, 1));
	}

	private static int bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { x, y });

		int result = 1;

		while (!queue.isEmpty()) {
			int pos[] = queue.poll();

			for (int[] num : arr[pos[0]][pos[1]].link) {
				if (!arr[num[0]][num[1]].light) {
					result += 1;
					arr[num[0]][num[1]].light = true;

					for (int i = 0; i < 4; i++) {
						int a = num[0] + dx[i];
						int b = num[1] + dy[i];

						if (a >= 1 && a < arr.length && b >= 1 && b < arr.length && visited[a][b]) {
							visited[num[0]][num[1]] = true;
							queue.add(new int[] { num[0], num[1] });
							break;
						}
					}
				}
			}

			for (int i = 0; i < 4; i++) {
				int a = pos[0] + dx[i];
				int b = pos[1] + dy[i];

				if (a >= 1 && a < arr.length && b >= 1 && b < arr.length && arr[a][b].light && !visited[a][b]) {
					visited[a][b] = true;
					queue.add(new int[] { a, b });
				}
			}
		}
		return result;
	}
}
