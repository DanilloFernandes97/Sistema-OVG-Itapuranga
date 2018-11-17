package bean;

import java.sql.Date;

public class Solicitante {
    
    private int Id = -1;
    private String Nome = null;
    private String Rg = null;
    private String Cpf = null;
    private String NomePai = null;
    private String NomeMae = null;
    private int IdEndereco = -1;
    private Date DataNascimento = null;
    private String Sexo = null; 
    private String Naturalidade = null;
    private String EstadoCivil = null;
    private String HistoricoSocial = null;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }

    public String getRg() {
        return Rg;
    }

    public void setRg(String rg) {
        this.Rg = rg;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String cpf) {
        this.Cpf = cpf;
    }

    public String getNomePai() {
        return NomePai;
    }

    public void setNomePai(String nome_pai) {
        this.NomePai = nome_pai;
    }

    public String getNomeMae() {
        return NomeMae;
    }

    public void setNomeMae(String nome_mae) {
        this.NomeMae = nome_mae;
    }

    public int getIdEndereco() {
        return IdEndereco;
    }

    public void setIdEndereco(int id_endereco) {
        this.IdEndereco = id_endereco;
    }

    public Date getDataNascimento() {
        return DataNascimento;
    }

    public void setDataNascimento(Date data_nascimento) {
        this.DataNascimento = data_nascimento;
    }

    public String getSexo() { // Hmmmmmmm (͡° ͜ʖ ͡°) 
        return Sexo;
    }

    public void setSexo(String sexo) { // Hmmmmmmm (͡° ͜ʖ ͡°) 
        this.Sexo = sexo;
    }

    public String getNaturalidade() {
        return Naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.Naturalidade = naturalidade;
    }

    public String getEstadoCivil() {
        return EstadoCivil;
    }

    public void setEstadoCivil(String estado_civil) {
        this.EstadoCivil = estado_civil;
    }

    public String getHistoricoSocial() {
        return HistoricoSocial;
    }

    public void setHistoricoSocial(String historico_social) {
        this.HistoricoSocial = historico_social;
    }
    
    
    
}
