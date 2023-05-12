/*
 * D'après https://github.com/sharmaeklavya2/tcp-chat/ (un peu remanié)
 */

package fr.uparis.informatique.cpoo5.tcpdemo;

import java.net.*;
import java.io.*;



class ChatClient
{
    public static int port = 13000;
    public static BufferedReader con_br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args)throws IOException
    {
        System.out.print("Enter server address: ");
        String address = con_br.readLine();
        Socket sock = new Socket(address, port);
        BufferedReader sock_br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
        PrintWriter sock_pw = new PrintWriter(sock.getOutputStream(), true);
        System.out.println("Connection established");

        Thread chat_client_writer = new ChatWriter("chat_client_writer", sock_pw, con_br);
        chat_client_writer.start();
        
        String s;
        while((s = sock_br.readLine()) != null)
        {
            System.out.println("\rserver: " + s);
            System.out.print("> ");
        }
        sock.close();
    }
}
