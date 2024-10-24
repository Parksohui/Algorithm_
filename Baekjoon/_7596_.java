import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class _7596_ { // MP3 Songs

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int num = -1, idx = 1;
		while ((num = Integer.parseInt(bf.readLine())) != 0) {
			String[] arr = new String[num];
			for (int i = 0; i < num; i++) {
				arr[i] = bf.readLine();
			}
			Arrays.sort(arr);
			bw.write(idx++ + "\n");
			for (int i = 0; i < num; i++) {
				bw.write(arr[i] + "\n");
			}
		}
		bw.flush();
	}
}
