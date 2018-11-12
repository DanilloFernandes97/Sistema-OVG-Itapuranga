package DAO;

import interface_persistencia.InterfacePersistencia;
import bean.Telefone;
import enuns.TipoTelefone;
import java.io.IOException;
import java.sql.SQLException;
import persistencia.Persistencia;

public class TelefoneDAO implements InterfacePersistencia<Telefone> {

    @Override
    public boolean salvar(Telefone pObjeto) throws IOException, ClassNotFoundException, SQLException {

        Persistencia persistencia = null;
        String sql = null;
        boolean retorno;

        try {

            if (!this.getExiste(pObjeto.getId())) {

                pObjeto.setId(this.getProximoCodigo());

                sql = "INSERT INTO telefone(";
                sql = sql + " id_solicitante,";
                sql = sql + " telefone,";
                sql = sql + " tipo,";
                sql = sql + " id";
                sql = sql + ")VALUES(";
                sql = sql + " ?,";
                sql = sql + " ?,";
                sql = sql + " ?,";
                sql = sql + " ?";
                sql = sql + ")";

            } else {

                sql = "UPDATE telefone SET";
                sql = sql + " id_solicitante = ?,";
                sql = sql + " telefone = ?,";
                sql = sql + " tipo = ?";
                sql = sql + "WHERE id = ?";
            }

            persistencia = new Persistencia();

            persistencia.getPreparedStatement(sql);

            persistencia.setParametro(1, pObjeto.getId_solicitante());
            persistencia.setParametro(2, pObjeto.getTelefone());
            persistencia.setParametro(3, convertEnumToInt(pObjeto.getTipoTelefone()));
            persistencia.setParametro(4, pObjeto.getId());

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

            sql = "SELECT COUNT(id) FROM telefone WHERE id = " + pID;

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

            sql = "SELECT MAX(id) FROM telefone";

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
    public boolean getObjeto(int pID, Telefone pObjeto) throws IOException, ClassNotFoundException, SQLException {

        String sql = null;
        Persistencia persistencia = null;
        boolean retorno = false;

        try {

            sql = "SELECT";
            sql = sql + " id,";
            sql = sql + " id_solicitante,";
            sql = sql + " telefone,";
            sql = sql + " tipo";
            sql += " FROM telefone";
            sql += " WHERE id = ?";

            persistencia = new Persistencia();

            persistencia.getPreparedStatement(sql);

            persistencia.setParametro(1, pID);

            if (persistencia.getResultSet(null).first()) {

                pObjeto.setId_solicitante(persistencia.getResultSet(null).getInt("id_solicitante"));
                pObjeto.setTelefone(persistencia.getResultSet(null).getString("telefone"));
                pObjeto.setTipoTelefone(convertIntToEnum(persistencia.getResultSet(null).getInt("tipo")));
                pObjeto.setId(persistencia.getResultSet(null).getInt("id"));

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

            sql = "DELETE FROM produto WHERE id = ?";

            persistencia.getPreparedStatement(sql);

            persistencia.getPreparedStatement(null).setInt(1, pID);

            retorno = persistencia.getPreparedStatement(null).executeUpdate() > 0;

        } finally {
            sql = null;
            persistencia = null;
        }

        return retorno;

    }

    public int convertEnumToInt(final TipoTelefone tipoTelefone) {
        return 0;
    }

    public TipoTelefone convertIntToEnum(final int valor) {
        return TipoTelefone.ttCelular;
    }

}
