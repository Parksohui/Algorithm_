import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _6108_ { // The Perfect Cow

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(bf.readLine());

		int result[] = new int[N];

		int temp[] = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				temp[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(temp);
			result[i] = temp[N / 2];
		}
		Arrays.sort(result);
		System.out.println(result[N / 2]);
	}
}
