package ShoppingMall.Service;

import ShoppingMall.DTO.AdminDTO;
import ShoppingMall.DTO.GoodsDTO;
import ShoppingMall.LoginCheck;
import ShoppingMall.Repository.AdminRepository;
import ShoppingMall.Repository.GoodsRepository;

import java.util.List;
import java.util.Scanner;

public class AdminService {
    GoodsRepository goodsRepository = new GoodsRepository();
    AdminRepository adminRepository = new AdminRepository();
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
                adminJoin();
            } else if (sel == 2) {
                adminLogin();
            } else if (sel == 0) {
                run = false;
            }
        }
    }

    public void subMenu() {
        boolean run = true;
        while (run) {
            System.out.println("=============================================================");
            System.out.print("1.상품 등록\t");
            System.out.print("2.상품 조회\t");
            System.out.print("3.상품 수정\t");
            System.out.println("4.상품 삭제");
            System.out.print("5.주문 목록\t");
            System.out.print("6.입금 내역\t");
            System.out.print("7.발송 처리\t");
            System.out.println("0.이전");
            System.out.println("=============================================================");
            System.out.print(" > ");
            int sel = sc.nextInt();
            if (sel == 1) {
                goodsUpload();
            } else if (sel == 2) {
                goodsList();
            } else if (sel == 3) {

            } else if (sel == 4) {

            } else if (sel == 5) {

            } else if (sel == 6) {

            } else if (sel == 7) {

            } else if (sel == 0) {
                run = false;
            }
        }
    }

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
            subMenu();
        } else {
            System.out.println("입력 정보가 일치하지 않습니다.");
        }
    }

    public void goodsUpload() {
        System.out.println("상품 등록입니다.");
        System.out.print("상품명 > ");
        String goodsName = sc.next();
        System.out.print("카테고리 > ");
        String category = sc.next();
        System.out.print("상품 가격 > ");
        int goodsPrice = sc.nextInt();
        System.out.print("상품 상세 > ");
        String goodsDetail = sc.next();
        GoodsDTO goodsDTO = new GoodsDTO(goodsName, category, goodsPrice, goodsDetail);
        boolean upload = goodsRepository.goodsUpload(goodsDTO);
        if (upload) {
            System.out.println("등록 완료");
        } else {
            System.out.println("등록 실패");
        }
    }

    public void goodsList() {
        System.out.println("상품 목록입니다.");
        List<GoodsDTO> goodsDTOList = goodsRepository.goodsList();
        if (!goodsDTOList.isEmpty()) {
            for (GoodsDTO goodsDTO : goodsDTOList) {
                System.out.println("goodsDTO = " + goodsDTO);
            }
        } else {
            System.out.println("등록된 상품이 없습니다.");
        }
    }
}
