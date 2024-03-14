import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _5549_ { // 행성 탐사
	static class Planet {
		private int j, o ,i;

		public Planet(int j, int o, int i) {
			this.j = j;
			this.o = o;
			this.i = i;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(bf.readLine());

		char arr[][] = new char[m + 1][n + 1];
		Planet result[][] = new Planet[m + 1][n + 1];

		for (int i = 0; i < m + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				result[i][j] = new Planet(0, 0, 0);
			}
		}

		for (int i = 1; i <= m; i++) {
			String str = bf.readLine();
			for (int j = 1; j <= n; j++) {
				arr[i][j] = str.charAt(j - 1);

				result[i][j].j = result[i - 1][j].j + result[i][j - 1].j - result[i - 1][j - 1].j;
				result[i][j].o = result[i - 1][j].o + result[i][j - 1].o - result[i - 1][j - 1].o;
				result[i][j].i = result[i - 1][j].i + result[i][j - 1].i - result[i - 1][j - 1].i;

				if (arr[i][j] == 'J') {
					result[i][j].j += 1;
				} else if (arr[i][j] == 'O') {
					result[i][j].o += 1;
				} else {
					result[i][j].i += 1;
				}
			}
		}

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			Planet answer = new Planet(result[c][d].j, result[c][d].o, result[c][d].i);

			answer.i -= result[c][b-1].i;
			answer.j -= result[c][b-1].j;
			answer.o -= result[c][b-1].o;

			answer.i -= result[a-1][d].i;
			answer.j -= result[a-1][d].j;
			answer.o -= result[a-1][d].o;

			answer.i += result[a-1][b-1].i;
			answer.j += result[a-1][b-1].j;
			answer.o += result[a-1][b-1].o;

			bw.write(answer.j + " " + answer.o + " " + answer.i + "\n");
		}
		bw.flush();
	}
}
