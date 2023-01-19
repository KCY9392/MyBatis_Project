package com.kh.mybatis.board.model.vo;

import java.sql.Date;

import com.kh.mybatis.member.model.vo.Member;

public class Reply {

	private int replyNo;
	private String replyContent;
	private String replyWriter;
	private int refBNo;
	private Date createDate;
	private String status;
	private Member member;
	
	
	public Reply() {
		super();
	}


	public Reply(int replyNo, String replyContent,String replyWriter, int refBNo, Date createDate, String status) {
		super();
		this.replyNo = replyNo;
		this.replyContent = replyContent;
		this.replyWriter = replyWriter;
		this.refBNo = refBNo;
		this.createDate = createDate;
		this.status = status;
	}


	public Reply(int replyNo, String replyContent, String replyWriter, int refBNo, Date createDate, String status,
			Member member) {
		super();
		this.replyNo = replyNo;
		this.replyContent = replyContent;
		this.replyWriter = replyWriter;
		this.refBNo = refBNo;
		this.createDate = createDate;
		this.status = status;
		this.member = member;
	}


	public Member getMember() {
		return member;
	}


	public void setMember(Member member) {
		this.member = member;
	}


	public int getReplyNo() {
		return replyNo;
	}


	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}


	public String getReplyContent() {
		return replyContent;
	}


	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}


	public int getRefBNo() {
		return refBNo;
	}


	public void setRefBNo(int refBNo) {
		this.refBNo = refBNo;
	}


	public Date getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	
	
	public String getReplyWriter() {
		return replyWriter;
	}


	public void setReplyWriter(String replyWriter) {
		this.replyWriter = replyWriter;
	}


	@Override
	public String toString() {
		return "Reply [replyNo=" + replyNo + ", replyContent=" + replyContent + ", replyWriter=" + replyWriter
				+ ", refBNo=" + refBNo + ", createDate=" + createDate + ", status=" + status + ", member=" + member
				+ "]";
	}


	
}
