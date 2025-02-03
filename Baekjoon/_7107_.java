import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _7107_ { // Journey of A Knight
	static int dx[] = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int dy[] = { -2, -1, 1, 2, 2, 1, -1, -2 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int i = Integer.parseInt(st.nextToken()) - 1;
		int j = m - Integer.parseInt(st.nextToken());

		boolean arr[][] = new boolean[m][n];
		int x = m - 1, y = 0;
		arr[x][y] = true;

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { x, y, 0 });

		boolean flag = false;
		int result = -1;
		while (!queue.isEmpty()) {
			int temp[] = queue.poll();
			for (int k = 0; k < 8; k++) {
				x = temp[0] + dx[k];
				y = temp[1] + dy[k];
				if (x >= 0 && x < m && y >= 0 && y < n && !arr[x][y]) {
					if (x == j && y == i) {
						flag = true;
						result = temp[2] + 1;
						break;
					}
					arr[x][y] = true;
					queue.add(new int[] { x, y, temp[2] + 1 });
				}
			}
			if (flag) {
				break;
			}
		}

		if (result != -1) {
			System.out.println(result);
		} else {
			System.out.println("NEVAR");
		}
	}
}
