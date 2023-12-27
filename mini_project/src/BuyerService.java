import java.util.Scanner;

public class BuyerService {
    Scanner sc = new Scanner(System.in);
    public static String loginId = null;
    BuyerRepository buyerRepository = new BuyerRepository();

    public void buyerMenu() {
        boolean run = true;
        while (run) {
            System.out.println("========================================================");
            System.out.println("| 1.마이페이지 | 2.상품 검색 | 3.카테고리 | 4.장바구니 | 0.종료 |");
            System.out.println("========================================================");
            System.out.print("메뉴 선택 > ");
            int sel = sc.nextInt();
            if (sel == 1) {
                myPage();
            } else if (sel == 2) {
                goodsSearch();
            } else if (sel == 3) {

            } else if (sel == 4) {

            } else if (sel == 5) {
                run = false;
            } else {
                System.out.println("존재하지 않는 페이지입니다.");
            }
        }
    }

    private void myPage() {
        BuyerDTO buyerDTO = buyerRepository.myPage(loginId);
        if (buyerDTO != null) {
            System.out.println("buyerDTO = " + buyerDTO);
        }
    }

    private void goodsSearch() {
        System.out.println("상품 검색");
        System.out.print("검색어 > ");
        String searchWord = sc.next();
        AdminDTO buyerDTO = buyerRepository.search(searchWord);
        if (buyerDTO != null){
            System.out.println("buyerDTO = " + buyerDTO);
        }else{
            System.out.println("검색 결과가 없습니다.");
        }
    }


    public void join() {
        System.out.println("회원가입");
        System.out.print("사용할 ID > ");
        String id = sc.next();
        System.out.print("사용할 PW > ");
        String password = sc.next();
        System.out.print("전화번호 > ");
        String mobile = sc.next();
        BuyerDTO buyerDTO = new BuyerDTO(id, password, mobile, 0);
        boolean join = buyerRepository.join(buyerDTO);
        if (join) {
            System.out.println("회원가입 완료");
            System.out.println("감사의 의미로 1,000 point 지급!");
            int point = buyerDTO.getPoint();
            point += 1000;
            buyerDTO.setPoint(point);
        } else {
            System.out.println("회원가입 실패");
        }
    }

    public void login() {
        System.out.println("로그인");
        System.out.print("ID > ");
        String id = sc.next();
        System.out.print("PW > ");
        String password = sc.next();
        boolean login = buyerRepository.login(id, password);
        if (login) {
            System.out.println("로그인 성공");
            loginId = id;
            buyerMenu();
        } else {
            System.out.println("입력 정보가 올바르지 않습니다.");
        }
    }
}
