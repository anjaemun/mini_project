package email;

import email.Service.AccountService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainController {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AccountService accountService = new AccountService();
        boolean run = true;
        while (run) {
            System.out.println("==================================");
            System.out.println("\t\tWelcome to J-mail");
            System.out.println("==================================");
            System.out.println("1.회원 등록 2.로그인 3.종료");
            System.out.println("==================================");
            try {
                int sel = sc.nextInt();
                if (sel == 1) {
                    accountService.join();
                } else if (sel == 2) {
                    accountService.login();
                } else if (sel == 3) {
                    run = false;
                } else {
                    System.out.println("다시 시도");
                }
            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력해주세요.");
            }
        }
    }
}
