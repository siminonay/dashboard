package com.project.dashboard.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data


public class TinyDashboard {

    private String createdTime;
    private Last7Days last7Days;
    private Last30Days last30Days;
    private Long allTime;
    private BestDay bestDay;
    private String URL;

}