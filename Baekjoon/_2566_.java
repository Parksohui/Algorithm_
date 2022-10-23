import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2566_ { //최댓값
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[][]arr=new int[9][9];
		int max_value=0;
		int x=1, y=1;
		for(int i=0; i<9; i++) {
			st=new StringTokenizer(bf.readLine());
			for(int j=0; j<9; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
				if(max_value<arr[i][j]) {
					max_value=arr[i][j];
					x=i+1;
					y=j+1;
				}
			}
		}
		System.out.println(max_value);
		System.out.println(x+" "+y);
	}
}
