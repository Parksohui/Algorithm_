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

public class _29882_ { // Ranking
	static class Solution {
		private String task;
		private int point;

		public Solution(String task, int point) {
			this.task = task;
			this.point = point;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		HashMap<String, ArrayList<Solution>> map = new HashMap<>();
		HashMap<String, Integer> result = new HashMap<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());

			String name = st.nextToken();
			String task = st.nextToken();
			int point = Integer.parseInt(st.nextToken());

			if (map.containsKey(name)) {
				ArrayList<Solution> list = map.get(name);
				boolean flag = false;

				for (int j = 0; j < list.size(); j++) {
					if (list.get(j).task.equals(task)) {
						flag = true;
						if (list.get(j).point < point) {
							result.put(name, result.get(name) - list.get(j).point + point);
							list.get(j).point = point;
						}
					}
				}
				if (!flag) {
					result.put(name, result.get(name) + point);
					map.get(name).add(new Solution(task, point));
				}

			} else {
				ArrayList<Solution> list = new ArrayList<>();
				list.add(new Solution(task, point));

				map.put(name, list);
				result.put(name, point);
			}
		}
		ArrayList<String> answer = new ArrayList<>(result.keySet());
		Collections.sort(answer, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return result.get(o2) - result.get(o1);
			}
		});

		for (String name : answer) {
			bw.write(name + " " + result.get(name) + "\n");
		}
		bw.flush();
	}
}
