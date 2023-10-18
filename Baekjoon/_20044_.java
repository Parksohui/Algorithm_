import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _20044_ { // Project Teams

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		int arr[] = new int[n * 2];
		st = new StringTokenizer(bf.readLine());

		for (int i = 0; i < n * 2; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int start = 0, end = 2 * n - 1;

		int result = arr[start++] + arr[end--];
		for (int i = 0; i < n - 1; i++) {
			if (result > arr[start] + arr[end])
				result = arr[start] + arr[end];
			start += 1;
			end -= 1;
		}
		System.out.println(result);
	}
}
