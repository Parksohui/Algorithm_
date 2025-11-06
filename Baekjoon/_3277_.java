import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class _3277_ { // DOMAINS

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(bf.readLine());

		HashMap<String, Integer> map = new HashMap<>();

		for (int i = 0; i < n; i++) {
			String address = bf.readLine().replace("http://", "");

			String temp[] = address.split("\\.");

			String result = temp[temp.length - 1].split("/")[0];

			if (map.containsKey(result)) {
				map.replace(result, map.get(result) + 1);
			} else {
				map.put(result, 1);
			}
		}

		ArrayList<String> list = new ArrayList<>(map.keySet());
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return map.get(o2) - map.get(o1);
			}
		});

		bw.write(map.get(list.get(0)) + "\n");

		for (int i = 0; i < list.size(); i++) {
			if (map.get(list.get(i)) == map.get(list.get(0))) {
				bw.write(list.get(i) + " ");
			}
		}
		bw.flush();
	}
}
