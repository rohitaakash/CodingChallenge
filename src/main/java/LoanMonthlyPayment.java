

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;

public class LoanMonthlyPayment {
	/**
	 * Iterate through each line of input.
	 */
	public static void main(String[] args) throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
		BufferedReader in = new BufferedReader(reader);
		String line;
		while ((line = in.readLine()) != null) {
			if (line.length() != 0) {
				String[] arr = line.split("\\s*(~)\\s*");
				if (arr.length > 0) {
					double loanAmount = Double.parseDouble(arr[0]);
					double numOfPeriods = Double.parseDouble(arr[1])*12;
					double rate = Double.parseDouble(arr[2])/(100*12);
					double dPayment = Double.parseDouble(arr[3]);
					double pValue = loanAmount - dPayment;
					
					double monthlyPayment = (rate*pValue)/(1-Math.pow(1+rate, -numOfPeriods));
					double totalInterest = monthlyPayment*numOfPeriods - pValue;
					
					DecimalFormat df = new DecimalFormat("#.00");
					
					System.out.println(df.format(monthlyPayment) + "~" + Math.round(totalInterest));
				}
			} else {
				return;
			}
		}

	}
}
