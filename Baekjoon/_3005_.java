import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class _3005_ { // 크로스워드 퍼즐 쳐다보기

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		char[][] arr = new char[r][c];
		for (int i = 0; i < r; i++) {
			String str = bf.readLine();
			for (int j = 0; j < c; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		ArrayList<String> result = new ArrayList<>();

		// 가로
		for (int i = 0; i < r; i++) {
			String str = "";
			for (int j = 0; j < c; j++) {
				if (arr[i][j] != '#') {
					str += arr[i][j];
				} else {
					if (str.length() > 1) {
						result.add(str);
					}
					str = "";
				}
			}
			if (str.length() > 1) {
				result.add(str);
			}
		}

		// 세로
		for (int i = 0; i < c; i++) {
			String str = "";
			for (int j = 0; j < r; j++) {
				if (arr[j][i] != '#') {
					str += arr[j][i];
				} else {
					if (str.length() > 1) {
						result.add(str);
					}
					str = "";
				}
			}
			if (str.length() > 1) {
				result.add(str);
			}
		}

		Collections.sort(result);
		System.out.println(result.get(0));
	}
}
