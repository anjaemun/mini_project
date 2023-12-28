package ShoppingMall.DTO;

public class GoodsDTO {
    private Long id;
    private String goodsName;
    private String category;
    private int goodsPrice;
    private String goodsDetail;

    public static Long idValue = 1L;

    public GoodsDTO(String goodsName, String category, int goodsPrice, String goodsDetail) {
        this.id = idValue++;
        this.goodsName = goodsName;
        this.category = category;
        this.goodsPrice = goodsPrice;
        this.goodsDetail = goodsDetail;
    }

    @Override
    public String toString() {
        return "GoodsDTO{" +
                "id=" + id +
                ", goodsName='" + goodsName + '\'' +
                ", category='" + category + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", goodsDetail='" + goodsDetail + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(int goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsDetail() {
        return goodsDetail;
    }

    public void setGoodsDetail(String goodsDetail) {
        this.goodsDetail = goodsDetail;
    }

    public static Long getIdValue() {
        return idValue;
    }

    public static void setIdValue(Long idValue) {
        GoodsDTO.idValue = idValue;
    }
}
