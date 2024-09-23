import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _15240_ { // Paint bucket

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int arr[][] = new int[R][C];
		for (int i = 0; i < R; i++) {
			String str = bf.readLine();
			for (int j = 0; j < C; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}

		st = new StringTokenizer(bf.readLine());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int dx[] = { -1, 1, 0, 0 };
		int dy[] = { 0, 0, -1, 1 };

		if (arr[X][Y] != K) {
			Queue<int[]> queue = new LinkedList<>();
			queue.add(new int[] { X, Y });
			int c = arr[X][Y];
			arr[X][Y] = K;

			while (!queue.isEmpty()) {
				int temp[] = queue.poll();
				for (int i = 0; i < 4; i++) {
					int a = temp[0] + dx[i];
					int b = temp[1] + dy[i];
					if (a >= 0 && a < R && b >= 0 && b < C && arr[a][b] == c) {
						arr[a][b] = K;
						queue.add(new int[] { a, b });
					}
				}
			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				bw.write(arr[i][j] + "");
			}
			bw.write("\n");
		}
		bw.flush();
	}
}
