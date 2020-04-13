package Server;


import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ActivityCoordinatorDAO {


    protected static final Logger LOGGER = Logger.getLogger(ActivityCoordinatorDAO.class.getName());

    private final static String findStatementString = "SELECT * FROM activitycoordinator where username = ? and password = ?";
    private static final String insertActivityCoordinatorString = "INSERT INTO activitycoordinator (username,password,name,email,cnp)" + " VALUES (?,?,?,?,?)";
    private static final String viewAllStatementString = "SELECT * FROM activitycoordinator;";
    private static final String deleteStatementString = "DELETE FROM activitycoordinator WHERE name = ?;";
    private static final String editStatementString = "UPDATE activitycoordinator\n" + "SET password = ?, name = ?, email = ?, cnp = ?\n" + "WHERE username = ?;";

    /**
     * @return 1 for success, 0 otherwise
     */
    public static ActivityCoordinator findByName(String username, String password) {
        ActivityCoordinator toReturn = null;

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
            toReturn = new ActivityCoordinator(usr, passwordM, "ActivityCoordinator", fullname, email, cnp);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "MailerDAO:findByName " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
        return toReturn;
    }

    /**
     * @return a list of all the ActivityCoordinators in the database
     */
    public static ArrayList<Object> viewAll() {
        ArrayList<Object> toReturn = new ArrayList<Object>();

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement viewAllStatement = null;
        ResultSet rs = null;
        try {
            viewAllStatement = dbConnection.prepareStatement(viewAllStatementString);
            rs = viewAllStatement.executeQuery();
            rs.next();

            while (rs.next()) {
                int id = rs.getInt("id");
                String usr = rs.getString("username");
                String passwordM = rs.getString("password");
                String fullname = rs.getString("name");
                String email = rs.getString("email");
                String cnp = rs.getString("cnp");
                toReturn.add(new Mailer(usr, passwordM, "ActivityCoordinator", fullname, email, cnp));
            }

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ActivityCoordinatorDAO:viewAllActivityCoord " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(viewAllStatement);
            ConnectionFactory.close(dbConnection);
        }
        return toReturn;
    }

    /**
     * @return a list of all the ActivityCoordinators in the database
     */
    public static ArrayList<Object> viewAllForTablePrint() {
        ArrayList<Object> toReturn = new ArrayList<Object>();

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement viewAllStatement = null;
        ResultSet rs = null;
        try {
            viewAllStatement = dbConnection.prepareStatement(viewAllStatementString);
            rs = viewAllStatement.executeQuery();
            rs.next();

            while (rs.next()) {
                int id = rs.getInt("id");
                String usr = rs.getString("username");
                String passwordM = rs.getString("password");
                String fullname = rs.getString("name");
                String email = rs.getString("email");
                String cnp = rs.getString("cnp");
                toReturn.add(new ActivityCoordinatorDataParser(id, usr, passwordM, fullname, email, cnp));
            }

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ActivityCoordinatorDAO:viewAllActivityCoord " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(viewAllStatement);
            ConnectionFactory.close(dbConnection);
        }
        return toReturn;
    }

    /**
     * @param user the ActivityCoordinator to be inserted
     * @return 0 for success and -1 otherwhise
     */
    public static int insertActivityCoordinator(ActivityCoordinator user) {
        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement insertStatement = null;
        int insertedId = -1;
        try {
            insertStatement = dbConnection.prepareStatement(insertActivityCoordinatorString, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setString(1, user.getUsername());
            insertStatement.setString(2, user.getPassword());
            insertStatement.setString(3, user.getName());
            insertStatement.setString(4, user.getEmail());
            insertStatement.setString(5, user.getCNP());
            insertStatement.executeUpdate();

            ResultSet rs = insertStatement.getGeneratedKeys();
            if (rs.next()) {
                insertedId = rs.getInt(1);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "DataBaseAI:insertUser " + e.getMessage());
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
        return insertedId;
    }

    /**
     * @param user
     * @return 0 for success and -1 otherwhise
     */
    public static int edit(ActivityCoordinator user) {
        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement editStatement = null;
        try {
            editStatement = dbConnection.prepareStatement(editStatementString);
            editStatement.setString(1, user.getPassword());
            editStatement.setString(2, user.getName());
            editStatement.setString(3, user.getEmail());
            editStatement.setString(4, user.getCNP());
            editStatement.setString(5, user.getUsername());

            editStatement.executeUpdate();


        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ActivityCoordinatorDAO:edit " + e.getMessage());
            return 1;
        } finally {
            ConnectionFactory.close(editStatement);
            ConnectionFactory.close(dbConnection);
        }
        return 0;
    }


    /**
     * @param name of the ActivityCoordinator to delete
     * @return 0 for success and -1 otherwhise
     */
    public static int delete(String name) {
        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement deleteStatement = null;
        try {
            deleteStatement = dbConnection.prepareStatement(deleteStatementString);
            deleteStatement.setString(1, name);
            deleteStatement.executeUpdate();

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ActivityCoordinatorDAO:delete " + e.getMessage());
            return 1;
        } finally {
            ConnectionFactory.close(deleteStatement);
            ConnectionFactory.close(dbConnection);
        }
        return 0;
    }


}
