import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _16987_ { // 계란으로 계란치기
	static Egg arr[];
	static boolean visited[];
	static int cnt, result;

	static class Egg {
		private int d;
		private int w;

		public Egg(int d, int w) {
			this.d = d;
			this.w = w;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		arr = new Egg[n];
		visited = new boolean[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			arr[i] = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		result = 0;
		cnt = 0;

		search(0);

		System.out.println(result);
	}

	private static void search(int idx) {
		for (int i = 0; i < arr.length; i++) {
			if (idx == i) {
				continue;
			}
			if (!visited[i]) {
				arr[idx].d -= arr[i].w;
				arr[i].d -= arr[idx].w;

				if (arr[i].d <= 0) {
					cnt += 1;
					visited[i] = true;
				}
				if (arr[idx].d <= 0) {
					cnt += 1;
					visited[idx] = true;
				}
				
				if(result < cnt ) {
					result= cnt;
				}
				
				int temp=idx+1;
				while(temp<arr.length && visited[temp]) {
					temp++;
				}
				if(temp < arr.length) {
					search(temp);
				}
				arr[idx].d += arr[i].w;
				arr[i].d += arr[idx].w;

				if (arr[i].d-arr[idx].w <=0 && arr[i].d > 0) {
					cnt -= 1;
					visited[i] = false;
				}
				if (arr[idx].d-arr[i].w <=0 && arr[idx].d > 0) {
					cnt -= 1;
					visited[idx] = false;
				}
			}
		}
	}
}
