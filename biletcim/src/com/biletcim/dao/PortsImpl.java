package com.biletcim.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.biletcim.configs.Config;
import com.biletcim.entities.Port;

@Repository
public class PortsImpl implements PortsDAO {

	@Override
	public Boolean addPortList(List<Port> port) {
		// TODO Auto-generated method stub
		
		Boolean durum = false;
		
		String sql = "INSERT INTO `dbbiletcim`.`ports` (`PortName`, `Code`, `City`, `Country`, `CoordinateLatitude`, `CoordinateLongitude`) VALUES (?, ?, ?, ?, ?, ?);\r\n" + 
				"";
		
					try {
						
						int rs = 0;
						Config.OpenDB(sql);
						for (int index = 0; index < port.size(); index++) {
							
							Config.stmt.setString(1,port.get(index).getPortName());
							Config.stmt.setString(2,port.get(index).getCode());
							Config.stmt.setString(3,port.get(index).getCity());
							Config.stmt.setString(4,port.get(index).getCountry());
							
							Config.stmt.setDouble(5,port.get(index).getCoordinateLatitude());
							Config.stmt.setDouble(6,port.get(index).getCoordinateLongitude());
							System.out.println("la"+port.get(index).getCoordinateLatitude());
							System.out.println("lng"+port.get(index).getCoordinateLongitude());
							
							rs =	Config.stmt.executeUpdate();
							System.out.println(rs+" Eklendi.");
							
						}
					
			   
			   
			   durum = true;
				
			   Config.CloseDB();
					} catch (SQLException e) {
						
						e.printStackTrace();
						durum = null;
					}
					
		
					return durum;

	}

}
