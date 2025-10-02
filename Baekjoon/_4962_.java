import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _4962_ { // Next Mayor

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		String str = "";
		while (!(str = bf.readLine()).equals("0 0")) {
			st = new StringTokenizer(str);

			int n = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());

			int arr[] = new int[n];
			int result=-1;

			while (true) {
				for (int i = 0; i < n; i++) {
					boolean check = false;
					if (p > 0) {
						arr[i] += 1;
						p -= 1;
						if (p == 0) {
							for (int j = 0; j < n; j++) {
								if (i != j && arr[j] != 0) {
									check = true;
									break;
								}
							}
							if (!check) {
								result=i;
								break;
							}
						}
					} else {
						p += arr[i];
						arr[i] = 0;
					}
				}
				if(result!=-1) {
					break;
				}
			}
			bw.write(result+"\n");
		}
		bw.flush();
	}
}
