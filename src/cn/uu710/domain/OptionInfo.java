package cn.uu710.domain;

/**
 * 选项信息实体类
 */
public class OptionInfo extends BaseDomainInfo{
	private Integer questionNumId;
	private String optionContent;
	private String optionType;
	
	// 辅助信息，数据库中不存储该字段
	private PaperInfo paperInfo;

	public Integer getQuestionNumId() {
		return questionNumId;
	}

	public void setQuestionNumId(Integer questionNumId) {
		this.questionNumId = questionNumId;
	}

	public String getOptionContent() {
		return optionContent;
	}

	public void setOptionContent(String optionContent) {
		this.optionContent = optionContent;
	}

	public String getOptionType() {
		return optionType;
	}

	public void setOptionType(String optionType) {
		this.optionType = optionType;
	}

	public PaperInfo getPaperInfo() {
		return paperInfo;
	}

	public void setPaperInfo(PaperInfo paperInfo) {
		this.paperInfo = paperInfo;
	}

}
