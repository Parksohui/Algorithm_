import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _28464_ { // Potato

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(bf.readLine());

		st = new StringTokenizer(bf.readLine());

		int arr[] = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int sum = 0;
		for (int i = 0; i < N / 2; i++) {
			sum += arr[i];
		}

		bw.write(sum + " ");

		sum = 0;
		for (int i = N / 2; i < N; i++) {
			sum += arr[i];
		}

		bw.write(sum + "");
		bw.flush();
	}
}
