import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class _19238_ { // 스타트 택시
	static int arr[][], n;
	static boolean visited[][];
	static int dx[] = { -1, 0, 0, 1 }; // 상좌우하
	static int dy[] = { 0, -1, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int fuel = Integer.parseInt(st.nextToken());

		arr = new int[n + 1][n + 1];
		visited = new boolean[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 1; j <= n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(bf.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());

		int idx = 2;
		HashMap<Integer, int[]> map = new HashMap<>();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());

			arr[startX][startY] = idx;
			map.put(idx++, new int[] { endX, endY });
		}

		while (fuel > 0) {
			init();
			int info[] = findCustomer(x, y);

			if (info[0] == -1 && info[1] == -1) {
				break;
			}

			arr[info[0]][info[1]] = 0;
			fuel -= info[3];
			if (fuel <= 0) {
				break;
			}

			init();
			info = taxi(info[0], info[1], map.get(info[2]));

			if (info[0] == -1 && info[1] == -1) {
				break;
			}

			fuel -= info[2];
			if (fuel < 0) {
				break;
			}
			fuel += (info[2] * 2);
			m -= 1;
			x = info[0];
			y = info[1];

			if (m == 0) {
				break;
			}

		}

		if (m > 0 || fuel <= 0) { // 모든 손님을 이동시킬 수 없거나 이동 도중에 연료가 바닥난 경우
			System.out.println(-1);
		} else { // 모든 손님을 이동시키고 연료를 충전했을 때 남은 연료의 양
			System.out.println(fuel);
		}

	}

	// 방문 배열 초기화
	private static void init() {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				visited[i][j] = false;
			}
		}

	}

	// 현재 위치에서 가장 가까운 손님 찾기
	private static int[] findCustomer(int x, int y) {
		if (arr[x][y] > 1) {
			return new int[] { x, y, arr[x][y], 0 };
		}

		Queue<int[]> queue = new LinkedList<>();
		PriorityQueue<int[]> pri = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[3] == o2[3]) {
					if (o1[0] == o2[0]) {
						return o1[1] - o2[1];
					}
					return o1[0] - o2[0];
				}
				return o1[3] - o2[3];
			}
		});
		queue.add(new int[] { x, y, 0 });
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			int info[] = queue.poll();
			for (int i = 0; i < 4; i++) {
				int a = info[0] + dx[i];
				int b = info[1] + dy[i];
				if (a > 0 && a <= n && b > 0 && b <= n && arr[a][b] != 1 && !visited[a][b]) {
					visited[a][b] = true;
					if (arr[a][b] > 1) {
						if (pri.size() == 0 || pri.peek()[3] >= info[2] + 1) {
							pri.add(new int[] { a, b, arr[a][b], info[2] + 1 });
						}
					}
					queue.add(new int[] { a, b, info[2] + 1 });
				}
			}
		}

		if (pri.isEmpty()) {
			return new int[] { -1, -1, -1, -1 };
		} else {
			return pri.poll();
		}
	}

	// 손님 출발지에서 목적지까지 이동
	private static int[] taxi(int x, int y, int[] find) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { x, y, 0 });
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			int info[] = queue.poll();
			for (int i = 0; i < 4; i++) {
				int a = info[0] + dx[i];
				int b = info[1] + dy[i];
				if (a > 0 && a <= n && b > 0 && b <= n && arr[a][b] != 1 && !visited[a][b]) {
					visited[a][b] = true;
					if (a == find[0] && b == find[1]) {
						return new int[] { a, b, info[2] + 1 };
					}
					queue.add(new int[] { a, b, info[2] + 1 });
				}
			}
		}
		return new int[] { -1, -1, -1 };
	}
}