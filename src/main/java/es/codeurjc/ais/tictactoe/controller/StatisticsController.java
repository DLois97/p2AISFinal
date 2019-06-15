package es.codeurjc.ais.tictactoe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import es.codeurjc.ais.tictactoe.service.StatisticsService;

@Controller
public class StatisticsController {
	@Autowired
	private StatisticsService statisticsService;
	@RequestMapping("/stats")
	public String verEstadisticas(Model model) {
		model.addAttribute("estadisticas", statisticsService.getEstadisticas());
		return "stats";
	}
	

}
