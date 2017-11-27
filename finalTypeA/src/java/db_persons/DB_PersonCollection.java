package db_persons;

import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

public class DB_PersonCollection {

    public static String update(Statement statement, HttpServletRequest request) {
        String errorMessage = "";
        String action = request.getParameter("action");
        if (action != null) {
            String name = request.getParameter("Name");
            String eyeColor = request.getParameter("EyeColor");
            String hairColor = request.getParameter("HairColor");
            String height = request.getParameter("Height");
            String weight = request.getParameter("Weight");
            DB_Person book = new DB_Person(name, eyeColor, hairColor, height, weight);

            String strIndex;
            int index;

            
            // important! add connection to the methods that need it for prepared statements
            switch (action) {
                case "Clear List":
                    errorMessage = DB_Person.remove(-1, statement);
                    break;
                case "add":
                    errorMessage = book.insert(statement);
                    break;
                case "remove":
                    strIndex = request.getParameter("index");
                    index = Integer.parseInt(strIndex);
                    errorMessage = DB_Person.remove(index, statement);
                    break;
                case "update":
                    strIndex = request.getParameter("index");
                    index = Integer.parseInt(strIndex);
                    errorMessage = book.update(index, statement);
                    break;
            }
        }

        ArrayList<DB_Person> personCollection = new ArrayList<>();
        errorMessage += DB_Person.getPeople(statement, personCollection);
        request.setAttribute("PersonCollection", personCollection);

        return errorMessage;
    }
}