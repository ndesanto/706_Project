import java.io.*;
import java.net.*;

import static java.lang.Thread.sleep;

public class ClientServer {
    static Config configuration = new Config();
    public static String ip2 = configuration.IP2;
    public static String ip4 = configuration.IP4;

    public static void main(String[] args) throws IOException, InterruptedException {
        //Declaring Variables
        String IP2 = ip2;
        byte buffer[] = new byte[128];
        byte buffer2[] = new byte[128];
        byte buffer3[] = new byte[128];
        byte buffer4[] = new byte[128];
        DatagramSocket server = new DatagramSocket(40400);

        // Part 1
        // Runs the DNS server, receives a packet from client for the video
        // number chosen and its type (V)
        System.out.println("Running ClientServer....");
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        server.receive(packet);
        System.out.println("Found: " + server);
        int port = packet.getPort();
        InetAddress addressClient = packet.getAddress();
        packet = new DatagramPacket(buffer, buffer.length,addressClient,port);
        String response = new String(packet.getData(), 0, packet.getLength());

        String videoNum = response.substring(0,1);
        String type = response.substring(1,2);

        // Only works if the type is V
        // If user chooses a valid video 1-5
                if((type.charAt(0)) == 'V'){

                    /*
                        If the request is valid, put the type in the buffer to send to the HCServer DNS
                        Part 3 sends a UDP packet and receives one from the dummy hisCinema-DNS
                        Part 4 sends a UDP packet and receives one from the dummy herCDN-DNS
                        Part 5 sends a UDP packet to the client with the IP of herCDN
                    */
                    if (Integer.parseInt(videoNum.trim()) == 1) {
                        System.out.println("Works! Received Request for Video 1");

                        // Part 3
                        InetAddress addressHCSDNS = InetAddress.getByName(IP2);

                        buffer = type.getBytes();
                        DatagramPacket packet2 = new DatagramPacket(buffer,buffer.length,addressHCSDNS,40402);
                        server.send(packet2);

                        packet2 = new DatagramPacket(buffer2,buffer2.length);
                        server.receive(packet2);
                        System.out.println("Found: " + server);
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
                        System.out.println("Found: " + server);
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

                        } else if (Integer.parseInt(videoNum.trim()) == 2) {
                            System.out.println("Works! Received Request for Video 2");

                            // Part 3
                            InetAddress addressHCSDNS = InetAddress.getByName(IP2);

                            buffer = type.getBytes();
                            DatagramPacket packet2 = new DatagramPacket(buffer,buffer.length,addressHCSDNS,40402);
                            server.send(packet2);

                            packet2 = new DatagramPacket(buffer2,buffer2.length);
                            server.receive(packet2);
                        System.out.println("Found: " + packet2);
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
                        System.out.println("Found: " + packet3);
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

                        } else if (Integer.parseInt(videoNum.trim()) == 3) {
                            System.out.println("Works! Received Request for Video 3");

                            // Part 3
                            InetAddress addressHCSDNS = InetAddress.getByName(IP2);

                            buffer = type.getBytes();
                            DatagramPacket packet2 = new DatagramPacket(buffer,buffer.length,addressHCSDNS,40402);
                            server.send(packet2);

                            packet2 = new DatagramPacket(buffer2,buffer2.length);
                            server.receive(packet2);
                        System.out.println("Found: " + server);
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
                        System.out.println("Found: " + server);
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

                        } else if (Integer.parseInt(videoNum.trim()) == 4) {
                            System.out.println("Works! Received Request for Video 4");

                            // Part 3
                            InetAddress addressHCSDNS = InetAddress.getByName(IP2);

                            buffer = type.getBytes();
                            DatagramPacket packet2 = new DatagramPacket(buffer,buffer.length,addressHCSDNS,40402);
                            server.send(packet2);

                            packet2 = new DatagramPacket(buffer2,buffer2.length);
                            server.receive(packet2);
                        System.out.println("Found: " + server);
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
                        System.out.println("Found: " + server);
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

                        } else if (Integer.parseInt(videoNum.trim()) == 5) {
                            System.out.println("Works! Received Request for Video 5");

                            // Part 3
                            InetAddress addressHCSDNS = InetAddress.getByName(IP2);

                            buffer = type.getBytes();
                            DatagramPacket packet2 = new DatagramPacket(buffer,buffer.length,addressHCSDNS,40402);
                            server.send(packet2);

                            packet2 = new DatagramPacket(buffer2,buffer2.length);
                            server.receive(packet2);
                        System.out.println("Found: " + server);
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
                        System.out.println("Found: " + server);
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
