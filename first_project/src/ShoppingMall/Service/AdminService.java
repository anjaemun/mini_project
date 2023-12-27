package ShoppingMall.Service;

import ShoppingMall.DTO.AdminDTO;
import ShoppingMall.LoginCheck;
import ShoppingMall.Repository.AdminRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminService {
    List<AdminDTO> adminDTOList = new ArrayList<>();
    AdminRepository adminRepository = new AdminRepository();
    Scanner sc = new Scanner(System.in);

    public void adminJoin() {
        System.out.println("관리자 회원가입입니다.");
        System.out.print("사용할 ID > ");
        String adminId = sc.next();
        System.out.print("사용할 PW > ");
        String adminPassword = sc.next();
        System.out.print("성명 > ");
        String adminName = sc.next();
        AdminDTO adminDTO = new AdminDTO(adminId, adminPassword, adminName);
        boolean adminJoin = adminRepository.adminJoin(adminDTO);
        if (adminJoin) {
            System.out.println("회원가입 성공");
        } else {
            System.out.println("회원가입 실패");
        }

    }

    public void adminLogin() {
        System.out.println("관리자 로그인입니다.");
        System.out.print("ID > ");
        String adminId = sc.next();
        System.out.print("PW > ");
        String adminPassword = sc.next();
        boolean login = adminRepository.adminLogin(adminId, adminPassword);
        if (login) {
            System.out.println(LoginCheck.adminLoginId + "님 환영합니다.");
        } else {
            System.out.println("입력 정보가 일치하지 않습니다.");
        }
    }
}
