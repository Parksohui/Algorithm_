import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _31307_ { // Lines Per Hour

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken()) * 5;

		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}

		Arrays.sort(arr);

		int sum = 0;
		boolean flag = false;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			if (sum > x) {
				System.out.println(i);
				flag = true;
				break;
			}
		}

		if (!flag) {
			System.out.println(n);
		}
	}
}
