package ShoppingMall.Repository;

import ShoppingMall.DTO.AdminDTO;

import java.util.ArrayList;
import java.util.List;

public class AdminRepository {
    List<AdminDTO> adminDTOList = new ArrayList<>();

    public boolean adminJoin(AdminDTO adminDTO) {

        return adminDTOList.add(adminDTO);
    }
}
