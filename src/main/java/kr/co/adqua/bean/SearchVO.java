package kr.co.adqua.bean;

public class SearchVO {

	private String searchOption;
	private String keyword;
	
	public SearchVO() {
	}

	public SearchVO(String searchOption, String keyword) {
		super();
		this.searchOption = searchOption;
		this.keyword = keyword;
	}
	
	public String getSearchOption() {
		return searchOption;
	}
	public void setSearchOption(String searchOption) {
		this.searchOption = searchOption;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "SearchVO [searchOption=" + searchOption + ", keyword=" + keyword + "]";
	}
	
}
