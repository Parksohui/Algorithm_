import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _5637_ { // 가장 긴 단어

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		boolean flag = false;
		int max = 0;
		String result = "";

		while (true) {
			st = new StringTokenizer(bf.readLine());

			while (st.hasMoreTokens()) {
				String str = st.nextToken();
				if (str.equals("E-N-D")) {
					flag = true;
					break;
				}

				String answer = "";
				for (int i = 0; i < str.length(); i++) {
					if (Character.isAlphabetic(str.charAt(i)) || str.charAt(i) == '-') {
						answer += Character.toLowerCase(str.charAt(i));
					} else {
						if (max < answer.length()) {
							max = answer.length();
							result = answer;
						}
						answer = "";
					}
				}
				if (max < answer.length()) {
					max = answer.length();
					result = answer;
				}
			}
			if (flag) {
				break;
			}
		}
		System.out.println(result);
	}
}
