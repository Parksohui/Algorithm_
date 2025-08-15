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

public class _8641_ { // Sklep

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		HashMap<Integer, int[]> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());

			int a = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			if (map.containsKey(a)) {
				map.get(a)[1] += k;
			} else {
				map.put(a, new int[] { i, k });
			}
		}

		ArrayList<Integer> list = new ArrayList<>(map.keySet());
		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return map.get(o1)[0] - map.get(o2)[0];
			}
		});

		bw.write(list.size() + "\n");
		for (int i = 0; i < list.size(); i++) {
			bw.write(list.get(i) + " " + map.get(list.get(i))[1] + "\n");
		}
		bw.flush();
	}
}
