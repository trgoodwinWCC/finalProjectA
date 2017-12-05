package db_persons;

import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import jdbc.PasswordSave;

public class loginServlet {
    public static String update(Statement statement, HttpServletRequest request) {
        String errorMessage = "";
        String action = request.getParameter("action");
        
        //consider adding this page to the controller and doing if/else on the button inputs.
        //Also figure out how to redirect to and from this part.
        
        if (action != null) {
            String sellerName = request.getParameter("SellerName");
            String sellerPassword = request.getParameter("SellerPassword");
            String createSellerName = request.getParameter("CreateSellerName");
            String createSellerPassword = request.getParameter("CreateSellerPassword");

            PasswordSave saving = new PasswordSave();
            switch (action) {
                case "Login":
                    if(saving.attemptLogin(sellerName,sellerPassword,statement)) {
                        errorMessage="Username or password is incorrect.";
                    }
                    break;
                case "Create Account":
                    if(saving.createAccount(createSellerName, createSellerPassword, statement))
                        errorMessage="A error occured or the username is already used.";
                    break;
            }
        }

        //request.setAttribute("PersonCollection", personCollection);

        return errorMessage;
    }
}
