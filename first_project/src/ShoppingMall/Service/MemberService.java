package ShoppingMall.Service;

import ShoppingMall.DTO.MemberDTO;
import ShoppingMall.LoginCheck;
import ShoppingMall.Repository.MemberRepository;

import java.util.Scanner;

public class MemberService {
    Scanner sc = new Scanner(System.in);
    MemberRepository memberRepository = new MemberRepository();

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
        System.out.println("일반 고객 로그인입니다.");
        System.out.print("ID > ");
        String memberId = sc.next();
        System.out.print("PW > ");
        String memberPassword = sc.next();
        boolean login = memberRepository.memberLogin(memberId, memberPassword);
        if (login) {
            System.out.println(LoginCheck.memberLoginId + "님 환영합니다.");
        } else {
            System.out.println("입력 정보가 일치하지 않습니다.");
        }
    }
}
