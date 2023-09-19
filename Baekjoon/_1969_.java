import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _1969_ { // DNA
	static class Dna implements Comparable<Dna> {
		private char x;
		private int cnt;

		public Dna(char x, int cnt) {
			this.x = x;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Dna o) {
			if (this.cnt == o.cnt)
				return this.x - o.x;
			return o.cnt - this.cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		ArrayList<HashMap<Character, Integer>> list = new ArrayList<>();
		String arr[]=new String[n];
		for (int i = 0; i < m; i++) {
			list.add(new HashMap<>());
		}

		for (int i = 0; i < n; i++) {
			arr[i] = bf.readLine();
			for (int j = 0; j < m; j++) {
				if (list.get(j).containsKey(arr[i].charAt(j))) {
					list.get(j).replace(arr[i].charAt(j), list.get(j).get(arr[i].charAt(j))+1);
				} else {
					list.get(j).put(arr[i].charAt(j), 1);
				}
			}
		}

		String result = "";
		int answer=0;
		PriorityQueue<Dna> queue = new PriorityQueue<>();

		for (int i = 0; i < m; i++) {
			list.get(i).forEach((key, value) -> {
				queue.add(new Dna(key, value));
			});
			char temp=queue.poll().x;
			for(int j=0; j<n; j++) {
				if(arr[j].charAt(i) != temp) {
					answer+=1;
				}
			}
			result += temp;
			queue.clear();
		}

		System.out.println(result);
		System.out.println(answer);
	}
}
