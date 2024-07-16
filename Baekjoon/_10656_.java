import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _10656_ { // 십자말풀이

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		char arr[][] = new char[n][m];
		for (int i = 0; i < n; i++) {
			String str = bf.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		ArrayList<int[]> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == '#') {
					continue;
				}
				if ((j - 1 < 0 || arr[i][j - 1] == '#') && j + 1 < m && arr[i][j + 1] == '.' && j + 2 < m
						&& arr[i][j + 2] == '.') {
					list.add(new int[] { i + 1, j + 1 });
				} else if ((i - 1 < 0 || arr[i - 1][j] == '#') && i + 1 < n && arr[i + 1][j] == '.' && i + 2 < n
						&& arr[i + 2][j] == '.') {
					list.add(new int[] { i + 1, j + 1 });
				}
			}
		}
		bw.write(list.size() + "\n");
		for (int[] temp : list) {
			bw.write(temp[0] + " " + temp[1] + "\n");
		}
		bw.flush();
	}
}
