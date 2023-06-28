import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class _17299_ { // 오등큰수

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());
		int arr[] = new int[n];
		int result[] = new int[n];
		int f[] = new int[1000001];

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
			f[num] += 1;
			result[i] = -1;
		}

		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < n - 1; i++) {
			if (f[arr[i]] < f[arr[i + 1]]) {
				result[i] = arr[i + 1];
				while (!stack.isEmpty()) {
					if (f[arr[stack.peek()]] < f[arr[i + 1]]) {
						int num = stack.pop();
						result[num] = arr[i + 1];
					} else {
						break;
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
