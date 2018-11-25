package DAO;

import interface_persistencia.InterfacePersistencia;
import bean.Municipio;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import persistencia.Persistencia;

public class MunicipioDAO implements InterfacePersistencia<Municipio> {

    @Override
    public boolean salvar(Municipio pObjeto) throws IOException, ClassNotFoundException, SQLException {

        Persistencia persistencia = null;
        String sql = null;
        boolean retorno;

        try {

            if (!this.getExiste(pObjeto.getId())) {

                pObjeto.setId(this.getProximoCodigo());

                sql = "INSERT INTO municipio(";
                sql = sql + "  codigo_ibge,";
                sql = sql + "  nome,";
                sql = sql + "  id_estado,";
                sql = sql + "  id";
                sql = sql + ")VALUES(";
                sql = sql + "  ?,";
                sql = sql + "  ?,";
                sql = sql + "  ?,";
                sql = sql + "  ?";
                sql = sql + ")";

            } else {

                sql = "UPDATE municipio SET";
                sql = sql + "  codigo_ibge = ?,";
                sql = sql + "  nome  = ?,";
                sql = sql + "  id_estado  = ?,";
                sql = sql + "WHERE id = ?";
            }

            persistencia = new Persistencia();

            persistencia.getPreparedStatement(sql);

            persistencia.setParametro(1, pObjeto.getCodigoIbge());
            persistencia.setParametro(2, pObjeto.getNome());
            persistencia.setParametro(3, pObjeto.getIdEstado());
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

            sql = "SELECT COUNT(id) FROM municipio WHERE id = " + pID;

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

            sql = "SELECT MAX(id) FROM municipio";

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
    public boolean getObjeto(int pID, Municipio pObjeto) throws IOException, ClassNotFoundException, SQLException {

        String sql = null;
        Persistencia persistencia = null;
        boolean retorno = false;

        try {

            sql = "SELECT";
            sql += "  codigo_ibge,";
            sql += "  nome,";
            sql += "  id_estado,";
            sql += "  id";
            sql += " FROM municipio";
            sql += " WHERE id = ?";

            persistencia = new Persistencia();

            persistencia.getPreparedStatement(sql);

            persistencia.setParametro(1, pID);

            if (persistencia.getResultSet(null).first()) {

                pObjeto.setId(persistencia.getResultSet(null).getInt("id"));
                pObjeto.setCodigoIbge(persistencia.getResultSet(null).getInt("codigo_ibge"));
                pObjeto.setNome(persistencia.getResultSet(null).getString("nome"));
                pObjeto.setIdEstado(persistencia.getResultSet(null).getInt("id_estado"));

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

            sql = "DELETE FROM municipio WHERE id = ?";

            persistencia.getPreparedStatement(sql);

            persistencia.getPreparedStatement(null).setInt(1, pID);

            retorno = persistencia.getPreparedStatement(null).executeUpdate() > 0;

        } finally {
            sql = null;
            persistencia = null;
        }

        return retorno;

    }

    public List<Municipio> getConsulta(final String pCHAVE, final byte pCONSULTARPOR) throws ClassNotFoundException, SQLException, IOException {
        String sql = null;
        Persistencia persistencia = null;

        List<Municipio> lista = new ArrayList<>();

        try {

            sql = "SELECT";
            sql += "  codigo_ibge,";
            sql += "  nome,";
            sql += "  id_estado,";
            sql += "  id";
            sql += "  FROM municipio";
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

                Municipio municipio = new Municipio();

                municipio.setId(persistencia.getResultSet(null).getInt("id"));
                municipio.setIdEstado(persistencia.getResultSet(null).getInt("id_estado"));
                municipio.setNome(persistencia.getResultSet(null).getString("nome"));
                municipio.setCodigoIbge(persistencia.getResultSet(null).getInt("codigo_ibge"));

                lista.add(municipio);

            }

            return lista;

        } finally {
            sql = null;
            persistencia = null;
        }
    }

    public String getNome(int pCodigoIbge) throws IOException, ClassNotFoundException, SQLException {

        String sql = null;
        Persistencia persistencia = null;

        try {

            sql = "SELECT";
            sql += "  nome";
            sql += " FROM municipio";
            sql += " WHERE codigo_ibge = ?";

            persistencia = new Persistencia();

            persistencia.getPreparedStatement(sql);

            persistencia.setParametro(1, pCodigoIbge);

            if (persistencia.getResultSet(null).first()) {
                return persistencia.getResultSet(null).getString("nome");
            } else {
                return "-1";
            }

        } finally {
            sql = null;
            persistencia = null;
        }

    }

    public int getId(int pCodigoIbge) throws IOException, ClassNotFoundException, SQLException {

        String sql = null;
        Persistencia persistencia = null;

        try {

            sql = "SELECT";
            sql += "  id";
            sql += " FROM municipio";
            sql += " WHERE codigo_ibge = ?";

            persistencia = new Persistencia();

            persistencia.getPreparedStatement(sql);

            persistencia.setParametro(1, pCodigoIbge);

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
    
    public int getCodigoIbge(int pId) throws IOException, ClassNotFoundException, SQLException {

        String sql = null;
        Persistencia persistencia = null;

        try {

            sql = "SELECT";
            sql += "  codigo_ibge";
            sql += " FROM municipio";
            sql += " WHERE id = ?";

            persistencia = new Persistencia();

            persistencia.getPreparedStatement(sql);

            persistencia.setParametro(1, pId);

            if (persistencia.getResultSet(null).first()) {
                return persistencia.getResultSet(null).getInt("codigo_ibge");
            } else {
                return -1;
            }

        } finally {
            sql = null;
            persistencia = null;
        }

    }


}
