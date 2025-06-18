import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _9512_ { // Languages

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(bf.readLine());
		HashMap<String, String> map = new HashMap<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());

			String language = st.nextToken();

			while (st.hasMoreTokens()) {
				map.put(st.nextToken().toLowerCase(), language);
			}
		}

		String str = "";
		while ((str = bf.readLine()) != null) {
			st = new StringTokenizer(str);
			boolean flag = false;

			while (st.hasMoreTokens()) {
				String word = st.nextToken().toLowerCase();

				int start = 0, end = 0;
				while (start < word.length() && end < word.length()) {
					if (Character.isAlphabetic(word.charAt(end)) || word.charAt(end) == '\''
							|| word.charAt(end) == '-') {
						end++;
					} else {
						String temp = word.substring(start, end);
						start = end + 1;
						end = start;

						if (map.containsKey(temp)) {
							bw.write(map.get(temp) + "\n");
							flag = true;
							break;
						}
					}
				}
				if (!flag) {
					String temp = word.substring(start, end);
					if (map.containsKey(temp)) {
						bw.write(map.get(temp) + "\n");
						break;
					}
				}
			}
		}
		bw.flush();
	}
}
