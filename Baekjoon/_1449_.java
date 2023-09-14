import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1449_ { // 수리공 항승

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(bf.readLine());

		PriorityQueue<Double> queue = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(st.nextToken());
			queue.add(x - 0.5);
			queue.add(x + 0.5);
		}

		double temp = queue.poll();
		int result = 1;
		boolean flag = false;

		while (!queue.isEmpty()) {
			if (temp + l > queue.peek()) {
				queue.poll();
			} else if (!flag && temp + l == queue.peek()) {
				flag=true;
				queue.poll();
			} else {
				temp = queue.poll();
				result += 1;
				flag=false;
			}
		}

		System.out.println(result);
	}
}
