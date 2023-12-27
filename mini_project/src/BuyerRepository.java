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

    public BuyerDTO myPage(String loginId) {
        BuyerDTO buyerDTO1 = null;
        for (BuyerDTO buyerDTO : buyerDTOList) {
            if (loginId.equals(buyerDTO.getId())) {
                buyerDTO1 = buyerDTO;
            }
        }
        return buyerDTO1;
    }
}
