package justsmart.esprit.com.zaiedhospital.entities;

import java.util.Date;

/**
 * Created by BHK on 09/10/2017.
 */

public class Mood {
    public String level;
    public String name;
    public String explaination;
    public Date date;
    public int patientId;

    public Mood() {
    }

    public Mood(String level, String name, String explaination) {
        this.level = level;
        this.name = name;
        this.explaination = explaination;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }

    public String getExplaination() {
        return explaination;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExplaination(String explaination) {
        this.explaination = explaination;
    }

    @Override
    public String toString() {
        return "Mood{" +
                "level='" + level + '\'' +
                ", name='" + name + '\'' +
                ", explaination='" + explaination + '\'' +
                ", date=" + date +
                ", patientId=" + patientId +
                '}';
    }

    public Mood(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mood mood = (Mood) o;

        return name.equals(mood.name);

    }

    public Mood(String level, String name, String explaination, Date date) {
        this.level = level;
        this.name = name;
        this.explaination = explaination;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}


