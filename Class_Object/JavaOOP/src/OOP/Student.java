package OOP;

public class Student {
    public String name;
    public Integer age;
    public String gender;
    public Integer ID;

    public Student(){
        name = "CHAN TAI MAN";
        age = 18;
        gender = "M";
        ID = 123;
    };
    public String getName() {
        return name;
    }

    public void setNames(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }
};
