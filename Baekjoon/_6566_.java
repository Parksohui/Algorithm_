import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

public class _6566_ { // 애너그램 그룹

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = "";

		HashMap<String, ArrayList<String>> map = new HashMap<>();

		while ((str = bf.readLine()) != null) {
			char[] arr = str.toCharArray();

			Arrays.sort(arr);

			String key = new String(arr);
			if (map.containsKey(key)) {
				map.get(key).add(str);
			} else {
				ArrayList<String> set = new ArrayList<>();
				set.add(str);

				map.put(key, set);
			}
		}

		for (String key : map.keySet()) {
			Collections.sort(map.get(key));
		}

		ArrayList<String> list = new ArrayList<>(map.keySet());
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (map.get(o2).size() == map.get(o1).size()) {
					return map.get(o1).get(0).compareTo(map.get(o2).get(0));
				}
				return map.get(o2).size() - map.get(o1).size();
			}
		});

		for (int i = 0; i < Math.min(5, list.size()); i++) {

			bw.write("Group of size " + map.get(list.get(i)).size() + ": ");

			HashSet<String> set = new HashSet<>();
			for (int j = 0; j < map.get(list.get(i)).size(); j++) {
				set.add(map.get(list.get(i)).get(j));
			}

			ArrayList<String> result = new ArrayList<>(set);
			Collections.sort(result);

			for (int j = 0; j < result.size(); j++) {
				bw.write(result.get(j) + " ");
			}
			bw.write(".\n");
		}
		bw.flush();
	}
}
