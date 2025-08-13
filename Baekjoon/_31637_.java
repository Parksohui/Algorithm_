import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _31637_ { // ダンス (Dance)

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(bf.readLine());

		int arr[] = new int[N * 2];

		for (int i = 0; i < 2 * N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		boolean flag = false;
		Arrays.sort(arr);
		
		for (int i = 0; i < 2 * N; i += 2) {
			if (arr[i + 1] - arr[i] > D) {
				flag = true;
				break;
			}
		}

		if (flag) {
			System.out.println("No");
		} else {
			System.out.println("Yes");
		}
	}
}
