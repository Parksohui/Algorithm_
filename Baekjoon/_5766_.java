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

public class _5766_ { // 할아버지는 유명해!

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n, m;
		st = new StringTokenizer(bf.readLine());
		HashMap<Integer, Integer> map = new HashMap<>();

		while ((n = Integer.parseInt(st.nextToken())) != 0 && (m = Integer.parseInt(st.nextToken())) != 0) {
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(bf.readLine());
				for (int j = 0; j < m; j++) {
					int num = Integer.parseInt(st.nextToken());
					if (map.containsKey(num)) {
						map.replace(num, map.get(num) + 1);
					} else {
						map.put(num, 1);
					}
				}
			}
			ArrayList<int[]> list = new ArrayList<>();
			for (int key : map.keySet()) {
				list.add(new int[] { key, map.get(key) });
			}
			Collections.sort(list, new Comparator<int[]>() {

				@Override
				public int compare(int[] o1, int[] o2) {
					if (o2[1] == o1[1]) {
						return o1[0] - o2[0];
					}
					return o2[1] - o1[1];
				}
			});

			int max = list.get(0)[1], cnt = 0;
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i)[1] != max) {
					if (cnt == 0)
						cnt = list.get(i)[1];
					if (cnt == list.get(i)[1])
						bw.write(list.get(i)[0] + " ");
				}
			}
			st = new StringTokenizer(bf.readLine());
			map.clear();
			bw.write("\n");
		}
		bw.flush();
	}
}
