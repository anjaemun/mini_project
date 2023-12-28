package ShoppingMall.DTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OrderDTO {
    private Long id;
    private String goodsName;
    private String category;
    private int goodsPrice;
    private int quantity;
    private String paymentAt;

    public static Long idValue = 1L;

    public OrderDTO(String goodsName, String category, int goodsPrice, int quantity) {
        this.id = idValue++;
        this.goodsName = goodsName;
        this.category = category;
        this.goodsPrice = goodsPrice;
        this.quantity = quantity;
        this.paymentAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yy.MM.dd.HH:mm"));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(int goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPaymentAt() {
        return paymentAt;
    }

    public void setPaymentAt(String paymentAt) {
        this.paymentAt = paymentAt;
    }

    public static Long getIdValue() {
        return idValue;
    }

    public static void setIdValue(Long idValue) {
        OrderDTO.idValue = idValue;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "id=" + id +
                ", goodsName='" + goodsName + '\'' +
                ", category='" + category + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", quantity=" + quantity +
                ", paymentAt='" + paymentAt + '\'' +
                '}';
    }
}
