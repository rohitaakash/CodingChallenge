import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class BinarySum {

	public static void main(String[] args) throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
		BufferedReader in = new BufferedReader(reader);
		String line;

		String[] num = null;
		while ((line = in.readLine()) != null) {
			num = line.split(",");
		}

		String s1 = num[0];
		String s2 = num[1];

		int i1 = s1.length() - 1;
		int i2 = s2.length() - 1;
		int carry = 0;

		StringBuilder sumNum = new StringBuilder();

		while (i1 != -1 || i2 != -1 || carry != 0) {
			int a = 0, b = 0, sum = 0;
			if (i1 != -1) {
				a = s1.charAt(i1) - '0';
				sum = sum + a;
				i1--;
			}

			if (i2 != -1) {
				b = s2.charAt(i2) - '0';
				sum = sum + b;
			}

			if (carry != 0)
				sum = sum + carry;

			if (sum == 0) {
				sumNum.append("0");
				carry = 0;
			} else if (sum == 1) {
				sumNum.append("1");
				carry = 0;
			} else if (sum == 2) {
				sumNum.append("0");
				carry = 1;
			} else if (sum == 3) {
				sumNum.append("1");
			}
		}

		sumNum.reverse();

		System.out.println(Integer.parseInt(sumNum.toString()));

	}

}
