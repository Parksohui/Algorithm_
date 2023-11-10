import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1916_ { // 최소비용 구하기
	static ArrayList<ArrayList<City>> list;
	static boolean visited[];
	static int result[];

	static class City {
		private int num;
		private int money;

		public City(int num, int money) {
			this.num = num;
			this.money = money;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());
		int m = Integer.parseInt(bf.readLine());

		list = new ArrayList<>();
		visited = new boolean[n + 1];
		result = new int[n + 1];

		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
			result[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int money = Integer.parseInt(st.nextToken());
			list.get(start).add(new City(end, money));
		}

		st = new StringTokenizer(bf.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		bfs(start, end);

		System.out.println(result[end]);
	}

	private static void bfs(int start, int end) {
		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		queue.add(new int[] { start, 0 });
		visited[start] = true;

		while (!queue.isEmpty()) {
			int temp[] = queue.poll();
			if (result[temp[0]] < temp[1])
				continue;
			for (int i = 0; i < list.get(temp[0]).size(); i++) {
				City city = list.get(temp[0]).get(i);
				if (!visited[city.num] || result[city.num] > temp[1] + city.money) {
					visited[city.num] = true;
					result[city.num] = temp[1] + city.money;
					queue.add(new int[] { city.num, result[city.num] });
				}
			}
		}
	}
}
