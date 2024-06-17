import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1120_ { // 문자열
	static String A, B;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		A = st.nextToken();
		B = st.nextToken();

		int d = B.length() - A.length();

		int result = B.length();
		if (d == 0) {
			result = Math.min(result, diff(0));
		} else {
			while (d >= 0) {
				result = Math.min(result, diff(d--));
			}
		}

		System.out.println(result);
	}

	private static int diff(int left) {
		int answer = 0;
		for (int i = left; i < left + A.length(); i++) {
			if (A.charAt(i - left) != B.charAt(i)) {
				answer += 1;
			}
		}
		return answer;
	}
}
