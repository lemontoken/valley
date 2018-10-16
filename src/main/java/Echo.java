import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Echo {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String message;
        while((message = reader.readLine()) != null){
            System.out.println(message);
        }
    }
}
