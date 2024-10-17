import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _30610_ { // A-maze-ing Lakes
	static boolean arr[][];
	static ArrayList<Integer> result;
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		arr = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String str = bf.readLine();
			for (int j = 0; j < M; j++) {
				if (str.charAt(j) == '0') {
					arr[i][j] = true;
				}
			}
		}

		result = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!arr[i][j]) {
					bfs(i, j);
				}
			}
		}

		Collections.sort(result);
		bw.write(result.size() + "\n");
		for (int num : result) {
			bw.write(num + " ");
		}
		bw.flush();
	}

	private static void bfs(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { i, j });
		arr[i][j] = true;
		int cnt = 1;

		while (!queue.isEmpty()) {
			int temp[] = queue.poll();
			for (int k = 0; k < 4; k++) {
				int x = temp[0] + dx[k];
				int y = temp[1] + dy[k];
				if (x >= 0 && x < arr.length && y >= 0 && y < arr[0].length && !arr[x][y]) {
					arr[x][y] = true;
					cnt += 1;
					queue.add(new int[] { x, y });
				}
			}
		}
		result.add(cnt);
	}
}
