import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class _11068_ { // 회문인 수

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(bf.readLine());

		for (int i = 0; i < T; i++) {
			String str = bf.readLine();

			boolean flag = false;
			for (int j = 0; j <= str.length() / 2; j++) {
				if (str.charAt(j) != str.charAt(str.length() - 1 - j)) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				bw.write("1\n");
			} else {
				for (int j = 2; j <= 64; j++) {
					if (j == 10) {
						continue;
					}
					flag = false;

					int num = Integer.parseInt(str);
					ArrayList<Integer> list = new ArrayList<>();
					while (num != 0) {
						list.add(num % j);
						num /= j;
					}

					for (int k = 0; k <= list.size() / 2; k++) {
						if (list.get(k) != list.get(list.size() - 1 - k)) {
							flag = true;
							break;
						}
					}
					if (!flag) {
						bw.write("1\n");
						break;
					}
				}
				if (flag) {
					bw.write("0\n");
				}
			}
		}
		bw.flush();
	}
}
