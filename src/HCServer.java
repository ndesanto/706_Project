import java.io.*;
import java.net.*;

import static java.lang.Thread.sleep;

public class HCServer {
//    static Config configuration = new Config();
//    public static String ip1 = configuration.IP1;
//    public static String ip2 = configuration.IP2;
//    public static String ip3 = configuration.IP3;
//    public static String ip4 = configuration.IP4;
//    public static String protocol = configuration.PROTOCOL;
//    public static String port = configuration.PORT;

    public static void main(String[] args) throws IOException, InterruptedException {

        // Part 2
        ServerSocket server = new ServerSocket(40401);
        System.out.println("Running hisCinema Server....");

        Socket socket = server.accept();

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println("src/index.html");

        System.out.println("Sent index File");

        sleep(3000);
        System.out.println("wait...");
    }
}



