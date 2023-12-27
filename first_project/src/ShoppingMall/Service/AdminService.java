package ShoppingMall.Service;

import ShoppingMall.DTO.AdminDTO;
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
}
