package Application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {

    private String nameFile;

    private String content;

    public WriteToFile(String nameFile,String content) {
        this.nameFile = nameFile;
        this.content = content;
    }

    public void write(){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(nameFile+".txt"))) {

            //String content = "This is the content to write into file\n";

            bw.write(this.content);

            System.out.println("Done");

        } catch (IOException e) {

            e.printStackTrace();

        }
    }
}

