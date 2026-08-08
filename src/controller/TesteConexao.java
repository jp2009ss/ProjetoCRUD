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
        
        u1.setNome("Abilynna");
        u1.setCpf("222.444.555.11");
        u1.setEmail("abi@yahoo.com");
        u1.setTelefone("(34)9333-4433");
        u1.setNascimento(Date.valueOf("2000-03-02"));
        ud.adicionar(u1);
        
        
        /* Teste de formatação de dados
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate data = LocalDate.parse(txNascimento.getText(), formato);
        u.setNascimento(Date.valueOf(data));
        */
  
            
    }
}
