## 개요
DB에 있는 정보를 select * 하여 excel에 저장해주는 코드

## 데이터 소스

간암_진단_신체계측정보

https://www.bigdata-cancer.kr/ncc/tableStatView.do?centerCd=00040&cncrTbNo=18040

## DDL

```sql
create table LVER_DG_THNF
(
    ID                    int auto_increment
        primary key,
    CENTER_CD             varchar(20)   null comment '센터코드',
    IRB_APRV_NO           varchar(50)   null comment 'IRB승인번호',
    PT_SBST_NO            varchar(10)   null comment '환자대체번호',
    ANDG_ANTH_RCRD_YMD    varchar(8)    null comment '신체계측진단신체계측기록일자',
    ANDG_ANTH_SEQ         int           null comment '신체계측진단신체계측순번',
    ANDG_HT_MSRM_YMD      varchar(8)    null comment '신체계측진단신장측정일자',
    ANDG_HT_MSRM_VL       float         null comment '신체계측진단신장측정값',
    ANDG_WT_MSRM_YMD      varchar(8)    null comment '신체계측진단체중측정일자',
    ANDG_WT_MSRM_VL       float         null comment '신체계측진단체중측정값',
    ANDG_BMI_VL           float         null comment '신체계측진단BMI값',
    ANDG_ECOG_CD          varchar(20)   null comment '신체계측진단ECOG코드',
    ANDG_ECOG_NM          varchar(200)  null comment '신체계측진단ECOG명',
    ANDG_ECOG_CD_ETC_CONT varchar(8000) null comment '신체계측진단ECOG코드기타내용',
    ANDG_CTRT_BLPR_VL     varchar(10)   null comment '신체계측진단수축혈압값',
    ANDG_RLXT_BLPR_VL     varchar(10)   null comment '신체계측진단이완혈압값',
    CRTN_DT               datetime      null comment '생성일시'
);
```


## 실행하는 방법

application.yml의 db접속정보를 수정한 후 실행하면 root에 output.xlsx 파일이 생성됩니다.


