package email.DTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MailDTO {
    private Long id;
    private String fromAccount;
    private String toAccount;
    private String title;
    private String contents;
    private String sendAt;

    public static Long idValue = 1L;

    public MailDTO(String fromAccount, String toAccount, String title, String contents) {
        this.id = idValue++;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.title = title;
        this.contents = contents;
        this.sendAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd.HH시mm분"));
    }

    @Override
    public String toString() {
        return "MailDTO{" +
                "id=" + idValue +
                ", 보낸 사람 : '" + fromAccount + '\'' +
                ", 받는 사람 : '" + toAccount + '\'' +
                ", 제목 : '" + title + '\'' +
                ", 내용 : '" + contents + '\'' +
                ", 전송시간 : '" + sendAt + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }

    public String getToAccount() {
        return toAccount;
    }

    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getSendAt() {
        return sendAt;
    }

    public void setSendAt(String sendAt) {
        this.sendAt = sendAt;
    }

    public static Long getIdValue() {
        return idValue;
    }

    public static void setIdValue(Long idValue) {
        MailDTO.idValue = idValue;
    }
}
