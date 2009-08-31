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
	public PermissionsScheme add_permissions_scheme(Long idPermissions,
			String action, String destType, String destValue) throws Exception {
		PermissionsSchemeExample pse = new PermissionsSchemeExample();
		pse.createCriteria().andIdPermissionsEqualTo(idPermissions).andActionEqualTo(action).andDestTypeEqualTo(destType);
		java.util.List<PermissionsScheme> permissionsschemes = permissionsSchemeDAO.selectByExample(pse);
		if(permissionsschemes.size()>0){
			throw new Exception("你已经创建了这种类型得权限了");
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
	public ResourcesPermission bind_permission(String destType,
			String destValue, Long idPermissions) throws Exception {
		ResourcesPermissionExample rpe = new ResourcesPermissionExample();
		rpe.createCriteria().andDestTypeEqualTo(destType).andDestValueEqualTo(destValue);
		java.util.List<ResourcesPermission> resourcespermissions = resourcesPermissionDAO.selectByExample(rpe);
		if(resourcespermissions.size()>0){
			throw new Exception("一个资源只能绑定一个权限");
		}
		ResourcesPermission resourcespermission = new ResourcesPermission();
		resourcespermission.setDestType(destType);
		resourcespermission.setDestValue(destValue);
		resourcespermission.setIdPermissions(idPermissions);
		resourcespermission.setId(resourcesPermissionDAO.insert_return_id(resourcespermission));
		return resourcespermission;
	}

	@Override
	public boolean del_permissions_scheme(Long id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete_permission(Long id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean unbind_permission(Long id) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ResourcesPermission update_bind_permission(Long id, String destType,
			String destValue) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Permission update_permission(Long id, String name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PermissionsScheme update_permissions_scheme(Long id,String destValue) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
