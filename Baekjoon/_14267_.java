import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _14267_ { // 회사 문화 1
	static int sup[], answer[];
	static boolean visited[];
	static ArrayList<ArrayList<Integer>> sub;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		sup = new int[n + 1];
		answer = new int[n + 1];
		visited = new boolean[n + 1];
		sub = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			sub.add(new ArrayList<>());
		}

		st = new StringTokenizer(bf.readLine());
		for (int i = 1; i <= n; i++) {
			sup[i] = Integer.parseInt(st.nextToken());
			if (sup[i] > -1)
				sub.get(sup[i]).add(i);
		}

		for (int j = 0; j < m; j++) {
			st = new StringTokenizer(bf.readLine());
			int i = Integer.parseInt(st.nextToken()); // 직원 번호
			int w = Integer.parseInt(st.nextToken()); // 칭찬의 수치
			answer[i] += w;
		}
		
		for(int i=1; i<=n; i++) {
			if(answer[i]>0 && !visited[i]) {
				visited[i]=true;
				dfs(i);
			}
		}

		for (int i = 1; i <= n; i++) {
			bw.write(answer[i] + " ");
		}
		bw.flush();
	}

	private static void dfs(int idx) {
		for (int i = 0; i < sub.get(idx).size(); i++) {
			int next=sub.get(idx).get(i);
			answer[next]+=answer[idx];
			visited[next]=true;
			dfs(next);
		}
	}
}
