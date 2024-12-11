import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;

public class _8633_ { // Sortowanie biżuterii

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(bf.readLine());

		String arr[] = new String[n];
		for (int i = 0; i < n; i++) {
			arr[i] = bf.readLine();
		}

		Arrays.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if (o1.length() == o2.length()) {
					return o1.compareTo(o2);
				}
				return o1.length() - o2.length();
			}
		});

		for (int i = 0; i < n; i++) {
			bw.write(arr[i] + "\n");
		}
		bw.flush();
	}
}
