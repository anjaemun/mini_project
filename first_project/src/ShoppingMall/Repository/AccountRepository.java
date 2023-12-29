package ShoppingMall.Repository;

import ShoppingMall.DTO.AccountDTO;

import java.util.ArrayList;
import java.util.List;

public class AccountRepository {
    List<AccountDTO> accountDTOList = new ArrayList<>();
    public List<AccountDTO> depositList() {
        return accountDTOList;
    }


    public boolean payment(Long id) {

    }
}
