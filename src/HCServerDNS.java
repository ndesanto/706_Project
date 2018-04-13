import java.io.IOException;
import java.net.*;

public class HCServerDNS {
    static Config configuration = new Config();
    public static String ip1 = configuration.IP1;
    public static String ip2 = configuration.IP2;
    public static String ip3 = configuration.IP3;
    public static String ip4 = configuration.IP4;
    public static String protocol = configuration.PROTOCOL;
    public static String port = configuration.PORT;

    public static void main(String[] args) throws IOException {
        String IP = ip2;
        String IP3 = ip3;
        byte buffer[] = new byte[128];
        byte buffer2[] = new byte[128];
        DatagramSocket server2 = new DatagramSocket(40402);
        System.out.println("Running HCServerDNS...");

        DatagramPacket packet2 = new DatagramPacket(buffer, buffer.length);
        server2.receive(packet2);
        String answer = new String(packet2.getData(), 0, packet2.getLength());
        System.out.println(answer);

        int p2 = packet2.getPort();
        InetAddress a2 = packet2.getAddress();

        buffer2 = IP3.getBytes();
        System.out.println(buffer2);
        packet2 = new DatagramPacket(buffer2,buffer2.length,a2,40400);
        server2.send(packet2);



    }

}
