package request;

import java.util.ArrayList;

public class UserData {
    public String email;
    public String name;
    public ArrayList<Integer> tasks;
    public ArrayList<Integer> companies;

    public UserData(String email, String name, ArrayList<Integer> tasks, ArrayList<Integer> companies) {
        this.email = email;
        this.name = name;
        this.tasks = tasks;
        this.companies = companies;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Integer> getTasks() {
        return tasks;
    }

    public ArrayList<Integer> getCompanies() {
        return companies;
    }
}
