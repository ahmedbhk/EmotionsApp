package justsmart.esprit.com.zaiedhospital.adapters;



import android.widget.LinearLayout;

import java.util.Date;
import justsmart.esprit.com.zaiedhospital.entities.Mood;

/**
 * Created by BHK on 22/05/2017.
 */

public class MoodsListDataModel {
        private String exp;
        private String name;
        private String level;
        private Date date;
        private String image;
        private int id;
        private LinearLayout layout;

    public MoodsListDataModel(String name, String level, Date date, String image) {
        this.name = name;
        this.level = level;
        this.date = date;
        this.image = image;

    }

    public MoodsListDataModel(String name, String level, Date date, String image, String exp, LinearLayout layout) {
        this.exp = exp;
        this.name = name;
        this.level = level;
        this.date = date;
        this.image = image;
        this.layout=layout;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MoodsListDataModel(Mood m) {
        name = m.getName();

    }

    public LinearLayout getLayout() {
        return layout;
    }

    public void setLayout(LinearLayout layout) {
        this.layout = layout;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }
}
