import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class _3022_ { // PRASE

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());

		HashMap<String, Integer> map = new HashMap<>();

		int result = 0;

		for (int i = 0; i < n; i++) {
			String name = bf.readLine();

			if (map.containsKey(name)) {
				if (i  - map.get(name) < map.get(name)) {
					result += 1;
				}
				map.replace(name, map.get(name) + 1);
			} else {
				map.put(name, 1);
			}
		}
		System.out.println(result);
	}
}
