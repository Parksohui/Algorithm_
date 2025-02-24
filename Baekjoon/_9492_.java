import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _9492_ { // Perfect Shuffle

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int num = 0;

		while ((num = Integer.parseInt(bf.readLine())) != 0) {
			String arr[] = new String[num];
			for (int i = 0; i < num; i++) {
				arr[i] = bf.readLine();
			}

			int x = 0, y = -1;
			if (num % 2 == 0) {
				y = num / 2;
			} else {
				y = (num / 2) + 1;
			}

			while (x < (num / 2) || y < num) {
				bw.write(arr[x++] + "\n");
				bw.write(arr[y++] + "\n");
			}
			if (num % 2 == 1) {
				bw.write(arr[x] + "\n");
			}
		}
		bw.flush();
	}
}
