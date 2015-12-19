package com.xyb.highmaps.web.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class TreeDto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private Integer pid;
	private String text;
	private String value;
	private String iconCls;
	private String state = "closed";
	private Boolean checked = false;
	private Map<String, Object> attributes;
	private List<TreeDto> children;
	public TreeDto() {
		
	}
	public TreeDto(String text) {
		id = 0;
		this.text = text;
		state = "open";
	}
	
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public TreeDto(Integer id, String text) {
		this.id = id;
		this.text = text;
		state = "open";
	}
	
	public final Map<String, Object> getAttributes() {
		return attributes;
	}
	public final Boolean getChecked() {
		return checked;
	}
	public List<TreeDto> getChildren() {
		return children;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getState() {
		return state;
	}
	public String getText() {
		return text;
	}
	public final String getValue() {
		return value;
	}
	public final void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}
	public final void setChecked(Boolean checked) {
		this.checked = checked;
	}
	public void setChildren(List<TreeDto> children) {
		this.children = children;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setText(String text) {
		this.text = text;
	}
	public final void setValue(String value) {
		this.value = value;
	}


}
