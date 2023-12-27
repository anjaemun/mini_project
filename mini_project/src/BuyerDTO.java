public class BuyerDTO {
    private String id;
    private String password;
    private String mobile;
    private int point;

    @Override
    public String toString() {
        return "BuyerDTO{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", mobile='" + mobile + '\'' +
                ", point=" + point +
                '}';
    }

    public BuyerDTO(String id, String password, String mobile, int point) {
        this.id = id;
        this.password = password;
        this.mobile = mobile;
        this.point = point;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getPoint() {
        return point;
    }
}
