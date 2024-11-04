import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class _11235_ { // Polling

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());

		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			String str = bf.readLine();
			if (map.containsKey(str)) {
				map.replace(str, map.get(str) + 1);
			} else {
				map.put(str, 1);
			}
		}

		ArrayList<String> key = new ArrayList<>(map.keySet());
		Collections.sort(key, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (map.get(o2) == map.get(o1)) {
					return o1.compareTo(o2);
				}
				return map.get(o2) - map.get(o1);
			}
		});

		for (String name : key) {
			if (map.get(name) == map.get(key.get(0))) {
				System.out.println(name);
			} else {
				break;
			}
		}
	}
}
