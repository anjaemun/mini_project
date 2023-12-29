package ShoppingMall.Service;

import ShoppingMall.DTO.AccountDTO;
import ShoppingMall.DTO.GoodsDTO;
import ShoppingMall.DTO.MemberDTO;
import ShoppingMall.DTO.OrderDTO;
import ShoppingMall.LoginCheck;
import ShoppingMall.Repository.AccountRepository;
import ShoppingMall.Repository.GoodsRepository;
import ShoppingMall.Repository.MemberRepository;

import java.util.List;
import java.util.Scanner;

public class MemberService {
    Scanner sc = new Scanner(System.in);
    MemberRepository memberRepository = new MemberRepository();
    GoodsRepository goodsRepository = new GoodsRepository();
    AccountRepository accountRepository = new AccountRepository();


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
                memberJoin();
            } else if (sel == 2) {
                memberLogin();
            } else if (sel == 0) {
                run = false;
            }
        }
    }

    private void subMenu() {
        boolean run = true;
        while (run) {
            System.out.println("=============================================================");
            System.out.println("1.마이 페이지");
            System.out.println("2.카테고리");
            System.out.println("3.장바구니");
            System.out.println("0.로그아웃");
            System.out.println("=============================================================");
            System.out.print(" > ");
            int sel = sc.nextInt();
            if (sel == 1) {
                myPage();
            } else if (sel == 2) {
                category();
            } else if (sel == 3) {
                cart();
            } else if (sel == 0) {
                LoginCheck.memberLoginId = null;
                run = false;
            }
        }
    }


    private void category() {
        System.out.println("=====Category=====");
        System.out.println("==========================");
        System.out.println("1.Top\t2.Bottom");
        System.out.println("3.Outer\t4.Shoes");
        System.out.println("==========================");
        System.out.println(" > ");
        int sel = sc.nextInt();
        if (sel == 1) {
            topCategory();
        } else if (sel == 2) {
            bottomCategory();
        } else if (sel == 3) {
            outerCategory();
        } else if (sel == 4) {
            shoesCategory();
        }
    }


    private void myPage() {
        System.out.println("=====" + LoginCheck.memberLoginId + "=====");
        int point = memberRepository.point(LoginCheck.memberLoginId);
        boolean run = true;
        while (run) {
            System.out.println("=============================================================");
            System.out.println("포인트 " + point + "point");
            System.out.println("=============================================================");
            System.out.println("1.주문 조회\t2.배송 조회\t3.장바구니\t0.홈");
            System.out.println("=============================================================");
            System.out.print(" > ");
            int sel = sc.nextInt();
            if (sel == 1) {
                orderList();
            } else if (sel == 2) {

            } else if (sel == 3) {

            } else {
                run = false;
            }
        }
    }

    private void orderList() {
        List<OrderDTO> orderDTOList = memberRepository.orderList();
        if (!orderDTOList.isEmpty()) {
            for (OrderDTO orderDTO : orderDTOList) {
                System.out.println("orderDTO = " + orderDTO);
            }
        } else {
            System.out.println("주문 내역이 없습니다.");
        }
    }


    public void memberJoin() {
        System.out.println("일반 고객 회원가입입니다.");
        System.out.print("사용할 ID > ");
        String memberId = sc.next();
        System.out.print("사용할 PW > ");
        String memberPassword = sc.next();
        System.out.print("성명 > ");
        String memberName = sc.next();
        System.out.print("전화번호 > ");
        String memberMobile = sc.next();
        MemberDTO memberDTO = new MemberDTO(memberId, memberPassword, memberName, memberMobile);
        boolean memberJoin = memberRepository.memberJoin(memberDTO);
        if (memberJoin) {
            System.out.println("회원가입 성공");
        } else {
            System.out.println("회원가입 실패");
        }
    }

    public void memberLogin() {
        boolean run = true;
        while (run) {
            System.out.println("=====Member Login=====");
            System.out.print("ID > ");
            String memberId = sc.next();
            System.out.print("PW > ");
            String memberPassword = sc.next();
            boolean login = memberRepository.memberLogin(memberId, memberPassword);
            if (login) {
                System.out.println(LoginCheck.memberLoginId + "님 환영합니다.");
                subMenu();
            } else {
                System.out.println("입력 정보가 일치하지 않습니다.");
                run = false;
            }
        }
    }

    private void topCategory() {
        System.out.println("=====Top=====");
        String category1 = "Top";
        List<GoodsDTO> goodsDTO = goodsRepository.categoryClass(category1);
        if (!goodsDTO.isEmpty()) {
            for (GoodsDTO dto : goodsDTO) {
                System.out.println("goodsDTO = " + dto);
            }
            System.out.println("담고 싶은 상품 ID > ");
            Long sel = sc.nextLong();
            List<GoodsDTO> cart = goodsRepository.contain(sel);
            if (!cart.isEmpty()) {
                System.out.println("담기 완료");
            }
        } else {
            System.out.println("상의가 없습니다.");
        }
    }

    private void bottomCategory() {
        System.out.println("=====Bottom=====");
        String category1 = "Bottom";
        List<GoodsDTO> goodsDTO = goodsRepository.categoryClass(category1);
        if (!goodsDTO.isEmpty()) {
            for (GoodsDTO goodsDTO1 : goodsDTO) {
                System.out.println("goodsDTO1 = " + goodsDTO1);
                System.out.println("담고 싶은 상품 ID > ");
                Long sel = sc.nextLong();
                List<GoodsDTO> cart = goodsRepository.contain(sel);
                if (!cart.isEmpty()) {
                    System.out.println("담기 완료");
                }
            }
        } else {
            System.out.println("하의가 없습니다.");
        }

    }

    private void outerCategory() {
        System.out.println("=====Outer=====");
        String category1 = "Outer";
        List<GoodsDTO> goodsDTO = goodsRepository.categoryClass(category1);
        if (!goodsDTO.isEmpty()) {
            for (GoodsDTO goodsDTO1 : goodsDTO) {
                System.out.println("goodsDTO1 = " + goodsDTO1);
                System.out.println("담고 싶은 상품 ID > ");
                Long sel = sc.nextLong();
                List<GoodsDTO> cart = goodsRepository.contain(sel);
                if (!cart.isEmpty()) {
                    System.out.println("담기 완료");
                }
            }
        } else {
            System.out.println("아우터가 없습니다.");
        }

    }

    private void shoesCategory() {
        System.out.println("=====Shoes=====");
        String category1 = "Shoes";
        List<GoodsDTO> goodsDTO = goodsRepository.categoryClass(category1);
        if (!goodsDTO.isEmpty()) {
            for (GoodsDTO goodsDTO1 : goodsDTO) {
                System.out.println("goodsDTO1 = " + goodsDTO1);
                System.out.println("담고 싶은 상품 ID > ");
                Long sel = sc.nextLong();
                List<GoodsDTO> cart = goodsRepository.contain(sel);
                if (!cart.isEmpty()) {
                    System.out.println("담기 완료");
                }
            }
        } else {
            System.out.println("신발이 없습니다.");
        }
    }

    private void cart() {
        System.out.println("=====Cart=====");
        List<GoodsDTO> cart = goodsRepository.cart();
        if (!cart.isEmpty()) {
            for (GoodsDTO goodsDTO : cart) {
                System.out.println("goodsDTO = " + goodsDTO);
            }
        } else {
            System.out.println("내역이 존재하지 않습니다.");
        }
    }
}
