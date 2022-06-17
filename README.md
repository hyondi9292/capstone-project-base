# 캡스톤 프로젝트 환경

```
브레인스토밍 https://labs.msaez.io/#/courses/cna-full/be513ff0-e2d5-11ec-b71d-f90e603c5333/capstone-team/alphamega89@naver.com
https://labs.msaez.io//#/home/project/msalogin/alphamega89@naver.com


5.로그인 (원장분리)


기능적 요구사항

1.아이디/패스워드 기반으로 로그인한다.
2. 정상 고객인지 확인한다. 
3. 아이디와 패스워드  일치하는지 확인한다. 
4. 해당 고객의 계좌와 잔액을 불러온다. 
5. 로그인이 완료된다. 
6. 자신의 계좌와 잔액 정보를 확인할 수 있다. 



비기능적 요구사항
1. 트랜잭션
- 회원상태가 정상인 경우에 로그인 할 수있다. 
- 아이디/비밀번호가 일치하는 경우에 로그인 할 수 있다. 


2. 장애격리

상품 및 수신 서비스가 장애이더라도, 로그인은 정상적으로 되어야한다.(365일 24시간 받을 수 있어야 한다(상품처리서비스가 죽더라도,,)

성능

상품서비스가 불안정 하더라도 손님은 자신의 계좌와 최근 잔액 상태를 조회할 수있어한다. 





1. Fork (내 저장소로 환경 복제)
이 Repo 를 먼저 Fork 합니다. github 의 우상단 Fork를 클릭

1. 본인의 레포지토리를 확인
e.g. github.com/내계정/capstone-project-base

1. Gitpod 로 접속
본인의 레포지토리 주소 앞에 "gitpod.io/#" 을 넣고 접속 
```
https://gitpod.io/#https://github.com/alphamega89/capstone-project-base
```
1. VS Code 접속 및 Language Server 확인
- VS Code 접속 후, store-domain > main > java 내의 Java 파일을 하나 Open
- Java Language Server 가 기동되는 것을 꼭 확인
- Java Language Support 플러그인을 설치한다는 메시지에 꼭 "Install" 해줄것
- 혹시 Reload Window, Restart Now 하겠다는 메시지가 들어오면 그것도 수락


## 오리엔테이션
https://www.youtube.com/embed/u-C1mrSUAjg


### 평가 항목
https://workflowy.com/s/c10811dfdb67/UhOZB2crKOhNPUYp


## 로컬 유틸리티 설치

- httpie (curl / POSTMAN 대용)
```
pip install httpie
```

- Kafka (by docker)
```
cd kafka
docker-compose up -d     # docker-compose 가 모든 kafka 관련 리소스를 받고 실행할 때까지 기다림
```
 Kafka 정상 실행 확인
```
$ docker-compose logs kafka | grep -i started    

kafka-kafka-1  | [2022-04-21 22:07:03,262] INFO [KafkaServer id=1] started (kafka.server.KafkaServer)
```
Kafka consumer 접속
```
docker-compose exec -it kafka /bin/bash   # kafka docker container 내부 shell 로 진입

[appuser@e23fbf89f899 bin]$ cd/bin
[appuser@e23fbf89f899 bin]$ ./kafka-console-consumer --bootstrap-server localhost:9092 --topic petstore
```
> Docker compose 를 이용한 kafka 는 29090 으로 접속해야 합니다. 따라서 application.yml 의 broker 설정의 포트넘버 수정 (9092 -> 29092)이 필요합니다.

- Kafka local installation 

Download
```
wget https://dlcdn.apache.org/kafka/3.1.0/kafka_2.13-3.1.0.tgz
tar -xf kafka_2.13-3.1.0.tgz
```

Run Kafka
```
cd kafka_2.13-3.1.0/
bin/zookeeper-server-start.sh config/zookeeper.properties &
bin/kafka-server-start.sh config/server.properties &
```

Kafka Event 컨슈밍하기 (별도 터미널)
```
cd kafka_2.13-3.1.0/
bin/kafka-console-consumer.sh --bootstrap-server 127.0.0.1:9092 --topic petstore
```

## 클라우드 관련 유틸리티

- kubectl 설치
https://kubernetes.io/docs/tasks/tools/install-kubectl-linux/

- awscli 설치
https://docs.aws.amazon.com/ko_kr/cli/latest/userguide/getting-started-install.html

- eksctl 설치
https://docs.aws.amazon.com/ko_kr/eks/latest/userguide/eksctl.html

## 쿠버네티스 

### Helm(패키지 인스톨러) 설치
- Helm 3.x 설치
```bash
curl https://raw.githubusercontent.com/helm/helm/master/scripts/get-helm-3 > get_helm.sh
chmod 700 get_helm.sh
./get_helm.sh
```

#### Kafka 설치
```bash
helm repo update
helm repo add bitnami https://charts.bitnami.com/bitnami
helm install my-kafka bitnami/kafka
```

#### Nginx ingress 설치
https://www.ibm.com/docs/ko/control-desk/7.6.1.x?topic=kubernetes-installing-nginx-ingress-controller-in-cluster
```bash
helm upgrade --install ingress-nginx ingress-nginx \
  --repo https://kubernetes.github.io/ingress-nginx \
  --namespace ingress-nginx --create-namespace
```

## 자주 쓰는 명령
- 포트 확인 및 점유 프로세스 삭제
```bash
cmd(포트확인) : netstat -lntp | grep :808 
tcp        0      0 0.0.0.0:8080            0.0.0.0:*               LISTEN      3752/java           
tcp        0      0 0.0.0.0:8081            0.0.0.0:*               LISTEN      3109/java           
cmd : kill -9 3109  <-- 해당 pid
모든 점유 프로세스 삭제 : kill -9 `netstat -lntp|grep 808|awk '{ print $7 }'|grep -o '[0-9]*'`
```

- httpie pod 생성
https://github.com/TheOpenCloudEngine/uEngine-cloud/wiki/Httpie-%EC%84%A4%EC%B9%98


- siege pod 생성
https://github.com/JoeDog/siege.git
