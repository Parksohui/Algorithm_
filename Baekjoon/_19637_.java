import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _19637_ { // IF문 좀 대신 써줘
	static String name[];
	static int value[];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		name = new String[n];
		value = new int[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());

			name[i] = st.nextToken();
			value[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < m; i++) {
			int num = Integer.parseInt(bf.readLine());
			int result = search(num, 0, n - 1);
			bw.write(name[result] + "\n");
		}
		bw.flush();
	}

	private static int search(int num, int start, int end) {
		if (start > end) {
			return -1;
		}

		int mid = (start + end) / 2;

		if (value[mid] < num) {
			if (value[mid + 1] >= num) {
				return mid + 1;
			}
			return search(num, mid + 1, end);
		} else if (value[mid] >= num) {
			if (mid == 0) {
				return 0;
			}
			if (value[mid - 1] < num) {
				return mid;
			}
			return search(num, start, mid - 1);
		}
		return -1;
	}
}
