package org.so;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Master {
    private static final boolean DEV = false;
    private static final String[] NODES = DEV? new String[]{"127.0.0.1"} : new String[]{"192.168.0.3", "192.168.0.4"};
    private static final int PORT = 3333;
    //private static ExecutorService executorService = Executors.newFixedThreadPool(NODES.length-1);

    public static void MasterServer(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Cluster Master Node");
        while (true){
            System.out.println("1. Listar Arquivos");
            System.out.println("2. Deletar Arquivos");
            System.out.println("3. Sair");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    for (String node : NODES) {
                        System.out.println("Option 1");
                        NodeClient.listFiles(node, PORT);
                    }

                    break;
                case 2:

                    for (String node : NODES) {

                        NodeClient.deleteFile(node, PORT);

                    }
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Opção inválida.");
            }
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
