package fxfinalq2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.collections.*;
/**
 *
 * @author NorhanNasr
 */
public class FXFinalQ2 extends Application {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet res = null;
    ObservableList<Employee> data;
    TableView<Employee> table;
    int size;

    @Override
    public void start(Stage primaryStage) {
        
        Button Search =new Button("Search");
        Label serachlbl = new Label("Search for employee by ID");
        TextField searchtext = new TextField();
        
        GridPane searchpane = new GridPane();
        searchpane.add(serachlbl , 0,0);
        searchpane.add(searchtext , 1,0);
        searchpane.add(Search , 2,0);
        
        HBox searchbox = new HBox(searchpane);
        searchbox.setPadding(new Insets(20));

        Button btn1 = new Button();
        btn1.setText("Add");

        Button btn2 = new Button();
        btn2.setText("Clear");

        Text txt1 = new Text("Add New Student");

        Label l1 = new Label("ID");
        Label l2 = new Label("Name");
        Label l3 = new Label("Job");
        Label l4 = new Label("Salary");

        TextField t1 = new TextField();
        TextField t2 = new TextField();
        TextField t3 = new TextField();
        TextField t4 = new TextField();

        GridPane g1 = new GridPane();
        g1.add(txt1, 0, 0, 2, 1);
        g1.add(l1, 0, 1);
        g1.add(t1, 1, 1);
        g1.add(l2, 0, 2);
        g1.add(t2, 1, 2);
        g1.add(l3, 0, 3);
        g1.add(t3, 1, 3);
        g1.add(l4, 0, 4);
        g1.add(t4, 1, 4);

        g1.add(btn1, 0, 6);
        g1.add(btn2, 1, 6);

        g1.setVgap(10);
        g1.setHgap(10);
        g1.setAlignment(Pos.CENTER);
        g1.setPadding(new Insets(20));

        table = new TableView<>();
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        table.setPlaceholder(new Label("No rows to display"));

        TableColumn c1 = new TableColumn("ID");
        c1.setCellValueFactory(new PropertyValueFactory<>("ID"));

        TableColumn c2 = new TableColumn("Name");
        c2.setCellValueFactory(new PropertyValueFactory<>("Name"));

        TableColumn c3 = new TableColumn("Job");
        c3.setCellValueFactory(new PropertyValueFactory<>("Job"));

        TableColumn c4 = new TableColumn("Salary");
        c4.setCellValueFactory(new PropertyValueFactory<>("Salary"));

        table.getColumns().addAll(c1, c2, c3, c4);

        try {
            show();
        } catch (Exception e) {
            System.err.println(e.toString());
        }

        Label l5 = new Label("Update Student's Major by ID: ");
        Label l6 = new Label("ID");
        TextField t5 = new TextField();
        Label l7 = new Label("New Job");
        TextField t6 = new TextField();
        Button btn3 = new Button("Update");

        GridPane g2 = new GridPane();

        g2.add(l5, 0, 0, 2, 1);
        g2.add(l6, 0, 1);
        g2.add(t5, 1, 1);
        g2.add(l7, 0, 2);
        g2.add(t6, 1, 2);
        g2.add(btn3, 0, 3, 2, 1);

        g2.setVgap(10);
        g2.setHgap(10);
        g2.setPadding(new Insets(20));

        Label l8 = new Label("Delete Student by ID: ");
        Label l9 = new Label("ID");
        TextField t7 = new TextField();
        Button btn4 = new Button("Delete");

        GridPane g3 = new GridPane();

        g3.add(l8, 0, 0, 2, 1);
        g3.add(l9, 0, 1);
        g3.add(t7, 1, 1);
        g3.add(btn4, 0, 2, 2, 1);

        g3.setVgap(10);
        g3.setHgap(10);
        g3.setPadding(new Insets(20));

        VBox Firstvbox = new VBox(g1, g3);
        Firstvbox.setPadding(new Insets(20));

        Button btn5 = new Button("Average Above");

        GridPane g4 = new GridPane();

        g4.add(btn5, 0, 0);

        g4.setVgap(10);
        g4.setHgap(10);
        g4.setPadding(new Insets(20));
        g4.setAlignment(Pos.CENTER);

        Label countlbl = new Label("Count All Employees ");
        Button countbtn = new Button("Count");
        Label countreslbl = new Label();

        GridPane countpane = new GridPane();

        countpane.add(countlbl, 0, 0, 2, 1);
        countpane.add(countbtn, 0, 1);
        countpane.add(countreslbl, 1, 1);

        countpane.setVgap(10);
        countpane.setHgap(10);
        countpane.setPadding(new Insets(20));

        Label Maxsallbl = new Label("Maximum Salary");
        Button maxbtn = new Button("Maximum Salary");
        Label maxlbl = new Label();

        GridPane maxpane = new GridPane();

        maxpane.add(Maxsallbl, 0, 0, 2, 1);
        maxpane.add(maxbtn, 0, 1);
        maxpane.add(maxlbl, 0, 2);

        g4.setVgap(10);
        g4.setHgap(10);
        g4.setPadding(new Insets(20));

        VBox vbox = new VBox(g2, countpane, maxpane);
        VBox v = new VBox(searchpane,table, g4);
        v.setPadding(new Insets(20));

        maxbtn.setOnAction((event) -> {

            try {
                maxfn();
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }

        });

        countbtn.setOnAction((ActionEvent event) -> {

            try {
                show();
                countreslbl.setText("There are " + size + " employees");
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }

        });

        btn1.setOnAction((ActionEvent event) -> {

            conn = dbConn.DBConnection();
            String sql = "Insert into employee (ID, Name, Job, Salary) Values(?,?,?,?)";

            try {
                pst = conn.prepareStatement(sql);
                pst.setString(1, t1.getText());
                pst.setString(2, t2.getText());
                pst.setString(3, t3.getText());
                pst.setString(4, t4.getText());

                int i = pst.executeUpdate();
                if (i == 1) {
                    System.out.println("Data is inserted");
                }
                pst.close();
                conn.close();
                show();
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
        });

        btn2.setOnAction((ActionEvent event) -> {

            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
        });

        btn3.setOnAction((ActionEvent event) -> {

            String id = t5.getText();
            String m = t6.getText();

            String sql = "Update employee set Job = ? where ID = ?";
            conn = dbConn.DBConnection();
            try {
                pst = conn.prepareStatement(sql);
                pst.setString(1, m);
                pst.setString(2, id);
                pst.executeUpdate();
                pst.close();
                conn.close();
                show();
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }

        });

        btn4.setOnAction(e -> {
            String id = t7.getText();
            String sql = "Delete from employee where ID = ?";

            conn = dbConn.DBConnection();
            try {
                pst = conn.prepareStatement(sql);
                pst.setString(1, id);
                pst.executeUpdate();
                pst.close();
                conn.close();
                show();
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }

        });

        btn5.setOnAction(e -> {
            String sql = "select avg (Salary) from employee"; // avg, sum, count, min, max
            String avg ;

            conn = dbConn.DBConnection();
            try {
                pst = conn.prepareStatement(sql);
                res = pst.executeQuery();
                if (res.next()) {
                    avg = Double.toString(res.getDouble(1));
                    abvavg(avg);
                }
                pst.close();
                conn.close();

            } catch (Exception ex) {
                System.out.println(ex.toString());
            }

        });
        
        Search.setOnAction((ActionEvent event) -> {
            data = FXCollections.observableArrayList();
            conn = dbConn.DBConnection();

            try {
                pst = conn.prepareStatement("select * from employee Where id = "+searchtext.getText());

                res = pst.executeQuery();

                while (res.next()) {
                    data.add(new Employee(res.getInt(1), res.getString(2), res.getString(3), res.getDouble(4)));

                }

                pst.close();
                conn.close();
                table.setItems(data);
                searchtext.setText("");
            } catch (Exception exx) {
                System.out.println(exx.toString());
            }
        });

        FlowPane root = new FlowPane(Firstvbox, v, vbox);
        Scene scene = new Scene(root, 1000, 500);

        primaryStage.setTitle("DB Connection");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void show() throws SQLException {

        data = FXCollections.observableArrayList();
        conn = dbConn.DBConnection();

        pst = conn.prepareStatement("select * from employee");
        res = pst.executeQuery();

        while (res.next()) {
            data.add(new Employee(res.getInt(1), res.getString(2), res.getString(3), res.getDouble(4)));
        }
        size = data.size();
        pst.close();
        conn.close();
        table.setItems(data);
    }
    
    public void maxfn() throws SQLException{
        
        data = FXCollections.observableArrayList();
            conn = dbConn.DBConnection();

            pst = conn.prepareStatement("select * from employee where Salary=(select Max(Salary) from employee)");
            res = pst.executeQuery();

            while (res.next()) {
                data.add(new Employee(res.getInt(1), res.getString(2), res.getString(3), res.getDouble(4)));
            }
            size = data.size();
            pst.close();
            conn.close();
            table.setItems(data);
        
    }
    
    public void abvavg(String avg) throws SQLException{
        
        data = FXCollections.observableArrayList();
            conn = dbConn.DBConnection();

            pst = conn.prepareStatement("select * from employee where Salary > "+avg);
            res = pst.executeQuery();

            while (res.next()) {
                data.add(new Employee(res.getInt(1), res.getString(2), res.getString(3), res.getDouble(4)));
            }
            size = data.size();
            pst.close();
            conn.close();
            table.setItems(data);
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
