package main;

import java.sql.Connection;


public class main {
  
    public static void main(String[] args) {
        
        try {
            
            Connection Connection = conexao.Conexao.getConexao();
            
        } catch (Exception e) {       
            
            System.out.println("Erro " + e.getMessage());
            
        }
        
    }
    
}
