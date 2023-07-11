import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _5525_ { // IOIOI

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());
		int s = Integer.parseInt(bf.readLine());
		String str = bf.readLine();

		int cnt = 0;
		int i = 0;
		int result = 0;
		while (i < s - 2) {
			if (str.charAt(i) == 'I' && str.charAt(i + 1) == 'O' && str.charAt(i + 2) == 'I') {
				cnt += 1;
				i += 2;
			} else {
				if (cnt >= n) {
					result += cnt - n + 1;
				}
				cnt = 0;
				i += 1;
			}
		}
		if (cnt >= n)
			result += cnt - n + 1;

		System.out.println(result);
	}
}
