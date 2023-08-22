import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class _2812_ { // 크게 만들기

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		String str = bf.readLine();
		Stack<Integer> stack = new Stack<>();

		stack.add(str.charAt(0) - '0');

		for (int i = 1; i < n; i++) {
			int num = str.charAt(i) - '0';
			while (!stack.isEmpty() && k > 0 && stack.peek() < num) {
				stack.pop();
				k -= 1;
			}
			stack.add(num);
		}

		while (k > 0) {
			k-=1;
			stack.pop();
		}

		for (int x : stack) {
			bw.write(x + "");
		}

		bw.flush();
	}
}
