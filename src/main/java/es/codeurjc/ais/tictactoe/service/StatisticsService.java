package es.codeurjc.ais.tictactoe.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import es.codeurjc.ais.tictactoe.*;

@Service("statisticsService") 
public class StatisticsService {
	private List<Estadistics> estadisticas = new ArrayList<Estadistics>();
	
	public boolean insertarEstadisticas(Estadistics est) {
		for (Estadistics e: estadisticas) {
			if (e.getNombre().equals(est.getNombre())) {
				e.setGanadas(est.getGanadas());
				e.setPerdidas(est.getPerdidas());
				e.setEmpatadas(est.getEmpatadas());
				return true;
			}
		}
		estadisticas.add(est);
		return true;
	}
	public boolean aumentarEstadisticas(String nombre,int caso) {
		if (estadisticas.size()!=0) {	
			for (Estadistics e: estadisticas) {
				if (e.getNombre().equals(nombre)) {
					switch (caso) {
					case 0:
						e.setGanadas(e.getGanadas()+1);
						break;
					case 1:
						e.setPerdidas(e.getPerdidas()+1);
						break;
					case 2:
						e.setEmpatadas(e.getEmpatadas()+1);
						break;
					}
					return true;
				} else {
					int ganadas = 0;
					int perdidas = 0;
					int empatadas = 0;
					switch (caso) {
					case 0:
						ganadas++;
						break;
					case 1:
						perdidas++;
						break;
					case 2:
						empatadas++;
						break;
					}
					Estadistics est = new Estadistics(nombre,ganadas, perdidas, empatadas);
					estadisticas.add(est);
					return true;
				}
			}
		} else {
		int ganadas = 0;
		int perdidas = 0;
		int empatadas = 0;
		switch (caso) {
		case 0:
			ganadas++;
			break;
		case 1:
			perdidas++;
			break;
		case 2:
			empatadas++;
			break;
		}
		Estadistics est = new Estadistics(nombre,ganadas, perdidas, empatadas);
		estadisticas.add(est);
		}
		return true;
		
	}
	public List<Estadistics> getEstadisticas() {
		return estadisticas;
	}
	public void setEstadisticas(List<Estadistics> estadisticas) {
		this.estadisticas = estadisticas;
	}

	
}
