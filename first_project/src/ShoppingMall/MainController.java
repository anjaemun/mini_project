package ShoppingMall;

import ShoppingMall.Service.AdminService;
import ShoppingMall.Service.MemberService;

import java.util.Scanner;

public class MainController {
    public static void main(String[] args) {
        AdminService adminService = new AdminService();
        MemberService memberService = new MemberService();
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        int sel;
        while (run) {
            System.out.println("=============================================================");
            System.out.println("미니멀리즘에 오신 것을 환영합니다!");
            System.out.println("관리자이시면 1번, 일반 고객이시면 2번을, 종료하시려면 0번을 선택해주세요.");
            System.out.println("=============================================================");
            System.out.print(" > ");
            sel = sc.nextInt();
            if (sel == 1) {
                adminService.mainMenu();
            } else if (sel == 2) {
                memberService.mainMenu();
            } else {
                run = false;
            }
        }
    }
}
