import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _15464_ { // The Bovine Shuffle

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(bf.readLine());

		int arr[] = new int[N];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken()) - 1;
		}

		String id[] = new String[N];
		st = new StringTokenizer(bf.readLine());

		for (int i = 0; i < N; i++) {
			id[i] = st.nextToken();
		}

		for (int i = 0; i < N; i++) {
			bw.write(id[arr[arr[arr[i]]]] + "\n");
		}

		bw.flush();
	}
}
