package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import java.util.Vector;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import javafx.stage.Window;
import model.Bank;
import model.Staff;
import model.Transaction;
import util.Connect;

public class Main extends Application {
	
	Connect connect = Connect.getInstance();
	Connection connection = connect.getConnection();
	
	Scene sceneAddTR, sceneHome, sceneUpdateTR;
	private Stage window;
	private Scene sceneLogin;
	private BorderPane root;
	
	//Login
	private BorderPane rootLogin;
	private FlowPane fp2;
	private GridPane gp2;
	private Label title2;
	private TextField usernameTF2;
	private PasswordField passwordTF2;
	private Button loginButton2;

	
	// Home
	private BorderPane rootHome;
	private GridPane gridPane5;
	private Button addTRButton5, updateTRButton5;
	private Label titleLbl5;
	private Line verticalLine5;
	private VBox titleVB5;
	
	// AddTR
	private ArrayList<Integer> ALStaffId = new ArrayList<>();
	private ArrayList<Integer> ALBankId = new ArrayList<>();
	private Line horizontalLine1;
	private BorderPane rootAddTR,rootGridPane1;
	private Label titleLbl1, kategoriLbl1, pemasukanLbl1, pengeluaranlbl1, nominalLbl1, tanggalLbl1, staffidLbl1,
			keteranganLbl1;
	private Label namarektujuanLbl1, transaksikebankLbl1, norekbanktujuanLbl1,stripLbl1;
	private TextField nominalTF1, tanggalTF1, staffTF1, keteranganTF1;
	private TextField namarekTF1, transaksiTF1, norekTF1;
	private DatePicker dp1;

	private ToggleGroup kategoriGroup1;
	private GridPane gridPane1;
	private VBox kategoriVB1, nominalVB1, tanggalVB1, staffVB1, keteranganVB1;
	private VBox namarekVB1, transaksiVB1, norekVB1, titleVB1;

	private RadioButton pemasukanRadio1;
	private RadioButton pengeluaranRadio1;

	private Button addButton1, backButton1;

	// UpdateTR
	private BorderPane rootUpdateTR;
	private Line horizontalLine3;
	private Label titleLbl3, TransactionIDLbl3, stripLbl3, nominalLbl3, staffLbl3, tglLbl3, keteranganLbl3,
			pengirimLbl3, bankLbl3, norekLbl3;
	private GridPane gridPane3, rootgridPane3;
	private HBox TransactionIDhb3, enterButton3hb3;
	private VBox TitleUpdatevb3, nominalvb3, kategorivb3, staffvb3, tglvb3, keteranganvb3, pengirimvb3, bankvb3,
			norekvb3;
	private TextField transactionIDtf3, nominalTF3, staffTF3, tglTF3, keteranganTF3, pengirimTF3, bankTF3, norekTF3;
	private Button enterButton3, updateButton3, deleteButton3, clearButton3, backButton3;
	ToggleGroup kategoriGroup3;
	Label kategoriLbl3;
	RadioButton pemasukanRadio3, pengeluaranRadio3;
	DatePicker dp3;


	
	public static void main(String[] args) {
		launch(args);
	}

	private void home() {
		
		verticalLine5 = new Line(0, 0, 800, 0);
		addTRButton5 = new Button("Add Transaction");
		updateTRButton5 = new Button("Update Transaction");
		titleLbl5 = new Label("Home");
		titleLbl5.setFont(Font.font("Arial", FontWeight.BOLD, 40));
		rootHome.setAlignment(titleLbl5, Pos.TOP_CENTER);
		
		gridPane5 = new GridPane();
		gridPane5.add(addTRButton5, 0, 0);
		gridPane5.add(updateTRButton5, 1, 0);
		gridPane5.setAlignment(Pos.CENTER);
		gridPane5.setHgap(10);
		
		titleVB5= new VBox(titleLbl5, verticalLine5);
		titleVB5.setAlignment(Pos.CENTER);
		rootHome = new BorderPane();
		rootHome.setCenter(gridPane5);
		rootHome.setTop(titleVB5);
		//css
				String blueTheme = "-fx-background-color: #4e79a7; -fx-text-fill: white;";
				String textFieldStyle = "-fx-border-color: #092E67;";
				String buttonStyle = "-fx-font-size:20px;-fx-background-color: #092E67; -fx-text-fill: #FFE8C7;";
				String biruGelap = "-fx-text-fill: #092E67;";
				String krem= "-fx-text-fill: #FFE8C7;";
				String labelStyle = "-fx-text-fill: #092E67;";
		//style
		rootHome.setMargin(gridPane5, new Insets(10));
		gridPane5.setStyle("-fx-background-color: #E6EFF5;-fx-background-radius:10");
		rootHome.setStyle("-fx-background-color: #092E67;");
		titleLbl5.setStyle(krem);
		verticalLine5.setStyle("-fx-stroke: #FFE8C7");
		addTRButton5.setStyle(buttonStyle);
		updateTRButton5.setStyle(buttonStyle);
	}

	void updateTR() {
		titleLbl3 = new Label("Update Transaction");
		titleLbl3.setTextFill(Color.web("#FFE8C7"));
		titleLbl3.setFont(Font.font("Arial", FontWeight.BOLD, 40)); 
		TransactionIDLbl3 = new Label("Input Transaction ID");
		horizontalLine3 = new Line(0,0,800,0);
		stripLbl3 = new Label(
				"---------------------------------------------------------------------------------------------------------------------");
		stripLbl3.setTextFill(Color.web("#FFE8C7"));
		titleLbl3.setFont(Font.font("Arial", FontWeight.BOLD, 40)); 
		nominalLbl3 = new Label("Nominal");
		staffLbl3 = new Label("Staff");
		keteranganLbl3 = new Label("Keterangan");
		tglLbl3 = new Label("Tanggal Transaksi");
		pengirimLbl3 = new Label("Nama Rekening Pengirim");
		bankLbl3 = new Label("Transaksi dari Bank");
		norekLbl3 = new Label("No. Rekening Bank Asal");
		enterButton3 = new Button("Enter");
		enterButton3.setBackground(new Background(new BackgroundFill(Color.web("#F5EBD9"), null, null)));
		updateButton3 = new Button("Update");
		deleteButton3 = new Button("Delete");
		clearButton3 = new Button("Clear");
		backButton3 = new Button("Back");
		kategoriLbl3 = new Label("Kategori");
		kategoriGroup3 = new ToggleGroup();

		dp3 = new DatePicker();

		pemasukanRadio3 = new RadioButton("Pemasukan");
		pengeluaranRadio3 = new RadioButton("Pengeluaran");

		transactionIDtf3 = new TextField();
		transactionIDtf3.setMaxWidth(250);
		nominalTF3 = new TextField();
		nominalTF3.setMaxWidth(150);
		staffTF3 = new TextField();
		staffTF3.setMaxWidth(150);
		tglTF3 = new TextField();
		tglTF3.setMaxWidth(150);
		keteranganTF3 = new TextField();
		keteranganTF3.setMaxWidth(150);
		pengirimTF3 = new TextField();
		pengirimTF3.setMaxWidth(150);
		bankTF3 = new TextField();
		bankTF3.setMaxWidth(150);
		norekTF3 = new TextField();
		norekTF3.setMaxWidth(150);

		pemasukanRadio3.setToggleGroup(kategoriGroup3);
		pengeluaranRadio3.setToggleGroup(kategoriGroup3);

		TitleUpdatevb3 = new VBox(titleLbl3, horizontalLine3);
		TitleUpdatevb3.setAlignment(Pos.TOP_CENTER);

		kategorivb3 = new VBox(kategoriLbl3, pemasukanRadio3, pengeluaranRadio3);
		kategorivb3.setSpacing(2);

		TransactionIDhb3 = new HBox(TransactionIDLbl3, transactionIDtf3, enterButton3);
		TransactionIDhb3.setSpacing(10);

		enterButton3hb3 = new HBox(updateButton3, deleteButton3, clearButton3, backButton3);
		enterButton3hb3.setSpacing(10);

		nominalvb3 = new VBox(nominalLbl3, nominalTF3);
		staffvb3 = new VBox(staffLbl3, staffTF3);
		tglvb3 = new VBox(tglLbl3, dp3);
		keteranganvb3 = new VBox(keteranganLbl3, keteranganTF3);
		pengirimvb3 = new VBox(pengirimLbl3, pengirimTF3);
		bankvb3 = new VBox(bankLbl3, bankTF3);
		norekvb3 = new VBox(norekLbl3, norekTF3);

		gridPane3 = new GridPane();
//		gridPane3.add(TransactionIDhb3, 0, 0);
		gridPane3.add(kategorivb3, 1, 1);
		gridPane3.add(nominalvb3, 1, 2);
		gridPane3.add(staffvb3, 2, 2);
		gridPane3.add(tglvb3, 1, 3);
		gridPane3.add(keteranganvb3, 2, 3);
		gridPane3.add(pengirimvb3, 3, 1);
		gridPane3.add(bankvb3, 3, 2);
		gridPane3.add(norekvb3, 3, 3);
		gridPane3.setAlignment(Pos.TOP_CENTER);
//		gridPane3.add(enterButton3hb3, 0, 5);

		gridPane3.setVgap(10);
		gridPane3.setHgap(50);

		rootgridPane3 = new GridPane();
		rootgridPane3.add(TransactionIDhb3, 0, 0);
		rootgridPane3.add(gridPane3, 0, 1);
		rootgridPane3.add(enterButton3hb3, 0, 2);
		rootgridPane3.setVgap(10);
		
		rootgridPane3.setBackground(new Background(new BackgroundFill(Color.web("#E6EFF5"), new CornerRadii(10), null)));
		
//		Background lightBlueBackground4 = new Background(new BackgroundFill(Color.DARKBLUE, null, null));
//		rootUpdateTR.setBackground(lightBlueBackground4);
//		Background lightBlueBackground3 = new Background(new BackgroundFill(Color.LIGHTBLUE, new CornerRadii(10), null));
//		 rootgridPane3.setBackground(lightBlueBackground3);
		
		 

		rootgridPane3.setAlignment(Pos.TOP_CENTER);
		rootUpdateTR.setAlignment(rootgridPane3, Pos.CENTER);
		rootUpdateTR = new BorderPane();
		rootUpdateTR.setTop(TitleUpdatevb3);
		rootUpdateTR.setCenter(rootgridPane3);
		rootUpdateTR.setMargin(rootgridPane3, new Insets(10));

		rootUpdateTR.setBackground(new Background(new BackgroundFill(Color.web("#092E67"), null, null)));
		
		
		//css
				String textFieldStyle = "-fx-border-color: #092E67;";
				String buttonStyle = "-fx-background-color: #092E67; -fx-text-fill: #FFE8C7;-fx-font-size:15;";
				String biruGelap = "-fx-text-fill: #092E67;";
				String krem= "-fx-text-fill: #FFE8C7;";
				String labelStyle = "-fx-text-fill: #092E67;";
				
				//style
				titleLbl3.setFont(Font.font("Arial", FontWeight.BOLD, 40));
				rootUpdateTR.setStyle("-fx-background-color: #092E67;");
				
				gridPane3.setStyle("-fx-background-color: #E6EFF5;-fx-background-radius: 10;");
				
				titleLbl3.setStyle(krem);
				horizontalLine3.setStyle("-fx-stroke: #FFE8C7;");
				kategoriLbl3.setStyle(labelStyle);
				nominalLbl3.setStyle(labelStyle);
				tglLbl3.setStyle(labelStyle);
				staffLbl3.setStyle(labelStyle);
				keteranganLbl3.setStyle(labelStyle);
				norekLbl3.setStyle(labelStyle);
				bankLbl3.setStyle(labelStyle);
				pengirimLbl3.setStyle(labelStyle);
				
				nominalTF3.setStyle(textFieldStyle);
				staffTF3.setStyle(textFieldStyle);
				keteranganTF3.setStyle(textFieldStyle);
				bankTF3.setStyle(textFieldStyle);
				pengirimTF3.setStyle(textFieldStyle);
				norekTF3.setStyle(textFieldStyle);

				pemasukanRadio3.setStyle(biruGelap);
				pengeluaranRadio3.setStyle(biruGelap);
				
				dp3.setStyle(textFieldStyle);
				
				clearButton3.setStyle(buttonStyle);
				backButton3.setStyle(buttonStyle);
				updateButton3.setStyle(buttonStyle);
				deleteButton3.setStyle(buttonStyle);
				
				//style non css
				nominalTF3.setPrefSize(200, 10);
				staffTF3.setPrefSize(200, 10);
				keteranganTF3.setPrefSize(200, 10);
				norekTF3.setPrefSize(200, 10);
				pengirimTF3.setPrefSize(200, 10);
				bankTF3.setPrefSize(200, 10);
				dp3.setPrefSize(200, 10);
	}

	void addTR() {
		//inisiasi
		titleLbl1 = new Label("Input Transaction");
		horizontalLine1 = new Line(0,0,800,0);
		kategoriLbl1 = new Label("Kategori");
		nominalLbl1 = new Label("Nominal");
		tanggalLbl1 = new Label("Tanggal");
		staffidLbl1 = new Label("Staff ID");
		keteranganLbl1 = new Label("Keterangan");
		namarektujuanLbl1 = new Label("Nama Rekening Tujuan");
		transaksikebankLbl1 = new Label("Transaksi ke Bank");
		norekbanktujuanLbl1 = new Label("No. Rekening Bank Tujuan");

		nominalTF1 = new TextField();
		nominalTF1.setPromptText("input nominal");
		tanggalTF1 = new TextField();
		staffTF1 = new TextField();
		staffTF1.setPromptText("input staff id");
		keteranganTF1 = new TextField();
		keteranganTF1.setPromptText("input keterangan");
		namarekTF1 = new TextField();
		namarekTF1.setPromptText("input nama rekening tujuan");
		transaksiTF1 = new TextField();
		transaksiTF1.setPromptText("input transaksi ke bank");
		norekTF1 = new TextField();
		norekTF1.setPromptText("input no. rek. bank tujuan");
		dp1 = new DatePicker();
		dp1.setPromptText("pilih tanggal transaksi");
		kategoriGroup1 = new ToggleGroup();

		pemasukanRadio1 = new RadioButton("Pemasukan");
		pengeluaranRadio1 = new RadioButton("Pengeluaran");

		pemasukanRadio1.setToggleGroup(kategoriGroup1);
		pengeluaranRadio1.setToggleGroup(kategoriGroup1);
		
		titleVB1 = new VBox(titleLbl1,horizontalLine1);
		kategoriVB1 = new VBox(kategoriLbl1, pemasukanRadio1, pengeluaranRadio1);
		kategoriVB1.setSpacing(2);
		nominalVB1 = new VBox(nominalLbl1, nominalTF1);
		tanggalVB1 = new VBox(tanggalLbl1, dp1);
		staffVB1 = new VBox(staffidLbl1, staffTF1);
		keteranganVB1 = new VBox(keteranganLbl1, keteranganTF1);
		namarekVB1 = new VBox(namarektujuanLbl1, namarekTF1);
		transaksiVB1 = new VBox(transaksikebankLbl1, transaksiTF1);
		norekVB1 = new VBox(norekbanktujuanLbl1, norekTF1);

		addButton1 = new Button("Add");
		backButton1 = new Button("Back");
		
		gridPane1 = new GridPane();
		gridPane1.add(kategoriVB1, 0, 0);
		gridPane1.add(nominalVB1, 0, 1);
		gridPane1.add(tanggalVB1, 0, 2);
		gridPane1.add(staffVB1, 0, 3);
		gridPane1.add(keteranganVB1, 0, 4);
		gridPane1.add(namarekVB1, 1, 1);
		gridPane1.add(transaksiVB1, 1, 2);
		gridPane1.add(norekVB1, 1, 3);
		gridPane1.setAlignment(Pos.TOP_CENTER);
		gridPane1.add(addButton1, 0, 5);
		gridPane1.add(backButton1, 1, 5);

		gridPane1.setVgap(10);
		gridPane1.setHgap(50);
	
		//layout
		gridPane1.setPadding(new Insets(10));
		GridPane.setHalignment(addButton1, HPos.CENTER);
		GridPane.setHalignment(backButton1, HPos.CENTER);
		
//		rootGridPane1.setMargin(gridPane1, new Insets(100));
//		rootGridPane1= new BorderPane();
//		rootGridPane1.setCenter(gridPane1);
		
		rootAddTR = new BorderPane();
		rootAddTR.setTop(titleVB1);
		rootAddTR.setCenter(gridPane1);
		root.setMargin(gridPane1, new Insets(10));
//		rootAddTR.setCenter(rootGridPane1);
		titleVB1.setAlignment(Pos.CENTER);
		
		//css
		String textFieldStyle = "-fx-border-color: #092E67;";
		String buttonStyle = "-fx-background-color: #092E67; -fx-text-fill: #FFE8C7;-fx-font-size:15;";
		String biruGelap = "-fx-text-fill: #092E67;";
		String krem= "-fx-text-fill: #FFE8C7;";
		String labelStyle = "-fx-text-fill: #092E67;";
		
		//style
		titleLbl1.setFont(Font.font("Arial", FontWeight.BOLD, 40));
		rootAddTR.setStyle("-fx-background-color: #092E67;");
		
		gridPane1.setStyle("-fx-background-color: #E6EFF5;-fx-background-radius: 10;");
		
		titleLbl1.setStyle(krem);
		horizontalLine1.setStyle("-fx-stroke: #FFE8C7;");
		kategoriLbl1.setStyle(labelStyle);
		nominalLbl1.setStyle(labelStyle);
		tanggalLbl1.setStyle(labelStyle);
		staffidLbl1.setStyle(labelStyle);
		keteranganLbl1.setStyle(labelStyle);
		namarektujuanLbl1.setStyle(labelStyle);
		transaksikebankLbl1.setStyle(labelStyle);
		norekbanktujuanLbl1.setStyle(labelStyle);
		
		nominalTF1.setStyle(textFieldStyle);
		staffTF1.setStyle(textFieldStyle);
		keteranganTF1.setStyle(textFieldStyle);
		namarekTF1.setStyle(textFieldStyle);
		transaksiTF1.setStyle(textFieldStyle);
		norekTF1.setStyle(textFieldStyle);

		pemasukanRadio1.setStyle(biruGelap);
		pengeluaranRadio1.setStyle(biruGelap);
		
		dp1.setStyle(textFieldStyle);
		
		addButton1.setStyle(buttonStyle);
		backButton1.setStyle(buttonStyle);
		
		//style non css
		nominalTF1.setPrefSize(200, 10);
		staffTF1.setPrefSize(200, 10);
		keteranganTF1.setPrefSize(200, 10);
		namarekTF1.setPrefSize(200, 10);
		transaksiTF1.setPrefSize(200, 10);
		norekTF1.setPrefSize(200, 10);
		dp1.setPrefSize(200, 10);
	}
	void login() {
		rootLogin = new BorderPane();
		fp2 = new FlowPane();
		gp2 = new GridPane();
		title2 = new Label("SIGN IN");
		usernameTF2 = new TextField();
		usernameTF2.setPromptText("Username");
		passwordTF2 = new PasswordField();
		passwordTF2.setPromptText("Password");
		loginButton2 = new Button("Login");
		
		Background lightBlueBackground = new Background(new BackgroundFill((Color.web("#092E67")), null, null));
		rootLogin.setBackground(lightBlueBackground);
		 
		 
		 title2.setFont(Font.font("Arial", FontWeight.BOLD, 38));
		 title2.setTextFill(Color.web("#FFE8C7"));
		 rootLogin.setTop(title2);
		 rootLogin.setBottom(loginButton2);
		 rootLogin.setCenter(gp2);
		 fp2.setMaxWidth(Double.MAX_VALUE);
		 fp2.setAlignment(Pos.CENTER);
		 
		 usernameTF2.setFont(Font.font("Arial", 15));
		 passwordTF2.setFont(Font.font("Arial", 15));
		 gp2.add(fp2, 1, 0);
		 fp2.setHgap(10);
		 gp2.setHgap(10);
		 gp2.setVgap(20);
		 gp2.add(title2, 1, 0);
		 gp2.add(usernameTF2, 1, 1);
		 gp2.add(passwordTF2, 1, 2);
		 gp2.add(loginButton2, 1, 3);
		 gp2.setPadding(new Insets(90));
		 gp2.setAlignment(Pos.CENTER);
		 rootLogin.setCenter(gp2);
		 GridPane.setHalignment(gp2, HPos.CENTER);
		 rootLogin.setPadding(new Insets(10));
		 loginButton2.setPadding(new Insets(10, 40, 10, 40));
		 loginButton2.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		 title2.setPadding(new Insets(0,0,0,130));
		 Insets buttonMargin = new Insets(0,0,0,130);
		 GridPane.setMargin(loginButton2, buttonMargin);
		 loginButton2.setStyle("-fx-background-color: #FFE8C7;");
		 loginButton2.setTextFill(Color.web("#092E67"));
		}
	void eventAction() {
		//login
		loginButton2.setOnAction(event -> {
            String username = usernameTF2.getText();
            String password = passwordTF2.getText();

            Connect connect = Connect.getInstance();
            Connection connection = connect.getConnection();

            try {
                String query = "SELECT * FROM staff WHERE Username = ? AND Password = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);

                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    int id = resultSet.getInt("ID");

                    Staff staff = new Staff(id, username, password);

                    System.out.println("Login successful");
                    System.out.println(staff.getId());
                    System.out.println(staff.getUsername());
                    System.out.println(staff.getPassword());
                    // root.setCenter(rootHome);
                    window.setScene(sceneHome);
                    window.setTitle("Finance Buddy - Home");
                } else {
                    System.out.println("Invalid username or password");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        });
		
		// add TR
		addButton1.setOnAction(event -> {
			
			try {
				ArrayList<TextField> ALTF = new ArrayList<>();
				ALTF.add(keteranganTF1);
				ALTF.add(namarekTF1);
				ALTF.add(nominalTF1);
				ALTF.add(norekTF1);
				ALTF.add(staffTF1);
				ALTF.add(transaksiTF1);
				
				if(Integer.parseInt(nominalTF1.getText())<=0) {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setHeaderText("Nominal must be >0");
					alert.showAndWait();
					return;
				}
				try {
					Integer.parseInt(norekTF1.getText());
				} catch (Exception e) {
					Alert a = new Alert(AlertType.ERROR);
					a.setContentText("Account Number must be integer");
					a.show();
					return;
				}
				if(!validationTF(ALTF,dp1,kategoriGroup1)) {
//					Alert alert = new Alert(AlertType.ERROR);
//					alert.setHeaderText("All TextField must be not blank");
//					alert.showAndWait();
				}
				else {
					boolean staffValid=false;
					//validation staff id
					getStaffData();
					Integer staffid = Integer.parseInt(staffTF1.getText());
					
					for (Integer i : ALStaffId) {
						if(staffid == i){
							staffValid= true;
							System.out.println("Staff ID Valid");
							break;
						}
					}
					if(!staffValid) {
						Alert alert = new Alert(AlertType.ERROR);
						alert.setHeaderText("Staff Id tidak valid");
						alert.showAndWait();
						return;
					}
					//validasi norek
					boolean norekExist=false;
					getBankData();
					Integer bankid = Integer.parseInt(norekTF1.getText());
					for (Integer i : ALBankId) {
						if(i==bankid) {
							System.out.println("Bank Id telah terdaftar");
							norekExist=true;
							break;
						}
					}
					try {
						Connect connect = Connect.getInstance();
						Connection connection = connect.getConnection();
						String category = ((RadioButton) kategoriGroup1.getSelectedToggle()).getText(); ;
						String nominal = nominalTF1.getText() ;
						String tanggal = dp1.getValue().toString() ;
						String staff = staffTF1.getText() ;
						String keterangan = keteranganTF1.getText();
						String namarek = namarekTF1.getText();
						String transaksi = transaksiTF1.getText() ;
						String norek = norekTF1.getText();
						if(!norekExist) {
							String queryAddAccount=" INSERT INTO bank VALUES"
									+ "("+norek+",'"+namarek+"','"+transaksi+"')";
							boolean addAccountSuccess = connect.execUpdate(queryAddAccount);
							if(addAccountSuccess) {
								Alert alert = new Alert(AlertType.INFORMATION);
								alert.setTitle("Information");
								alert.setHeaderText(null);
								alert.setContentText("new bank Account Added");
								alert.showAndWait();
							}
						}
						String queryAddTrans="INSERT INTO `trans` (`TransID`, `Category`, `Description`, `TransDate`, `Amount`, `id`, `AccountNumber`) VALUES"
								+ "(NULL,'" + category+"','" +keterangan+"','"+tanggal+"','"+nominal+"',"
								+staff+",'"+norek+"')";
//						String query=  "INSERT INTO trans VALUES "
//								 +"(NULL, 'Pemasukan', '123', '2023-11-01', "
//								 + "'2', '222', '2');";
//						System.out.println(queryAddAccount);
//						System.out.println(queryAddTrans);
						boolean addTransSuccess =connect.execUpdate(queryAddTrans);
						if(addTransSuccess) {
							System.out.println("Transaction  Added");
							Alert alert = new Alert(AlertType.INFORMATION);
							alert.setTitle("Information");
							alert.setHeaderText(null);
							alert.setContentText("Transaction Added");
							alert.showAndWait();
						}
						else {
							Alert alert = new Alert(AlertType.ERROR);
							alert.setTitle("Error");
							alert.setHeaderText("Fail to add transaction");
							alert.setContentText("Please make sure all data format is true");
							alert.showAndWait();
						}
					} catch (Exception e2) {
						System.out.println("Fail with exception"+e2);
						Alert alert = new Alert(AlertType.ERROR);
						alert.setTitle("Error");
						alert.setHeaderText("Fail to add transaction");
						alert.setContentText("Please make sure all data format is true");
						alert.showAndWait();
					}
				}
				ALTF.clear();
				
				
				
				
			
			} catch (Exception e2) {
				Alert a = new Alert(AlertType.ERROR);
				a.setContentText("Pastikan format data benar");
				a.showAndWait();
			}
		});

		backButton1.setOnAction(event -> {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setHeaderText("Are you sure wanna go back?");
			Optional<ButtonType> resultAlert = alert.showAndWait();
			if(resultAlert.get() == ButtonType.CANCEL) {
				event.consume();
			}else {
				System.out.println("Back to home");
//				root.setCenter(rootHome);
				window.setScene(sceneHome);
				window.setTitle("Finance Buddy - Home");
			}
		});

		// updateTR
		ArrayList<Transaction> ALTrans = new ArrayList<>();
//		ArrayList<Bank> ALBank = new ArrayList<>();
		
		enterButton3.setOnAction(e-> {
			try {
				Integer.parseInt(transactionIDtf3.getText());
			} catch (Exception e2) {
				Alert a = new Alert(AlertType.ERROR);
				a.setContentText("Must be integer");
				a.showAndWait();
				return;
			}
			
			
			String query = "SELECT * \r\n" + 
					"FROM Trans, Bank \r\n" + 
					"WHERE Trans.TransID ="+ transactionIDtf3.getText()
					+ " AND Trans.AccountNumber = Bank.AccountNumber;" ;
			System.out.println(query);
			Connect connect = Connect.getInstance();
			Connection connection = connect.getConnection();
			connect.execQuery(query);
			try {
	            while(connect.rs.next()) {
	                int TransID  = connect.rs.getInt("TransID");
	                int Amount = connect.rs.getInt("Amount");
	                int id = connect.rs.getInt("id");
	                String Category = connect.rs.getString("Category");
	                String Description = connect.rs.getString("Description");
	                String AccountNumber = connect.rs.getString("AccountNumber");
	                String TransDate = connect.rs.getString("TransDate");
	                String Bank = connect.rs.getString("BankName");
	                String AccountName = connect.rs.getString("AccountName");
	                ALTrans.add(new Transaction(TransID, Amount, id, Category, Description, AccountNumber, TransDate, Bank, AccountName));
	                
	          
//	                String Bank = connect.rs.getString("BankName");
//	                String AccountName = connect.rs.getString("AccountName");
//	                ALBank.add(new Bank(AccountNumber, Bank, AccountName));
//	                System.out.println("Trans ID = " +TransID);
//	                System.out.println("Bank = "+Bank);
	            }
	        } catch (SQLException s) {
	            System.out.println("GetTransaction Fail");
	        }
//			System.out.println("size: "+ALTrans.size());
//			for (Transaction transaction : ALTrans) {
//				System.out.println(transaction.getAccountName());
//				System.out.println(transaction.getAccountNumber());
//				System.out.println(transaction.getAmount());
//				System.out.println(transaction.getBank());
//				System.out.println(transaction.getCategory());
//				System.out.println(transaction.getDescription());
//				System.out.println(transaction.getId());
//				System.out.println(transaction.getTransDate());
//				System.out.println(transaction.getTransID());
//			}System.out.println("tes");
			
			
			int inputtedTransId = Integer.parseInt(transactionIDtf3.getText());
			boolean dataFound = false;
			Transaction existingTransaction = new Transaction();
			for (Transaction transaction : ALTrans) {
				if (inputtedTransId==transaction.getTransID()) {
					dataFound = true;
					existingTransaction = transaction;
				}
			}
			if(dataFound==false) {
				System.out.println("Not Found");
				//tambahin alert not found
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information");
				alert.setHeaderText(null);
				alert.setContentText("Data not found!");
				alert.showAndWait();
				return;
			}
			else {
				//set text semua komponen
				nominalTF3.setText(Integer.toString(existingTransaction.getAmount()));
				dp3.setValue(LocalDate.parse(existingTransaction.getTransDate()));
				keteranganTF3.setText(existingTransaction.getDescription());
				staffTF3.setText(Integer.toString(existingTransaction.getId()));
				norekTF3.setText(existingTransaction.getAccountNumber());
				bankTF3.setText(existingTransaction.getBank());
				pengirimTF3.setText(existingTransaction.getAccountName());
				if (existingTransaction.getCategory().equals("Pemasukan")) {
					kategoriGroup3.selectToggle(pemasukanRadio3);
				}else if(existingTransaction.getCategory().equals("Pengeluaran")) {
					kategoriGroup3.selectToggle(pengeluaranRadio3);
				}
			}
		});
		
		clearButton3.setOnAction(event -> {
            nominalTF3.setText(null);
            transactionIDtf3.setText(null);
            staffTF3.setText(null);
            keteranganTF3.setText(null);
            pengirimTF3.setText(null);
            bankTF3.setText(null);
            norekTF3.setText(null);
            dp3.setValue(null);
            kategoriGroup3.selectToggle(null);;

        });
		updateButton3.setOnAction(event -> {
			try {
					
				
			int inputtedTransId = Integer.parseInt(transactionIDtf3.getText());
		    int updatedAmount = Integer.parseInt(nominalTF3.getText());
		    String updatedTransDate = dp3.getValue().toString();
		    String updatedDescription = keteranganTF3.getText();
		    String updatedCategory = ((RadioButton) kategoriGroup3.getSelectedToggle()).getText();
		    int updatedId = Integer.parseInt(staffTF3.getText());
		    String updatedAccountNumber = norekTF3.getText();
		    String updatedBank = bankTF3.getText();
		    String updatedAccountName = pengirimTF3.getText();
		    if(updatedAmount<=0) {
		    	Alert a = new Alert(AlertType.ERROR);
		    	a.setContentText("Amount must be >0");
		    	a.showAndWait();
		    	return;
		    }
		    if(updatedTransDate.isBlank()
		    	||updatedDescription.isBlank()||updatedCategory.isBlank()||updatedAccountNumber.isBlank()||updatedBank.isBlank()||updatedAccountName.isBlank()) {
		    	Alert a = new Alert(AlertType.ERROR);
		    	a.setContentText("Pastikan semua data tidak kosong");
		    	a.showAndWait();
		    	return;
		    }
		    Transaction existingTransaction = new Transaction();
			boolean dataFound = false;
			for (Transaction transaction : ALTrans) {
				if (inputtedTransId==transaction.getTransID()) {
					dataFound = true;
					existingTransaction = transaction;
				}
			}
			
			getStaffData();
			boolean idValid=false;
			for (int s : ALStaffId) {
				if(updatedId==s) {
					idValid=true;
				}
			}
			if(!idValid) {
				Alert a = new Alert(AlertType.ERROR);
				a.setContentText("Staff id tidak valid");
				a.show();
				return;
			}
			String accNumber = norekTF3.getText() ;
				try {
					Integer.parseInt(accNumber);
				} catch (Exception e) {
					Alert a = new Alert(AlertType.ERROR);
					a.setContentText("Account Number must be integer");
					a.show();
					return;
				}
		    
		    	String updateQuery = String.format(
			    		"UPDATE trans\n"
			    		+ "SET Category = '%s', Description = '%s', TransDate = '%s', Amount = %s, id = %s\n"
//			    		+ "AccountNumber='%s'"
			    		+ "WHERE TransID = %s", updatedCategory, updatedDescription, updatedTransDate, updatedAmount, updatedId,
//			    		updatedAccountNumber, 
			    		inputtedTransId);
			    String updateQuery2 = String.format(
			    		"UPDATE bank\n"
			    		+ "SET AccountNumber = '%s', AccountName ='%s', BankName = '%s'\n"
			    		+ "WHERE AccountNumber = '%s'", updatedAccountNumber, updatedAccountName, updatedBank, existingTransaction.getAccountNumber());

			    Connect connect = Connect.getInstance();
			    Connection connection = connect.getConnection();
			    connect.execUpdate(updateQuery2);
			    connect.execUpdate(updateQuery);

			    boolean updateTransSuccess = connect.execUpdate(updateQuery);
			    boolean updateBankSuccess = connect.execUpdate(updateQuery2);
			    if (updateTransSuccess) {
			    	  nominalTF3.setText(null);
			            transactionIDtf3.setText(null);
			            staffTF3.setText(null);
			            keteranganTF3.setText(null);
			            norekTF3.setText(null);
			            dp3.setValue(null);
			            kategoriGroup3.selectToggle(null);;
			            pengirimTF3.setText(null);
			            bankTF3.setText(null);
			    	System.out.println("Data updated successfully!");
					System.out.println("Transaction  updated");		
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information");
					alert.setHeaderText(null);
					alert.setContentText("Transaction data updated");
					alert.showAndWait();

				} 
			    else if (updateBankSuccess) {
					System.out.println("Data updated successfully!");
					System.out.println("Transaction  updated");		
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information");
					alert.setHeaderText(null);
					alert.setContentText("Bank data updated");
					alert.showAndWait();

				}
			    else {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error");
					alert.setHeaderText("Fail to update transaction");
					alert.setContentText("Please make sure all data format is true");
					alert.showAndWait();
				}
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Fail with exception"+e);
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText("Fail to update transaction");
				alert.setContentText("Please make sure all data format is true");
				alert.showAndWait();
			}

		    
		});
		deleteButton3.setOnAction(event -> {
			try {
				int inputtedTransId = Integer.parseInt(transactionIDtf3.getText());
				String deleteQuery = String.format("DELETE FROM trans\n"
						+ "WHERE TransID = %s", inputtedTransId);
				
				 Connect connect = Connect.getInstance();
				    Connection connection = connect.getConnection();
				    connect.execUpdate(deleteQuery);
				    
				boolean deleteTransSuccess = connect.execUpdate(deleteQuery);
				if (deleteTransSuccess) {
					nominalTF3.setText(null);
		            transactionIDtf3.setText(null);
		            staffTF3.setText(null);
		            keteranganTF3.setText(null);
		            norekTF3.setText(null);
		            dp3.setValue(null);
		            kategoriGroup3.selectToggle(null);;
		            pengirimTF3.setText(null);
		            bankTF3.setText(null);
		            
					System.out.println("Transaction  deleted");
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information");
					alert.setHeaderText(null);
					alert.setContentText("Transaction deleted");
					alert.showAndWait();
				}else {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error");
					alert.setHeaderText("Fail to delete transaction");
					alert.setContentText("");
					alert.showAndWait();
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Fail with exception"+e);
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText("Fail to delete transaction");
				alert.setContentText("Please make sure all data format is true");
				alert.showAndWait();
			}
			ALTrans.clear();
		});
		
		
		
		backButton3.setOnAction(event -> {
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setHeaderText("Are you sure wanna go back?");
			Optional<ButtonType> resultAlert = alert.showAndWait();
			if(resultAlert.get() == ButtonType.CANCEL) {
				event.consume();
			}else {
				  nominalTF3.setText(null);
		            transactionIDtf3.setText(null);
		            staffTF3.setText(null);
		            keteranganTF3.setText(null);
		            pengirimTF3.setText(null);
		            bankTF3.setText(null);
		            norekTF3.setText(null);
		            dp3.setValue(null);
		            kategoriGroup3.selectToggle(null);;
				System.out.println("Back to home");
//				root.setCenter(rootHome);
				window.setScene(sceneHome);
				window.setTitle("Finance Buddy - Home");
			}
		});

		// Home
		addTRButton5.setOnAction(event -> {
			System.out.println("Go to Add Transaction");
			window.setScene(sceneAddTR);
//			root.setCenter(rootAddTR);
			window.setTitle("Finance Buddy - Add transaction");
			keteranganTF1.setText(null);
			namarekTF1.setText(null);
			nominalTF1.setText(null);
			norekTF1.setText(null);
			staffTF1.setText(null);
			transaksiTF1.setText(null);
			kategoriGroup1.selectToggle(null);
			dp1.setValue(null);
		});

		updateTRButton5.setOnAction(e -> {
			System.out.println("Go to Update Transaction");
			window.setScene(sceneUpdateTR);
//			root.setCenter(rootUpdateTR);
			window.setTitle("Finance Buddy - Update Transaction");
		});

	}
	public void getStaffData() {
		ALStaffId.clear();
		
		String query = "SELECT id FROM staff";
		connect.rs = connect.execQuery(query);
		try {
			while(connect.rs.next()) {
				Integer id = connect.rs.getInt("id");
				ALStaffId.add(id);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void getBankData() {
		ALBankId.clear();
		String query = "SELECT AccountNumber FROM bank";
		connect.rs = connect.execQuery(query);
		try {
			while(connect.rs.next()) {
				Integer id = connect.rs.getInt("AccountNumber");
				ALBankId.add(id);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	private boolean validationTF(ArrayList<TextField> AL,DatePicker dp,ToggleGroup tg) {
		String name="Tolong ";
		boolean valid=true;
		for (TextField t : AL) {
			if(t.getText().isBlank()) {
				valid=false;
				name= name+t.getPromptText()+", ";
			}
		}
		if(dp.getValue() == null) {
			name= name+dp.getPromptText()+", ";
			valid=false;
		}
		if(tg.getSelectedToggle() == null) {
			name= name+" pilih kategori, ";
			valid=false;
		}
		if(!valid) {
			Alert alert = new Alert(AlertType.ERROR);
//			name= name.format("%s", name);
			alert.setHeaderText("Semua field tidak boleh kosong");
			name= name.substring(0, name.length()-2);
			alert.setContentText(name+" !");
			alert.showAndWait();
		}
		
		return valid;
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
//		root = new BorderPane();
		
		window = primaryStage;
		login();
		home();
		addTR();
		updateTR();
		eventAction();
		Background lightBlueBackground = new Background(new BackgroundFill(Color.LIGHTBLUE, null, null));
		
//		root.setCenter(rootLogin);
		

		sceneAddTR = new Scene(rootAddTR,800,600);
		sceneHome = new Scene(rootHome,800,600);
		sceneUpdateTR = new Scene(rootUpdateTR,800,600);
		sceneLogin = new Scene(rootLogin , 800, 600);
		
		primaryStage.setScene(sceneLogin);
		window.show();
		window.setTitle("Finance Buddy - Login");
		
	}
	

}