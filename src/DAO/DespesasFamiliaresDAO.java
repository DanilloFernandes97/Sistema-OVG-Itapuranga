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
                sql = sql + " valor_moradia,";
                sql = sql + " valor_energia,";
                sql = sql + " valor_agua,";
                sql = sql + " valor_alimentacao,";
                sql = sql + " valor_farmacia,";
                sql = sql + " valor_gas,";
                sql = sql + " valor_telefone,";
                sql = sql + " valor_financiamento,";
                sql = sql + " valor_outros";
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
                sql = sql + " valor_moradia = ?,";
                sql = sql + " valor_energia = ?,";
                sql = sql + " valor_agua = ?,";
                sql = sql + " valor_alimentacao = ?,";
                sql = sql + " valor_farmacia = ?,";
                sql = sql + " valor_gas = ?,";
                sql = sql + " valor_telefone = ?,";
                sql = sql + " valor_financiamento = ?,";
                sql = sql + " valor_outros = ?";
                sql = sql + "WHERE id = ?";
            }

            persistencia = new Persistencia();

            persistencia.getPreparedStatement(sql);

            persistencia.setParametro(1, pObjeto.getId());
            persistencia.setParametro(2, pObjeto.getIdSolicitante());
            persistencia.setParametro(3, pObjeto.getValorEnergia());
            persistencia.setParametro(4, pObjeto.getValorAgua());
            persistencia.setParametro(5, pObjeto.getValorAlimentacao());
            persistencia.setParametro(6, pObjeto.getValorFarmacia());
            persistencia.setParametro(8, pObjeto.getValorGas());
            persistencia.setParametro(9, pObjeto.getValorTelefone());
            persistencia.setParametro(3, pObjeto.getValorFinanciamento());
            persistencia.setParametro(3, pObjeto.getValorOutros());

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
            sql = sql + " valor_moradia,";
            sql = sql + " valor_energia,";
            sql = sql + " valor_agua,";
            sql = sql + " valor_alimentacao,";
            sql = sql + " valor_farmacia,";
            sql = sql + " valor_gas,";
            sql = sql + " valor_telefone,";
            sql = sql + " valor_financiamento,";
            sql = sql + " valor_outros";
            sql += " FROM despesas_familiares";
            sql += " WHERE id = ?";

            persistencia = new Persistencia();

            persistencia.getPreparedStatement(sql);

            persistencia.setParametro(1, pID);

            if (persistencia.getResultSet(null).first()) {

                pObjeto.setId(persistencia.getResultSet(null).getInt("id"));
                pObjeto.setIdSolicitante(persistencia.getResultSet(null).getInt("id_solicitant"));
                pObjeto.setValorMoradia(persistencia.getResultSet(null).getDouble("valor_moradia"));
                pObjeto.setValorEnergia(persistencia.getResultSet(null).getDouble("valor_energia"));
                pObjeto.setValorAgua(persistencia.getResultSet(null).getDouble("valor_agua"));
                pObjeto.setValorAlimentacao(persistencia.getResultSet(null).getDouble("valor_alimentacao"));
                pObjeto.setValorFarmacia(persistencia.getResultSet(null).getDouble("valor_farmacia"));
                pObjeto.setValorGas(persistencia.getResultSet(null).getDouble("valor_gas"));
                pObjeto.setValorTelefone(persistencia.getResultSet(null).getDouble("valor_telefone"));
                pObjeto.setValorFinanciamento(persistencia.getResultSet(null).getDouble("valor_financiamento"));
                pObjeto.setValorOutros(persistencia.getResultSet(null).getDouble("valor_outros"));

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
