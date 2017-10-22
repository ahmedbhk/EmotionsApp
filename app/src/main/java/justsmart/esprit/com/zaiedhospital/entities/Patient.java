package justsmart.esprit.com.zaiedhospital.entities;

import java.util.Date;

/**
 * Created by BHK on 09/10/2017.
 */

public class Patient {
    public String name;
    public String gender;
    public int age;
    public String login;
    public String password;
    public int bedNum;
    public String nurse;
    public int patientId;

    public Patient() {
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBedNum() {
        return bedNum;
    }

    public void setBedNum(int bedNum) {
        this.bedNum = bedNum;
    }

    public String getNurse() {
        return nurse;
    }

    public void setNurse(String nurse) {
        this.nurse = nurse;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id='" + patientId + '\'' +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", bedNum=" + bedNum +
                ", nurse='" + nurse + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Patient patient = (Patient) o;

        if (age != patient.age) return false;
        if (bedNum != patient.bedNum) return false;
        if (name != null ? !name.equals(patient.name) : patient.name != null) return false;
        if (gender != null ? !gender.equals(patient.gender) : patient.gender != null) return false;
        if (login != null ? !login.equals(patient.login) : patient.login != null) return false;
        if (password != null ? !password.equals(patient.password) : patient.password != null)
            return false;
        return nurse != null ? nurse.equals(patient.nurse) : patient.nurse == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + bedNum;
        result = 31 * result + (nurse != null ? nurse.hashCode() : 0);
        return result;
    }
}
