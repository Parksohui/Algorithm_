import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;

public class _11652_ { // 카드

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());
		HashMap<Long, Integer> map = new HashMap<>();

		long num = 0;
		for (int i = 0; i < n; i++) {
			num = Long.parseLong(bf.readLine());
			if (map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
			} else {
				map.put(num, 1);
			}
		}

		long result_key = num;
		int result_value = map.get(num);

		for (Entry<Long, Integer> entry : map.entrySet()) {
			long key = entry.getKey();
			int value = entry.getValue();

			if (value == result_value) {
				if (result_key > key) {
					result_key = key;
				}
			} else if (value > result_value) {
				result_key = key;
				result_value = value;
			}
		}
		System.out.println(result_key);
	}
}
