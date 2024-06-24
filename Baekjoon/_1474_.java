import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1474_ { // 밑 줄

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		String arr[] = new String[n];
		int space[] = new int[n - 1];
		int len = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = bf.readLine();
			len += arr[i].length();
		}

		int temp = (m - len) / (n - 1);
		for (int i = 0; i < n - 1; i++) {
			space[i] = temp;
		}

		if ((m - len) % (n - 1) != 0) {
			m -= len + (n - 1) * temp;
			while (m > 0) {
				for (int i = 1; i < n; i++) {
					if (Character.isLowerCase(arr[i].charAt(0))) {
						space[i - 1] += 1;
						m -= 1;
					}
					if (m == 0) {
						break;
					}
				}
				if (m == 0) {
					break;
				}
				for(int i=n-1; i>=0; i--) {
					if(Character.isUpperCase(arr[i].charAt(0))) {
						space[i-1]+=1;
						m-=1;
					}
					if(m==0) {
						break;
					}
				}
			}
		}
		for (int i = 0; i < n; i++) {
			bw.write(arr[i]);
			if (i == n - 1) {
				break;
			}
			for (int j = 0; j < space[i]; j++) {
				bw.write("_");
			}
		}
		bw.flush();
	}
}
