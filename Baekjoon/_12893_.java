import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _12893_ { // 적의 적
	static ArrayList<ArrayList<Integer>> arr;
	static boolean team[], visited[], flag;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		arr = new ArrayList<>();
		team = new boolean[n];
		visited = new boolean[n];
		flag = false;
		for (int i = 0; i < n; i++) {
			arr.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			arr.get(a).add(b);
			arr.get(b).add(a);
		}

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				team[i] = true;
				search(i);
			}
		}
		if (flag)
			System.out.println(0);
		else
			System.out.println(1);
	}

	private static void search(int idx) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(idx);

		while (!queue.isEmpty()) {
			int num = queue.poll();
			for (int i = 0; i < arr.get(num).size(); i++) {
				int next = arr.get(num).get(i);
				if (!visited[next]) {
					visited[next] = true;
					team[next] = !team[num];
					queue.add(next);
				} else {
					if (team[num] != !team[next]) {
						flag = true;
						return;
					}
				}
			}
		}
	}
}
