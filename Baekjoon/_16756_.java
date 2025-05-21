import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _16756_ { // Pismo

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(bf.readLine());

		st = new StringTokenizer(bf.readLine());

		int arr[] = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N - 1; i++) {
			int a = Math.max(arr[i], arr[i + 1]);
			int b = Math.min(arr[i], arr[i + 1]);
			min = Math.min(min, a - b);
		}
		System.out.println(min);
	}
}