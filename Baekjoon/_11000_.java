import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _11000_ { // 강의실 배정

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());
		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0])
					return o1[1] - o2[1];
				return o1[0] - o2[0];
			}

		});
		
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			queue.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
		}
		
		PriorityQueue<Integer> temp = new PriorityQueue<>();
		
		while (!queue.isEmpty()) {
			int num[] = queue.poll();
			if (temp.size() == 0)
				temp.add(num[1]);
			else {
				if(temp.peek()<=num[0]) {
					temp.poll();
				}
				temp.add(num[1]);
			}
		}
		System.out.println(temp.size());
	}
}
