package com.limingliang.kubernetes.yaml.prometheus.metrics;

import io.prometheus.client.Collector;
import io.prometheus.client.GaugeMetricFamily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: limingliang
 * @Description:
 * @Date: 2021/4/21 13:14
 * Copyright (c) 2017, zaodao All Rights Reserved.
 */
public class Custom2Collector extends Collector {

    @Override
    public List<MetricFamilySamples> collect() {

        List<MetricFamilySamples> metricFamilySamplesList = new ArrayList<>();

        // With no labels
        metricFamilySamplesList.add(new GaugeMetricFamily("my_guage_2", "help", 42));

        // With labels
        GaugeMetricFamily gaugeMetricFamily = new GaugeMetricFamily("my_other_guage", "help", Arrays.asList("labelname"));
        gaugeMetricFamily.addMetric(Arrays.asList("foo"), 4);
        gaugeMetricFamily.addMetric(Arrays.asList("bar"), 5);
        metricFamilySamplesList.add(gaugeMetricFamily);

        return metricFamilySamplesList;
    }
}
