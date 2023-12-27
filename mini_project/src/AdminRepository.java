import java.util.ArrayList;
import java.util.List;

public class AdminRepository {
    List<AdminDTO> adminDTOList = new ArrayList<>();

    public boolean login(String adminId, String adminPassword) {
        boolean result = false;
        if (adminId.equals(AdminDTO.idValue) && adminPassword.equals(AdminDTO.passwordValue)) {
            result = true;
        }
        return result;
    }
}



