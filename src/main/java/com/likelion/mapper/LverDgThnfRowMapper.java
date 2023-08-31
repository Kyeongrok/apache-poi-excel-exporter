package com.likelion.mapper;

import com.likelion.domain.LverDgThnf;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class LverDgThnfRowMapper implements RowMapper<LverDgThnf> {

    @Override
    public LverDgThnf mapRow(ResultSet rs, int rowNum) throws SQLException {
        LverDgThnf lverDgThnf = new LverDgThnf();

        lverDgThnf.setId(rs.getLong("id"));
        lverDgThnf.setCenterCd(rs.getString("CENTER_CD"));
        lverDgThnf.setIrbAprvNo(rs.getString("IRB_APRV_NO"));
        lverDgThnf.setPtSbstNo(rs.getString("PT_SBST_NO"));
        lverDgThnf.setAndgAnthRcrdYmd(rs.getString("ANDG_ANTH_RCRD_YMD"));
        lverDgThnf.setAndgAnthSeq(rs.getInt("ANDG_ANTH_SEQ"));
        lverDgThnf.setAndgHtMsrmYmd(rs.getString("ANDG_HT_MSRM_YMD"));
        lverDgThnf.setAndgHtMsrmVl(rs.getFloat("ANDG_HT_MSRM_VL"));
        lverDgThnf.setAndgWtMsrmYmd(rs.getString("ANDG_WT_MSRM_YMD"));
        lverDgThnf.setAndgWtMsrmVl(rs.getFloat("ANDG_WT_MSRM_VL"));
        lverDgThnf.setAndgBmiVl(rs.getFloat("ANDG_BMI_VL"));
        lverDgThnf.setAndgEcogCd(rs.getString("ANDG_ECOG_CD"));
        lverDgThnf.setAndgEcogNm(rs.getString("ANDG_ECOG_NM"));
        lverDgThnf.setAndgEcogCdEtcCont(rs.getString("ANDG_ECOG_CD_ETC_CONT"));
        lverDgThnf.setAndgCtrtBlprVl(rs.getString("ANDG_CTRT_BLPR_VL"));
        lverDgThnf.setAndgRlxtBlprVl(rs.getString("ANDG_RLXT_BLPR_VL"));
        lverDgThnf.setCrtnDt(rs.getObject("CRTN_DT", LocalDateTime.class));

        return lverDgThnf;
    }
}
