package com.biletcim.dao;

import java.util.List;

import com.biletcim.entities.Port;

public interface PortsDAO {
	public Boolean addPortList(List<Port> port);
	
	public Port getPortByShortName(String ShortName);
}
