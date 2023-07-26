package response.doRegister;

public class UnSuccessRegistration {
    public final String type;
    public final String message;

    public UnSuccessRegistration(String type, String message) {
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
