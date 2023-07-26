package request;

import java.util.ArrayList;

public class UserWithTasksData {
    public class Birthday {
        public int sec;
        public int usec;

        public Birthday(int sec, int usec) {
            this.sec = sec;
            this.usec = usec;
        }

        public int getSec() {
            return sec;
        }

        public int getUsec() {
            return usec;
        }
    }

    public class Company {
        public String name;
        public int id;

        public Company(String name, int id) {
            this.name = name;
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }
    }

    public class DateRegister {
        public int sec;
        public int usec;

        public DateRegister(int sec, int usec) {
            this.sec = sec;
            this.usec = usec;
        }

        public int getSec() {
            return sec;
        }

        public int getUsec() {
            return usec;
        }
    }

    public class DateStart {
        public int sec;
        public int usec;

        public DateStart(int sec, int usec) {
            this.sec = sec;
            this.usec = usec;
        }

        public int getSec() {
            return sec;
        }

        public int getUsec() {
            return usec;
        }
    }

    public class DateUpdated {
        public int sec;
        public int usec;

        public DateUpdated(int sec, int usec) {
            this.sec = sec;
            this.usec = usec;
        }

        public int getSec() {
            return sec;
        }

        public int getUsec() {
            return usec;
        }
    }

    public class Root {
        public String name;
        public String name1;
        public String hobby;
        public String surname1;
        public String fathername1;
        public String cat;
        public String dog;
        public String parrot;
        public String cavy;
        public String hamster;
        public String squirrel;
        public String phone;
        public String adres;
        public String gender;
        public DateStart date_start;
        public DateUpdated date_updated;
        public Birthday birthday;
        public ArrayList<String> role;
        public DateRegister date_register;
        public String date;
        public String email;
        public String by_user;
        public ArrayList<Company> companies;
        public ArrayList<Task> tasks;

        public Root(String name, String name1, String hobby, String surname1, String fathername1, String cat, String dog, String parrot, String cavy, String hamster, String squirrel, String phone, String adres, String gender, DateStart date_start, DateUpdated date_updated, Birthday birthday, ArrayList<String> role, DateRegister date_register, String date, String email, String by_user, ArrayList<Company> companies, ArrayList<Task> tasks) {
            this.name = name;
            this.name1 = name1;
            this.hobby = hobby;
            this.surname1 = surname1;
            this.fathername1 = fathername1;
            this.cat = cat;
            this.dog = dog;
            this.parrot = parrot;
            this.cavy = cavy;
            this.hamster = hamster;
            this.squirrel = squirrel;
            this.phone = phone;
            this.adres = adres;
            this.gender = gender;
            this.date_start = date_start;
            this.date_updated = date_updated;
            this.birthday = birthday;
            this.role = role;
            this.date_register = date_register;
            this.date = date;
            this.email = email;
            this.by_user = by_user;
            this.companies = companies;
            this.tasks = tasks;
        }

        public String getName() {
            return name;
        }

        public String getName1() {
            return name1;
        }

        public String getHobby() {
            return hobby;
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

        public String getAdres() {
            return adres;
        }

        public String getGender() {
            return gender;
        }

        public DateStart getDate_start() {
            return date_start;
        }

        public DateUpdated getDate_updated() {
            return date_updated;
        }

        public Birthday getBirthday() {
            return birthday;
        }

        public ArrayList<String> getRole() {
            return role;
        }

        public DateRegister getDate_register() {
            return date_register;
        }

        public String getDate() {
            return date;
        }

        public String getEmail() {
            return email;
        }

        public String getBy_user() {
            return by_user;
        }

        public ArrayList<Company> getCompanies() {
            return companies;
        }

        public ArrayList<Task> getTasks() {
            return tasks;
        }
    }

    public class Task {
        public String name;
        public int id;

        public Task(String name, int id) {
            this.name = name;
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public int getId() {
            return id;
        }
    }
}
