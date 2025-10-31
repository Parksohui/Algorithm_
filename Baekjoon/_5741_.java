import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _5741_ { // Soccer League

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = 0;

		while ((n = Integer.parseInt(bf.readLine())) != 0) {
			HashMap<String, int[]> map = new HashMap<>();

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(bf.readLine());

				String club1 = st.nextToken();
				int x = Integer.parseInt(st.nextToken());
				st.nextToken();
				int y = Integer.parseInt(st.nextToken());
				String club2 = st.nextToken();

				if (!map.containsKey(club1)) {
					map.put(club1, new int[] { 0, 0 });
				}
				if (!map.containsKey(club2)) {
					map.put(club2, new int[] { 0, 0 });
				}

				if (x > y) {
					map.get(club1)[0] += 3;
					map.get(club1)[1] += (x - y);
					map.get(club2)[1] += (y - x);
				} else if (x < y) {
					map.get(club2)[0] += 3;
					map.get(club1)[1] += (x - y);
					map.get(club2)[1] += (y - x);
				} else {
					map.get(club1)[0] += 1;
					map.get(club2)[0] += 1;
				}
			}
			ArrayList<String> result = new ArrayList<>(map.keySet());
			Collections.sort(result, new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					if (map.get(o2)[0] == map.get(o1)[0]) {
						return map.get(o2)[1] - map.get(o1)[1];
					}
					return map.get(o2)[0] - map.get(o1)[0];
				}
			});

			for (String club : result) {
				bw.write(map.get(club)[0] + " " + club + "\n");
			}
			bw.write("\n");
		}
		bw.flush();
	}
}
