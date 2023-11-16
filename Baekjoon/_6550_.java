import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _6550_ { // 부분 문자열

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String str = "";
		while ((str = bf.readLine()) != null) {
			st = new StringTokenizer(str);

			String s = st.nextToken();
			String t = st.nextToken();

			int arr[][] = new int[s.length() + 1][t.length() + 1];

			for (int i = 0; i < s.length(); i++) {
				for (int j = 0; j < t.length(); j++) {
					if (s.charAt(i) == t.charAt(j)) {
						arr[i + 1][j + 1] = Math.max(arr[i][j] + 1, arr[i][j + 1]);
					} else {
						arr[i + 1][j + 1] = Math.max(arr[i][j + 1], arr[i + 1][j]);
					}
				}
			}
			if (arr[s.length()][t.length()] == s.length()) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}
	}
}
