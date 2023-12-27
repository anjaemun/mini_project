public class BuyerDTO {
    private String id;
    private String password;
    private String mobile;

    @Override
    public String toString() {
        return "BuyerDTO{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }

    public BuyerDTO(String id, String password, String mobile) {
        this.id = id;
        this.password = password;
        this.mobile = mobile;
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
}
