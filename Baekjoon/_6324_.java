import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _6324_ { // URLs

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(bf.readLine());

		for (int i = 0; i < n; i++) {
			String str = bf.readLine();

			bw.write("URL #" + (i + 1) + "\n");

			String protocol[] = str.split("://");
			bw.write("Protocol = " + protocol[0] + "\n");

			String temp[] = protocol[1].split("/");
			String host[] = temp[0].split(":");

			bw.write("Host     = " + host[0] + "\n");
			if (host.length > 1) {
				bw.write("Port     = " + host[1] + "\n");
			} else {
				bw.write("Port     = <default>\n");
			}

			bw.write("Path     = ");
			if (temp.length > 1) {
				for (int j = 1; j < temp.length; j++) {
					bw.write(temp[j]);
					if (j < temp.length - 1) {
						bw.write("/");
					}
				}
				if (protocol.length > 2) {
					for (int j = 2; j < protocol.length; j++) {
						bw.write("://" + protocol[j]);
					}
				}
			} else {
				bw.write("<default>");
			}
			if (i < n - 1) {
				bw.write("\n\n");
			}
		}
		bw.flush();
	}
}
