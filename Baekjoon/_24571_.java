import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _24571_ { // Good Groups

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int x = Integer.parseInt(bf.readLine());

		HashMap<String, ArrayList<String>> same = new HashMap<>();
		for (int i = 0; i < x; i++) {
			st = new StringTokenizer(bf.readLine());

			String a = st.nextToken();
			String b = st.nextToken();

			if (same.containsKey(a)) {
				same.get(a).add(b);
			} else {
				ArrayList<String> list = new ArrayList<>();
				list.add(b);

				same.put(a, list);
			}

			if (same.containsKey(b)) {
				same.get(b).add(a);
			} else {
				ArrayList<String> list = new ArrayList<>();
				list.add(a);

				same.put(b, list);
			}
		}

		int y = Integer.parseInt(bf.readLine());

		HashMap<String, ArrayList<String>> diff = new HashMap<>();
		for (int i = 0; i < y; i++) {
			st = new StringTokenizer(bf.readLine());

			String a = st.nextToken();
			String b = st.nextToken();

			if (diff.containsKey(a)) {
				diff.get(a).add(b);
			} else {
				ArrayList<String> list = new ArrayList<>();
				list.add(b);

				diff.put(a, list);
			}

			if (diff.containsKey(b)) {
				diff.get(b).add(a);
			} else {
				ArrayList<String> list = new ArrayList<>();
				list.add(a);

				diff.put(b, list);
			}
		}

		int g = Integer.parseInt(bf.readLine());

		int result = 0;
		for (int i = 0; i < g; i++) {
			st = new StringTokenizer(bf.readLine());

			ArrayList<String> list = new ArrayList<>();

			while (st.hasMoreTokens()) {
				list.add(st.nextToken());
			}

			for (int j = 0; j < list.size(); j++) {
				ArrayList<Integer> temp = new ArrayList<>();
				if (same.containsKey(list.get(j))) {
					for (int k = 0; k < same.get(list.get(j)).size(); k++) {
						if (!list.contains(same.get(list.get(j)).get(k))) {
							result += 1;
							temp.add(k);
						}
					}
					for (int k = temp.size() - 1; k >= 0; k--) {
						same.get(same.get(list.get(j)).get(temp.get(k))).remove(list.get(j));
						same.get(list.get(j)).remove(temp.get(k));
					}
				}

				temp.clear();
				if (diff.containsKey(list.get(j))) {
					for (int k = 0; k < diff.get(list.get(j)).size(); k++) {
						if (list.contains(diff.get(list.get(j)).get(k))) {
							result += 1;
							temp.add(k);
						}
					}
					for (int k = temp.size() - 1; k >= 0; k--) {
						diff.get(diff.get(list.get(j)).get(temp.get(k))).remove(list.get(j));
						diff.get(list.get(j)).remove(temp.get(k));
					}
				}
			}
		}
		System.out.println(result);
	}
}
