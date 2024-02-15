# 💌 My PB(Private Banker) Diary
## Private Banker가 사용하는 고객 및 이력관리 서비스
QR을 통해 고객을 PB정보 열람 가능 </br>
PB(Private Banker) 개인 고객에게 금융 상담 및 투자 관리 서비스를 제공하는 금융 전문가

## ✏️ 프로젝트 개요
> PB는 자신의 포트폴리오와 이력을 명함에 붙이거나 이력서 사이트를 제공함으로써 새로운 영업 환경과
> 기회를 제공하고 개인투자자들도 PB와 쉽게 contact하고 새로운 투자상품을 추천받을 수 있는 통합 자산관리 서비스입니다. </br>
> 또한, PB에게는 고객과 일정 관리 할 수 있는 페이지를 제공함으로써 맞춤형 서비스를 제공할 수 있습니다.


## 💫 프로젝트 기능
  ```
  1. 고객정보 관리
     각 고객에 대한 상세 페이지를 제공하여 포트폴리오, 수익률, 계좌 자산 등을 확인
  2. 캘린더 일정 관리
     고객과의 미팅 및 상담 일정 관리
  3. QR코드 생성 및 다운로드
     PB의 정보 페이지를 QR코드로 생성하고 명함에 붙일 수 있음
     따라서 PB가 활동하는 영업 시장을 넓히는 효과
  ```

## 👩‍👦‍👦 프로젝트 역할
```
- 안정민 : Figma 활용 UI 설계 및 FrontEnd 전체
- 고나형 : Cloud Architecture 설계 및 EKS 배포, CRUD API 개발
- 이재연 : Figma 활용 UI 설계 및 FrontEnd 전체
- 나영현 : ERD 설계, CRUD API 설계 및 개발
- 홍보영 : ERD 설계, CRUD API 설계 및 개
```


<div align="left">

### Tech Stack

**FE**

<img src="https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white">
<img src="https://img.shields.io/badge/css3-1572B6?style=for-the-badge&logo=css3&logoColor=white">
<img src="https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=white">
<img src="https://img.shields.io/badge/react-61DAFB?style=for-the-badge&logo=react&logoColor=white">

**UX·UI**

<img src="https://img.shields.io/badge/Figma-ae4dff?style=for-the-badge&logo=figma&logoColor=white">

**BE**

<img src="https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white">
<img src="https://img.shields.io/badge/JAVA 17-0058CC?style=for-the-badge&logoColor=white">
<img src="https://img.shields.io/badge/spring boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white">
<img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white">

**Infra**

<img src="https://img.shields.io/badge/NHNCloud-232F3E?style=for-the-badge&logo=nhn-cloud&logoColor=white">
<img src="https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white">
<img src="https://img.shields.io/badge/Kubernetes-326CE5?style=for-the-badge&logo=kubernetes&logoColor=white">

**CO-WORK**

[![GitHub](https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white)](https://github.com/)
[![Jira](https://img.shields.io/badge/Jira-0052CC?style=for-the-badge&logo=jira&logoColor=white)](https://www.atlassian.com/software/jira)
[![Notion](https://img.shields.io/badge/Notion-000000?style=for-the-badge&logo=notion&logoColor=white)](https://www.notion.so/)

</div>

## ERD
‼️ 정보계 시스템에 있는 DB table들을 최대한 고려하여 확장 가능한 형태로 DB 설계
![ERD](https://github.com/shs-g1/server/assets/89563433/e097ebca-f80b-48e0-b6a7-1bd5123bfefc)

## Infra
- NKS와 NCR을 Private Subnet에 구축하여 외부접근제한
![infra](https://github.com/shs-g1/server/assets/89563433/8c6baa12-64e1-4419-8e18-3a5bd5a2fe9a)

# 기능 소개
### 1. 로그인
- 회원가입은 진행하지 않음
- 기존에 등록되어 있는 PB 로그인 정보를 활용함
![로그인](https://github.com/shs-g1/server/assets/89563433/52d8f1b4-bada-431a-b51c-a54dc1b22d57)

## 2. PB 메인 페이지
- 캘린더 기능
  - 오늘 일정을 따로 확인 가능하며 + 버튼을 클릭하여 입력 모달창에 일정 입력 가능
  - 달력의 날짜를 클릭하면, 입력 모달창 열림
- 본인이 관리하는 고객 리스트 정보 조회
  - 고객의 수익률을 리스트로 확인 가능
  - 각 고객 리스트를 클릭하면 해당 고객의 상세 페이지로 이동
- 관리 고객의 수익률을 바탕으로 지금까지 누적된 인센티브 확인 가능
<div style="display: flex; justify-content: space-between;">
  <img src="https://github.com/shs-g1/server/assets/89563433/d1cacd32-9856-471d-a906-b5f46060b9c1" alt="메인 페이지" width="48%">
  <img src="https://github.com/shs-g1/server/assets/89563433/38ada06e-8c8b-4dbe-b797-ecc8faa169b6" alt="메인 페이지-일정추가" width="48%">
</div>

## 3. 고객 관리 페이지
- 고객 상세정보 확인 가능
- 상단의 네비게이션 탭으로 스크롤 이동 가능
- 고객의 포트폴리오 확인 가능
- 고객의 계좌별 수익률 확인 가능
- 전체 계좌 현황 및 잔고, 체결 내역 확인 가능
<div style="display: flex; justify-content: space-between;">
  <img src="https://github.com/shs-g1/server/assets/89563433/7956b14a-c92b-4471-8283-aad6f0c15ba2" alt="고객관리페이지1" width="48%">
  <img src="https://github.com/shs-g1/server/assets/89563433/3f9d71a3-d68b-494e-ad22-b2dd87893c69" alt="고객관리페이지2" width="48%">
</div>

## 4. My Profile 수정 페이지
- 개인정보 입력
  - 파일은 이미지 형식만 업로드 가능
  - 이메일은 도메인을 직접 선택할 수 있고 입력할 수 있음
  - 경력 및 학력은 추가와 삭제 버튼을 통해 수행됌
  - 전문 분야는 최대 3개까지 선택가능하며 자격증 정보 입력 가능
  - 자기소개 입력 창
- 등록하기 버튼으로 고객에게 보여질 QR코드를 확인하고 다운로드할 수 있음
![PB 정보 등록 페이지](https://github.com/shs-g1/server/assets/89563433/cc8175e8-3c88-4660-b095-c214fb297a8a)

## 5. PB 이력 및 포트폴리오 정보 제공 페이지
- PB가 입력한 정보 확인이 가능
- 포트폴리오 목록을 클릭하면 모달창 확인가능
- 모달창에 투자 포트폴리오의 상세 정보 확인 가능
  
‼️ 투자 포트폴리오는 PB 본인이 운용했던 투자 포트폴리오 내역을 보여줌

‼️ 해당 페이지는 앱 뷰 형태로 제작을 진행함(QR을 핸드폰으로 찍고 접속하는 경우)
<div style="display: flex; justify-content: space-between;">
  <img src="https://github.com/shs-g1/server/assets/89563433/8d84f78f-bdca-4ebc-9b91-70aee73e5dc0" alt="포트폴리오1" width="30%">
  <img src="https://github.com/shs-g1/server/assets/89563433/32a0cf98-fd92-403f-b754-3808f552131b" alt="포트폴리오2" width="30%">
  <img src="https://github.com/shs-g1/server/assets/89563433/de09e43d-71f4-4355-b292-db5992b18486" alt="포트폴리오 화면" width="30%">
</div>

## 🎀 시연 Test
![명함](https://github.com/shs-g1/server/assets/89563433/5e3ddc99-ad6e-4b35-ac48-2af449d15c4f)

# ⚙️ Conversion Rule

<h2>commit message</h2> 

- feat : 새로운 기능
- fix : 버그 수정
- docs : 문서 추가/수정
- test : 테스트 추가/수정
- build : 빌드 업무 수정, 패키지 매니저 수정
- refactor : 코드 리팩토링
- chore : 중요하지 않은 변경(코드 포맷팅, 세미콜론 누락, 코드 변경이 없는 경우, …)

<h2>📃 Branch 전략 </h2>
- github issue 활용
- PR Templete 지키기
- 기능별 Branch 만들기
- Dev 브랜치에 병합
