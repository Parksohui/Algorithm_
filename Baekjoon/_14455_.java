import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _14455_ { // Don't Be Last!

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(bf.readLine());

		HashMap<String, Integer> map = new HashMap<>();
		map.put("Bessie", 0);
		map.put("Elsie", 0);
		map.put("Daisy", 0);
		map.put("Gertie", 0);
		map.put("Annabelle", 0);
		map.put("Maggie", 0);
		map.put("Henrietta", 0);

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());

			String name = st.nextToken();
			map.replace(name, map.get(name) + Integer.parseInt(st.nextToken()));
		}

		ArrayList<String> list = new ArrayList<>(map.keySet());
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return map.get(o1).compareTo(map.get(o2));
			}
		});

		int min = -1;
		boolean flag = false;
		String result = "";
		for (int i = 0; i < list.size(); i++) {
			if (map.get(list.get(i)) != map.get(list.get(0)) && min == -1) {
				min = map.get(list.get(i));
				result = list.get(i);
			} else if (map.get(list.get(i)) == min) {
				flag = true;
				break;
			}
		}

		if (min == -1 || flag) {
			System.out.println("Tie");
		} else {
			System.out.println(result);
		}
	}
}
