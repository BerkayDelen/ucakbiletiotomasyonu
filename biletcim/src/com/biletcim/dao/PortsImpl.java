package com.biletcim.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.biletcim.configs.Config;
import com.biletcim.entities.Company;
import com.biletcim.entities.Port;
import com.biletcim.entities.Ticket;
import com.biletcim.entities.User;

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

	public Port getPortByShortName(String ShortName) {
		 Port port = null;
		
		String sql = "SELECT City  from ports where Code = ? ";
		
		try {
			Config.OpenDB(sql);
		Config.stmt.setString(1,ShortName);
		
		
		ResultSet rs =	Config.stmt.executeQuery();
   while(rs.next()){
      //Retrieve by column name
	  port = new Port("",ShortName,rs.getString("City"),"",0,0);
     
      System.out.println("Country : " + rs.getString("City"));
     
   }
   rs.close();
	
   Config.CloseDB();
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		

		return port;
	}

	@Override
	public List<Port> getPorts() {
		List<Port> Ports = new ArrayList<Port>();
		
		String getSession = "SELECT * from ports where portName <>''  order by PortName ASC";

		try {

			Config.OpenDB(getSession);

			
			ResultSet rs = Config.stmt.executeQuery();
			while (rs.next()) { 
			      String portName = "";
			      String code = "";
			      String city = "";
			      String country = "";
			      double coordinateLatitude = 0;
			      double coordinateLongitude= 0;
			      
			      portName = rs.getString("PortName");
			      code = rs.getString("Code");
			      city = rs.getString("City");
			      country = rs.getString("Country");
			      
			      
			      coordinateLatitude = Double.parseDouble(rs.getString("coordinateLatitude"));
			      coordinateLongitude = Double.parseDouble(rs.getString("coordinateLongitude"));
			      Port port = new Port(portName, code, city, country, coordinateLatitude, coordinateLongitude);
			      Ports.add(port);

			}
			rs.close();

			Config.CloseDB();

		} catch (SQLException e) {

			System.out.println("HATA  Session Create Read Data in:" + e.getMessage());

		}
		
		return Ports;
	}
}
