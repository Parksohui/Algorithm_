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

public class _12596_ { // Odd Man Out (Large)

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(bf.readLine());

		for (int i = 0; i < N; i++) {
			int G = Integer.parseInt(bf.readLine());

			HashMap<Integer, Integer> map = new HashMap<>();
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < G; j++) {
				int C = Integer.parseInt(st.nextToken());

				if (map.containsKey(C)) {
					map.replace(C, map.get(C) + 1);
				} else {
					map.put(C, 1);
				}
			}

			ArrayList<Integer> list = new ArrayList<>(map.keySet());
			Collections.sort(list, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return map.get(o1) - map.get(o2);
				}
			});
			bw.write("Case #" + (i + 1) + ": " + list.get(0) + "\n");
		}
		bw.flush();
	}
}
