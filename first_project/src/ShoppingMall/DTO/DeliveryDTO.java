package ShoppingMall.DTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DeliveryDTO {
    private Long id;
    private String goodsName;
    private int quantity;
    private String sendAt;

    public static Long idValue = 1L;

    public DeliveryDTO(String goodsName, int quantity) {
        this.id = idValue++;
        this.goodsName = goodsName;
        this.quantity = quantity;
        this.sendAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yy.MM.dd.HH:mm"));
    }

    @Override
    public String toString() {
        return "DeliveryDTO{" +
                "id=" + id +
                ", goodsName='" + goodsName + '\'' +
                ", quantity=" + quantity +
                ", sendAt='" + sendAt + '\'' +
                '}';
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSendAt() {
        return sendAt;
    }

    public void setSendAt(String sendAt) {
        this.sendAt = sendAt;
    }

    public static Long getIdValue() {
        return idValue;
    }

    public static void setIdValue(Long idValue) {
        DeliveryDTO.idValue = idValue;
    }
}
