import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class _18294_ { // Biodiversity

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());

		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			String species = bf.readLine();
			if (map.containsKey(species)) {
				map.replace(species, map.get(species) + 1);
			} else {
				map.put(species, 1);
			}
		}

		List<String> key = new ArrayList<>(map.keySet());
		key.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return map.get(o2).compareTo(map.get(o1));
			}
		});

		int num = map.get(key.get(0));
		int sum = 0;
		for (int i = 1; i < key.size(); i++) {
			sum += map.get(key.get(i));
			if (sum >= num) {
				break;
			}
		}

		if (sum >= num) {
			System.out.println("NONE");
		} else {
			System.out.println(key.get(0));
		}
	}
}
