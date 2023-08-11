package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//public class EchoServer {
//    public static void main(String[] args) throws IOException {
//        try (ServerSocket server = new ServerSocket(9000)) {
//            while (!server.isClosed()) {
//                Socket socket = server.accept();
//                try (OutputStream out = socket.getOutputStream();
//                     BufferedReader in = new BufferedReader(
//                             new InputStreamReader(socket.getInputStream()))) {
//                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
////                    for (String str = in.readLine(); str != null && !str.isEmpty(); str = in.readLine()) {
////                        System.out.println(str);
////                    }
//                    if (in.readLine().contains("/?msg=Bye")) {
//                        server.close();
//                    }
//                    out.flush();
//                }
//            }
//        }
//    }
//}

//public class EchoServer {
//    public static void main(String[] args) throws IOException {
//        try (ServerSocket server = new ServerSocket(9000)) {
//            while (!server.isClosed()) {
//                Socket socket = server.accept();
//                try (OutputStream out = socket.getOutputStream();
//                     BufferedReader in = new BufferedReader(
//                             new InputStreamReader(socket.getInputStream()))) {
////                    out.write("HTTP/1.1 200 OK\r\n".getBytes());
//                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
//                    out.write("Hello, dear friend.".getBytes());
//                    for (String str = in.readLine(); str != null && !str.isEmpty(); str = in.readLine()) {
//                        System.out.println(str);
//                    }
//                    out.flush();
//                }
//            }
//        }
//    }
//}

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    String line = in.readLine();
                    if (line.contains("/?msg=Exit")) {
                        out.write("Exit".getBytes());
                        server.close();
                    } else if (line.contains("/?msg=Hello")) { // http://localhost:9000/?msg=Hello
                        out.write("Hello".getBytes());
                    } else {
                        out.write(line.split(".*=")[1]
                                .split(" ")[0]
                                .getBytes());
                    }
                    out.flush();
                }
            }
        }
    }
}