package Entity;

public class Account {

        private String userName;
        private String firstName;
        private String lastName;
        private String email;
        private int age;
        private int id;

    public Account(String userName, String firstName, String lastName, String email, int age, int id) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.id = id;
    }

    public boolean hasUseName(String desiredUserName) {
            return this.userName.equals(desiredUserName);
        }

        public boolean ageBetween(int minAge, int maxAge) {
            return age >= minAge && age <= maxAge;
        }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Account{" +
                "userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}