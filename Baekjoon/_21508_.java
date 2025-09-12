import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _21508_ { // Список школ

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());

			String num = "";
			boolean flag = false;
			while (st.hasMoreTokens()) {
				String str = st.nextToken();

				for (int j = 0; j < str.length(); j++) {
					if (Character.isDigit(str.charAt(j))) {
						num += str.charAt(j);
						flag = true;
					} else {
						if (flag) {
							break;
						}
					}
				}
				if (flag) {
					break;
				}
			}
			if (map.containsKey(num)) {
				map.replace(num, map.get(num) + 1);
			} else {
				map.put(num, 1);
			}
		}

		ArrayList<String> result = new ArrayList<>();
		for (String i : map.keySet()) {
			if (map.get(i) <= 5) {
				result.add(i);
			}
		}

		bw.write(result.size() + "\n");
		for (String i : result) {
			bw.write(i + "\n");
		}
		bw.flush();
	}
}
