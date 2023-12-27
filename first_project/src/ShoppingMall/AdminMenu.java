package ShoppingMall;

import ShoppingMall.DTO.AdminDTO;
import ShoppingMall.Repository.AdminRepository;
import ShoppingMall.Service.AdminService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminMenu {
    List<AdminDTO> adminDTOList = new ArrayList<>();
    AdminService adminService = new AdminService();

    Scanner sc = new Scanner(System.in);
    boolean run = true;
    int sel;

    public void mainMenu() {
        while (run) {
            System.out.println("=============================================================");
            System.out.println("1.회원가입");
            System.out.println("2.로그인");
            System.out.println("0.이전");
            System.out.println("=============================================================");
            System.out.print(" > ");
            sel = sc.nextInt();
            if (sel == 1) {
                adminService.adminJoin();
            } else if (sel == 2) {
                adminService.adminLogin();
            } else if (sel == 0) {
                run = false;
            }
        }
    }

}
