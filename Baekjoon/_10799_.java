import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _10799_ { // 쇠막대기

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String str = bf.readLine();

		Stack<Character> stack = new Stack<>();
		int result = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				stack.add('(');
				if (str.charAt(i + 1) != ')') {
					result += 1;
				}
			} else {
				stack.pop();
				if(str.charAt(i-1)!=')') {
					result += stack.size();
				}
			}
		}
		System.out.println(result);
	}
}
