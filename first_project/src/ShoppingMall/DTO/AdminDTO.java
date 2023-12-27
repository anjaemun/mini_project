package ShoppingMall.DTO;

public class AdminDTO {
    private String adminId;
    private String adminPassword;
    private String adminName;


    public AdminDTO(String adminId, String adminPassword, String adminName) {
        this.adminId = adminId;
        this.adminPassword = adminPassword;
        this.adminName = adminName;
    }

    @Override
    public String toString() {
        return "AdminDTO{" +
                "adminId='" + adminId + '\'' +
                ", adminPassword='" + adminPassword + '\'' +
                ", adminName='" + adminName + '\'' +
                '}';
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
}
