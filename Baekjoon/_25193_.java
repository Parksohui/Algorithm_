import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _25193_ { // 곰곰이의 식단 관리

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bf.readLine());

		String S = bf.readLine();
		int c = 0, e = 0;
		for (int i = 0; i < N; i++) {
			if (S.charAt(i) == 'C') {
				c += 1;
			} else {
				e += 1;
			}
		}

		int result = c / (e + 1);
		if (e > 0 && c % (e + 1) != 0) {
			result += 1;
		}
		System.out.println(result);
	}
}
