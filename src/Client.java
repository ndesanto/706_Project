import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;

import static java.lang.Thread.sleep;

public class Client {
    static Config configuration = new Config();
    public static String ip1 = configuration.IP1;
    public static String ip2 = configuration.IP2;
    public static String ip3 = configuration.IP3;
    public static String ip4 = configuration.IP4;
    public static String protocol = configuration.PROTOCOL;
    public static String port = configuration.PORT;


    public static void main(String[] args) throws IOException, InterruptedException {

        //Part 1
        DatagramSocket toServ= new DatagramSocket();
        String IP = ip1;

        InetAddress a = InetAddress.getByName(IP);

        JFrame frame = new JFrame();
        String words = "open hiscinema.com?";

        JOptionPane.showMessageDialog(frame, words);
        Socket s = new Socket(ip2, 40401);

        BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String url = input.readLine();
        System.out.println(url);
        File htmlFile = new File(url);
        Desktop.getDesktop().browse(htmlFile.toURI());

        String videonum = JOptionPane.showInputDialog( "Which video would you like to watch?");
        videonum += "V";
        sleep(3000);
        System.out.println("wait...");

        //Part 2
        byte[] buffer = videonum.getBytes();
        DatagramPacket pack = new DatagramPacket(buffer,buffer.length,a,40400);
        toServ.send(pack);
        pack = new DatagramPacket(buffer,buffer.length);
        toServ.receive(pack);
        String ans = new String(pack.getData(),0,pack.getLength());
        System.out.println(ans);
        //System.exit(0);

    }
}
