import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _6191_ { // Cows on Skates
	static boolean arr[][];
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	static class Info {
		int x;
		int y;
		ArrayList<int[]> list;

		public Info(int x, int y, ArrayList<int[]> list) {
			this.x = x;
			this.y = y;
			this.list = list;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		arr = new boolean[r][c];
		for (int i = 0; i < r; i++) {
			String str = bf.readLine();
			for (int j = 0; j < c; j++) {
				if (str.charAt(j) == '*') {
					arr[i][j] = true;
				}
			}
		}

		ArrayList<int[]> result = bfs();

		for (int[] answer : result) {
			bw.write(answer[0] + " " + answer[1] + "\n");
		}
		bw.write(r + " " + c);
		bw.flush();
	}

	private static ArrayList<int[]> bfs() {
		Queue<Info> queue = new LinkedList<>();
		ArrayList<int[]> list = new ArrayList<>();
		list.add(new int[] { 1, 1 });
		queue.add(new Info(0, 0, list));

		arr[0][0] = true;

		while (!queue.isEmpty()) {
			Info info = queue.poll();
			for (int i = 0; i < 4; i++) {
				int x = info.x + dx[i];
				int y = info.y + dy[i];
				if (x >= 0 && x < arr.length && y >= 0 && y < arr[0].length && !arr[x][y]) {
					if (x == arr.length - 1 && y == arr[0].length - 1) {
						return info.list;
					}
					arr[x][y] = true;
					ArrayList<int[]> temp = new ArrayList<>(info.list);
					temp.add(new int[] { x + 1, y + 1 });
					queue.add(new Info(x, y, temp));
				}
			}
		}
		return null;
	}
}
