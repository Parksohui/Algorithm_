import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class _10106_ { // The Geneva Confection

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine());

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(bf.readLine());

			Stack<Integer> lake = new Stack<>();
			Stack<Integer> branch = new Stack<>();
			int cnt = 1;

			for (int j = 0; j < n; j++) {
				lake.add(Integer.parseInt(bf.readLine()));
			}

			boolean flag = false;
			while (!lake.isEmpty() || !branch.isEmpty()) {
				if (!branch.isEmpty() && branch.peek() == cnt) {
					branch.pop();
					cnt++;
				} else if (!lake.isEmpty() && lake.peek() == cnt) {
					lake.pop();
					cnt++;
				} else {
					if(lake.isEmpty()) {
						flag=true;
						break;
					}
					branch.add(lake.pop());
				}
			}
			
			if(flag) {
				bw.write("N\n");
			}else {
				bw.write("Y\n");
			}
		}
		bw.flush();
	}
}
