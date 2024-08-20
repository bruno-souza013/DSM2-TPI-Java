/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelagem;

import Controle.Conexao;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author fatec-dsm2
 */
public class Filmes {
    private int codigo;
    private String titulo;
    private String genero;
    private String produtora;
    private String datacompra;
    Conexao con = new Conexao();
    
    public Filmes() {
        this(0,"","","","");
    }

    public Filmes(int codigo, String titulo,String genero,String produtora, String datacompra) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.genero = genero;
        this.produtora = produtora;
        this.datacompra = datacompra;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    public String getProdutora() {
        return produtora;
    }

    public void setProdutora(String produtora) {
        this.produtora = produtora;
    }

    public String getDatacompra() {
        return datacompra;
    }

    public void setDatacompra(String datacompra) {
        this.datacompra = datacompra;
    }
    public void cadastrarFilmes(){
     String sql = "INSERT INTO filmes (codigo, titulo, genero, produtora, data_compra) VALUES "
            + "('" + getCodigo() + "', '" + getTitulo() + "', '" + getGenero() + "','" +getProdutora()+"','" + getDatacompra() + "')";
    con.executeSQL(sql);
    }
    public ResultSet consultar(){
        ResultSet tabela;
        tabela = null;
        String sql= "Select * from filmes";
        tabela = con.RetornarResultset(sql);
     return tabela;   
    }
    
    public void excluirFilmes(){
       String sql;
        sql= "Delete from filmes where codigo=" +getCodigo();
        con.executeSQL(sql);
        JOptionPane.showMessageDialog(null, "Registro excluído com sucesso..."); 
    }
    public void alterarFilmes(){
        String sql;
        sql = "update filmes set titulo='" + getTitulo() + "', genero='" + getGenero() + "', produtora='" + getProdutora() + "', data_compra='" + getDatacompra() + "' where codigo=" + getCodigo();
        con.executeSQL(sql);
        JOptionPane.showMessageDialog(null, "Dados alterados com sucesso...");
    }
     public ResultSet consultarCampoEspecifico(){
        ResultSet tabela;
        tabela = null;
        try{
          String sql="Select * from filmes where codigo like '"+ getCodigo()+"%'";
          tabela= con.RetornarResultset(sql);                  
       
           }
           catch(Exception sqle){
                JOptionPane.showMessageDialog(null,"Erro ->"+sqle.getMessage());
           }
        return tabela;    
    }
}
