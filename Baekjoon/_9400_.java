import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _9400_ { // Calculate the Fence Needed

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = 0;
		Queue<int[]> queue = new LinkedList<>();

		int dx[] = { -1, 1, 0, 0 };
		int dy[] = { 0, 0, -1, 1 };

		while ((N = Integer.parseInt(bf.readLine())) != 0) {
			boolean arr[][] = new boolean[101][101];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(bf.readLine());

				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				arr[101 - x][y] = true;
				queue.add(new int[] { 101 - x, y });
			}

			int result = 0;
			while (!queue.isEmpty()) {
				int temp[] = queue.poll();
				int cnt = 0;

				for (int i = 0; i < 4; i++) {
					int x = temp[0] + dx[i];
					int y = temp[1] + dy[i];

					if (x >= 0 && x < 101 && y >= 0 && y < 101 && arr[x][y]) {
						cnt += 1;
					}
				}
				result += (4 - cnt);
			}
			bw.write(result + "\n");
		}
		bw.flush();
	}
}
