import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class _5966_ { // Cow Cotillion

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(bf.readLine());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());

			int k = Integer.parseInt(st.nextToken());
			String p = st.nextToken();

			Stack<Character> stack = new Stack<>();
			boolean flag = false;
			for (int j = 0; j < k; j++) {
				if (p.charAt(j) == '>') {
					stack.push(p.charAt(j));
				} else {
					if (!stack.isEmpty()) {
						stack.pop();
					} else {
						flag = true;
						break;
					}
				}
			}
			if (!stack.isEmpty() || flag) {
				bw.write("illegal\n");
			} else {
				bw.write("legal\n");
			}
		}
		bw.flush();
	}
}
