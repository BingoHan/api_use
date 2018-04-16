package com.king.tooth.apitet.res.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.king.tooth.apitet.res.dao.SubNodeDao;
import com.king.tooth.apitet.res.entity.ParentNode;
import com.king.tooth.apitet.res.entity.SubNode;

/**
 * resteasy api测试  服务层
 * @author StoneKing
 */
@Service
public class SubNodeService {

	SubNodeDao dao = new SubNodeDao(); 
	/**
	 * 获取所有的资源树
	 */
	public List<ParentNode> findAllDymResModule() {
		List<ParentNode> nodeNo1 =  dao.findAllDymResModule();
		
		dealSubRes(nodeNo1, true);
		return nodeNo1;
	}

	/**
	 * 递归处理子资源
	 * @param resTreeNodes
	 * @param remove 是否从集合中移除没有子资源的节点
	 */
	private void dealSubRes(List<ParentNode> nodeNo1, boolean remove) {
		List<SubNode> subReses = null;
		for (int i = 0; i < nodeNo1.size(); i++) {
			subReses = dao.findSubResModule(nodeNo1.get(i).getId());
			if(subReses != null && subReses.size() > 0){
				nodeNo1.get(i).setNodes(subReses);
				dealSubRes2(subReses, false);
			}else{
				if(remove){
					nodeNo1.remove(i);
					i--;
				}
			}
		}
	}
	
	
	private void dealSubRes2(List<SubNode> resTreeNodes, boolean remove) {
		List<SubNode> subReses = null;
		for (int i = 0; i < resTreeNodes.size(); i++) {
			subReses = dao.findSubResModule(resTreeNodes.get(i).getId());
			if(subReses != null && subReses.size() > 0){
				resTreeNodes.get(i).setNodes(subReses);
			}else{
				if(remove){
					resTreeNodes.remove(i);
					i--;
				}
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
