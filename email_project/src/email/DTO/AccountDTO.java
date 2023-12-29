package email.DTO;

public class AccountDTO {
    private String name;
    private int age;
    private String gender;
    private String Email;
    private String Password;

    public AccountDTO(String name, int age, String gender, String email, String password) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.Email = email;
        this.Password = password;
    }

    @Override
    public String toString() {
        return "EmailAccount{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", Email='" + Email + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
