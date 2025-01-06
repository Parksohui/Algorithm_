import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _5104_ { // NoMoPhobia

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		HashMap<String, Integer> table = new HashMap<>();
		table.put("TT", 75);
		table.put("TX", 50);
		table.put("PR", 80);
		table.put("RT", 30);
		table.put("AP", 25);
		table.put("PX", 60);

		HashMap<String, Integer> map = new HashMap<>();

		int w, n;
		while ((w = Integer.parseInt(st.nextToken())) != 0 && (n = Integer.parseInt(st.nextToken())) != 0) {
			ArrayList<String> names = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(bf.readLine());
				String name = st.nextToken();
				String code = st.nextToken();

				if (map.containsKey(name)) {
					map.replace(name, map.get(name) + table.get(code));
				} else {
					names.add(name);
					map.put(name, table.get(code));
				}
			}

			bw.write("Week " + w + " ");
			boolean flag = false;
			for (int i = 0; i < names.size(); i++) {
				if (map.get(names.get(i)) >= 100) {
					if (flag) {
						bw.write(",");
					}
					bw.write(names.get(i));
					flag = true;
				}
			}

			if (!flag) {
				bw.write("No phones confiscated");
			}
			bw.write("\n");
			st = new StringTokenizer(bf.readLine());
			map.clear();
		}
		bw.flush();
	}
}
