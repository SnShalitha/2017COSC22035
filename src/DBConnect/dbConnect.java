package DBConnect;
import java.sql.*;
public class dbConnect {
        //public String url = "localhost";
        public String url = "172.16.20.180";
        public String port = "3306"; //8889
        public String database = "hacklnjava";
      //  String relation=""
        public String user = "admin";
        public String password = "stcs";//root
        public String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        Connection conn = null;

        //Function to Connect to DB
        public void Connect2DB()
        {
            String DB_URL = "jdbc:mysql://"+url+":"+port+"/"+database;
            Statement stmnt=null;
            DBConnect.dbConnect db=new dbConnect();
            stmnt=db.Conn2DB();
            //  Statement dbstmt=null;
            try {
                //stmnt.executeUpdate("insert into userdetails values(1000102,'Wsta','loves wayiti','jj',3)");
                stmnt.executeUpdate("select * from  ");
                ResultSet res=stmnt.executeQuery("select  * from userdetails ");

                while(res.next())
                    if((res.getInt("Role")==3))
                    System.out.println(res.getString("Email")+" "+res.getString("UserName"));
                //conn = DriverManager.getConnection(DB_URL,user,password);//Connect
                //dbstmt = conn.createStatement();
               // System.out.println("Connected");
            }
            catch (SQLException se)
            {
                se.printStackTrace();
            }
            //return dbstmt;
            db.closeDb();
        }


    public Statement Conn2DB()
    {
        String DB_URL = "jdbc:mysql://"+url+":"+port+"/"+database;
        Statement dbstmt=null;
        try {
            conn = DriverManager.getConnection(DB_URL,user,password);//Connect
            dbstmt = conn.createStatement();
            System.out.println("Connected");
        }
        catch (SQLException se)
        {
            se.printStackTrace();
        }
        return dbstmt;
    }
    public  void closeDb(){
            try{
                System.out.printf("CLOSING");
                conn.close();
            }catch (SQLException ex){
                ex.getStackTrace();
            }
    }

}
