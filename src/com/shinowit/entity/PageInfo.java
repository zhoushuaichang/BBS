package com.shinowit.entity;

public class PageInfo {

private int pageSize;//一页显示多少条记录
	
	private int currentPageIndex;//当前要显示哪一页
	
	private int recordCount;//总记录数
	
	private int pageCount; //总页数

	
	public void setPageInfo(int recordCount,int pageSize,int currentPageIndex){
		this.recordCount=recordCount;
		this.pageSize=pageSize;
		this.currentPageIndex=currentPageIndex;
		
		this.pageCount=recordCount/pageSize;
		
		if ((recordCount % pageSize)>0){
			this.pageCount++;
		}
	}
	
	/**
	 * 取前一页的页号
	 * @return
	 */
	public int getPriorPageNumber(){
		int i=currentPageIndex-1;
		if (i<1){
			i=1;
		}
		return i;
	}
	
	public int getNextPageNumber(){
		int i=currentPageIndex+1;
		if (i>pageCount){
			i=pageCount;
		}
		return i;
	}
	
	public boolean havePriorPage(){
		return currentPageIndex<=1?false:true;
	}
	
	public boolean haveNextPage(){
		return currentPageIndex>=pageCount?false:true;
	}
	
	public int getCurrentPageIndex() {
		return currentPageIndex;
	}

	public void setCurrentPageIndex(int currentPageIndex) {
		this.currentPageIndex = currentPageIndex;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
}
