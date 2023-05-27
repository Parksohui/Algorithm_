import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _16509_ { // 장군
	static int dx[] = { -1, 0, 1, 0 }; // 상 우 하 좌
	static int dy[] = { 0, 1, 0, -1 };
	static int dx2[] = { -1, -1, -1, 1, 1, 1, 1, -1 }; // 대각선
	static int dy2[] = { -1, 1, 1, 1, 1, -1, -1, -1 };
	static int r2, c2, result;
	static boolean visited[][];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		visited = new boolean[10][9];
		result = -1;

		// 상의 위치
		int r1 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());

		// 왕의 위치
		st = new StringTokenizer(bf.readLine());
		r2 = Integer.parseInt(st.nextToken());
		c2 = Integer.parseInt(st.nextToken());

		bfs(r1, c1, 0);

		System.out.println(result);

	}

	private static void bfs(int r1, int c1, int depth) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { r1, c1, depth });
		visited[r1][c1] = true;

		while (!queue.isEmpty()) {
			int temp[] = queue.poll();
			int num = 0;
			for (int i = 0; i < 4; i++) {
				int x = temp[0] + dx[i];
				int y = temp[1] + dy[i];
				if (x >= 0 && x < 10 && y >= 0 && y < 9 ) { 
					for (int j = num; j < num+2; j++) {
						if (x + (dx2[j] * 2) >= 0 && x + (dx2[j] * 2) < 10 && y + (dy2[j] * 2) >= 0
								&& y + (dy2[j] * 2) < 9) { 
							if (x + dx2[j] == r2 && y + dy2[j] == c2) 
								continue;
							if (visited[x + (dx2[j] * 2)][y + (dy2[j] * 2)]) 
								continue;
							if (x + (dx2[j] * 2) == r2 && y + (dy2[j] * 2) == c2) {
								result = temp[2] + 1;
								break;
							}
							visited[x + (dx2[j] * 2)][y + (dy2[j] * 2)] = true;
							queue.add(new int[] { x + (dx2[j] * 2), y + (dy2[j] * 2), temp[2] + 1 });
						}
					}
					if (result > -1)
						break;
				}
				num += 2;
			}
			if (result > -1)
				break;
		}
	}
}
