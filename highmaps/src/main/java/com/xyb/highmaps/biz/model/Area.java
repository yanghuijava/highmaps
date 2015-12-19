package com.xyb.highmaps.biz.model;

public class Area {
	
	private Integer id;
	private Integer parentId;
	private Integer idcard;
	private String name;
	private Integer level;
	private String drillKey;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Integer getIdcard() {
		return idcard;
	}
	public void setIdcard(Integer idcard) {
		this.idcard = idcard;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public String getDrillKey() {
		return drillKey;
	}
	public void setDrillKey(String drillKey) {
		this.drillKey = drillKey;
	}
	@Override
	public String toString() {
		return "Area [id=" + id + ", parentId=" + parentId + ", idcard="
				+ idcard + ", name=" + name + ", level=" + level
				+ ", drillKey=" + drillKey + "]";
	}
}
