package com.step07.problem03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class VitaBiodome03 {
    public static void main(String[] args) {
        final int PORT = 8080;
        System.out.println("서버가 시작되었습니다. 포트: " + PORT);

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                try {
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("클라이언트 연결됨: " + clientSocket.getInetAddress());
                    handleRequest(clientSocket);
                } catch (IOException e) {
                    System.out.println("클라이언트 요청 처리 중 오류 발생: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("서버 시작 오류: " + e.getMessage());
        }
    }

    private static void handleRequest(Socket clientSocket) throws IOException {
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream())
        ) {

//            요청의 첫 줄 (예: GET / HTTP/1.1)
            String requestLine = in.readLine();
            System.out.println("요청 라인: " + requestLine);

            if (requestLine == null || requestLine.isEmpty()) {
                return;
            }

//            요청 파싱
            String[] tokens = requestLine.split(" ");
            String method = tokens[0];
            String path = tokens[1];

//            응답 생성
            String statusLine;
            String body;

            if (method.equals("GET") && path.equals("/")) {
                body = "<html><body><h1>Welcome to Vitamin Storage :)</h1></body></html>";
                statusLine = "HTTP/1.1 200 OK";
            } else {
                body = "<html><body><h1>Page Not Found :(</h1></body></html>";
                statusLine = "HTTP/1.1 404 Not Found";
            }

            int contentLength = body.getBytes().length;

//            응답 전송
            out.println(statusLine);
            out.println("Content-Type: text/html; charset=UTF-8");
            out.println("Content-Length: " + contentLength);
            out.println(); // header-body 구분
            out.println(body);
            out.flush();

        } catch (IOException e) {
            throw new IOException("요청 처리 중 오류 발생", e);
        } finally {
            clientSocket.close();
        }
    }
}
