import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1726_ { // 로봇
	static int arr[][], visited[][], m, n, x2, y2, dir2;
	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { 1, -1, 0, 0 };

	public static class Robot {
		int x, y, dir, depth;

		public Robot(int x, int y, int dir, int depth) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.depth = depth;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		arr = new int[m][n];
		visited = new int[m][n];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				visited[i][j] = -1;
			}
		}

		st = new StringTokenizer(bf.readLine());
		int x1 = Integer.parseInt(st.nextToken()) - 1;
		int y1 = Integer.parseInt(st.nextToken()) - 1;
		int dir1 = Integer.parseInt(st.nextToken()) - 1;

		st = new StringTokenizer(bf.readLine());
		x2 = Integer.parseInt(st.nextToken()) - 1;
		y2 = Integer.parseInt(st.nextToken()) - 1;
		dir2 = Integer.parseInt(st.nextToken()) - 1;

		int result = 0;

		if (x1 == x2 && y1 == y2) {
			result = dirCalc(dir2, dir1, 0);
		} else {
			result = bfs(x1, y1, dir1);
		}

		System.out.println(result);
	}

	private static int bfs(int a, int b, int dir) {
		Queue<Robot> queue = new LinkedList<>();
		queue.add(new Robot(a, b, dir, 0));
		visited[a][b] = 0;
		boolean flag = false;
		int cnt = -1;

		while (!queue.isEmpty()) {
			Robot robot = queue.poll();
			for (int i = 0; i < 4; i++) {
				flag = false;
				for (int j = 1; j <= 3; j++) {
					int x = robot.x + (dx[i] * j);
					int y = robot.y + (dy[i] * j);
					if (x >= 0 && x < m && y >= 0 && y < n && arr[x][y] == 0) {
						flag = true;
						int depth = dirCalc(robot.dir, i, robot.depth);
						Robot newRobot = new Robot(x, y, i, depth + 1);
						if (x == x2 && y == y2) {
							depth = dirCalc(dir2, i, depth) + 1;
							if (cnt == -1 || cnt > depth) {
								cnt = depth;
							}
						}
						if (visited[x][y] == -1 || visited[x][y] > newRobot.depth) {
							visited[x][y] = newRobot.depth;
							queue.add(newRobot);
						}
					} else {
						flag = false;
					}
					if (!flag)
						break;
				}
			}
		}
		return cnt;
	}

	public static int dirCalc(int x, int y, int depth) {
		if ((x == 2 && y == 3) || (x == 3 && y == 2) || (x == 1 && y == 0) || (x == 0 && y == 1)) {
			depth += 2;
		} else if (x != y) {
			depth += 1;
		}
		return depth;
	}

}
