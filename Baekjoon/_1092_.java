import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class _1092_ { // 배

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		Integer arr[] = new Integer[n];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int m = Integer.parseInt(bf.readLine());

		st = new StringTokenizer(bf.readLine());
		ArrayList<Integer> box = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			box.add(Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(arr, Collections.reverseOrder());
		box.sort(Collections.reverseOrder());

		if (box.get(0) > arr[0]) {
			System.out.println(-1);
		} else {
			int result = 0;
			int idx = 0;

			while (!box.isEmpty()) {
				if (idx == 0) {
					result += 1;
				}
				for (int i = 0; i < box.size(); i++) {
					if (arr[idx] >= box.get(i)) {
						box.remove(i);
						break;
					}
				}
				idx += 1;

				if (idx == n) {
					idx = 0;
				}
			}
			System.out.println(result);
		}
	}
}
