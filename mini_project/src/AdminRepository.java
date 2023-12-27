import java.util.ArrayList;
import java.util.List;

public class AdminRepository {
    List<AdminDTO> adminDTOList = new ArrayList<>();
    List<AdminDTO> adminDTOS = new ArrayList<>();

    public boolean login(String adminId, String adminPassword) {
        boolean result = false;
        if (adminId.equals(AdminDTO.idValue) && adminPassword.equals(AdminDTO.passwordValue)) {
            result = true;
        }
        return result;
    }

    public boolean upload(AdminDTO adminDTO1) {
        return adminDTOS.add(adminDTO1);
    }

    public List<AdminDTO> goodsList() {
        return adminDTOS;
    }
}



