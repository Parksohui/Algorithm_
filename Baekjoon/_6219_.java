import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _6219_ { // 소수의 자격

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		boolean arr[] = new boolean[b + 1];
		arr[0] = true;
		arr[1] = true;
		for (int i = 2; i < ((b + 1) / 2) + 1; i++) {
			if (!arr[i]) {
				for (int j = i + i; j < b + 1; j += i) {
					arr[j] = true;
				}
			}
		}

		int result = 0;
		String find=Integer.toString(d);
		for (int i = a; i <= b; i++) {
			if (!arr[i]) {
				String str = Integer.toString(i);
				if(str.contains(find)) {
					result+=1;
				}
			}
		}
		System.out.println(result);
	}
}
