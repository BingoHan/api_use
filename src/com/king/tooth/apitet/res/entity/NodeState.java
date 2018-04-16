package com.king.tooth.apitet.res.entity;

import java.io.Serializable;


/**
 * 节点状态类
 * @author StoneKing
 */
public class NodeState implements Serializable{
	private static final long serialVersionUID = -2385751048368814532L;
	
	private String id;
	private boolean checked;
	private boolean disabled;
	private boolean expanded = true;
	private boolean selected;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	public boolean isDisabled() {
		return disabled;
	}
	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}
	public boolean isExpanded() {
		return expanded;
	}
	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
}
