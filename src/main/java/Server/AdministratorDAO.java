package Server;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdministratorDAO {

    protected static final Logger LOGGER = Logger.getLogger(ActivityCoordinatorDAO.class.getName());
    private final static String findStatementString = "SELECT * FROM administrator where username = ? and password = ?";

    /**
     * @return 1 for success, 0 otherwise
     */
    public static Administrator findByName(String username, String password) {
        Administrator toReturn = null;

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = dbConnection.prepareStatement(findStatementString);
            findStatement.setString(1, username);
            findStatement.setString(2, password);
            rs = findStatement.executeQuery();
            rs.next();

            String usr = rs.getString("username");
            String passwordM = rs.getString("password");
            String fullname = rs.getString("name");
            String email = rs.getString("email");
            String cnp = rs.getString("cnp");
            toReturn = new Administrator(usr, passwordM, "Administrator", fullname, email, cnp);

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "MailerDAO:findByName " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
        return toReturn;
    }

}
