-- 18개의 랜덤 회원 레코드 생성
BEGIN
  FOR i IN 1..18 LOOP
    INSERT INTO MEMBER (
      MEMBER_ID,
      MEMBER_PW,
      MEMBER_NICK,
      MEMBER_EMAIL,
      MEMBER_TEL,
      ENROLL_DT,
      PROMOTION_FL,
      DELETED_FL
    ) VALUES (
      'user' || TO_CHAR(i + 4, 'FM00'),    -- 'USER05'부터 시작하여 'USER44'까지 순차적으로 생성 (MEMBER_ID)
      '1',                                  -- 모든 회원의 비밀번호를 '1'로 설정 (MEMBER_PW)
      DBMS_RANDOM.STRING('U', 6),           -- 랜덤 대문자 문자열 (MEMBER_NICK)
      DBMS_RANDOM.STRING('L', 8) || '@example.com',  -- 랜덤 이메일 (MEMBER_EMAIL)
      TO_CHAR(FLOOR(DBMS_RANDOM.VALUE(1000000000, 9999999999)), 'FM0000000000'),  -- 랜덤 전화번호 (MEMBER_TEL)
      SYSDATE,                              -- 현재 날짜 및 시간 (ENROLL_DT)
      DEFAULT,                              -- PROMOTION_FL의 기본값 사용
      DEFAULT                               -- DELETED_FL의 기본값 사용
    );
  END LOOP;
  COMMIT;
END;
/

-- 18개의 랜덤 RESUME 레코드 생성
BEGIN
  FOR i IN 1..18 LOOP
    INSERT INTO RESUME (
      MEMBER_ID,
      "POSITION",
      EXPR_PERIOD,
      EMPL_TYPE,
      EMPL_LOCATION,
      SALARY_EXPECT,
      FIELD
    ) VALUES (
      'user' || TO_CHAR(i + 4, 'FM00'),  -- 'USER05'부터 시작하여 'USER44'까지 순차적으로 생성 (MEMBER_ID)
      CASE
        WHEN DBMS_RANDOM.VALUE < 0.5 THEN '프론트엔드 개발자'
        ELSE '백엔드 개발자'
      END,                                   -- '프론트엔드 개발자' 또는 '백엔드 개발자' 랜덤 선택 (POSITION)
      TO_CHAR(TRUNC(DBMS_RANDOM.VALUE(1, 10)), 'FM0'),  -- 1부터 10까지 랜덤 경력 기간 (EXPR_PERIOD) - 숫자 형식
      CASE
        WHEN DBMS_RANDOM.VALUE < 0.33 THEN '사무실 출근'
        WHEN DBMS_RANDOM.VALUE < 0.67 THEN '재택'
        ELSE '하이브리드'
      END,                                   -- '사무실 출근', '재택', 또는 '하이브리드' 랜덤 선택 (EMPL_TYPE)
      CASE
        WHEN DBMS_RANDOM.VALUE < 0.2 THEN '서울 종로'
        WHEN DBMS_RANDOM.VALUE < 0.4 THEN '서울 구로'
        WHEN DBMS_RANDOM.VALUE < 0.6 THEN '서울 강남'
        WHEN DBMS_RANDOM.VALUE < 0.8 THEN '서울 성동'
        ELSE '판교'
      END,                                   -- 주어진 옵션 중 하나를 랜덤으로 선택 (EMPL_LOCATION)
      CASE
        WHEN DBMS_RANDOM.VALUE < 0.2 THEN 2700
        WHEN DBMS_RANDOM.VALUE < 0.4 THEN 3000
        WHEN DBMS_RANDOM.VALUE < 0.6 THEN 3500
        WHEN DBMS_RANDOM.VALUE < 0.8 THEN 4000
        ELSE 5000
      END,                                   -- 주어진 옵션 중 하나를 랜덤으로 선택 (SALARY_EXPECT)
      CASE
        WHEN DBMS_RANDOM.VALUE < 0.33 THEN 'java'
        WHEN DBMS_RANDOM.VALUE < 0.67 THEN 'javascript'
        ELSE 'jquery'
      END                                   -- 'java', 'javascript', 또는 'jquery' 중 랜덤 선택 (FIELD)
    );
  END LOOP;
  COMMIT;
END;
/

BEGIN
  FOR i IN 1..18 LOOP
    INSERT INTO COMPANY (
      CMPN_NO,
      MEMBER_ID,
      CMPN_NM,
      CMPN_ADDR,
      CMPN_LOGO,
      CMPN_INTRO,
      CMPN_MCOUNT,
      CMPN_FL,
      CMPN_HP
    ) VALUES (
      SEQ_CMPN_NO.NEXTVAL, -- CMPN_NO
      'user' || TO_CHAR(i + 4, 'FM00'), -- MEMBER_ID
      
        CASE-- CMPN_LOGO
        WHEN i = 1 THEN '핑거랩스'
        WHEN i = 2 THEN '아이오트러스트'
        WHEN i = 3 THEN '넛지헬스케어(캐시워크)'
        WHEN i = 4 THEN '링글잉글리시'
        WHEN i = 5 THEN '에타일렉트로닉스'
        WHEN i = 6 THEN '테스트뱅크'
        WHEN i = 7 THEN '캔랩코리아'
        WHEN i = 8 THEN '(주)티디아이'
        WHEN i = 9 THEN '(주)이지시큐' -- CMPN_MCOUNT
        WHEN i = 10 THEN '스마일드래곤'
        WHEN i = 11 THEN '아이페이지온'
        WHEN i = 12 THEN '클라썸'
        WHEN i = 13 THEN '에이클로젯'
        WHEN i = 14 THEN '그린랩스'
        WHEN i = 15 THEN '토기'
        WHEN i = 16 THEN '네오사피엔스'
        WHEN i = 17 THEN '크레비스파트너스'
        WHEN i = 18 THEN '로그프레소'
        ELSE NULL
      END,
      
      CASE 
        WHEN DBMS_RANDOM.VALUE < 0.25 THEN '서울 강남'
        WHEN DBMS_RANDOM.VALUE < 0.5 THEN '서울 성동' -- CPMN_ADDR
        WHEN DBMS_RANDOM.VALUE < 0.75 THEN '서울 종로'
        ELSE '서울 구로'
      END,
    
      CASE-- CMPN_LOGO
        WHEN i = 1 THEN '/resources/images/recruit/FingerLabs.png'   
        WHEN i = 2 THEN '/resources/images/recruit/ioTrust.png'
        WHEN i = 3 THEN '/resources/images/recruit/cashwalk.png'
        WHEN i = 4 THEN '/resources/images/recruit/ringle.png'
        WHEN i = 5 THEN '/resources/images/recruit/etaelec.png'
        WHEN i = 6 THEN '/resources/images/recruit/testbank.png'
        WHEN i = 7 THEN '/resources/images/recruit/canlab.png'
        WHEN i = 8 THEN '/resources/images/recruit/tdi.png'
        WHEN i = 9 THEN '/resources/images/recruit/aegisecu.png' -- CMPN_MCOUNT
        WHEN i = 10 THEN '/resources/images/recruit/smiledragon.png'
        WHEN i = 11 THEN '/resources/images/recruit/ipageon.jpg'
        WHEN i = 12 THEN '/resources/images/recruit/classum.png'
        WHEN i = 13 THEN '/resources/images/recruit/acloset.png'
        WHEN i = 14 THEN '/resources/images/recruit/greenlabs.png'
        WHEN i = 15 THEN '/resources/images/recruit/togi.jpg'
        WHEN i = 16 THEN '/resources/images/recruit/typecast.jpg'
        WHEN i = 17 THEN '/resources/images/recruit/crevisse.png'
        WHEN i = 18 THEN '/resources/images/recruit/logpresso.png'
        ELSE NULL
      END,
      CASE
        WHEN i = 1 THEN '핑거랩스(Fingerlabs)는, 온라인과 오프라인, 기성산업과 신산업을 연결하는 웹 3.0 전문기업으로, 다양한 산업에서 쉽게 Web3.0 를 도입할 수 있도록 지원하는 온·오프라인 고객 관리 솔루션 ‘페이버렛’, 웹 3.0 콘텐츠 유통 허브 ‘엑스클루시브’, 국내 대표 PFP NFT 프로젝트 ’선미야클럽’을 운영하고 있습니다.'
        WHEN i = 2 THEN '아이오트러스트(IOTrust)는 Web 3.0 시대에 사용자가 더 쉽고, 더 안전하게 블록체인 서비스를 누릴 수 있는 지갑을 만들고자 합니다. 대한민국 블록체인 산업을 선도하고 있는 아이오트러스트는 2018년 지문인증형 지갑을 시작으로 50여 개 이상의 메인넷을 지원하는 소프트웨어 지갑, 언제 어디서든 이용할 수 있는 카드 타입형 지갑을 선보이며 빠르게 성장했습니다.'
        WHEN i = 3 THEN '캐시워크(CashWalk)는 사용자의 건강행태에 동기를 부여해 비만, 당뇨, 고혈압 등 만성질환을 관리 및 예방할 수 있도록 돕는 서비스입니다.'
        WHEN i = 4 THEN '링글잉글리시(Ringle)는 아이비리그 등 영미권 명문대 출신 원어민 강사와 실시간으로 대화할 수 있는 화상영어 플랫폼입니다.'
        WHEN i = 5 THEN '에타일렉트로닉스(Eta Electronics)는 차세대 무선전력전송 솔루션 Eta-ON을 개발하고 있는 전기전자 테크 스타트업입니다.'
        WHEN i = 6 THEN '테스트뱅크(TestBank)는 학생들의 가방을 가볍게 만들어주자 라는 미션을 가지고 이를 해결하기 위해 문제집, 참고서 등의 종이책을 디지털컨텐츠로 변환 시켜주는 인공지능 개발과 태블릿, PC, 모바일 등으로 문제풀고 공부 할 수 있는 서비스를 개발하고 있습니다.'
        WHEN i = 7 THEN '캔랩코리아(CanLab Korea)는 인터넷/모바일 커뮤니티 플랫폼 구축을 위해 필요한 제반 툴을 SaaS (Software-as-a-Service) 방식으로 제공합니다.'
        WHEN i = 8 THEN 'TDI그룹(TDI Group)은 대한민국의 빅데이터 분석 NO1 전문 기업으로, 2011년 설립 이래 다양한 업종 및 고객의 독보적인 Data Analysis를 선도적으로 리딩해왔으며 4차 산업혁명을 견인하는 빅데이터 분야의 IT 기술력을 기반으로 다양한 비즈니스 영역에서 가장 혁신적으로 도약할 수 있는 통찰력을 제공하고 있는 기업입니다.'
        WHEN i = 9 THEN '이지시큐(EasySecu)는 진보, 진화된 정보보호 컨설팅을 연구, 지향하며 컴플라이언스 기준과 고객의 만족을 모두 충족시키기 위한 최적의 컨설팅을 제공합니다.'
        WHEN i = 10 THEN '스마일드래곤(SmileDragon)은 Creative한 디자인과 높은 개발 기술력을 보유하고 있는 마케팅 전문 기업입니다.'
        WHEN i = 11 THEN '아이페이지온(IPAGEON)은 ICT 솔루션으로 사람과 사람을 잇는 기업입니다. 주요 사업 영역으로는 코어망, 기업형 커뮤니케이션, 산업용 loT 솔루션을 제공하며, 해당 분야에서 다년간 축적한 기술력을 바탕으로 국내외 120여개의 기업과 파트너쉽을 맺어 최적의 솔루션을 제공하고 있습니다.'
        WHEN i = 12 THEN '클라썸(Classum)은 교육 및 지식 공유 플랫폼입니다.' -- CMPN_INTRO
        WHEN i = 13 THEN '에이클로젯(Acloset)는 문제집, 참고서 등의 종이책을 디지털 컨텐츠로 변환시켜주는 인공지능 서비스를 제공합니다.'
        WHEN i = 14 THEN '그린랩스(Greenlabs)는 농사짓는 과정에서 불편했던 경험과 어려움에 주목하여 농창업을 시작으로 인류 먹거리와 환경에 이르기까지 농업 관계자를 위한 모든 솔루션을 디지털화 하여 제공합니다.'
        WHEN i = 15 THEN '토기(Togi)는 21세기 기술 혁신의 시대에 걸맞는 새로운 "식(食)"의 혁명을 주도하려는 비전을 품고 있으며, 유수 투자자들로부터 투자를 유치한 스타트업입니다.'
        WHEN i = 16 THEN '네오사피엔스(Neosapiens)는 음성·언어 분야의 인공지능 원천기술을 개발하고 있으며, 인공지능 성우 서비스 타입캐스트로 사랑받고 있습니다.'
        WHEN i = 17 THEN '크레비스파트너스(Crevisse Partners)는 온라인모금, 지능형결제, 마케팅자동화 등을 통해 비즈니스와 고객 데이터를 연결하는 CRM을 제공합니다.'
        WHEN i = 18 THEN '로그프레소(Logpresso)는 보안운영(SecOps) 플랫폼 전문 기업으로, 로그관리, 보안관제, 보안운영자동화 플랫폼을 공급합니다.'
        ELSE NULL
      END,
        CASE 
        WHEN i = 1 THEN 57
        WHEN i = 2 THEN 35
        WHEN i = 3 THEN 155
        WHEN i = 4 THEN 77
        WHEN i = 5 THEN 15
        WHEN i = 6 THEN 10
        WHEN i = 7 THEN 50
        WHEN i = 8 THEN 50
        WHEN i = 9 THEN 20 -- CMPN_MCOUNT
        WHEN i = 10 THEN 20
        WHEN i = 11 THEN 120
        WHEN i = 12 THEN 10
        WHEN i = 13 THEN 26
        WHEN i = 14 THEN 129
        WHEN i = 15 THEN 6
        WHEN i = 16 THEN 63
        WHEN i = 17 THEN 76
        WHEN i = 18 THEN 53
        ELSE NULL
      END,
      'Y', -- CMPN_FL
        CASE 
        WHEN i = 1 THEN 'https://fingerlabs.io/'
        WHEN i = 2 THEN 'https://career.iotrust.kr/'
        WHEN i = 3 THEN 'https://cashwalk12.career.greetinghr.com/'
        WHEN i = 4 THEN 'https://www.ringleplus.com/ko/student/landing/home'
        WHEN i = 5 THEN 'https://etaelec.com/'
        WHEN i = 6 THEN 'https://www.testbank.ai/'
        WHEN i = 7 THEN 'https://www.canlab.co/'
        WHEN i = 8 THEN 'https://tdi9.com/tdi-city'
        WHEN i = 9 THEN 'www.aegisecu.com' -- CMPN_HP
        WHEN i = 10 THEN 'https://www.smiledragon.co.kr/'
        WHEN i = 11 THEN 'http://www.ipageon.com/'
        WHEN i = 12 THEN 'https://www.classum.com/ko/'
        WHEN i = 13 THEN 'https://ko.acloset.app/'
        WHEN i = 14 THEN 'https://greenlabs.co.kr/'
        WHEN i = 15 THEN 'https://togi.co/'
        WHEN i = 16 THEN 'https://typecast.ai/kr?utm_source=google&utm_medium=cpc&utm_campaign=kr_23_search_brand&utm_content=pc_brand_rsa_001&utm_term=%EB%84%A4%EC%98%A4%EC%82%AC%ED%94%BC%EC%97%94%EC%8A%A4&gclid=CjwKCAjwgsqoBhBNEiwAwe5w07BRLYRw2YPtOPsKsBGLahFLN3oo1GFN8Zt613uiOJSat4lMf0D5sRoCQloQAvD_BwE'
        WHEN i = 17 THEN 'https://www.crevisse.com/'
        WHEN i = 18 THEN 'https://logpresso.com/ko'
        ELSE NULL
      END
    );

    INSERT INTO BOARD_RECRUIT (
      BOARD_NO,
      CMPN_NO,
      "POSITION",
      EXPR_PERIOD,
      EMPL_TYPE,
      EMPL_CNDT,
      ENTR_EXAM,
      JOB_TYPE,
      BENEFIT,
      SALARYINFO
    ) VALUES (
      SEQ_BOARD_NO.NEXTVAL, -- RECRUIT_NO
      SEQ_CMPN_NO.CURRVAL, -- CMPN_NO (COMPANY 테이블에서 생성한 시퀀스 값을 가져와서 사용)
        CASE 
        WHEN i = 1 THEN '프론트엔드 개발자'
        WHEN i = 2 THEN '프론트엔드 개발자'
        WHEN i = 3 THEN '프론트엔드 개발자'
        WHEN i = 4 THEN '프론트엔드 개발자'
        WHEN i = 5 THEN '프론트엔드 개발자'
        WHEN i = 6 THEN '프론트엔드 개발자'
        WHEN i = 7 THEN '백엔드 개발자'
        WHEN i = 8 THEN '프론트엔드 개발자'
        WHEN i = 9 THEN '백엔드 개발자'
        WHEN i = 10 THEN '프론트엔드 개발자'
        WHEN i = 11 THEN '백엔드 개발자'
        WHEN i = 12 THEN '백엔드 개발자'
        WHEN i = 13 THEN '백엔드 개발자'
        WHEN i = 14 THEN '백엔드 개발자'
        WHEN i = 15 THEN '백엔드 개발자'
        WHEN i = 16 THEN '백엔드 개발자'
        WHEN i = 17 THEN '백엔드 개발자'
        WHEN i = 18 THEN '백엔드 개발자'
        ELSE NULL
      END,
      CASE 
        WHEN i = 1 THEN '신입 ~ 4년 차'
        WHEN i = 2 THEN '신입 ~ 1년 차'
        WHEN i = 3 THEN '신입 ~ 1년 차'
        WHEN i = 4 THEN '신입 ~ 5년 차'
        WHEN i = 5 THEN '신입 ~ 10년 차'
        WHEN i = 6 THEN '신입 ~ 7년 차'
        WHEN i = 7 THEN '경력 3~15년'
        WHEN i = 8 THEN '경력 3~15년'
        WHEN i = 9 THEN '경력 1~3년'
        WHEN i = 10 THEN '경력 3~8년'
        WHEN i = 11 THEN '신입 ~ 15년 차'
        WHEN i = 12 THEN '신입 ~ 5년 차'
        WHEN i = 13 THEN '신입 ~ 10년 차'
        WHEN i = 14 THEN '신입 ~ 5년 차'
        WHEN i = 15 THEN '신입 ~ 3년 차'
        WHEN i = 16 THEN '신입 ~ 2년 차'
        WHEN i = 17 THEN '신입 ~ 5년 차'
        WHEN i = 18 THEN '신입 ~ 5년 차'
        ELSE NULL
      END,
      CASE 
        WHEN i = 1 THEN '사무실 출근'
        WHEN i = 2 THEN '사무실 출근'
        WHEN i = 3 THEN '사무실 출근'
        WHEN i = 4 THEN '사무실 출근'
        WHEN i = 5 THEN '사무실 출근'
        WHEN i = 6 THEN '사무실 출근'
        WHEN i = 7 THEN '사무실 출근'
        WHEN i = 8 THEN '사무실 출근'
        WHEN i = 9 THEN '풀재택'
        WHEN i = 10 THEN '사무실 출근'
        WHEN i = 11 THEN '사무실 출근'
        WHEN i = 12 THEN '사무실 출근'
        WHEN i = 13 THEN '사무실 출근'
        WHEN i = 14 THEN '사무실 출근'
        WHEN i = 15 THEN '사무실 출근'
        WHEN i = 16 THEN '풀재택'
        WHEN i = 17 THEN '하이브리드'
        WHEN i = 18 THEN '풀재택'
        ELSE NULL
      END,
     CASE 
        WHEN i = 1 THEN '- 수습기간 : 경력 2개월/신입 3개월 (복지 혜택은 동일 적용)<br>
<br>
- 근무시간: 매주 월~금 09:30 ~ 18:30 (탄력 근무 시행)<br>
<br>
- 학동역 도보 5분 거리 빌딩 근무 ( 강남구 싸이칸타워 )'
        WHEN i = 2 THEN '- 수습기간 : 3개월 (복지 혜택은 동일 적용)<br>
<br>
- 근무시간: 매주 월~금 09:00 ~ 18:00'
        WHEN i = 3 THEN 'ㆍ근무일시: 주 5일(월~금) 09:00~18:00 (시차출퇴근제 운영)<br>
<br>
ㆍ근무형태: 인턴직 - 3개월 후 평가를 통해 정규직 전환 가능<br>
<br>
   ⇒ 정규직 전환 후 계속 근로가능자 必 : 졸업자 또는 졸업예정자'
        WHEN i = 4 THEN 'ㆍ근무형태: 병역특례 (전문연구요원, 보충역)<br>
<br>
ㆍ근무일시: 주 5일(월~금) 09:00~18:00 (시차출퇴근제 운영)'
        WHEN i = 5 THEN '- 수습기간 : 3개월 (복지 혜택은 동일 적용)<br>
<br>
- 근무시간: 매주 월~금 09:00 ~ 18:00'
        WHEN i = 6 THEN '09시~12시 사이 원하시는 시간에 출근하고 8시간 근무 뒤 퇴근'
        WHEN i = 7 THEN '마감일 및 근무지<br>
• 마감일 : ~2023-10-24<br>
• 근무지<br>
- 서울 서초구 서초중앙로 14, 16층 3호'
        WHEN i = 8 THEN '• 선택출근제(9:30-18:30 or 10:00-19:00)'
        WHEN i = 9 THEN '주 5일제 근무 / 재택근무 활성화 / 업무 능률 향상을 위한 자율 출퇴근'
        WHEN i = 10 THEN '주 5일제 근무 / 정규직 채용의 경우 3개월의 수습기간이 있습니다.'
        WHEN i = 11 THEN '- 수습기간 : 3개월 (복지 혜택은 동일 적용)<br>
<br>
- 근무시간: 매주 월~금 09:00 ~ 18:00'
        WHEN i = 12 THEN '- 수습기간 : 3개월 (복지 혜택은 동일 적용)<br>
<br>
- 근무시간: 매주 월~금 09:00 ~ 18:00'
        WHEN i = 13 THEN '- 수습기간 : 3개월 (복지 혜택은 동일 적용)<br>
<br>
- 근무시간: 매주 월~금 09:00 ~ 18:00'
        WHEN i = 14 THEN '- 수습기간 : 3개월 (복지 혜택은 동일 적용)<br>
<br>
- 근무시간: 매주 월~금 09:00 ~ 18:00'
        WHEN i = 15 THEN '- 수습기간 : 3개월 (복지 혜택은 동일 적용)<br>
<br>
- 근무시간: 매주 월~금 09:00 ~ 18:00'
        WHEN i = 16 THEN '- 수습기간 : 3개월 (복지 혜택은 동일 적용)<br>
<br>
- 근무시간: 매주 월~금 09:00 ~ 18:00'
        WHEN i = 17 THEN '근무시간: 재량근무제 (코어타임 11시~17시)<br>
근무시작일: 협의 후 결정'
        WHEN i = 18 THEN '- 수습기간 : 3개월 (복지 혜택은 동일 적용)<br>
<br>
- 근무시간: 매주 월~금 09:00 ~ 18:00'
        ELSE NULL
      END,
      CASE 
        WHEN i = 1 THEN '지원서 제출 → 1차 서류 심사 → 2차 인터뷰 → 처우 협의 → 입사<br>
<br>
* 사전 과제는 포지션에 따라 진행 될 수 있습니다. 사전 공지를 드리며, 미진행시에는 인터뷰가 바로 진행 됩니다.'
        WHEN i = 2 THEN '"서류전형 → 1차 인터뷰 → 처우협의 및 최종합격<br>
<br>
  ⇒ 지원 포지션 별로 코딩테스트가 있을 수 있습니다. (인터뷰 일정 어레인지 시 별도안내)<br>
<br>
  ⇒ 전형과정 중 동의를 통해 레퍼런스체크를 진행할 수 있습니다."'
        WHEN i = 3 THEN '서류전형 → 1차 인터뷰 → 처우협의 및 최종합격<br>
<br>
  ⇒ 지원 포지션 별로 코딩테스트가 있을 수 있습니다. (인터뷰 일정 어레인지 시 별도안내)<br>
<br>
  ⇒ 전형과정 중 동의를 통해 레퍼런스체크를 진행할 수 있습니다.<br>'
        WHEN i = 4 THEN 'ㆍ서류전형 → 1차 인터뷰 → 처우협의 및 최종합격<br>
<br>
  ⇒ 서류전형 진행 전 자료 요청을 통해 병역특례 대상자 확인을 진행하고 있습니다.<br>
<br>
  ⇒ 지원 포지션 별로 코딩테스트가 있을 수 있습니다. (인터뷰 일정 어레인지 시 별도안내)<br>
<br>
  ⇒ 전형과정 중 동의를 통해 레퍼런스체크를 진행할 수 있습니다.'
        WHEN i = 5 THEN 'ㆍ서류전형 → 1차 인터뷰 → 처우협의 및 최종합격<br>
<br>
  ⇒ 서류전형 진행 전 자료 요청을 통해 병역특례 대상자 확인을 진행하고 있습니다.<br>
<br>
  ⇒ 지원 포지션 별로 코딩테스트가 있을 수 있습니다. (인터뷰 일정 어레인지 시 별도안내)<br>
<br>
  ⇒ 전형과정 중 동의를 통해 레퍼런스체크를 진행할 수 있습니다.'
        WHEN i = 6 THEN '이력서 (자유 형식)<br>
포트폴리오 (자유 형식)<br>
그 외에 본인을 설명 할 수 있는 모든 것이라면 제출을 환영합니다'
        WHEN i = 7 THEN '이력서 (자유 형식)<br>
포트폴리오 (자유 형식)<br>
그 외에 본인을 설명 할 수 있는 모든 것이라면 제출을 환영합니다'
        WHEN i = 8 THEN '이력서 (자유 형식)<br>
포트폴리오 (자유 형식)<br>
그 외에 본인을 설명 할 수 있는 모든 것이라면 제출을 환영합니다'
        WHEN i = 9 THEN ' 채용절차 : 서류검토 -> 1차 면접 -> 2차 임원 면접 -> 최종 합격 통보'
        WHEN i = 10 THEN '• 제출 서류<br>
　- 이력서<br>
　- 포트폴리오<br>'
        WHEN i = 11 THEN '서류 → 실무진 인터뷰→ 임원 인터뷰 → 최종합격<br>

<br>

️ ✔ 채용 절차는 지원하신 공고에 따라 상이할 수 있어요.<br>
<br>
️ ✔ 특정 직군의 경우, 코딩 테스트 전형이 추가될 수 있어요.<br>
<br>
️ ✔ 아이페이지온은 채용절차 공정화에 관한 법률 제4조3 을 준수하고 있어>.'
        WHEN i = 12 THEN 'Step 1. 지원서 제출<br>
Step 2. 과제<br>
Step 3. 직무 인터뷰<br>
Step 4. 임원진 인터뷰'
        WHEN i = 13 THEN '- 서류전형 (포트폴리오 검토)<br>
- 1차 인터뷰 (직무 중심)<br>
- 2차 인터뷰 (스타트업 핏 중심)<br>
- 처우협의<br>
- 입사확정'
        WHEN i = 14 THEN '- 서류전형 (포트폴리오 검토)<br>
- 1차 인터뷰 (직무 중심)<br>
- 2차 인터뷰 (스타트업 핏 중심)<br>
- 처우협의<br>
- 입사확정'
        WHEN i = 15 THEN '서류 ＞ 실무 면접 ＞ (필요시 2차면접 후) 합격 발표'
        WHEN i = 16 THEN '서류 ＞ 실무 면접 ＞ (필요시 2차면접 후) 합격 발표'
        WHEN i = 17 THEN '이력서 (필수)<br>
경력기술서 또는 포트폴리오 (선택) : 업무 또는 연구개발실적 중심 '
        WHEN i = 18 THEN '입사 지원 시 서류 검토＞면접＞최종 합격 의 순서로 진행됩니다.<br>
이력서 등 별도의 문서를 올려주실 때는 반드시 PDF 로 제출해 주세요. (PDF 형식 이외의 파일은 검토하지 않습니다.)<br>
이력서에는 직무와 무관한 개인정보(현재 연봉, 주소, 사진 등)는 기재하지 말아주세요.<br>
이력서에는 자격 요건과 관련된 경험 및 학습 내역을 반드시 기재해 주세요.'
        ELSE NULL
      END,
      CASE 
        WHEN i = 1 THEN '정규직'
        WHEN i = 2 THEN '정규직'
        WHEN i = 3 THEN '정규직'
        WHEN i = 4 THEN '인턴'
        WHEN i = 5 THEN '인턴'
        WHEN i = 6 THEN '정규직'
        WHEN i = 7 THEN '정규직'
        WHEN i = 8 THEN '정규직'
        WHEN i = 9 THEN '정규직'
        WHEN i = 10 THEN '정규직'
        WHEN i = 11 THEN '정규직'
        WHEN i = 12 THEN '정규직'
        WHEN i = 13 THEN '정규직'
        WHEN i = 14 THEN '정규직'
        WHEN i = 15 THEN '정규직'
        WHEN i = 16 THEN '정규직'
        WHEN i = 17 THEN '정규직'
        WHEN i = 18 THEN '정규직'
        ELSE NULL
      END,
      CASE 
        WHEN i = 1 THEN '- 4대보험·퇴직연금 / 자유로운 연차 / 모성보호제도·중소기업 소득세 감면 제도 등을 기본으로,<br>

- 점심값을 지원하고 있어요<br>
- 야근시 석식을 지원합니다<br>
- 탄력 근무제로 러쉬아워를 피해요<br>
- 생일 선물과 생일 반일 휴가를 드립니다<br>
- 섬세한 경조휴가를 챙겨드리고 있어요<br>'
        WHEN i = 2 THEN '- 사내 카페테리아 지원, 바리스타가 직접 내려주는 신선한 커피를 마음껏 즐기세요<br>
- 야근 시 택시비 지원, 수고 많은 핑랩피플의 편안한 귀가를 위해<br>
- 근속 2년 주기 마다 휴가비와 유급휴가를 드립니다<br>
- 근속 5년 주기 마다 1개월 리프레쉬 휴가와 선물을 드립니다<br>
- 자기 계발비 지원, 운동, 교육, 취미 등 다양한 분야에 활용 가능해요'
        WHEN i = 3 THEN '프리미엄 프라이데이 운영 (매월 마지막 주 금요일 오전 근무만)<br>
<br>
ㆍ1층 임직원용 카페테리아 운영 (전 메뉴 50% 무제한 할인)<br>
<br>
ㆍ식대 지급 및 복지포인트 제공<br>
<br>
ㆍ스낵바 (음료, 스낵 등이 무한 제공)<br>
<br>
ㆍ생일 당일 선물 선택 및 오후 반차 제공<br>
<br>
ㆍ창립기념일 특별 휴가 제공 (매년 7월 27일)'
        WHEN i = 4 THEN 'ㆍ경조 휴가 및 경조사비 지원<br>
<br>
ㆍ장기근속자 포상 Refresh휴가 지급 (만 3년, 5년, 7년)<br>
<br>
ㆍ개발에 필요한 최신형 개인 장비 제공 (맥북 프로 M1, 듀얼 모니터 등)<br>
<br>
ㆍ해외 컨퍼런스 지원 (참가비/항공료/숙박비용 등)'

        WHEN i = 5 THEN '- 사내 카페테리아 지원, 바리스타가 직접 내려주는 신선한 커피를 마음껏 즐기세요<br>
- 야근 시 택시비 지원, 수고 많은 핑랩피플의 편안한 귀가를 위해<br>
- 근속 2년 주기 마다 휴가비와 유급휴가를 드립니다<br>
- 근속 5년 주기 마다 1개월 리프레쉬 휴가와 선물을 드립니다<br>
- 자기 계발비 지원, 운동, 교육, 취미 등 다양한 분야에 활용 가능해요'
        WHEN i = 6 THEN ' 구성원의 성장을 응원합니다. <br>
맥북프로 (M2 Pro) 또는 그에 준하는 윈도우 노트북과 27 또는 32인치 4K 모니터를 지원합니다.<br>
업무 관련 세미나와 교육, 도서 구입비를 지원합니다.
'
        WHEN i = 7 THEN ' 주도적이고 자유로운 업무 문화<br>
• 자유로운 휴가 사용'
        WHEN i = 8 THEN '• 자유복장<br>
• 경조휴가<br>
• 직무교육 지원<br>
• 쾌적한 근무환경<br>
• 최신 하드웨어/소프트웨어 지원<br>
• 설·추석 선물 지급'
        WHEN i = 9 THEN ' 카페테리아(음료, 커피, 과자 등)<br>
• 공기청정기<br>
• 휴게실(안마의자)<br>
• 자기계발 존중<br>
• 자격증 합격시 포상제도<br>
• 신입사원교육(OJT)'
        WHEN i = 10 THEN '• 저희는 아난티 회원권을 가지고 있어 6성급 휴양시설도 제공해드려요!<br>
• 생일을 더 행복하게! 생일이시라면 회사에서 주는 선물과 함께 일찍 퇴근하세요!<br>
• 매 달 원하는 메뉴를 주문할 수 있는 스낵/음료바와 함께하세요!<br>
• 모든 복지 항목은 아래 자사 사이트에서 확인해보세요!<br>
• 자사 사이트: https://www.smiledragon.co.kr/careers'
        WHEN i = 11 THEN ' 카페테리아(음료, 커피, 과자 등)<br>
• 공기청정기<br>
• 휴게실(안마의자)<br>
• 자기계발 존중<br>
• 자격증 합격시 포상제도<br>
• 신입사원교육(OJT)'
        WHEN i = 12 THEN ' 카페테리아(음료, 커피, 과자 등)<br>
• 공기청정기<br>
• 휴게실(안마의자)<br>
• 자기계발 존중<br>
• 자격증 합격시 포상제도<br>
• 신입사원교육(OJT)'
        WHEN i = 13 THEN ' 카페테리아(음료, 커피, 과자 등)<br>
• 공기청정기<br>
• 휴게실(안마의자)<br>
• 자기계발 존중<br>
• 자격증 합격시 포상제도<br>
• 신입사원교육(OJT)'
        WHEN i = 14 THEN ' 카페테리아(음료, 커피, 과자 등)<br>
• 공기청정기<br>
• 휴게실(안마의자)<br>
• 자기계발 존중<br>
• 자격증 합격시 포상제도<br>
• 신입사원교육(OJT)'
        WHEN i = 15 THEN '• 여의도 파크원 타워의 쾌적한 근무환경 지원 (스파크플러스 여의도점, 지하철 5,9호선 연결, 2021년 10월 오픈)<br>
<br>
• 점심 식대 지원 (식권대장으로 여의도 맛집 탐방 가능)<br>
<br>
• 장비 지원 (LG 울트라파인 모니터 / 최신 16인치 맥북 프로)<br>
<br>
• 자유로운 연차 사용'
        WHEN i = 16 THEN ' 카페테리아(음료, 커피, 과자 등)<br>
• 공기청정기<br>
• 휴게실(안마의자)<br>
• 자기계발 존중<br>
• 자격증 합격시 포상제도<br>
• 신입사원교육(OJT)'
        WHEN i = 17 THEN '비즈니스 솔루션 개발 경험 (CRM, ERP 등)<br>
Multi-Tenant SaaS 소프트웨어 개발 경험<br>
대량 결제, 메시징 시스템 개발 경험<br>
전문연구요원 신규편입/전직 가능자'
        WHEN i = 18 THEN '자율 재택근무 : 재택근무를 시행하고 있으며, 재택 업무에 필요한 모니터 등 장비를 지원합니다. (담당 업무에 따라 달라질 수 있습니다.)<br>
재택비용 지원 : 효율적인 재택 업무 환경 조성을 위해 매월 재택비용을 지원합니다.<br>
유연근무제 : 팀별로 Core-time (11시-4시) 을 제외한 자유로운 출퇴근(업무시작/종료) 시간을 정할 수 있습니다.<br>
백신휴가 : 코로나19 백신 접종을 위한 백신휴가를 지급하며, 개인별 이상 반응에 따라 자유로이 사용 가능합니다!'
        ELSE NULL
      END,
       CASE 
        WHEN i = 1 THEN '비공개'
        WHEN i = 2 THEN '비공개'
        WHEN i = 3 THEN '비공개'
        WHEN i = 4 THEN '비공개'
        WHEN i = 5 THEN '비공개'
        WHEN i = 6 THEN '비공개'
        WHEN i = 7 THEN '비공개'
        WHEN i = 8 THEN '비공개'
        WHEN i = 9 THEN '비공개'
        WHEN i = 10 THEN '비공개'
        WHEN i = 11 THEN '비공개'
        WHEN i = 12 THEN '비공개'
        WHEN i = 13 THEN '비공개'
        WHEN i = 14 THEN '비공개'
        WHEN i = 15 THEN '비공개'
        WHEN i = 16 THEN '비공개'
        WHEN i = 17 THEN '비공개'
        WHEN i = 18 THEN '비공개'
        ELSE NULL
      END
      
    );
    
    
    
    
    
    INSERT INTO BOARD(
        BOARD_NO,
        MEMBER_ID,
        BOARD_TITLE,
        BOARD_CONTENT,
        CREATE_DT,
        MODIFY_DT,
        DELETED_FL,
        READ_COUNT
    
    ) VALUES(
        
        SEQ_BOARD_NO.CURRVAL,
        'user' || TO_CHAR(i + 4, 'FM00'),
        CASE 
            WHEN i = 1 THEN '[채용] 핑거랩스 웹 프론트엔드 개발자'
            WHEN i = 2 THEN '[개발] 프론트엔드'
            WHEN i = 3 THEN '[캐시워크] 프론트엔드개발 채용전환형'
            WHEN i = 4 THEN '[인턴/정규직] Software Engineer - Frontend'
            WHEN i = 5 THEN '프론트엔드 엔지니어(신입/경력)'
            WHEN i = 6 THEN '학생들의 삶의 질을 실질적으로 개선하는 일,'
            WHEN i = 7 THEN '개발자 채용'
            WHEN i = 8 THEN '아이큐 프론트엔드 개발자(3년이상)'
            WHEN i = 9 THEN 'NodeJS 백엔드 개발자' -- BOARD_TITLE
            WHEN i = 10 THEN '[Core] Web Frontend Engineer'
            WHEN i = 11 THEN '[웹 백엔드 개발자]를 찾고 있어요!'
            WHEN i = 12 THEN '백엔드(Node.js) 개발자'
            WHEN i = 13 THEN '백엔드 엔지니어'
            WHEN i = 14 THEN '팜모닝 백엔드 엔지니어'
            WHEN i = 15 THEN '백엔드 엔지니어'
            WHEN i = 16 THEN '백엔드 개발자'
            WHEN i = 17 THEN 'SaaS Backend Engineer (전문연구요원 가능)'
            WHEN i = 18 THEN '[전문연구요원] 백엔드 개발자'
            ELSE NULL
        END,
        CASE 
            WHEN i = 1 THEN '- Javascript 및 typescript 에 능숙한 분<br>
- 다양한 기술 스택에 대한 이해가 높은 분<br>
- 해외 출장/근무에 결격 사유가 없는 분<br>
<br>
이런 역량은 플러스 요인이 될 수 있어요.<br>
- 소프트웨어 컴포넌트 디자인 및 구현이 능숙한 분<br>
- 인터랙티브 웹페이지 구현에 능숙한 분<br>
- 수평 커뮤니케이션를 중시하고 유연한 생각으로 구성원들과 원활히 소통할 수 있는 분<br>
- 블록체인 기술에 대한 관심과 이해가 있는 분'
            WHEN i = 2 THEN '신입 개발자분은 전산학 또는 컴퓨터공학 관련 전공이 필수예요.<br>
- 경력, 학력, 연령 전부 무관하고 블록체인 경험이 없어도 괜찮아요.<br>
- Javascript, Node.js, 비동기 요청 처리가 능숙한 분이 필요해요.<br>
- Webpack을 통한 번들링 과정에 대한 이해도가 있는 분을 찾아요.<br>
- HTML 및 CSS에 대한 이해가 깊은 분이면 좋겠어요.<br>
<br>
이런 역량은 플러스 요인이 될 수 있어요.<br>
- Vue.js 사용 경험, Vue2에서 Vue3으로의 마이그레이션 경험, Vue Composition api 기반으로 개발 경험이 있는 분이면 좋아요.<br>
- Webpack4 및 Webpack5 빌드 과정을 상세히 설정할 수 있거나 테스트 코드 작성, JS 번들링 과정 최적화에 능숙한 분이면 더욱 좋아요.<br>
- 블록체인 관련 서비스, Node와의 API 요청, 블록체인 Contract 작성, Apache 및 NGINX를 이용한 사이트 배포 경험이 있는 분이면 환영해요.'
            WHEN i = 3 THEN '웹 표준, 웹 접근성, 반응형 개발 가능하신 분<br>
ㆍ새로운 기술에 두려워하지 않고 꾸준히 노력하는 분<br>
ㆍ문제에 직면했을때 유연하게 대처가 가능하신 분<br>
<br>
이런 역량은 플러스 요인이 될 수 있어요.<br>
ㆍSEO 최적화 경험이 있으신분<br>
ㆍHTML, CSS, JS 라이브러리를 사용하지 않아도 개발이 가능하신 분<br>
ㆍNextJS, TypeScript, SCSS, GraphQL 사용 경험이 있으신 분<br>
ㆍ개발자로서 자신감 있고 능동적인 분'
            WHEN i = 4 THEN '- 신입 또는 5년 이하의 개발 경력이 있으신 분<br>
- 농업에 대한 관심이 있고, 업무 도메인 이해를 중요하게 생각하시는 분<br>
- 1개 이상의 프로그래밍 언어를 업무에 필요한 수준으로 다룰 줄 아시는 분<br>
- 데이터베이스에 대한 기본적인 이해가 있으신 분<br>
- 웹에 대한 기본적인 이해가 있으신 분<br>
<br>
이런 역량은 플러스 요인이 될 수 있어요.<br>
- 전자상거래 서비스 개발 및 운영 경험이 있으신 분<br>
- 함수형 프로그래밍에 대한 관심이 많으신 분<br>
- GraphQL, Relay에 대한 이해가 있으신 분<br>
- AWS 인프라를 직접 운영해본 경험이 있으신 분'
            WHEN i = 5 THEN '- React 프로그래밍 경험이 있으신 분<br>
- React, Redux, HTML, CSS, SCSS 관련 지식과 경험이 있으신 분<br>
<br>
이런 역량은 플러스 요인이 될 수 있어요.<br>
- 우수한 커뮤니케이션 스킬을 갖추신 분<br>
- 팀워크의 중요성을 아시고, Team-based Problem Solving 스킬을 갖추신 분<br>
- 새로운 일에 도전을 두려워하지 않으시는 분<br>
- 배움을 통한 성장에 열려있으신 분'

            WHEN i = 6 THEN '학력 : 대졸 이상<br>
- 경력 : 무관<br>
- 컴퓨터/시스템공학, 전기전자공학, 수학과 등 유관분야 전공<br>
<br>
이런 역량은 플러스 요인이 될 수 있어요.<br>
- Vue 또는 React를 이용한 Javascript 프레임워크 기반 웹 프론트엔드 개발 경험 보유자<br>
- Bootstrap 등 웹 프레임워크 개발 경험 보유자<br>
- HTML, CCS, Javascript 개발 가능 자<br>
- 모바일 환경에서 Front-end 개발 경험 보유자<br>
- 웹 표준을 고려한 UI 개발 경험 보유자<br>
- UI/UX에 대하여 높은 가치를 두고 있는 분<br>
- 새로운 기술 습득, 사용에 능동적인 분'
            WHEN i = 7 THEN '- React 사용에 능숙하신 분<br>
- 타입스크립트 사용에 능숙하신 분<br>
- GraphQL + React 두 가지 조합에 익숙하신 분<br>
- React Native 개발에 관심이 있으신 분<br>
- Full-Stack 제너럴리스트가 되는 것에 대해 거부감이 없으신 분<br>
- AWS 와 같은 클라우드 환경에 익숙하신 분<br>
- Git 을 통한 버전관리 및 협업의 경험이 있으신분<br>
- “해결 불가능한 문제는 없다” 라고 생각하시는 분<br>
- 그저 주어진 개발만 하는 것이 아닌, 주도적으로 문제를 정의하고 해결하시는 분<br>
<br>
이런 역량은 플러스 요인이 될 수 있어요.<br>
- React Native 개발 경험이 있으신 분<br>
- 모노레포에 대해 경험이 있거나, 관심이 있으신 분<br>
- CICD 관련 경험이 있으신분<br>
- 코드 리뷰에 긍정적이신 분<br>
- 모바일 또는 반응 형 웹 개발 경험이 있으신 분<br>
- UI/UX 개선과 관련된 고민을 좋아하시는 분<br>
- Kubernetes, Docker 등 컨테이너 환경에 대한 이해가 있으신 분<br>
- MSA 에 대해서 알고 계시거나 관심이 있으신 분<br>
- gRPC에 관심이 있으신 분'
            WHEN i = 8 THEN '주요업무<br>
• Web 3.0 Application 백엔드 서비스 개발<br>
• Web 3.0 Application 스마트 컨트랙트 개발 및 유지 보수<br>
• EVM Network 데이터 인덱싱 / 조회용 API 개발<br>
• Wallet as a Service 연동 개발<br>
<br>
자격요건<br>
• 기본적인 Backend 서비스 개발 경험 및 역량<br>
• AWS를 통한 서비스 구축 경험<br>
• Blockchain 개발 경험 및 RPC API 에 대한 이해<br>
• 스마트컨트랙트 개발 방식에 대한 이해<br>
<br>
우대사항<br>
• 서비스 운용과 CI/CD 에 대한 경험<br>
• Microservice에 대한 경험과 이해<br>
• Serverless / Container 기술에 대한 이해<br>
• 주도적으로 복잡한 기술적인 결정을 내리고, 팀원들을 설득할 수 있는 능력<br>
• 팀원들이 높은 수준을 유지할 수 있도록 적극적인 Code Review, Feedback을 줄수 있어야함'
            WHEN i = 9 THEN '주요업무<br>
• Node.js(NestJS, ExpressJs) 서버 구축 및 DB(MySql, Prisma, TypeORM) 관리<br>
• RESTful API 서버 개발<br>
• RDBMS(AWS RDS)에 대한 관리<br>
• 컨테이너를 기반으로 한, MicroService Architecture Backend 개발<br>
• AWS를 활용한 클라우드 기반 Backend 개발<br>
• Git 등의 툴을 활용한 개발 협업<br><br>
자격요건<br>
• Node.js 개발 경력 1년 이상 혹은 이해 준하는 경력을 가지신 분<br>
• 긍정적 사고와 원활한 커뮤니케이션이 가능하신 분<br>
• 개발 프로세스에 대한 이해 (디자인, 설계, 구현, 테스트, 배포, 운영)<br>
• 원활한 커뮤니케이션을 통해 적극적인 소통과 피드백이 가능한 분<br>
• 코드 리뷰, 단위 테스트, 지속적인 통합 및 배포 (CI/CD) 등의 개발 프로세스를 따르며, 팀의 생산성과 협업<br>
• 클린 아키텍처, MSA 등에 대한 이해' -- BOARD_CONTENT
            WHEN i = 10 THEN '저희는 이런 환경에서 일해요!<br>
<br>
• 개발팀 내부적으로 Slack 을 통한 커뮤니케이션이 이루어집니다.<br>
• Pull Request 는 반드시 팀원들의 코드 리뷰를 받고 이루어집니다.<br>
• Notion 을 통해 프로젝트 진행상황 및 정보를 관리합니다.<br>
• Docker 를 통해 개발환경을 단일화합니다.<br>
• GitHub Actions 를 통해 프로젝트 빌드 및 배포 자동화가 진행됩니다.<br>
• 사내 Kubernetes + Helm + Argo CD 환경으로 배포가 이루어집니다.<br>
<br>
<br>
️ 저희는 이런 기술을 사용해요!<br>
<br>
• Next.js, TypeScript, Emotion, Jest, Cypress<br>
• Yarn Berry, pnpm, Rollup.js<br>
더욱 자세한 기술스택은 https://stackshare.io/companies/smiledragon 에서 확인하실 수 있어요!'
            WHEN i = 11 THEN '🙍‍♀️ 신입<br>
<br>
- 컴퓨터/정보통신/전산학과 전공자<br>
- Java 프로그래밍을 하실 수 있는 분<br>
<br>

🙍‍♂️ 경력<br>
<br>
- Java 프로그래밍이 가능하신 분<br>
- 스프링 프레임워크 기반 개발 경험이 있으신 분<br>
- DB 개발 경험이 있으신 분<br>
- Linux 환경에서 개발이 가능하신 분<br>
<br>
이런 역량은 플러스 요인이 될 수 있어요.<br>
- 통신 프로그램 개발 경험이 있으신 분<br>
- EMS, NMS 개발 경험이 있으신 분<br>
- UI(BootStrap 등) 개발 경험이 있으신 분<br>
- Javascript(jQuery) 개발 경험이 있으신 분'
            WHEN i = 12 THEN '- 2년 이상의 백엔드 개발 경력이 있거나 그에 준하는 실력을 갖추신 분 (경력 지원자의 경우)<br>
- AWS/GCP를 통해 인프라 구축한 경험이 있는 분<br>
- Node.js와 JavaScript 또는 TypeScript 에 대한 이해를 갖춘 분<br>
- 단위테스트, 기능테스트, 종단테스트, 빌드 자동화, 지속적 통합의 경험이 있는 분<br>
- RDBMS, NoSQL에 대한 이해를 갖춘 분<br>
- 자유로운 근무환경에서 스스로의 목표와 일정을 관리할 수 있는 분<br>
- 배움에 대한 열정을 갖고, 지속적이고 효과적으로 피드백을 주고 받는 분<br>
- 맡은 작업에 대한 오너십을 갖고, 이를 완성시키는 일에 열정이 있는 분<br>
<br>
이런 역량은 플러스 요인이 될 수 있어요.<br>
- 서버리스로 상용 서비스를 운영한 경험이 있으신 분<br>
- WebSocket 혹은 socket.io로 많은 사람들이 접속하는 실시간 채팅 서비스를 구현한 경험이 있는 분<br>
- 성장하는 서비스에서 결제 및 VAN 연동 경험이 있는 분<br>
- 여러 국가에 걸쳐 서비스를 운영/배포한 경험이 있는 분<br>
- MSA를 직접 설계, 구축해 본 경험이 있는 분'
            WHEN i = 13 THEN '- 신입, 주니어, 시니어 모두 가능<br>
- 컴퓨터공학 전공자 (혹은 그에 준하는 역량 보유자)<br>
- Go 또는 기타 1개 이상의 언어를 활용한 백엔드 개발 역량<br>
- 자기 주도적인 업무 스타일 보유 및 논리적인 의사소통 능력<br>
- 해외여행 결격사유가 없는 분<br>
<br>
이런 역량은 플러스 요인이 될 수 있어요.<br>
- 스타트업에 대한 이해와 마인드셋'
            WHEN i = 14 THEN '- 신입 또는 5년 이하의 개발 경력이 있으신 분<br>
- 농업에 대한 관심이 있고, 업무 도메인 이해를 중요하게 생각하시는 분<br>
- 1개 이상의 프로그래밍 언어를 업무에 필요한 수준으로 다룰 줄 아시는 분<br>
- 데이터베이스에 대한 기본적인 이해가 있으신 분<br>
- 웹에 대한 기본적인 이해가 있으신 분<br>
<br>
이런 역량은 플러스 요인이 될 수 있어요.<br>
- 전자상거래 서비스 개발 및 운영 경험이 있으신 분<br>
- 함수형 프로그래밍에 대한 관심이 많으신 분<br>
- GraphQL, Relay에 대한 이해가 있으신 분<br>
- AWS 인프라를 직접 운영해본 경험이 있으신 분'
            WHEN i = 15 THEN '• Spring(Java/Kotlin), Rails, Node.js, django, flask 중 하나 이상을 활용한 서버 개발 경험이 있으신 분<br>
• 자유롭게 의견을 내고 지적으로 정직한 토론을 좋아하시는 분<br>
<br>
이런 역량은 플러스 요인이 될 수 있어요.<br>
• Kotlin Spring을 활용한 서비스 개발 경험이 있으신 분<br>
• AWS 등 클라우드 컴퓨팅 관련 경험이 있으신 분<br>
• Docker 등 컨테이너 가상화 플랫폼 관련 경험이 있으신 분<br>
• PyTorch, SageMaker를 이용한 AI 서버 배포 경험이 있으신 분'
            WHEN i = 16 THEN '- 파이썬 서버 개발 및 운영 경험<br>
- 도커에 대한 이해<br>
- GIT에 대한 이해<br>
<br>
이런 역량은 플러스 요인이 될 수 있어요.<br>
- 자동화 지향형<br>
- 오픈소스 활동 지향형<br>
- 테스팅을 항상 생각하는 분<br>
- 소프트웨어 개발에 대한 고민이 깊은 분<br>
- 상용화 서비스에 대한 개발 및 운영 경험이 있는 분'
            WHEN i = 17 THEN '- 구조적이고 효율적인 코드를 작성하는 것을 즐기는 사람<br>
- 좋은 제품을 만들기 위해 상호 배려하면서 소통할 수 있는 사람<br>
- 새로운 기술의 탐색을 즐기는 한편 제품에는 신중하게 적용하는 균형잡힌 시각을 갖추고자 하는 사람<br>
- 제품, 운영, 마케팅, 영업 등 다양한 관점을 가진 구성원들과의 협업을 즐기는 사람<br>
<br>
이런 역량은 플러스 요인이 될 수 있어요.<br>
- 비즈니스 솔루션 개발 경험 (CRM, ERP 등)<br>
- Multi-Tenant SaaS 소프트웨어 개발 경험<br>
- 대량 결제, 메시징 시스템 개발 경험<br>
- 전문연구요원 신규편입/전직 가능자'
            WHEN i = 18 THEN '이런 분을 원해요.<br>
- 컴퓨터 공학 및 유관 전공 석사 졸업 및 졸업 예정이신 분<br>
- 네트워크 및 통신에 대한 기술적 이해도가 있으신 분<br>
- 멀티스레드 동시성 제어 및 비동기 프로그래밍의 이해도가 높으신 분<br>
- 지속적인 학습이 가능하신 분<br>
- 다양한 분야의 사람들과 협업하기 위한 유연하고 친화적인 커뮤니케이션 능력을 보유하신 분<br>
- 문제의 근원적 해결에 대한 끈기와 의지가 있으신 분<br>
- 기록과 공유의 중요성을 이해하고 실천하시는 분'
            ELSE NULL
        END,
        SYSDATE,
        NULL,
        DEFAULT,
        0
    
    );
   
    INSERT INTO "TAG"(
    TAG_NO,
    TAG_NM
  ) VALUES(
    SEQ_TAG_NO.NEXTVAL,
     CASE
        WHEN DBMS_RANDOM.VALUE < 0.2 THEN 'Java'
        WHEN DBMS_RANDOM.VALUE < 0.4 THEN 'Javascript'
        WHEN DBMS_RANDOM.VALUE < 0.6 THEN 'jQuery'
        WHEN DBMS_RANDOM.VALUE < 0.8 THEN 'linux'
        ELSE 'Java'
      END       
  );
    
  INSERT INTO TAG_RELATION(
    TAG_NO,
    ITEM_TYPE,
    ITEM_NO
  ) VALUES(
    SEQ_TAG_NO.CURRVAL,
    3,
    SEQ_BOARD_NO.CURRVAL
    
  );
  
    INSERT INTO "TAG"(
    TAG_NO,
    TAG_NM
  ) VALUES(
    SEQ_TAG_NO.NEXTVAL,
     CASE
        WHEN DBMS_RANDOM.VALUE < 0.2 THEN 'typescript'
        WHEN DBMS_RANDOM.VALUE < 0.4 THEN 'NestJs'
        WHEN DBMS_RANDOM.VALUE < 0.6 THEN 'NodeJs'
        WHEN DBMS_RANDOM.VALUE < 0.8 THEN 'Spring'
        ELSE 'typescript'
      END       
  );
  
    INSERT INTO TAG_RELATION(
    TAG_NO,
    ITEM_TYPE,
    ITEM_NO
  ) VALUES(
    SEQ_TAG_NO.CURRVAL,
    3,
    SEQ_BOARD_NO.CURRVAL
    
  );
  
    INSERT INTO "TAG"(
    TAG_NO,
    TAG_NM
  ) VALUES(
    SEQ_TAG_NO.NEXTVAL,
     CASE
        WHEN DBMS_RANDOM.VALUE < 0.2 THEN 'CloudWatch'
        WHEN DBMS_RANDOM.VALUE < 0.4 THEN 'AWS Lambda'
        WHEN DBMS_RANDOM.VALUE < 0.6 THEN 'MySQL'
        WHEN DBMS_RANDOM.VALUE < 0.8 THEN 'JQuery'
        ELSE 'CloudWatch'
      END       
  );
    
  INSERT INTO TAG_RELATION(
    TAG_NO,
    ITEM_TYPE,
    ITEM_NO
  ) VALUES(
    SEQ_TAG_NO.CURRVAL,
    3,
    SEQ_BOARD_NO.CURRVAL
    
  );
  
    
    INSERT INTO "TAG"(
    TAG_NO,
    TAG_NM
  ) VALUES(
    SEQ_TAG_NO.NEXTVAL,
     CASE
        WHEN DBMS_RANDOM.VALUE < 0.2 THEN 'Oracle'
        WHEN DBMS_RANDOM.VALUE < 0.4 THEN 'Docker'
        WHEN DBMS_RANDOM.VALUE < 0.6 THEN 'git'
        WHEN DBMS_RANDOM.VALUE < 0.8 THEN 'AWS'
        ELSE 'Oracle'
      END       
  );
    
  INSERT INTO TAG_RELATION(
    TAG_NO,
    ITEM_TYPE,
    ITEM_NO
  ) VALUES(
    SEQ_TAG_NO.CURRVAL,
    3,
    SEQ_BOARD_NO.CURRVAL
    
  );
  
    INSERT INTO "TAG"(
    TAG_NO,
    TAG_NM
  ) VALUES(
    SEQ_TAG_NO.NEXTVAL,
     CASE
        WHEN DBMS_RANDOM.VALUE < 0.2 THEN 'Sentry'
        WHEN DBMS_RANDOM.VALUE < 0.4 THEN 'pyTorch'
        WHEN DBMS_RANDOM.VALUE < 0.6 THEN 'postgreSQL'
        WHEN DBMS_RANDOM.VALUE < 0.8 THEN 'Redis'
        ELSE 'Sentry'
      END       
  );
    
  INSERT INTO TAG_RELATION(
    TAG_NO,
    ITEM_TYPE,
    ITEM_NO
  ) VALUES(
    SEQ_TAG_NO.CURRVAL,
    3,
    SEQ_BOARD_NO.CURRVAL
    
  );
 
  END LOOP;
  COMMIT;
END;
