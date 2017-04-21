/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistem.informasi.akademik;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author WIN7_UL_Sp1
 */
public class SistemInformasiAkademik {

    static String grade;
    
    public static void main(String[] args) throws SQLException {
       Scanner scanner = new Scanner(System.in);
       
       System.out.println("NIM:");
       String NIM = scanner.nextLine();
       
       System.out.println("Nama:");
       String nama = scanner.nextLine();
       
       System.out.println("Kode MK:");
       String kode_mk = scanner.nextLine();
       
       System.out.println("Nilai:");
       Integer nilai = scanner.nextInt();
             
       if (nilai > 80){
            grade = "A";
        }
        else if (nilai > 70){
            grade = "B";
        }
        else if (nilai > 60){
            grade = "C";
        }
        else if (nilai > 50){
            grade = "D";
        }
        else {
            grade = "E";
        }
          
    System.out.println(grade);
    
       Connection conn = null;
PreparedStatement stmt = null;
try{
    conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/siak", "root", ""); 
    String sql="insert into nilai(NIM,kode_mk,grade) values(?,?,?)";
    stmt = (PreparedStatement) conn.prepareStatement(sql);
    stmt.setString(1, NIM);
    stmt.setString(2, kode_mk);
    stmt.setString(3, grade);
           boolean execute = stmt.execute();   
    System.out.println(grade);       
    }
    
    
 catch (SQLException se){
    System.out.println(se.getMessage());
} finally {
    conn.close();
}
    }
    
    
    
}
