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

public class _14184_ { // IOI 2017 Logo

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = 0;

		while ((n = Integer.parseInt(bf.readLine())) != 0) {
			HashMap<Integer, int[]> map = new HashMap<>();

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(bf.readLine());
				int d = Integer.parseInt(st.nextToken());

				for (int j = 0; j < d; j++) {
					int id = Integer.parseInt(st.nextToken());

					if (map.containsKey(id)) {
						map.get(id)[j] += (3 - j);
						map.get(id)[3] += (3 - j);
					} else {
						int[] arr = new int[4];
						arr[j] += (3 - j);
						arr[3] += (3 - j);
						map.put(id, arr);
					}
				}
			}
			ArrayList<Integer> list = new ArrayList<>(map.keySet());
			Collections.sort(list, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					if (map.get(o2)[3] == map.get(o1)[3]) {
						if (map.get(o2)[0] == map.get(o1)[0]) {
							return map.get(o2)[1] - map.get(o1)[1];
						}
						return map.get(o2)[0] - map.get(o1)[0];
					}
					return map.get(o2)[3] - map.get(o1)[3];
				}
			});

			ArrayList<Integer> result = new ArrayList<>();
			result.add(list.get(0));

			for (int i = 1; i < list.size(); i++) {
				if (map.get(list.get(0))[3] == map.get(list.get(i))[3]
						&& map.get(list.get(0))[0] == map.get(list.get(i))[0]
						&& map.get(list.get(0))[1] == map.get(list.get(i))[1]) {
					result.add(list.get(i));
				} else {
					break;
				}
			}

			Collections.sort(result);
			for (int i = 0; i < result.size(); i++) {
				bw.write(result.get(i) + " ");
			}
			bw.write("\n");
		}
		bw.flush();
	}
}
