package Client;
import Server.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class View {

    JFrame frameC;

    //Controller and other objects
    private Controller controller = new Controller();
    private LogInMemory model = new LogInMemory();
    public boolean Switch = true;

    //Log in fields
    private JTextField jtxtLogInUsername;
    private JPasswordField jtxtLogInPassword;
    private JButton jbtLogIn;
    private JPanel logInPanel;
    private JLabel jlbLogIn;


    //Universal fields (for all users)
    private JButton jbtLogOut;
    private JPanel mainPanel;
    private JPanel userInfoPanel;
    private JTextField jtxtUsernameAfterLogIn;
    private JLabel jlbUserLogo;
    private JPanel topPanel;

    //Mailer Panel fields
    private JButton jbtViewParcels;
    private JButton jbtViewRoute;
    private JButton jbtSearchParcel;
    private JPanel mailerPanel;
    private ArrayList<Object> parcelList;
    private JTable jtParcelList;
    private JScrollPane spParcelList;
    private JTextField jtxtViewParcelMailerName;
    private JTextField jtxtViewOptimalRouteMailerName;
    private JTextField jtxtSearchParcel;
    private JPanel searchPanel;
    private JLabel jlbParcelNo;
    private JLabel jlbParcelDestination;
    private JLabel jlbNameOfDestination;
    private JLabel jlbParcelWeight;
    private JLabel jlbPressButtonToSearch;
    private JTextField jtxtEnterParcelNo;
    private JTextField jtxtDestinationName;
    private JTextField jtxtReciverName;
    private JTextField jtxtWeight;
    private JButton jbtSeachParcel;
    private JLabel jlbNodeNetwork;
    private JTextField jtxtOptimalRoute;


    //Activity coordinator stuff
    private JLabel jlbPressButtonToNew;
    private JLabel jlbPressButtonToEdit;
    private JLabel jlbPressButtonToDelete;
    private JButton jbtPresstoNewParcel;
    private JButton jbtPresstoEditParcel;
    private JButton jbtPresstoDeleteParcel;
    private JPanel panelCoordinator;
    private JLabel jlbMailerNameAssign;
    private JLabel jlbParcelNoForAssign;
    private JTextField jtxtMailerNameAssign;
    private JTextField jtxtParcelNoForAssign;
    private JButton jbtSetPacelToMailer;
    private JButton jbtSaveReports;
    private JPanel panelParcelToPostman;
    private JLabel jlbPressToAssign;
    private JButton jbtPressToAssign;
    private JPanel panelSaveReports;
    private JLabel jlbReportType;
    private JComboBox jtxtReportType;
    private JButton jbtPressToSaveReport;


    //Admin stuff
    private JButton jbtViewMailers;
    private JButton jbtViewActivityCoordinators;
    private JButton jbtCreate;
    private JButton jbtDelete;
    private JButton jbtUpdate;
    private JPanel panelAdmin;
    private JPanel panelForButtonsAdmin;


    private ArrayList<Object> mailersList;
    private JTable jtMailersList;
    private JScrollPane spMailerList;
    private ArrayList<Object> activityCoordinatorsList;
    private JTable jtActivityCoordinatorsList;
    private JScrollPane spActivityCoordinatorsList;

    private JLabel jlbUsername;
    private JLabel jlbPassword;
    private JLabel jlbFullName;
    private JLabel jlbEmailAdress;
    private JLabel jlbCNP;

    private JTextField jtxtUsernameAdmin;
    private JTextField jtxtPasswordAdmin;
    private JTextField jtxtFullNameAdmin;
    private JTextField jtxtEmailAdressAdmin;
    private JTextField jtxtCNPAdmin;



    public View(){

        frameC = new JFrame();
        frameC.setBackground(Color.BLACK);
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();



        ///////////////////// Log in screen begin /////////////////////////

        Icon icon1 = new ImageIcon("src/resources/door.png");
        jbtLogIn = new JButton(icon1);
        jbtLogIn.setText("LOG IN");
        jbtLogIn.setBackground(Color.gray);
        jtxtLogInUsername = new JTextField(40);
        jtxtLogInUsername.setText("Username");
        jtxtLogInPassword = new JPasswordField(15);
        jtxtLogInPassword.setText("Password");
        jlbLogIn = new JLabel();
        jlbLogIn.setIcon(new ImageIcon("src/resources/logoCourierSmall.jpg"));


        logInPanel = new JPanel();
        logInPanel.setLayout(new GridLayout(4, 1));
        logInPanel.add(jlbLogIn);
        logInPanel.add(jtxtLogInUsername);
        logInPanel.add(jtxtLogInPassword);
        logInPanel.add(jbtLogIn);

        gc.weightx = 0.5;
        gc.weighty = 0.5;
        gc.gridx = 0;
        gc.gridy = 0;
        mainPanel.add(logInPanel, gc);

        ////////////////// Top Panel /////////////////////

        topPanel = new JPanel(new GridBagLayout());
        gc.weightx = 0.5;
        gc.weighty = 0.5;
        gc.gridx = 0;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        mainPanel.add(topPanel, gc);
        topPanel.setVisible(false);


        ////////////////// User stuff panel /////////////////////

        userInfoPanel = new JPanel(new GridBagLayout());
        gc.weightx = 0.5;
        gc.weighty = 0.5;
        gc.gridx = 0;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_START;

        jlbUserLogo = new JLabel();
        jlbUserLogo.setIcon(new ImageIcon("src/resources/logoCourierSmall.jpg"));
        userInfoPanel.add(jlbUserLogo, gc);

        jtxtUsernameAfterLogIn = new JTextField(20);
        jtxtUsernameAfterLogIn.setEditable(false);
        jtxtUsernameAfterLogIn.setText("Logged in as: ");
        gc.weightx = 0.2;
        gc.weighty = 0.2;
        gc.gridx = 0;
        gc.gridy = 1;
        gc.anchor = GridBagConstraints.LINE_START;
        userInfoPanel.add(jtxtUsernameAfterLogIn, gc);

        jbtLogOut = new JButton(new ImageIcon("src/resources/openDoor.png"));
        jbtLogOut.setBackground(Color.gray);
        jbtLogOut.setText("Log Out");
        gc.weightx = 0.2;
        gc.weighty = 0.2;
        gc.gridx = 0;
        gc.gridy = 2;
        gc.anchor = GridBagConstraints.LINE_START;
        userInfoPanel.add(jbtLogOut, gc);

        gc.weightx = 0.5;
        gc.weighty = 0.5;
        gc.gridx = 0;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        topPanel.add(userInfoPanel, gc);


        ////////////////// Mailer panel ////////////////////

        mailerPanel = new JPanel(new GridLayout(1,3));

        jbtViewParcels = new JButton(new ImageIcon("src/resources/box.png"));
        jbtViewParcels.setText("View Parcels");
        jbtViewParcels.setBackground(Color.WHITE);
        jbtViewRoute = new JButton(new ImageIcon("src/resources/truck.png"));
        jbtViewRoute.setText("View Route");
        jbtViewRoute.setBackground(Color.WHITE);
        jbtSearchParcel = new JButton(new ImageIcon("src/resources/search.png"));
        jbtSearchParcel.setText("Search Parcel");
        jbtSearchParcel.setBackground(Color.WHITE);

        mailerPanel.add(jbtViewParcels);
        mailerPanel.add(jbtViewRoute);
        mailerPanel.add(jbtSearchParcel);

        jtxtViewParcelMailerName = new JTextField("Mailer name: cristi");
        jtxtViewParcelMailerName.setBackground(Color.WHITE);
        jtxtViewOptimalRouteMailerName = new JTextField("Mailer name: cristi");
        jtxtViewOptimalRouteMailerName.setBackground(Color.WHITE);
        jtxtSearchParcel = new JTextField("Enter parcel no. : 3");
        jtxtSearchParcel.setBackground(Color.WHITE);

        gc.weightx = 4;
        gc.weighty = 4;
        gc.gridx = 1;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        topPanel.add(mailerPanel, gc);

        ///////////////// Table with Parcels //////////////////

        parcelList = ParcelDAO.viewAllForTablePrint(controller.nodeNetwork);
        jtParcelList = controller.createTable(parcelList);
        jtParcelList.setBounds(201, 0, 1080, 400);
        spParcelList = new JScrollPane(jtParcelList);
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.weightx = 1;
        gc.weighty = 0.75;
        gc.gridx = 1;
        gc.gridy = 1;

        topPanel.add(spParcelList,gc);


        /////////////// Map panel ////////////////////

        jlbNodeNetwork = new JLabel();
        jlbNodeNetwork.setIcon(new ImageIcon("src/resources/nodes.png"));
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.weightx = 1;
        gc.weighty = 0.75;
        gc.gridx = 1;
        gc.gridy = 1;
        topPanel.add(jlbNodeNetwork,gc);
        jlbNodeNetwork.setVisible(false);
        jtxtOptimalRoute = new JTextField("Optimal Route here: ");
        jtxtOptimalRoute.setBackground(Color.WHITE);
        topPanel.add(jtxtOptimalRoute);
        Font font1 = new Font("SansSerif", Font.BOLD, 30);
        jtxtOptimalRoute.setSize(150,20);
        jtxtOptimalRoute.setFont(font1);
        jtxtOptimalRoute.setHorizontalAlignment(JTextField.CENTER);
        jtxtOptimalRoute.setVisible(false);



        //////////////// Search parcel Parcel/////////////////

        searchPanel = new JPanel(new GridLayout(2,8));
        jlbParcelNo = new JLabel("Parcel No. ");
        jlbParcelDestination = new JLabel("Parcel Destination");
        jlbNameOfDestination = new JLabel("Reciver Name");
        jlbParcelWeight = new JLabel("Weight");
        jlbPressButtonToSearch = new JLabel("press search");
        jlbPressButtonToNew = new JLabel("press new");
        jlbPressButtonToEdit = new JLabel("press edit");
        jlbPressButtonToDelete = new JLabel("press delete");



        searchPanel.add(jlbParcelNo);
        searchPanel.add(jlbParcelDestination);
        searchPanel.add(jlbNameOfDestination);
        searchPanel.add(jlbParcelWeight);
        searchPanel.add(jlbPressButtonToSearch);
        searchPanel.add(jlbPressButtonToNew);
        searchPanel.add(jlbPressButtonToEdit);
        searchPanel.add(jlbPressButtonToDelete);


        jtxtEnterParcelNo = new JTextField("");
        jtxtDestinationName = new JTextField("Empty");
        jtxtDestinationName.setEditable(false);
        jtxtReciverName = new JTextField("Empty");
        jtxtReciverName.setEditable(false);
        jtxtWeight = new JTextField("Empty");
        jtxtWeight.setEditable(false);
        jbtSeachParcel = new JButton("Search");
        jbtSeachParcel.setBackground(Color.WHITE);
        jbtSeachParcel.setIcon(new ImageIcon("src/resources/search.png"));

        jbtPresstoNewParcel = new JButton("New");
        jbtPresstoNewParcel.setBackground(Color.WHITE);
        jbtPresstoNewParcel.setIcon(new ImageIcon("src/resources/new.png"));

        jbtPresstoEditParcel = new JButton("Edit");
        jbtPresstoEditParcel.setBackground(Color.WHITE);
        jbtPresstoEditParcel.setIcon(new ImageIcon("src/resources/edit.png"));

        jbtPresstoDeleteParcel = new JButton("Delete");
        jbtPresstoDeleteParcel.setBackground(Color.WHITE);
        jbtPresstoDeleteParcel.setIcon(new ImageIcon("src/resources/delete.png"));

        searchPanel.add(jtxtEnterParcelNo);
        searchPanel.add(jtxtDestinationName);
        searchPanel.add(jtxtReciverName);
        searchPanel.add(jtxtWeight);
        searchPanel.add(jbtSeachParcel);
        searchPanel.add(jbtPresstoNewParcel);
        searchPanel.add(jbtPresstoEditParcel);
        searchPanel.add(jbtPresstoDeleteParcel);

        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.weightx = 1;
        gc.weighty = 0.75;
        gc.gridx = 1;
        gc.gridy = 2;

        topPanel.add(searchPanel,gc);
        searchPanel.setVisible(false);

        ///////////////// Activity coordinator panels ////////////////

        panelCoordinator = new JPanel(new GridLayout(1,2));
        jbtSetPacelToMailer = new JButton("Set parcel to postman");
        jbtSetPacelToMailer.setBackground(Color.WHITE);
        jbtSetPacelToMailer.setIcon(new ImageIcon("src/resources/assignParcel.png"));

        jbtSaveReports = new JButton("Save Reports");
        jbtSaveReports.setBackground(Color.WHITE);
        jbtSaveReports.setIcon(new ImageIcon("src/resources/excel.png"));

        panelCoordinator.add(jbtSetPacelToMailer);
        panelCoordinator.add(jbtSaveReports);

        gc.fill = GridBagConstraints.NONE;
        gc.weightx = 2;
        gc.weighty = 1;
        gc.gridx = 2;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        topPanel.add(panelCoordinator, gc);

        jlbMailerNameAssign = new JLabel("Mailer Name");
        jlbParcelNoForAssign = new JLabel("Parcel no.");
        jlbPressToAssign = new JLabel("Press to assign");
        jtxtMailerNameAssign = new JTextField("Enter here");
        jtxtParcelNoForAssign = new JTextField("Enter here");

        jbtPressToAssign = new JButton("");
        jbtPressToAssign.setBackground(Color.WHITE);
        jbtPressToAssign.setIcon(new ImageIcon("src/resources/assignParcel.png"));

        panelParcelToPostman = new JPanel(new GridLayout(2,3));
        panelParcelToPostman.add(jlbMailerNameAssign);
        panelParcelToPostman.add(jlbParcelNoForAssign);
        panelParcelToPostman.add(jlbPressToAssign);
        panelParcelToPostman.add(jtxtMailerNameAssign);
        panelParcelToPostman.add(jtxtParcelNoForAssign);
        panelParcelToPostman.add(jbtPressToAssign);


        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.weightx = 1;
        gc.weighty = 0.75;
        gc.gridx = 1;
        gc.gridy = 3;

        topPanel.add(panelParcelToPostman,gc);
        panelParcelToPostman.setVisible(false);

        ///////////////// Save Reports Panel //////////////////

        panelSaveReports = new JPanel(new GridLayout(1,3));
        panelSaveReports.setVisible(false);
        jlbReportType = new JLabel("Select type  ");
        panelSaveReports.add(jlbReportType);
        jtxtReportType = new JComboBox();
        jtxtReportType.setBackground(Color.WHITE);
        jtxtReportType.addItem("CSV");
        jtxtReportType.addItem("XML");
        jtxtReportType.addItem("JSON");
        panelSaveReports.add(jtxtReportType);

        jbtPressToSaveReport = new JButton("");
        jbtPressToSaveReport.setBackground(Color.WHITE);
        jbtPressToSaveReport.setIcon(new ImageIcon("src/resources/new.png"));
        panelSaveReports.add(jbtPressToSaveReport);

        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.weightx = 1;
        gc.weighty = 0.75;
        gc.gridx = 1;
        gc.gridy = 4;

        topPanel.add(panelSaveReports,gc);


        ///////////////// Admin Panel /////////////////

        panelAdmin = new JPanel(new GridLayout(1,2));
        jbtViewMailers = new JButton("View Mailers");
        jbtViewMailers.setBackground(Color.WHITE);
        jbtViewMailers.setIcon(new ImageIcon("src/resources/assignParcel.png"));

        jbtViewActivityCoordinators = new JButton("View Activity Coordinators");
        jbtViewActivityCoordinators.setBackground(Color.WHITE);
        jbtViewActivityCoordinators.setIcon(new ImageIcon("src/resources/activityCoordinator.png"));

        panelAdmin.add(jbtViewMailers);
        panelAdmin.add(jbtViewActivityCoordinators);

        gc.fill = GridBagConstraints.NONE;
        gc.weightx = 2;
        gc.weighty = 1;
        gc.gridx = 2;
        gc.gridy = 0;
        gc.anchor = GridBagConstraints.LINE_START;
        topPanel.add(panelAdmin, gc);
        panelAdmin.setVisible(false);


        ////////////////// Table with Mailers ////////////////

        MailerDAO mailerDAO = new MailerDAO();
        mailersList = mailerDAO.viewAllForTablePrint();
        jtMailersList = controller.createTable(mailersList);
        jtMailersList.setBounds(201, 0, 1080, 400);
        spMailerList = new JScrollPane(jtMailersList);
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.weightx = 1;
        gc.weighty = 0.75;
        gc.gridx = 1;
        gc.gridy = 1;

        topPanel.add(spMailerList, gc);
        spMailerList.setVisible(false);

        ////////// Table with Activity Coordinators //////////

        ActivityCoordinatorDAO act = new ActivityCoordinatorDAO();
        activityCoordinatorsList = act.viewAllForTablePrint();
        jtActivityCoordinatorsList = controller.createTable(activityCoordinatorsList);
        jtActivityCoordinatorsList.setBounds(201, 0, 1080, 400);
        spActivityCoordinatorsList = new JScrollPane(jtActivityCoordinatorsList);
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.anchor = GridBagConstraints.LINE_START;
        gc.weightx = 1;
        gc.weighty = 0.75;
        gc.gridx = 1;
        gc.gridy = 1;

        topPanel.add(spActivityCoordinatorsList, gc);
        spActivityCoordinatorsList.setVisible(false);



        /////////// Table with data for the admin ////////////

        panelForButtonsAdmin = new JPanel(new GridLayout(3,6));
        jlbUsername = new JLabel("Username");
        jlbPassword = new JLabel("Password");
        jlbFullName = new JLabel("Full Name");
        jlbEmailAdress = new JLabel("Email");
        jlbCNP = new JLabel("CNP");
        panelForButtonsAdmin.add(jlbUsername);
        panelForButtonsAdmin.add(jlbPassword);
        panelForButtonsAdmin.add(jlbFullName);
        panelForButtonsAdmin.add(jlbEmailAdress);
        panelForButtonsAdmin.add(jlbCNP);

        jtxtUsernameAdmin = new JTextField();
        jtxtPasswordAdmin = new JTextField();
        jtxtFullNameAdmin = new JTextField();
        jtxtEmailAdressAdmin = new JTextField();
        jtxtCNPAdmin = new JTextField();
        panelForButtonsAdmin.add(jtxtUsernameAdmin);
        panelForButtonsAdmin.add(jtxtPasswordAdmin);
        panelForButtonsAdmin.add(jtxtFullNameAdmin);
        panelForButtonsAdmin.add(jtxtEmailAdressAdmin);
        panelForButtonsAdmin.add(jtxtCNPAdmin);

        jbtCreate = new JButton("Create");
        jbtCreate.setBackground(Color.WHITE);
        jbtCreate.setIcon(new ImageIcon("src/resources/new.png"));
        panelForButtonsAdmin.add(jbtCreate);

        jbtUpdate = new JButton("Update");
        jbtUpdate.setBackground(Color.WHITE);
        jbtUpdate.setIcon(new ImageIcon("src/resources/edit.png"));
        panelForButtonsAdmin.add(jbtUpdate);

        jbtDelete = new JButton("Delete");
        jbtDelete.setBackground(Color.WHITE);
        jbtDelete.setIcon(new ImageIcon("src/resources/delete.png"));
        panelForButtonsAdmin.add(jbtDelete);


        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        gc.weightx = 1;
        gc.weighty = 0.75;
        gc.gridx = 1;
        gc.gridy = 5;

        topPanel.add(panelForButtonsAdmin,gc);
        panelForButtonsAdmin.setVisible(false);

        ///////////////// Action Listeners ///////////////////

        jbtLogIn.addActionListener(new ListenToLogIn());
        jbtViewParcels.addActionListener(new ListenToViewParcels());
        jbtLogOut.addActionListener(new ListenToLogOut());
        jbtSearchParcel.addActionListener(new ListenToSearchParcel());
        jbtSeachParcel.addActionListener(new ListenToActuallySearch());
        jbtPresstoNewParcel.addActionListener(new ListenToNewParcel());
        jbtPresstoEditParcel.addActionListener(new ListenToEditParcel());
        jbtPresstoDeleteParcel.addActionListener(new ListenToDeleteParcel());
        jbtSetPacelToMailer.addActionListener(new ListenToAssignParcel());
        jbtPressToAssign.addActionListener(new ListenToActuallyAssignParcel());
        jbtSaveReports.addActionListener(new ListenToSaveReports());
        jbtPressToSaveReport.addActionListener(new ListenToActuallySaveReports());
        jbtViewRoute.addActionListener(new ListenToViewRoute());
        jbtViewMailers.addActionListener(new ListenToViewMailers());
        jbtViewActivityCoordinators.addActionListener(new ListenToViewActivityCoordinators());
        jbtCreate.addActionListener(new ListenToCreate());
        jbtDelete.addActionListener(new ListenToDelete());
        jbtUpdate.addActionListener(new ListenToUpdate());

        ///////////////// Final Stuff ////////////////////

        frameC.add(mainPanel);
        frameC.setSize(1920, 1080);
        frameC.setVisible(true);
        frameC.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    class ListenToLogIn implements ActionListener {


        public void actionPerformed(ActionEvent e) {

            try {

                String username = jtxtLogInUsername.getText();
                String password = jtxtLogInPassword.getText();
                Boolean isLoggedIn = false;

                Mailer mailer = Client.logInMailer("192.168.0.108", 5000,username,password);
                    if(mailer != null){
                        logInPanel.setVisible(false);
                        topPanel.setVisible(true);
                        jtxtUsernameAfterLogIn.setText("Logged in as: " + jtxtLogInUsername.getText());
                        isLoggedIn = true;
                        model.setTypeOfUserLoggedIn("Mailer");
                        model.setMailer(mailer);
                        panelCoordinator.setVisible(false);
                        jtxtDestinationName.setEditable(false);
                        jtxtReciverName.setEditable(false);
                        jtxtWeight.setEditable(false);
                        mailerPanel.setVisible(true);
                        spParcelList.setVisible(true);
                        spMailerList.setVisible(false);
                        jbtPresstoDeleteParcel.setEnabled(false);
                        jbtPresstoEditParcel.setEnabled(false);
                        jbtPresstoNewParcel.setEnabled(false);

                        parcelList.clear();
                        parcelList = Client.requestParcelsForMailer("192.168.0.108", 5000, mailer.getName());
                        jtParcelList.removeAll();
                        jtParcelList = controller.createTable(parcelList);
                        spParcelList.getViewport().setView(jtParcelList);
                        spParcelList.revalidate();
                        spParcelList.repaint();

                    }




                //ActivityCoordinator ac = ActivityCoordinatorDAO.findByName(username, password);
                ActivityCoordinator ac = Client.logInActivityCoordinator("192.168.0.108", 5000,username,password);

                    if(ac != null){
                        logInPanel.setVisible(false);
                        topPanel.setVisible(true);
                        jtxtUsernameAfterLogIn.setText("Logged in as: " + jtxtLogInUsername.getText());
                        isLoggedIn = true;
                        model.setActivityCoordinator(ac);
                        model.setTypeOfUserLoggedIn("ActivityCoordinator");
                        panelCoordinator.setVisible(true);
                        jtxtDestinationName.setEditable(true);
                        jtxtReciverName.setEditable(true);
                        jtxtWeight.setEditable(true);
                        mailerPanel.setVisible(true);
                        spParcelList.setVisible(true);
                        spMailerList.setVisible(false);
                        spActivityCoordinatorsList.setVisible(false);
                        jbtPresstoDeleteParcel.setEnabled(true);
                        jbtPresstoEditParcel.setEnabled(true);
                        jbtPresstoNewParcel.setEnabled(true);

                        parcelList.clear();
                        parcelList = Client.requestAllParcels("192.168.0.108", 5000);
                        jtParcelList.removeAll();
                        jtParcelList = controller.createTable(parcelList);
                        spParcelList.getViewport().setView(jtParcelList);
                        spParcelList.revalidate();
                        spParcelList.repaint();

                    }


            //Administrator admin = AdministratorDAO.findByName(username,password);
                Administrator admin = Client.logInAdministrator("192.168.0.108", 5000,username,password);
                    if(admin != null){
                        logInPanel.setVisible(false);
                        topPanel.setVisible(true);
                        panelAdmin.setVisible(true);
                        mailerPanel.setVisible(false);
                        spParcelList.setVisible(false);
                        panelCoordinator.setVisible(false);
                        spMailerList.setVisible(! Switch);
                        spActivityCoordinatorsList.setVisible(Switch);
                        panelForButtonsAdmin.setVisible(true);
                        jtxtUsernameAfterLogIn.setText("Logged in as: " + jtxtLogInUsername.getText());
                        isLoggedIn = true;
                        model.setAdmin(admin);
                        model.setTypeOfUserLoggedIn("Administrator");

                        Switch = ! Switch;


                    }


                if(isLoggedIn == false){
                    jtxtLogInUsername.setText("Username or password wrong");
                }

            } catch (Exception e1) {
                System.out.println("Ooops! Something went wrong" + e1);
            }

        }
    }

    class ListenToLogOut implements ActionListener {


        public void actionPerformed(ActionEvent e) {

            try {


                spMailerList.setVisible(false);
                spActivityCoordinatorsList.setVisible(false);
                panelForButtonsAdmin.setVisible(false);
                logInPanel.setVisible(true);
                topPanel.setVisible(false);
                panelAdmin.setVisible(false);
                jlbNodeNetwork.setVisible(false);
                jtxtOptimalRoute.setVisible(false);
                mailerPanel.setVisible(false);
                searchPanel.setVisible(false);
                panelSaveReports.setVisible(false);
                jtxtUsernameAfterLogIn.setText("");
                model.setTypeOfUserLoggedIn("");


            } catch (Exception e1) {
                System.out.println("Ooops! Something went wrong");
            }

        }
    }

    class ListenToViewParcels implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            try {



                spParcelList.setVisible(true);
                searchPanel.setVisible(false);
                panelParcelToPostman.setVisible(false);
                panelSaveReports.setVisible(false);
                jlbNodeNetwork.setVisible(false);
                jtxtOptimalRoute.setVisible(false);



                if(model.getTypeOfUserLoggedIn().equals("Mailer")){
                    Mailer mailer = model.getMailer();
                    parcelList.clear();
                    parcelList = Client.requestParcelsForMailer("192.168.0.108", 5000, mailer.getName());
                    jtParcelList.removeAll();
                    jtParcelList = controller.createTable(parcelList);
                    spParcelList.getViewport().setView(jtParcelList);
                    spParcelList.revalidate();
                    spParcelList.repaint();
                }
                else{
                    parcelList.clear();
                    parcelList = Client.requestAllParcels("192.168.0.108", 5000);
                    //parcelList = ParcelDAO.viewAllForTablePrint(controller.nodeNetwork);
                    jtParcelList.removeAll();
                    jtParcelList = controller.createTable(parcelList);
                    spParcelList.getViewport().setView(jtParcelList);
                    spParcelList.revalidate();
                    spParcelList.repaint();
                }



            } catch (Exception e1) {
                System.out.println("Ooops! Something went wrong");
            }

        }
    }

    class ListenToSearchParcel implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            try {

                spParcelList.setVisible(false);
                searchPanel.setVisible(true);
                panelParcelToPostman.setVisible(false);
                panelSaveReports.setVisible(false);
                jlbNodeNetwork.setVisible(false);
                jtxtOptimalRoute.setVisible(false);


            } catch (Exception e1) {
                System.out.println("Ooops! Something went wrong");
            }

        }
    }

    class ListenToActuallySearch implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            try {

                //ParcelStandard parcel = ParcelDAO.findByName(Integer.parseInt( jtxtEnterParcelNo.getText()), controller.nodeNetwork);
                    ParcelStandard parcel = Client.findParcelByName("192.168.0.108", 5000, Integer.parseInt( jtxtEnterParcelNo.getText()));
                    if(parcel != null){
                        jtxtDestinationName.setText(parcel.getAdress().getAdress());
                        jtxtReciverName.setText(parcel.getReceiverName());
                        jtxtWeight.setText(String.valueOf(parcel.getWeight()));

                    }



            } catch (Exception e1) {
                System.out.println("Ooops! Something went wrong");
            }

        }
    }

    class ListenToNewParcel implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            try {
                Node node = controller.nodeNetwork.getNode(jtxtDestinationName.getText());
                ParcelStandard parcel = new ParcelStandard(1, node, jtxtReciverName.getText(), Float.valueOf(jtxtWeight.getText()));
                //ParcelDAO.insert(parcel);
                Client.insertParcel("192.168.0.108", 5000, parcel);

            } catch (Exception e1) {
                System.out.println("Ooops! Something went wrong" + e1);
            }

        }
    }

    class ListenToEditParcel implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            try {

                Node node = controller.nodeNetwork.getNode(jtxtDestinationName.getText());
                ParcelStandard parcel = new ParcelStandard(Integer.parseInt(jtxtEnterParcelNo.getText()), node, jtxtReciverName.getText(), Float.valueOf(jtxtWeight.getText()));

                //ParcelDAO.edit(Integer.parseInt(jtxtEnterParcelNo.getText()),parcel);
                Client.editParcel("192.168.0.108", 5000, Integer.parseInt(jtxtEnterParcelNo.getText()),parcel);

            } catch (Exception e1) {
                System.out.println("Ooops! Something went wrong");
            }

        }
    }

    class ListenToDeleteParcel implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            try {

                //ParcelDAO.delete(Integer.parseInt(jtxtEnterParcelNo.getText()));
                Client.deleteParcel("192.168.0.108", 5000,Integer.parseInt(jtxtEnterParcelNo.getText()) );

            } catch (Exception e1) {
                System.out.println("Ooops! Something went wrong");
            }

        }
    }

    class ListenToAssignParcel implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            try {
                spParcelList.setVisible(false);
                searchPanel.setVisible(false);
                panelParcelToPostman.setVisible(true);
                panelSaveReports.setVisible(false);

            } catch (Exception e1) {
                System.out.println("Ooops! Something went wrong");
            }

        }
    }

    class ListenToActuallyAssignParcel implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            try {

                //ParcelDAO.assignToMailer(jtxtMailerNameAssign.getText(),Integer.parseInt(jtxtParcelNoForAssign.getText()));
                Client.requestAssignToMailer("192.168.0.108", 5000, jtxtMailerNameAssign.getText(),Integer.parseInt(jtxtParcelNoForAssign.getText()));

            } catch (Exception e1) {
                System.out.println("Ooops! Something went wrong"+ e1) ;
            }

        }
    }

    class ListenToSaveReports implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            try {

                spParcelList.setVisible(false);
                searchPanel.setVisible(false);
                panelParcelToPostman.setVisible(false);
                panelSaveReports.setVisible(true);
                jlbNodeNetwork.setVisible(false);
                jtxtOptimalRoute.setVisible(false);

            } catch (Exception e1) {
                System.out.println("Ooops! Something went wrong");
            }

        }
    }

    class ListenToActuallySaveReports implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            try {
                controller.saveReports(jtxtReportType.getSelectedItem().toString(), controller.nodeNetwork);
            } catch (Exception e1) {
                System.out.println("Ooops! Something went wrong");
            }

        }
    }

    class ListenToViewRoute implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            try {
                //model.getMailer().parcelsToDeliver = MailerDAO.viewParcelsForMailerAsParcels(model.getMailer().getName(),controller.nodeNetwork);

                if(model.getTypeOfUserLoggedIn().equals("Mailer")){

                    model.getMailer().parcelsToDeliver = Client.viewParcelsForMailerAsParcels("192.168.0.108", 5000, model.getMailer().getName());
                    String routeString = "";
                    for(Node node: controller.searchBestTrip(model.getMailer())){
                        routeString += node.getAdress();
                        routeString += " ";
                    }
                    jtxtOptimalRoute.setText(routeString);

                }
                spParcelList.setVisible(false);
                searchPanel.setVisible(false);
                panelParcelToPostman.setVisible(false);
                panelSaveReports.setVisible(false);
                jlbNodeNetwork.setVisible(true);
                jtxtOptimalRoute.setVisible(true);


            } catch (Exception e1) {
                System.out.println("Ooops! Something went wrong");
            }

        }
    }

    class ListenToViewMailers implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            try {
                panelForButtonsAdmin.setVisible(true);
                spActivityCoordinatorsList.setVisible(false);
                spMailerList.setVisible(true);

                mailersList.clear();

                mailersList = Client.requestAllMailers("192.168.0.108", 5000);

                //mailersList = MailerDAO.viewAllForTablePrint();
                jtMailersList.removeAll();
                jtMailersList = controller.createTable(mailersList);
                spMailerList.getViewport().setView(jtMailersList);
                spMailerList.revalidate();
                spMailerList.repaint();

            } catch (Exception e1) {
                System.out.println("Ooops! Something went wrong");
            }

        }
    }

    class ListenToViewActivityCoordinators implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            try {
                panelForButtonsAdmin.setVisible(true);
                spMailerList.setVisible(false);
                spActivityCoordinatorsList.setVisible(true);

                activityCoordinatorsList.clear();
                ActivityCoordinatorDAO act = new ActivityCoordinatorDAO();
                activityCoordinatorsList = Client.requestAllActivityCoordinators("192.168.0.108", 5000);

                //activityCoordinatorsList = act.viewAllForTablePrint();
                jtActivityCoordinatorsList.removeAll();
                jtActivityCoordinatorsList = controller.createTable(activityCoordinatorsList);
                spActivityCoordinatorsList.getViewport().setView(jtActivityCoordinatorsList);
                spActivityCoordinatorsList.revalidate();
                spActivityCoordinatorsList.repaint();

            } catch (Exception e1) {
                System.out.println("Ooops! Something went wrong" + e1);
            }

        }
    }

    class ListenToCreate implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            try {

                if(spMailerList.isVisible()){

                    Mailer newMailer = new Mailer(jtxtUsernameAdmin.getText(), jtxtPasswordAdmin.getText(), "Mailer", jtxtFullNameAdmin.getText(), jtxtEmailAdressAdmin.getText(),jtxtCNPAdmin.getText());
                    //MailerDAO.insertMailer(newMailer);
                    Client.insertMailer("192.168.0.108", 5000, newMailer);


                    mailersList.clear();
                    mailersList = MailerDAO.viewAllForTablePrint();
                    jtMailersList.removeAll();
                    jtMailersList = controller.createTable(mailersList);
                    spMailerList.getViewport().setView(jtMailersList);
                    spMailerList.revalidate();
                    spMailerList.repaint();

                }
                else if(spActivityCoordinatorsList.isVisible()){

                    ActivityCoordinator newAC = new ActivityCoordinator(jtxtUsernameAdmin.getText(), jtxtPasswordAdmin.getText(), "ActivityCoordinator", jtxtFullNameAdmin.getText(), jtxtEmailAdressAdmin.getText(),jtxtCNPAdmin.getText());

                    Client.insertActivityCoordinator("192.168.0.108", 5000, newAC);
                    //activityCoordinatorDAO.insertActivityCoordinator(newAC);

                    activityCoordinatorsList.clear();
                    activityCoordinatorsList = ActivityCoordinatorDAO.viewAllForTablePrint();
                    jtActivityCoordinatorsList.removeAll();
                    jtActivityCoordinatorsList = controller.createTable(activityCoordinatorsList);
                    spActivityCoordinatorsList.getViewport().setView(jtActivityCoordinatorsList);
                    spActivityCoordinatorsList.revalidate();
                    spActivityCoordinatorsList.repaint();

                }



            } catch (Exception e1) {
                System.out.println("Ooops! Something went wrong" + e1);
            }

        }
    }

    class ListenToDelete implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            try {

                if(spMailerList.isVisible()){


                    Client.deleteMailer("192.168.0.108", 5000, jtxtFullNameAdmin.getText());

                    mailersList.clear();
                    mailersList = MailerDAO.viewAllForTablePrint();
                    jtMailersList.removeAll();
                    jtMailersList = controller.createTable(mailersList);
                    spMailerList.getViewport().setView(jtMailersList);
                    spMailerList.revalidate();
                    spMailerList.repaint();

                }
                else if(spActivityCoordinatorsList.isVisible()){

                    Client.deleteActivityCoordinator("192.168.0.108", 5000, jtxtFullNameAdmin.getText());

                    activityCoordinatorsList.clear();
                    activityCoordinatorsList = ActivityCoordinatorDAO.viewAllForTablePrint();
                    jtActivityCoordinatorsList.removeAll();
                    jtActivityCoordinatorsList = controller.createTable(activityCoordinatorsList);
                    spActivityCoordinatorsList.getViewport().setView(jtActivityCoordinatorsList);
                    spActivityCoordinatorsList.revalidate();
                    spActivityCoordinatorsList.repaint();
                }

            } catch (Exception e1) {
                System.out.println("Ooops! Something went wrong" + e1);
            }

        }
    }

    class ListenToUpdate implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            try {

                if(spMailerList.isVisible()){

                    Mailer newMailer = new Mailer(jtxtUsernameAdmin.getText(), jtxtPasswordAdmin.getText(), "Mailer", jtxtFullNameAdmin.getText(), jtxtEmailAdressAdmin.getText(),jtxtCNPAdmin.getText());
                    Client.editMailer("192.168.0.108", 5000, newMailer);

                    mailersList.clear();
                    mailersList = MailerDAO.viewAllForTablePrint();//Client.requestAllMailers("192.168.0.108", 5000);
                    jtMailersList.removeAll();
                    jtMailersList = controller.createTable(mailersList);
                    spMailerList.getViewport().setView(jtMailersList);
                    spMailerList.revalidate();
                    spMailerList.repaint();

                }
                else if(spActivityCoordinatorsList.isVisible()){

                    ActivityCoordinator newAC = new ActivityCoordinator(jtxtUsernameAdmin.getText(), jtxtPasswordAdmin.getText(), "ActivityCoordinator", jtxtFullNameAdmin.getText(), jtxtEmailAdressAdmin.getText(),jtxtCNPAdmin.getText());

                    Client.editActivityCoordinator("192.168.0.108", 5000, newAC);
                    activityCoordinatorsList.clear();
                    activityCoordinatorsList = ActivityCoordinatorDAO.viewAllForTablePrint();
                    jtActivityCoordinatorsList.removeAll();
                    jtActivityCoordinatorsList = controller.createTable(activityCoordinatorsList);
                    spActivityCoordinatorsList.getViewport().setView(jtActivityCoordinatorsList);
                    spActivityCoordinatorsList.revalidate();
                    spActivityCoordinatorsList.repaint();

                }



            } catch (Exception e1) {
                System.out.println("Ooops! Something went wrong" + e1);
            }

        }
    }

}