import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CompileFileStatistics {

    public static void main(String[] args) {
        String S = "my.song.mp3 11b\ngreatSong.flac 1000b\nnot3.txt 5b\nvideo.mp4 200b\ngame.exe 100b\nmov!e.mkv 10000b";
        System.out.println(fileStatistics(S));
    }

    private static String fileStatistics(String S) {
        Map<String, Integer> statistics = new HashMap<>();
        Map<String, String> categories = new HashMap<>();

        categories.put("mp3", "music");
        categories.put("aac", "music");
        categories.put("flac", "music");
        categories.put("jpg", "images");
        categories.put("bmp", "images");
        categories.put("gif", "images");
        categories.put("mp4", "movies");
        categories.put("avi", "movies");
        categories.put("mkv", "movies");
        categories.put("7z", "other");
        categories.put("txt", "other");
        categories.put("zip", "other");

        statistics.put("music", 0);
        statistics.put("images", 0);
        statistics.put("movies", 0);
        statistics.put("other", 0);

        String[] files = S.split("\n");
        for (int i = 0; i < files.length; i++) {
            String[] details = files[i].split(" ");
            int size = Integer.parseInt(details[1].substring(0, details[1].length() - 1));
            String extension = details[0].substring(details[0].lastIndexOf('.') + 1);
            if(categories.containsKey(extension)) {
                String category = categories.get(extension);
                statistics.put(category, statistics.get(category) + size);
            } else {
                categories.put(extension, "other");
                statistics.put("other", statistics.get("other") + size);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("music ").append(statistics.get("music")).append("b\n");
        sb.append("images ").append(statistics.get("images")).append("b\n");
        sb.append("movies ").append(statistics.get("movies")).append("b\n");
        sb.append("other ").append(statistics.get("other")).append("b");


        System.out.println(Arrays.asList(files));
        return sb.toString();
    }
}
