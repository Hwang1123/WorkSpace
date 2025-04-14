package jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class employee_Run {
	public static void main(String[] args) {
		
		Connection cn = null;
		Statement pmst = null;
		ResultSet rset = null;
		List<employee> list = new ArrayList();
		
		String sql = "SELECT * FROM EMPLOYEE";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##SERVER", "SERVER");
			cn.setAutoCommit(false);
			
			pmst = cn.createStatement();
			
			rset = pmst.executeQuery(sql);
			
			rset.next();
			
			while(rset.next()) {
				String emp_id = rset.getString("EMP_ID");
				String emp_name = rset.getString("EMP_NAME");
				String emp_no = rset.getString("EMP_NO");
				String email = rset.getString("EMAIL");
				String phone = rset.getString("PHONE");
				String dept_code = rset.getString("DEPT_CODE");
				String job_code = rset.getString("JOB_CODE");
				String manager_id = rset.getString("MANAGER_ID");
				String hire_date = rset.getString("HIRE_DATE");
				String ent_date = rset.getString("ENT_DATE");
				String ent_yn = rset.getString("ENT_YN");
				int salary = rset.getInt("SALARY");
				int bonus = rset.getInt("BONUS");
				
				list.add(new employee(emp_id, emp_name, emp_no, email, phone, dept_code, job_code,
							manager_id, hire_date, ent_date, ent_yn, salary, bonus));
				
				//System.out.println(emp_id + "," + emp_name + "," + emp_no + "," + email + "," + phone + "," + dept_code + "," + job_code + ","
				//		+ manager_id + "," + hire_date + "," + ent_date + "," + ent_yn + "," + salary + "," + bonus);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				pmst.close();
				cn.close();
			} catch(SQLException e) {
				e.printStackTrace(); 
			}
		} if(list.size() > 0) {
			System.out.println(list);
		} else {
			System.out.println("데이터가 없습니다.");
		}
		
		
		
	}
}
