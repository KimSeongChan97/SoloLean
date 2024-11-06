### 🏨 SpringHotel - README.md

---

**SpringHotel**은 **Spring Framework**와 **MySQL**을 기반으로 한 호텔 예약 및 관리 시스템입니다. 

고객에게는 간편한 호텔 객실 예약을, 관리자는 예약 및 고객 정보를 효율적으로 관리할 수 있는 시스템을 제공합니다. 주요 기능으로는 **소셜 로그인, 실시간 예약 시스템**, **객실 상세 정보 모달**, **리뷰 작성**, **QnA 기능**, 그리고 **회원가입 시 이메일 인증** 등이 포함되어 있습니다.

---

## 📋 프로젝트 개요

- **프로젝트 기간**: 2024.10.11 - 2024.10.21
- **팀 구성**: 3명
- **목표**: 고객에게 원활한 호텔 예약 경험을 제공하고, 관리자가 효율적으로 운영을 관리할 수 있는 시스템을 구축하는 것을 목표로 했습니다.


![멤버](https://github.com/user-attachments/assets/04399d60-099e-4b08-a353-03bee3ecb36e)

---

## 📂 프로젝트 구조
![기술_스택](https://github.com/user-attachments/assets/204e5907-1556-4454-9889-8b174eeb0c06)

---

## 🛠 주요 기능

1. **호텔 예약 시스템**
   - **실시간 객실 조회 및 필터링**: 사용자가 날짜, 인원(성인인, 어린이)의 조건으로 예약 가능한 객실을 실시간으로 조회 가능
   - **예약 기능**: 사용자가 원하는 객실을 선택 후, 예약 정보 확인하여 예약하며 예약 상태가 실시간으로 업데이트됨

2. **예약 내역**
   - **예약 내역 관리**: 사용자의 예약 상세 내역 확인 가능하며 객실 리뷰 화면으로 이동 가능함.
   - **사용자 등급**: 결제 내역 및 투숙 박수에 따른 사용자 등급 확인
                    - VIP (남색)
                          결제금액: 2000000 이상
   
4. **객실 상세 정보 모달**
   - **모달 창 구현**: 각 객실의 상세 정보(사진, 설명, 편의시설)를 제공하여 예약 전 충분한 정보 제공

5. **리뷰 및 평점 시스템**
   - **리뷰 작성 기능**: 고객이 이용한 객실에 대해 리뷰를 작성하고 평점을 남길 수 있음
   - **리뷰 목록 조회**: 다른 고객들의 후기를 확인할 수 있음

6. **회원가입 시 이메일 인증**
   - **API를 통한 이메일 인증**: 회원가입 시 인증 메일 발송 후 사용자가 계정 활성화를 완료해야 함
   - **Spring Security**와 연동된 인증 시스템

7. **로그인**
   - 소셜 로그인: 네이버 로그인
   - 일반 로그인
  
8. **QnA 시스템**
   - **QnA 작성 및 답변**: 고객은 호텔에 대한 문의를 할 수 있고, 관리자는 해당 질문에 답변을 제공

9. **관리자 시스템**
   - **예약 관리**: 관리자는 모든 예약을 조회하고, 예약 상태를 변경할 수 있음
   - **고객 관리**: 고객 정보를 조회 및 수정 가능
   - **객실 관리**: 객실 정보를 추가, 수정, 삭제할 수 있음

---

## ✨ 주요 화면

### 1. **메인 페이지**
- **메뉴**: 로그인 전, 후의 접근 가능 메뉴가 다름
- **호텔 사진**: 호텔 사진 슬라이더 구현함

 ![image](https://github.com/user-attachments/assets/4381ba87-fa89-4f50-984c-213b36b7cfbe)
 
---

### 2. **객실 상세 정보 모달**
- 선택한 객실의 **상세 설명**, 가격, 편의시설, 리뷰를 모달로 제공

![image](https://github.com/user-attachments/assets/d0dbe511-81d9-4802-989d-f910bf633848)

![image](https://github.com/user-attachments/assets/03daca86-090e-4d4b-9f06-f014f925c984)

![image](https://github.com/user-attachments/assets/77dab157-b85c-4bbe-bcde-84685f6feb83)

---

### 3. **예약 페이지**
- 날짜와 인원(성인, 어린이)의 조건으로 검색 후, 예약 가능 객실을 선택하여 예약 진행 및 최종 예약 요약 확인

![image](https://github.com/user-attachments/assets/2831ea4a-65cd-4979-a278-d3cd937131a9)

![image](https://github.com/user-attachments/assets/1f57b46f-f36c-497d-8c46-0b0395425c83)

![image](https://github.com/user-attachments/assets/7314e5f8-5c6a-43a9-8720-c1c7bbccedfa)

![image](https://github.com/user-attachments/assets/4acb5b71-4235-4e50-a7a1-6bcaeb304d33)

![image](https://github.com/user-attachments/assets/e07ca076-581d-4384-ba4c-aed62af66c74)

---

### 4. **회원가입 및 이메일 인증**
- 회원가입 시, 고객이 이메일 인증을 완료해야 계정이 활성화됨

![image](https://github.com/user-attachments/assets/a80d9803-ffec-4526-8809-f0177acd2ed9)

![image](https://github.com/user-attachments/assets/ed6598b9-d7de-43c8-a9f5-aee6a462d2c2)

---

### 5. **관리자 페이지**
- 예약 관리, 고객 정보 수정, 객실 관리 등을 실시간으로 처리 가능

---

## 결론 및 성과

**SpringHotel** 프로젝트는 효율적인 예약 및 관리 시스템을 구현하여 사용자가 원활하게 호텔 예약을 진행할 수 있도록 했습니다. **CI/CD** 파이프라인을 통해 지속적인 통합 및 자동 배포 환경을 구축했으며, 이메일 인증을 통한 보안 기능 강화로 신뢰성 높은 시스템을 제공했습니다.

---

## 🔗 프로젝트 링크

- [프로젝트 Notion 페이지](https://fresh-second-b8f.notion.site/241017_Spring-Hotel-11e42d6fe7d7801b9127dfdf9a6cc0c6)
- [GitHub 저장소](https://github.com/ujin302/SpringHotel)

---
