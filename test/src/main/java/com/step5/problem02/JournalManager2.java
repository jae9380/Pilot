//package com.step5.problem02;
//
//import com.step5.problem02.Journal;
//import com.step5.problem03.customException.ExceptionTypes;
//
//
//import java.io.*;
//import java.net.URISyntaxException;
//import java.net.URL;
//import java.text.ParseException;
//
//public class JournalManager2 {
////    기존에 작성된 JournalManager 코드에서 각 파일 찾기 -> 엑세스 검증 -> 파일 읽기 단계로 메서드화 진행
////    각 단계에서 적절한 예외 반환
//    public Journal loadJournal(String fileName) {
//        try {
//            InputStream is = findFile(fileName);
//
//            String content = readContent(is);
//            return new Journal(fileName, content);
//        }catch (ParseException e ) {
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }catch (FileNotFoundException e) {
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        } catch (SecurityException e) {
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }catch (ExceptionTypes.EmptyFileException e) {
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }catch (IOException e) {
//            System.out.println("[IOException] 파일 읽기 중 오류 발생: " + fileName);
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//    private InputStream findFile(String fileName) throws FileNotFoundException, ParseException {
//        ClassLoader classLoader = getClass().getClassLoader();
//        String resourcePath = "step05/problem02/" + fileName;
//
//        URL resourceUrl = classLoader.getResource(resourcePath);
//
//        if (resourceUrl == null) throw new FileNotFoundException("[FileNotFoundException] 리소스 파일이 존재하지 않습니다: " + fileName);
//
//        try {
//            File file = new File(resourceUrl.toURI()); // 실제 File 객체로 변환
//            validateFileName(file.getName()); // 실제 파일 이름을 기준으로 날짜 데이터 유효성 검증
//        }catch (ParseException e) {
//            throw e;
//        }catch (URISyntaxException e) {
//            throw new FileNotFoundException("[FileNotFoundException] URI 구문 오류로 인해 파일 경로를 변환할 수 없습니다: " + fileName + "\t원인: " + e.getMessage());
//        }
//        return classLoader.getResourceAsStream(resourcePath);
//    }
//
////    Security Checking Method
//    private void SecurityCheck(InputStream is, String fileName) throws SecurityException {
//        if (!hasAccessPermission(fileName)) {
//            // 요구하는 예외 구현
//            throw new SecurityException("[SecurityException] 파일 접근 권한이 없습니다: " + fileName);
//        }
//
//    }
//
//    // Access Checking Method
//    private boolean hasAccessPermission(String fileName) {
////        검증 구현에 대한 내용은 일단 없음
//        return true; // 일단 항상 허용으로 설정
//    }
//
//    private String readContent(InputStream is) throws IOException, EmptyFileException {
//        StringBuilder content = new StringBuilder();
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                content.append(line).append("\n");
//            }
//        } catch (IOException e) {
//            // Exception에 메세지를 담기 위해 catch를 사용하여 예외 다시 발생
//            throw new IOException("[IOException] 파일 내용을 읽는 중 오류 발생", e);
//        }
//
//        if (content.toString().trim().isEmpty()) throw new EmptyFileException();
//
//        return content.toString();
//    }
//
//    private void validateFileName(String fileName) throws ParseException {
//        if (fileName.replaceAll("[^0-9]", "").length() != 12)
//            throw new ParseException("[ParseException] 파일 이름에서 날짜 데이터를 확인할 수 없습니다: " + fileName, 0);
//    }
//
//}