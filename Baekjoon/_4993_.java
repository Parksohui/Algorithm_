import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _4993_ { // Red and Black
	static boolean arr[][];
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(bf.readLine());
		int w = -1, h = -1;

		while ((w = Integer.parseInt(st.nextToken())) != 0 && (h = Integer.parseInt(st.nextToken())) != 0) {
			arr = new boolean[h][w];
			int x = -1, y = -1;

			for (int i = 0; i < h; i++) {
				String str = bf.readLine();
				for (int j = 0; j < w; j++) {
					if (str.charAt(j) == '#') {
						arr[i][j] = true;
					} else if (str.charAt(j) == '@') {
						x = i;
						y = j;
					}
				}
			}
			result = 1;
			arr[x][y] = true;
			bfs(x, y);

			bw.write(result + "\n");
			st = new StringTokenizer(bf.readLine());
		}
		bw.flush();
	}

	private static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { x, y });

		while (!queue.isEmpty()) {
			int temp[] = queue.poll();
			for (int i = 0; i < 4; i++) {
				int a = temp[0] + dx[i];
				int b = temp[1] + dy[i];
				if (a >= 0 && a < arr.length && b >= 0 && b < arr[0].length && !arr[a][b]) {
					arr[a][b] = true;
					result += 1;
					queue.add(new int[] { a, b });
				}
			}
		}

	}

}
