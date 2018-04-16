package com.king.tooth.apitet.res.entity;


import java.io.Serializable;
import java.util.List;

/**
 * 资源树节点类
 * @author StoneKing
 */
public class SubNode implements Serializable{
	private static final long serialVersionUID = -45230936512576467L;
	
	private String id;
	private String text;// 显示的名字
	private String drmId;
	private NodeState nodeState;
	public NodeState getNodeState() {
		return nodeState;
	}
	public void setNodeState(NodeState nodeState) {
		this.nodeState = nodeState;
	}
	private String ownerAssembly;
	public String getOwnerAssembly() {
		return ownerAssembly;
	}
	public void setOwnerAssembly(String ownerAssembly) {
		this.ownerAssembly = ownerAssembly;
	}
	public String getDrmId() {
		return drmId;
	}
	public void setDrmId(String drmId) {
		this.drmId = drmId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	private List<SubNode> nodes;// 子节点
	
	public SubNode() {
		
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
	public List<SubNode> getNodes() {
		return nodes;
	}
	public void setNodes(List<SubNode> nodes) {
		this.nodes = nodes;
	}
}
