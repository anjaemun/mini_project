package email.Service;

import email.DTO.MailDTO;
import email.LoginCheck;
import email.Repository.MailRepository;

import java.util.List;
import java.util.Scanner;
public class MailService {
    MailRepository mailRepository = new MailRepository();
    Scanner sc = new Scanner(System.in);
    public void mailList() {
        List<MailDTO> mailDTOList = mailRepository.mailList(LoginCheck.loginEmail);
        if (!mailDTOList.isEmpty()) {
            System.out.println("ID" + "\t" + "From" + "\t" + "Title" + "\t" + "Time");
            for (MailDTO mailDTO : mailDTOList) {
                System.out.println(mailDTO.getId() + "\t" + mailDTO.getFromAccount() + "\t" + mailDTO.getTitle() + "\t" + mailDTO.getSendAt());
            }
        } else {
            System.out.println("Empty,,,");
        }
        boolean run = true;
        while (run) {
            System.out.println("===========================================================");
            System.out.println("1.메일 작성 | 2.메일 조회 | 3.보낸 메일 | 4.받은 메일 | 5.로그아웃 |");
            System.out.println("===========================================================");
//            try {
            System.out.print(" > ");
            int sel = sc.nextInt();
            if (sel == 1) {
                mailWrite();
            } else if (sel == 2) {
                mailList();
            } else if (sel == 3) {
                sendMail();
            } else if (sel == 4) {
                receiveMail();
            } else if (sel == 5) {
                run = false;
            } else {
                System.out.println("다시 입력하세요.");
            }
//            } catch (InputMismatchException e) {
//                System.out.println("숫자를 입력하세요.");
//            }
        }
    }

    private void receiveMail() {
        List<MailDTO> receiveMail = mailRepository.receiveMail(LoginCheck.loginEmail);
        if (!receiveMail.isEmpty()) {
            for (MailDTO mailDTO : receiveMail) {
                System.out.println("mailDTO = " + mailDTO);
            }
        } else {
            System.out.println("받은 메일이 없습니다.");
        }
    }

    private void sendMail() {
        List<MailDTO> sendMail = mailRepository.sendMail(LoginCheck.loginEmail);
        if (!sendMail.isEmpty()) {
            for (MailDTO mailDTO : sendMail) {
                System.out.println("mailDTO = " + mailDTO);
            }
        } else {
            System.out.println("보낸 메일이 없습니다.");
        }

    }

    private void mailWrite() {
        System.out.print("받는 사람 > ");
        String email = sc.next();
        System.out.print("제목 > ");
        String title = sc.next();
        System.out.print("내용 > ");
        String contents = sc.next();
        MailDTO mailDTO = new MailDTO(LoginCheck.loginEmail, email, title, contents);
        boolean mailWrite = mailRepository.mailWrite(mailDTO);
        if (mailWrite) {
            System.out.println("전송 완료");
        } else {
            System.out.println("전송 실패");
        }
    }
}
