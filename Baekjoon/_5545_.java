import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class _5545_ { // 최고의 피자

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		st = new StringTokenizer(bf.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(bf.readLine());

		Integer arr[] = new Integer[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}

		Arrays.sort(arr, Collections.reverseOrder());

		int money = a;
		int kal = c;
		int result = kal / money;

		for (int i = 0; i < n; i++) {
			money += b;
			kal += arr[i];
			if (kal / money > result) {
				result = kal / money;
			}
		}
		System.out.println(result);
	}
}
