import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class _10431_ { // 줄세우기

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int p = Integer.parseInt(bf.readLine());
		ArrayList<Integer> arr = new ArrayList<>();

		for (int i = 0; i < p; i++) {
			st = new StringTokenizer(bf.readLine());

			int t = Integer.parseInt(st.nextToken());
			int result = 0;

			for (int j = 0; j < 20; j++) {
				int num = Integer.parseInt(st.nextToken());
				if (j == 0) {
					arr.add(num);
				} else {
					boolean flag=false;
					
					for (int k = 0; k < j; k++) {
						if (arr.get(k) > num) {
							result += (j - k);
							flag=true;
							break;
						}
					}
					arr.add(num);
					if(flag) {
						Collections.sort(arr);
					}
				}
			}
			bw.write(t + " " + result + "\n");
			arr.clear();
		}
		bw.flush();
	}
}
