import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _4659_ { // 비밀번호 발음하기

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String arr[] = new String[] { "a", "e", "i", "o", "u" };

		String s = bf.readLine();
		while (!s.equals("end")) {
			boolean flag = false;

			// 1. 모음
			int count = 0;
			for (int i = 0; i < 5; i++) {
				if (s.contains(arr[i]))
					count += 1;
			}
			if (count == 0)
				flag = true;

			// 2. 모음 3개, 자음 3개
			count = 0;
			int count2 = 0;
			for (int i = 0; i < s.length(); i++) {
				boolean temp = false;
				for (int j = 0; j < 5; j++) {
					if (s.charAt(i) == arr[j].charAt(0)) {
						count2 = 0;
						count += 1;
						temp = true;
						break;
					}
				}
				if (!temp) {
					count = 0;
					count2 += 1;
				}
				if (count >= 3 || count2 >= 3) {
					flag = true;
					break;
				}
			}

			// 3. 같은 글자 연속적 두번 x (ee, oo 허용)
			count = 0;
			for (int i = 0; i < s.length() - 1; i++) {
				if (s.charAt(i) == s.charAt(i + 1) && s.charAt(i) != 'e' && s.charAt(i) != 'o') {
					flag = true;
					break;
				}
			}

			if (flag)
				System.out.println("<" + s + "> is not acceptable.");
			else
				System.out.println("<" + s + "> is acceptable.");

			s = bf.readLine();
		}
	}
}
