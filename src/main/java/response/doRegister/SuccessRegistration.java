package response.doRegister;

public class SuccessRegistration {
    private final String name;
    private final String avatar;
    private final String password;
    private final int birthday;
    private final String email;
    private final String gender;
    private final int date_start;
    private final String hobby;

    public SuccessRegistration(
            String name,
            String avatar,
            String password,
            int birthday,
            String email,
            String gender,
            int date_start,
            String hobby
    ) {
        this.name = name;
        this.avatar = avatar;
        this.password = password;
        this.birthday = birthday;
        this.email = email;
        this.gender = gender;
        this.date_start = date_start;
        this.hobby = hobby;
    }

    public String getName() {
        return name;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getPassword() {
        return password;
    }

    public int getBirthday() {
        return birthday;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public int getDate_start() {
        return date_start;
    }

    public String getHobby() {
        return hobby;
    }
}
