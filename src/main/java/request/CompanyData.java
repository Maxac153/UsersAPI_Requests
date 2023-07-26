package request;

import java.util.ArrayList;

public class CompanyData {
    public class Company {
        private final String name;
        private final String type;
        private final String inn;
        private final String ogrn;
        private final String kpp;
        private final String phone;
        private final String adress;
        private final ArrayList<String> users;

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

    public class Root{
        private final String type;
        private final int id_company;
        private final Company company;

        public Root(String type, int id_company, Company company) {
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
}
