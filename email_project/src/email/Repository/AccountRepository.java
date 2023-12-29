package email.Repository;

import email.DTO.AccountDTO;
import email.LoginCheck;

import java.util.ArrayList;
import java.util.List;

public class AccountRepository {
    List<AccountDTO> accountDTOList = new ArrayList<>();

    public boolean emailCheck(String email) {
        for (AccountDTO accountDTO : accountDTOList) {
            if (email.equals(accountDTO.getEmail())) {
                return false;
            }
        }
        return true;
    }

    public boolean join(AccountDTO accountDTO) {
        accountDTOList.add(accountDTO);
        return true;
    }

    public boolean login(String email, String password) {
        boolean result = false;
        for (AccountDTO accountDTO : accountDTOList) {
            if (email.equals(accountDTO.getEmail()) && password.equals(accountDTO.getPassword())) {
                LoginCheck.loginEmail = email;
                result = true;
            }
        }
        return result;
    }
}
