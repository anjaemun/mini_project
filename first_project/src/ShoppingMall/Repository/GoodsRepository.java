package ShoppingMall.Repository;

import ShoppingMall.DTO.GoodsDTO;

import java.util.ArrayList;
import java.util.List;

public class GoodsRepository {
    List<GoodsDTO> goodsDTOList = new ArrayList<>();

    public boolean goodsUpload(GoodsDTO goodsDTO) {
        return goodsDTOList.add(goodsDTO);
    }

    public List<GoodsDTO> goodsList() {
        return goodsDTOList;
    }

    public boolean update(Long goodsId, String goodsName, String category, int goodsPrice, String goodsDetail) {
        boolean result = false;
        for (GoodsDTO goodsDTO : goodsDTOList) {
            if (goodsId.equals(goodsDTO.getId())) {
                goodsDTO.setGoodsName(goodsName);
                goodsDTO.setCategory(category);
                goodsDTO.setGoodsPrice(goodsPrice);
                goodsDTO.setGoodsDetail(goodsDetail);
                result = true;
            }
        }
        return result;
    }

    public boolean goodsDelete(Long goodsId) {
        boolean result = false;
        for (int i = 0; i < goodsDTOList.size(); i++) {
            if (goodsId.equals(goodsDTOList.get(i).getId())) {
                goodsDTOList.remove(i);
                result = true;
            }
        }
        return result;
    }

    public List<GoodsDTO> categoryClass(String category1) {
        List<GoodsDTO> goodsDTOS = new ArrayList<>();
        for (GoodsDTO goodsDTO : goodsDTOList) {
            if (category1.equals(goodsDTO.getCategory())) {
                goodsDTOS.add(goodsDTO);
            }
        }
        return goodsDTOS;
    }
}

