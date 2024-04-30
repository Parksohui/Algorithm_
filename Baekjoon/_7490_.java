import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class _7490_ { // 0 만들기
	static ArrayList<String> answer;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine());
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(bf.readLine());

			String result = "1";
			answer = new ArrayList<>();
			search(result, n, 2);
			
			for(String str:answer) {
				bw.write(str+"\n");
			}
			bw.write("\n");
		}
		bw.flush();
	}

	private static void search(String result, int n, int idx) {
		if (idx == n + 1) {
			String temp = result.replace(" ", "");
			int x = 1;
			int a = temp.charAt(0) - '0';
			while (x < temp.length() && Character.isDigit(temp.charAt(x))) {
				a *= 10;
				a += temp.charAt(x++)-'0';
			}
			while (x < temp.length()) {
				int y = x;
				y += 1;
				int b = temp.charAt(y) - '0';
				while (y + 1 < temp.length() && Character.isDigit(temp.charAt(y + 1))) {
					b *= 10;
					b += temp.charAt(++y) - '0';
				}
				if (temp.charAt(x) == '+') {
					a += b;
				} else {
					a -= b;
				}
				x = y + 1;
			}
			if (a == 0) {
				answer.add(result);
			}
			return;
		}

		search(result + " " + idx, n, idx + 1);
		search(result + "+" + idx, n, idx + 1);
		search(result + "-" + idx, n, idx + 1);
		
	}
}
