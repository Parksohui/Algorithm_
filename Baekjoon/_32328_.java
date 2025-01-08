import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class _32328_ { // Bronze Count

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());

		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			int score = Integer.parseInt(bf.readLine());

			if (map.containsKey(score)) {
				map.replace(score, map.get(score) + 1);
			} else {
				map.put(score, 1);
			}
		}

		ArrayList<Integer> list = new ArrayList<>(map.keySet());
		Collections.sort(list, Collections.reverseOrder());

		System.out.println(list.get(2) + " " + map.get(list.get(2)));
	}
}
