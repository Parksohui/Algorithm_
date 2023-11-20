import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class _1448_ { // 삼각형 만들기

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());

		Integer arr[] = new Integer[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}

		Arrays.sort(arr, Collections.reverseOrder());

		boolean flag = false;

		for (int i = 0; i < n - 2; i++) {
			if (arr[i] < arr[i + 1] + arr[i + 2]) {
				System.out.println(arr[i] + arr[i + 1] + arr[i + 2]);
				flag = true;
				break;
			}
		}

		if (!flag) {
			System.out.println(-1);
		}
	}
}
