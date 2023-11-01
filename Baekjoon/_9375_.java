import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _9375_ { // 패션왕 신해빈

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int t = Integer.parseInt(bf.readLine());
		HashMap<String, ArrayList<String>> map = new HashMap<>();

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(bf.readLine());
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(bf.readLine());
				String name = st.nextToken();
				String type = st.nextToken();
				if (map.containsKey(type)) {
					ArrayList<String> arr = map.get(type);
					arr.add(name);
					map.replace(type, arr);
				} else {
					ArrayList<String> arr = new ArrayList<>();
					arr.add(name);
					map.put(type, arr);
				}
			}
			int result = 1;
			for (String key : map.keySet()) {
				int size = map.get(key).size() + 1;
				result *= size;
			}
			bw.write(result - 1 + "\n");
			map.clear();
		}
		bw.flush();
	}
}
