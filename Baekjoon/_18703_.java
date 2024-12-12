import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class _18703_ { // Duplicate Files

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int t = Integer.parseInt(bf.readLine());

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(bf.readLine());

			Map<String, Integer> map = new HashMap<>();
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(bf.readLine());

				String str = st.nextToken();
				int num = Integer.parseInt(st.nextToken());

				if (map.containsKey(str)) {
					if (map.get(str) > num) {
						map.replace(str, num);
					}
				} else {
					map.put(str, num);
				}
			}
			List<Integer> list = new ArrayList<>(map.values());
			Collections.sort(list);

			for (int j = 0; j < list.size(); j++) {
				bw.write(list.get(j) + " ");
			}
			bw.write("\n");
		}
		bw.flush();
	}
}
