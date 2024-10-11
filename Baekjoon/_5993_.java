import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _5993_ { // Invasion of the Milkweed
	static boolean arr[][];
	static int dx[] = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int dy[] = { 0, 0, -1, 1, -1, 1, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int Mx = Integer.parseInt(st.nextToken());
		int My = Integer.parseInt(st.nextToken());

		arr = new boolean[Y][X];
		for (int i = 0; i < Y; i++) {
			String str = bf.readLine();
			for (int j = 0; j < X; j++) {
				if (str.charAt(j) == '*') {
					arr[i][j] = true;
				}
			}
		}
		System.out.println(bfs(Y - My, Mx - 1));
	}

	private static int bfs(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { i, j, 0 });
		arr[i][j] = true;

		int result = 0;

		while (!queue.isEmpty()) {
			int temp[] = queue.poll();
			for (int k = 0; k < 8; k++) {
				int x = temp[0] + dx[k];
				int y = temp[1] + dy[k];
				if (x >= 0 && x < arr.length && y >= 0 && y < arr[0].length && !arr[x][y]) {
					arr[x][y] = true;
					result = Math.max(result, temp[2] + 1);
					queue.add(new int[] { x, y, temp[2] + 1 });
				}
			}
		}
		return result;
	}
}
