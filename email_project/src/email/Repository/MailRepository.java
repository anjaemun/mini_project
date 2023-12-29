package email.Repository;

import email.DTO.MailDTO;

import java.util.ArrayList;
import java.util.List;

public class MailRepository {
    static List<MailDTO> mailDTOList = new ArrayList<>();

    public static List<MailDTO> mailList(String loginEmail) {
        List<MailDTO> mailDTOS = new ArrayList<>();
        for (MailDTO mailDTO : mailDTOList) {
            if (loginEmail.equals(mailDTO.getToAccount()) || loginEmail.equals(mailDTO.getFromAccount())) {
                mailDTOS.add(mailDTO);
            }
        }
        return mailDTOS;
    }

    public boolean mailWrite(MailDTO mailDTO) {
        mailDTOList.add(mailDTO);
        return true;
    }


    public List<MailDTO> sendMail(String loginEmail) {
        List<MailDTO> mailDTOS = new ArrayList<>();
        for (MailDTO mailDTO : mailDTOList) {
            if (loginEmail.equals(mailDTO.getFromAccount())) {
                mailDTOS.add(mailDTO);
            }
        }
        return mailDTOS;
    }

    public List<MailDTO> receiveMail(String loginEmail) {
        List<MailDTO> mailDTOS = new ArrayList<>();
        for (MailDTO mailDTO : mailDTOList) {
            if (loginEmail.equals(mailDTO.getToAccount())) {
                mailDTOS.add(mailDTO);
            }
        }
        return mailDTOS;
    }
}
