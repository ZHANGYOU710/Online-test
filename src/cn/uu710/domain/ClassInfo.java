package cn.uu710.domain;

/**
 * 班级信息实体类
 */
public class ClassInfo extends BaseDomainInfo {

	private String className;
	private Integer maxScore;
	private Integer minScore;
	private String classRule;

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Integer getMaxScore() {
		return maxScore;
	}

	public void setMaxScore(Integer maxScore) {
		this.maxScore = maxScore;
	}

	public Integer getMinScore() {
		return minScore;
	}

	public void setMinScore(Integer minScore) {
		this.minScore = minScore;
	}

	public String getClassRule() {
		return classRule;
	}

	public void setClassRule(String classRule) {
		this.classRule = classRule;
	}

}
