package bean;

import enuns.TipoTelefone;

public class Telefone {
    
    private int Id = -1;
    private int IdSolicitante = -1;
    private String Telefone = null;
    private TipoTelefone TipoTelefone;

    public Telefone() {
        this.TipoTelefone = TipoTelefone.ttOutros;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public int getId_solicitante() {
        return IdSolicitante;
    }

    public void setId_solicitante(int id_solicitante) {
        this.IdSolicitante = id_solicitante;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String telefone) {
        this.Telefone = telefone;
    }

    public TipoTelefone getTipoTelefone() {
        return TipoTelefone;
    }  

    public void setTipoTelefone(TipoTelefone tipoTelefone) {
        this.TipoTelefone = tipoTelefone;
    }
    
}               