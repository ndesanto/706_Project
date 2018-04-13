import java.io.*;
import java.net.Socket;

import java.net.ServerSocket;


public class HerCDNServer {

    public static void main(String[] args) {
        final int PORT = 40400;
        final String FILENAME = "src\\video.mp4";
        FileInputStream fileIn;
        BufferedInputStream buffer;
        OutputStream out;
        Socket socket;

        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            while(true){
                System.out.println("server is waiting");
                socket = serverSocket.accept();
                System.out.println("Found: " + socket);
                File file = new File (FILENAME);
                byte[] fileBuffer = new byte [(int)file.length()];
                fileIn = new FileInputStream(file);
                buffer = new BufferedInputStream(fileIn);
                buffer.read(fileBuffer,0, fileBuffer.length);
                out = socket.getOutputStream();
                System.out.println("Sending: " + FILENAME + "(" + fileBuffer.length + " bytes)" );
                out.write(fileBuffer, 0, fileBuffer.length);
                out.flush();
                System.out.println("finito");
                buffer.close();
                out.close();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
