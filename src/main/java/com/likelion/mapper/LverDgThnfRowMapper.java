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
        lverDgThnf.setCenterCd(rs.getString("CenterCd"));
        lverDgThnf.setIrbAprvNo(rs.getString("IrbAprvNo"));
        lverDgThnf.setPtSbstNo(rs.getString("PtSbstNo"));
        lverDgThnf.setAndgAnthRcrdYmd(rs.getString("AndgAnthRcrdYmd"));
        lverDgThnf.setAndgAnthSeq(rs.getInt("AndgAnthSeq"));
        lverDgThnf.setAndgHtMsrmYmd(rs.getString("AndgHtMsrmYmd"));
        lverDgThnf.setAndgHtMsrmVl(rs.getFloat("AndgHtMsrmVl"));
        lverDgThnf.setAndgWtMsrmYmd(rs.getString("AndgWtMsrmYmd"));
        lverDgThnf.setAndgWtMsrmVl(rs.getFloat("AndgWtMsrmVl"));
        lverDgThnf.setAndgBmiVl(rs.getFloat("AndgBmiVl"));
        lverDgThnf.setAndgEcogCd(rs.getString("AndgEcogCd"));
        lverDgThnf.setAndgEcogNm(rs.getString("AndgEcogNm"));
        lverDgThnf.setAndgEcogCdEtcCont(rs.getString("AndgEcogCdEtcCont"));
        lverDgThnf.setAndgCtrtBlprVl(rs.getString("AndgCtrtBlprVl"));
        lverDgThnf.setAndgRlxtBlprVl(rs.getString("AndgRlxtBlprVl"));
        lverDgThnf.setCrtnDt(rs.getObject("CrtnDt", LocalDateTime.class));

        return lverDgThnf;
    }
}
