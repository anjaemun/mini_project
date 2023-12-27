import java.util.ArrayList;
import java.util.List;

public class AdminRepository {
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

    public Boolean goodsUpdate(Long goodsId, String goodsName, int goodsPrice, String goodsDeatils) {
        boolean adminDTO1 = false;
        for (AdminDTO adminDTO : adminDTOS) {
            if (goodsId.equals(adminDTO.getGoodsId())) {
                adminDTO.setGoodsName(goodsName);
                adminDTO.setGoodsPrice(goodsPrice);
                adminDTO.setGoodsDetails(goodsDeatils);
                adminDTO1 = true;
            }
        }
        return adminDTO1;
    }

    public boolean goodsDelete(Long goodsId) {
        boolean result = false;
        for (int i = 0; i < adminDTOS.size(); i++) {
            if (goodsId.equals(adminDTOS.get(i).getGoodsId())) {
                adminDTOS.remove(i);
                result = true;
            }
        }
        return result;
    }
}



