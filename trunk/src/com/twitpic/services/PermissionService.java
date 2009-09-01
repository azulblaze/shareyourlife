package com.twitpic.services;

public interface PermissionService {
	/**
	 * add a permission
	 * @param account
	 * @param name
	 * @return
	 */
	public com.twitpic.db.model.Permission add_permission(String account,String name) throws Exception;
	/**
	 * delete permission by id
	 * @param id
	 * @return
	 */
	public boolean delete_permission(Long id,String account) throws Exception;
	/**
	 * update permission name by id
	 * @param id
	 * @param name
	 * @return
	 */
	public com.twitpic.db.model.Permission update_permission(Long id,String account,String name) throws Exception;
	/**
	 * bind permission to resource
	 * @param dest_type
	 * @param dest_value
	 * @param id_permissions
	 * @return
	 */
	public com.twitpic.db.model.ResourcesPermission bind_permission(String account,String dest_type,String dest_value,Long id_permissions) throws Exception;
	/**
	 * unbind permission
	 * @param id
	 * @return
	 */
	public boolean unbind_permission(Long id,String account) throws Exception;
	/**
	 * update the parameter of the binding
	 * @param id
	 * @param dest_type
	 * @param dest_value
	 * @return
	 */
	public com.twitpic.db.model.ResourcesPermission update_bind_permission(Long id,String account,String dest_type,String dest_value) throws Exception;
	/**
	 * add permission scheme
	 * @param id_permissions
	 * @param action
	 * @param dest_type
	 * @param dest_value
	 * @return
	 */
	public com.twitpic.db.model.PermissionsScheme add_permissions_scheme(Long id_permissions,String account,String action,String dest_type,String dest_value) throws Exception;
	/**
	 * delete the permission scheme
	 * @param id
	 * @return
	 */
	public boolean del_permissions_scheme(Long id,String account) throws Exception;
	/**
	 * update the permission scheme
	 * @param id
	 * @param dest_value
	 * @return
	 */
	public com.twitpic.db.model.PermissionsScheme update_permissions_scheme(Long id,String account,String destType,String dest_value) throws Exception;
	
}
