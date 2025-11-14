import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class _5957_ { // Cleaning the Dishes

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		Stack<Integer> unwashed = new Stack<>();
		Stack<Integer> washed = new Stack<>();
		Stack<Integer> dried = new Stack<>();

		for (int i = n; i > 0; i--) {
			unwashed.add(i);
		}

		String str = "";

		while ((str = bf.readLine()) != null) {
			st = new StringTokenizer(str);

			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			if (c == 1) {
				for (int i = 0; i < d; i++) {
					washed.add(unwashed.pop());
				}
			} else {
				for (int i = 0; i < d; i++) {
					dried.add(washed.pop());
				}
			}
		}

		while (!dried.isEmpty()) {
			bw.write(dried.pop() + "\n");
		}
		bw.flush();
	}
}
