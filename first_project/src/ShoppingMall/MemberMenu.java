package ShoppingMall;

import ShoppingMall.Service.MemberService;

import java.util.Scanner;

public class MemberMenu {
    MemberService memberService = new MemberService();
    Scanner sc = new Scanner(System.in);

    public void mainMenu() {
        boolean run = true;
        while (run) {
            System.out.println("=============================================================");
            System.out.println("1.회원가입");
            System.out.println("2.로그인");
            System.out.println("0.이전");
            System.out.println("* 첫 로그인 시 1,000point 무조건 지급 *");
            System.out.println("=============================================================");
            System.out.print(" > ");
            int sel = sc.nextInt();
            if (sel == 1) {
                memberService.memberJoin();
            } else if (sel == 2) {
                memberService.memberLogin();
            } else if (sel == 3) {

            } else if (sel == 0) {
                run = false;
            }
        }
    }
}
