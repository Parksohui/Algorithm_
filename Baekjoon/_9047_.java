import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class _9047_ { // 6174

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(bf.readLine());

		int result = 0;
		String min = "", max = "";
		for (int i = 0; i < T; i++) {
			String str = bf.readLine();

			while (!str.equals("6174")) {
				char[] arr = str.toCharArray();
				Arrays.sort(arr);

				min = String.valueOf(arr);
				max = "";
				for (int j = min.length() - 1; j >= 0; j--) {
					max += min.charAt(j);
				}
				result += 1;
				str = Integer.toString(Integer.parseInt(max) - Integer.parseInt(min));

				if (str.length() < 4) {
					str = "0" + str;
				}
			}
			bw.write(result + "\n");
			result = 0;
		}
		bw.flush();
	}
}
