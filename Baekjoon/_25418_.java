import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _25418_ { // 정수 a를 k로 만들기

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int a = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		boolean visited[] = new boolean[1000001];

		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { a, 0 });

		int result = 0;

		while (!queue.isEmpty()) {
			int temp[] = queue.poll();
			if (temp[0] * 2 <= 1000000 && !visited[temp[0] * 2]) {
				if (temp[0] * 2 == k) {
					result = temp[1] + 1;
					break;
				}
				visited[temp[0]*2]=true;
				queue.add(new int[] { temp[0] * 2, temp[1] + 1 });
			}

			if (temp[0] + 1 <= 1000000 && !visited[temp[0] + 1]) {
				if (temp[0] + 1 == k) {
					result = temp[1] + 1;
					break;
				}
				visited[temp[0]+1]=true;
				queue.add(new int[] { temp[0] + 1, temp[1] + 1 });
			}
		}
		System.out.println(result);
	}
}
