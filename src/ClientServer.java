import java.io.*;
import java.net.*;

import static java.lang.Thread.sleep;

public class ClientServer {
    static Config configuration = new Config();
//    public static String ip1 = configuration.IP1;
    public static String ip2 = configuration.IP2;
//    public static String ip3 = configuration.IP3;
    public static String ip4 = configuration.IP4;
//    public static String protocol = configuration.PROTOCOL;
//    public static String port = configuration.PORT;

    public static void main(String[] args) throws IOException, InterruptedException {

        // Part 1
        String IP2 = ip2;
        byte buffer[] = new byte[128];
        byte buffer2[] = new byte[128];
        byte buffer3[] = new byte[128];
        byte buffer4[] = new byte[128];
        DatagramSocket server = new DatagramSocket(40400);

        System.out.println("Running ClientServer....");
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        server.receive(packet);
        int port = packet.getPort();
        InetAddress addressClient = packet.getAddress();
        packet = new DatagramPacket(buffer, buffer.length,addressClient,port);
        String response = new String(packet.getData(), 0, packet.getLength());

        String videoNum = response.substring(0,1);
        String type = response.substring(1,2);

                if((type.charAt(0)) == 'V'){
                    if (Integer.parseInt(videoNum.trim()) == 1) {
                        System.out.println("Works! Received Request for Video 1");

                        // Part 3
                        InetAddress addressHCSDNS = InetAddress.getByName(IP2);

                        buffer = type.getBytes();
                        DatagramPacket packet2 = new DatagramPacket(buffer,buffer.length,addressHCSDNS,40402);
                        server.send(packet2);

                        packet2 = new DatagramPacket(buffer2,buffer2.length);
                        server.receive(packet2);
                        String received = new String(packet2.getData(),0,packet2.getLength());
                        System.out.println(received + " Is HerCDN IP");

                        sleep(3000);
                        System.out.println("wait...");

                        // Part 4
                        InetAddress addressCDNDNS = InetAddress.getByName(received);

                        buffer = type.getBytes();
                        DatagramPacket packet3 = new DatagramPacket(buffer,buffer.length,addressCDNDNS,40403);
                        server.send(packet3);

                        packet3 = new DatagramPacket(buffer3,buffer3.length);
                        server.receive(packet3);
                        String received2 = new String(packet3.getData(),0,packet3.getLength());
                        System.out.println(received2 + " is the type");

                        sleep(3000);
                        System.out.println("wait...");
                        //Part 5
                        buffer4 = ip4.getBytes();
                        packet3 = new DatagramPacket(buffer4,buffer4.length,addressClient,40405);
                        server.send(packet3);
                        sleep(3000);
                        System.out.println("wait...");

                    } else
                        System.out.println("Invalid Video");
        }
    }


}
