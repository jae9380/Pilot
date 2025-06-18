//package com.step05.problem04;
//
//import java.util.Scanner;
//
//public class BiodomeForever04 {
//    private static boolean validationInput(String type, String input) {
//        if (!input.matches("[0-9.]+")) {
//            System.out.printf("잘못된 값입니다. %s는 숫자로 입력해주세요.\n", type);
//            return true;
//        }
//        return false;
//    }
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        EnvironmentManager em = new EnvironmentManager();
//
//
//        while (true) {
//            System.out.print("1. 새로운 환경 데이터 입력\n2. 모든 환경 데이터 조회\n3. 날짜별 산소 수치만 조회\n4. 프로그램 종료\n선택: ");
//            String input = scanner.nextLine();
//            switch (input) {
//                case "1":
//                    System.out.print("온도를 입력하세요: ");
//                    String temperature = scanner.nextLine();
//                    if (validationInput("온도", temperature)) continue;
//
//                    System.out.print("습도를 입력하세요: ");
//                    String humidity = scanner.nextLine();
//                    if (validationInput("습도", humidity)) continue;
//
//                    System.out.print("산소 농도를 입력하세요: ");
//                    String oxygenLevel = scanner.nextLine();
//                    if (validationInput("산소 농도", oxygenLevel)) continue;
//
//                    System.out.print("측정 장소를 입력하세요: ");
//                    String location = scanner.nextLine();
//
//                    em.register(temperature, humidity, oxygenLevel, location);
//                    break;
//                case "2":
//                    em.showAllData();
//                    break;
//                case "3":
//                    em.sortByDate();
//                    break;
//                case "4":
//                    System.out.println("프로그램을 종료합니다. 감사합니다.");
//                    return;
//                default:
//                    System.out.println("잘못된 입력입니다. 1, 2, 3 중 하나를 선택해주세요.");
//            }
//        }
//    }
//}
