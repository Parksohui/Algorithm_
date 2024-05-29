import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _3054_ { // 피터팬 프레임

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = bf.readLine();

		char arr[][] = new char[5][5 * str.length() - (str.length() - 1)];

		int dx[] = { -2, -1, -1, 0, 0, 1, 1, 2 };
		int dy[] = { 0, -1, 1, -2, 2, -1, 1, 0 };

		for (int i = 0; i < str.length(); i++) {
			arr[2][2 + (4 * i)] = str.charAt(i);

			for (int j = 0; j < 8; j++) {
				if ((i + 1) % 3 == 0) {
					arr[2 + dx[j]][2 + (4 * i) + dy[j]] = '*';
				} else {
					if (arr[2 + dx[j]][2 + (4 * i) + dy[j]] == '*') {
						continue;
					}
					arr[2 + dx[j]][2 + (4 * i) + dy[j]] = '#';
				}
			}
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] != '*' && arr[i][j] != '#' && !Character.isAlphabetic(arr[i][j])) {
					bw.write(".");
				} else {
					bw.write(arr[i][j]);
				}
			}
			bw.write("\n");
		}
		bw.flush();
	}
}
