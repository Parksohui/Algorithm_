import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class _11448_ { // Ga
	static int dx[] = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int dy[] = { 0, 0, -1, 1, -1, 1, -1, 1 };
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(bf.readLine());
		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(bf.readLine());

			boolean arr[][] = new boolean[N][N];
			Queue<int[]> queue = new LinkedList<>();
			for (int j = 0; j < N; j++) {
				String str = bf.readLine();
				for (int k = 0; k < N; k++) {
					if (str.charAt(k) == 'b') {
						arr[j][k] = true;
					} else if (str.charAt(k) == 'w') {
						arr[j][k] = true;
						queue.add(new int[] { j, k });
					}
				}
			}
			bw.write(bfs(arr, queue) + "\n");
		}
		bw.flush();
	}

	private static int bfs(boolean[][] arr, Queue<int[]> queue) {
		int result = 0;

		while (!queue.isEmpty()) {
			int temp[] = queue.poll();
			for (int i = 0; i < 8; i++) {
				int x = temp[0] + dx[i];
				int y = temp[1] + dy[i];
				if (x >= 0 && x < N && y >= 0 && y < N && !arr[x][y]) {
					arr[x][y] = true;
					result += 1;
					queue.add(new int[] { x, y });
				}
			}
		}
		return result;
	}
}
