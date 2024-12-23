import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class _13281_ { // Look for the Winner!

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = -1;

		HashMap<Character, Integer> map = new HashMap<>();
		String result = null;
		
		while ((n = Integer.parseInt(bf.readLine())) != 0) {
			st = new StringTokenizer(bf.readLine());
			int max = -1, idx = -1;

			for (int i = 0; i < n; i++) {
				char x = st.nextToken().charAt(0);

				if (map.containsKey(x)) {
					map.replace(x, map.get(x) + 1);
				} else {
					map.put(x, 1);
				}
				if (max < map.get(x)) {
					max = map.get(x);
					result = x + "";
				}

				if (n == 1) {
					idx = 1;
					break;
				}
				List<Integer> list = new ArrayList<>(map.values());
				Collections.sort(list, Collections.reverseOrder());

				if ((list.size() > 1 && list.get(0) > list.get(1) + (n - (i + 1)))
						|| (list.size() == 1 && i == n / 2)) {
					idx = i + 1;
					break;
				}
			}
			if (idx == -1) {
				bw.write("TIE\n");
			} else {
				bw.write(result + " " + idx + "\n");
			}
			map.clear();
		}
		bw.flush();
	}
}
