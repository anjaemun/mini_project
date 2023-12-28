package ShoppingMall.Repository;

import ShoppingMall.DTO.DeliveryDTO;
import ShoppingMall.DTO.OrderDTO;

import java.util.ArrayList;
import java.util.List;

public class DeliveryRepository {

    List<OrderDTO> orderDTOList = new ArrayList<>();

    public List<OrderDTO> delivery(Long id) {
        List<OrderDTO> deliveryDTOList = new ArrayList<>();
        for (int i = 0; i < orderDTOList.size(); i++) {
            if (id.equals(orderDTOList.get(i).getId())) {
                deliveryDTOList.add(orderDTOList.get(i));
                orderDTOList.remove(i);
            }
        }
        return deliveryDTOList;
    }
}
