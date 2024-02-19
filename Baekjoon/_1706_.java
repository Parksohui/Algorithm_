import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class _1706_ { // 크로스워드

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		char arr[][] = new char[r][c];
		for (int i = 0; i < r; i++) {
			String str = bf.readLine();
			for (int j = 0; j < c; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < r; i++) {
			String temp = "";
			for (int j = 0; j < c; j++) {
				if (arr[i][j] != '#') {
					temp += arr[i][j];
				} else {
					if (temp.length() > 1) {
						list.add(temp);
					}
					temp = "";
				}
			}
			if (temp.length() > 1) {
				list.add(temp);
			}
		}

		for (int i = 0; i < c; i++) {
			String temp = "";
			for (int j = 0; j < r; j++) {
				if (arr[j][i] != '#') {
					temp += arr[j][i];
				} else {
					if (temp.length() > 1) {
						list.add(temp);
					}
					temp = "";
				}
			}
			if (temp.length() > 1) {
				list.add(temp);
			}
		}

		Collections.sort(list);
		System.out.println(list.get(0));
			
	}
}
