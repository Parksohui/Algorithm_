import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _17198_ { // Bucket Brigade

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		char arr[][] = new char[10][10];
		boolean visited[][] = new boolean[10][10];

		int x = 0, y = 0, x2 = 0, y2 = 0;
		for (int i = 0; i < 10; i++) {
			String str = bf.readLine();
			for (int j = 0; j < 10; j++) {
				arr[i][j] = str.charAt(j);
				if (arr[i][j] == 'B') {
					x = i;
					y = j;
				} else if (arr[i][j] == 'R') {
					visited[i][j] = true;
				} else if (arr[i][j] == 'L') {
					x2 = i;
					y2 = j;
				}
			}
		}

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { x, y, 0 });
		visited[x][y] = true;

		int dx[] = { -1, 1, 0, 0 };
		int dy[] = { 0, 0, -1, 1 };
		boolean flag = false;
		while (!queue.isEmpty()) {
			int temp[] = queue.poll();
			for (int i = 0; i < 4; i++) {
				int a = temp[0] + dx[i];
				int b = temp[1] + dy[i];
				if (a >= 0 && a < 10 && b >= 0 && b < 10 && !visited[a][b]) {
					if (a == x2 && b == y2) {
						System.out.println(temp[2]);
						flag = true;
						break;
					}
					visited[a][b] = true;
					queue.add(new int[] { a, b, temp[2] + 1 });
				}
			}
			if (flag) {
				break;
			}
		}
	}
}
