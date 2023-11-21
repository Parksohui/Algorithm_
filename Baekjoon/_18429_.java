import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _18429_ { // 근손실
	static int arr[], answer;
	static boolean visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		arr = new int[n];
		visited = new boolean[n];
		answer = 0;

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		search(0, n, k, 500);
		
		System.out.println(answer);
	}

	private static void search(int idx, int n, int k, int w) {
		if (idx == n) {
			answer += 1;
			return;
		}
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				if (w + arr[i] - k < 500) {
					continue;
				}
				visited[i] = true;
				search(idx + 1, n, k, w + arr[i] - k);
				visited[i] = false;
			}
		}
	}
}
