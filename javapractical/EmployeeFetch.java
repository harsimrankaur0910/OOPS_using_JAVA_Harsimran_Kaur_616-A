import java.sql.*;

public class EmployeeFetch {
    public static void main(String[] args) {
        try {
            // Modern JDBC (driver loads automatically if jar is present)
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/companydb",
                "root",
                "password"
            );

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM employee");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("emp_id") + " " +
                    rs.getString("emp_name") + " " +
                    rs.getString("department") + " " +
                    rs.getDouble("salary")
                );
            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}