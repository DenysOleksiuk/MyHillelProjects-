package Hillel_33.Server;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.net.Socket;
import java.time.Instant;

public class ClientHandler implements Runnable {

    private static final Logger logger = LogManager.getLogger(ClientHandler.class);

    private final String clientName;
    private final Socket socket;
    private final MultiClientServer server;
    private final Instant connectedAt;

    public ClientHandler(String clientName, Socket socket, MultiClientServer server) {
        this.clientName = clientName;
        this.socket = socket;
        this.server = server;
        this.connectedAt = Instant.now();
    }

    public String getClientName() {
        return clientName;
    }

    public Instant getConnectedAt() {
        return connectedAt;
    }

    @Override
    public void run() {
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))
        ) {
            String message;
            while ((message = in.readLine()) != null) {
                logger.info("[{}] отримано: {}", clientName, message.trim());
                if ("exit".equalsIgnoreCase(message.trim())) {
                    out.write("Goodbye!\n");
                    out.flush();
                    break;
                } else {
                    out.write("Received: " + message + "\n");
                    out.flush();
                }
            }
        } catch (IOException e) {
            logger.error("Помилка у клієнта {}: ", clientName, e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                logger.error("Не вдалося закрити сокет для {}: ", clientName, e);
            }
            server.removeClient(clientName);
        }
    }
}
