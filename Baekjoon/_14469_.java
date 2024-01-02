import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _14469_ { // 소가 길을 건너간 이유 3

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			queue.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
		}

		int result = 0;
		while (!queue.isEmpty()) {
			int temp[] = queue.poll();
			
			if(temp[0]<=result) {
				result+=temp[1];
			}else {
				result=temp[0]+temp[1];
			}
		}
		System.out.println(result);
	}
}
