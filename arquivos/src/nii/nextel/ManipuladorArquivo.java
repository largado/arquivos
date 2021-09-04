package nii.nextel;

import java.io.BufferedReader;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
 
public class ManipuladorArquivo {
	private static java.sql.Statement st;
	private static ResultSet resultado;
	private static ResultSet resultado2;
    public static void leitor(String path) throws IOException, ClassNotFoundException, SQLException, FileNotFoundException {
  
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = "";
        while (true) {
            if (linha != null) {
         
                try {
                	Class.forName("oracle.jdbc.OracleDriver");
                	Connection con = DriverManager.getConnection("", "","");
                	st = con.createStatement();    
                	ResultSet resultado = st.executeQuery("SELECT * FROM xnp_port_msg WHERE PORT_ID = '" +linha+ "' ");
                	if (resultado == null) {
                		ResultSet resultado2 = st.executeQuery("SELECT * FROM xnp_port_msg WHERE PORT_ID = '" +linha+ "' "); 
                	}
                	
                	while (resultado.next()) {
                		String guardaresultado = resultado.getString("REQ_SEQ");
                		System.out.print(guardaresultado);
                	}
                } catch(SQLException e) {
                	e.printStackTrace();
                }
 
            } else
                break;
            linha = buffRead.readLine();
        }
        buffRead.close();
    }
 
}