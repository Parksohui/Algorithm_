import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _33094_ { // Diet Plan

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int arr[] = new int[n];

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
		int cnt = 0, sum = 0;
		while (cnt < n) {
			queue.add(arr[cnt]);
			sum += arr[cnt];

			if (sum > m) {
				if (k == 0) {
					break;
				}
				k -= 1;
				sum -= queue.poll();
			}
			cnt += 1;
		}
		System.out.println(cnt);
	}
}
