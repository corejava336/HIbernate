package com.nt.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import antlr.Version;

public class Mobile_Customer implements Serializable 
{

private static final long serialVersionUID = 1L;
private Integer cid;
private String cname;
private String callerTune;
private Integer VersionCount;
private long mobileNo;
public Integer getCid() {
	return cid;
}
public void setCid(Integer cid) {
	this.cid = cid;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
public String getCallerTune() {
	return callerTune;
}
public void setCallerTune(String callerTune) {
	this.callerTune = callerTune;
}
public Integer getVersionCount() {
	return VersionCount;
}
public void setVersionCount(Integer versionCount) {
	VersionCount = versionCount;
}
public long getMobileNo() {
	return mobileNo;
}
public void setMobileNo(long mobileNo) {
	this.mobileNo = mobileNo;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}
@Override
public String toString() {
	return "Mobile_Customer [cid=" + cid + ", cname=" + cname + ", callerTune=" + callerTune + ", VersionCount="
			+ VersionCount + ", mobileNo=" + mobileNo + "]";
}

}
