import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class _9700_ { // RAINFOREST CANOPY
	static boolean arr[][];
	static int dx[] = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int dy[] = { 0, 0, -1, 1, -1, 1, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = "";
		int idx = 1;

		while ((str = bf.readLine()) != null) {
			int num = Integer.parseInt(str);

			arr = new boolean[num][num];

			for (int i = 0; i < num; i++) {
				String temp = bf.readLine();
				for (int j = 0; j < num; j++) {
					if (temp.charAt(j) == '0') {
						arr[i][j] = true;
					}
				}
			}

			int result = 0;
			for (int i = 0; i < num; i++) {
				for (int j = 0; j < num; j++) {
					if (!arr[i][j]) {
						result += 1;
						bfs(i, j);
					}
				}
			}
			bw.write("Case #" + (idx++) + ": " + result + "\n");
		}
		bw.flush();
	}

	private static void bfs(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { i, j });

		while (!queue.isEmpty()) {
			int temp[] = queue.poll();
			for (int k = 0; k < 8; k++) {
				int x = temp[0] + dx[k];
				int y = temp[1] + dy[k];
				if (x >= 0 && x < arr.length && y >= 0 && y < arr[0].length && !arr[x][y]) {
					arr[x][y] = true;
					queue.add(new int[] { x, y });
				}
			}
		}
	}
}
