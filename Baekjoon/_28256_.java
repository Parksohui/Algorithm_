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

public class _28256_ { // 초콜릿 보관함
	static char arr[][];
	static boolean visited[][];
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(bf.readLine());

		for (int i = 0; i < T; i++) {
			arr = new char[3][3];
			visited = new boolean[3][3];
			for (int j = 0; j < 3; j++) {
				String str = bf.readLine();
				for (int k = 0; k < 3; k++) {
					arr[j][k] = str.charAt(k);
				}
			}

			ArrayList<Integer> result = new ArrayList<>();
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					if (arr[j][k] == 'O' && !visited[j][k]) {
						visited[j][k] = true;
						result.add(search(j, k, 1));
					}
				}
			}

			Collections.sort(result);

			st = new StringTokenizer(bf.readLine());
			int num = Integer.parseInt(st.nextToken());
			int answer[] = new int[num];
			boolean flag = false;
			for (int j = 0; j < num; j++) {
				answer[j] = Integer.parseInt(st.nextToken());
			}

			if (result.size() != num) {
				bw.write("0\n");
			} else {
				for (int j = 0; j < num; j++) {
					if (result.get(j) != answer[j]) {
						bw.write("0\n");
						flag = true;
						break;
					}
				}
				if (!flag) {
					bw.write("1\n");
				}
			}
		}
		bw.flush();
	}

	private static int search(int a, int b, int cnt) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { a, b });

		while (!queue.isEmpty()) {
			int info[] = queue.poll();
			for (int i = 0; i < 4; i++) {
				int x = info[0] + dx[i];
				int y = info[1] + dy[i];
				if (x >= 0 && x < 3 && y >= 0 && y < 3 && arr[x][y] == 'O' && !visited[x][y]) {
					visited[x][y] = true;
					cnt += 1;
					queue.add(new int[] { x, y });
				}
			}
		}
		return cnt;
	}
}
