package com.lumora.daily.domain;

import com.lumora.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.lumora.common.annotation.Excel;

/**
 * 日常记录_每日日报内容对象 daily_report_content
 *
 * @author Leo
 * @date 2025-06-17
 */
public class DailyReportContent extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 每日日报内容ID
     */
    private Long reportContentId;

    /**
     * 每日日报ID
     */
    @Excel(name = "每日日报ID")
    private Long reportId;

    /**
     * 内容类型
     */
    @Excel(name = "内容类型")
    private String contentType;

    /**
     * 内容
     */
    @Excel(name = "内容")
    private String content;

    /**
     * 删除标志（0代表存在 2代表删除）
     */
    private String delFlag;

    public void setReportContentId(Long reportContentId) {
        this.reportContentId = reportContentId;
    }

    public Long getReportContentId() {
        return reportContentId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public Long getReportId() {
        return reportId;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public String getDelFlag() {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("reportContentId", getReportContentId())
                .append("reportId", getReportId())
                .append("contentType", getContentType())
                .append("content", getContent())
                .append("delFlag", getDelFlag())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .toString();
    }
}
