import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class _2210_ { // 숫자판 점프
	static int arr[][];
	static int dx[]= {-1,1,0,0};
	static int dy[]= {0,0,-1,1};
	static Set<String> set;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		arr=new int[5][5];
		set=new HashSet<>();
		for(int i=0; i<5; i++) {
			st = new StringTokenizer(bf.readLine());
			for(int j=0; j<5; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				String x=""+arr[i][j];
				search(i, j, 1, x);
			}
		}
		System.out.println(set.size());
		
	}

	private static void search(int i, int j, int k, String x) {
		if(k==6) {
			set.add(x);
			return;
		}
		for(int num=0; num<4; num++) {
			if(i+dx[num]>=0 && i+dx[num]<5 && j+dy[num]>=0 && j+dy[num]<5) {
				search(i+dx[num], j+dy[num], k+1, x+arr[i+dx[num]][j+dy[num]]);
			}
		}	
	}
}
