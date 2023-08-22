import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class _2841_ { // 외계인의 기타 연주

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());

		ArrayList<Stack<Integer>> arr = new ArrayList<>();
		for (int i = 0; i < 7; i++) {
			arr.add(new Stack<>());
		}

		int result = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			int num = Integer.parseInt(st.nextToken());
			int p_num = Integer.parseInt(st.nextToken());

			Stack<Integer> stack = arr.get(num);
			while (!stack.isEmpty() && stack.peek() > p_num) {
				stack.pop();
				result += 1;
			}
			if(!stack.isEmpty() && stack.peek()==p_num) {
				continue;
			}else {
				stack.add(p_num);
				result += 1;
			}
		}
		System.out.println(result);
	}
}
