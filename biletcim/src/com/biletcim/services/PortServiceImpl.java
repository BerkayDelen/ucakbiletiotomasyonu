package com.biletcim.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.biletcim.dao.PortsDAO;
import com.biletcim.entities.Port;

@Service
@Transactional
public class PortServiceImpl implements PortService {

	@Autowired
	private PortsDAO portsDAO;
	
	
	@Override
	@Transactional
	public Boolean addPortList(List<Port> ports) {
		// TODO Auto-generated method stub
		return portsDAO.addPortList(ports);
	}


	@Override
	@Transactional
	public Port getPortByShortName(String ShortName) {
		// TODO Auto-generated method stub
		return portsDAO.getPortByShortName(ShortName);
	}

}
