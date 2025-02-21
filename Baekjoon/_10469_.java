import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _10469_ { // 사이 나쁜 여왕들

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		boolean visited[][] = new boolean[8][8];
		Queue<int[]> queue = new LinkedList<>();

		for (int i = 0; i < 8; i++) {
			String str = bf.readLine();
			for (int j = 0; j < 8; j++) {
				if (str.charAt(j) == '*') {
					visited[i][j] = true;
					queue.add(new int[] { i, j });
				}
			}
		}

		int dx[] = { -1, 1, 0, 0, -1, -1, 1, 1 };
		int dy[] = { 0, 0, -1, 1, -1, 1, -1, 1 };
		boolean flag = false;

		if (queue.size() != 8) {
			flag = true;
		}

		while (!queue.isEmpty() && !flag) {
			int temp[] = queue.poll();
			for (int i = 0; i < 8; i++) {
				int x = temp[0], y = temp[1];
				while (x + dx[i] >= 0 && x + dx[i] < 8 && y + dy[i] >= 0 && y + dy[i] < 8) {
					x += dx[i];
					y += dy[i];
					if (visited[x][y]) {
						flag = true;
						break;
					}
				}
				if (flag) {
					break;
				}
			}
		}

		if (flag) {
			System.out.println("invalid");
		} else {
			System.out.println("valid");
		}
	}
}
