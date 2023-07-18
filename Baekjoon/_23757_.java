import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _23757_ { // 아이들과 선물 상자 

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			queue.add(Integer.parseInt(st.nextToken()));
		}

		st = new StringTokenizer(bf.readLine());
		boolean flag = false;
		for (int i = 0; i < m; i++) {
			int num = Integer.parseInt(st.nextToken());
			int box = queue.poll();
			if (box < num) {
				flag = true;
				break;
			}
			queue.add(box - num);
		}
		if (flag)
			System.out.println(0);
		else
			System.out.println(1);
	}
}
