import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _1331_ { // 나이트 투어
	static Queue<int[]> queue;
	static boolean arr[][];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		arr = new boolean[6][6];

		int startX = 0, startY = 0;
		queue = new LinkedList<>();

		for (int i = 0; i < 36; i++) {
			String str = bf.readLine();
			int x = 0;
			int y = 6 - (str.charAt(1) - '0');

			if (str.charAt(0) == 'A') {
				x = 0;
			} else if (str.charAt(0) == 'B') {
				x = 1;
			} else if (str.charAt(0) == 'C') {
				x = 2;
			} else if (str.charAt(0) == 'D') {
				x = 3;
			} else if (str.charAt(0) == 'E') {
				x = 4;
			} else if (str.charAt(0) == 'F') {
				x = 5;
			}

			if (i == 0) {
				startX = x;
				startY = y;
			}
			queue.add(new int[] { x, y });
		}
		queue.add(new int[] { startX, startY });

		if (check(queue)) {
			System.out.println("Valid");
		} else {
			System.out.println("Invalid");
		}
	}

	private static boolean check(Queue<int[]> queue) {
		int dx[] = { -1, -2, -2, -1, 1, 2, 2, 1 };
		int dy[] = { -2, -1, 1, 2, 2, 1, -1, -2 };

		int now[] = queue.poll();
		boolean flag = false;

		while (!queue.isEmpty()) {
			for (int i = 0; i < 8; i++) {
				int x = now[0] + dx[i];
				int y = now[1] + dy[i];
				if (queue.peek()[0] == x && queue.peek()[1] == y) {
					if (arr[x][y]) {
						return false;
					}
					arr[x][y] = true;
					flag = true;
					now = queue.poll();
					break;
				}
			}
			if (!flag) {
				return false;
			}
			flag = false;
		}
		return true;
	}
}
