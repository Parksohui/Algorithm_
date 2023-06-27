import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;

public class _3425_ { // 고스택

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Stack<Integer> stack = new Stack<>();
		ArrayList<String> arr = new ArrayList<>();

		String input = "";
		while (!(input = bf.readLine()).equals("QUIT")) {

			while (!input.equals("END")) {
				arr.add(input);
				input = bf.readLine();
			}
			int n = Integer.parseInt(bf.readLine());
			for (int i = 0; i < n; i++) {
				int num = Integer.parseInt(bf.readLine());
				stack.add(num);
				boolean flag = false;
				for (int j = 0; j < arr.size(); j++) {
					String str[] = arr.get(j).split(" ");
					if (str[0].equals("NUM"))
						stack.add(Integer.parseInt(str[1]));
					else if (str[0].equals("POP")) {
						if (stack.size() == 0) {
							flag = true;
							break;
						}
						stack.pop();
					} else if (str[0].equals("INV")) {
						if (stack.size() == 0) {
							flag = true;
							break;
						}
						stack.set(stack.size()-1, -stack.peek());
					} else if (str[0].equals("DUP")) {
						if (stack.size() == 0) {
							flag = true;
							break;
						}
						stack.add(stack.peek());
					} else if (str[0].equals("SWP")) {
						if (stack.size() < 2) {
							flag = true;
							break;
						}
						int a=stack.pop();
						int b=stack.pop();
						stack.add(a);
						stack.add(b);
					} else {
						if (stack.size() < 2) {
							flag = true;
							break;
						}
						int a = stack.pop();
						int b = stack.pop();
						if (str[0].equals("ADD")) {
							if(Math.abs((long)a + (long)b) > 1000000000) {
								flag=true;
								break;
							}
							stack.add(a + b);
						} else if (str[0].equals("SUB")) {
							if(Math.abs((long)b - (long)a) > 1000000000) {
								flag=true;
								break;
							}
							stack.add(b - a);
						} else if (str[0].equals("MUL")) {
							if(Math.abs((long)a * (long)b) > 1000000000) {
								flag=true;
								break;
							}
							stack.add(a * b);
						} else if (str[0].equals("DIV")) {
							if (a == 0 ) {
								flag = true;
								break;
							}
							if ((a < 0 && b < 0) || (a > 0 && b > 0)) {
								stack.add(Math.abs(b) / Math.abs(a));
							} else {
								stack.add(-(Math.abs(b) / Math.abs(a)));
							}
						} else if (str[0].equals("MOD")) {
							if (a == 0) {
								flag = true;
								break;
							}
							if (b < 0) {
								stack.add(-(Math.abs(b) % Math.abs(a)));
							} else {
								stack.add(Math.abs(b) % Math.abs(a));
							}
						}
					}
				}
				if (flag || stack.size() != 1) {
					bw.write("ERROR\n");
				} else {
					bw.write(stack.pop() + "\n");
				}
				stack.clear();
			}
			arr.clear();
			bw.write("\n");
			bf.readLine();
		}
		bw.flush();
	}

}
