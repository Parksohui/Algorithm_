import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1652_ { // 누울 자리를 찾아라

	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(bf.readLine());
		char arr[][]=new char[n][n];
		
		int width=0, heigth=0, temp=0;
		
		for(int i=0; i<n; i++) { // input & width
			String s=bf.readLine();
			temp=0;
			for(int j=0; j<n; j++) {
				arr[i][j]=s.charAt(j);
				if(arr[i][j]=='X') {
					if(temp>=2) width+=1;
					temp=0;
				}else {
					temp+=1;
				}
			}
			if(temp>=2) width+=1;
		}
		
		for(int i=0; i<n; i++) {
			temp=0;
			for(int j=0; j<n; j++) {
				if(arr[j][i]=='X') {
					if(temp>=2) heigth+=1;
					temp=0;
				}else {
					temp+=1;
				}
			}
			if(temp>=2) heigth+=1;
		}
		System.out.println(width+" "+heigth);
	}

}
