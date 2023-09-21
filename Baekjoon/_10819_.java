import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10819_ { // 차이를 최대로
	static int arr[], result, arr2[];
	static boolean visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());
		st = new StringTokenizer(bf.readLine());

		arr = new int[n];
		arr2 = new int[n];
		visited = new boolean[n];
		result = 0;

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		search(0, n);
		System.out.println(result);
	}

	private static void search(int idx, int n) {
		if (idx == n) {
			int temp = 0;
			for (int i = 0; i < n - 1; i++) {
				temp += Math.abs(arr2[i] - arr2[i + 1]);
			}
			if (temp > result) {
				result = temp;
			}
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr2[idx] = arr[i];
				search(idx + 1, n);
				visited[i] = false;
			}
		}
	}
}
