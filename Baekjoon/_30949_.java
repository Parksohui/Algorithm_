import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class _30949_ { // Equal Schedules

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		String str = "";

		HashMap<String, Integer> map = new HashMap<>();

		boolean flag = false;
		while (!(str = bf.readLine()).equals("======")) {
			if (str.equals("------")) {
				flag = true;
				continue;
			}

			st = new StringTokenizer(str);
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			String name = st.nextToken();

			if (flag) {
				if (map.containsKey(name)) {
					map.replace(name, map.get(name) + (y - x));
				} else {
					map.put(name, y - x);
				}
			} else {
				if (map.containsKey(name)) {
					map.replace(name, map.get(name) - (y - x));
				} else {
					map.put(name, -(y - x));
				}
			}
		}

		Set<String> set = new HashSet<>(map.keySet());
		for (String name : set) {
			if (map.get(name) == 0) {
				map.remove(name);
			}
		}

		if (map.size() == 0) {
			bw.write("No differences found.");
		} else {
			ArrayList<String> list = new ArrayList<>(map.keySet());
			Collections.sort(list);

			for (String name : list) {
				bw.write(name + " ");
				if (map.get(name) > 0) {
					bw.write("+" + map.get(name) + "\n");
				} else {
					bw.write(map.get(name) + "\n");
				}
			}
		}
		bw.flush();
	}
}
