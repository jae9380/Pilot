package com.step07.problem01;

import java.net.*;

public class URLUtil {
    void getInfo(String path) throws MalformedURLException, URISyntaxException, UnknownHostException {
        URL url = new URL(path);

        System.out.println("\n[URL 정보]");
        System.out.println("url.getAuthority(): " + url.getAuthority());

        try {
            Object content = url.getContent();
            System.out.println("url.getContent(): " + content);
        } catch (Exception e) {
            System.out.println("url.getContent(): [연결 실패 또는 읽기 불가]");
        }

        System.out.println("url.getDefaultPort(): " + url.getDefaultPort());
        System.out.println("url.getPort(): " + url.getPort());
        System.out.println("url.getFile(): " + url.getFile());
        System.out.println("url.getHost(): " + url.getHost());
        System.out.println("url.getPath(): " + url.getPath());
        System.out.println("url.getProtocol(): " + url.getProtocol());
        System.out.println("url.getQuery(): " + url.getQuery());
        System.out.println("url.getRef(): " + url.getRef());
        System.out.println("url.getUserInfo(): " + url.getUserInfo());
        System.out.println("url.toExternalForm(): " + url.toExternalForm());
        System.out.println("url.toURI(): " + url.toURI());

        System.out.println("\n[DNS 정보]");
        String host = url.getHost();
        InetAddress inetAddress = InetAddress.getByName(host);
        System.out.println("IP 주소: " + inetAddress.getHostAddress());
    }
}
