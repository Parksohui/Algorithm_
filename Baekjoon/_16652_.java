import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _16652_ { // Email Destruction

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(bf.readLine());

			int cnt = 0;
			while (st.hasMoreTokens()) {
				String str = st.nextToken();

				if (str.equals("Re:")) {
					cnt += 1;
				} else {
					if (map.containsKey(str)) {
						if (map.get(str) < cnt) {
							map.replace(str, cnt);
						}
					} else {
						map.put(str, cnt);
					}
				}
			}
		}
		int result = 0;
		for (String str : map.keySet()) {
			result += (map.get(str) + 1);
		}

		if (result <= n) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}
