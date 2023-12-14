import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _5582_ { // 공통 부분 문자열

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String a = bf.readLine();
		String b = bf.readLine();

		int arr[][] = new int[a.length() + 1][b.length() + 1];
		
		int result=0;
		
		for (int i = 0; i < a.length(); i++) {
			for (int j = 0; j < b.length(); j++) {
				if(a.charAt(i)==b.charAt(j)) {
					arr[i+1][j+1]=arr[i][j]+1;
					result=Math.max(arr[i+1][j+1], result);
				}
			}
		}
		System.out.println(result);
	}
}
