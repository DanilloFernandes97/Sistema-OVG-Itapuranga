package DAO;

import interface_persistencia.InterfacePersistencia;
import bean.ComposicaoFamiliar;
import bean.Solicitante;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import persistencia.Persistencia;

public class ComposicaoFamiliarDAO implements InterfacePersistencia<ComposicaoFamiliar> {

    @Override
    public boolean salvar(ComposicaoFamiliar pObjeto) throws IOException, ClassNotFoundException, SQLException {

        Persistencia persistencia = null;
        String sql = null;
        boolean retorno;

        try {

            if (!this.getExiste(pObjeto.getId())) {

                pObjeto.setId(this.getProximoCodigo());

                sql = "INSERT INTO composicao_familiar(";
                sql += " id_solicitante,";
                sql += " parentesco,";
                sql += " nome,";
                sql += " data_nasc,";
                sql += " profissao,";
                sql += " renda,";
                sql += " id";
                sql += ")VALUES(";
                sql += " ?,";
                sql += " ?,";
                sql += " ?,";
                sql += " ?,";
                sql += " ?,";
                sql += " ?,";
                sql += " ?";
                sql += ")";

            } else {

                sql = "UPDATE composicao_familiar SET";
                sql += " id_solicitante = ?,";
                sql += " parentesco = ?,";
                sql += " nome = ?,";
                sql += " data_nasc = ?,";
                sql += " profissao = ?,";
                sql += " renda = ?";
                sql += "WHERE id = ?";
            }

            persistencia = new Persistencia();

            persistencia.getPreparedStatement(sql);

            persistencia.setParametro(1, pObjeto.getIdSolicitante());
            persistencia.setParametro(2, pObjeto.getParentesco());
            persistencia.setParametro(3, pObjeto.getNome());
            persistencia.setParametro(4, pObjeto.getDataNasc());
            persistencia.setParametro(5, pObjeto.getProfissao());
            persistencia.setParametro(6, pObjeto.getRenda());
            persistencia.setParametro(7, pObjeto.getId());

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

            sql = "SELECT COUNT(id) FROM composicao_familiar WHERE id = " + pID;

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

            sql = "SELECT MAX(id) FROM composicao_familiar";

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
    public boolean getObjeto(int pID, ComposicaoFamiliar pObjeto) throws IOException, ClassNotFoundException, SQLException {

        String sql = null;
        Persistencia persistencia = null;
        boolean retorno = false;

        try {

            sql = "SELECT";
            sql += " id_solicitante,";
            sql += " parentesco,";
            sql += " nome,";
            sql += " data_nasc,";
            sql += " profissao,";
            sql += " renda,";
            sql += " id";
            sql += " FROM composicao_familiar";
            sql += " WHERE id = ?";

            persistencia = new Persistencia();

            persistencia.getPreparedStatement(sql);

            persistencia.setParametro(1, pID);

            if (persistencia.getResultSet(null).first()) {

                pObjeto.setId(persistencia.getResultSet(null).getInt("id"));
                pObjeto.setIdSolicitante(persistencia.getResultSet(null).getInt("id_solicitant"));
                pObjeto.setParentesco(persistencia.getResultSet(null).getString("parentesco"));
                pObjeto.setNome(persistencia.getResultSet(null).getString("nome"));
                pObjeto.setDataNasc(persistencia.getResultSet(null).getDate("data_nasc"));
                pObjeto.setProfissao(persistencia.getResultSet(null).getString("profissao"));
                pObjeto.setRenda(persistencia.getResultSet(null).getDouble("renda"));

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

            sql = "DELETE FROM composicao_familiar WHERE id = ?";

            persistencia = new Persistencia();
            
            persistencia.getPreparedStatement(sql);

            persistencia.getPreparedStatement(null).setInt(1, pID);

            retorno = persistencia.getPreparedStatement(null).executeUpdate() > 0;

        } finally {
            sql = null;
            persistencia = null;
        }

        return retorno;

    }

    public List<ComposicaoFamiliar> getConsulta(final int pIDSOLICITANTE) throws ClassNotFoundException, SQLException, IOException {
        String sql = null;
        Persistencia persistencia = null;

        List<ComposicaoFamiliar> lista = new ArrayList<>();

        try {

            sql = "SELECT";
            sql += " id_solicitante,";
            sql += " parentesco,";
            sql += " nome,";
            sql += " data_nasc,";
            sql += " profissao,";
            sql += " renda,";
            sql += " id";
            sql += " FROM composicao_familiar";
            sql += " WHERE id_solicitante = " + pIDSOLICITANTE;

            persistencia = new Persistencia();

            persistencia.getPreparedStatement(sql);

            while (persistencia.getResultSet(sql).next()) {
                ComposicaoFamiliar composicaoFamiliar = new ComposicaoFamiliar();

                composicaoFamiliar.setId(persistencia.getResultSet(null).getInt("id"));
                composicaoFamiliar.setIdSolicitante(persistencia.getResultSet(null).getInt("id_solicitante"));
                composicaoFamiliar.setParentesco(persistencia.getResultSet(null).getString("parentesco"));
                composicaoFamiliar.setNome(persistencia.getResultSet(null).getString("nome"));
                composicaoFamiliar.setDataNasc(persistencia.getResultSet(null).getDate("data_nasc"));
                composicaoFamiliar.setProfissao(persistencia.getResultSet(null).getString("profissao"));
                composicaoFamiliar.setRenda(persistencia.getResultSet(null).getDouble("renda"));

                lista.add(composicaoFamiliar);

            }

            return lista;

        } finally {
            sql = null;
            persistencia = null;
        }
    }

}
