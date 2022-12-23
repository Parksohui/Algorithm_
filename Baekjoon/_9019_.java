import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _9019_ {
	static int A,B;
	static String result="";
	static Queue<Integer>queue;
	static Queue<String>cmd;
	static boolean check[];

	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T=Integer.parseInt(bf.readLine()); //test case
		queue=new LinkedList<>();
		cmd=new LinkedList<>();
		
		for(int i=0; i<T; i++) {
			st=new StringTokenizer(bf.readLine());
			A=Integer.parseInt(st.nextToken());
			B=Integer.parseInt(st.nextToken());
			result="";
			queue.clear();
			cmd.clear();
			check=new boolean[10000];
			search();
			System.out.println(result);
		}
	}
	private static int D(int num) {
		return (num*2)%10000;
	}
	
	private static int S(int num) {
		if(num==0) return 9999;
		else return num-1;
	}
	
	private static int L(int num) { 
		int n=num%1000;
		int temp=num/1000;
		return (n*10)+temp;
	}
	
	private static int R(int num) {
		int n=num/10;
		int temp=num%10;
		return (temp*1000)+n;
	}

	private static void search() {
		queue.add(A);
		check[A]=true;
		cmd.add("");
		
		while(!queue.isEmpty()) {
			int n=queue.poll();
			String line=cmd.poll();

			int num=D(n);
			if(num==B) {
				result=line+"D";
				break;
			}
			else if(!check[num]){
				check[num]=true;
				queue.add(num);
				cmd.add(line+"D");
			}
			num=S(n);
			if(num==B) {
				result=line+"S";
				break;
			}
			else if(!check[num]){
				check[num]=true;
				queue.add(num);
				cmd.add(line+"S");
			}

			num=L(n);
			if(num==B) {
				result=line+"L";
				break;
			}
			else if(!check[num]){
				check[num]=true;
				queue.add(num);
				cmd.add(line+"L");
			}
			num=R(n);
			if(num==B) {
				result=line+"R";
				break;
			}
			else if(!check[num]){
				check[num]=true;
				queue.add(num);
				cmd.add(line+"R");
			}
			if(result!="")break;
		}
	}
}
