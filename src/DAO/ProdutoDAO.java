package DAO;

import interface_persistencia.InterfacePersistencia;
import bean.Produto;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import persistencia.Persistencia;

public class ProdutoDAO implements InterfacePersistencia<Produto> {

    @Override
    public boolean salvar(Produto pObjeto) throws IOException, ClassNotFoundException, SQLException {

        Persistencia persistencia = null;
        String sql = null;
        boolean retorno;

        try {

            if (!this.getExiste(pObjeto.getId())) {

                pObjeto.setId(this.getProximoCodigo());

                sql = "INSERT INTO produto(";
                sql = sql + " nome,";
                sql = sql + " quantidade,";
                sql = sql + " id";
                sql = sql + ")VALUES(";
                sql = sql + " ?,";
                sql = sql + " ?,";
                sql = sql + " ?";
                sql = sql + ")";

            } else {

                sql = "UPDATE produto SET";
                sql = sql + " nome = ?,";
                sql = sql + " quantidade = ?";
                sql = sql + "WHERE id = ?";
            }

            persistencia = new Persistencia();

            persistencia.getPreparedStatement(sql);

            persistencia.setParametro(1, pObjeto.getNome());
            persistencia.setParametro(2, pObjeto.getQuantidade());
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

            sql = "SELECT COUNT(id) FROM produto WHERE id = " + pID;

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

            sql = "SELECT MAX(id) FROM produto";

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
    public boolean getObjeto(int pID, Produto pObjeto) throws IOException, ClassNotFoundException, SQLException {

        String sql = null;
        Persistencia persistencia = null;
        boolean retorno = false;

        try {

            sql = "SELECT";
            sql = sql + " id,";
            sql = sql + " nome,";
            sql = sql + " quantidade";
            sql += " FROM produto";
            sql += " WHERE id = ?";

            persistencia = new Persistencia();

            persistencia.getPreparedStatement(sql);

            persistencia.setParametro(1, pID);

            if (persistencia.getResultSet(null).first()) {

                pObjeto.setNome(persistencia.getResultSet(null).getString("nome"));
                pObjeto.setQuantidade(persistencia.getResultSet(null).getDouble("quantidade"));
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
    
    public List<Produto> getConsulta(final String pCHAVE, final byte pCONSULTARPOR) throws ClassNotFoundException, SQLException, IOException {
        String sql = null;
        Persistencia persistencia = null;

        List<Produto> lista = new ArrayList<>();

        try {

            sql = "SELECT";
            sql += " id,";
            sql += " nome";
            sql += " FROM produto";
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
                Produto produto = new Produto();

                produto.setNome(persistencia.getResultSet(null).getString("nome"));
                produto.setId(persistencia.getResultSet(null).getInt("id"));

                lista.add(produto);

            }

            return lista;

        } finally {
            sql = null;
            persistencia = null;
        }
    }

}
