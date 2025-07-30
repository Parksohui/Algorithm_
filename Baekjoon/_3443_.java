import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _3443_ { // Reaux! Sham! Beaux!

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		HashMap<String, String> map = new HashMap<String, String>() {
			{
				put("Kamen", "Rock");
				put("Rock", "Rock");
				put("Pierre", "Rock");
				put("Stein", "Rock");
				put("Ko", "Rock");
				put("Koe", "Rock");
				put("Sasso", "Rock");
				put("Roccia", "Rock");
				put("Guu", "Rock");
				put("Kamien", "Rock");
				put("Piedra", "Rock");

				put("Nuzky", "Scissors");
				put("Scissors", "Scissors");
				put("Ciseaux", "Scissors");
				put("Schere", "Scissors");
				put("Ollo", "Scissors");
				put("Olloo", "Scissors");
				put("Forbice", "Scissors");
				put("Choki", "Scissors");
				put("Nozyce", "Scissors");
				put("Tijera", "Scissors");

				put("Papir", "Paper");
				put("Paper", "Paper");
				put("Feuille", "Paper");
				put("Papier", "Paper");
				put("Carta", "Paper");
				put("Rete", "Paper");
				put("Paa", "Paper");
				put("Papel", "Paper");
			}

		};

		String str;
		int turn = 1;
		int player = 0;
		String name[] = new String[2];
		int score[] = new int[2];

		while (true) {
			str = bf.readLine();

			if (str.equals("-") || str.equals(".")) {
				bw.write("Game #" + (turn++) + ":\n");
				for (int i = 0; i < 2; i++) {
					bw.write(name[i] + ": " + score[i]);
					if (score[i] == 1) {
						bw.write(" point\n");
					} else {
						bw.write(" points\n");
					}
				}
				if (score[0] == score[1]) {
					bw.write("TIED GAME\n");
				} else if (score[0] > score[1]) {
					bw.write("WINNER: " + name[0] + "\n");
				} else {
					bw.write("WINNER: " + name[1] + "\n");
				}

				player = 0;
				score = new int[2];

				if (str.equals(".")) {
					break;
				}
				bw.write("\n");
				continue;
			}

			st = new StringTokenizer(str);

			if (player < 2) {
				st.nextToken();
				name[player++] = st.nextToken();
			} else {
				String first = map.get(st.nextToken());
				String second = map.get(st.nextToken());

				if (first.equals(second)) {
					continue;
				} else {
					if (first.equals("Rock")) {
						if (second.equals("Scissors")) {
							score[0] += 1;
						} else if (second.equals("Paper")) {
							score[1] += 1;
						}
					} else if (first.equals("Scissors")) {
						if (second.equals("Rock")) {
							score[1] += 1;
						} else if (second.equals("Paper")) {
							score[0] += 1;
						}
					} else if (first.equals("Paper")) {
						if (second.equals("Rock")) {
							score[0] += 1;
						} else if (second.equals("Scissors")) {
							score[1] += 1;
						}
					}
				}
			}
		}
		bw.flush();
	}
}
