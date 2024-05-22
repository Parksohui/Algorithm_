import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class _3568_ { // iSharp

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = bf.readLine();
		String arr[] = str.split(" ");

		Stack<Character> stack = new Stack<>();
		for (int i = 1; i < arr.length; i++) {
			String var = "";
			for (int j = 0; j < arr[i].length(); j++) {
				if (!Character.isAlphabetic(arr[i].charAt(j))) {
					if (arr[i].charAt(j) != ',' && arr[i].charAt(j) != ';')
						stack.add(arr[i].charAt(j));
				} else {
					var += arr[i].charAt(j);
				}
			}
			bw.write(arr[0]);
			while (!stack.isEmpty()) {
				if(stack.peek()==']') {
					stack.pop();
					stack.pop();
					bw.write("[]");
				}else {
					bw.write(stack.pop());
				}
			}
			bw.write(" " + var + ";\n");

		}
		bw.flush();
	}
}
