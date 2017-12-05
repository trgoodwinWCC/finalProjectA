package db_persons;

import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;

public class loginServlet {
    public static String update(Statement statement, HttpServletRequest request) {
        String errorMessage = "";
        String action = request.getParameter("action");
        
        if (action != null) {
            String sellerName = request.getParameter("SellerName");
            String sellerPassword = request.getParameter("SellerPassword");
            String createSellerName = request.getParameter("CreateSellerName");
            String createSellerPassword = request.getParameter("CreateSellerPassword");

            String strIndex;
            int index;

            
            // important! add connection to the methods that need it for prepared statements
            switch (action) {
                case "Login":
                    
                //
                case "Clear List":
                    errorMessage = DB_Person.remove(-1, statement);
                    break;
            }
        }

        ArrayList<DB_Person> personCollection = new ArrayList<>();
        errorMessage += DB_Person.getPeople(statement, personCollection);
        request.setAttribute("PersonCollection", personCollection);

        return errorMessage;
    }
}
