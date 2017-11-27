package db_persons;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DB_Person {

    // Name, eye color, hair color, height, and weight. 
    private String name;
    private String eyeColor;
    private String hairColor;
    private String height;
    private String weight;
    int index;

    public DB_Person(String name, String eyeColor, String hairColor, String height, String weight, int index) {
        this.name = name;
        this.eyeColor = eyeColor;
        this.hairColor = hairColor;
        this.height = height;
        this.weight = weight;
        this.index = index;
    }

    public DB_Person(String name, String eyeColor, String hairColor, String height, String weight) {
        this(name, eyeColor, hairColor, height, weight, -1); // index shouldn't be used.
    }

    public void setName(String t) {
        name = t;
    }
    public void setEyeColor(String a) {
        eyeColor = a;
    }
    public void setHairColor(String is) {
        hairColor = is;
    }
    public void setHeight(String e) {
        height = e;
    }
    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }
    public String getEyeColor() {
        return eyeColor;
    }
    public String getHairColor() {
        return hairColor;
    }
    public String getHeight() {
        return height;
    }
    public String getWeight() {
        return weight;
    }
    public int getIndex() {
        return index;
    }
    
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other.getClass() != getClass()) {
            return false;
        }
        DB_Person bother = (DB_Person) other;
        if (name.equals(bother.name) && hairColor.equals(bother.hairColor) && eyeColor.equals(bother.eyeColor) && height.equals(bother.height) && weight.equals(bother.weight)) {
            return true;
        } else {
            return false;
        }
    }

    public String update(int index, Statement statement) {
        String sql = "update PersonCollection set Name= ?, EyeColor= ?, HairColor= ?, Height= ?, Weight= ? where PersonSpot= ?";
        PreparedStatement pmt;
        String error="";
        try {
            pmt = statement.getConnection().prepareStatement(sql);
            pmt.setString(1, name);
            pmt.setString(2, eyeColor);
            pmt.setString(3, hairColor);
            pmt.setString(4, height);
            pmt.setString(5, weight);
            pmt.setInt(6, index);
            pmt.executeUpdate();
        } catch (SQLException ex) {
            error = ex.toString();
        }
        System.out.println("got to update just fine");
        return error;
    }

    public String insert(Statement statement) {
        // First find out if the book is already in the collection:
        String sql2 = "select Name from PersonCollection where Name=? AND EyeColor=? AND HairColor=? AND Height=? AND Weight=?";
        PreparedStatement pmt;
        String error="";
        try {
            pmt = statement.getConnection().prepareStatement(sql2);
            pmt.setString(1, name);
            pmt.setString(2, eyeColor);
            pmt.setString(3, hairColor);
            pmt.setString(4, height);
            pmt.setString(5, weight);
            System.out.println(pmt+" prepared1");
            ResultSet rs = pmt.executeQuery();
            if (rs.next()) {
                return "Person already exists";
            }
            sql2 = "insert into PersonCollection values(?, ?, ?, ?, ?, null)";
            pmt = statement.getConnection().prepareStatement(sql2);
            pmt.setString(1, name);
            pmt.setString(2, eyeColor);
            pmt.setString(3, hairColor);
            pmt.setString(4, height);
            pmt.setString(5, weight);
            pmt.executeUpdate();
        } catch (SQLException ex) {
            error = ex.toString();
        }
        System.out.println("got to insert just fine");
        return error;
    }

    // Note index =-1 will delete all rows
    public static String remove(int index, Statement statement) {
        String sql = "delete from PersonCollection ";
        if (index >= 0) {
            sql += " where PersonSpot=" + index;
        }
        return executeUpdate(sql, statement);
    }

    private static String executeUpdate(String sql, Statement statement) {
        String error = "";
        try {
            System.out.println("sql=" + sql);
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            error = e.toString();
        }
        return error;
    }

    public static String getPeople(Statement statement, ArrayList<DB_Person> people) {
        String error = "";
        try {
            String sql = "select * from PersonCollection";
            System.out.println("sql=" + sql);
            ResultSet rs = statement.executeQuery(sql);
            people.clear();
            while (rs.next()) {
                String n = rs.getString("Name");
                String e = rs.getString("EyeColor");
                String c = rs.getString("HairColor");
                String h = rs.getString("Height");
                String w = rs.getString("Weight");
                int ind = rs.getInt("PersonSpot");
                DB_Person bk = new DB_Person(n, e, c, h, w, ind);
                people.add(bk);
            }
        } catch (SQLException ex) {
            error = ex.toString();
        }
        return error;
    }

    // Surround with single quote
    private String q_surround(String s) {
        return "\'" + s + "\'";
    }
}