import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _32076_ { // Easy as ABC

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		char arr[][] = new char[3][3];

		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});

		for (int i = 0; i < 3; i++) {
			String str = bf.readLine();
			for (int j = 0; j < 3; j++) {
				arr[i][j] = str.charAt(j);
				queue.add(new int[] { i, j, arr[i][j] - '0' });
			}
		}

		int num = queue.peek()[2];
		int dx[] = { -1, -1, -1, 0, 1, 1, 1, 0 };
		int dy[] = { -1, 0, 1, 1, 1, 0, -1, -1 };
		ArrayList<String> list = new ArrayList<>();

		while (!queue.isEmpty() && num == queue.peek()[2]) {
			int temp[] = queue.poll();
			boolean visited[][] = new boolean[3][3];

			visited[temp[0]][temp[1]] = true;

			for (int i = 0; i < 8; i++) {
				String str = Character.toString((char) (temp[2] + '0'));
				int x = temp[0] + dx[i];
				int y = temp[1] + dy[i];

				if (x >= 0 && x < 3 && y >= 0 && y < 3 && !visited[x][y]) {
					str = str + arr[x][y];
					visited[x][y] = true;
					for (int j = 0; j < 8; j++) {
						int x2 = x + dx[j];
						int y2 = y + dy[j];

						if (x2 >= 0 && x2 < 3 && y2 >= 0 && y2 < 3 && !visited[x2][y2]) {
							String str2 = str + arr[x2][y2];
							list.add(str2);
						}
					}
				}
			}
		}
		Collections.sort(list);
		System.out.println(list.get(0));
	}
}
