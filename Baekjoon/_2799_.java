import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _2799_ { // 블라인드

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int arr[][] = new int[5 * m + 1][5 * n + 1];
		int result[] = new int[5];

		for (int i = 0; i < 5 * m + 1; i++) {
			String str = bf.readLine();
			for (int j = 0; j < 5 * n + 1; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		for (int j = 0; j < 5 * n; j += 5) {
			for (int i = 0; i < 5 * m; i += 5) {
				int cnt = 0;
				for (int k = i + 1; k < i + 6; k++) {
					if (arr[k][j + 1] == '*') {
						cnt += 1;
					}
				}
				result[cnt] += 1;
			}
		}

		for (int i = 0; i < 5; i++) {
			bw.write(result[i] + " ");
		}
		bw.flush();
	}

}
