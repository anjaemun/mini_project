package email.Service;

import email.DTO.AccountDTO;
import email.Repository.AccountRepository;

import java.util.Scanner;

public class AccountService {
    Scanner sc = new Scanner(System.in);
    AccountRepository accountRepository = new AccountRepository();
    MailService mailService = new MailService();


    public void join() {
        boolean run = true;
        while (run) {
            System.out.println("=======Join=======");
            System.out.print("name > ");
            String name = sc.next();
            System.out.print("age > ");
            int age = sc.nextInt();
            System.out.print("gender(m/fe) > ");
            String gender = sc.next();
            System.out.print("email > ");
            String email = sc.next();
            boolean emailCheck = accountRepository.emailCheck(email);
            if (emailCheck) {
                System.out.print("password > ");
                String password = sc.next();
                AccountDTO accountDTO = new AccountDTO(name, age, gender, email, password);
                boolean join = accountRepository.join(accountDTO);
                if (join) {
                    System.out.println("가입 완료");
                    run = false;
                } else {
                    System.out.println("가입 실패");
                }
            } else {
                System.out.println("사용 중인 이메일입니다.");
            }
        }
    }

    public void login() {
        System.out.println("=======Login=======");
        System.out.print("email > ");
        String email = sc.next();
        System.out.print("password > ");
        String password = sc.next();
        boolean login = accountRepository.login(email, password);
        if (login) {
            System.out.println(email + "님 환영합니다.");
            System.out.println("=======Mail List=======");
            mailService.mailList();
        } else {
            System.out.println("입력 정보가 일치하지 않습니다.");
        }

    }
}
