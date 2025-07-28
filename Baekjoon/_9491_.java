import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _9491_ { // Politics

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		String str = "";

		while ((str = bf.readLine()) != null) {
			st = new StringTokenizer(str);

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			ArrayList<String> list = new ArrayList<>();
			HashMap<String, ArrayList<String>> map = new HashMap<>();

			for (int i = 0; i < n; i++) {
				String name = bf.readLine();

				list.add(name);
				map.put(name, new ArrayList<>());
			}

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(bf.readLine());

				String supporter = st.nextToken();
				String cadidate = st.nextToken();

				if (map.containsKey(cadidate)) {
					map.get(cadidate).add(supporter);
				} else {
					list.add(cadidate);
					map.put(cadidate, new ArrayList<>());
					map.get(cadidate).add(supporter);
				}
			}

			for (int i = 0; i < list.size(); i++) {
				for (int j = 0; j < map.get(list.get(i)).size(); j++) {
					bw.write(map.get(list.get(i)).get(j) + "\n");
				}
			}
		}
		bw.flush();
	}
}
