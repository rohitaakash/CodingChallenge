import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class StringBeauty {

	public static void main(String[] args) throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
		BufferedReader in = new BufferedReader(reader);
		String line;
		while ((line = in.readLine()) != null) {
			int[] count = new int[26];

			for (int i = 0; i < line.length(); i++) {
				if (line.charAt(i) >= 'A' && line.charAt(i) <= 'Z') {
					count[line.charAt(i) - 'A'] += 1;
				} else if (line.charAt(i) >= 'a' && line.charAt(i) <= 'z') {
					count[line.charAt(i) - 'a'] += 1;
				}
			}

			Arrays.sort(count);
			int beauty = 26;
			int sum = 0;
			for (int i = count.length - 1; i >= 0; i--) {
				sum = sum + beauty * count[i];
				beauty--;
			}

			System.out.println(sum);
		}

	}
}
