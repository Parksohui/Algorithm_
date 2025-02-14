import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class _15044_ { // Fase

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());
		int k = Integer.parseInt(bf.readLine());

		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(Integer.parseInt(bf.readLine()));
		}

		Collections.sort(list, Collections.reverseOrder());

		int result = 0, num = list.get(0);
		for (int i = 0; i < n; i++) {
			if (num == list.get(i)) {
				result += 1;
			} else {
				if (result >= k) {
					break;
				}
				num = list.get(i);
				result += 1;
			}
		}
		System.out.println(result);
	}
}
