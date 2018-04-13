import java.io.*;
import java.net.*;

import static java.lang.Thread.sleep;

public class HCServer {


    public static void main(String[] args) throws IOException, InterruptedException {

        // Part 2
        // TCP handshake with client, sends the index file
        ServerSocket server = new ServerSocket(40401);
        System.out.println("Running hisCinema Server....");

        Socket socket = server.accept();

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println("src/index.html");
        System.out.println("Found: " + socket);
        System.out.println("Sent index File");

        sleep(3000);
        System.out.println("wait...");
    }
}



