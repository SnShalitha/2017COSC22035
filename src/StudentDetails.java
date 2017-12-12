import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import DBConnect.*;

public class StudentDetails extends JFrame{
    private JPanel panel1;
    private JButton btnOk;
    private JTextArea txtuserName;
    private JTextArea textArea2;
    private JTextArea txtGpa;
    private JTextArea txtType;
    private JTextArea txtcontactNumber;
    private JTextArea txtAcademicyear;
    private JButton btnExit;
    private JButton btnCourses;

    public StudentDetails(String userName) {
        //setContentPane(panel1);
        setContentPane( panel1);
        pack();
        setVisible(true);
        fillData(userName);

    }
    public void fillData(String usrName){
        DBConnect.dbConnect db=new dbConnect();
        String sql="select * from login where Username="+usrName+"";
        Statement st=db.Conn2DB();
        try{

            ResultSet rst=st.executeQuery(sql);
            rst.first();
            txtuserName.setText(rst.getString(1));
            txtAcademicyear.setText(rst.getString(4));
            txtcontactNumber.setText(rst.getString(6));

        }catch (Exception ex){

        }
    }
}
