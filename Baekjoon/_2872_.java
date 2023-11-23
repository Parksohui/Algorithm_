import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _2872_ { // 우리집엔 도서관이 있어

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());

		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}

		int num = n;
		for (int i = n - 1; i >= 0; i--) {
			if (arr[i] == num) {
				num--;
			}
		}
		System.out.println(num);
	}
}
