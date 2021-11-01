### 生成私钥，权限设置为600
umask 077; openssl genrsa -out lml.key 2048

### 创建证书签署请求，-subj选项中的CN的值将被kubeconfig作为用户名使用，O的值将被识别为用户组
openssl req -new -key lml.key -out lml.csr -subj "/CN=lml/O=kubernetes"

### 基于kubeadm安装Kubernetes集群时生成的CA签署证书，这里设置其有效时长为3650天
openssl x509 -req -in lml.csr -CA ca.crt -CAkey ca.key -CAcreateserial -out lml.crt -days 3650

### 查看证书
openssl x509 -in lml.crt -text -noout

### 添加用户到kubectl
kubectl config set-credentials lml --client-key=lml.key --client-certificate=lml.crt --embed-certs=true

### 使用用户
kubectl get pod --user lml
```
#没有权限
Error from server (Forbidden): pods is forbidden: User "lml" cannot list resource "pods" in API group "" in the namespace "default"
```