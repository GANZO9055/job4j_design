package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream output = socket.getOutputStream();
                     BufferedReader input = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String string = input.readLine();
                    output.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    if (string.contains("Exit")) {
                        server.close();
                        continue;
                    }
                    if (string.contains("Hello")) {
                        output.write("Hello".getBytes());
                        continue;
                    }
                    if (string.contains("msg")) {
                        output.write("What".getBytes());
                    }
                    output.flush();
                }
            }
        }
    }
}
