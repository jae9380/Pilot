//package com.step05.problem07;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.io.RandomAccessFile;
//import java.util.RandomAccess;
//
//public class EnvironmentFileRepository {
//    private final static String FILE_NAME = "environment_data_Lumino.txt";
//    private final File file;
//    private final File dir = new File("src/main/resources/step05/problem07");
//
//    public EnvironmentFileRepository() {
//        if (!dir.exists()) dir.mkdirs();
//        file = new File(dir, FILE_NAME);
//    }
//
//    public EnvironmentData getByDateTime(String dateTime) throws RuntimeException, IOException{
//        EnvironmentData answer = null;
//        try (RandomAccessFile raf = new RandomAccessFile(file, "r")){
//            String line;
//
//            while ((line = raf.readLine()) != null) {
//                if (line.startsWith(dateTime)) return EnvironmentData.fromData(line);
//
//            }
//        }catch (FileNotFoundException e) {
//            throw new RuntimeException("파일을 찾을 수 없습니다." + file.getPath(), e);
//        }
//
//        return answer;
//    }
//}