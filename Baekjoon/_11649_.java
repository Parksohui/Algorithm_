import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class _11649_ { // Xedni Drawkcab

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(bf.readLine());

		String[] arr = new String[n];
		for (int i = 0; i < n; i++) {
			String str = bf.readLine();

			String result = "";
			for (int j = str.length() - 1; j >= 0; j--) {
				result += str.charAt(j);
			}
			arr[i] = result;
		}
		Arrays.sort(arr);

		for (int i = 0; i < n; i++) {
			bw.write(arr[i] + "\n");
		}
		bw.flush();
	}
}
