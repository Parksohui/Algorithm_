import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _14241_ { // 슬라임 합치기

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		st=new StringTokenizer(bf.readLine());

		int arr[]=new int[n];
		for(int i=0; i<n; i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}

		long result=0;
		for(int i=1; i<n; i++) {
			result+=arr[i-1]*arr[i];
			arr[i]=arr[i-1]+arr[i];
		}
		System.out.println(result);
	}
}