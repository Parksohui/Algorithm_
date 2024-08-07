import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1254_ { // 팰린드롬 만들기

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String S = bf.readLine();
		int answer = Integer.MAX_VALUE;

		boolean flag = false;
		if (S.length() == 1) {
			answer = 1;
		} else if (S.length() == 2 && S.charAt(0) == S.charAt(1)) {
			answer = 2;
		} else {
			for (int i = S.length() / 2 - 1; i < S.length(); i++) {
				boolean check = false;
				if (i + 1 < S.length() && S.charAt(i) == S.charAt(i + 1) && i>=S.length()-i-2) {
					for (int j = 1; j <= i; j++) {
						if (i + 1 + j >= S.length()) {
							answer = Math.min(answer, i + i + 2);
							flag = true;
							check = true;
							break;
						}
						if (S.charAt(i - j) != S.charAt(i + 1 + j)) {
							check = true;
							break;
						}
					}
					if (!check) {
						answer = Math.min(answer, S.length());
					}
				}

				if (i < S.length() - 1 - i) {
					continue;
				}

				check = false;
				for (int j = 1; j <= i; j++) {
					if (i + j >= S.length()) {
						answer = Math.min(answer, i + i + 1);
						flag = true;
						check = true;
						break;
					}
					if (S.charAt(i - j) != S.charAt(i + j)) {
						check = true;
						break;
					}
				}
				if (!check) {
					answer = Math.min(answer, S.length());
					break;
				}
				if (flag) {
					break;
				}
			}
		}
		System.out.println(answer);
	}
}
