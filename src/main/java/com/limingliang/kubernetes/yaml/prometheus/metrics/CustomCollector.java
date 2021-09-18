package com.limingliang.kubernetes.yaml.prometheus.metrics;

import io.prometheus.client.Collector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: limingliang
 * @Description:
 * @Date: 2021/4/21 13:14
 * Copyright (c) 2017, zaodao All Rights Reserved.
 */
public class CustomCollector extends Collector {

    @Override
    public List<MetricFamilySamples> collect() {

        List<MetricFamilySamples> metricFamilySamplesList = new ArrayList<>();

        String metricName = "my_guage_1";

        //Your code to get metrics
        MetricFamilySamples.Sample sample = new MetricFamilySamples.Sample(metricName,
            Arrays.asList("l1"), Arrays.asList("v1"), 4);
        MetricFamilySamples.Sample sample2 = new MetricFamilySamples.Sample(metricName,
            Arrays.asList("l1", "l2"), Arrays.asList("v1", "v2"), 3);

        MetricFamilySamples metricFamilySamples = new MetricFamilySamples(metricName, Type.GAUGE, "help",
            Arrays.asList(sample, sample2));

        metricFamilySamplesList.add(metricFamilySamples);
        return metricFamilySamplesList;
    }
}
