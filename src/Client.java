import javax.swing.*;
import java.awt.*;
import java.awt.color.ICC_Profile;
import java.io.*;
import java.net.*;

import static java.lang.Thread.sleep;

public class Client {
    static Config configuration = new Config();
    public static String ip1 = configuration.IP1;
    public static String ip2 = configuration.IP2;
//    public static String ip3 = configuration.IP3;
//    public static String ip4 = configuration.IP4;
//    public static String protocol = configuration.PROTOCOL;
//    public static String port = configuration.PORT;

    public static void main(String[] args) throws IOException, InterruptedException {
        //Part 1
        String IP = ip1;
        Socket tcpServer = new Socket(ip2, 40401);
        DatagramSocket server= new DatagramSocket(40405);

        InetAddress address = InetAddress.getByName(IP);

        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame, "open hiscinema.com?");

        BufferedReader input = new BufferedReader(new InputStreamReader(tcpServer.getInputStream()));
        String url = input.readLine();
        File htmlFile = new File(url);
        Desktop.getDesktop().browse(htmlFile.toURI());

        String videoNumber = JOptionPane.showInputDialog( "Which video would you like to watch?");
        videoNumber += "V";

        sleep(3000);
        System.out.println("wait...");

        //Part 2
        byte[] buffer = videoNumber.getBytes();
        DatagramPacket packet = new DatagramPacket(buffer,buffer.length,address,40400);
        server.send(packet);

        sleep(3000);
        System.out.println("wait...");

        //Part 5
        byte buffer2[] = new byte[128];
        packet = new DatagramPacket(buffer2,buffer2.length);
        server.receive(packet);
        String response = new String(packet.getData(),0,packet.getLength());
        System.out.println(response + " is herCDNs IP");
        //ReceiveFile file = new ReceiveFile();
        String NEWFILENAME = "src/newvideo.mp4";
        Socket socket = new Socket(ip2, 40400);
        System.out.println("Connecting");

        byte[] fileBuffer = new byte[400000];
        InputStream in = socket.getInputStream();
        FileOutputStream fileOut = new FileOutputStream(NEWFILENAME);
        BufferedOutputStream bufferOutput = new BufferedOutputStream(fileOut);
        int bytesRead = in.read(fileBuffer, 0, fileBuffer.length);
        int current = bytesRead;

        do {
            bytesRead = in.read(fileBuffer, current, (fileBuffer.length - current));
            if (bytesRead >= 0) current += bytesRead;
        } while (bytesRead > -1);

        bufferOutput.write(fileBuffer, 0, current);
        bufferOutput.flush();
        System.out.println("File " + NEWFILENAME
                + " downloaded (" + current + " bytes read)");

    }
}
