import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.StringTokenizer;

public class _15465_ { // Milk Measurement
	static class Cow {
		private String name;
		private int milk;
		private int day;

		public Cow(String name, int milk) {
			this.name = name;
			this.milk = milk;
		}

		public Cow(String name, int milk, int day) {
			this.name = name;
			this.milk = milk;
			this.day = day;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		ArrayList<Cow> list = new ArrayList<>();
		list.add(new Cow("Bessie", 7));
		list.add(new Cow("Elsie", 7));
		list.add(new Cow("Mildred", 7));

		ArrayList<Cow> cmd = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());

			int day = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			int milk = Integer.parseInt(st.nextToken());

			cmd.add(new Cow(name, milk, day));
		}

		Collections.sort(cmd, new Comparator<Cow>() {
			@Override
			public int compare(Cow o1, Cow o2) {
				return o1.day - o2.day;
			}
		});

		int result = 0;
		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				if (list.get(j).name.equals(cmd.get(i).name)) {
					list.get(j).milk += cmd.get(i).milk;
					break;
				}
			}
			Collections.sort(list, new Comparator<Cow>() {
				@Override
				public int compare(Cow o1, Cow o2) {
					return o2.milk - o1.milk;
				}
			});

			boolean flag = false;
			for (int j = 0; j < 3; j++) {
				if (list.get(j).milk == list.get(0).milk) {
					if (!set.contains(list.get(j).name)) {
						flag = true;
						set.add(list.get(j).name);
					}
				} else {
					if (set.contains(list.get(j).name)) {
						flag = true;
						set.remove(list.get(j).name);
					}
				}
			}
			if (flag) {
				result += 1;
			}
		}
		System.out.println(result);
	}
}
