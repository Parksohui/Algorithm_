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

public class _5614_ { // 問題 3

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());

			String str = st.nextToken();
			int num = Integer.parseInt(st.nextToken());

			if (map.containsKey(str)) {
				map.put(str, map.get(str) + num);
			} else {
				map.put(str, num);
			}
		}

		ArrayList<String> list = new ArrayList<>(map.keySet());

		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if (o1.length() == o2.length()) {
					return o1.compareTo(o2);
				}
				return o1.length() - o2.length();
			}
		});

		for (int i = 0; i < list.size(); i++) {
			bw.write(list.get(i) + " " + map.get(list.get(i)) + "\n");
		}

		bw.flush();
	}
}
