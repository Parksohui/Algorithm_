import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _15645_ { // 내려가기 2

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		int arr[][] = new int[n][3];

		int maxDp[][] = new int[n][3];
		int minDp[][] = new int[n][3];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());

			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				minDp[i][j] = Integer.MAX_VALUE;
			}
		}

		for (int i = 0; i < 3; i++) {
			maxDp[0][i] = arr[0][i];
			minDp[0][i] = arr[0][i];
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				if (j - 1 >= 0) {
					maxDp[i][j] = Math.max(maxDp[i][j], maxDp[i - 1][j - 1] + arr[i][j]);
					minDp[i][j] = Math.min(minDp[i][j], minDp[i - 1][j - 1] + arr[i][j]);
				}
				if (j + 1 < 3) {
					maxDp[i][j] = Math.max(maxDp[i][j], maxDp[i - 1][j + 1] + arr[i][j]);
					minDp[i][j] = Math.min(minDp[i][j], minDp[i - 1][j + 1] + arr[i][j]);
				}
				maxDp[i][j] = Math.max(maxDp[i][j], maxDp[i - 1][j] + arr[i][j]);
				minDp[i][j] = Math.min(minDp[i][j], minDp[i - 1][j] + arr[i][j]);
			}
		}

		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			max = Math.max(max, maxDp[n - 1][i]);
			min = Math.min(min, minDp[n - 1][i]);
		}

		bw.write(max + " " + min);
		bw.flush();
	}
}
