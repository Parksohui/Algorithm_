import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _20680_ { // Birds Rituals

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());

		ArrayList<String> list = new ArrayList<>();
		st = new StringTokenizer(bf.readLine());

		for (int i = 0; i < n; i++) {
			list.add(st.nextToken());
		}

		for (int i = 0; i < s; i++) {
			st = new StringTokenizer(bf.readLine());

			String cmd = st.nextToken();
			String name = st.nextToken();

			if (cmd.equals("insert")) {
				int idx = Integer.parseInt(st.nextToken());
				list.add(idx, name);

			} else if (cmd.equals("depart")) {
				list.remove(name);

			} else {
				int idx = list.indexOf(name);
				int move = Integer.parseInt(st.nextToken());

				if (move == 0) {
					continue;
				}
				
				if(move < 0) {
					list.add(idx + move, name);
					list.remove(idx+1);
				}else {
					list.add(idx + move+1, name);
					list.remove(idx);
				}
				
			}
		}

		for (String name : list) {
			bw.write(name + " ");
		}
		bw.flush();
	}
}
