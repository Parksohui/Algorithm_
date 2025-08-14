import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class _6770_ { // Absolutely Acidic

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bf.readLine());

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(bf.readLine());
			if (map.containsKey(num)) {
				map.replace(num, map.get(num) + 1);
			} else {
				map.put(num, 1);
			}
		}

		ArrayList<Integer> list = new ArrayList<>(map.keySet());
		Collections.sort(list, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				if (map.get(o1) == map.get(o2)) {
					return o2 - o1;
				}
				return map.get(o2) - map.get(o1);
			}
		});

		int max = list.get(0), value = map.get(list.get(1)), min = list.get(1), diff = Math.abs(max - min);

		for (int i = 2; i < list.size(); i++) {
			if (map.get(list.get(i)) == value && Math.abs(max - list.get(i)) > diff) {
				diff = Math.abs(max - list.get(i));
				min = list.get(i);
			}
		}
		System.out.println(Math.abs(max - min));
	}
}
