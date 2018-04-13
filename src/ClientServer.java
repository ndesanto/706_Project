import java.io.*;
import java.net.*;

public class ClientServer {
    static Config configuration = new Config();
    public static String ip1 = configuration.IP1;
    public static String ip2 = configuration.IP2;
    public static String ip3 = configuration.IP3;
    public static String ip4 = configuration.IP4;
    public static String protocol = configuration.PROTOCOL;
    public static String port = configuration.PORT;

    public static void main(String[] args) throws IOException {
        // Part 1
        String IP = ip1;
        byte buffer[] = new byte[128];
        byte buffer2[] = new byte[128];
        DatagramSocket server = new DatagramSocket(40400);
       // DatagramSocket server2= new DatagramSocket(40401);
            //ServerSocket listener = new ServerSocket(40400);
        System.out.println("Running ClientServer....");
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                server.receive(packet);
                int p = packet.getPort();
                InetAddress a = packet.getAddress();
                packet = new DatagramPacket(buffer, buffer.length,a,p);
                String answer = new String(packet.getData(), 0, packet.getLength());

                String videonum = answer.substring(0,1);
                String type = answer.substring(1,2);

                if((type.charAt(0)) == 'V'){

                    if (Integer.parseInt(videonum.trim()) == 1) {
                        System.out.println("Works! Received Request for Video 1");
                        InetAddress aSend = InetAddress.getByName(ip2);

                        buffer = type.getBytes();
                        DatagramPacket packet2 = new DatagramPacket(buffer,buffer.length,aSend,40402);
                        server.send(packet2);

                        packet2 = new DatagramPacket(buffer2,buffer2.length);
                        server.receive(packet2);
                        String received = new String(packet2.getData(),0,packet2.getLength());
                        System.out.println(received + " Is HerCDN IP");
                        

                    }
                    else
                        System.out.println("notwork");
        }
    }


}
