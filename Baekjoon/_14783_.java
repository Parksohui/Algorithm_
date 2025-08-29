import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _14783_ { // Eenie Meenie Miney Moe

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			queue.add(i);
		}

		int arr[] = new int[l];
		st = new StringTokenizer(bf.readLine());

		for (int i = 0; i < l; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int idx = 0;
		int cnt = 1;

		while (queue.size() != 1) {
			int temp = queue.poll();

			if (cnt == arr[idx]) {
				idx += 1;
				if (idx == l) {
					idx = 0;
				}
				cnt = 1;
				continue;
			}

			queue.add(temp);
			cnt += 1;
		}
		System.out.println(queue.poll());
	}
}
