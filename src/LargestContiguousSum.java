

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class LargestContiguousSum {
	/**
	 * Iterate through each line of input.
	 */
	public static void main(String[] args) throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
		BufferedReader in = new BufferedReader(reader);
		String line;
		while ((line = in.readLine()) != null) {
			
			if(line.length() != 0) {
				String[] arr = line.split("\\s*(,)\\s*");
				if(arr.length > 0) {
					int max = Integer.parseInt(arr[0]);
					int sum = 0;
					for (int i = 0; i < arr.length; i++) {
						sum += Integer.parseInt(arr[i]);
						if (sum > max) {
							max = sum;
						} else if (sum < 0) {
							sum = 0;
						}
					}
					System.out.println(max);
				}
			}else {
				return;				
			}
			
		}
		
	}

}
