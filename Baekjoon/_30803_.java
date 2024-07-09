import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _30803_ { // 수도꼭지

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(bf.readLine());
		int arr[] = new int[N + 1];
		boolean visited[] = new boolean[N + 1];

		long answer = 0;
		st = new StringTokenizer(bf.readLine());
		for (int i = 1; i < N + 1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			answer += arr[i];
		}
		bw.write(answer + "\n");

		int Q = Integer.parseInt(bf.readLine());
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(bf.readLine());

			int num = Integer.parseInt(st.nextToken());
			if (num == 1) {
				int temp = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				if (visited[temp]) {
					arr[temp] = x;
				} else {
					answer -= arr[temp];
					arr[temp] = x;
					answer += arr[temp];
				}
			} else {
				int x = Integer.parseInt(st.nextToken());
				if (!visited[x]) {
					visited[x] = true;
					answer -= arr[x];
				} else {
					visited[x] = false;
					answer += arr[x];
				}
			}
			bw.write(answer + "\n");
		}
		bw.flush();
	}
}
