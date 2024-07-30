import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class _5619_ { // 세 번째

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());

		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}

		Arrays.sort(arr);

		ArrayList<Integer> result = new ArrayList<>();
		int temp = -1;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < Math.min(n, i + 4); j++) {
				result.add(Integer.parseInt(Integer.toString(arr[i]) + Integer.toString(arr[j])));
				result.add(Integer.parseInt(Integer.toString(arr[j]) + Integer.toString(arr[i])));
			}
			Collections.sort(result);
			if (result.size() > 3) {
				if (temp == result.get(2)) {
					break;
				} else {
					temp = result.get(2);
				}
			}
		}
		System.out.println(result.get(2));
	}
}
