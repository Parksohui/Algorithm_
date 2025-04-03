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

public class _15237_ { // Cipher

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(bf.readLine());

		HashMap<Integer, int[]> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());

			if (map.containsKey(num)) {
				map.get(num)[1] += 1;
			} else {
				int arr[] = { i, 1 };
				map.put(num, arr);
			}
		}

		ArrayList<Integer> list = new ArrayList<>(map.keySet());
		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (map.get(o1)[1] == map.get(o2)[1]) {
					return map.get(o1)[0] - map.get(o2)[0];
				}
				return map.get(o2)[1] - map.get(o1)[1];
			}
		});

		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < map.get(list.get(i))[1]; j++) {
				bw.write(list.get(i) + " ");
			}
		}
		bw.flush();
	}
}
