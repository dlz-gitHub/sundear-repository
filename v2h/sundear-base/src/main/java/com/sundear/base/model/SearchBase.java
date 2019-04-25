package com.sundear.base.model;
import com.sundear.base.enumeration.SearchEnum.SearchTypeEnum;

public class SearchBase {
	final int PAGE_SIZE=10;
	public void setSearchPage(int startRowNum,int pageSize){		
		this.startRowNum=startRowNum;
		this.pageSize=pageSize;
	}
	private int startRowNum;
	public int getStartRowNum(){
		return this.startRowNum;
	}
	
	private int endRowNum;
	public int getEndRowNum(){
		return this.endRowNum;
	}

	private int pageIndex;
	public int getPageIndex(){
		return this.pageIndex;
	}
	private int pageSize;
	public int getPageSize(){
		return this.pageSize;
	}

	private int totalCount;
	public int getTotalCount(){
		return this.totalCount;
	}
	public void setTotalCount(int totalCount){
		this.totalCount=totalCount;
	}

	private int top;
	public int getTop(){
		return this.top;
	}
	public void setTop(int top){
		this.top=top;
	}
	
	private SearchTypeEnum searchType;

	public SearchTypeEnum getSearchType(){
		return this.searchType;
	}
	public void setSearchType(SearchTypeEnum searchType){
		this.searchType=searchType;
	}
	

	private String orderBy;

	public String getOrderBy(){
		return this.orderBy;
	}
	public void setOrderBy(String orderBy){
		this.orderBy=orderBy;
	}

	private String additionalWhereSql;

	public String getAdditionalWhereSql(){
		return this.additionalWhereSql;
	}
	public void setAdditionalWhereSql(String additionalWhereSql){
		this.additionalWhereSql=additionalWhereSql;
	}
}
