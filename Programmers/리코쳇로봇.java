import java.util.*;

class Solution {
	public int solution(String[] board) {
		int answer = 0;

		char arr[][] = new char[board.length][board[0].length()];

		int x = 0, y = 0;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length(); j++) {
				arr[i][j] = board[i].charAt(j);

				if (arr[i][j] == 'R') {
					x = i;
					y = j;
				}
			}
		}

		answer = bfs(arr, x, y);

		return answer;
	}

	private int bfs(char arr[][], int x, int y) {
		int dx[] = { -1, 1, 0, 0 };
		int dy[] = { 0, 0, -1, 1 };

		boolean visited[][] = new boolean[arr.length][arr[0].length];
		visited[x][y] = true;

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { x, y, 0 });

		while (!queue.isEmpty()) {
			int temp[] = queue.poll();

			for (int i = 0; i < 4; i++) {
				int x1 = temp[0], y1 = temp[1];

				while (x1 + dx[i] >= 0 && x1 + dx[i] < arr.length && y1 + dy[i] >= 0 && y1 + dy[i] < arr[0].length
						&& arr[x1 + dx[i]][y1 + dy[i]] != 'D') {
					x1 += dx[i];
					y1 += dy[i];
				}
				if (arr[x1][y1] == 'G') {
					return temp[2] + 1;
				}
				if (!visited[x1][y1]) {
					visited[x1][y1] = true;
					queue.add(new int[] { x1, y1, temp[2] + 1 });
				}
			}
		}
		return -1;
	}
}