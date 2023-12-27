import java.util.ArrayList;
import java.util.List;

public class BuyerRepository {
    List<BuyerDTO> buyerDTOList = new ArrayList<>();
    public boolean join(BuyerDTO buyerDTO) {
        return buyerDTOList.add(buyerDTO);
    }
}
