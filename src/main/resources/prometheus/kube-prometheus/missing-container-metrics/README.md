部署export并且添加对应的抓取目标和rule 监控oom容器重启次数

https://mp.weixin.qq.com/s/ZgNEuY9oj_6Y37cul8acXA

1. 添加repo helm repo add missing-container-metrics https://draganm.github.io/missing-container-metrics
2. helm pull missing-container-metrics/missing-container-metrics
3. tar -zxvf missing-container-metrics-0.1.1.tgz
4. 在template目录下创建文件podMonitor.yaml和prometheusRule.yaml
5. 修改对应的values.yaml
6. helm install missing-container-metrics -f values.yaml . --namespace xxx. 观察target和rule是否添加


