import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _15426_ { // GlitchBot
	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
	static int x, y;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());

		int n = Integer.parseInt(bf.readLine());

		String arr[] = new String[n];
		for (int i = 0; i < n; i++) {
			arr[i] = bf.readLine();
		}

		flag = false;
		for (int i = 0; i < n; i++) {
			search(arr, i, 0, 0, 0, 0, "");
		}
	}

	private static void search(String[] arr, int i, int a, int b, int dir, int idx, String cmd) {
		if (flag) {
			return;
		}
		if (idx == arr.length) {
			if (a == x && y == b) {
				flag = true;
				System.out.println((i + 1) + " " + cmd);
			}
			return;
		}
		if (i == idx) {
			if (arr[i].equals("Left")) {
				search(arr, i, a, b, (dir + 1) > 3 ? 0 : dir + 1, idx + 1, "Right"); // right
				search(arr, i, a + dx[dir], b + dy[dir], dir, idx + 1, "Forward"); // forward
			} else if (arr[i].equals("Right")) {
				search(arr, i, a, b, (dir - 1) < 0 ? 3 : dir - 1, idx + 1, "Left"); // left
				search(arr, i, a + dx[dir], b + dy[dir], dir, idx + 1, "Forward"); // forward
			} else {
				search(arr, i, a, b, (dir + 1) > 3 ? 0 : dir + 1, idx + 1, "Right"); // right
				search(arr, i, a, b, (dir - 1) < 0 ? 3 : dir - 1, idx + 1, "Left"); // left
			}
		} else {
			if (arr[idx].equals("Left")) {
				search(arr, i, a, b, (dir - 1) < 0 ? 3 : dir - 1, idx + 1, cmd); // left
			} else if (arr[idx].equals("Right")) {
				search(arr, i, a, b, (dir + 1) > 3 ? 0 : dir + 1, idx + 1, cmd); // right
			} else {
				search(arr, i, a + dx[dir], b + dy[dir], dir, idx + 1, cmd); // forward
			}
		}
	}
}
