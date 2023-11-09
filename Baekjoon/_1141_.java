import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _1141_ { // 접두사

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());

		String arr[] = new String[n];
		for (int i = 0; i < n; i++) {
			arr[i] = bf.readLine();
		}

		Arrays.sort(arr);

		int result = 0;
		boolean flag = false;

		for (int i = 0; i < n - 1; i++) {
			flag = false;
			for (int j = 0; j < arr[i].length(); j++) {
				if (arr[i].charAt(j) != arr[i + 1].charAt(j)) {
					flag = true;
				}
				if (flag) {
					break;
				}
			}
			if (!flag) {
				result += 1;
			}
		}
		System.out.println(n - result);
	}
}
