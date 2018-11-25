package DAO;

import bean.Solicitante;
import interface_persistencia.InterfacePersistencia;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import persistencia.Persistencia;

public class SolicitanteDAO implements InterfacePersistencia<Solicitante> {

    @Override
    public boolean salvar(Solicitante pObjeto) throws ClassNotFoundException, SQLException, IOException {

        Persistencia persistencia = null;
        String sql = null;
        boolean retorno;

        try {

            if (!this.getExiste(pObjeto.getId())) {

                pObjeto.setId(this.getProximoCodigo());

                sql = "INSERT INTO solicitante(";
                sql = sql + " nome,";
                sql = sql + " rg,";
                sql = sql + " cpf,";
                sql = sql + " nome_pai,";
                sql = sql + " nome_mae,";
                sql = sql + " data_nascimento,";
                sql = sql + " sexo,";
                sql = sql + " naturalidade,";
                sql = sql + " estado_civil,";
                sql = sql + " historico_social,";
                sql = sql + " id";
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

                sql = "UPDATE solicitante SET";
                sql = sql + " nome = ?,";
                sql = sql + " rg = ?,";
                sql = sql + " cpf = ?,";
                sql = sql + " nome_pai = ?,";
                sql = sql + " nome_mae = ?,";
                sql = sql + " data_nascimento = ?,";
                sql = sql + " sexo = ?,";
                sql = sql + " naturalidade = ?,";
                sql = sql + " estado_civil = ?,";
                sql = sql + " historico_social = ?";
                sql = sql + "WHERE id = ?";
            }

            persistencia = new Persistencia();

            persistencia.getPreparedStatement(sql);

            persistencia.setParametro(1, pObjeto.getNome());
            persistencia.setParametro(2, pObjeto.getRg());
            persistencia.setParametro(3, pObjeto.getCpf());
            persistencia.setParametro(4, pObjeto.getNomePai());
            persistencia.setParametro(5, pObjeto.getNomeMae());            
            persistencia.setParametro(6, pObjeto.getDataNascimento());
            persistencia.setParametro(7, pObjeto.getSexo());
            persistencia.setParametro(8, pObjeto.getNaturalidade());
            persistencia.setParametro(9, pObjeto.getEstadoCivil());
            persistencia.setParametro(10, pObjeto.getHistoricoSocial());
            persistencia.setParametro(11, pObjeto.getId());

            retorno = persistencia.getPreparedStatement(null).executeUpdate() > 0;

        } finally {
            persistencia = null;
        }

        return retorno;

    }

    @Override
    public boolean getExiste(int pID) throws ClassNotFoundException, SQLException, IOException {
        String sql = null;
        boolean retorno = false;
        Persistencia persistencia = null;

        try {

            sql = "SELECT COUNT(id) FROM solicitante WHERE id = " + pID;

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

            sql = "SELECT MAX(id) FROM solicitante";

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
    public boolean getObjeto(int pID, Solicitante pObjeto) throws ClassNotFoundException, SQLException, IOException {

        String sql = null;
        Persistencia persistencia = null;
        boolean retorno = false;

        try {

            sql = "SELECT";
            sql = sql + " nome,";
            sql = sql + " rg,";
            sql = sql + " cpf,";
            sql = sql + " nome_pai,";
            sql = sql + " nome_mae,";            
            sql = sql + " data_nascimento,";
            sql = sql + " sexo,";
            sql = sql + " naturalidade,";
            sql = sql + " estado_civil,";
            sql = sql + " historico_social,";
            sql = sql + " id";
            sql += " FROM solicitante";
            sql += " WHERE id = ?";

            persistencia = new Persistencia();

            persistencia.getPreparedStatement(sql);

            persistencia.setParametro(1, pID);

            if (persistencia.getResultSet(null).first()) {

                pObjeto.setNome(persistencia.getResultSet(null).getString("nome"));
                pObjeto.setRg(persistencia.getResultSet(null).getString("rg"));
                pObjeto.setCpf(persistencia.getResultSet(null).getString("cpf"));
                pObjeto.setNomePai(persistencia.getResultSet(null).getString("nome_pai"));
                pObjeto.setNomeMae(persistencia.getResultSet(null).getString("nome_mae"));                
                pObjeto.setDataNascimento(persistencia.getResultSet(null).getDate("data_nascimento"));
                pObjeto.setSexo(persistencia.getResultSet(null).getString("sexo"));
                pObjeto.setNaturalidade(persistencia.getResultSet(null).getString("naturalidade"));
                pObjeto.setEstadoCivil(persistencia.getResultSet(null).getString("estado_civil"));
                pObjeto.setHistoricoSocial(persistencia.getResultSet(null).getString("historico_social"));
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
    public boolean delete(int pID) throws ClassNotFoundException, SQLException, IOException {

        Persistencia persistencia = null;
        String sql = null;
        boolean retorno = false;

        try {

            persistencia = new Persistencia();

            sql = "DELETE FROM solicitante WHERE id = ?";

            persistencia.getPreparedStatement(sql);

            persistencia.getPreparedStatement(null).setInt(1, pID);

            retorno = persistencia.getPreparedStatement(null).executeUpdate() > 0;

        } finally {
            sql = null;
            persistencia = null;
        }

        return retorno;

    }

    public List<Solicitante> getConsulta(final String pCHAVE, final byte pCONSULTARPOR) throws ClassNotFoundException, SQLException, IOException {
        String sql = null;
        Persistencia persistencia = null;

        List<Solicitante> lista = new ArrayList<>();

        try {

            sql = "SELECT";
            sql += " id,";
            sql += " nome,";
            sql += " rg,";
            sql += " cpf,";
            sql += " nome_pai,";
            sql += " nome_mae,";            
            sql += " data_nascimento,";
            sql += " sexo,";
            sql += " naturalidade,";
            sql += " estado_civil,";
            sql += " historico_social";
            sql += " FROM solicitante";
            sql += " WHERE 0=0";

            persistencia = new Persistencia();

            if (!pCHAVE.trim().isEmpty()) {

                switch (pCONSULTARPOR) {
                    case 0:// Código                      
                        sql += " AND id = " + pCHAVE;
                        break;

                    case 1:// Nome                        
                        sql += " AND nome LIKE '" + pCHAVE + "%'";
                        break;

                    case 2: // Palavra-Chave
                        sql += " AND nome LIKE '%" + pCHAVE + "%'";
                        break;
                }
            }

            persistencia.getPreparedStatement(sql);

            while (persistencia.getResultSet(sql).next()) {
                Solicitante solicitante = new Solicitante();

                solicitante.setNome(persistencia.getResultSet(null).getString("nome"));
                solicitante.setRg(persistencia.getResultSet(null).getString("rg"));
                solicitante.setCpf(persistencia.getResultSet(null).getString("cpf"));
                solicitante.setNomePai(persistencia.getResultSet(null).getString("nome_pai"));
                solicitante.setNomeMae(persistencia.getResultSet(null).getString("nome_mae"));                
                solicitante.setDataNascimento(persistencia.getResultSet(null).getDate("data_nascimento"));
                solicitante.setSexo(persistencia.getResultSet(null).getString("sexo"));
                solicitante.setNaturalidade(persistencia.getResultSet(null).getString("naturalidade"));
                solicitante.setEstadoCivil(persistencia.getResultSet(null).getString("estado_civil"));
                solicitante.setHistoricoSocial(persistencia.getResultSet(null).getString("historico_social"));
                solicitante.setId(persistencia.getResultSet(null).getInt("id"));

                lista.add(solicitante);

            }

            return lista;

        } finally {
            sql = null;
            persistencia = null;
        }
    }

}
