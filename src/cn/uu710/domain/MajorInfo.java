package cn.uu710.domain;

/**
 * 专业信息实体
 */
public class MajorInfo extends BaseDomainInfo{
    private String majorName;
    private Integer academyInfoId;
    // 辅助信息，用于存储学院信息，数据库中不存在该字段
    private AcademyInfo academyInfo;

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public Integer getAcademyInfoId() {
        return academyInfoId;
    }

    public void setAcademyInfoId(Integer academyInfoId) {
        this.academyInfoId = academyInfoId;
    }

    public AcademyInfo getAcademyInfo() {
        return academyInfo;
    }

    public void setAcademyInfo(AcademyInfo academyInfo) {
        this.academyInfo = academyInfo;
    }
}
