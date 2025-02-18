import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _15235_ { // Olympiad Pizza

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(bf.readLine());

		int arr[] = new int[N];

		Queue<int[]> queue = new LinkedList<>();

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			queue.add(new int[] { Integer.parseInt(st.nextToken()), i });
		}

		int time = 0;
		while (!queue.isEmpty()) {
			int result[] = queue.poll();
			time += 1;

			result[0] -= 1;
			if (result[0] == 0) {
				arr[result[1]] = time;
			} else {
				queue.add(result);
			}
		}

		for (int i = 0; i < N; i++) {
			bw.write(arr[i] + " ");
		}
		bw.flush();
	}
}
