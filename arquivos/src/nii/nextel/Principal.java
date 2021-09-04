package nii.nextel;

import java.sql.*;
import java.io.IOException;

public class Principal {
 
    public static void main(String args[]) throws IOException, SQLException, ClassNotFoundException {
        String path = "/Users/alex/Documents/workspace/arquivos/lista";
 
        ManipuladorArquivo.leitor(path);
    }
 
}
