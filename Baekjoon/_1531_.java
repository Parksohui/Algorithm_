import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1531_ { // 투명

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int arr[][]=new int[101][101];
		int result=0;
		
		for(int i=0; i<n; i++) {
			st=new StringTokenizer(bf.readLine());
			
			int x1=Integer.parseInt(st.nextToken());
			int y1=Integer.parseInt(st.nextToken());
			int x2=Integer.parseInt(st.nextToken());
			int y2=Integer.parseInt(st.nextToken());
			
			for(int j=x1; j<=x2; j++) {
				for(int k=y1; k<=y2; k++) {
					arr[j][k]+=1;
					if(arr[j][k] == (m+1)) {
						result+=1;
					}
				}
			}
		}
		
		System.out.println(result);
	}
}
