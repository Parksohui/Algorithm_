import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class _9357_ { // Eligibility

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine());

		HashMap<String, HashSet<String>> map = new HashMap<>();
		for (int i = 0; i < t; i++) {
			bw.write("Case #" + (i + 1) + ":\n");
			int n = Integer.parseInt(bf.readLine());
			for (int j = 0; j < n; j++) {
				String str = bf.readLine();

				String name = "";
				String year = "";

				for (int k = 0; k < str.length(); k++) {
					if (!Character.isDigit(str.charAt(k))) {
						name += str.charAt(k);
					} else {
						year += str.charAt(k);
					}
				}

				if (map.containsKey(name)) {
					map.get(name).add(year);
				} else {
					HashSet<String> set = new HashSet<>();
					set.add(year);
					map.put(name, set);
				}

			}
			ArrayList<String> list = new ArrayList<>();
			for (String name : map.keySet()) {
				if (map.get(name).size() < 5) {
					list.add(name);
				}
			}
			Collections.sort(list);
			for (String name : list) {
				bw.write(name + "\n");
			}
			map.clear();
		}
		bw.flush();
	}
}
