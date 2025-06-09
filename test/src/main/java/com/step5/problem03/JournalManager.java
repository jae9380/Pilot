//package com.step5.problem03;
//
//import com.step5.problem03.Journal;
//import com.step5.problem03.customException.ExceptionTypes;
//import com.step5.problem03.customException.ExceptionTypes.*;
//
//import java.io.*;
//import java.net.URISyntaxException;
//import java.net.URL;
//import java.text.ParseException;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//public class JournalManager {
////    public Journal loadJournal(String fileName) {
////        try {
////            InputStream is = findFile(fileName);
////
////            String content = readContent(is);
////            return new Journal(fileName, content);
////        }catch (ParseException e ) {
////            System.out.println(e.getMessage());
////            e.printStackTrace();
////        }catch (FileNotFoundException e) {
////            System.out.println(e.getMessage());
////            e.printStackTrace();
////        } catch (SecurityException e) {
////            System.out.println(e.getMessage());
////            e.printStackTrace();
////        }catch (IOException e) {
////            System.out.println("[IOException] 파일 읽기 중 오류 발생: " + fileName);
////            e.printStackTrace();
////        } catch (EmptyFileException e) {
////            System.out.println(e.getMessage());
////            e.printStackTrace();
////        }
////        return null;
////    }
//
//    public List<Journal> loadFolder(String folderPath) {
//        List<Journal> journals = new ArrayList<>();
//
//        File[] files = null;
//        try {
//            files = findFilesByFolder(folderPath);
//        } catch (InvalidFolderPathException e) {
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        } catch (EmptyFolderException e) {
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }
//
//        for (File file : files) {
//            if (file.isFile()) {
//                try {
//                    String fileName = file.getName();
//                    validateFileName(fileName);
//                    InputStream is = new FileInputStream(file);
//                    String content = readContent(is);
//                    journals.add(new Journal(fileName, content));
//                } catch (EmptyFileException e) {
//                    System.out.println(e.getMessage());
//                    e.printStackTrace();
//                } catch (IOException e) {
//                    System.out.println("[IOException] 파일 읽기 중 오류 발생: " + file.getName());
//                    e.printStackTrace();
//                } catch (ParseException e) {
//                    System.out.println(e.getMessage());
//                    e.printStackTrace();
//                }
//            }
//        }
//        return journals;
//    }
//
//    public void savePlantDataToFile() {
//        String folderPath = "src/main/resources/step05/problem03";
//        Set<String> journalPairs = loadFolder(folderPath).stream()
//                .map(j -> {
//                    try {
//                        return extractNameAndAddress(j);
//                    } catch (IllegalContentFormatException e) {
//                        System.out.println(e.getMessage());
//                        e.printStackTrace();
//                    }
//                    return null;
//                })
//                .collect(Collectors.toSet());
//
//        try {
//            File outputDir = new File(folderPath+"/output");
//            if (!outputDir.exists()) {
//                boolean created = outputDir.mkdirs();
//                if (created) {
//                    System.out.println("디렉토리를 생성했습니다: " + outputDir.getAbsolutePath());
//                } else {
//                    System.err.println("디렉토리 생성에 실패했습니다.");
//                }
//            }
//
//            String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmm"));
//            File outputFile = new File(outputDir, dateTime + "_Lumino_ADR.txt");
//
//            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
//                for (String pair : journalPairs) {
//                    writer.write(pair);
//                    writer.newLine();
//                }
//                System.out.println("파일 저장 완료: " + outputFile.getAbsolutePath());
//            }
//
//        } catch (Exception e) {
//            System.err.println("파일 저장 실패: " + e.getMessage());
//            e.printStackTrace();
//        }
//    }
////
////    private InputStream findFile(String fileName) throws FileNotFoundException, ParseException {
////        ClassLoader classLoader = getClass().getClassLoader();
////        String resourcePath = "step05/problem02/" + fileName;
////
////        URL resourceUrl = classLoader.getResource(resourcePath);
////
////        if (resourceUrl == null) throw new FileNotFoundException("[FileNotFoundException] 리소스 파일이 존재하지 않습니다: " + fileName);
////
////        try {
////            File file = new File(resourceUrl.toURI());
////            validateFileName(file.getName());
////        }catch (ParseException e) {
////            throw e;
////        }catch (URISyntaxException e) {
////            throw new FileNotFoundException("[FileNotFoundException] URI 구문 오류로 인해 파일 경로를 변환할 수 없습니다: " + fileName + "\t원인: " + e.getMessage());
////        }
////        return classLoader.getResourceAsStream(resourcePath);
////    }
//
//    private File[] findFilesByFolder(String folderPath) throws InvalidFolderPathException, EmptyFolderException {
//        File folder = new File(folderPath);
//        if (!folder.exists() || !folder.isDirectory()) throw new InvalidFolderPathException();
//
//
//        File[] files = folder.listFiles();
//        if (files == null || files.length == 0) throw new EmptyFolderException();
//
//        return files;
//    }
//
//    private String readContent(InputStream is) throws IOException, EmptyFileException {
//        StringBuilder content = new StringBuilder();
//        BufferedReader reader = null;
//        try {
//            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
//            String line;
//            while ((line = reader.readLine()) != null) {
//                content.append(line).append("\n");
//            }
//        } catch (IOException e) {
//            throw new IOException("[IOException] 파일 내용을 읽는 중 오류 발생", e);
//        } finally {
//            if (reader != null) {
//                try {
//                    reader.close();
//                } catch (IOException e) {
//                    System.out.println("BufferedReader 닫는 중 오류 발생: " + e.getMessage());
//                }
//            }
//        }
//
//        if (content.toString().trim().isEmpty()) throw new EmptyFileException();
//
//        return content.toString();
//    }
//
//    public String extractNameAndAddress(Journal journal) throws IllegalContentFormatException {
//        String name = null;
//        String address = null;
//
//        String[] lines = journal.getContent().split("\\r?\\n");
//
//        for (String line : lines) {
//            line = line.trim();
//
//            if (line.startsWith("Name.")) {
//                name = line.substring(5).trim();
//            } else if (line.startsWith("ADR.")) {
//                address = line.substring(4).trim();
//            }
//        }
//
//        if (name != null && address != null) {
//            return name + " - " + address;
//        } else throw new IllegalContentFormatException();
//    }
//
//    private void validateFileName(String fileName) throws ParseException {
////        문제에서 regex 사용 불가 제약
////        if (fileName.replaceAll("[^0-9]", "").length() != 12)
//        for (char c : fileName.substring(0, 12).toCharArray()) {
//            if (!Character.isDigit(c)) throw new ParseException("[ParseException] 파일 이름에서 날짜 데이터를 확인할 수 없습니다: " + fileName, 0);
//        }
//    }
//}