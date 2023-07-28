package response.createCompany;

import java.util.ArrayList;

public class SuccessCreateCompany {
    public class Company{
        public final String name;
        public final String type;
        public final String inn;
        public final String ogrn;
        public final String kpp;
        public final String phone;
        public final String adress;
        public final ArrayList<String> users;

        public Company(String name, String type, String inn, String ogrn, String kpp, String phone, String adress, ArrayList<String> users) {
            this.name = name;
            this.type = type;
            this.inn = inn;
            this.ogrn = ogrn;
            this.kpp = kpp;
            this.phone = phone;
            this.adress = adress;
            this.users = users;
        }

        public String getName() {
            return name;
        }

        public String getType() {
            return type;
        }

        public String getInn() {
            return inn;
        }

        public String getOgrn() {
            return ogrn;
        }

        public String getKpp() {
            return kpp;
        }

        public String getPhone() {
            return phone;
        }

        public String getAdress() {
            return adress;
        }

        public ArrayList<String> getUsers() {
            return users;
        }
    }

    public String type;
    public int id_company;
    public Company company;

    public SuccessCreateCompany(String type, int id_company, Company company) {
        this.type = type;
        this.id_company = id_company;
        this.company = company;
    }

    public String getType() {
        return type;
    }

    public int getId_company() {
        return id_company;
    }

    public Company getCompany() {
        return company;
    }
}
