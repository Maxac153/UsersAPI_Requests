package response.createCompany;

import java.util.ArrayList;

public class SuccessCreateCompany {
    private final String company_name;
    private final String company_type;
    private final ArrayList<String> company_users;
    private final String email_owner;

    public SuccessCreateCompany(String company_name, String company_type, ArrayList<String> company_users, String email_owner) {
        this.company_name = company_name;
        this.company_type = company_type;
        this.company_users = company_users;
        this.email_owner = email_owner;
    }

    public String getCompany_name() {
        return company_name;
    }

    public String getCompany_type() {
        return company_type;
    }

    public ArrayList<String> getCompany_users() {
        return company_users;
    }

    public String getEmail_owner() {
        return email_owner;
    }
}
