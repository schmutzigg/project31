package com.xiandian.cloud.storage.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.xiandian.cloud.storage.domain.ShareBean;

@Repository
public class ShareDao extends BaseDao<ShareBean> {

/*	public boolean insertShareFile(ShareBean shareBean) {
		
		Long count = super.count("from ShareBean where userid =? and filename=? and type=? ", new Object[]{shareBean.getUserid(),shareBean.getFilename(),shareBean.getType()});
		if(count>0){
			ShareBean sb = super.get("from ShareBean where userid =? and filepath=? and type=?",  new Object[]{shareBean.getUserid(),shareBean.getFilepath(),shareBean.getType()});
			sb.setUserid(shareBean.getUserid());
			sb.setType(shareBean.getType());
			sb.setFilename(shareBean.getFilename());
			sb.setIsdir(shareBean.getIsdir());
			sb.setFilepath(shareBean.getFilepath());
			sb.setHttp(shareBean.getHttp());
			sb.setPwd(shareBean.getPwd());
			sb.setData(shareBean.getData());
			super.update(sb);
		}else{
			super.save(shareBean);
		}

		return true;
	}*/

	public List getUsernameBynum(String num) {
		List findSql = super.findSql("select s.id,s.filename,s.filepath,s.userid,s.type,s.pwd,s.isdir from t_user u,t_sharefile s where s.userid=u.id and s.http like ?", new Object[]{"%"+num});
		if(findSql==null||findSql.size()<1){
			return null;
		}
	//	return findSql.get(0);
		return findSql;
	}

		public List<ShareBean> queryShareInfoByUserId(Integer id) {
		List<ShareBean> find = super.find("from ShareBean where userid=? order by date desc", new Object[]{id});
		return find;
	}

	public boolean cancelShare(int id) {
		ShareBean shareBean = super.get(id);
		if(shareBean!=null){
			super.remove(shareBean);
			return true;
		}else{
			return false;
		}
	}

}
