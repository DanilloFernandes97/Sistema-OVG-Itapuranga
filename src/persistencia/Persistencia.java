package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import conexao.Conexao;
import java.io.IOException;

public class Persistencia {
    
	private PreparedStatement PreparedStatement;
	private ResultSet ResultSet;

	public PreparedStatement getPreparedStatement(final String pSQL) throws ClassNotFoundException, SQLException, IOException {

		if (this.PreparedStatement == null) {
			this.preparaPreparedStatement(pSQL);
		}

		return this.PreparedStatement;
	}
	
	private void preparaPreparedStatement(final String pSQL) throws SQLException, ClassNotFoundException, IOException {

		if (pSQL.trim().isEmpty() || (pSQL == null)) {
			throw new SQLException("Parâmetro SQL vazio");
		} else {
			this.PreparedStatement =  Conexao.getConexao().prepareStatement(pSQL,
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
    
}