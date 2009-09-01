package com.twitpic.services.impl;

import com.twitpic.db.dao.PermissionDAO;
import com.twitpic.db.dao.PermissionsSchemeDAO;
import com.twitpic.db.dao.ResourcesPermissionDAO;
import com.twitpic.db.model.Permission;
import com.twitpic.db.model.PermissionExample;
import com.twitpic.db.model.PermissionsScheme;
import com.twitpic.db.model.PermissionsSchemeExample;
import com.twitpic.db.model.ResourcesPermission;
import com.twitpic.db.model.ResourcesPermissionExample;
import com.twitpic.services.PermissionService;

public class PermissionServiceImpl implements PermissionService {
	
	private PermissionDAO permissionDAO;
	
	private PermissionsSchemeDAO permissionsSchemeDAO;
	
	private ResourcesPermissionDAO resourcesPermissionDAO;

	public void setPermissionDAO(PermissionDAO permissionDAO) {
		this.permissionDAO = permissionDAO;
	}

	public void setPermissionsSchemeDAO(PermissionsSchemeDAO permissionsSchemeDAO) {
		this.permissionsSchemeDAO = permissionsSchemeDAO;
	}

	public void setResourcesPermissionDAO(
			ResourcesPermissionDAO resourcesPermissionDAO) {
		this.resourcesPermissionDAO = resourcesPermissionDAO;
	}

	@Override
	public Permission add_permission(String account, String name) throws Exception {
		PermissionExample pe = new PermissionExample();
		pe.createCriteria().andAccountEqualTo(account).andNameEqualTo(name);
		java.util.List<Permission> permissions = permissionDAO.selectByExample(pe);
		if(permissions.size()>0){
			throw new Exception("这个名字你已经创建过了");
		}
		Permission permission = new Permission();
		permission.setAccount(account);
		permission.setName(name);
		permission.setId(permissionDAO.insert_return_id(permission));
		return permission;
	}

	@Override
	public PermissionsScheme add_permissions_scheme(Long idPermissions,String account,
			String action, String destType, String destValue) throws Exception {
		PermissionsSchemeExample pse = new PermissionsSchemeExample();
		pse.createCriteria().andIdPermissionsEqualTo(idPermissions).andActionEqualTo(action).andDestTypeEqualTo(destType);
		java.util.List<PermissionsScheme> permissionsschemes = permissionsSchemeDAO.selectByExample(pse);
		if(permissionsschemes.size()>0){
			throw new Exception("你已经创建了这种类型得权限了");
		}
		Permission permission = permissionDAO.selectByPrimaryKey(idPermissions);
		if(permission==null||!permission.getAccount().equals(account)){
			throw new Exception("无法完成您得请求");
		}
		PermissionsScheme permissionsscheme = new PermissionsScheme();
		permissionsscheme.setAction(action);
		permissionsscheme.setDestType(destType);
		permissionsscheme.setDestValue(destValue);
		permissionsscheme.setIdPermissions(idPermissions);
		permissionsscheme.setId(permissionsSchemeDAO.insert_return_id(permissionsscheme));
		return permissionsscheme;
	}

	@Override
	public ResourcesPermission bind_permission(String account,String destType,
			String destValue, Long idPermissions) throws Exception {
		ResourcesPermissionExample rpe = new ResourcesPermissionExample();
		rpe.createCriteria().andDestTypeEqualTo(destType).andDestValueEqualTo(destValue);
		java.util.List<ResourcesPermission> resourcespermissions = resourcesPermissionDAO.selectByExample(rpe);
		if(resourcespermissions.size()>0){
			throw new Exception("一个资源只能绑定一个权限");
		}
		Permission permission = permissionDAO.selectByPrimaryKey(idPermissions);
		if(permission==null||!permission.getAccount().equals(account)){
			throw new Exception("无法完成您得请求");
		}
		ResourcesPermission resourcespermission = new ResourcesPermission();
		resourcespermission.setDestType(destType);
		resourcespermission.setDestValue(destValue);
		resourcespermission.setIdPermissions(idPermissions);
		resourcespermission.setId(resourcesPermissionDAO.insert_return_id(resourcespermission));
		return resourcespermission;
	}

	@Override
	public boolean del_permissions_scheme(Long id,String account) throws Exception {
		PermissionsScheme permissionsscheme = permissionsSchemeDAO.selectByPrimaryKey(id);
		if(permissionsscheme!=null){
			Permission permission = permissionDAO.selectByPrimaryKey(permissionsscheme.getIdPermissions());
			if(permission!=null&&permission.getAccount().equals(account)){
				permissionsSchemeDAO.deleteByPrimaryKey(id);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean delete_permission(Long id,String account) throws Exception {
		Permission permission = permissionDAO.selectByPrimaryKey(id);
		if(permission!=null&&permission.getAccount().equals(account)){
			//delete scheme
			PermissionsSchemeExample pse = new PermissionsSchemeExample();
			pse.createCriteria().andIdPermissionsEqualTo(id);
			permissionsSchemeDAO.deleteByExample(pse);
			//delete bind resources
			ResourcesPermissionExample rpe = new ResourcesPermissionExample();
			rpe.createCriteria().andIdPermissionsEqualTo(id);
			resourcesPermissionDAO.deleteByExample(rpe);
			//delete permission
			permissionDAO.deleteByPrimaryKey(id);
			
			return true;
		}
		return false;
	}

	@Override
	public boolean unbind_permission(Long id,String account) throws Exception {
		ResourcesPermission resourcespermission = resourcesPermissionDAO.selectByPrimaryKey(id);
		if(resourcespermission!=null){
			Permission permission = permissionDAO.selectByPrimaryKey(resourcespermission.getIdPermissions());
			if(permission!=null&&permission.getAccount().equals(account)){
				resourcesPermissionDAO.deleteByPrimaryKey(id);
				return true;
			}
		}
		return false;
	}

	@Override
	public ResourcesPermission update_bind_permission(Long id,String account, String destType,
			String destValue) throws Exception {
		ResourcesPermission resourcespermission = resourcesPermissionDAO.selectByPrimaryKey(id);
		if(resourcespermission!=null){
			Permission permission = permissionDAO.selectByPrimaryKey(resourcespermission.getIdPermissions());
			if(permission!=null&&permission.getAccount().equals(account)){
				resourcespermission.setDestType(destType);
				resourcespermission.setDestValue(destValue);
				resourcesPermissionDAO.updateByPrimaryKeySelective(resourcespermission);
				return resourcespermission;
			}
		}
		throw new Exception("无法更新该资源的权限");
	}

	@Override
	public Permission update_permission(Long id,String account, String name) throws Exception {
		Permission permission = permissionDAO.selectByPrimaryKey(id);
		if(permission!=null&&permission.getAccount().equals(account)){
			permission.setName(name);
			permissionDAO.updateByPrimaryKeySelective(permission);
			return permission;
		}
		throw new Exception("无法更新权限名字");
	}

	@Override
	public PermissionsScheme update_permissions_scheme(Long id,String account,String destType,String destValue) throws Exception {
		PermissionsScheme permissionsscheme = permissionsSchemeDAO.selectByPrimaryKey(id);
		if(permissionsscheme!=null){
			Permission permission = permissionDAO.selectByPrimaryKey(permissionsscheme.getIdPermissions());
			if(permission!=null&&permission.getAccount().equals(account)&&permissionsscheme.getDestType().equals(destType)){
				permissionsscheme.setDestValue(destValue);
				permissionsSchemeDAO.updateByPrimaryKeySelective(permissionsscheme);
				return permissionsscheme;
			}
		}
		throw new Exception("无法更新权限配置");
	}

}
