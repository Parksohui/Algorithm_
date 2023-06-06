import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class _24483_ { //알고리즘 수업 - 깊이 우선 탐색 5
	static ArrayList<ArrayList<Integer>> arr;
	static int d[], t[];
	static int idx;
	
	public static void main(String[] args) throws IOException { 
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int r=Integer.parseInt(st.nextToken())-1;
		
		arr=new ArrayList<>();
		d=new int[n];
		t=new int[n];
		for(int i=0; i<n; i++) {
			arr.add(new ArrayList<>());
			d[i]=-1;
		}
		
		for(int i=0; i<m; i++) {
			st=new StringTokenizer(bf.readLine());
			int u=Integer.parseInt(st.nextToken())-1;
			int v=Integer.parseInt(st.nextToken())-1;
			arr.get(u).add(v);
			arr.get(v).add(u);
		}
		
		for(int i=0; i<n; i++) {
			Collections.sort(arr.get(i));
		}
		
		d[r]=0;
		t[r]=1;
		idx=2;
		dfs(r);
		
		long result=0;
		for(int i=0; i<n; i++) {
			result+= (d[i]*t[i]);
		}
		System.out.println(result);
	}

	private static void dfs(int r) {
		for(int i=0; i<arr.get(r).size(); i++) {
			if(d[arr.get(r).get(i)]==-1) {
				d[arr.get(r).get(i)]=d[r]+1;
				t[arr.get(r).get(i)]=idx++;
				dfs(arr.get(r).get(i));
			}
		}
	}
}
