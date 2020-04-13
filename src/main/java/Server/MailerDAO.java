package Server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MailerDAO {
    protected static final Logger LOGGER = Logger.getLogger(MailerDAO.class.getName());
    private static final String insertStatementString = "INSERT INTO mailer (name,email,cnp,username,password)" + " VALUES (?,?,?,?,?)";
    private final static String findStatementString = "SELECT * FROM mailer where username = ? and password = ?";
    private final static String findByFullNameString = "SELECT * FROM mailer where name = ? ";
    private final static String editStatementString = "UPDATE mailer\n" + "SET password = ?, name = ?, email = ?, cnp = ?\n" + "WHERE username = ?;";
    private final static String deleteStatementString = "DELETE FROM mailer WHERE name = ?;";
    private final static String viewAllMailers = "SELECT * FROM mailer";
    private final static String viewParcelsForMailer = "SELECT parcels.id, parcels.adress, parcels.receiver, parcels.weight\n" + "FROM parcels \n" + "INNER JOIN mailer ON parcels.mailerid = mailer.id \n" +  "WHERE mailer.name = ?;";

    /**
     * @param username the mailer's username
     * @param password the mailer's password
     * @return one Mailer data structure
     */

    public static Mailer findByUsername(String username, String password) {
        Mailer toReturn = null;

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = dbConnection.prepareStatement(findStatementString);
            findStatement.setString(1, username);
            findStatement.setString(2, password);
            rs = findStatement.executeQuery();
            rs.next();

            String fullname = rs.getString("name");
            String email = rs.getString("email");
            String cnp = rs.getString("cnp");
            String usr = rs.getString("username");
            String passwordM = rs.getString("password");
            toReturn = new Mailer(usr, passwordM, "Mailer", fullname, email, cnp);
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
     * @param fullname the mailer's name
     * @return one Mailer id data structure
     */

    public static int findByName(String fullname) {
        int toReturn = -1;

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = dbConnection.prepareStatement(findByFullNameString);
            findStatement.setString(1, fullname);
            rs = findStatement.executeQuery();
            rs.next();

            toReturn = rs.getInt("id");
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "MailerDAO:findByName " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }

        return toReturn;
    }


    public static ArrayList<Object> viewParcelsForMailer(String name, NodeNetwork nodeNetwork) {
        ArrayList<Object> toReturn = new ArrayList<Object>();

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement viewAllStatement = null;
        ResultSet rs = null;
        try {
            viewAllStatement = dbConnection.prepareStatement(viewParcelsForMailer);
            viewAllStatement.setString(1, name);
            rs = viewAllStatement.executeQuery();
            rs.next();

            while (rs.next()) {
                int id = rs.getInt("id");
                String adress = rs.getString("adress");
                String receiver = rs.getString("receiver");
                float weight = rs.getFloat("weight");
                Node my_node = nodeNetwork.getNode(adress);
                toReturn.add(new ParcelStandard(id, my_node, receiver, weight));
            }

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "MailerDAO:viewParcelsForMailer " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(viewAllStatement);
            ConnectionFactory.close(dbConnection);
        }
        return toReturn;
    }

    public static ArrayList<ParcelStandard> viewParcelsForMailerAsParcels(String name, NodeNetwork nodeNetwork) {
        ArrayList<ParcelStandard> toReturn = new ArrayList<ParcelStandard>();

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement viewAllStatement = null;
        ResultSet rs = null;
        try {
            viewAllStatement = dbConnection.prepareStatement(viewParcelsForMailer);
            viewAllStatement.setString(1, name);
            rs = viewAllStatement.executeQuery();
            rs.next();

            while (rs.next()) {
                int id = rs.getInt("id");
                String adress = rs.getString("adress");
                String receiver = rs.getString("receiver");
                float weight = rs.getFloat("weight");
                Node my_node = nodeNetwork.getNode(adress);
                toReturn.add(new ParcelStandard(id, my_node, receiver, weight));
            }

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "MailerDAO:viewParcelsForMailer " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(viewAllStatement);
            ConnectionFactory.close(dbConnection);
        }
        return toReturn;
    }


    public static ArrayList<Object> viewAllMailers() {
        ArrayList<Object> toReturn = new ArrayList<Object>();

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement viewAllStatement = null;
        ResultSet rs = null;
        try {
            viewAllStatement = dbConnection.prepareStatement(viewAllMailers);
            rs = viewAllStatement.executeQuery();
            rs.next();

            while (rs.next()) {
                int id = rs.getInt("id");
                String fullname = rs.getString("name");
                String email = rs.getString("email");
                String cnp = rs.getString("cnp");
                String usr = rs.getString("username");
                String passwordM = rs.getString("password");
                toReturn.add(new Mailer(usr, passwordM, "Mailer", fullname, email, cnp));
            }

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "MailerDAO:viewAllMailers " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(viewAllStatement);
            ConnectionFactory.close(dbConnection);
        }
        return toReturn;
    }


    public static ArrayList<Object> viewAllForTablePrint() {
        ArrayList<Object> toReturn = new ArrayList<Object>();

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement viewAllStatement = null;
        ResultSet rs = null;
        try {
            viewAllStatement = dbConnection.prepareStatement(viewAllMailers);
            rs = viewAllStatement.executeQuery();
            rs.next();

            while (rs.next()) {
                int id = rs.getInt("id");
                String fullname = rs.getString("name");
                String email = rs.getString("email");
                String cnp = rs.getString("cnp");
                String usr = rs.getString("username");
                String passwordM = rs.getString("password");
                toReturn.add(new MailerDataPaser(id, usr, passwordM, fullname, email, cnp));
            }

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "MailerDAO:viewAllMailers " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(viewAllStatement);
            ConnectionFactory.close(dbConnection);
        }
        return toReturn;
    }


    public static int insertMailer(Mailer user) {
        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement insertStatement = null;
        int insertedId = -1;
        try {
            insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setString(1, user.getName());
            insertStatement.setString(2, user.getEmail());
            insertStatement.setString(3, user.getCNP());
            insertStatement.setString(4, user.getUsername());
            insertStatement.setString(5, user.getPassword());
            insertStatement.executeUpdate();

            ResultSet rs = insertStatement.getGeneratedKeys();
            if (rs.next()) {
                insertedId = rs.getInt(1);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "MailerDAO:insertUser " + e.getMessage());
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
        return insertedId;
    }

    /**
     * @param user the mailer to edit
     * @return 0 for success and -1 otherwhise
     */
    public static int edit(Mailer user) {
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
            LOGGER.log(Level.WARNING, "MailerDAO:edit " + e.getMessage());
            return 1;
        } finally {
            ConnectionFactory.close(editStatement);
            ConnectionFactory.close(dbConnection);
        }
        return 0;
    }

    /**
     * @param name the name fot the Mailer to delete
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
            LOGGER.log(Level.WARNING, "MailerDAO:delete " + e.getMessage());
            return 1;
        } finally {
            ConnectionFactory.close(deleteStatement);
            ConnectionFactory.close(dbConnection);
        }
        return 0;
    }


}
