import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SessionInfo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String logFile = args[0];
		String line = null;

		Map<Integer, List<Long>> sessions = new HashMap<Integer, List<Long>>();

		try {
			FileReader fileReader = new FileReader(logFile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {
				String[] parts = line.split(",\\s");
				int sessionId = Integer.parseInt(parts[0]);
				if (sessions.containsKey(sessionId)) {
					sessions.get(sessionId).add(Long.parseLong(parts[1]));
				} else {
					List<Long> timestamps = new ArrayList<>();
					timestamps.add(Long.parseLong(parts[1]));
					sessions.put(sessionId, timestamps);
				}
			}
			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Unable to open file '" + logFile + "'");
		} catch (IOException ex) {
			System.out.println("Error reading file '" + logFile + "'");
		}

		// System.out.println(sessions);

		Map<Integer, List<Long>> sessionCount = new HashMap<Integer, List<Long>>();
		int maxCount = 0;
		int maxUser = 0;
		for (int id : sessions.keySet()) {
			List<Long> timestamps = sessions.get(id);
			Collections.sort(timestamps);
			for (int i = 0; i < timestamps.size() - 1; i++) {
				long startTime = timestamps.get(i);
				int count = 1;

				for (int j = i + 1; j < timestamps.size(); j++) {
					if (timestamps.get(j) - startTime <= 3600) {
						count++;
					} else {
						if (maxCount <= count) {
							if (maxCount == count) {
								if (sessionCount.get(maxUser).get(1) < timestamps.get(j - 1)) {
									maxUser = id;
								}
							} else {
								maxUser = id;
								
							}
							maxCount = count;
							List<Long> details = new ArrayList<>();
							details.add((long) count);
							details.add(timestamps.get(j - 1));
							sessionCount.put(id, details);
						}
						
						
						break;
					}
				}
			}
		}
		
		System.out.println(maxUser);
		System.out.println(sessionCount.get(maxUser));

	}

}
