import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _13398_ { // 연속합 2

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		int arr[] = new int[n];
		int answer[][] = new int[2][n];
		st = new StringTokenizer(bf.readLine());

		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
		}

		int result = arr[0];

		answer[0][0] = arr[0];
		for (int i = 1; i < n; i++) {
			answer[0][i] = Math.max(answer[0][i - 1] + arr[i], arr[i]);
			answer[1][i] = Math.max(answer[0][i - 1], answer[1][i - 1] + arr[i]);
			
			result=Math.max(answer[0][i], result);
			result=Math.max(answer[1][i], result);
		}
		System.out.println(result);
	}
}
