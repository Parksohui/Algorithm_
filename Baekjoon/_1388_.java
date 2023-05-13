import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1388_ { // 바닥 장식 
	static char arr[][];
	static boolean visited[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		int n=Integer.parseInt(st.nextToken()); // 세로 크기
		int m=Integer.parseInt(st.nextToken()); // 가로 크기
		
		arr=new char[n][m];
		visited=new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			String x=bf.readLine();
			for(int j=0; j<m; j++) {
				arr[i][j]=x.charAt(j);
			}
		}
		
		int result=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(!visited[i][j]) {
					visited[i][j]=true;
					result+=1;
					search(i,j);
				}
			}
		}
		System.out.println(result);
	}

	private static void search(int x, int y) {
		if(arr[x][y]=='-') {
			if(y+1<arr[0].length && arr[x][y+1]=='-') {
				visited[x][y+1]=true;
				search(x,y+1);
			}
		}
		if(arr[x][y]=='|') {
			if(x+1<arr.length && arr[x+1][y]=='|') {
				visited[x+1][y]=true;
				search(x+1,y);
			}
		}
	}
}
