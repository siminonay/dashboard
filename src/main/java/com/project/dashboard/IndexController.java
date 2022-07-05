package com.project.dashboard;

import com.project.dashboard.dto.URLDto;
import com.project.dashboard.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Controller
public class IndexController {
    @GetMapping({"/", "/index"})
    public String index(Model model) {

//        Product[] obj = new Product[3];
//        obj[0] = new Product("Last 7 days",1041, 148.71);
//        obj[1] = new Product("Last 30 days",4669, 155.63);
//        obj[2] = new Product("All time",199828, 187.63);
//        model.addAttribute("allProducts", obj);

//        //BeforeSearch Controller
//        TinyDashboard data = new TinyDashboard();
//        //Mockdata
//
//        // 7days
//        Last7Days last7days = new Last7Days();
//        last7days.setTotalHits(Long.valueOf(1496));
//        last7days.setDates(new ArrayList<>(Arrays.asList("Jun,2023", "Jul,2023", "March,2023", "Jul,2023", "March,2023")));
//        last7days.setNumberOfAccess(new ArrayList<>(Arrays.asList(200, 150, 300, 240, 150, 210, 110)));
//        data.setLast7Days(last7days);
//
//        // 30days
//        Last30Days last30days = new Last30Days();
//        last30days.setTotalHits(Long.valueOf(3195));
//        last30days.setDates(new ArrayList<>(Arrays.asList("Jun,2023", "Jul,2023", "March,2023")));
//        last30days.setNumberOfAccess(new ArrayList<>(Arrays.asList(250, 100, 400, 300, 500, 750, 900)));
//        data.setLast30Days(last30days);
//
//        // Alltimedays
//        data.setAllTime(Long.valueOf(1171032));
//
//        //Bestday
//        BestDay bestDay = new BestDay();
//        bestDay.setClickCount(Long.valueOf(950));
//        bestDay.setDate(DateTimeFormatter.ofPattern("MMMM d,yyyy", new Locale("en")).format(LocalDateTime.now()));
//        data.setBestDay(bestDay);
//
//        //CreatedTime
//        data.setCreatedTime(DateTimeFormatter.ofPattern("MMMM d,yyyy", new Locale("en")).format(LocalDateTime.now()));
//
//
//        model.addAttribute("chartDateLast7Days", data.getLast7Days().getDates().stream().toArray(String[]::new));
//        model.addAttribute("chartDateLast30Days", data.getLast30Days().getDates().stream().toArray(String[]::new));
//        model.addAttribute("chartDateLast30DaysData", data.getLast30Days().getNumberOfAccess().stream().toArray(Integer[]::new));
//        model.addAttribute("chartDateLast7DaysData", data.getLast7Days().getNumberOfAccess().stream().toArray(Integer[]::new));
//
//        model.addAttribute("last7days", data.getLast7Days().getTotalHits());
//        model.addAttribute("last7daysPeriod", data.getLast7Days().getTotalHits() / 7);
//        model.addAttribute("last30days", data.getLast30Days().getTotalHits());
//        model.addAttribute("last30daysPeriod", data.getLast30Days().getTotalHits() / 30);
//
//        model.addAttribute("alltimedays", data.getAllTime());
//        model.addAttribute("alltimedaysPeriod", data.getAllTime() / 30);
//
//        model.addAttribute("bestdayCount", data.getBestDay().getClickCount());
//        model.addAttribute("bestday", " hits on " + data.getBestDay().getDate());
//
//        model.addAttribute("createdtime", "Short URL created on " + data.getCreatedTime());
//

        model.addAttribute("URLDto", new URLDto());

        return "index";
    }

    @GetMapping("/detail")
    public String getMockData(@ModelAttribute URLDto searchDto, BindingResult result, Model model){

        TinyDashboard data = new TinyDashboard();

        //Mockdata

        // 7days
        Last7Days last7days = new Last7Days();
        last7days.setTotalHits(Long.valueOf(1496));
        last7days.setDates(new ArrayList<>(Arrays.asList("Jun,2023", "Jul,2023", "March,2023", "Jul,2023", "March,2023")));
        last7days.setNumberOfAccess(new ArrayList<>(Arrays.asList(200, 150, 300, 240, 150, 210, 110)));
        data.setLast7Days(last7days);

        // 30days
        Last30Days last30days = new Last30Days();
        last30days.setTotalHits(Long.valueOf(3195));
        last30days.setDates(new ArrayList<>(Arrays.asList("Jun,2023", "Jul,2023", "March,2023")));
        last30days.setNumberOfAccess(new ArrayList<>(Arrays.asList(250, 100, 400, 300, 500, 750, 900)));
        data.setLast30Days(last30days);

        // Alltimedays
        data.setAllTime(Long.valueOf(1171032));

        //Bestday
        BestDay bestDay = new BestDay();
        bestDay.setClickCount(Long.valueOf(950));
        bestDay.setDate(DateTimeFormatter.ofPattern("MMMM d,yyyy", new Locale("en")).format(LocalDateTime.now()));
        data.setBestDay(bestDay);

        //CreatedTime
        data.setCreatedTime(DateTimeFormatter.ofPattern("MMMM d,yyyy", new Locale("en")).format(LocalDateTime.now()));

        //URL
        data.setURL(searchDto.getURL());

        model.addAttribute("TinyDashboard", data);

        return "detail";

    }
}