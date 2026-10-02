package org.example.proxyPattern;

// 1. Common Interface
interface DataService {
    String fetchData(String query);
}

// 2. Real Subject (Existed on Remote Server)
class RemoteDataService implements DataService {
    @Override
    public String fetchData(String query) {
        return "DATABASE_RESULT_FOR [" + query + "]";
    }
}

// 3. Remote Proxy (Handles Connection Details locally)
class RemoteDataProxy implements DataService {
    private RemoteDataService remoteService;
    private final String serverIp;

    public RemoteDataProxy(String serverIp) {
        this.serverIp = serverIp;
    }

    private void establishConnection() {
        System.out.println("[Remote Proxy] Connecting to Remote Server IP: " + serverIp + " over HTTPS...");
        // Simulated network connection delay & handshake
        this.remoteService = new RemoteDataService();
    }

    @Override
    public String fetchData(String query) {
        if (remoteService == null) {
            establishConnection();
        }
        System.out.println("[Remote Proxy] Forwarding query over network...");
        return remoteService.fetchData(query);
    }
}

// 4. Client Code
public class RemoteProxyDemo {
    public static void main(String[] args) {
        DataService proxy = new RemoteDataProxy("192.168.1.100");
        
        System.out.println("--- Querying Remote Service ---");
        String result = proxy.fetchData("SELECT * FROM users");
        System.out.println("Client received response: " + result);
    }
}