import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1343_ { // 폴리오미노

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String board = bf.readLine();
		String[] arr = board.split("\\.");

		String result = "";
		boolean flag = false;

		int idx = 0;
		while (idx < board.length() && board.charAt(idx) == '.') {
			result += ".";
			idx += 1;
		}

		for (String x : arr) {
			int len = x.length();
			if (len % 4 == 0 || len % 2 == 0 || len % 6 == 0) {
				while (len > 0) {
					if (len >= 4) {
						result += "AAAA";
						len -= 4;
						idx += 4;
					} else if (len == 2) {
						result += "BB";
						len -= 2;
						idx += 2;
					}
				}
			} else {
				flag = true;
				break;
			}

			while (idx < board.length() && board.charAt(idx) == '.') {
				result += ".";
				idx += 1;
			}
		}

		if (flag) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}
	}
}
