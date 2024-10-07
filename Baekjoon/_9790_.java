import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _9790_ { // Elephant Show

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int a = -1, b = -1;
		int dx[] = { -1, 1, 0, 0 };
		int dy[] = { 0, 0, -1, 1 };
		while ((a = Integer.parseInt(st.nextToken())) != 0 && (b = Integer.parseInt(st.nextToken())) != 0) {
			boolean arr[][] = new boolean[b][a];

			int x = -1, y = -1;
			for (int i = 0; i < b; i++) {
				String str = bf.readLine();
				for (int j = 0; j < a; j++) {
					if (str.charAt(j) == '#') {
						arr[i][j] = true;
					} else if (str.charAt(j) == 'A') {
						x = i;
						y = j;
					}
				}
			}

			int answer = 1;
			Queue<int[]> queue = new LinkedList<>();
			queue.add(new int[] { x, y });
			arr[x][y] = true;

			while (!queue.isEmpty()) {
				int temp[] = queue.poll();
				for (int i = 0; i < 4; i++) {
					x = temp[0] + dx[i];
					y = temp[1] + dy[i];
					if (x >= 0 && x < b && y >= 0 && y < a && !arr[x][y]) {
						arr[x][y] = true;
						answer += 1;
						queue.add(new int[] { x, y });
					}
				}
			}
			bw.write(answer + "\n");
			st = new StringTokenizer(bf.readLine());
		}
		bw.flush();
	}
}
