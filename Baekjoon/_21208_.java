import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _21208_ { // Gratitude
	static class Info implements Comparable<Info> {
		private String item;
		private int num;
		private int recent;

		public Info(int num, int recent) {
			this.num = num;
			this.recent = recent;
		}

		@Override
		public int compareTo(Info o) {
			if (this.num == o.num) {
				return o.recent - this.recent;
			}
			return o.num - this.num;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		HashMap<String, Info> map = new HashMap<>();
		for (int i = 0; i < 3 * n; i++) {
			String str = bf.readLine();
			if (map.containsKey(str)) {
				Info info = map.get(str);
				info.num += 1;
				info.recent = i;
			} else {
				map.put(str, new Info(1, i));
			}
		}

		ArrayList<Info> list = new ArrayList<>();

		for (String str : map.keySet()) {
			Info info = map.get(str);
			info.item = str;
			list.add(info);
		}
		Collections.sort(list);

		for (int i = 0; i < k; i++) {
			if (i >= list.size()) {
				break;
			}
			bw.write(list.get(i).item + "\n");
		}
		bw.flush();
	}
}
