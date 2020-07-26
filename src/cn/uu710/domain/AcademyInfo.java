package cn.uu710.domain;

/**
 * 学院信息实体类
 */
public class AcademyInfo extends BaseDomainInfo {
    private String academyName;

    public String getAcademyName() {
        return academyName;
    }

    public void setAcademyName(String academyName) {
        this.academyName = academyName;
    }
}
