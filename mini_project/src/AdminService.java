import java.util.Scanner;

public class AdminService {
    AdminDTO adminDTO = null;
    AdminRepository adminRepository = new AdminRepository();
    Scanner sc = new Scanner(System.in);

    public void login() {
        System.out.print("관리자 ID > ");
        String adminId = sc.next();
        System.out.print("관리자 PW > ");
        String adminPassword = sc.next();
        adminDTO = new AdminDTO();
        boolean adminLogin = adminRepository.login(adminId, adminPassword);
        if (adminLogin) {
            System.out.println(adminDTO.getId()+"님 환영합니다.");
        } else {
            System.out.println("입력정보가 일치하지 않습니다.");
        }


    }
}
