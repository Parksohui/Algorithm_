import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _16198_ { // 에너지 모으기
	static int arr[], result;
	static boolean visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		arr = new int[n];
		visited = new boolean[n];
		result = 0;

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		getEnergy(0);

		System.out.println(result);
	}

	private static void getEnergy(int num) {
		int cnt = 0;
		for (int i = 1; i < arr.length - 1; i++) {
			if (!visited[i]) {
				visited[i] = true;
				int x=i, y=i;
				while(visited[x]) {
					x--;
				}
				while(visited[y]) {
					y++;
				}
				getEnergy(num + arr[x] * arr[y]);
				visited[i] = false;
			} else {
				cnt += 1;
			}
		}
		if (cnt == arr.length - 2) {
			if (result < num) {
				result = num;
			}
		}
	}
}
