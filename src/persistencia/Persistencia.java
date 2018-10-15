package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import conexao.Conexao;
import java.io.IOException;
import java.sql.Date;
import java.sql.Statement;

public class Persistencia {

    private Statement Statement = null;
    private PreparedStatement PreparedStatement;
    private ResultSet ResultSet;

    public PreparedStatement getPreparedStatement(final String pSQL) throws ClassNotFoundException, SQLException, IOException {

        if (this.PreparedStatement == null) {
            this.preparaPreparedStatement(pSQL);
        }

        return this.PreparedStatement;
    }

    // *******************************************
    /* Sobre os 2 parâmetros ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE no 
    construtor. Eles são usados para os ResultSets que receberem o SQL dentro do Statement ou
    PrepareStatement não apenas se moverem para frente(como vem por padrão quando cria um 
    ResultSet), podendo agora apontar para o primeiro registros do nada, para o ultimo, etc.
    Tanto que os valores constantes vem na classe ResultSet.
     */
    private void preparaPreparedStatement(final String pSQL) throws SQLException, ClassNotFoundException, IOException {

        if (pSQL.trim().isEmpty() || (pSQL == null)) {
            throw new SQLException("Parâmetro SQL vazio");
        } else {
            this.PreparedStatement = Conexao.getConexao().prepareStatement(pSQL,
                    java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE, java.sql.ResultSet.CONCUR_UPDATABLE);
        }

    }

    public void setParametro(final int pINDEX, final Integer pPARAMETRO) throws ClassNotFoundException, SQLException, IOException {

        if (pPARAMETRO == null || pPARAMETRO == -1) {
            this.getPreparedStatement(null).setNull(pINDEX, Types.INTEGER);
        } else {
            this.getPreparedStatement(null).setInt(pINDEX, pPARAMETRO);
        }

    }

    public void setParametro(final int pINDEX, final String pPARAMETRO) throws ClassNotFoundException, SQLException, IOException {

        if (pPARAMETRO != null) {
            this.getPreparedStatement(null).setString(pINDEX, pPARAMETRO);
        } else {
            this.getPreparedStatement(null).setNull(pINDEX, Types.VARCHAR);
        }

    }

    public void setParametro(final int pINDEX, final Float pPARAMETRO) throws ClassNotFoundException, SQLException, IOException {

        if (pPARAMETRO == null || pPARAMETRO == -1) {
            this.getPreparedStatement(null).setFloat(pINDEX, pPARAMETRO);
        } else {
            this.getPreparedStatement(null).setNull(pINDEX, Types.FLOAT);
        }

    }

    public void setParametro(final int pINDEX, final Date pPARAMETRO) throws ClassNotFoundException, SQLException, IOException {

        if (pPARAMETRO == null) {
            this.getPreparedStatement(null).setDate(pINDEX, pPARAMETRO);
        } else {
            this.getPreparedStatement(null).setNull(pINDEX, Types.DATE);
        }

    }

    public ResultSet getResultSet(final String pSQL) throws ClassNotFoundException, SQLException, IOException {

        if (this.ResultSet == null) {

            this.ResultSet = this.getPreparedStatement(pSQL).executeQuery();

        }

        return this.ResultSet;

    }

    public boolean executeUpdate(final String pSQL) throws ClassNotFoundException, SQLException, IOException {

        boolean lReturn = false;

        if (pSQL != null) {
            lReturn = this.getPreparedStatement(pSQL).executeUpdate(pSQL) > 0;
        } else {
            lReturn = this.getPreparedStatement(pSQL).executeUpdate() > 0;
        }

        return lReturn;

    }

    // *******************************************
    /* Sobre os 2 parâmetros ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE no 
    construtor. Eles são usados para os ResultSets que receberem o SQL dentro do Statement ou
    PrepareStatement não apenas se moverem para frente(como vem por padrão quando cria um 
    ResultSet), podendo agora apontar para o primeiro registros do nada, para o ultimo, etc.
    Tanto que os valores constantes vem na classe ResultSet.
     */
    public Statement getStatement() throws ClassNotFoundException, SQLException, IOException {

        if (this.Statement == null) {
            this.Statement = Conexao.getConexao().createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        }

        return this.Statement;
    }

    //*********************************** 
    public void preparaResultSet(final boolean pUSAR_STATEMENT, final String pSQL) throws SQLException, ClassNotFoundException, IOException {
        if (pUSAR_STATEMENT) {
            this.ResultSet = this.getStatement().executeQuery(pSQL);
        } else {
            this.ResultSet = this.getPreparedStatement(pSQL).executeQuery();
        }
    }

}
