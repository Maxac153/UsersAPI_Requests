package response.createCompany;

public class UnSuccessCreateCompany {
    public final String type;
    public final String message;

    public UnSuccessCreateCompany(String type, String message) {
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
