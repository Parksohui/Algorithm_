import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _4408_ { // Election

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		HashMap<String, String> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			String name = bf.readLine();
			String party = bf.readLine();

			map.put(name, party);
		}

		int m = Integer.parseInt(bf.readLine());

		HashMap<String, Integer> election = new HashMap<>();
		for (int i = 0; i < m; i++) {
			String name = bf.readLine();

			if (map.containsKey(name)) {
				if (election.containsKey(name)) {
					election.put(name, election.get(name) + 1);
				} else {
					election.put(name, 1);
				}
			}
		}

		ArrayList<String> names = new ArrayList<>(election.keySet());
		Collections.sort(names, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return election.get(o2).compareTo(election.get(o1));
			}
		});

		if (names.size() == 0) {
			System.out.println("tie");
		} else if (names.size() == 1) {
			System.out.println(map.get(names.get(0)));
		} else {
			if (election.get(names.get(0)) == election.get(names.get(1))) {
				System.out.println("tie");
			} else {
				System.out.println(map.get(names.get(0)));
			}
		}
	}
}
