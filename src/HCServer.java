import java.awt.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

public class HCServer {
    static Config configuration = new Config();
    public static String ip1 = configuration.IP1;
    public static String ip2 = configuration.IP2;
    public static String ip3 = configuration.IP3;
    public static String ip4 = configuration.IP4;
    public static String protocol = configuration.PROTOCOL;
    public static String port = configuration.PORT;

    public static void main(String[] args) throws IOException {
        ServerSocket listener = new ServerSocket(40401);
        System.out.println("Running hisCinema Server....");
        try {
            while (true) {
                Socket socket = listener.accept();
                try {
                    PrintWriter out =
                            new PrintWriter(socket.getOutputStream(), true);
                    out.println("Socket Address: " + socket.getLocalSocketAddress() + "Port: " + socket.getLocalPort() + "Remote Socket Address: " + socket.getRemoteSocketAddress());
                } finally {
                    socket.close();
                }
            }
        }
        finally {
            listener.close();
        }


    }
}
