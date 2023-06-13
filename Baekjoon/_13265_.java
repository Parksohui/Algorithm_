import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _13265_ { // 색칠하기
	static ArrayList<ArrayList<Integer>> arr;
	static int check[];
	static boolean flag;
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t=Integer.parseInt(bf.readLine());
		for(int i=0; i<t; i++) {
			st=new StringTokenizer(bf.readLine());
			
			int n=Integer.parseInt(st.nextToken()); 
			int m=Integer.parseInt(st.nextToken()); 
			
			arr=new ArrayList<>();
			check=new int[n];
			flag=false;
			for(int j=0; j<n; j++) {
				arr.add(new ArrayList<>());
				check[j]=-1;
			}
			
			for(int j=0; j<m; j++) {
				st=new StringTokenizer(bf.readLine());
				int x=Integer.parseInt(st.nextToken())-1;
				int y=Integer.parseInt(st.nextToken())-1;
				arr.get(x).add(y);
				arr.get(y).add(x);
			}
			
			for(int j=0; j<n; j++) {
				if(check[j]==-1) {
					check[j]=0;
					bfs(j);
				}
			}	
			if(flag) System.out.println("impossible");
			else System.out.println("possible");
		}
	}
	private static void bfs(int j) {
		Queue<Integer>queue=new LinkedList<>();
		queue.add(j);
		
		while(!queue.isEmpty()) {
			int num=queue.poll();
			for(int i=0; i<arr.get(num).size(); i++) {
				if(check[arr.get(num).get(i)]==-1) {
					if(check[num]==0) {
						check[arr.get(num).get(i)]=1;
						queue.add(arr.get(num).get(i));
					}
					else if(check[num]==1) {
						check[arr.get(num).get(i)]=0;
						queue.add(arr.get(num).get(i));
					}
				}else if(check[arr.get(num).get(i)]==0) {
					if(check[num]!=1) {
						flag=true;
						return;
					}
				}else if(check[arr.get(num).get(i)]==1) {
					if(check[num]!=0) {
						flag=true;
						return;
					}
				}
			}
		}
	}
}
