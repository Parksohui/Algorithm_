import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _23843_ { // 콘센트

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(bf.readLine());
		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < n; i++) {
			queue.add(Integer.parseInt(st.nextToken()));
		}

		PriorityQueue<Integer> socket = new PriorityQueue<>();
		ArrayList<Integer> list = new ArrayList<>();
		int result = 0, num=0;
		while (!queue.isEmpty()) {
			if (socket.size() < m) {
				socket.add(queue.poll());
			} else {
				num=socket.poll();
				result += num;
				while(!socket.isEmpty()) {
					int x =socket.poll()-num;
					if(x>0) {
						list.add(x);
					}
				}
				for(int i=0; i<list.size(); i++) {
					socket.add(list.get(i));
				}
				list.clear();
			}
		}

		while(!socket.isEmpty()) {
			num=socket.poll();
		}
		result+=num;
		
		System.out.println(result);
	}
}
