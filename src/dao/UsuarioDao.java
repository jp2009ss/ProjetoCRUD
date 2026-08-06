package dao;

import controller.ConnectionMySql;
import model.UsuarioModel;
import java.sql.Connection;
import java.sql.*;
import javax.swing.JOptionPane;

public class UsuarioDao {

    private Connection connection;

    public UsuarioDao(Connection connection) {
        this.connection = new ConnectionMySql().getConnection();
    }

    public void adicionar(UsuarioModel usuario) {
        String sql = "INSERT INTO usuario(nome,cpf,email,telefone,nascimento)VALUES(?,?,?,?,?)";
        
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getCpf());
            ps.setString(3, usuario.getEmail());
            ps.setString(4, usuario.getTelefone());
            ps.setDate  (5, usuario.getNascimento());
            
            ps.execute();
            ps.close();
            
            JOptionPane.showMessageDialog(null, "Usuário Cadastrado!");
            
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar!");
            throw new RuntimeException(e);
        }
        

    }

}
