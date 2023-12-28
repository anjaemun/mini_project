package ShoppingMall.Repository;

import ShoppingMall.DTO.OrderDTO;

import java.util.ArrayList;
import java.util.List;

public class PaymentRepository {
    List<OrderDTO> orderDTOList = new ArrayList<>();
    public List<OrderDTO> orderList() {
        return orderDTOList;
    }
}
