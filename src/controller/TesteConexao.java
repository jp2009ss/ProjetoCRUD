package controller;

import dao.UsuarioDao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.UsuarioModel;

public class TesteConexao {
    public static void main(String[] args)throws SQLException{
        
        Connection connection = new ConnectionMySql().getConnection();
        JOptionPane.showMessageDialog(null, "Conexão Estabelecida!");
        connection.close();
        
        
        //TESTEEE
        UsuarioModel u = new UsuarioModel();
        UsuarioDao ud = new UsuarioDao(connection);
        
        u.setNome("Felizberto");
        u.setCpf("333.444.555-66");
        u.setEmail("feliz@hotmail.com");
        u.setTelefone("(34)94445454545");
        u.setNascimento(Date.valueOf("2026-08-06"));
        
        ud.adicionar(u);

  
            
    }
}
