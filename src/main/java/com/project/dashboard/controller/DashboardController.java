package com.project.dashboard.controller;

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
public class DashboardController {

    @GetMapping({"/", "/index"})
    public String index(Model model) {
        model.addAttribute("URLDto", new URLDto());
        return "index";
    }

    @GetMapping("/detail")
    public String getMockData(@ModelAttribute URLDto searchDto, BindingResult result, Model model){

        URLDashboard data = new URLDashboard();

        //Mock Datas

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

        // All
        data.setAllTime(Long.valueOf(1171032));

        //Best
        BestDay bestDay = new BestDay();
        bestDay.setClickCount(Long.valueOf(950));
        bestDay.setDate(DateTimeFormatter.ofPattern("MMMM d,yyyy", new Locale("en")).format(LocalDateTime.now()));
        data.setBestDay(bestDay);

        //CreatedTime
        data.setCreatedTime(DateTimeFormatter.ofPattern("MMMM d,yyyy", new Locale("en")).format(LocalDateTime.now()));

        //URL
        data.setURL(searchDto.getURL());

        model.addAttribute("URLDashboard", data);

        return "detail";

    }
}