package com.project.dashboard.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class GenerateDays {
    private List<Integer> numberOfAccess;
    private List<String> dates;
    private Long totalHits;
}