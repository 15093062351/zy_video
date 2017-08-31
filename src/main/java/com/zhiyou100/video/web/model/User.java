package com.zhiyou100.video.web.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.zhiyou100.video.web.utils.MD5Utils;

public class User {
    private Integer id;

    private String nickName;

    private Integer sex;
    
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthday;

    private String email;

    private String province;

    private String city;

    private String headUrl;

    private String password;

    private Date insertTime;

    private Date updateTime;

    private String captcha;

    private String uPic;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getHeadUrl() {
		return headUrl;
	}

	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public String getuPic() {
		return uPic;
	}

	public void setuPic(String uPic) {
		this.uPic = uPic;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", nickName=" + nickName + ", sex=" + sex + ", birthday=" + birthday + ", email="
				+ email + ", province=" + province + ", city=" + city + ", headUrl=" + headUrl + ", password="
				+ password + ", insertTime=" + insertTime + ", updateTime=" + updateTime + ", captcha=" + captcha
				+ ", uPic=" + uPic + "]";
	}

    
    
    
    
    
    
}