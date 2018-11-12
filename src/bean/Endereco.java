package bean;

public class Endereco {

    private int id;
    private String logadouro;
    private String bairro;
    private String complemento;
    private String numero;
    private String cep;
    private int id_municipio;
   
    public int getId() {
        return id;
    }

   
    public void setId(int id) {
        this.id = id;
    }
   
    public String getLogadouro() {
        return logadouro;
    }
    
    public void setLogadouro(String logadouro) {
        this.logadouro = logadouro;
    }
    
    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public int getId_municipio() {
        return id_municipio;
    }

    public void setId_municipio(int id_municipio) {
        this.id_municipio = id_municipio;
    }
    
    
}
