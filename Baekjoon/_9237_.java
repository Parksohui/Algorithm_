import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class _9237_ { // 이장님 초대

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		Integer arr[] = new Integer[n];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr, Collections.reverseOrder());

		int result = 0;
		int day = 1;
		for (int i = 0; i < n; i++) {
			int tree = day++ + arr[i];
			if (tree > result) {
				result = tree;
			}
		}
		System.out.println(result + 1);
	}
}
