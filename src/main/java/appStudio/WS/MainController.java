package appStudio.WS;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;

public class MainController {
    public static void main(String[] args) {
        try {
            System.out.println("===============Servicios Rest Iniciados=================");
            HttpServer servidor = HttpServer.create(new InetSocketAddress(5000),0);
            servidor.createContext("/WS/getClients", WSClient::getAllClient);
            servidor.createContext("/WS/getClient",WSClient::getClient);
            servidor.createContext("/WS/createClient", WSClient::createClient);
            servidor.start();

        } catch (IOException e) {

            throw new RuntimeException(e);
        }
    }
}
