
1. 下载calicoctl, 授予权限chmod +x calicoctl, 将其移动到/usr/local/bin中.
2. 默认指标是关闭的。需要手动开启.calicoctl patch felixConfiguration default  --patch '{"spec":{"prometheusMetricsEnabled": true}}'.
3. curl -s http://localhost:9091/metrics 查看指标
4. 添加felix和kube-controllers的指标采集. 
5. 添加对应的图表grafana-dashboard-calico-felix
