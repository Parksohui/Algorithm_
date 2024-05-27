import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _11504_ { // 돌려 돌려 돌림판!

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int t = Integer.parseInt(bf.readLine());

		int num[] = new int[2];

		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(bf.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			String str = "";

			for (int j = 0; j < 2; j++) {
				st = new StringTokenizer(bf.readLine());
				for (int k = 0; k < m; k++) {
					str += st.nextToken();
				}
				num[j] = Integer.parseInt(str);
				str = "";
			}

			int arr[] = new int[n];
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}

			int result = 0;
			for (int j = 0; j < n; j++) {
				str = "";
				for (int k = 0; k < m; k++) {
					if (j + k >= n) {
						str += arr[j + k - n];
					} else {
						str += arr[j + k];
					}
				}
				if (num[0] <= Integer.parseInt(str) && Integer.parseInt(str) <= num[1]) {
					result += 1;
				}
			}
			bw.write(result + "\n");
		}
		bw.flush();
	}
}
