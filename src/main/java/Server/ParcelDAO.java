package Server;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ParcelDAO {



    protected static final Logger LOGGER = Logger.getLogger(ActivityCoordinatorDAO.class.getName());

    private final static String findStatementString = "SELECT * FROM parcels where id = ?";
    private static final String insertStatementString = "INSERT INTO parcels (adress,receiver,weight)" + " VALUES (?,?,?)";
    private static final String viewAllStatementString = "SELECT * FROM parcels;";
    private static final String deleteStatementString = "DELETE FROM parcels WHERE id = ?;";
    private static final String editStatementString = "UPDATE parcels\n" + "SET adress = ?, receiver = ?, weight = ?\n" + "WHERE id = ?;";
    private static final String assignStatementString = "UPDATE parcels\n" + "SET mailerid = ?\n" + "WHERE id = ?;";

    /**
     * @return 1 for success, 0 otherwise
     */
    public static ParcelStandard findByName(int id, NodeNetwork nodeNetwork) {
        ParcelStandard toReturn = null;

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = dbConnection.prepareStatement(findStatementString);
            findStatement.setInt(1, id);
            rs = findStatement.executeQuery();
            rs.next();

            int idR = rs.getInt("id");
            String adress = rs.getString("adress");
            String receiver = rs.getString("receiver");
            float weight = rs.getFloat("weight");
            Node n = nodeNetwork.getNode(adress);
            toReturn = new ParcelStandard(idR,n,receiver, weight);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ParcelDAO:findByNumb " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
        return toReturn;
    }

    /**
     * @return a list of all the parcels in the database
     */
    public static ArrayList<Object> viewAll(NodeNetwork nodeNetwork) {
        ArrayList<Object> toReturn = new ArrayList<Object>();

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement viewAllStatement = null;
        ResultSet rs = null;
        try {
            viewAllStatement = dbConnection.prepareStatement(viewAllStatementString);
            rs = viewAllStatement.executeQuery();
            rs.next();

            while (rs.next()) {
                int idR = rs.getInt("id");
                String adress = rs.getString("adress");
                String receiver = rs.getString("receiver");
                float weight = rs.getFloat("weight");
                int mid = rs.getInt("mailerid");
                Node n = nodeNetwork.getNode(adress);
                toReturn.add(new ParcelStandard(idR,n,receiver, weight));
            }

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ParcelDAO:viewAll " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(viewAllStatement);
            ConnectionFactory.close(dbConnection);
        }
        return toReturn;
    }

    /**
     * @return a list of all the parcels in the database
     */
    public static ArrayList<Object> viewAllForTablePrint(NodeNetwork nodeNetwork) {
        ArrayList<Object> toReturn = new ArrayList<Object>();

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement viewAllStatement = null;
        ResultSet rs = null;
        try {
            viewAllStatement = dbConnection.prepareStatement(viewAllStatementString);
            rs = viewAllStatement.executeQuery();
            rs.next();

            while (rs.next()) {
                int idR = rs.getInt("id");
                String adress = rs.getString("adress");
                String receiver = rs.getString("receiver");
                float weight = rs.getFloat("weight");
                int mid = rs.getInt("mailerid");
                toReturn.add(new ParcelDataParser(idR,adress,receiver,weight,mid));
            }

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ParcelDAO:viewAll " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(viewAllStatement);
            ConnectionFactory.close(dbConnection);
        }
        return toReturn;
    }



    public static ArrayList<ParcelStandard> viewAllAsParcelStandard(NodeNetwork nodeNetwork) {
        ArrayList<ParcelStandard> toReturn = new ArrayList<ParcelStandard>();

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement viewAllStatement = null;
        ResultSet rs = null;
        try {
            viewAllStatement = dbConnection.prepareStatement(viewAllStatementString);
            rs = viewAllStatement.executeQuery();
            rs.next();

            while (rs.next()) {
                int idR = rs.getInt("id");
                String adress = rs.getString("adress");
                String receiver = rs.getString("receiver");
                float weight = rs.getFloat("weight");
                int mid = rs.getInt("mailerid");
                Node n = nodeNetwork.getNode(adress);
                toReturn.add(new ParcelStandard(idR,n,receiver, weight));
            }

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ParcelDAO:viewAll " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(viewAllStatement);
            ConnectionFactory.close(dbConnection);
        }
        return toReturn;
    }

    /**
     * @param parcel the parcel to be inserted
     * @return 0 for success and -1 otherwhise
     */
    public static int insert(ParcelStandard parcel) {
        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement insertStatement = null;
        int insertedId = -1;
        try {
            insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
            insertStatement.setString(1, parcel.getAdress().getAdress());
            insertStatement.setString(2, parcel.getReceiverName());
            insertStatement.setFloat( 3, parcel.getWeight());
            insertStatement.executeUpdate();

            ResultSet rs = insertStatement.getGeneratedKeys();
            if (rs.next()) {
                insertedId = rs.getInt(1);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ParcelDAO:insert " + e.getMessage());
        } finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
        }
        return insertedId;
    }

    /**
     * @param id the id of the Parcel
     * @param parcel the parcel to edit
     * @return 0 for success and -1 otherwhise
     */
    public static int edit(int id, ParcelStandard parcel) {
        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement editStatement = null;
        try {
            editStatement = dbConnection.prepareStatement(editStatementString);
            editStatement.setString(1, parcel.getAdress().getAdress());
            editStatement.setString(2, parcel.getReceiverName());
            editStatement.setFloat( 3, parcel.getWeight());
            editStatement.setInt(4, id);

            editStatement.executeUpdate();


        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ParcelDAO:edit " + e.getMessage());
            return 1;
        } finally {
            ConnectionFactory.close(editStatement);
            ConnectionFactory.close(dbConnection);
        }
        return 0;
    }


    /**
     * @param id the id of the parcel to delete
     * @return 0 for success and -1 otherwhise
     */
    public static int delete(int id) {
        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement deleteStatement = null;
        try {
            deleteStatement = dbConnection.prepareStatement(deleteStatementString);
            deleteStatement.setInt(1, id);
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


    public static int assignToMailer(String mailerName, int parcelId) {

        MailerDAO mailerDAO = new MailerDAO();
        int mailerId = mailerDAO.findByName(mailerName);

        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement editStatement = null;
        try {
            editStatement = dbConnection.prepareStatement(assignStatementString);
            editStatement.setInt(1, mailerId);
            editStatement.setInt(2, parcelId);

            editStatement.executeUpdate();


        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "ParcelDAO:edit " + e.getMessage());
            return 1;
        } finally {
            ConnectionFactory.close(editStatement);
            ConnectionFactory.close(dbConnection);
        }
        return 0;
    }




}
