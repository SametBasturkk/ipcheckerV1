package ipsorgu.firstVersion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ipDbReader {
    private static final int INITIAL_CAPACITY = 10000; // Adjust the value based on your data size
    public static List ipDb = new ArrayList<>(INITIAL_CAPACITY);

    public ipDbReader() {
        System.out.println("IpDbReader is running");
    }

    public void readerDB(String dbPath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(dbPath))) {
            String line;
            while ((line = br.readLine()) != null) {
                List<String> values = parseCSVLine(line);
                ipDb.add(values);
            }
        }
    }

    private List<String> parseCSVLine(String line) {
        List<String> values = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == ',') {
                values.add(sb.toString());
                sb.setLength(0); // Reset the StringBuilder for the next value
            } else {
                sb.append(c);
            }
        }
        values.add(sb.toString()); // Add the last value
        return values;
    }

    public static List getIpDb() {
        return ipDb;
    }
}
