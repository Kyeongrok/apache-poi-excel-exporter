## DDL

```sql
create table LVER_DG_THNF
(
    ID                    int auto_increment
        primary key,
    CENTER_CD             varchar(20)   null,
    IRB_APRV_NO           varchar(50)   null,
    PT_SBST_NO            varchar(10)   null,
    ANDG_ANTH_RCRD_YMD    varchar(8)    null,
    ANDG_ANTH_SEQ         int           null,
    ANDG_HT_MSRM_YMD      varchar(8)    null,
    ANDG_HT_MSRM_VL       float         null,
    ANDG_WT_MSRM_YMD      varchar(8)    null,
    ANDG_WT_MSRM_VL       float         null,
    ANDG_BMI_VL           float         null,
    ANDG_ECOG_CD          varchar(20)   null,
    ANDG_ECOG_NM          varchar(200)  null,
    ANDG_ECOG_CD_ETC_CONT varchar(8000) null,
    ANDG_CTRT_BLPR_VL     varchar(10)   null,
    ANDG_RLXT_BLPR_VL     varchar(10)   null,
    CRTN_DT               datetime      null
);
```


## 실행하는 방법

application.yml의 db접속정보를 수정한 후 실행하면 root에 output.xlsx 파일이 생성됩니다.


