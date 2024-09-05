package org.so;

import java.io.*;
import java.net.*;

public class Client {

    public static void startNodeServer(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Node server started on port " + port);

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {

                    String request = in.readLine();

                    if ("LIST_FILES".equals(request)) {
                        System.out.println("Listing files");

                        File dir = new File(System.getProperty("user.dir"));
                        File[] files = dir.listFiles();
                        if (files != null) {
                            for (File file : files) {
                                out.println(file.getName());
                            }
                        }
                    } else if ("SYNC_FILE".equals(request)) {
                        String filePath = in.readLine();

                        out.println("Arquivo " + filePath + " sincronizado com sucesso.");
                    } else if ("DELETE_FILE".equals(request)) {
                        String filePath = in.readLine();
                        System.out.println("Deleting file " + System.getProperty("user.dir")+"/"+filePath);
                        if (new File(System.getProperty("user.dir")+"/"+filePath).delete()) {
                            System.out.println("File " + filePath + " deletado com sucesso.");
                            out.println("Arquivo deletado");
                        } else {
                            System.out.println("File " + filePath + " nao foi deletado.");
                            out.println("Arquivo não encontrado");
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
