import java.util.*;
import java.sql.*;
class CRUD
{
  public static void main(String args[]) throws Exception
  {
    Scanner sc = new Scanner(System.in);
    System.out.println("1.Inserting Data");
    System.out.println("2.Deleting Data");
    System.out.println("3.Updating Data");
    System.out.println("4.View Data");
    System.out.println("Enter Your choice:");
    int ch = sc.nextInt();
    DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","SYSTEM", "SYSTEM");
    Statement stmt= con.createStatement();
    switch(ch)
    {
      case 1: 
              System.out.println("Enter the no. of data you want to insert:");
              int n = sc.nextInt();
              for(int a=0;a<n;a++)
              {
                System.out.println("Enter Employee Id:");
                String e = sc.next();
                System.out.println("Enter Employee Name:");
                String en = sc.next();
                System.out.println("Enter Employee Salary:");
                String es = sc.next();
                String q = "insert into emp123(EID,ENAME,ESAL) values (?,?,?)";
                PreparedStatement ps = con.prepareStatement(q);
                ps.setString(1,e);
                ps.setString(2,en);
                ps.setString(3,es);
                ps.executeUpdate();
                ResultSet rs = stmt.executeQuery("Select * from emp123");
                System.out.println("EID"+" ENAME "+"   ESAL"); 
    
                while(rs.next())
                {
                  System.out.println(rs.getInt("EID")+"   "+rs.getString("ENAME")+"    "+rs.getInt("ESAL"));
                }
                 
              }
              break;
     case 2: System.out.println("Enter the no. of data you want to delete:");
             int n1 = sc.nextInt();
             for(int a=0;a<n1;a++)
             {
               System.out.println("Enter Employee Id:");
               String e = sc.next();
               String q = "delete from emp123 where EID = ?";
               PreparedStatement ps = con.prepareStatement(q);
               ps.setString(1,e);
               ps.executeUpdate();
               ResultSet rs = stmt.executeQuery("Select * from emp123");
               System.out.println("EID"+" ENAME "+"   ESAL"); 
    
               while(rs.next())
               {
                  System.out.println(rs.getInt("EID")+"   "+rs.getString("ENAME")+"    "+rs.getInt("ESAL"));
               }
             }
             break;
     case 3: System.out.println("Enter the no. of data you want to update:");
             int n2 = sc.nextInt();
             for(int a=0;a<n2;a++)
             {
             System.out.println("Enter Employee Id:");
             String e = sc.next();
             System.out.println("Enter Employee Name:");
             String en = sc.next();
             System.out.println("Enter Employee Salary:");
             String es = sc.next();

             String sql ="UPDATE emp123 SET ENAME=?,ESAL=? WHERE EID=?";
             PreparedStatement ps = con.prepareStatement(sql);
             ps.setString(1,en);
             ps.setString(2,es);
             ps.setString(3,e);
             ps.executeUpdate();
             ResultSet rs = stmt.executeQuery("Select * from emp123");

             System.out.println("EID"+" ENAME "+"   ESAL"); 
             while(rs.next())
             {
               System.out.println(rs.getInt("EID")+"   "+rs.getString("ENAME")+"    "+rs.getInt("ESAL"));
             }
             }
             break;
     case 4: String a = "SELECT * FROM emp123";
             ResultSet rs = stmt.executeQuery(a);
             int count = 0;
             System.out.println("EID"+" ENAME "+"   ESAL"); 
             while(rs.next())
             {
               System.out.println(rs.getInt("EID")+"   "+rs.getString("ENAME")+"    "+rs.getInt("ESAL"));
             }
             break;
    
            

   }
    con.close();
  }
}