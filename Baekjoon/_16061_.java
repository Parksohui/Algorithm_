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

public class _16061_ { // You Are Fired!

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());

			String s = st.nextToken();
			int c = Integer.parseInt(st.nextToken());

			map.put(s, c);
		}

		ArrayList<String> list = new ArrayList<>(map.keySet());
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return map.get(o2) - map.get(o1);
			}
		});

		int result = 0;
		ArrayList<String> answer = new ArrayList<>();

		for (int i = 0; i < k; i++) {
			d -= map.get(list.get(i));
			answer.add(list.get(i));
			result += 1;

			if (d <= 0) {
				break;
			}
		}

		if (d > 0) {
			bw.write("impossible");
		} else {
			bw.write(result + "\n");
			for (int i = 0; i < answer.size(); i++) {
				bw.write(answer.get(i) + ", YOU ARE FIRED!\n");
			}
		}
		bw.flush();
	}
}
