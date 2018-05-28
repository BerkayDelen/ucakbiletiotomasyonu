package com.biletcim.services;

import java.util.List;
import com.biletcim.entities.Port;

public interface PortService {
	public List<Port> getPorts();
	public Boolean addPortList(List<Port> port);
	public Port getPortByShortName(String ShortName);
}
