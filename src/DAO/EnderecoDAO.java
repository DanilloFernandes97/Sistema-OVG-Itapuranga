package DAO;

import interface_persistencia.InterfacePersistencia;
import bean.Endereco;
import java.io.IOException;
import java.sql.SQLException;
import persistencia.Persistencia;

public class EnderecoDAO implements InterfacePersistencia<Endereco> {

    @Override
    public boolean salvar(Endereco pObjeto) throws IOException, ClassNotFoundException, SQLException {

        Persistencia persistencia = null;
        String sql = null;
        boolean retorno;

        try {

            if (!this.getExiste(pObjeto.getId())) {

                pObjeto.setId(this.getProximoCodigo());

                sql = "INSERT INTO endereco(";
                sql = sql + " id,";
                sql = sql + " id_solicitante,";
                sql = sql + " logadouro,";
                sql = sql + " bairro,";
                sql = sql + " complemento,";
                sql = sql + " numero,";
                sql = sql + " cep,";
                sql = sql + " id_municipio";
                sql = sql + ")VALUES(";
                sql = sql + " ?,";
                sql = sql + " ?,";
                sql = sql + " ?,";
                sql = sql + " ?,";
                sql = sql + " ?,";
                sql = sql + " ?,";
                sql = sql + " ?,";
                sql = sql + " ?";
                sql = sql + ")";

            } else {

                sql = "UPDATE endereco SET";
                sql = sql + " id = ?,";
                sql = sql + " id_solicitante = ?,";
                sql = sql + " logadouro = ?,";
                sql = sql + " bairro = ?,";
                sql = sql + " complemento = ?,";
                sql = sql + " numero = ?,";
                sql = sql + " cep = ?,";
                sql = sql + " id_municipio = ?";
                sql = sql + "WHERE id = ?";
            }

            persistencia = new Persistencia();

            persistencia.getPreparedStatement(sql);

            persistencia.setParametro(1, pObjeto.getId());
            persistencia.setParametro(2, pObjeto.getIdSolicitante());
            persistencia.setParametro(3, pObjeto.getLogadouro());           
            persistencia.setParametro(4, pObjeto.getBairro());
            persistencia.setParametro(5, pObjeto.getComplemento());
            persistencia.setParametro(6, pObjeto.getNumero());
            persistencia.setParametro(7, pObjeto.getCep());
            persistencia.setParametro(8, pObjeto.getIdmunicipio());

            retorno = persistencia.getPreparedStatement(null).executeUpdate() > 0;

        } finally {
            persistencia = null;
        }

        return retorno;

    }

    @Override
    public boolean getExiste(int pID) throws IOException, ClassNotFoundException, SQLException {

        String sql = null;
        boolean retorno = false;
        Persistencia persistencia = null;

        try {

            sql = "SELECT COUNT(id) FROM endereco WHERE id = " + pID;

            persistencia = new Persistencia();

            persistencia.preparaResultSet(true, sql);

            if (persistencia.getResultSet(null).first()) {
                retorno = persistencia.getResultSet(null).getInt(1) > 0;
            }

        } finally {
            sql = null;
            persistencia = null;
        }

        return retorno;

    }

    @Override
    public int getProximoCodigo() throws IOException, ClassNotFoundException, SQLException {

        int retorno = -1;
        String sql = null;

        Persistencia persistencia = new Persistencia();
        try {

            sql = "SELECT MAX(id) FROM endereco";

            persistencia.preparaResultSet(true, sql);

            persistencia.getResultSet(null).first();

            retorno = persistencia.getResultSet(null).getInt(1) + 1;

        } finally {
            sql = null;
            persistencia = null;
        }

        return retorno;

    }

    @Override
    public boolean getObjeto(int pID, Endereco pObjeto) throws IOException, ClassNotFoundException, SQLException {

        String sql = null;
        Persistencia persistencia = null;
        boolean retorno = false;

        try {

            sql = "SELECT";
            sql = sql + " id,";
            sql = sql + " id_solicitante,";
            sql = sql + " logadouro,";
            sql = sql + " bairro,";
            sql = sql + " complemento,";
            sql = sql + " numero,";
            sql = sql + " cep,";
            sql = sql + " id_municipio";
            sql += " FROM endereco";
            sql += " WHERE id = ?";

            persistencia = new Persistencia();

            persistencia.getPreparedStatement(sql);

            persistencia.setParametro(1, pID);

            if (persistencia.getResultSet(null).first()) {

                pObjeto.setId(persistencia.getResultSet(null).getInt("id"));
                pObjeto.setIdSolicitante(persistencia.getResultSet(null).getInt("id_solicitante"));
                pObjeto.setBairro(persistencia.getResultSet(null).getString("bairro"));
                pObjeto.setLogadouro(persistencia.getResultSet(null).getString("logadouro"));
                pObjeto.setComplemento(persistencia.getResultSet(null).getString("Complemento"));
                pObjeto.setNumero(persistencia.getResultSet(null).getString("numero"));
                pObjeto.setCep(persistencia.getResultSet(null).getString("cep"));
                pObjeto.setIdmunicipio(persistencia.getResultSet(null).getInt("id_municipio"));

            }

            retorno = true;

        } finally {
            sql = null;
            persistencia = null;
        }

        return retorno;

    }

    @Override
    public boolean delete(int pID) throws IOException, ClassNotFoundException, SQLException {

        Persistencia persistencia = null;
        String sql = null;
        boolean retorno = false;

        try {

            sql = "DELETE FROM endereco WHERE id = ?";

            persistencia.getPreparedStatement(sql);

            persistencia.getPreparedStatement(null).setInt(1, pID);

            retorno = persistencia.getPreparedStatement(null).executeUpdate() > 0;

        } finally {
            sql = null;
            persistencia = null;
        }

        return retorno;

    }

    public int getIdEndereco(final int pIDSOLICITANTE) throws ClassNotFoundException, SQLException, IOException {
        String sql = null;
        Persistencia persistencia = null;

        try {

            sql = "SELECT";
            sql += "  id";
            sql += " FROM endereco";
            sql += " WHERE id_solicitante = ?";

            persistencia = new Persistencia();

            persistencia.getPreparedStatement(sql);

            persistencia.setParametro(1, pIDSOLICITANTE);

            if (persistencia.getResultSet(null).first()) {

                return persistencia.getResultSet(null).getInt("id");

            } else {

                return -1;

            }

        } finally {
            sql = null;
            persistencia = null;
        }

    }
}
