package com.vcs.admin.common.adminconstant;

public class AdminConstant {

	public static final String SUCCESS_PAGE = "success.jsp";
	public static final String FAILURE_PAGE = "failure.jsp";
	public static final String SELECT_PAGE = "userSelect.jsp";
	public static final String PERMISSION_PAGE = "permissionSelect.jsp";
	public static final String ROLESELECT_PAGE = "roleSelect.jsp";
	public static final String ROLE_PAGE = "roleSelect.jsp";

	public static final String USER_INSERT = "INSERT INTO USER1 VALUES(?,?,?,?,?,?,?)";
	public static final String USER_UPDATE = "UPDATE USER1 SET FIRST_NAME=?, LAST_NAME=?, MOBILE_NUMBER=?, PASSWORD=?, DATE_OF_BIRTH=?, GENDER=? WHERE EMAIL_ID=?";
	public static final String USER_DELETE = "DELETE FROM USER1 WHERE EMAIL_ID=?";
	public static final String USER_SELECT = "SELECT * FROM USER1";

	public static final String ROLE_INSERT = "INSERT INTO ROLE VALUES(?,?)";
	public static final String ROLE_UPDATE = "UPDATE ROLE SET ROLE_NAME=? WHERE ROLE_ID=?";
	public static final String ROLE_DELETE = "DELETE FROM ROLE WHERE ROLE_ID=?";
	public static final String ROLE_SELECT = "SELECT * FROM ROLE";

	public static final String PERMISSION_INSERT = "INSERT INTO PERMISSION VALUES(?,?)";
	public static final String PERMISSION_UPDATE = "UPDATE PERMISSION SET PERMISSION_NAME=? WHERE PERMISSION_ID=?";
	public static final String PERMISSION_DELETE = "DELETE FROM PERMISSION WHERE PERMISSION_ID=?";
	public static final String PERMISSION_SELECT = "SELECT * FROM PERMISSION";

}
