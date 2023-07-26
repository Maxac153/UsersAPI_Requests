package request;

import java.util.ArrayList;

public class UserData {
    public class Root {
        public String email;
        public String name;
        public ArrayList<Task> tasks;
        public ArrayList<Integer> companies;
        public String hobby;
        public String adres;
        public String name1;
        public String surname1;
        public String fathername1;
        public String cat;
        public String dog;
        public String parrot;
        public String cavy;
        public String hamster;
        public String squirrel;
        public String phone;
        public String inn;
        public String gender;
        public String birthday;
        public String date_start;

        public Root(String email, String name, ArrayList<Task> tasks, ArrayList<Integer> companies, String hobby, String adres, String name1, String surname1, String fathername1, String cat, String dog, String parrot, String cavy, String hamster, String squirrel, String phone, String inn, String gender, String birthday, String date_start) {
            this.email = email;
            this.name = name;
            this.tasks = tasks;
            this.companies = companies;
            this.hobby = hobby;
            this.adres = adres;
            this.name1 = name1;
            this.surname1 = surname1;
            this.fathername1 = fathername1;
            this.cat = cat;
            this.dog = dog;
            this.parrot = parrot;
            this.cavy = cavy;
            this.hamster = hamster;
            this.squirrel = squirrel;
            this.phone = phone;
            this.inn = inn;
            this.gender = gender;
            this.birthday = birthday;
            this.date_start = date_start;
        }

        public String getEmail() {
            return email;
        }

        public String getName() {
            return name;
        }

        public ArrayList<Task> getTasks() {
            return tasks;
        }

        public ArrayList<Integer> getCompanies() {
            return companies;
        }

        public String getHobby() {
            return hobby;
        }

        public String getAdres() {
            return adres;
        }

        public String getName1() {
            return name1;
        }

        public String getSurname1() {
            return surname1;
        }

        public String getFathername1() {
            return fathername1;
        }

        public String getCat() {
            return cat;
        }

        public String getDog() {
            return dog;
        }

        public String getParrot() {
            return parrot;
        }

        public String getCavy() {
            return cavy;
        }

        public String getHamster() {
            return hamster;
        }

        public String getSquirrel() {
            return squirrel;
        }

        public String getPhone() {
            return phone;
        }

        public String getInn() {
            return inn;
        }

        public String getGender() {
            return gender;
        }

        public String getBirthday() {
            return birthday;
        }

        public String getDate_start() {
            return date_start;
        }
    }

    public class Task {
        public String title;
        public String description;

        public Task(String title, String description) {
            this.title = title;
            this.description = description;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }
    }
}
