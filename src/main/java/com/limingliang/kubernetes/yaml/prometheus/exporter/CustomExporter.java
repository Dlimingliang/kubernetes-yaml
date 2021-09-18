package com.limingliang.kubernetes.yaml.prometheus.exporter;

import com.limingliang.kubernetes.yaml.prometheus.metrics.Custom2Collector;
import com.limingliang.kubernetes.yaml.prometheus.metrics.CustomCollector;
import io.prometheus.client.exporter.HTTPServer;
import io.prometheus.client.hotspot.DefaultExports;

import java.io.IOException;

/**
 * @Auther: limingliang
 * @Description:
 * @Date: 2021/4/21 13:54
 * Copyright (c) 2017, zaodao All Rights Reserved.
 */
public class CustomExporter {

    public static void main(String[] args) throws IOException {

        new CustomCollector().register();
        new Custom2Collector().register();
        DefaultExports.initialize();
        HTTPServer httpServer = new HTTPServer(1234);
    }
}
