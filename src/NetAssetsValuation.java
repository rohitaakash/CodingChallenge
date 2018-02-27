

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;

public class NetAssetsValuation {
	/**
	 * Iterate through each line of input.
	 */
	public static void main(String[] args) throws IOException {
		InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
		BufferedReader in = new BufferedReader(reader);
		String line;
		while ((line = in.readLine()) != null) {
			if (line.length() != 0) {
				String[] arr = line.split("\\|");
				if (arr.length > 0) {

					String[] pTemp = arr[0].split(":")[1].split(";");
					HashMap<String, Double> portfolio = new HashMap<>();
					for (int i = 0; i < pTemp.length; i++) {
						String[] temp = pTemp[i].split(",");
						portfolio.put(temp[0], Double.parseDouble(temp[1]) * Double.parseDouble(temp[2]));
					}

					String[] bTemp = arr[1].split(":")[1].split(";");
					HashMap<String, Double> benchmark = new HashMap<>();
					for (int i = 0; i < bTemp.length; i++) {
						String[] temp = bTemp[i].split(",");
						benchmark.put(temp[0], Double.parseDouble(temp[1]) * Double.parseDouble(temp[2]));
					}

					double portNav = 0.0;
					for (String s : portfolio.keySet()) {
						portNav += portfolio.get(s);
					}

					double benchNav = 0.0;
					for (String s : benchmark.keySet()) {
						benchNav += benchmark.get(s);
					}

					TreeMap<String, Double> map = new TreeMap<>();

					for (String s : portfolio.keySet()) {
						double diff = portfolio.get(s) / portNav;
						if (benchmark.containsKey(s)) {
							diff = diff - benchmark.get(s) / benchNav;
						}
						map.put(s, diff*100);
					}

					for (String s : benchmark.keySet()) {
						if (!map.containsKey(s)) {
							double diff = -1 * benchmark.get(s) / benchNav;
							map.put(s, diff*100);
						}

					}

					DecimalFormat df = new DecimalFormat("#0.00");					
					Iterator<String> itr = map.keySet().iterator();
					while(itr.hasNext()) {
						String s = itr.next();
						System.out.print(s + ":" + df.format(map.get(s)));
						if(itr.hasNext()) {
							System.out.print(",");
						}
					}

				}
			} else {
				return;
			}
		}
	}
}
