import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;

public class _16654_ { // Generalized German Quotation

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = bf.readLine();

		ArrayList<Character> list = new ArrayList<>();
		Stack<Character[]> stack = new Stack<>();

		for (int i = 0; i < str.length(); i += 2) {
			if (stack.isEmpty()) {
				stack.add(new Character[] { str.charAt(i), '[' });
				list.add('[');
			} else {
				if (stack.peek()[0] == str.charAt(i)) {
					stack.add(new Character[] { str.charAt(i), stack.peek()[1] });
					list.add(stack.peek()[1]);
				} else {
					stack.pop();
					list.add(']');
				}
			}
		}

		if (stack.isEmpty()) {
			for (int i = 0; i < list.size(); i++) {
				bw.write(list.get(i));
			}
		} else {
			bw.write("Keine Loesung");
		}
		bw.flush();
	}
}
