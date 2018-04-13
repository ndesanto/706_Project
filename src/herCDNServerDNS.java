import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import static java.lang.Thread.sleep;

public class herCDNServerDNS {
//
//    static Config configuration = new Config();
//    public static String ip1 = configuration.IP1;
//    public static String ip2 = configuration.IP2;
//    public static String ip3 = configuration.IP3;
//    public static String ip4 = configuration.IP4;
//    public static String protocol = configuration.PROTOCOL;
//    public static String port = configuration.PORT;

    public static void main(String[] args) throws IOException, InterruptedException {

        // Part 4
        byte buffer[] = new byte[128];
        byte buffer2[] = new byte[128];
        DatagramSocket server = new DatagramSocket(40403);
        System.out.println("Running herCDNServerDNS...");

        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        server.receive(packet);
        String response = new String(packet.getData(), 0, packet.getLength());

        InetAddress addressClientServer = packet.getAddress();
        sleep(3000);
        System.out.println("wait...");

        String type = "A";
        buffer2 = type.getBytes();
        packet = new DatagramPacket(buffer2,buffer2.length,addressClientServer,40400);
        server.send(packet);

    }
}
