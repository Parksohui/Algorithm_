import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.io.IOException;

public class _31047_ { // Warehouse

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(bf.readLine());

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(bf.readLine());

			HashMap<String, Integer> map = new HashMap<>();
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(bf.readLine());

				String name = st.nextToken();
				int m = Integer.parseInt(st.nextToken());

				if (map.containsKey(name)) {
					map.replace(name, map.get(name) + m);
				} else {
					map.put(name, m);
				}
			}

			ArrayList<String> list = new ArrayList<>(map.keySet());
			Collections.sort(list, new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					if (map.get(o1) == map.get(o2)) {
						return o1.compareTo(o2);
					}
					return map.get(o2) - map.get(o1);
				}
			});

			bw.write(list.size() + "\n");
			for (int j = 0; j < list.size(); j++) {
				bw.write(list.get(j) + " " + map.get(list.get(j)) + "\n");
			}
		}
		bw.flush();
	}
}
