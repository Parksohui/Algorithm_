import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.regex.Pattern;

public class _9996_ { // 한국이 그리울 땐 서버에 접속하지

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(bf.readLine());

		String str = bf.readLine();
		String pattern = "^";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != '*') {
				pattern += str.charAt(i);
			} else {
				pattern += "[a-z]*";
			}
		}
		pattern += "$";

		for (int i = 0; i < N; i++) {
			String name = bf.readLine();
			if (Pattern.matches(pattern, name)) {
				bw.write("DA\n");
			} else {
				bw.write("NE\n");
			}
		}
		bw.flush();
	}
}
