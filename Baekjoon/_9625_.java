import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _9625_ { // BABBA

	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		int k=Integer.parseInt(bf.readLine());

		int count[][]=new int[2][k];
		count[0][0]=0;
		count[1][0]=1;
		
		for(int i=1; i<k; i++) {
			int a=count[0][i-1];
			int b=count[1][i-1];
			
			count[0][i]=b;
			count[1][i]=a+b;
		}
		System.out.println(count[0][k-1]+" "+count[1][k-1]);
	}
}
