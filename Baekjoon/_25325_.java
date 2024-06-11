import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _25325_ { // 학생 인기도 측정
	static class Student implements Comparable<Student> {
		private String name;
		private int score;

		public Student(String name, int score) {
			this.name=name;
			this.score=score;
		}
		
		@Override
		public int compareTo(Student o) {
			if (o.score == this.score) {
				return this.name.compareTo(o.name);
			}
			return o.score - this.score;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		HashMap<String, Integer> map = new HashMap<>();
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			map.put(st.nextToken(), 0);
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());

			while (st.hasMoreTokens()) {
				String name = st.nextToken();
				map.replace(name, map.get(name) + 1);
			}
		}

		ArrayList<Student> list = new ArrayList<>();
		for (String name : map.keySet()) {
			list.add(new Student(name, map.get(name)));
		}
		
		Collections.sort(list);
		
		for(int i=0; i<n; i++) {
			bw.write(list.get(i).name+" "+list.get(i).score+"\n");
		}
		bw.flush();
	}
}
