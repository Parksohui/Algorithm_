import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _4351_ { // Hay Points

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());

			map.put(st.nextToken(), Integer.parseInt(st.nextToken()));
		}

		int t = 0, result = 0;
		while (t < m) {
			String str = bf.readLine();
			if (str.equals(".")) {
				t += 1;
				bw.write(result + "\n");
				result = 0;
			} else {
				st = new StringTokenizer(str);
				while (st.hasMoreTokens()) {
					String word = st.nextToken();
					if (map.containsKey(word)) {
						result += map.get(word);
					}
				}
			}
		}
		bw.flush();
	}
}
