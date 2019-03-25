package java8test.ch8;

import java.io.*;

public class ExecuteAround {
    public String processFile(BufferedReaderProcessor p)  {
        try(BufferedReader br = new BufferedReader(new FileReader(""))) {
            return p.process(br);
        } catch (IOException e) {
            e.getMessage();
        }
        return "";
    }

    public void consoleWrite(BufferedWriterProcessor w) throws IOException {
        try(BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            w.process(bw);
        }
    }
    String oneLine = processFile((BufferedReader br) -> br.readLine());

    //                                     consoleWrite((BufferedWriter bw) -> bw.write("Hello World"));
}
interface BufferedReaderProcessor {
    String process(BufferedReader b) throws IOException;
}
interface  BufferedWriterProcessor {
    String process(BufferedWriter w) throws IOException;
}