import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _2508_ { // 사탕 박사 고창영

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int t = Integer.parseInt(bf.readLine());

		for (int k = 0; k < t; k++) {
			bf.readLine();

			st = new StringTokenizer(bf.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			char[][] arr = new char[r][c];

			for (int i = 0; i < r; i++) {
				String str = bf.readLine();
				for (int j = 0; j < c; j++) {
					arr[i][j] = str.charAt(j);
				}
			}

			int answer = 0;
			for (int i = 0; i < r; i++) {
				int idx = 0;
				while (idx < c) {
					if (arr[i][idx] == '>' && idx + 1 < c && arr[i][idx + 1] == 'o' && idx + 2 < c
							&& arr[i][idx + 2] == '<') {
						answer += 1;
						idx += 3;
					} else if (arr[i][idx] == 'v' && i + 1 < r && arr[i + 1][idx] == 'o' && i + 2 < r
							&& arr[i + 2][idx] == '^') {
						answer += 1;
						idx += 1;
					} else {
						idx += 1;
					}
				}
			}
			bw.write(answer + "\n");
		}
		bw.flush();
	}
}
