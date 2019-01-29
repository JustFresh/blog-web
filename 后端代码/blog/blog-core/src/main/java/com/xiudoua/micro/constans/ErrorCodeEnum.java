package com.xiudoua.micro.constans;

/**
 * 
 * @desc 错误信息枚举
 * @author JustFresh
 * @time 2018年11月23日 下午4:38:31
 * @site http://www.xiudoua.com
 * @email justfresh@foxmail.com
 */
public enum ErrorCodeEnum {
	
	SUCCESS("200", "操作成功."),
	
	UNSUPPORT_RETURN_TYPE("500-01-00001", "无效数据返回."),
	
	CHANNEL_ID_REQUIRED("500-01-01001", "栏目ID必填."),
    SAVE_CHANNEL_ERROR("500-01-01002", "添加栏目失败."),
    DELETE_CHANNEL_ERROR("500-01-01003", "删除栏目失败."),
    BATCH_DELETE_CHANNEL_ERROR("500-01-01004", "批量删除栏目失败."),
    UPDATE_CHANNEL_ERROR("500-01-01005", "修改栏目失败."),
    GET_ONE_CHANNEL_ERROR("505-01-01006", "查询栏目详情失败."),
    CHANNEL_NAME_MUST_BE_NOT_NULL("505-01-01007", "栏目名必填."),
    
    ARTICLE_ID_REQUIRED("500-01-02001", "文章ID必填."),
    SAVE_ARTICLE_ERROR("500-01-02002", "添加文章失败."),
    DELETE_ARTICLE_ERROR("500-01-02003", "删除文章失败."),
    BATCH_DELETE_ARTICLE_ERROR("500-01-02004", "批量删除文章失败."),
    UPDATE_ARTICLE_ERROR("500-01-02005", "修改文章失败."),
    GET_ONE_ARTICLE_ERROR("505-01-02006", "查询文章详情失败."),
    ARTICLE_TITLE_MUST_BE_NOT_NULL("505-01-02007", "文章标题必填."),
    
    ADMIN_ID_REQUIRED("500-01-03001", "管理员ID必填."),
    SAVE_ADMIN_ERROR("500-01-03002", "添加管理员失败."),
    DELETE_ADMIN_ERROR("500-01-03003", "删除管理员失败."),
    BATCH_DELETE_ADMIN_ERROR("500-01-03004", "批量删除管理员失败."),
    UPDATE_ADMIN_ERROR("500-01-03005", "修改管理员失败."),
    GET_ONE_ADMIN_ERROR("505-01-03006", "查询管理员详情失败."),
    ADMIN_NAME_MUST_BE_NOT_NULL("505-01-03007", "管理员登录名必填."),
    ADMIN_PASSWORD_MUST_BE_NOT_NULL("505-01-03008", "管理员登录密码必填."),
    
    USER_ID_REQUIRED("500-01-04001", "用户ID必填."),
    SAVE_USER_ERROR("500-01-04002", "添加用户失败."),
    DELETE_USER_ERROR("500-01-04003", "删除用户失败."),
    BATCH_DELETE_USER_ERROR("500-01-04004", "批量删除用户失败."),
    UPDATE_USER_ERROR("500-01-04005", "修改用户失败."),
    GET_ONE_USER_ERROR("505-01-04006", "查询用户详情失败."),
    USERNAME_MUST_BE_NOT_NULL("505-01-04007", "登录名必填."),
    PASSWORD_MUST_BE_NOT_NULL("505-01-04008", "登录密码必填."),
    
    COMMENT_ID_REQUIRED("500-01-05001", "评论ID必填."),
    SAVE_COMMENT_ERROR("500-01-05002", "添加评论失败."),
    DELETE_COMMENT_ERROR("500-01-05003", "删除评论失败."),
    BATCH_DELETE_COMMENT_ERROR("500-01-05004", "批量删除评论失败."),
    UPDATE_COMMENT_ERROR("500-01-05005", "修改评论失败."),
    GET_ONE_COMMENT_ERROR("505-01-05006", "查询评论详情失败."),
    COMMENT_CONTENT_MUST_BE_NOT_NULL("505-01-05007", "评论内容必填."),
    
    ADV_ID_REQUIRED("500-01-06001", "广告ID必填."),
    SAVE_ADV_ERROR("500-01-06002", "添加广告失败."),
    DELETE_ADV_ERROR("500-01-06003", "删除广告失败."),
    BATCH_DELETE_ADV_ERROR("500-01-06004", "批量删除广告失败."),
    UPDATE_ADV_ERROR("500-01-06005", "修改广告失败."),
    GET_ONE_ADV_ERROR("505-01-06006", "查询广告详情失败."),
    ADVNAME_MUST_BE_NOT_NULL("505-01-06007", "广告标题必填."),
    ADVURL_MUST_BE_NOT_NULL("505-01-06008", "链接地址必填."),
    POSTIONID_MUST_BE_NOT_NULL("505-01-06009", "广告位必选."),
    
    UPLOAD_FORMAT_IS_WRONG("505-01-07001", "上传文件格式不符."),
    UPLOAD_FAILURE("505-01-07002", "上传失败."),
    UPLOAD_FILE_MUST_BE_NOT_NULL("505-01-07003", "上传文件不能为空."),
    UPLOADING_FILE_IS_TOO_BIG("505-01-07003", "上传文件太大."),
    
    LINKS_ID_REQUIRED("500-01-08001", "友情链接ID必填."),
    SAVE_LINKS_ERROR("500-01-08002", "添加友情链接失败."),
    DELETE_LINKS_ERROR("500-01-08003", "删除友情链接失败."),
    BATCH_DELETE_LINKS_ERROR("500-01-08004", "批量删除友情链接失败."),
    UPDATE_LINKS_ERROR("500-01-08005", "修改友情链接失败."),
    GET_ONE_LINK_ERROR("505-01-08006", "查询友情链接详情失败."),
    LINKS_TITLE_MUST_BE_NOT_NULL("505-01-08007", "友情链接标题必填."),
	;
	
	private String code;
    private String message;

    ErrorCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    @Override
    public String toString() {
        return this.name();
    }
	
}