package network.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Main {

    public static void main(String[] args) throws IOException {

        int port = 8081;

        ServerSocket serverSocket = new ServerSocket(port); // порт можете выбрать любой в доступном диапазоне 0-65536. Но чтобы не нарваться на уже занятый - рекомендуем использовать около 8080
        Socket clientSocket = serverSocket.accept(); // ждем подключения
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        System.out.println("New connection accepted");

        out.println("Write your name");
        final String name = in.readLine();

        out.println("Are you child? (yes/no)");
        final String age = in.readLine();

        switch (age) {
            case "yes":
                out.println(String.format("Welcome to the kids area, %s! Let's play!", name));
                break;
            case "no":
                out.println(String.format("Welcome to the adult zone, %s! " +
                        "Have a good rest, or a good working day!", name));
                break;
            default:
                out.println("Некорректный ввод!");
        }
    }
}
