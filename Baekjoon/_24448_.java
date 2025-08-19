import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class _24448_ { // 図書館 2 (Library 2)

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int q = Integer.parseInt(bf.readLine());

		Stack<String> stack = new Stack<>();

		for (int i = 0; i < q; i++) {
			String str = bf.readLine();

			if (str.equals("READ")) {
				bw.write(stack.pop() + "\n");
			} else {
				stack.add(str);
			}
		}
		
		bw.flush();
	}
}
