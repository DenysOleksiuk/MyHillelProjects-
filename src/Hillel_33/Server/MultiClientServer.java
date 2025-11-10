package Hillel_33.Server;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.Instant;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MultiClientServer {

    private static final Logger logger = LogManager.getLogger(MultiClientServer.class);
    private final int port;
    private ServerSocket serverSocket;
    private final AtomicInteger clientCounter = new AtomicInteger(0);

    private final Map<String, ClientHandler> activeClients = new ConcurrentHashMap<>();

    public MultiClientServer(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        serverSocket = new ServerSocket(port);
        logger.info("[SERVER] Server started on port {}", port);

        while (!serverSocket.isClosed()) {
            Socket clientSocket = serverSocket.accept();
            String clientName = "client - " + clientCounter.incrementAndGet();
            ClientHandler clientHandler = new ClientHandler(clientName, clientSocket, this);
            activeClients.put(clientName, clientHandler);
            logger.info("[SERVER] {} successfully connected ", clientName);
            new Thread(clientHandler).start();
        }
    }

    public void removeClient(String clientName) {
        activeClients.remove(clientName);
        logger.info("[SERVER] {} disconnected ", clientName);
    }

    public Map<String, ClientHandler> getActiveClients() {
        return Collections.unmodifiableMap(activeClients);
    }

    public static void main(String[] args) {
        int port = 12345;
        MultiClientServer server = new MultiClientServer(port);
        try {
            server.start();
        } catch (IOException e) {
            logger.error("Server error: ", e);
        }
    }
}

