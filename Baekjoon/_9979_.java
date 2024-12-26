import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class _9979_ { // Does This Make Me Look Fat?
	static class Info implements Comparable<Info> {
		private String name;
		private int weight;

		public Info(String name, int weight) {
			this.name = name;
			this.weight = weight;
		}

		@Override
		public int compareTo(Info o) {
			return o.weight - this.weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		String str = "";
		while ((str = bf.readLine()) != null) {
			String temp = "";
			ArrayList<Info> list = new ArrayList<>();
			while (!(temp = bf.readLine()).equals("END")) {
				st = new StringTokenizer(temp);

				String name = st.nextToken();
				int days = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());

				list.add(new Info(name, weight - days));
			}
			Collections.sort(list);

			for (int i = 0; i < list.size(); i++) {
				bw.write(list.get(i).name + "\n");
			}
			bw.write("\n");
		}
		bw.flush();
	}
}
