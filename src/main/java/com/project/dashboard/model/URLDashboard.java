package com.project.dashboard.model;

import lombok.Data;

@Data
public class URLDashboard {
    private String createdTime;
    private Last7Days last7Days;
    private Last30Days last30Days;
    private Long allTime;
    private BestDay bestDay;
    private String URL;
}