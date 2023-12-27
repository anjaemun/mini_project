import java.util.Scanner;

public class MainController {
    public static void main(String[] args) {
        boolean run = true;
        AdminService adminService = new AdminService();
        BuyerService buyerService = new BuyerService();
        Scanner sc = new Scanner(System.in);
        while (run) {
            System.out.println("=============================================");
            System.out.println("| 1.회원가입 | 2.로그인 | 3.관리자 페이지 | 4.종료 |");
            System.out.println("=============================================");
            System.out.print(" > ");
            int sel = sc.nextInt();
            if (sel == 1) {
                buyerService.join();
            } else if (sel == 2) {
                buyerService.login();
            } else if (sel == 3) {
//            adminService.login();
            } else if (sel == 4) {
                run = false;
            }
        }
    }
}
