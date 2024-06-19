import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _5002_ { // 도어맨

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int x = Integer.parseInt(bf.readLine());

		String str = bf.readLine();
		int w = 0, m = 0, idx1 = 0, idx2 = 1;

		while (Math.abs(m - w) <= x && x != 0) {
			if (idx1 == 0) {
				if (str.charAt(0) == 'M') {
					m += 1;
				} else {
					w += 1;
				}
				idx1 = idx2 + 1;
			}

			if (Math.abs(m - w) > x || (idx1 >= str.length() && idx2 >= str.length())) {
				break;
			}

			boolean flag = false;
			if (m > w) {
				if (idx1 < str.length() && w + 1 - m <= x && str.charAt(idx1) == 'W') {
					flag = true;
					w += 1;
					idx1 = Math.max(idx1, idx2) + 1;
				} else if (idx2 < str.length() && w + 1 - m <= x && str.charAt(idx2) == 'W') {
					flag = true;
					w += 1;
					idx2 = Math.max(idx1, idx2) + 1;
				} else if (idx1 < str.length() && m + 1 - w <= x && str.charAt(idx1) == 'M') {
					flag = true;
					m += 1;
					idx1 = Math.max(idx1, idx2) + 1;
				} else if (idx2 < str.length() && m + 1 - w <= x && str.charAt(idx2) == 'M') {
					flag = true;
					m += 1;
					idx2 = Math.max(idx1, idx2) + 1;
				}
			} else {
				if (idx1 < str.length() && m + 1 - w <= x && str.charAt(idx1) == 'M') {
					flag = true;
					m += 1;
					idx1 = Math.max(idx1, idx2) + 1;
				} else if (idx2 < str.length() && m + 1 - w <= x && str.charAt(idx2) == 'M') {
					flag = true;
					m += 1;
					idx2 = Math.max(idx1, idx2) + 1;
				} else if (idx1 < str.length() && w + 1 - m <= x && str.charAt(idx1) == 'W') {
					flag = true;
					w += 1;
					idx1 = Math.max(idx1, idx2) + 1;
				} else if (idx2 < str.length() && w + 1 - m <= x && str.charAt(idx2) == 'W') {
					flag = true;
					w += 1;
					idx2 = Math.max(idx1, idx2) + 1;
				}
			}
			if (!flag) {
				break;
			}
		}
		System.out.println(m + w);
	}
}
