import java.io.*;


/*
   This is where we store the DDNS records and the IP Addresses
   and ports so we do not have to change all the files individually.
*/
public class Config {


    String IP1 = "192.168.1.8";
    String IP2 = "192.168.1.8";
    String IP3 = "192.168.1.8";
    String IP4 = "192.168.1.8";
    String PORT = "40400";
    String PROTOCOL = "V";

    String DDNSclient = "clientserver," + IP1 + ", " + PROTOCOL;
    String DDNShc = "hiscinema.com," + IP2 + ", NS";
    String DDNShcdn = "herCDN.com," + IP3 + ", NS";
}
