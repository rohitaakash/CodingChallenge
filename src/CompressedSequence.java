import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class CompressedSequence {

	public static void main(String[] args) throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
		BufferedReader in = new BufferedReader(reader);
		String line;

		String[] arr = null;
		while ((line = in.readLine()) != null) {
			arr = line.split("\\s");
		}
		
			int sum = 1;
			int prevNum = Integer.parseInt(arr[0]);
			for (int i = 1; i < arr.length; i++) {
				int num = Integer.parseInt(arr[i]);
				if(num == prevNum) {
					sum = sum+1;
				}else {
					System.out.print(sum + " ");
					System.out.print(prevNum + " ");
					sum = 1;
					prevNum = num;
				}
			}
			System.out.print(sum + " ");
			System.out.print(Integer.parseInt(arr[arr.length-1]));
	}

}
