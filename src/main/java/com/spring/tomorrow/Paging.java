package com.spring.tomorrow;

public class Paging {

	private int pageSize = 10;
	private int blockSize = 10;
	private int curPage=1;
	private int curBlock=1;
	private int totalCount;
	private int totalPage;
	private int totalBlock;
	private int startPage=1;
	private int endPage=1;

	public Paging(int totalCount, int curPage) {
		setTotalCount(totalCount);
		setTotalPage(totalCount);
		setCurPage(curPage);
		setTotalBlock(curPage);
		setCurBlock(curPage);
		setStartPage(curBlock);
		setEndPage(startPage);

	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getBlockSize() {
		return blockSize;
	}

	public void setBlockSize(int blockSize) {
		this.blockSize = blockSize;
	}

	public int getCurPage() {
		return curPage;
	}

	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	public int getCurBlock() {
		return curBlock;
	}

	public void setCurBlock(int curPage) {
		this.curBlock = (int)Math.ceil((double)(curPage-1)/blockSize)+1;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int total) {
		this.totalPage = (int) Math.ceil((double)totalCount / pageSize);
	}

	public int getTotalBlock() {
		return totalBlock;
	}

	public void setTotalBlock(int totalPage) {
		this.totalBlock = (int)Math.ceil((double)totalCount/blockSize);
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int curBlock) {
		this.startPage = (curBlock - 1)* blockSize + 1;
	}

	public int getEndPage() {
		return endPage;

	}

	public void setEndPage(int startPage) {
		this.endPage = startPage + blockSize - 1;
		if(endPage>=totalPage)
			this.endPage=totalPage;
		
	}

}
