package response.createUser;

public class UnSuccessCreateUser {
    public final String type;
    public final String message;

    public UnSuccessCreateUser(String type, String message) {
        this.type = type;
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }
}
