import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class _14540_ { // Railway Station

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = 0;
	
		while ((n = Integer.parseInt(bf.readLine())) != 0) {
			String str = "";

			while (!(str = bf.readLine()).equals("0")) {
				st = new StringTokenizer(str);

				int[] result = new int[n];
				int idx = 0;
				for (int i = 0; i < n; i++) {
					result[i] = Integer.parseInt(st.nextToken());
				}

				Stack<Integer> stack = new Stack<>();
				Stack<Integer> temp = new Stack<>();
				for (int i = n; i > 0; i--) {
					stack.add(i);
				}

				boolean flag = false;
				while (idx < n) {
					if (!stack.isEmpty() && stack.peek() == result[idx]) {
						stack.pop();
						idx++;
					} else if (!temp.isEmpty() && temp.peek() == result[idx]) {
						temp.pop();
						idx++;
					} else {
						if (!stack.isEmpty()) {
							temp.add(stack.pop());
						} else {
							flag = true;
							break;
						}
					}
				}
				if (flag) {
					bw.write("No\n");
				} else {
					bw.write("Yes\n");
				}
			}
			bw.write("\n");
		}
		bw.flush();
	}
}
