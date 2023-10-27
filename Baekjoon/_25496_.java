import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _25496_ { // 장신구 명장 임스

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int p = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int arr[] = new int[n];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int result = 0;
		for (int i = 0; i < n; i++) {
			if (p >= 200)
				break;
			result += 1;
			p += arr[i];
		}
		System.out.println(result);
	}

}
