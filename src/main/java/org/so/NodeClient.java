package org.so;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class NodeClient {

    public static void listFiles(String host, int port) {
        System.out.println(host + ":" + port);
        try (Socket socket = new Socket(host, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            out.println("LIST_FILES");
            System.out.println("Listing files");
            String response;
            while ((response = in.readLine()) != null) {
                System.out.println(response);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());

        }
    }

    public static void syncFile(String host, int port) {
        try (Socket socket = new Socket(host, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            out.println("LIST_FILES");
            String response;
            while ((response = in.readLine()) != null) {

            }
            out.println("SYNC_FILE");

            //out.println(filePath);

           // String response;
            while ((response = in.readLine()) != null) {
                System.out.println(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteFile(String host, int port) {
        try(Socket socket = new Socket(host, port);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))){
            listFiles(host,port);
            out.println("DELETE_FILE");
            System.out.println("Which folder or filer?");
            String file = new Scanner(System.in).nextLine();
            out.println(file);
            String response = in.readLine();
            System.out.println(response);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
