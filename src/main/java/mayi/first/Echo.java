package mayi.first;

import java.io.*;

/**
 * @Project:spring_boot_final
 * @PackageName:mayi.first
 * @Author: Chang
 * @DateTime:2018/9/15 15:06.
 * @Description:
 */
public class Echo {
    public static void main(String[] args) throws IOException {
        String charSet="UTF-8";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in,charSet));
        BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(System.out,charSet));
        String message;
        while((message = reader.readLine()) != null){
            writer.write(message+"\n");
            writer.flush();
        }
    }
}
