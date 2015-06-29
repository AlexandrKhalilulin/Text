package ak.util;

import java.io.*;

public class Files {
    public static String getText() {
        InputStream loader = ClassLoader.getSystemResourceAsStream("sample.txt");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(loader, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        StringBuilder sb = new StringBuilder();
        try {
            while (reader.readLine() != null) {
                sb.append(reader.readLine()).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        sb.trimToSize();
        return sb.toString();
    }
}
