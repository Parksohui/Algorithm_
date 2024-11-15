import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _15242_ { // Knight
	static int dx[] = { -2, -2, -1, 1, 2, 2, 1, -1 };
	static int dy[] = { -1, 1, 2, 2, 1, -1, -2, -2 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String start = bf.readLine();
		String end = bf.readLine();

		int x1 = 8 - (start.charAt(1)-'0');
		int y1 = start.charAt(0) - 'a';

		int x2 = 8 - (end.charAt(1)-'0');
		int y2 = end.charAt(0) - 'a';

		if (x1 == x2 && y1 == y2) {
			System.out.println(0);
		} else {
			System.out.println(bfs(x1, y1, x2, y2));
		}
	}

	private static int bfs(int x1, int y1, int x2, int y2) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { x1, y1, 0 });

		boolean visited[][] = new boolean[8][8];
		visited[x1][y1] = true;

		while (!queue.isEmpty()) {
			int temp[] = queue.poll();
			for (int i = 0; i < 8; i++) {
				int x = temp[0] + dx[i];
				int y = temp[1] + dy[i];
				if (x >= 0 && x < 8 && y >= 0 && y < 8 && !visited[x][y]) {
					if (x == x2 && y == y2) {
						return temp[2] + 1;
					}
					visited[x][y] = true;
					queue.add(new int[] { x, y, temp[2] + 1 });
				}
			}
		}
		return -1;
	}
}
