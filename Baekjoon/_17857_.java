import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _17857_ { // Musical Chairs

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		st = new StringTokenizer(bf.readLine());
		ArrayList<int[]> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(new int[] { i + 1, Integer.parseInt(st.nextToken()) });
		}

		int idx=0;
		while (list.size() != 1) {
			idx += list.get(idx)[1] % list.size() - 1;
			if (idx < 0) {
				idx = list.size() - 1;
			}else if(idx >= list.size()) {
				idx-=list.size();
			}
			list.remove(idx);
			
			if(idx >= list.size()) {
				idx=0;;
			}
		}
		System.out.println(list.get(0)[0]);
	}
}
