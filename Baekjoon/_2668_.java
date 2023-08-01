import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.TreeSet;

public class _2668_ { // 숫자고르기
	static int arr[];
	static TreeSet<Integer> set, a, b;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(bf.readLine());

		arr = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}

		set = new TreeSet<>();
		a = new TreeSet<>();
		b = new TreeSet<>();

		for (int i = 1; i <= n; i++) {
			if (set.contains(i)) {
				continue;
			}
			dfs(i);
			if (a.equals(b)) {
				for (int num : a) {
					set.add(num);
				}
			}
			a.clear();
			b.clear();
		}
		
		bw.write(set.size()+"\n");
		for(int num: set) {
			bw.write(num+"\n");
		}
		bw.flush();

	}

	private static void dfs( int i) {
		a.add(i);
		b.add(arr[i]);
		if(a.contains(arr[i])) return;
		dfs(arr[i]);
	}
}
