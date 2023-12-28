package ShoppingMall.Service;

import ShoppingMall.DTO.*;
import ShoppingMall.LoginCheck;
import ShoppingMall.Repository.*;

import java.util.List;
import java.util.Scanner;

public class AdminService {
    GoodsRepository goodsRepository = new GoodsRepository();
    PaymentRepository paymentRepository = new PaymentRepository();
    AdminRepository adminRepository = new AdminRepository();
    AccountRepository accountRepository = new AccountRepository();
    DeliveryRepository deliveryRepository = new DeliveryRepository();
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
            System.out.print("7.배송 업무\t");
            System.out.println("0.이전 메뉴");
            System.out.println("=============================================================");
            System.out.print(" > ");
            int sel = sc.nextInt();
            if (sel == 1) {
                goodsUpload();
            } else if (sel == 2) {
                goodsList();
            } else if (sel == 3) {
                goodsUpdate();
            } else if (sel == 4) {
                goodsDelete();
            } else if (sel == 5) {
                orderList();
            } else if (sel == 6) {
                depositList();
            } else if (sel == 7) {
                delivery();
            } else if (sel == 0) {
                run = false;
            }
        }
    }




    public void adminJoin() {
        System.out.println("=====Admin Join=====");
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
        System.out.println("=====Admin Login=====");
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
        System.out.println("=====Goods Upload=====");
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
        System.out.println("=====Goods List=====");
        List<GoodsDTO> goodsDTOList = goodsRepository.goodsList();
        if (!goodsDTOList.isEmpty()) {
            for (GoodsDTO goodsDTO : goodsDTOList) {
                System.out.println("goodsDTO = " + goodsDTO);
            }
        } else {
            System.out.println("등록된 상품이 없습니다.");
        }
    }

    private void goodsUpdate() {
        System.out.println("=====Goods Update=====");
        System.out.print("수정할 상품 ID > ");
        Long goodsId = sc.nextLong();
        System.out.print("상품명 > ");
        String goodsName = sc.next();
        System.out.print("카테고리 > ");
        String category = sc.next();
        System.out.print("상품 가격 > ");
        int goodsPrice = sc.nextInt();
        System.out.print("상품 상세 > ");
        String goodsDetail = sc.next();
        boolean update = goodsRepository.update(goodsId, goodsName, category, goodsPrice, goodsDetail);
        if (update) {
            System.out.println("수정 완료");
        } else {
            System.out.println("ID가 일치하지 않습니다.");
        }
    }

    private void goodsDelete() {
        System.out.println("=====Goods Delete=====");
        System.out.print("삭제할 상품 ID > ");
        Long goodsId = sc.nextLong();
        boolean delete = goodsRepository.goodsDelete(goodsId);
        if (delete) {
            System.out.println("삭제 완료");
        } else {
            System.out.println("ID가 일치하지 않습니다.");
        }
    }

    private void orderList() {
        System.out.println("=====Order List=====");
        List<OrderDTO> orderDTOList = paymentRepository.orderList();
        if (!orderDTOList.isEmpty()) {
            for (OrderDTO orderDTO : orderDTOList) {
                System.out.println("orderDTO = " + orderDTO);
            }
        } else {
            System.out.println("주문 내역이 없습니다.");
        }
    }

    private void depositList() {
        System.out.println("=====Deposit List=====");
        List<AccountDTO> accountDTOList = accountRepository.depositList();
        if (!accountDTOList.isEmpty()) {
            for (AccountDTO accountDTO : accountDTOList) {
                System.out.println("accountDTO = " + accountDTO);
            }
        } else {
            System.out.println("입금 내역이 없습니다.");
        }
    }

    private void delivery() {
        System.out.println("=====Delivery Current=====");
        System.out.print("배송할 상품 ID > ");
        Long id = sc.nextLong();
//        DeliveryDTO deliveryDTO = new DeliveryDTO();
        List<OrderDTO> deliveryDTOList = deliveryRepository.delivery(id);
        if (!deliveryDTOList.isEmpty()) {
            System.out.println("배송 출발");
            for (OrderDTO orderDTO : deliveryDTOList) {
                System.out.println("orderDTO = " + orderDTO);
            }
        } else {
            System.out.println("해당 주문 내역이 없습니다.");
        }
    }
}

