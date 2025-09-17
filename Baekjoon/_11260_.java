import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _11260_ { // Cell Counting

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		String str = "";

		while (!(str = bf.readLine()).equals("0 0")) {
			st = new StringTokenizer(str);

			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			char arr[][] = new char[r][c];
			Queue<int[]> queue = new LinkedList<>();

			for (int i = 0; i < r; i++) {
				str = bf.readLine();
				for (int j = 0; j < c; j++) {
					arr[i][j] = str.charAt(j);
					if (arr[i][j] == '#') {
						queue.add(new int[] { i, j });
					}
				}
			}
			bw.write(bfs(queue, arr) + "\n");
		}
		bw.flush();
	}

	private static int bfs(Queue<int[]> queue, char[][] arr) {

		int dx[] = { -1, 1, 0, 0, -1, -1, 1, 1 };
		int dy[] = { 0, 0, -1, 1, -1, 1, -1, 1 };

		int result = 0;

		while (!queue.isEmpty()) {
			int position[] = queue.poll();

			boolean flag = false;

			for (int i = 0; i < 8; i++) {
				int x = position[0] + dx[i];
				int y = position[1] + dy[i];

				if (x >= 0 && x < arr.length && y >= 0 && y < arr[0].length && arr[x][y] == '#') {
					flag = true;
					break;
				}
			}

			if (!flag) {
				result += 1;
			}
		}
		return result;
	}
}
