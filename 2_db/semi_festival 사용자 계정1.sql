CREATE TABLE GOOD_ASSESS(
    REC_MEMBER_NO NUMBER REFERENCES MEMBER(MEMBER_NO),
    GOOD_MEMBER_NO NUMBER REFERENCES MEMBER(MEMBER_NO)
    );
COMMENT ON COLUMN "GOOD_ASSESS"."REC_MEMBER_NO" IS '좋아요할 사람';
COMMENT ON COLUMN "GOOD_ASSESS"."GOOD_MEMBER_NO" IS '좋아요받은 사람';

CREATE TABLE BAD_ASSESS(
    REC_MEMBER_NO1 NUMBER REFERENCES MEMBER(MEMBER_NO),
    BAD_MEMBER_NO NUMBER REFERENCES MEMBER(MEMBER_NO)
    );
    

COMMENT ON COLUMN "BAD_ASSESS"."REC_MEMBER_NO1" IS '신고자';
COMMENT ON COLUMN "BAD_ASSESS"."BAD_MEMBER_NO" IS '피신고자';	    

SELECT FESTIVAL_NO, FESTIVAL_TITLE, FESTIVAL_CT, FESTIVAL_DT, READ_COUNT, BOARD_CD, FESTIVAL_AREA, FESTIVAL_CAT, 
        FESTIVAL_DETAILINFO, FESTIVAL_SLOGAN, FESTIVAL_PHONE, FESTIVAL_FREE_FL, FESTIVAL_RELATEDAGENCIES
		FROM INFO_BOARD
		JOIN FESTIVAL_DETAIL USING(FESTIVAL_NO)
		WHERE FESTIVAL_NO = 1;
        
	    SELECT FESTIVAL_NO, FESTIVAL_TITLE, FESTIVAL_CT, FESTIVAL_DT, READ_COUNT, BOARD_CD, FESTIVAL_AREA, FESTIVAL_CAT, 
        FESTIVAL_DETAILINFO, FESTIVAL_SLOGAN, FESTIVAL_PHONE, FESTIVAL_FREE_FL, FESTIVAL_RELATEDAGENCIES
		FROM INFO_BOARD
		JOIN FESTIVAL_DETAIL USING(FESTIVAL_NO)
		WHERE FESTIVAL_NO = 1;       
        commit;
        
DROP TABLE FESTIVAL_DETAIL;

CREATE TABLE "FESTIVAL_DETAIL" (
	"FESTIVAL_NO"	NUMBER		NOT NULL,
	"FESTIVAL_DETAILINFO"	VARCHAR2(500)		NOT NULL,
	"FESTIVAL_SLOGAN"	VARCHAR2(100)		NULL,
	"FESTIVAL_PHONE"	VARCHAR2(15)		NULL,
	"FESTIVAL_FREE_FL"	VARCHAR2(6)		NULL,
    "FESTIVAL_YOUTUBE" VARCHAR2(1000) NULL,
	"FESTIVAL_RELATEDAGENCIES"	VARCHAR2(100)		NULL,
    "FESTIVAL_HOMEPAGE" VARCHAR2(500) NULL
);

COMMENT ON COLUMN "FESTIVAL_DETAIL"."FESTIVAL_NO" IS '축제번호';

COMMENT ON COLUMN "FESTIVAL_DETAIL"."FESTIVAL_DETAILINFO" IS '축제 상세정보';

COMMENT ON COLUMN "FESTIVAL_DETAIL"."FESTIVAL_SLOGAN" IS '축제 슬로건';

COMMENT ON COLUMN "FESTIVAL_DETAIL"."FESTIVAL_PHONE" IS '축제 전화번호';

COMMENT ON COLUMN "FESTIVAL_DETAIL"."FESTIVAL_FREE_FL" IS '축제 유/무료 여부';

COMMENT ON COLUMN "FESTIVAL_DETAIL"."FESTIVAL_YOUTUBE" IS '축제 유튜브';

COMMENT ON COLUMN "FESTIVAL_DETAIL"."FESTIVAL_RELATEDAGENCIES" IS '축제 관련 기관';

COMMENT ON COLUMN "FESTIVAL_DETAIL"."FESTIVAL_HOMEPAGE" IS '축제 홈페이지';

DROP SEQUENCE SEQ_FESTIVALDETAIL_NO;

CREATE SEQUENCE SEQ_FESTIVALDETAIL_NO
       INCREMENT BY 1 -- 증가값
       START WITH 1 -- 시작값
       MINVALUE 1; -- 최솟값

BEGIN
    FOR I IN 1..180 LOOP
        
       INSERT INTO FESTIVAL_DETAIL
        VALUES(SEQ_FESTIVALDETAIL_NO.NEXTVAL,
              '해당 축제 상세내용', ' 해당 축제 슬로건', '전화번호', '무료', null, '해당 축제 관련 기관', '홈피'
       );
        
   END LOOP;
 END;
/
COMMIT;

CREATE OR REPLACE PROCEDURE INSERT_FESTIVAL_IMG
(F_START    IN    NUMBER  
,F_END       IN    NUMBER
,L_START IN      NUMBER
,L_END    IN      NUMBER)
IS
   F_NUM NUMBER:= F_START;
   F_LEVEL NUMBER:= L_START;

BEGIN
    LOOP
        EXIT WHEN F_NUM > F_END;
         LOOP
            EXIT WHEN F_LEVEL > L_END;
            INSERT INTO FESTIVAL_IMG
                VALUES(F_NUM,
                        '/resources/images/festival_infomation/' || F_NUM ||'-'|| F_LEVEL ||'.png',
                        F_LEVEL);      
            F_LEVEL := F_LEVEL+1;
         END LOOP;
         F_LEVEL := L_START;
         F_NUM := F_NUM+1;
   END LOOP;
END;
/

EXEC INSERT_FESTIVAL_IMG(1,10,1,7); -- (1번축제부터 10번축제 각각 레벨1부터 7레벨까지 INSERT)
        
        
        commit;
        
