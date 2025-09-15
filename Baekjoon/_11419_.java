import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _11419_ { // Olympic Parade

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < n; i++) {
			int id = Integer.parseInt(bf.readLine());

			if (map.containsKey(id)) {
				map.replace(id, map.get(id) + 1);
			} else {
				map.put(id, 1);
			}
		}

		for (int id : map.keySet()) {
			if (map.get(id) % k != 0) {
				System.out.println(id);
				break;
			}
		}
	}
}
