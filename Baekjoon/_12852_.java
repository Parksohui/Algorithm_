import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _12852_ { // 1로 만들기 2

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(bf.readLine());
		int arr[] = new int[1000001];

		Queue<int[]> queue = new LinkedList<>();

		if (n != 1) {
			queue.add(new int[] { n, 0 });
		}

		while (!queue.isEmpty()) {
			int num[] = queue.poll();

			if (num[0] % 3 == 0 && arr[num[0] / 3] == 0) {
				queue.add(new int[] { num[0] / 3, num[1] + 1 });
				arr[num[0] / 3] = num[0];
				if (num[0] / 3 == 1) {
					bw.write((num[1] + 1) + "\n");
					break;
				}
			}
			if (num[0] % 2 == 0 && arr[num[0] / 2] == 0) {
				queue.add(new int[] { num[0] / 2, num[1] + 1 });
				arr[num[0] / 2] = num[0];
				if (num[0] / 2 == 1) {
					bw.write((num[1] + 1) + "\n");
					break;
				}
			}
			if (arr[num[0] - 1] == 0) {
				queue.add(new int[] { num[0] - 1, num[1] + 1 });
				arr[num[0] - 1] = num[0];
				if (num[0] - 1 == 1) {
					bw.write((num[1] + 1) + "\n");
					break;
				}
			}
		}

		if (n == 1)
			bw.write("0\n");

		ArrayList<Integer> result = new ArrayList<>();
		int idx = 1;
		while (true) {
			result.add(idx);
			if (idx == n) {
				break;
			}
			idx = arr[idx];
		}

		for (int i = result.size() - 1; i >= 0; i--) {
			bw.write(result.get(i) + " ");
		}
		bw.flush();
	}
}
