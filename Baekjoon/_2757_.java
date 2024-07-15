import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _2757_ { // 엑셀

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		char alphabet[] = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
				'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		String str = "";
		while (!(str = bf.readLine()).equals("R0C0")) {
			String arr[] = str.split("R|C");

			String temp = "";
			int num = Integer.parseInt(arr[2]);
			while (num > 0) {
				if (num % 26 == 0) {
					temp += 'Z';
					num = (num / 26) - 1;
				} else {
					temp += alphabet[(num % 26) - 1];
					num /= 26;
				}
			}
			String answer = "";
			for (int i = temp.length() - 1; i >= 0; i--) {
				answer += temp.charAt(i);
			}
			answer += arr[1];
			bw.write(answer + "\n");
		}
		bw.flush();
	}
}
