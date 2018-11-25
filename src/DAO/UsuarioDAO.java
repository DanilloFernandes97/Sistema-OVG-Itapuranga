package DAO;

import interface_persistencia.InterfacePersistencia;
import bean.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import persistencia.Persistencia;

public class UsuarioDAO implements InterfacePersistencia<Usuario> {

    @Override
    public boolean salvar(Usuario pObjeto) throws IOException, ClassNotFoundException, SQLException {

        Persistencia persistencia = null;
        String sql = null;
        boolean retorno;

        try {

            if (!this.getExiste(pObjeto.getId())) {

                pObjeto.setId(this.getProximoCodigo());

                sql = "INSERT INTO usuario(";
                sql = sql + " nome,";
                sql = sql + " senha,";
                sql = sql + " id";
                sql = sql + ")VALUES(";
                sql = sql + " ?,";
                sql = sql + " ?,";
                sql = sql + " ?";
                sql = sql + ")";

            } else {

                sql = "UPDATE usuario SET";
                sql = sql + " nome = ?,";
                sql = sql + " senha = ?";
                sql = sql + "WHERE id = ?";
            }

            persistencia = new Persistencia();

            persistencia.getPreparedStatement(sql);

            persistencia.setParametro(1, pObjeto.getNome());
            persistencia.setParametro(2, pObjeto.getSenha());
            persistencia.setParametro(3, pObjeto.getId());

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

            sql = "SELECT COUNT(id) FROM usuario WHERE id = " + pID;

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

            sql = "SELECT MAX(id) FROM usuario";

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
    public boolean getObjeto(int pID, Usuario pObjeto) throws IOException, ClassNotFoundException, SQLException {

        String sql = null;
        Persistencia persistencia = null;
        boolean retorno = false;

        try {

            sql = "SELECT";
            sql = sql + " id,";
            sql = sql + " nome,";
            sql = sql + " senha";
            sql += " FROM usuario";
            sql += " WHERE id = ?";

            persistencia = new Persistencia();

            persistencia.getPreparedStatement(sql);

            persistencia.setParametro(1, pID);

            if (persistencia.getResultSet(null).first()) {

                pObjeto.setNome(persistencia.getResultSet(null).getString("nome"));
                pObjeto.setSenha(persistencia.getResultSet(null).getString("senha"));
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
            persistencia = new Persistencia();

            sql = "DELETE FROM usuario WHERE id = ?";

            persistencia.getPreparedStatement(sql);

            persistencia.getPreparedStatement(null).setInt(1, pID);

            retorno = persistencia.getPreparedStatement(null).executeUpdate() > 0;

        } finally {
            sql = null;
            persistencia = null;
        }

        return retorno;

    }

    public List<Usuario> getConsulta(final String pCHAVE, final byte pCONSULTARPOR) throws ClassNotFoundException, SQLException, IOException {
        String sql = null;
        Persistencia persistencia = null;

        List<Usuario> lista = new ArrayList<>();

        try {

            sql = "SELECT";
            sql += " id,";
            sql += " nome";
            sql += " FROM usuario";
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
                Usuario usuario = new Usuario();

                usuario.setNome(persistencia.getResultSet(null).getString("nome"));
                usuario.setId(persistencia.getResultSet(null).getInt("id"));

                lista.add(usuario);

            }

            return lista;

        } finally {
            sql = null;
            persistencia = null;
        }
    }

    public boolean getAutenticacao(final String pNOME, final String pSENHA) throws IOException, ClassNotFoundException, SQLException {

        String sql = null;
        Persistencia persistencia = null;

        try {

            sql = "SELECT";
            sql += " id";
            sql += " FROM usuario";
            sql += " WHERE nome = ?";
            sql += " AND senha = ?";

            persistencia = new Persistencia();

            persistencia.getPreparedStatement(sql);

            persistencia.setParametro(1, pNOME);
            persistencia.setParametro(2, pSENHA);

            if (persistencia.getResultSet(null).first()) {
                return persistencia.getResultSet(null).getInt("id") > 0;
            } else {
                return false;
            }

        } finally {
            sql = null;
            persistencia = null;
        }

    }

    public boolean getExisteUsuarioCadastrado() throws IOException, ClassNotFoundException, SQLException {

        String sql = null;
        boolean retorno = false;
        Persistencia persistencia = null;

        try {

            sql = "SELECT COUNT(id) FROM usuario;";

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

}
