import java.util.ArrayList;
import java.util.List;

public class BuyerRepository {
    List<BuyerDTO> buyerDTOList = new ArrayList<>();

    public boolean join(BuyerDTO buyerDTO) {

        return buyerDTOList.add(buyerDTO);
    }

    public boolean login(String id, String password) {
        for (BuyerDTO buyerDTO : buyerDTOList) {
            if (id.equals(buyerDTO.getId()) && password.equals(buyerDTO.getPassword())) {
                return true;
            }
        }
        return false;
    }
}
