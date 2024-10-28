import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class _10527_ { // Judging Troubles

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());

		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			String str = bf.readLine();
			if (map.containsKey(str)) {
				map.replace(str, map.get(str) + 1);
			} else {
				map.put(str, 1);
			}
		}

		int result = 0;
		for (int i = 0; i < n; i++) {
			String str = bf.readLine();
			if (map.containsKey(str)) {
				result += 1;
				if (map.get(str) - 1 == 0) {
					map.remove(str);
				} else {
					map.replace(str, map.get(str) - 1);
				}
			}
		}
		System.out.println(result);
	}
}
