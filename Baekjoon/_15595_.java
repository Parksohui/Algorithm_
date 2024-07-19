import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class _15595_ { // 정답 비율 계산하기

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(bf.readLine());

		HashMap<String, Integer> map = new HashMap<>();
		Set<String> set = new HashSet<>();
		int numerator = 0, denominator = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());

			st.nextToken();
			String id = st.nextToken();
			int result = Integer.parseInt(st.nextToken());

			if (id.equals("megalusion")) {
				continue;
			}
			if (result == 4) {
				if (!set.contains(id)) {
					if (map.containsKey(id)) {
						denominator += map.get(id) + 1;
					} else {
						denominator += 1;
					}
					set.add(id);
					numerator += 1;
				}
			} else {
				if (!map.containsKey(id)) {
					map.put(id, 1);
				} else {
					map.replace(id, map.get(id) + 1);
				}
			}
		}
		if (denominator == 0) {
			System.out.println(0);
		} else {
			System.out.println(((double) numerator / denominator) * 100);
		}
	}
}
