package org.so;



public class Main {

    public static void main(String[] args) {
        switch (args[0]){
            case "1":{
                System.out.println("Cluster Master Node");
                Master.MasterServer();
                break;
            }
            case "2":{
                System.out.println("Cluster Node");
                 Client.startNodeServer(3333);
                break;

            }
        }


    }
}