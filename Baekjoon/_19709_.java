import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _19709_ { // LunchBox

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int arr[] = new int[m];
		for (int i = 0; i < m; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}

		Arrays.sort(arr);

		int result = 0;
		for (int i = 0; i < m; i++) {
			if (n - arr[i] >= 0) {
				n -= arr[i];
				result += 1;
			} else {
				break;
			}
		}
		System.out.println(result);
	}
}
