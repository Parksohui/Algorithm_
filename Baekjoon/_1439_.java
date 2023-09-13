import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1439_ { // 뒤집기

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String str = bf.readLine();

		int zero = 0, one = 0;

		if (str.charAt(0) == '0') {
			zero += 1;
		} else {
			one += 1;
		}

		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i - 1) != str.charAt(i)) {
				if (str.charAt(i) == '0')
					zero += 1;
				else
					one += 1;
			}
		}

		int result = (zero > one) ? one : zero;
		System.out.println(result);

	}
}
