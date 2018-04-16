package com.king.tooth.apitet.res.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.king.tooth.apitet.res.entity.ParentNode;
import com.king.tooth.apitet.res.entity.SubNode;
import com.king.tooth.apitet.res.hibernateutil.HibernateUtil1;

public class SubNodeDao {

	/*public List<NodeNo1> findAllDymResModule() {
		Session session = HibernateUtil1.getCurrentSession();
		String hql ="from NodeNo1 where projId is not null";
		Query query=session.createQuery(hql);
		List<NodeNo1> l =query.list();
		session.close();
		return l;
	}*/
	
	public List<ParentNode> findAllDymResModule(){
		Session session = HibernateUtil1.getCurrentSession();
		String hql ="select id,text,caption from ParentNode where projId is not null";
		Query query=session.createQuery(hql);
		List<Object[]> l =query.list();
		List<ParentNode>list=new ArrayList<ParentNode>();
		for (Object[] objects : l) {
			ParentNode no = new ParentNode();
			list.add(no);
			no.setId(objects[0]+"");
			String text=objects[1]+"";
			if(objects[2]!=null && !"".equals(objects[2].toString())){
				text+="("+objects[2]+")";
			}else{
				text+="()";
			}
			no.setText(text);
		}
		session.close();
		return list;
		
		
		
	}

	/*public static List<NodeNo2> findSubResModule(String id) {
		Session session = HibernateUtil1.getCurrentSession();
		String hql="from NodeNo2 where  drmId ='"+id+"'";
		Query query=session.createQuery(hql);
		List<NodeNo2> resTreeNode=query.list();
		
		session.close();
		return resTreeNode;
	}
	*/

	
	public static List<SubNode> findSubResModule(String id) {
		Session session = HibernateUtil1.getCurrentSession();
		String hql="select id,ownerAssembly ,text from SubNode where  drmId ='"+id+"'";
		 Query query=session.createQuery(hql);
		 
		List<Object[]> resTreeNode=query.list();
		List<SubNode> li= new ArrayList<SubNode>();
		for (Object[] obj : resTreeNode) {
			SubNode n2= new SubNode();
			li.add(n2);
			n2.setId(obj[0].toString());
			String text=obj[1].toString();
			text+="."+obj[2];
			n2.setText(text);
		}
		session.close();
		return li;
	}

	
}
