import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _6146_ { // 신아를 만나러
	static int arr[][], x, y;
	static boolean visited[][];
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		x = Integer.parseInt(st.nextToken()) + 500;
		y = Integer.parseInt(st.nextToken()) + 500;
		int n = Integer.parseInt(st.nextToken());

		arr = new int[1001][1001];
		visited = new boolean[1001][1001];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken()) + 500;
			int b = Integer.parseInt(st.nextToken()) + 500;

			visited[a][b] = true;
		}

		bfs();

	}

	private static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { 500, 500, 0 });

		while (!queue.isEmpty()) {
			int num[] = queue.poll();
			for (int i = 0; i < 4; i++) {
				int a = num[0] + dx[i];
				int b = num[1] + dy[i];
				if (Math.abs(a) <= 1001 && Math.abs(b) <= 1001 && !visited[a][b]) {
					visited[a][b] = true;
					if (a == x && b == y) {
						System.out.println(num[2] + 1);
						return;
					}
					queue.add(new int[] { a, b, num[2] + 1 });
				}
			}
		}
	}
}
