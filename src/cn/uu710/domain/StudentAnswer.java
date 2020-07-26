package cn.uu710.domain;

/**
 *学生答案信息实体类
 */
public class StudentAnswer extends BaseDomainInfo {

	private Integer studentNumId;
	private Integer questionNumId;
	private String answerType;
	private Integer studentScore;
	// 辅助信息
	private StudentInfo studentInfo;
	private PaperInfo paperInfo;
	private AcademyInfo academyInfo;

	public Integer getStudentScore() {
		return studentScore;
	}

	public void setStudentScore(Integer studentScore) {
		this.studentScore = studentScore;
	}

	public String getAnswerType() {
		return answerType;
	}

	public void setAnswerType(String answerType) {
		this.answerType = answerType;
	}

	public Integer getStudentNumId() {
		return studentNumId;
	}

	public void setStudentNumId(Integer studentNumId) {
		this.studentNumId = studentNumId;
	}

	public Integer getQuestionNumId() {
		return questionNumId;
	}

	public void setQuestionNumId(Integer questionNumId) {
		this.questionNumId = questionNumId;
	}

	public StudentInfo getStudentInfo() {
		return studentInfo;
	}

	public void setStudentInfo(StudentInfo studentInfo) {
		this.studentInfo = studentInfo;
	}

	public PaperInfo getPaperInfo() {
		return paperInfo;
	}

	public void setPaperInfo(PaperInfo paperInfo) {
		this.paperInfo = paperInfo;
	}

	public AcademyInfo getAcademyInfo() {
		return academyInfo;
	}

	public void setAcademyInfo(AcademyInfo academyInfo) {
		this.academyInfo = academyInfo;
	}

}
