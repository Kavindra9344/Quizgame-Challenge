import java.sql.*;

public class jdbclearning {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
       String url = "jdbc:mysql://localhost:3306/JDBCdemo";
        String rootname = "root";
       String password = "Kavi1235!";
        String query = "select * from employee";
        Connection con = DriverManager.getConnection(url, rootname, password);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
            rs.next();
              System.out.println(rs.getInt(1));
        System.out.println(rs.getString(2));
        System.out.println(rs.getInt(3));
        callaggration();
    }

    public static void insertdata() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/JDBCdemo";
        String rootname = "root";
        String password = "Kavi1235!";
        String query = "insert into employee values(1,'Abi',400000)";
        Connection con = DriverManager.getConnection(url, rootname, password);
        Statement st = con.createStatement();
        int row = st.executeUpdate(query);
        System.out.print("Number of rows affeted: " + row);
    }

    public static void insertvar() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/JDBCdemo";
        String rootname = "root";
        String password = "Kavi1235!";
        int age = 22;
        String name = "Saravana";
        int salary = 48000;
        String query = "insert into employee values( " + age + ", '" + name + "', " + salary + ")";
        Connection con = DriverManager.getConnection(url, rootname, password);
        Statement st = con.createStatement();
        int n = st.executeUpdate(query);
        System.out.println("No of rows inserted: " + n);
    }

    public static void insertusingPst() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/JDBCdemo";
        String rootname = "root";
        String password = "Kavi1235!";
        int age = 40;
        String name = "Hari";
        int salary = 1000000;
        String query = "insert into employee values(?,?,?)";
        Connection c = DriverManager.getConnection(url, rootname, password);
        PreparedStatement p = c.prepareStatement(query);
        p.setInt(1, age);
        p.setString(2, name);
        p.setInt(3, salary);
        int row = p.executeUpdate();
        System.out.print("No of row insert " + row);
    }

    public static void delete() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/JDBCdemo";
        String rootname = "root";
        String password = "Kavi1235!";
        String query = "delete from employee where age =35";
        Connection c = DriverManager.getConnection(url, rootname, password);
        Statement st = c.createStatement();
        int r = st.executeUpdate(query);
        System.out.print("Number of rows delete" + r);
    }

    public static void update() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/JDBCdemo";
        String rootname = "root";
        String password = "Kavi1235!";
        String query = "update employee set name = 'Puniya Devi' where name = 'devi' ";
        Connection c = DriverManager.getConnection(url, rootname, password);
        Statement st = c.createStatement();
        int r = st.executeUpdate(query);
        System.out.print("No of Rows Affected : " + r);
    }

    public static void prepudate() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/JDBCdemo";
        String rootname = "root";
        String password = "Kavi1235!";
        String query = "update employee set name =? where name =?";
        Connection c = DriverManager.getConnection(url, rootname, password);
        PreparedStatement p = c.prepareStatement(query);
        p.setString(1, "Puniyom");
        p.setString(2, "Puniya devi");
        int r = p.executeUpdate();
        System.out.println("Now of rows affeted " + r);
    }

    public static void prepupdate() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/JDBCdemo";
        String rootname = "root";
        String password = "Kavi1235!";
        String query = "update employee set age=? where name=? ";
        Connection c = DriverManager.getConnection(url, rootname, password);
        PreparedStatement p = c.prepareStatement(query);
        p.setInt(1, 22);
        p.setString(2, "Abi");
        int r = p.executeUpdate();
        System.out.print("No of row update " + r);
    }

    public static void prepsum() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/JDBCdemo";
        String rootname = "root";
        String password = "Kavi1235!";
        String query = "select sum(salary) from employee";
        Connection con = DriverManager.getConnection(url, rootname, password);
        PreparedStatement p = con.prepareStatement(query);
        ResultSet r = p.executeQuery();
        if (r.next()) {
            int sum = r.getInt(1);
            System.out.println("No of Rows Affected : " + sum);
        }
    }

    public static void prepcount() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/JDBCdemo";
        String rootname = "root";
        String password = "Kavi1235!";
        String qurey = "select count(name) from employee";
        Connection con = DriverManager.getConnection(url, rootname, password);
        PreparedStatement p = con.prepareStatement(qurey);
        ResultSet res = p.executeQuery();
        if (res.next()) {
            int count = res.getInt(1);
            System.out.print("No of rows Counted : " + count);
        }
        res.close();
        p.close();
    }

    public static void simplecallprocedure() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/JDBCdemo";
        String rootname = "root";
        String password = "Kavi1235!";
        String query = "select age, name, salary from employee where salary= (select max(salary) from employee)";
        Connection con = DriverManager.getConnection(url, rootname, password);
        PreparedStatement st = con.prepareStatement(query);
        ResultSet res = st.executeQuery();
        if (res.next()) {
            int age = res.getInt("age");
            String name = res.getString("name");
            int salary = res.getInt("salary");
            System.out.println("Maximum salary of employee :" + "Age : " + age + "," + "Name : " + name + ",Salary " + salary);
        }
        res.close();
        st.close();
        con.close();
    }

    public static void prepaggregatefunction() throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/JDBCdemo";
        String rootname = "root";
        String password = "Kavi1235!";
        String query1 = "select max(salary) from employee";
        String query2 = "select min(salary) from employee";
        String query3 = "select sum(salary) from employee";
        String query4 = "select count(salary) from employee";
        String query5 = "select avg(salary) from employee";
        Connection con = DriverManager.getConnection(url, rootname, password);
        PreparedStatement p1 = con.prepareStatement(query1);
        PreparedStatement p2 = con.prepareStatement(query2);
        PreparedStatement p3 = con.prepareStatement(query3);
        PreparedStatement p4 = con.prepareStatement(query4);
        PreparedStatement p5 = con.prepareStatement(query5);
        ResultSet res1 = p1.executeQuery();
        ResultSet res2 = p2.executeQuery();
        ResultSet res3 = p3.executeQuery();
        ResultSet res4 = p4.executeQuery();
        ResultSet res5 = p5.executeQuery();
        if (res1.next() && res2.next() && res3.next() && res4.next() && res5.next()) {
            int max = res1.getInt(1);
            int min = res2.getInt(1);
            int sum = res3.getInt(1);
            int count = res4.getInt(1);
            double avg = res5.getDouble(1);
            System.out.println("Maximum salary : " + max);
            System.out.println("Minimum salary : " + min);
            System.out.println("Sum of salary :" + sum);
            System.out.println("Count of employee : " + count);
            System.out.println("Avg Of salary : " + avg);
        }
        String query = "select max(salary),min(salary),sum(salary),count(salary),avg(salary) from employee";
        Connection c = DriverManager.getConnection(url, rootname, password);
        PreparedStatement p = c.prepareStatement(query);
        ResultSet res = p.executeQuery();
        if (res.next()) {
            int max = res.getInt(1);
            int min = res.getInt(2);
            int sum = res.getInt(3);
            int count = res.getInt(4);
            double avg = res.getDouble(5);
            System.out.println("Maximum salary : " + max);
            System.out.println("Minimum salary : " + min);
            System.out.println("Sum of salary :" + sum);
            System.out.println("Count of employee : " + count);
            System.out.println("Avg Of salary : " + avg);
        }
    }

public static void callaggration() throws Exception {
    Class.forName("com.mysql.cj.jdbc.Driver");
    String url = "jdbc:mysql://localhost:3306/JDBCdemo";
    String rootname = "root";
    String password = "Kavi1235!";
    try (Connection c = DriverManager.getConnection(url, rootname, password);
         CallableStatement st = c.prepareCall("{call getAgree()}");
         ResultSet res = st.executeQuery()) {
        if (res.next()) {
            int max = res.getInt(1);
            int min = res.getInt(2);            int sum = res.getInt(3);
            int count = res.getInt(4);
            double avg = res.getDouble(5);
            System.out.println("Maximum salary : " + max);
            System.out.println("Minimum salary : " + min);
            System.out.println("Sum of salary :" + sum);
            System.out.println("Count of employee : " + count);
            System.out.println("Avg Of salary : " + avg);
        }

    }
}
}


