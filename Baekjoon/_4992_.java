import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class _4992_ { // Hanafuda Shuffle

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		String str = "";

		Stack<Integer> stack = new Stack<>();
		Stack<Integer> temp = new Stack<>();
		Stack<Integer> move = new Stack<>();

		while (!(str = bf.readLine()).equals("0 0")) {
			st = new StringTokenizer(str);

			int n = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());

			for (int i = 1; i <= n; i++) {
				stack.add(i);
			}

			for (int i = 0; i < r; i++) {
				st = new StringTokenizer(bf.readLine());

				int p = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());

				for (int j = 1; j < p; j++) {
					temp.add(stack.pop());
				}

				for (int j = 0; j < c; j++) {
					move.add(stack.pop());
				}

				while (!temp.isEmpty()) {
					stack.add(temp.pop());
				}

				while (!move.isEmpty()) {
					stack.add(move.pop());
				}
			}
			bw.write(stack.peek() + "\n");
			stack.clear();
		}
		bw.flush();
	}
}
