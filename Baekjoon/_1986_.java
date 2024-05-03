import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1986_ { // 체스
	static int arr[][];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		Queue<int[]> queue = new LinkedList<>();

		st = new StringTokenizer(bf.readLine());
		int num = Integer.parseInt(st.nextToken());
		for (int i = 0; i < num; i++) {
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			queue.add(new int[] { x, y });
			arr[x][y] = 1;
		}

		st = new StringTokenizer(bf.readLine());
		num = Integer.parseInt(st.nextToken());
		for (int i = 0; i < num; i++) {
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			queue.add(new int[] { x, y });
			arr[x][y] = 2;
		}

		st = new StringTokenizer(bf.readLine());
		num = Integer.parseInt(st.nextToken());
		for (int i = 0; i < num; i++) {
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			arr[x][y] = 3;
		}

		move(queue);

		int result = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 0) {
					result += 1;
				}
			}
		}
		System.out.println(result);
	}

	private static void move(Queue<int[]> queue) {
		int dx1[] = { -1, -1, 0, 1, 1, 1, 0, -1 };
		int dy1[] = { 0, 1, 1, 1, 0, -1, -1, -1 };

		int dx2[] = { -2, -1, 1, 2, 2, 1, -1, -2 };
		int dy2[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

		while (!queue.isEmpty()) {
			int info[] = queue.poll();
			if (arr[info[0]][info[1]] == 1) {
				for (int i = 0; i < 8; i++) {
					int x = info[0], y = info[1];
					while (true) {
						x += dx1[i];
						y += dy1[i];
						if (x >= 0 && x < arr.length && y >= 0 && y < arr[0].length && (arr[x][y] == 0 || arr[x][y]==-1)) {
							arr[x][y] = -1;
						} else {
							break;
						}
					}
				}
			} else {
				for (int i = 0; i < 8; i++) {
					int x = info[0] + dx2[i];
					int y = info[1] + dy2[i];
					if (x >= 0 && x < arr.length && y >= 0 && y < arr[0].length && (arr[x][y] == 0 || arr[x][y]==-1)) {
						arr[x][y] = -1;
					}
				}
			}
		}
	}
}
