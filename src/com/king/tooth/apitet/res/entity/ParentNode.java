package com.king.tooth.apitet.res.entity;

import java.util.List;

public class ParentNode {
	private String id;
	private String text;// 显示的名字
	private String projId;
	private NodeState nodeState;
	public ParentNode() {
		nodeState = new NodeState();
	}
	public NodeState getNodeState() {
		return nodeState;
	}
	public void setNodeState(NodeState nodeState) {
		this.nodeState = nodeState;
	}
	private String caption;
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	private List<SubNode> nodes;// 子节点
	public String getProjId() {
		return projId;
	}
	public void setProjId(String projId) {
		this.projId = projId;
	}
	public List<SubNode> getNodes() {
		return nodes;
	}
	public void setNodes(List<SubNode> nodes) {
		this.nodes = nodes;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	

}
