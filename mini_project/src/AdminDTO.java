public class AdminDTO {
    private String id;
    private String password;

    private String goodsName;
    private int goodsPrice;

    private String goodsDetails;


    public static String idValue = "admin";
public static String passwordValue = "1234";
    public AdminDTO() {
        this.id = idValue;
        this.password = passwordValue;
    }

    public AdminDTO(String goodsName, int goodsPrice, String goodsDetails) {
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.goodsDetails = goodsDetails;
    }

    @Override
    public String toString() {
        return "AdminDTO{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
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
