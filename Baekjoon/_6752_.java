import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _6752_ { // Time on task

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(bf.readLine());
		int c = Integer.parseInt(bf.readLine());

		int arr[] = new int[c];
		for (int i = 0; i < c; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}

		Arrays.sort(arr);

		int result = -1;
		for (int i = 0; i < c; i++) {
			if (t - arr[i] >= 0) {
				t -= arr[i];
			} else {
				result = i;
				break;
			}
		}
		if (result == -1) {
			result = c;
		}
		System.out.println(result);
	}
}
