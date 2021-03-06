package com.xiandian.cloud.storage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiandian.cloud.storage.dao.ShareDao;
import com.xiandian.cloud.storage.domain.ShareBean;

@Service
public class ShareService {
	@Autowired
	private ShareDao shareDao;

/*	public boolean insertShareFile(ShareBean shareBean) {
		return shareDao.insertShareFile(shareBean);
	}*/
	
	public boolean saveShareFile(ShareBean shareBean){
		shareDao.save(shareBean);
		return true;
	}
	

	public List getUsernameBynum(String num) {
		return shareDao.getUsernameBynum(num);
	}

	public List<ShareBean> queryShareInfoByUserId(Integer id) {
		return shareDao.queryShareInfoByUserId(id);
	}

	public boolean cancelShare(int id) {
		return shareDao.cancelShare(id);
	}
	
	public ShareBean getShareBean(int id) {
		return shareDao.get(id);
	}
}
