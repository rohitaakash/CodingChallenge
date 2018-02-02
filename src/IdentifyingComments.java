import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class IdentifyingComments {

	public static void main(String[] args) throws IOException {
		InputStreamReader ir = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(ir);

        List<String> code = new ArrayList<>();
        String line = br.readLine();
        while (line!=null) {
            code.add(line);
            line = br.readLine();
        }

        List<String> comments = new ArrayList<>();
        for (int i = 0; i < code.size(); i++) {
            if (code.get(i).indexOf("/*") != -1) {
                if (code.get(i).indexOf("*/") != -1) {
                    comments.add(code.get(i).substring(code.get(i).indexOf("/*"), code.get(i).indexOf("*/") + 2));
                    if(code.get(i).indexOf("//") != -1) comments.add(code.get(i).substring(code.get(i).indexOf("//")));
                } else {
                    while (code.get(i).indexOf("*/") == -1) {
                        comments.add(code.get(i));
                        i++;
                        if (i >= code.size())
                            break;
                    }
                    comments.add(code.get(i).substring(0, code.get(i).indexOf("*/") + 2));
                    if(code.get(i).indexOf("//") != -1) comments.add(code.get(i).substring(code.get(i).indexOf("//")));
                }
                
            } else if (code.get(i).indexOf("//") != -1) {
                comments.add(code.get(i).substring(code.get(i).indexOf("//")));
            }
        }

        for (String i : comments) {
            System.out.println(i.trim());
        }
	}
}
