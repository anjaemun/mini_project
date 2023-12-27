import java.util.Scanner;

public class BuyerService {
    Scanner sc = new Scanner(System.in);
    BuyerRepository buyerRepository = new BuyerRepository();

    public void buyerMenu() {
        boolean run = true;
        while (run) {

            System.out.println("======================================================");
            System.out.println("| 1.회원 가입 | 2.로그인 | 3.상품 검색 | 4.카테고리 | 5.종료 |");
            System.out.println("======================================================");
            System.out.print("메뉴 선택 > ");
            int sel = sc.nextInt();
            if (sel == 1) {

            } else if (sel == 2) {

            } else if (sel == 3) {

            } else if (sel == 4) {

            } else if (sel == 5) {
                run = false;
            } else {
                System.out.println("존재하지 않는 페이지입니다.");
            }
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
        BuyerDTO buyerDTO = new BuyerDTO(id, password, mobile);
        boolean join = buyerRepository.join(buyerDTO);
        if (join) {
            System.out.println("회원가입 완료");
            System.out.println("감사의 의미로 1,000 point 지급!");
        } else {
            System.out.println("회원가입 실패");
        }

    }
}
