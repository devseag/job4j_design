package ru.job4j.io;

import java.io.*;

public class Analysis {
    public void unavailable(String source, String target) {
        try (BufferedReader b = new BufferedReader(new FileReader(source));
             PrintWriter p = new PrintWriter(target)) {
            String line;
            StringBuilder st = new StringBuilder();
            while (b.ready()) {
                line = b.readLine();
                if (st.length() == 0 && (line.startsWith("500") || line.startsWith("400"))) {
                    st.append(line.split(" ")[1]).append(";");
                } else if (st.length() != 0 && line.startsWith("200")) {
                    st.append(line.split(" ")[1]).append(";");
                    p.println(st);
                    st.setLength(0);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("data/server.log", "data/target.csv");
    }
}