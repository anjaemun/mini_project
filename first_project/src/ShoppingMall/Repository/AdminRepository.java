package ShoppingMall.Repository;

import ShoppingMall.DTO.AdminDTO;
import ShoppingMall.LoginCheck;

import java.util.ArrayList;
import java.util.List;

public class AdminRepository {
    List<AdminDTO> adminDTOList = new ArrayList<>();

    public boolean adminJoin(AdminDTO adminDTO) {
        return adminDTOList.add(adminDTO);
    }

    public boolean adminLogin(String adminId, String adminPassword) {
        for (AdminDTO adminDTO : adminDTOList) {
            if (adminId.equals(adminDTO.getAdminId()) && adminPassword.equals(adminDTO.getAdminPassword())) {
                LoginCheck.adminLoginId = adminId;
                return true;
            }
        }
        return false;
    }
}
