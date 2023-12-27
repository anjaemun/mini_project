public class AdminDTO {
    private String id;
    private String password;
    private Long goodsId;

    private String goodsName;
    private int goodsPrice;

    private String goodsDetails;


    public static String idValue = "admin";
    public static String passwordValue = "1234";
    public static Long goodsIdValue = 1L;

    public AdminDTO() {
        this.id = idValue;
        this.password = passwordValue;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public AdminDTO(String goodsName, int goodsPrice, String goodsDetails) {
        this.goodsId = goodsIdValue++;
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.goodsDetails = goodsDetails;
    }

    @Override
    public String toString() {
        return "AdminDTO{" +
                "goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", goodsDetails='" + goodsDetails + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getGoodsDetails() {
        return goodsDetails;
    }

    public void setGoodsDetails(String goodsDetails) {
        this.goodsDetails = goodsDetails;
    }
}
