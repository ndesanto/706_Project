import java.io.IOException;
import java.net.*;

import static java.lang.Thread.sleep;

public class HCServerDNS {
    static Config configuration = new Config();
//    public static String ip1 = configuration.IP1;
//    public static String ip2 = configuration.IP2;
    public static String ip3 = configuration.IP3;
//    public static String ip4 = configuration.IP4;
//    public static String protocol = configuration.PROTOCOL;
//    public static String port = configuration.PORT;

    public static void main(String[] args) throws IOException, InterruptedException {

        // Part 3
        String IP3 = ip3;
        byte buffer[] = new byte[128];
        byte buffer2[] = new byte[128];
        DatagramSocket server = new DatagramSocket(40402);
        System.out.println("Running HCServerDNS...");

        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        server.receive(packet);
        String response = new String(packet.getData(), 0, packet.getLength());

        InetAddress addressClientServer = packet.getAddress();
        sleep(3000);
        System.out.println("wait...");

        buffer2 = IP3.getBytes();
        packet = new DatagramPacket(buffer2,buffer2.length,addressClientServer,40400);
        server.send(packet);

    }
}
