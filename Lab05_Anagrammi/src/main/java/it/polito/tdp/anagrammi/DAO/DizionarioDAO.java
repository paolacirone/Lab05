package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DizionarioDAO {

	public boolean esisteNelDizionario(String parola) {

		String sql = "SELECT ? FROM parola WHERE nome=?";

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, parola);
			st.setString(2, parola);
			ResultSet rs = st.executeQuery();

			// se c'è un valore nel result next
			if (rs.next()) {
				conn.close();
				return true;
			} else
				return false;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}
