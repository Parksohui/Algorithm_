import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class _21939_ { // 문제 추천 시스템 Version 1

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());
		TreeMap<Integer, TreeMap<Integer, Integer>> map = new TreeMap<>();
		HashMap<Integer, Integer> num = new HashMap<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			int p = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());

			num.put(p, l);

			if (map.containsKey(l)) {
				map.get(l).put(p, -1);
			} else {
				TreeMap<Integer, Integer> temp = new TreeMap<>();
				temp.put(p, -1);
				map.put(l, temp);
			}
		}
		int m = Integer.parseInt(bf.readLine());
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			String cmd = st.nextToken();
			if (cmd.equals("recommend")) {
				int x = Integer.parseInt(st.nextToken());
				if (x == 1) {
					bw.write(map.lastEntry().getValue().lastKey() + "\n");
				} else {
					bw.write(map.firstEntry().getValue().firstKey() + "\n");
				}

			} else if (cmd.equals("add")) {
				int p = Integer.parseInt(st.nextToken());
				int l = Integer.parseInt(st.nextToken());

				num.put(p, l);

				if (map.containsKey(l)) {
					map.get(l).put(p, -1);
				} else {
					TreeMap<Integer, Integer> temp = new TreeMap<>();
					temp.put(p, -1);
					map.put(l, temp);
				}

			} else {
				int p = Integer.parseInt(st.nextToken());
				if (num.containsKey(p)) {
					int l = num.get(p);
					map.get(l).remove(p);
					if (map.get(l).size() == 0) {
						map.remove(l);
					}
				}
			}
		}
		bw.flush();
	}
}
