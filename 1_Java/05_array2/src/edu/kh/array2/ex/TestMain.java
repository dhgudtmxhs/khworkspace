package edu.kh.array2.ex;

import java.util.Scanner;

public class TestMain {

    public static Scanner scanner = new Scanner(System.in);

    static final int ROW = 5; 
    static final int COL = 4; 

    public static void main(String[] args) {
        String[][] parkingSpace = new String[ROW][COL];

        initializeParkingSpace(parkingSpace); 

        boolean flag = true; 

        while (flag) { 
            System.out.println("**** 주차 현황 ****");
            displayParkingSpace(parkingSpace); 
            displayMenu();
            System.out.print("메뉴를 선택하세요 : ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    parkCar(parkingSpace); // 주차하기
                    break;
                case 2:
                    searchCar(parkingSpace); // 차량검색
                    break;
                case 3:
                    exitCar(parkingSpace); // 출차하기
                    break;
                case 4:
                    System.out.println("프로그램 종료");
                    flag = false; // 사용자가 4를 선택하면 루프 종료
                    break;
                default:
                    System.out.println("메뉴 번호를 확인 후 다시 입력해주세요.");
            }
        }
    }

    private static void initializeParkingSpace(String[][] parkingSpace) {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (i == 0 && j == 0) { // 1행 1열일 때
                    parkingSpace[i][j] = " ";
                } else if (i == 0) { 
                    parkingSpace[i][j] = "" + (j); // 1,2,3 열 -> 문자열 + int = 문자열
                } else if (j == 0) {
                    parkingSpace[i][j] = "" + (i); // 1,2,3,4 행 -> 문자열 + int = 문자열
                } else {
                    parkingSpace[i][j] = "♡";
                }
            }
        }
    }

    private static void displayParkingSpace(String[][] parkingSpace) {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                System.out.print(parkingSpace[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void displayMenu() {
        System.out.print("1) 주차하기");
        System.out.print(" 2) 차량 검색");
        System.out.print(" 3) 출차하기");
        System.out.println(" 4) 종료");
    }

    private static void parkCar(String[][] parkingSpace) {
        System.out.print("주차할 위치(행 열)를 입력하세요 (예: 2 3): ");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        scanner.nextLine(); // 개행 문자(\n)를 읽어서 버림

        if (row < 0 || row >= ROW || col < 0 || col >= COL) {
            System.out.println("위치 번호를 확인해주세요1. 처음부터 다시 시작해 주세요.");
        } else if ("♥".equals(parkingSpace[row][col])) {
            System.out.println("다른 차량이 주차되어 있습니다. 처음부터 다시 시작해 주세요.");
        } else {
            System.out.print("차량 번호를 입력해주세요 (입력 예 : 20가1234): ");
            String carNumber = scanner.nextLine(); // 한 줄 전체를 읽음

            System.out.print("차량번호 " + carNumber + " 맞습니까?(y/n): ");
            String confirmation = scanner.next();

            if (confirmation.equalsIgnoreCase("y")) {
                System.out.println(carNumber + " 차량의 주차를 완료하였습니다.");

                // 주차한 차량을 하트로 표시
                parkingSpace[row][col] = "♥";

                // 차량 번호를 따로 저장
                carNumberArray[row][col] = carNumber; // carNumberArray는 String[][] 형태의 배열로 선언되어 있어야 함
            } else if(confirmation.equalsIgnoreCase("n")){
                System.out.println("처음부터 다시 진행해 주세요.");
            } else {
                System.out.println("y/n 중에서만 입력해주세요. 처음부터 다시 진행해 주세요.");
            }
        }
    }
    
    private static String[][] carNumberArray = new String[ROW][COL]; // 차량 번호를 저장하는 배열 추가

    // ...1

    private static void searchCar(String[][] parkingSpace) {
        System.out.print("차량 번호를 입력해주세요: ");

        String carNumber = scanner.next(); 
        
        boolean found = false; // 차량을 찾았는지 여부를 나타내는 변수

        // 주차 공간을 순회하면서 차량 번호와 일치하는 위치를 찾음
        for (int i = 1; i < ROW; i++) {
            for (int j = 1; j < COL; j++) {
                if (carNumber.equals(carNumberArray[i][j])) { // 저장된 배열에서 차량 번호를 비교
                    System.out.println(carNumber + " 차량은 (" + i + ", " + j + ")에 주차되어 있습니다.");
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }

        if (!found) {
            System.out.println("차량이 존재하지 않습니다. 차량번호 확인 후 처음부터 다시 진행해주세요.");
        }
    }

    private static void exitCar(String[][] parkingSpace) {
        System.out.print("차량 번호를 입력해주세요: ");
        String carNumberToExit = scanner.next();
        
        boolean found = false; // 차량을 찾았는지 여부를 나타내는 변수

        // 주차 공간을 순회하면서 차량 번호와 일치하는 위치를 찾음
        for (int i = 1; i < ROW; i++) {
            for (int j = 1; j < COL; j++) {
                if (carNumberToExit.equals(carNumberArray[i][j])) { // 저장된 배열에서 차량 번호를 비교
                    System.out.println(carNumberToExit + " 차량이 (" + i + ", " + j + ")에서 출차되었습니다.");
                    
                    // 주차한 차량을 빈 하트로 표시
                    parkingSpace[i][j] = "♡";
                    
                    // 차량 번호 삭제
                    carNumberArray[i][j] = null;
                    
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }

        if (!found) {
            System.out.println(carNumberToExit + " 차량을 찾을 수 없습니다.");
        }
    }
}