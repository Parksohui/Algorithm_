import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class _17298_ { // 오큰수

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());
		st = new StringTokenizer(bf.readLine());

		Stack<Integer> stack = new Stack<>();
		int arr[] = new int[n];
		int result[] = new int[n];
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
			result[i] = -1;
		}

		for (int i = 0; i < n - 1; i++) {
			if (arr[i] < arr[i + 1]) {
				result[i] = arr[i + 1];
				if (!stack.isEmpty()) {
					while (!stack.isEmpty()) {
						if (arr[stack.peek()] < arr[i + 1]) {
							int num = stack.pop();
							result[num] = arr[i + 1];
						}else {
							break;
						}
					}
				}

			} else {
				stack.add(i);
			}
		}
		for (int i = 0; i < n; i++) {
			bw.write(result[i] + " ");
		}
		bw.flush();
	}
}
