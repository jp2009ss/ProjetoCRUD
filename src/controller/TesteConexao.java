package controller;

import dao.UsuarioDao;
import model.UsuarioModel;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;


public class TesteConexao {
    public static void main(String[] args)throws SQLException{
        
        Connection connection = new ConnectionMySql().getConnection();
        JOptionPane.showMessageDialog(null, "Conexão Estabelecida!");
        connection.close();
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        //TESTEEE
        UsuarioModel u1 = new UsuarioModel();
        UsuarioDao ud = new UsuarioDao(connection);
        
        u1.setNome("Felizberto");
        u1.setCpf("333.444.555-66");
        u1.setEmail("infeliz@hotmail.com");
        u1.setTelefone("(34)94445454545");
        u1.setNascimento(Date.valueOf("2026-08-06"));
        ud.adicionar(u1);
        
        
        /* Teste de formatação de dados
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = LocalDate.parse(txNascimento.getText(), formato);
        u.setNascimento(Date.valueOf(data));
        */
  
            
    }
}
