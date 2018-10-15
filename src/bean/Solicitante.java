package bean;

import java.sql.Date;

public class Solicitante {
    
    private int id = -1;
    private String nome = null;
    private String rg = null;
    private String cpf = null;
    private String nomepai = null;
    private String nomemae = null;
    private int idendereco = -1;
    private Date datanascimento = null;
    private String sexo = null; // Hmmmmmmm (͡° ͜ʖ ͡°) 
    private String naturalidade = null;
    private String estadocivil = null;
    private String historicosocial = null;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNomePai() {
        return nomepai;
    }

    public void setNomePai(String nome_pai) {
        this.nomepai = nome_pai;
    }

    public String getNomeMae() {
        return nomemae;
    }

    public void setNomeMae(String nome_mae) {
        this.nomemae = nome_mae;
    }

    public int getIdEndereco() {
        return idendereco;
    }

    public void setIdEndereco(int id_endereco) {
        this.idendereco = id_endereco;
    }

    public Date getDataNascimento() {
        return datanascimento;
    }

    public void setDataNascimento(Date data_nascimento) {
        this.datanascimento = data_nascimento;
    }

    public String getSexo() { // Hmmmmmmm (͡° ͜ʖ ͡°) 
        return sexo;
    }

    public void setSexo(String sexo) { // Hmmmmmmm (͡° ͜ʖ ͡°) 
        this.sexo = sexo;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getEstadoCivil() {
        return estadocivil;
    }

    public void setEstadoCivil(String estado_civil) {
        this.estadocivil = estado_civil;
    }

    public String getHistoricoSocial() {
        return historicosocial;
    }

    public void setHistoricoSocial(String historico_social) {
        this.historicosocial = historico_social;
    }
    
    
    
}
