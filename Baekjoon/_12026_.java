import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _12026_ { // BOJ 거리

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());

		char arr[] = new char[n];
		String str = bf.readLine();
		for (int i = 0; i < str.length(); i++) {
			arr[i] = str.charAt(i);
		}

		int result[] = new int[n];

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (result[i] != 0 || i == 0) {
					if ((arr[i] == 'B' && arr[j] == 'O') || (arr[i] == 'O' && arr[j] == 'J')
							|| (arr[i] == 'J' && arr[j] == 'B')) {
						if (result[j] == 0 || result[j] > result[i] + ((j - i) * (j - i)))
							result[j] = result[i] + ((j - i) * (j - i));
					}
				}
			}
		}

		if (n > 1 && result[n - 1] == 0) {
			System.out.println(-1);
		} else {
			System.out.println(result[n - 1]);
		}
	}
}
