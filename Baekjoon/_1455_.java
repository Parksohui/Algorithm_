import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1455_ { // 뒤집기 II
	static boolean arr[][];
	static int maxX, maxY;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		arr = new boolean[n][m];

		int result = 0;

		maxX = -1;
		maxY = -1;
		for (int i = 0; i < n; i++) {
			String str = bf.readLine();
			for (int j = 0; j < m; j++) {
				if (str.charAt(j) == '1') {
					arr[i][j] = true;
					maxX = i;
					maxY = j;
				}
			}
		}

		while (maxX != -1 && maxY != -1) {
			result += 1;
			convert(maxX, maxY);
			check();
		}
		System.out.println(result);
	}

	private static void check() {
		maxX = -1;
		maxY = -1;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j]) {
					maxX = i;
					maxY = j;
				}
			}
		}

	}

	private static void convert(int x, int y) {
		for (int i = 0; i <= x; i++) {
			for (int j = 0; j <= y; j++) {
				arr[i][j] = !arr[i][j];
			}
		}
	}
}
