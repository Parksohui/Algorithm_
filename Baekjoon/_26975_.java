import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.InputStreamReader;

public class _26975_ { // Cow College

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		st = new StringTokenizer(bf.readLine());
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		long result = 0;
		int money = 0;
		for (int i = 0; i < n; i++) {
			if (result < new Long(arr[i]) * new Long(n - i)) {
				result = new Long(arr[i]) * new Long(n - i);
				money = arr[i];
			}
		}
		System.out.println(result + " " + money);
	}
}
