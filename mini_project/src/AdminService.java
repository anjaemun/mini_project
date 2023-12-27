import java.util.List;
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
            System.out.println(adminDTO.getId() + "님 환영합니다.");
            adminMenu();
        } else {
            System.out.println("입력정보가 일치하지 않습니다.");
        }
    }

    private void adminMenu() {
        boolean run = true;
        int sel;
        while (run) {
            System.out.println("============================================================================================================");
            System.out.println("| 1.상품 등록 | 2.상품 조회 | 3.상품 수정 | 4.상품 삭제 | 5.회원 관리 | 6.이체 내역 | 7.배송 현황 | 8.포인트 적립 | 0.종료 |");
            System.out.println("============================================================================================================");
            System.out.print(" > ");
            sel = sc.nextInt();
            if (sel == 1) {
                upload();
            } else if (sel == 2) {
                goodsList();
            } else if (sel == 3) {
                goodsUpdate();
            } else if (sel == 4) {

            } else if (sel == 5) {

            } else if (sel == 6) {

            } else if (sel == 7) {

            } else if (sel == 0) {
                run = false;
            } else {
                System.out.println("다시 입력하세요.");
            }
        }
    }

    private void upload() {
        System.out.println("상품 등록");
        System.out.print("상품명 > ");
        String goodsName = sc.next();
        System.out.print("상품 가격 > ");
        int goodsPrice = sc.nextInt();
        System.out.print("상품 설명 > ");
        String goodsDetails = sc.next();
        AdminDTO adminDTO1 = new AdminDTO(goodsName, goodsPrice, goodsDetails);
        boolean upload = adminRepository.upload(adminDTO1);
        if (upload) {
            System.out.println("등록 완료");
        } else {
            System.out.println("등록 실패");
        }

    }
    private void goodsList() {
        List<AdminDTO> adminDTO1 = adminRepository.goodsList();
        if (!adminDTO1.isEmpty()) {
            System.out.println("adminDTO1 = " + adminDTO1);
        } else {
            System.out.println("상품이 없습니다.");
        }
    }
    private void goodsUpdate() {
        System.out.println("상품 수정");
        System.out.print("수정할 상품 ID > ");
        Long goodsId = sc.nextLong();
        System.out.print("수정할 상품명 > ");
        String goodsName = sc.next();
        System.out.print("수정할 상품 가격 > ");
        int goodsPrice = sc.nextInt();
        System.out.print("수정할 상품 상세 > ");
        String goodsDetails = sc.next();
        boolean adminDTO1 = adminRepository.goodsUpdate(goodsId, goodsName, goodsPrice, goodsDetails);
        if (adminDTO1) {
            System.out.println("수정 완료");
        } else {
            System.out.println("수정 실패");
        }
    }
}
