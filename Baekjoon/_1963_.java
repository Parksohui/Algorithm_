import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1963_ { // 소수 경로
	static boolean arr[];
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		arr = new boolean[10000];

		for (int i = 2; i < 5001; i++) {
			if (!arr[i]) {
				for (int j = i + i; j < 10000; j += i) {
					arr[j] = true;
				}
			}
		}

		int t = Integer.parseInt(bf.readLine());
		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(bf.readLine());
			String a = st.nextToken();
			String b = st.nextToken();

			result = -1;

			if (a.equals(b)) {
				bw.write("0\n");
			} else {
				search(a, b);
				
				if(result==-1) {
					bw.write("Impossible\n");
				}else {
					bw.write(result + "\n");
				}
			}
		}
		bw.flush();
	}

	private static void search(String a, String b) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { Integer.parseInt(a), 0 });

		boolean visited[] = new boolean[10000];
		visited[Integer.parseInt(a)] = true;

		while (!queue.isEmpty()) {
			int num[] = queue.poll();

			String temp = Integer.toString(num[0]);
			for (int i = 0; i < b.length(); i++) {
				for (int j = 0; j < 10; j++) {
					if (temp.charAt(i)-'0' == j || (i==0 && j==0)) {
						continue;
					}
					String str = temp.substring(0, i) + j + temp.substring(i + 1, b.length());
					if (arr[Integer.parseInt(str)]) {
						continue;
					}
					if (str.equals(b)) {
						result = num[1] + 1;
						break;
					}
					if (!visited[Integer.parseInt(str)]) {
						visited[Integer.parseInt(str)]=true;
						queue.add(new int[] { Integer.parseInt(str), num[1] + 1 });
					}
				}
			}
			if (result != -1) {
				break;
			}
		}
	}
}
