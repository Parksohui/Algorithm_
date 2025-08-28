import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class _27042_ { // Bonbons

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		Queue<Integer> queue = new LinkedList<>();

		int n = Integer.parseInt(bf.readLine());

		for (int i = 1; i <= n; i++) {
			queue.add(i);
		}

		boolean flag = false;
		while (queue.size() != 1) {
			int num = queue.poll();
			if (!flag) {
				queue.add(num);
			}
			flag = !flag;
		}
		System.out.println(queue.poll());
	}
}
