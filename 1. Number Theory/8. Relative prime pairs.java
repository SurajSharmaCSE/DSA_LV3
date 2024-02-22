import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        // main logic 

            String[] st = br.readLine().split(" ");
            int l = Integer.parseInt(st[0]);
            int r = Integer.parseInt(st[1]);
            sb.append("YES\n");
            for(int i=0;i<r-l+1;i+=2)
            {
                 sb.append(l+i +" "+(l+i+1)+"\n");    
            }

        System.out.println(sb);
    }
}