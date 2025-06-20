import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class _9843_ { // LVM

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		String arr[] = new String[n];

		for (int i = 0; i < n; i++) {
			arr[i] = bf.readLine();
		}

		Stack<Integer> stack = new Stack<>();
		int idx = 0, register = 0;
		while (true) {
			st = new StringTokenizer(arr[idx]);

			String cmd = st.nextToken();
			if (cmd.equals("PUSH")) {
				int x = Integer.parseInt(st.nextToken());
				stack.add(x);
				idx += 1;
			} else if (cmd.equals("STORE")) {
				register = stack.pop();
				idx += 1;
			} else if (cmd.equals("LOAD")) {
				stack.add(register);
				idx += 1;
			} else if (cmd.equals("PLUS")) {
				stack.add(stack.pop() + stack.pop());
				idx += 1;
			} else if (cmd.equals("TIMES")) {
				stack.add(stack.pop() * stack.pop());
				idx += 1;
			} else if (cmd.equals("IFZERO")) {
				int num = stack.pop();
				int move = Integer.parseInt(st.nextToken());
				if (num == 0) {
					idx = move;
				} else {
					idx += 1;
				}
			} else {
				System.out.println(stack.pop());
				break;
			}
		}
	}
}
