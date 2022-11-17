package com.ashutosh.wuhan.spring_covid_wuhanvirus.controllers;

import com.ashutosh.wuhan.spring_covid_wuhanvirus.models.LocationStats;
import com.ashutosh.wuhan.spring_covid_wuhanvirus.services.CoronaVirusDataService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    final
    CoronaVirusDataService coronavirusdataservice;

    public HomeController(CoronaVirusDataService coronavirusdataservice) {
        this.coronavirusdataservice = coronavirusdataservice;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<LocationStats> allStats = coronavirusdataservice.getAllStats();
        int totalCases = allStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
        int totalNewCases = allStats.stream().mapToInt(stat -> stat.getDiffFromPreviousDay()).sum();

        model.addAttribute("CovidTracker", "Covid WuhanVirus Tracker");
        model.addAttribute("locationStats", allStats);
        model.addAttribute("totalReportedCases", totalCases);
        model.addAttribute("totalNewCases", totalNewCases);

        return "home";
    }
}
