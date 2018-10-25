package DAO;

import interface_persistencia.InterfacePersistencia;
import bean.DespesasFamiliares;
import java.io.IOException;
import java.sql.SQLException;
import persistencia.Persistencia;

public class DespesasFamiliaresDAO implements InterfacePersistencia<DespesasFamiliares> {

    @Override
    public boolean salvar(DespesasFamiliares pObjeto) throws IOException, ClassNotFoundException, SQLException {

        Persistencia persistencia = null;
        String sql = null;
        boolean retorno;

        try {

            if (!this.getExiste(pObjeto.getId())) {

                pObjeto.setId(this.getProximoCodigo());

                sql = "INSERT INTO produto(";
                sql = sql + " id,";
                sql = sql + " id_solicitante,";
                sql = sql + " moradia,";
                sql = sql + " energia,";
                sql = sql + " agua,";
                sql = sql + " alimentacao,";
                sql = sql + " farmacia,";
                sql = sql + " gas,";
                sql = sql + " telefone,";
                sql = sql + " financiamento,";
                sql = sql + " outros";
                sql = sql + ")VALUES(";
                sql = sql + " ?,";
                sql = sql + " ?,";
                sql = sql + " ?,";
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

                sql = "UPDATE produto SET";
                sql = sql + " id = ?,";
                sql = sql + " id_solicitante = ?,";
                sql = sql + " moradia = ?,";
                sql = sql + " energia = ?,";
                sql = sql + " agua = ?,";
                sql = sql + " alimentacao = ?,";
                sql = sql + " farmacia = ?,";
                sql = sql + " gas = ?,";
                sql = sql + " telefone = ?,";
                sql = sql + " financiamento = ?,";
                sql = sql + " outros = ?";
                sql = sql + "WHERE id = ?";
            }

            persistencia = new Persistencia();

            persistencia.getPreparedStatement(sql);

            persistencia.setParametro(1, pObjeto.getId());
            persistencia.setParametro(2, pObjeto.getIdSolicitante());
            persistencia.setParametro(3, pObjeto.getEnergia());
            persistencia.setParametro(4, pObjeto.getAgua());
            persistencia.setParametro(5, pObjeto.getAlimentacao());
            persistencia.setParametro(6, pObjeto.getFarmacia());
            persistencia.setParametro(8, pObjeto.getGas());
            persistencia.setParametro(9, pObjeto.getTelefone());
            persistencia.setParametro(3, pObjeto.getFinanciamento());
            persistencia.setParametro(3, pObjeto.getOutros());

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

            sql = "SELECT COUNT(id) FROM despesas_familiares WHERE id = " + pID;

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

            sql = "SELECT MAX(id) FROM despesas_familiares";

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
    public boolean getObjeto(int pID, DespesasFamiliares pObjeto) throws IOException, ClassNotFoundException, SQLException {

        String sql = null;
        Persistencia persistencia = null;
        boolean retorno = false;

        try {

            sql = "SELECT";
            sql = sql + " id,";
            sql = sql + " id_solicitante,";
            sql = sql + " moradia,";
            sql = sql + " energia,";
            sql = sql + " agua,";
            sql = sql + " alimentacao,";
            sql = sql + " farmacia,";
            sql = sql + " gas,";
            sql = sql + " telefone,";
            sql = sql + " financiamento,";
            sql = sql + " outros";
            sql += " FROM despesas_familiares";
            sql += " WHERE id = ?";

            persistencia = new Persistencia();

            persistencia.getPreparedStatement(sql);

            persistencia.setParametro(1, pID);

            if (persistencia.getResultSet(null).first()) {

                pObjeto.setId(persistencia.getResultSet(null).getInt("id"));
                pObjeto.setIdSolicitante(persistencia.getResultSet(null).getInt("id_solicitant"));
                pObjeto.setMoradia(persistencia.getResultSet(null).getDouble("moradia"));
                pObjeto.setEnergia(persistencia.getResultSet(null).getDouble("energia"));
                pObjeto.setAgua(persistencia.getResultSet(null).getDouble("agua"));
                pObjeto.setAlimentacao(persistencia.getResultSet(null).getDouble("alimentacao"));
                pObjeto.setFarmacia(persistencia.getResultSet(null).getDouble("farmacia"));
                pObjeto.setGas(persistencia.getResultSet(null).getDouble("gas"));
                pObjeto.setTelefone(persistencia.getResultSet(null).getDouble("telefone"));
                pObjeto.setFinanciamento(persistencia.getResultSet(null).getDouble("financiamento"));
                pObjeto.setOutros(persistencia.getResultSet(null).getDouble("outros"));

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

            sql = "DELETE FROM despesas_familiares WHERE id = ?";

            persistencia.getPreparedStatement(sql);

            persistencia.getPreparedStatement(null).setInt(1, pID);

            retorno = persistencia.getPreparedStatement(null).executeUpdate() > 0;

        } finally {
            sql = null;
            persistencia = null;
        }

        return retorno;

    }

}
