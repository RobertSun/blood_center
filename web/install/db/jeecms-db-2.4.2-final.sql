SET storage_engine=INNODB;


/*==============================================================*/
/* Table: ARTI_ARTICLE                                          */
/*==============================================================*/
create table ARTI_ARTICLE
(
   ARTICLE_ID           bigint not null auto_increment,
   WEBSITE_ID           bigint not null,
   CONFIG_ID            bigint not null,
   CTTCTG_ID            bigint not null,
   NEXT_ID              bigint comment '下一篇',
   PRE_ID               bigint comment '上一篇',
   GROUP_ID             bigint comment '允许浏览会员组',
   CHANNEL_ID           bigint not null comment '栏目ID',
   MEMBER_ID            bigint comment '录入会员',
   ADMIN_CHECK          bigint comment '审核管理员',
   ADMIN_DISABLE        bigint comment '禁用管理员',
   ADMIN_INPUT          bigint comment '录入管理员',
   TITLE                varchar(255) comment '文章标题',
   SHORT_TITLE          varchar(255) comment '简短标题（用于栏目或首页索引）',
   TITLE_COLOR          varchar(10) comment '标题颜色',
   TITLE_IMG            varchar(100) comment '文章标题缩略图',
   CONTENT_IMG          varchar(100) comment '文章内容图',
   DESCRIPTION          varchar(255) comment '文章描述',
   TAGS                 varchar(255) comment '标记，类似关键字',
   AUTHOR               varchar(100) comment '作者',
   ORIGIN               varchar(100) comment '来源',
   SORT_DATE            datetime not null comment '排序日期（通过置顶时间调整）',
   RELEASE_DATE         datetime not null comment '发表日期（可人为设置）',
   RELEASE_SYS_DATE     datetime not null comment '发布日期（系统日期）',
   CHECK_TIME           datetime comment '终审通过时间',
   DISABLE_TIME         datetime comment '禁用时间',
   VISIT_TOTAL          bigint not null default 0 comment '总共访问次数',
   VISIT_TODAY          bigint not null default 0 comment '当天访问次数',
   VISIT_WEEK           bigint not null default 0 comment '本周下载次数',
   VISIT_MONTH          bigint not null default 0 comment '本月下载次数',
   VISIT_QUARTER        bigint not null default 0 comment '本季下载次数',
   VISIT_YEAR           bigint not null default 0 comment '本年下载次数',
   STAT_DATE            date comment '统计时间',
   OUTER_URL            varchar(255) comment '外部链接',
   CONTENT_RES_PATH     varchar(200) comment '文章内容的资源路径',
   PAGE_COUNT           int comment '文章总页数',
   TPL_CONTENT          varchar(100) comment '指定模板',
   CHECK_STEP           int not null default 0 comment '审核级数',
   TOP_LEVEL            int not null default 0 comment '置顶级别',
   COMMENT_COUNT        int not null default 0 comment '评论数量',
   CHECK_OPINION        varchar(255) comment '审核意见',
   RELATED_IDS          varchar(255) comment '相关文章ID',
   HAS_TITLEIMG         bool not null default 0 comment '是否有标题图片',
   ALLOW_COMMENT        bool not null default 1 comment '是否允许评论',
   IS_BOLD              bool not null default 0 comment '是否加粗',
   IS_DRAFT             bool not null default 0 comment '是否草稿',
   IS_RECOMMEND         bool not null default 0 comment '是否推荐',
   IS_CHECK             bool not null default 1 comment '是否审核',
   IS_DISABLED          bool not null default 0 comment '是否禁用',
   IS_REJECT            bool not null default 0 comment '是否驳回',
   PARAM1               varchar(255) comment '文章相关数据1',
   PARAM2               varchar(255) comment '文章相关数据2',
   PARAM3               varchar(255) comment '文章相关数据3',
   DEF_STRING_1         varchar(255) comment '自定义字符串1',
   DEF_STRING_2         varchar(255) comment '自定义字符串2',
   DEF_STRING_3         varchar(255) comment '自定义字符串3',
   DEF_STRING_4         varchar(255) comment '自定义字符串4',
   DEF_STRING_5         varchar(255) comment '自定义字符串5',
   DEF_STRING_6         varchar(255) comment '自定义字符串6',
   DEF_STRING_7         varchar(255) comment '自定义字符串7',
   DEF_STRING_8         varchar(255) comment '自定义字符串8',
   DEF_STRING_9         varchar(255) comment '自定义字符串9',
   DEF_LONG_1           bigint comment '自定义长整数1',
   DEF_LONG_2           bigint comment '自定义长整数1',
   DEF_LONG_3           bigint comment '自定义长整数1',
   DEF_LONG_4           bigint comment '自定义长整数1',
   DEF_LONG_5           bigint comment '自定义长整数1',
   DEF_MONEY1           numeric(12,2) comment '自定义金额1',
   DEF_MONEY2           numeric(12,2) comment '自定义金额2',
   DEF_MONEY3           numeric(12,2) comment '自定义金额3',
   DEF_DATE1            datetime comment '自定义日期1',
   DEF_DATE2            datetime comment '自定义日期2',
   DEF_DATE3            datetime comment '自定义日期3',
   DEF_BOOL1            bool comment '自定义布尔1',
   DEF_BOOL2            bool comment '自定义布尔2',
   DEF_BOOL3            bool comment '自定义布尔3',
   primary key (ARTICLE_ID)
);

/*==============================================================*/
/* Index: ARTICLE_TOPLEVEL                                      */
/*==============================================================*/
create index ARTICLE_TOPLEVEL on ARTI_ARTICLE
(
   TOP_LEVEL
);

/*==============================================================*/
/* Index: ARTICLE_SOTE_DATE                                     */
/*==============================================================*/
create index ARTICLE_SOTE_DATE on ARTI_ARTICLE
(
   SORT_DATE
);

/*==============================================================*/
/* Index: ARTICLE_RELEASE_DATE                                  */
/*==============================================================*/
create index ARTICLE_RELEASE_DATE on ARTI_ARTICLE
(
   RELEASE_DATE
);

/*==============================================================*/
/* Index: ARTICLE_DISABLED                                      */
/*==============================================================*/
create index ARTICLE_DISABLED on ARTI_ARTICLE
(
   IS_DISABLED
);

/*==============================================================*/
/* Index: ARTICLE_CHECK                                         */
/*==============================================================*/
create index ARTICLE_CHECK on ARTI_ARTICLE
(
   IS_CHECK
);

/*==============================================================*/
/* Index: ARTICLE_RECOMMENT                                     */
/*==============================================================*/
create index ARTICLE_RECOMMENT on ARTI_ARTICLE
(
   IS_RECOMMEND
);

/*==============================================================*/
/* Table: ARTI_ARTICLE_ATTACHMENT                               */
/*==============================================================*/
create table ARTI_ARTICLE_ATTACHMENT
(
   ARTICLE_ID           bigint not null,
   ATTACHMENT_ID        bigint not null,
   primary key (ARTICLE_ID, ATTACHMENT_ID)
);

/*==============================================================*/
/* Table: AUXI_CONFIG                                           */
/*==============================================================*/
create table AUXI_CONFIG
(
   CONFIG_ID            bigint not null,
   MSG_NEED_CHECK       bool default 0 comment '留言板是否需要审核',
   MSG_IS_OPEN          bool default 1 comment '留言板是否开放',
   MSG_ANONYMITY        varchar(20) default '匿名网友' comment '留言板匿名网友名称',
   MSG_MAX_SIZE         int default 16384 comment '留言板留言大小(字节)',
   primary key (CONFIG_ID)
)
comment = "辅助系统配置表";

/*==============================================================*/
/* Table: AUXI_MSG                                              */
/*==============================================================*/
create table AUXI_MSG
(
   MSG_ID               bigint not null auto_increment,
   ADMIN_ID             bigint,
   MSGCTG_ID            bigint not null,
   WEBSITE_ID           bigint not null,
   MEMBER_ID            bigint,
   CONFIG_ID            bigint not null,
   TITLE                varchar(200) comment '留言标题',
   CONTENT_MEMBER       longtext comment '留言内容',
   CONTENT_ADMIN        longtext comment '回复内容',
   EMAIL                varchar(100) comment '电子邮箱',
   PHONE                varchar(100) comment '联系电话',
   QQ                   varchar(50) comment 'QQ',
   IP                   varchar(20) comment '留言IP',
   CREATE_TIME          datetime comment '留言时间',
   REPLY_TIME           datetime comment '回复时间',
   IS_CHECK             bool not null comment '是否审核',
   IS_RECOMMEND         bool not null comment '是否推荐',
   IS_DISABLED          bool not null comment '是否禁用',
   primary key (MSG_ID)
)
comment = "留言板留言";

/*==============================================================*/
/* Table: AUXI_MSG_CTG                                          */
/*==============================================================*/
create table AUXI_MSG_CTG
(
   MSGCTG_ID            bigint not null auto_increment,
   WEBSITE_ID           bigint not null,
   NAME                 varchar(50),
   DESCRIPTION          varchar(250),
   primary key (MSGCTG_ID)
)
comment = "留言类别";

/*==============================================================*/
/* Table: CMS_ADMIN                                             */
/*==============================================================*/
create table CMS_ADMIN
(
   ADMIN_ID             bigint not null,
   WEBSITE_ID           bigint not null,
   CHECK_RIGHT          int not null default 0 comment '审核级别（第几审）',
   IS_SELF_ONLY         bool not null default 0 comment '只允许修改自己的数据',
   primary key (ADMIN_ID)
)
comment = "jeecms管理员";

/*==============================================================*/
/* Table: CMS_ADMIN_CHANNEL                                     */
/*==============================================================*/
create table CMS_ADMIN_CHANNEL
(
   CHANNEL_ID           bigint not null,
   ADMIN_ID             bigint not null,
   primary key (CHANNEL_ID, ADMIN_ID)
);

/*==============================================================*/
/* Table: CMS_ARTICLE_TOPIC                                     */
/*==============================================================*/
create table CMS_ARTICLE_TOPIC
(
   TOPIC_ID             bigint not null,
   ARTICLE_ID           bigint not null,
   primary key (TOPIC_ID, ARTICLE_ID)
);

/*==============================================================*/
/* Table: CMS_CHANNEL                                           */
/*==============================================================*/
create table CMS_CHANNEL
(
   CHANNEL_ID           bigint not null auto_increment,
   WEBSITE_ID           bigint not null,
   CONFIG_ID            bigint not null,
   GROUP_CONTRI_ID      bigint comment '投稿会员组',
   GROUP_VISIT_ID       bigint comment '访问会员组',
   PARENT               bigint comment '父栏目',
   MODEL_ID             bigint not null comment '模型',
   SYS_TYPE             varchar(20) not null comment '系统类型',
   PATH                 varchar(100) comment '栏目路径',
   LFT                  int not null default 1 comment '树左边',
   RGT                  int not null default 2 comment '树右边',
   NAME                 varchar(100) comment '栏目名称',
   CONTENT              longtext comment '栏目内容',
   TITLE_IMG            varchar(100) comment '栏目缩略图',
   CONTENT_IMG          varchar(100) comment '栏目内容图',
   TPL_INDEX            varchar(100) comment '栏目页模板路径',
   TPL_CONTENT          varchar(100) comment '内容页模板路径',
   TITLE                varchar(255) comment 'TITLE',
   KEYWORDS             varchar(255) comment 'KEYWORDS',
   DESCRIPTION          varchar(255) comment 'DESCRIPTION',
   DOC_COUNT            int not null default 0 comment '文档数量',
   VISIT_TOTAL          bigint comment '总共访问次数',
   VISIT_TODAY          bigint comment '当天访问次数',
   STAT_DATE            date comment '统计日期',
   OUTER_URL            varchar(255) comment '外部链接',
   PRIORITY             int not null default 10 comment '栏目排列顺序',
   HAS_TITLEIMG         bool not null default 0 comment '是否有标题图片',
   HAS_CHILD            bool not null default 1 comment '是否可以有子节点',
   IS_DISPLAY           bool not null default 1 comment '是否显示',
   PARAM1               varchar(255) comment '栏目相关数据1',
   PARAM2               varchar(255) comment '栏目相关数据2',
   PARAM3               varchar(255) comment '栏目相关数据3',
   DEF_STRING_1         varchar(255) comment '自定义字符串1',
   DEF_STRING_2         varchar(255) comment '自定义字符串2',
   DEF_STRING_3         varchar(255) comment '自定义字符串3',
   DEF_STRING_4         varchar(255) comment '自定义字符串4',
   DEF_STRING_5         varchar(255) comment '自定义字符串5',
   DEF_STRING_6         varchar(255) comment '自定义字符串6',
   DEF_STRING_7         varchar(255) comment '自定义字符串7',
   DEF_STRING_8         varchar(255) comment '自定义字符串8',
   DEF_STRING_9         varchar(255) comment '自定义字符串9',
   DEF_LONG_1           bigint comment '自定义长整数1',
   DEF_LONG_2           bigint comment '自定义长整数1',
   DEF_LONG_3           bigint comment '自定义长整数1',
   DEF_LONG_4           bigint comment '自定义长整数1',
   DEF_LONG_5           bigint comment '自定义长整数1',
   DEF_MONEY1           numeric(12,2) comment '自定义金额1',
   DEF_MONEY2           numeric(12,2) comment '自定义金额2',
   DEF_MONEY3           numeric(12,2) comment '自定义金额3',
   DEF_DATE1            datetime comment '自定义日期1',
   DEF_DATE2            datetime comment '自定义日期2',
   DEF_DATE3            datetime comment '自定义日期3',
   DEF_BOOL1            bool comment '自定义布尔1',
   DEF_BOOL2            bool comment '自定义布尔2',
   DEF_BOOL3            bool comment '自定义布尔3',
   primary key (CHANNEL_ID)
);

/*==============================================================*/
/* Index: CHANNEL_LFT                                           */
/*==============================================================*/
create index CHANNEL_LFT on CMS_CHANNEL
(
   LFT
);

/*==============================================================*/
/* Index: CHANNEL_RGT                                           */
/*==============================================================*/
create index CHANNEL_RGT on CMS_CHANNEL
(
   RGT
);

/*==============================================================*/
/* Index: CHANNEL_SYSTYPE                                       */
/*==============================================================*/
create index CHANNEL_SYSTYPE on CMS_CHANNEL
(
   SYS_TYPE
);

/*==============================================================*/
/* Index: CHANNEL_PATH                                          */
/*==============================================================*/
create index CHANNEL_PATH on CMS_CHANNEL
(
   PATH
);

/*==============================================================*/
/* Table: CMS_CHANNEL_ATTCHMENT                                 */
/*==============================================================*/
create table CMS_CHANNEL_ATTCHMENT
(
   ATTACHMENT_ID        bigint not null,
   CHANNEL_ID           bigint not null,
   primary key (ATTACHMENT_ID, CHANNEL_ID)
);

/*==============================================================*/
/* Table: CMS_CHNL_MODEL                                        */
/*==============================================================*/
create table CMS_CHNL_MODEL
(
   MODEL_ID             bigint not null auto_increment,
   WEBSITE_ID           bigint not null,
   SYS_TYPE             varchar(20) comment '系统类型',
   NAME                 varchar(100) comment '模型名称',
   SHORT_NAME           varchar(20) comment '简称',
   TPL_PREFIX_CHANNEL   varchar(20) comment '栏目模板前缀',
   TPL_PREFIX_CONTENT   varchar(20) comment '内容模板前缀',
   PRIORITY             int not null default 10 comment '排列顺序',
   IS_DISPLAY           bool not null default 1 comment '是否显示',
   HAS_CHILD            bool not null default 1 comment '是否可以有子栏目',
   primary key (MODEL_ID)
)
comment = "栏目模型";

/*==============================================================*/
/* Table: CMS_CHNL_MODEL_ITEM                                   */
/*==============================================================*/
create table CMS_CHNL_MODEL_ITEM
(
   MITEM_ID             bigint not null auto_increment,
   MODEL_ID             bigint not null,
   MITEM_TYPE           int not null default 1 comment '模型项类型',
   NAME                 varchar(100) not null comment '表单名称',
   LABEL                varchar(100) comment 'LABEL名称',
   HELP                 varchar(255) comment '帮助信息',
   DATA_TYPE            int comment '数据类型',
   INPUT_TYPE           int comment '表单类型',
   INPUT_SIZE           int comment '输入框size',
   INPUT_WIDTH          int comment 'select宽度',
   TEXTAREA_COLS        int comment '文本区列数',
   TEXTAREA_ROWS        int comment '文本区行数',
   DEF_VALUE            varchar(255) comment '默认值',
   OPTION_VALUE         varchar(255) comment '可选项',
   PRIORITY             int not null comment '排列顺序',
   IS_PREDEFINE         bool not null default 0 comment '是否预定义',
   IS_CHECKED           bool not null default 1 comment '是否选中',
   primary key (MITEM_ID)
)
comment = "栏目模型定义";

/*==============================================================*/
/* Table: CMS_COMMENT                                           */
/*==============================================================*/
create table CMS_COMMENT
(
   COMMENT_ID           bigint not null auto_increment,
   WEBSITE_ID           bigint not null,
   MEMBER_ID            bigint,
   REF_DOC_ID           bigint not null comment '文档引用ID',
   REF_DOC_TYPE         char(4) not null comment '文档类型',
   ADMIN_ID             bigint,
   TITLE                varchar(200) comment '标题',
   CONTENT_MEMBER       longtext comment '会员评论内容',
   CONTENT_ADMIN        longtext comment '管理员回复内容',
   CREATE_TIME          datetime comment '创建时间',
   REPLAY_TIME          datetime comment '回复时间',
   IP                   varchar(50) comment '评论者IP',
   IS_CHECK             bool not null comment '是否审核',
   IS_RECOMMEND         bool not null comment '是否推荐',
   IS_DISABLED          bool not null comment '是否禁用',
   primary key (COMMENT_ID)
)
comment = "jeecms评论表";

/*==============================================================*/
/* Index: COMMENT_DOC_ID                                        */
/*==============================================================*/
create index COMMENT_DOC_ID on CMS_COMMENT
(
   REF_DOC_ID
);

/*==============================================================*/
/* Index: COMMENT_DOC_TYPE                                      */
/*==============================================================*/
create index COMMENT_DOC_TYPE on CMS_COMMENT
(
   REF_DOC_TYPE
);

/*==============================================================*/
/* Table: CMS_CONFIG                                            */
/*==============================================================*/
create table CMS_CONFIG
(
   CONFIG_ID            bigint not null,
   CHECK_COUNT          int not null default 0 comment '内容需要审核的次数',
   DEFAULT_SYSTEM       varchar(20) not null default 'article' comment '默认系统',
   COMMENT_NEED_CHECK   bool not null default 0 comment '评论是否需要审核',
   COMMENT_NEED_LOGIN   bool not null default 0 comment '评论是否需要登录',
   COMMENT_SORT         bool not null default 1 comment '评论排序方式(0:升序,1:降序)',
   COMMENT_MAX_LENGTH   int not null default 16384 comment '评论最大字节',
   REGISTER_STATUS      int default 1 comment '注册方式(0：关闭注册；1：开放注册；2：邀请注册)',
   REGISTER_GROUP       bigint comment '默认会员组ID',
   REGISTER_RULE        longtext comment '网络服务使用协议',
   AUTO_REGISTER        bool default 1 comment '是否自动注册（其他系统注册后，在本系统注册）',
   DEF_ARTICLE_MODEL    bigint comment '默认文章模型',
   DEF_DOWNLOAD_MODEL   bigint comment '默认下载模型',
   IS_CACHE_HOMEPAGE    bool not null default 0 comment '是否缓存首页',
   IS_CACHE_CHANNEL     bool not null default 0 comment '是否缓存栏目页',
   primary key (CONFIG_ID)
)
comment = "jeecms配置表";

/*==============================================================*/
/* Table: CMS_CONTENT_CTG                                       */
/*==============================================================*/
create table CMS_CONTENT_CTG
(
   CTTCTG_ID            bigint not null auto_increment,
   WEBSITE_ID           bigint not null,
   LABEL                varchar(20) not null comment '标识ID',
   NAME                 varchar(50) comment '名称',
   IMG_WIDTH            int default 139 comment '标题图片宽度',
   IMG_HEIGHT           int default 139 comment '标题图片高度',
   HAS_TITLEIMG         bool not null default 1 comment '是否有标题图片',
   IS_DISABLED          bool not null default 0 comment '是否继续使用',
   primary key (CTTCTG_ID)
)
comment = "JEECMS内容属性";

/*==============================================================*/
/* Table: CMS_MEMBER                                            */
/*==============================================================*/
create table CMS_MEMBER
(
   MEMBER_ID            bigint not null,
   WEBSITE_ID           bigint not null,
   GROUP_ID             bigint not null,
   SCORE                int not null default 0 comment '积分',
   COUPON               int not null default 0 comment '点劵',
   UPLOAD_STAT_DATE     date not null comment '上传统计日期',
   UPLOAD_SIZE          int not null default 0 comment '当日上传大小',
   UPLOAD_TOTAL_SIZE    bigint not null default 0 comment '总共上传大小',
   IS_DISABLED          bool not null default 0 comment '是否禁用',
   primary key (MEMBER_ID)
)
comment = "jeecms会员";

/*==============================================================*/
/* Table: CMS_MEMBER_GROUP                                      */
/*==============================================================*/
create table CMS_MEMBER_GROUP
(
   GROUP_ID             bigint not null auto_increment,
   WEBSITE_ID           bigint not null,
   NAME                 varchar(100) comment '组名',
   GROUP_LEVEL          int not null default 10 comment '组等级（越大越高）',
   DESCRIPTION          varchar(255) comment '描述',
   UPLOAD_SIZE          int not null default 0 comment '每天允许上传的总大小',
   primary key (GROUP_ID)
)
comment = "jeecms用户组";

/*==============================================================*/
/* Index: CMSGROUP_LEVEL                                        */
/*==============================================================*/
create index CMSGROUP_LEVEL on CMS_MEMBER_GROUP
(
   GROUP_LEVEL
);

/*==============================================================*/
/* Table: CMS_RECOMMEND_GROUP                                   */
/*==============================================================*/
create table CMS_RECOMMEND_GROUP
(
   RGROUP_ID            bigint not null auto_increment,
   CHANNEL_ID           bigint not null,
   WEBSITE_ID           bigint not null,
   SYS_TYPE             char(4) not null comment '系统类型',
   NAME                 varchar(50) comment '推荐组名',
   DESCRIPTION          varchar(250) comment '描述',
   primary key (RGROUP_ID)
);

/*==============================================================*/
/* Table: CMS_RECOMMEND_ITEM                                    */
/*==============================================================*/
create table CMS_RECOMMEND_ITEM
(
   RITEM_ID             bigint not null auto_increment,
   WEBSITE_ID           bigint not null,
   RGROUP_ID            bigint not null,
   SYS_TYPE             char(4) not null comment '系统类型',
   TITLE                varchar(250) comment '推荐的标题',
   DESCRIPTION          varchar(255) comment '推荐的描述',
   PIC_PATH             varchar(250) comment '图片地址，完整url',
   URL                  varchar(250) comment '推荐链接，完整url',
   COLOR                varchar(20) comment '标题的颜色',
   PRIORITY             int not null comment '优先级（显示的先后顺序）',
   IS_CHECK             bool not null comment '是否审核',
   primary key (RITEM_ID)
);

/*==============================================================*/
/* Table: CMS_TOPIC                                             */
/*==============================================================*/
create table CMS_TOPIC
(
   TOPIC_ID             bigint not null auto_increment,
   WEBSITE_ID           bigint not null,
   NAME                 varchar(150) not null comment '名称',
   KEYWORDS             varchar(255) comment '关键字',
   DESCRIPTION          varchar(255) comment '描述',
   TITLE_IMG            varchar(100) comment '标题图',
   TPL_CHANNEL          varchar(100) comment '模板',
   PRIORITY             int not null comment '排列顺序',
   primary key (TOPIC_ID)
)
comment = "专题表";

/*==============================================================*/
/* Table: CORE_ADMIN                                            */
/*==============================================================*/
create table CORE_ADMIN
(
   ADMIN_ID             bigint not null auto_increment,
   WEBSITE_ID           bigint not null,
   USER_ID              bigint not null,
   CREATE_TIME          datetime not null comment '创建时间',
   IS_DISABLED          bool not null default 0 comment '是否禁用',
   primary key (ADMIN_ID)
)
comment = "核心管理员";

/*==============================================================*/
/* Table: CORE_ADMIN_FUNCTION                                   */
/*==============================================================*/
create table CORE_ADMIN_FUNCTION
(
   ADMIN_ID             bigint not null,
   FUNCTION_ID          bigint not null,
   primary key (ADMIN_ID, FUNCTION_ID)
);

/*==============================================================*/
/* Table: CORE_ADMIN_ROLE                                       */
/*==============================================================*/
create table CORE_ADMIN_ROLE
(
   ROLE_ID              bigint not null,
   ADMIN_ID             bigint not null,
   primary key (ROLE_ID, ADMIN_ID)
);

/*==============================================================*/
/* Table: CORE_ATTACHMENT                                       */
/*==============================================================*/
create table CORE_ATTACHMENT
(
   ATTACHMENT_ID        bigint not null auto_increment,
   WEBSITE_ID           bigint not null,
   USER_ID              bigint,
   NAME                 varchar(50) comment '名称',
   DESCRIPTION          varchar(255) comment '描述',
   FILE_PATH            varchar(100) comment '文件路径',
   FILE_NAME            varchar(50) comment '文件名',
   FILE_SIZE            bigint comment '文件大小（字节）',
   DOWN_COUNT           bigint comment '下载次数',
   OWNER_NAME           varchar(100) comment '所有者名称',
   OWNER_URL            varchar(150) comment '所有者URL',
   OWNER_ID             bigint comment '所有者记录ID',
   OWNER_CTG            varchar(50) comment '所有者类别',
   CREATE_TIME          datetime comment '创建时间',
   IS_FREE              bool not null default 1 comment '是否允许免费下载',
   IS_LOST              bool not null default 0 comment '附件是否丢失',
   IS_PICTURE           bool default 1 comment '是否图片',
   primary key (ATTACHMENT_ID)
)
comment = "附件表";

/*==============================================================*/
/* Table: CORE_FUNCTION                                         */
/*==============================================================*/
create table CORE_FUNCTION
(
   FUNCTION_ID          bigint not null auto_increment,
   PARENT               bigint comment '父功能',
   NAME                 varchar(100),
   URL                  varchar(200),
   FUNCS                longtext comment '功能列表集，用@分割',
   DESCRIPTION          varchar(250),
   PRIORITY             int not null comment '功能菜单排列顺序',
   IS_MENU              bool not null comment '是否为菜单',
   primary key (FUNCTION_ID)
)
comment = "功能表";

/*==============================================================*/
/* Table: CORE_GLOBAL                                           */
/*==============================================================*/
create table CORE_GLOBAL
(
   GLOBAL_ID            bigint not null,
   CONTEXT_PATH         varchar(20) not null default '' comment '部署路径',
   PORT                 int not null default 80 comment '端口号',
   primary key (GLOBAL_ID)
);

/*==============================================================*/
/* Table: CORE_MEMBER                                           */
/*==============================================================*/
create table CORE_MEMBER
(
   MEMBER_ID            bigint not null auto_increment,
   USER_ID              bigint not null,
   WEBSITE_ID           bigint not null,
   NICK_NAME            varchar(50) comment '昵称',
   CREATE_TIME          datetime not null comment '创建时间',
   PERSONAL_WEBSITE     varchar(100) comment '个人网站',
   QQ                   varchar(100) comment 'QQ',
   MSN                  varchar(100) comment 'MSN',
   IS_DISABLED          bool not null default 0 comment '是否禁用',
   primary key (MEMBER_ID)
)
comment = "会员表";

/*==============================================================*/
/* Table: CORE_PRIVATE_MSG                                      */
/*==============================================================*/
create table CORE_PRIVATE_MSG
(
   PRIVMSG_ID           bigint not null,
   TO_USER              bigint not null comment '收信人',
   FROM_USER            bigint not null comment '发信人',
   MSG_TYPE             smallint not null default 1 comment '类型（2：已发，1：已阅，0：未阅）',
   MSG_SUBJECT          varchar(255) comment '主题',
   CREATE_TIME          datetime not null comment '创建时间',
   MSG_IP               varchar(20) not null default '' comment 'IP地址',
   primary key (PRIVMSG_ID)
)
comment = "个人短消息";

/*==============================================================*/
/* Table: CORE_PRIVATE_MSG_TEXT                                 */
/*==============================================================*/
create table CORE_PRIVATE_MSG_TEXT
(
   PRIVMSG_ID           bigint not null,
   MSG_TEXT             longtext comment '个人信息内容',
   primary key (PRIVMSG_ID)
)
comment = "个人消息内容";

/*==============================================================*/
/* Table: CORE_ROLE                                             */
/*==============================================================*/
create table CORE_ROLE
(
   ROLE_ID              bigint not null auto_increment,
   NAME                 varchar(50),
   DESCRIPTION          varchar(250),
   primary key (ROLE_ID)
)
comment = "角色表";

/*==============================================================*/
/* Table: CORE_ROLE_FUNCTION                                    */
/*==============================================================*/
create table CORE_ROLE_FUNCTION
(
   ROLE_ID              bigint not null,
   FUNCTION_ID          bigint not null,
   primary key (ROLE_ID, FUNCTION_ID)
);

/*==============================================================*/
/* Table: CORE_TPL_SOLUTION                                     */
/*==============================================================*/
create table CORE_TPL_SOLUTION
(
   WEBSITE_ID           bigint not null,
   SYSTEM_NAME          varchar(20) not null,
   SOLUTION_NAME        varchar(20)
)
comment = "模板方案表";

/*==============================================================*/
/* Table: CORE_USER                                             */
/*==============================================================*/
create table CORE_USER
(
   USER_ID              bigint not null auto_increment,
   LOGIN_NAME           varchar(50) not null comment '登录名',
   REAL_NAME            varchar(50) comment '真实姓名',
   PASSWORD             char(32) comment '密码',
   EMAIL                varchar(100) not null comment '电子邮箱',
   UNREAD_MSG           int not null default 0 comment '未读消息',
   FAX                  varchar(255) comment '传真',
   TEL                  varchar(255) comment '电话',
   MOBILE               varchar(255) comment '手机',
   ZIP                  varchar(20) comment '邮编',
   COMEFROM             varchar(50) comment '来自',
   ADDRESS              varchar(255) comment '联系地址',
   GENDER               bool comment '性别',
   BIRTHDAY             date comment '出生年月',
   CREATE_TIME          datetime comment '创建时间',
   LAST_LOGIN_TIME      datetime comment '最后登录时间',
   LAST_LOGIN_IP        varchar(50) comment '最后登录IP',
   CURRENT_LOGIN_TIME   datetime comment '当前登录时间',
   CURRENT_LOGIN_IP     varchar(50) comment '当前登录IP',
   LOGIN_COUNT          bigint default 0 comment '总共登录次数',
   IS_DISABLED          bool not null default 0 comment '是否禁用',
   primary key (USER_ID),
   unique key AK_LOGIN_NAME (LOGIN_NAME),
   unique key AK_EMAIL (EMAIL)
)
comment = "统一用户表。";

/*==============================================================*/
/* Table: CORE_WEBSITE                                          */
/*==============================================================*/
create table CORE_WEBSITE
(
   WEBSITE_ID           bigint not null auto_increment,
   GLOBAL_ID            bigint not null,
   PARENT               bigint comment '父站点',
   DOMAIN               varchar(50) not null comment '域名',
   RES_PATH             varchar(20) not null comment '资源路径',
   LFT                  int not null default 1 comment '树左边',
   RGT                  int not null default 2 comment '树右边',
   RES_DOMAIN           varchar(50) comment '资源地址',
   BASE_DOMAIN          varchar(50) comment '根域名',
   DOMAIN_ALIAS         varchar(250) comment '可储存多个别名，用;分割',
   NAME                 varchar(100) not null comment '站点名称',
   SHORT_NAME           varchar(20) comment '简称',
   SUFFIX               varchar(20) default 'htm' comment '访问后缀，可以是htm、asp、php等',
   CURRENT_SYSTEM       varchar(20) default 'jeecms' comment '当前系统（jeecms,jeeshop,jeeforum）',
   COOKIE_KEY           varchar(20) default '_jeecms' comment '系统cookie识别码',
   OWNER_NAME           varchar(100) default '' comment '网站拥有者姓名',
   OWNER_IDENTITY       varchar(100) default '' comment '网站拥有者身份证号',
   COMPANY              varchar(200) default '' comment '公司名称',
   COPYRIGHT            varchar(255) default '' comment '版权信息',
   RECORD_CODE          varchar(255) default '' comment '备案号',
   EMAIL                varchar(100) default '' comment '网站拥有者电子邮箱',
   PHONE_CODE           varchar(200) default '' comment '电话号码',
   MOBILE_CODE          varchar(200) default '' comment '手机号码',
   CONTROL_FRONT_IPS    longtext comment '前台允许访问的IP',
   CONTROL_ADMIN_IPS    longtext comment '后台允许访问的IP',
   CONTROL_RESERVED     longtext comment '用户信息保留字',
   CONTROL_NAME_MINLEN  int not null default 4 comment '用户名最短几个字符',
   CREATE_TIME          datetime not null comment '站点创建时间',
   EMAIL_CHARSET        varchar(20) default 'gbk' comment '邮件发送编码',
   EMAIL_HOSTNAME       varchar(50) default '' comment '邮件发送服务器',
   EMAIL_ACCOUNT        varchar(100) default '' comment '网站邮箱账号',
   EMAIL_USER_NAME      varchar(50) default '' comment '网站邮箱名称',
   EMAIL_USER_ID        varchar(100) default '' comment '网站邮箱登录名',
   EMAIL_USER_PWD       varchar(50) default '' comment '网站邮箱密码',
   EMAIL_SUBJECT        varchar(255) default '' comment '邮件主题（标题）',
   EMAIL_CONTENT        longtext comment '邮件内容',
   CLOSE_REASON         varchar(255) default '网站暂时关闭' comment '关闭原因',
   IS_CLOSE             bool not null default 0 comment '是否关闭网站（后台仍可访问）',
   primary key (WEBSITE_ID),
   unique key AK_DOMAIN (DOMAIN),
   unique key AK_RES_PATH (RES_PATH)
);

/*==============================================================*/
/* Index: WEBSITE_LFT                                           */
/*==============================================================*/
create index WEBSITE_LFT on CORE_WEBSITE
(
   LFT
);

/*==============================================================*/
/* Index: WEBSITE_RGT                                           */
/*==============================================================*/
create index WEBSITE_RGT on CORE_WEBSITE
(
   RGT
);

/*==============================================================*/
/* Table: DOWN_DOWNLOAD                                         */
/*==============================================================*/
create table DOWN_DOWNLOAD
(
   DOWNLOAD_ID          bigint not null auto_increment,
   CTTCTG_ID            bigint not null,
   DOWNTYPE_ID          bigint not null,
   GROUP_ID             bigint,
   ATTACHMENT_ID        bigint,
   MEMEBE_ID            bigint,
   CHANNEL_ID           bigint not null,
   WEBSITE_ID           bigint not null,
   ADMIN_INPUT          bigint comment '录入管理员',
   ADMIN_CHECK          bigint comment '审核管理员',
   ADMIN_DISABLE        bigint comment '禁用管理员',
   TITLE                varchar(255) comment '标题',
   SHORT_TITLE          varchar(255) comment '简短标题',
   TITLE_COLOR          varchar(10) comment '标题颜色',
   TITLE_IMG            varchar(100) comment '标题图片',
   DESCRIPTION          varchar(255) comment '软件描述',
   TAGS                 varchar(255) comment '标记（关键字）',
   AUTHOR               varchar(100) comment '作者',
   RELEASE_DATE         datetime comment '发布日期（可认为设置）',
   RELEASE_SYS_DATE     datetime comment '发布日期（系统日期）',
   CHECK_TIME           datetime comment '终审通过时间',
   DISABLE_TIME         datetime comment '禁用时间',
   VIEW_TOTAL           bigint not null default 0 comment '浏览次数',
   VISIT_TOTAL          bigint not null default 0 comment '总共下载次数',
   VISIT_TODAY          bigint not null default 0 comment '当天下载次数',
   VISIT_WEEK           bigint not null default 0 comment '本周下载次数',
   VISIT_MONTH          bigint not null default 0 comment '本月下载次数',
   VISIT_QUARTER        bigint not null default 0 comment '本季下载次数',
   VISIT_YEAR           bigint not null default 0 comment '本年下载次数',
   STAT_DATE            date comment '统计时间',
   OUTER_URL            varchar(255) comment '外部链接',
   CONTENT_RES_PATH     varchar(200) comment '资源路径',
   TPL_CONTENT          varchar(100) comment '指定模板',
   CHECK_STEP           int comment '审核级数',
   CHECK_OPINION        varchar(255) comment '审核意见',
   TOP_LEVEL            int default 0 comment '置顶级别',
   HOMEPAGE             varchar(100) comment '厂商主页',
   DEMO_URL             varchar(100) comment '系统演示',
   CONTACT              varchar(100) comment '联系方式',
   ENVIRONMENT          varchar(255) comment '运行环境',
   EVALUATION           int comment '软件评价',
   FILE_TYPE            varchar(20) comment '文件类型',
   FILE_SIZE            bigint comment '文件大小',
   DOWN_COUNT           bigint comment '下载次数',
   COMMENT_COUNT        int not null default 0 comment '评论数量',
   CONTENT              longtext comment '详细信息',
   HAS_TITLEIMG         bool not null default 0 comment '是否有标题图片',
   IS_BOLD              bool not null default 0 comment '是否加粗',
   IS_DRAFT             bool not null default 0 comment '是否草稿',
   IS_RECOMMEND         bool not null default 0 comment '是否推荐',
   IS_CHECK             bool not null default 1 comment '是否审核',
   IS_REJECT            bool not null default 0 comment '是否驳回',
   IS_DISABLED          bool not null default 0 comment '是否禁用',
   PARAM1               varchar(255) comment '文章相关数据1',
   PARAM2               varchar(255) comment '文章相关数据2',
   PARAM3               varchar(255) comment '文章相关数据3',
   DEF_STRING_1         varchar(255) comment '自定义字符串1',
   DEF_STRING_2         varchar(255) comment '自定义字符串2',
   DEF_STRING_3         varchar(255) comment '自定义字符串3',
   DEF_STRING_4         varchar(255) comment '自定义字符串4',
   DEF_STRING_5         varchar(255) comment '自定义字符串5',
   DEF_STRING_6         varchar(255) comment '自定义字符串6',
   DEF_STRING_7         varchar(255) comment '自定义字符串7',
   DEF_STRING_8         varchar(255) comment '自定义字符串8',
   DEF_STRING_9         varchar(255) comment '自定义字符串9',
   DEF_LONG_1           bigint comment '自定义长整数1',
   DEF_LONG_2           bigint comment '自定义长整数1',
   DEF_LONG_3           bigint comment '自定义长整数1',
   DEF_LONG_4           bigint comment '自定义长整数1',
   DEF_LONG_5           bigint comment '自定义长整数1',
   DEF_MONEY1           numeric(12,2) comment '自定义金额1',
   DEF_MONEY2           numeric(12,2) comment '自定义金额2',
   DEF_MONEY3           numeric(12,2) comment '自定义金额3',
   DEF_DATE1            datetime comment '自定义日期1',
   DEF_DATE2            datetime comment '自定义日期2',
   DEF_DATE3            datetime comment '自定义日期3',
   DEF_BOOL1            bool comment '自定义布尔1',
   DEF_BOOL2            bool comment '自定义布尔2',
   DEF_BOOL3            bool comment '自定义布尔3',
   primary key (DOWNLOAD_ID)
)
comment = "下载表";

/*==============================================================*/
/* Table: DOWN_DOWNLOAD_ATTACHMENT                              */
/*==============================================================*/
create table DOWN_DOWNLOAD_ATTACHMENT
(
   DOWNLOAD_ID          bigint not null,
   ATTACHMENT_ID        bigint not null,
   primary key (DOWNLOAD_ID, ATTACHMENT_ID)
);

/*==============================================================*/
/* Table: DOWN_TYPE                                             */
/*==============================================================*/
create table DOWN_TYPE
(
   DOWNTYPE_ID          bigint not null auto_increment,
   WEBSITE_ID           bigint not null,
   NAME                 varchar(100) comment '名称',
   DESCRIPTION          varchar(255) comment '描述',
   PRIORITY             int comment '排序顺序',
   IS_DISABLED          bool not null default 0 comment '是否禁用',
   primary key (DOWNTYPE_ID)
)
comment = "软件类型（国产、汉化、国外）";

alter table ARTI_ARTICLE add constraint FK_ARTICLE_CHANNEL foreign key (CHANNEL_ID)
      references CMS_CHANNEL (CHANNEL_ID) on delete restrict on update restrict;

alter table ARTI_ARTICLE add constraint FK_ARTICLE_CHECK_CADMIN foreign key (ADMIN_CHECK)
      references CMS_ADMIN (ADMIN_ID) on delete restrict on update restrict;

alter table ARTI_ARTICLE add constraint FK_ARTICLE_CMEMBER foreign key (MEMBER_ID)
      references CMS_MEMBER (MEMBER_ID) on delete restrict on update restrict;

alter table ARTI_ARTICLE add constraint FK_ARTICLE_CMSCONFIG foreign key (CONFIG_ID)
      references CMS_CONFIG (CONFIG_ID) on delete restrict on update restrict;

alter table ARTI_ARTICLE add constraint FK_ARTICLE_CTTCTG foreign key (CTTCTG_ID)
      references CMS_CONTENT_CTG (CTTCTG_ID) on delete restrict on update restrict;

alter table ARTI_ARTICLE add constraint FK_ARTICLE_DISABLE_CADMIN foreign key (ADMIN_DISABLE)
      references CMS_ADMIN (ADMIN_ID) on delete restrict on update restrict;

alter table ARTI_ARTICLE add constraint FK_ARTICLE_INPUT_CADMIN foreign key (ADMIN_INPUT)
      references CMS_ADMIN (ADMIN_ID) on delete restrict on update restrict;

alter table ARTI_ARTICLE add constraint FK_ARTICLE_MGROUP foreign key (GROUP_ID)
      references CMS_MEMBER_GROUP (GROUP_ID) on delete restrict on update restrict;

alter table ARTI_ARTICLE add constraint FK_ARTICLE_WEBSITE foreign key (WEBSITE_ID)
      references CORE_WEBSITE (WEBSITE_ID) on delete restrict on update restrict;

alter table ARTI_ARTICLE add constraint FK_NEXT_ARTICLE foreign key (NEXT_ID)
      references ARTI_ARTICLE (ARTICLE_ID) on delete restrict on update restrict;

alter table ARTI_ARTICLE add constraint FK_RPE_ARTICLE foreign key (PRE_ID)
      references ARTI_ARTICLE (ARTICLE_ID) on delete restrict on update restrict;

alter table ARTI_ARTICLE_ATTACHMENT add constraint FK_ARTI_ARTICLE_ATTACHMENT foreign key (ARTICLE_ID)
      references ARTI_ARTICLE (ARTICLE_ID) on delete restrict on update restrict;

alter table ARTI_ARTICLE_ATTACHMENT add constraint FK_ARTI_ARTICLE_ATTACHMENT2 foreign key (ATTACHMENT_ID)
      references CORE_ATTACHMENT (ATTACHMENT_ID) on delete restrict on update restrict;

alter table AUXI_CONFIG add constraint FK_AUXICONFIG_WEBSITE foreign key (CONFIG_ID)
      references CORE_WEBSITE (WEBSITE_ID) on delete restrict on update restrict;

alter table AUXI_MSG add constraint FK_AMSG_ADMIN foreign key (ADMIN_ID)
      references CORE_ADMIN (ADMIN_ID) on delete restrict on update restrict;

alter table AUXI_MSG add constraint FK_AMSG_MEMBER foreign key (MEMBER_ID)
      references CORE_MEMBER (MEMBER_ID) on delete restrict on update restrict;

alter table AUXI_MSG add constraint FK_AMSG_MSGCTG foreign key (MSGCTG_ID)
      references AUXI_MSG_CTG (MSGCTG_ID) on delete restrict on update restrict;

alter table AUXI_MSG add constraint FK_AMSG_WEBSITE foreign key (WEBSITE_ID)
      references CORE_WEBSITE (WEBSITE_ID) on delete restrict on update restrict;

alter table AUXI_MSG add constraint FK_AUXIMSG_CONFIG foreign key (CONFIG_ID)
      references AUXI_CONFIG (CONFIG_ID) on delete restrict on update restrict;

alter table AUXI_MSG_CTG add constraint FK_AMSGCTG_WEBSITE foreign key (WEBSITE_ID)
      references CORE_WEBSITE (WEBSITE_ID) on delete restrict on update restrict;

alter table CMS_ADMIN add constraint FK_CADMIN_ADMIN foreign key (ADMIN_ID)
      references CORE_ADMIN (ADMIN_ID) on delete restrict on update restrict;

alter table CMS_ADMIN add constraint FK_CADMIN_WEBSITE foreign key (WEBSITE_ID)
      references CORE_WEBSITE (WEBSITE_ID) on delete restrict on update restrict;

alter table CMS_ADMIN_CHANNEL add constraint FK_CMS_ADMIN_CHANNEL foreign key (ADMIN_ID)
      references CMS_ADMIN (ADMIN_ID) on delete restrict on update restrict;

alter table CMS_ADMIN_CHANNEL add constraint FK_CMS_ADMIN_CHANNEL2 foreign key (CHANNEL_ID)
      references CMS_CHANNEL (CHANNEL_ID) on delete restrict on update restrict;

alter table CMS_ARTICLE_TOPIC add constraint FK_CMS_ARTICLE_TOPIC foreign key (TOPIC_ID)
      references CMS_TOPIC (TOPIC_ID) on delete restrict on update restrict;

alter table CMS_ARTICLE_TOPIC add constraint FK_CMS_TOPIC_ARTICLE foreign key (ARTICLE_ID)
      references ARTI_ARTICLE (ARTICLE_ID) on delete restrict on update restrict;

alter table CMS_CHANNEL add constraint FK_CCHANNEL_CHNLMODEL foreign key (MODEL_ID)
      references CMS_CHNL_MODEL (MODEL_ID) on delete restrict on update restrict;

alter table CMS_CHANNEL add constraint FK_CHANNEL_PARENT foreign key (PARENT)
      references CMS_CHANNEL (CHANNEL_ID) on delete restrict on update restrict;

alter table CMS_CHANNEL add constraint FK_CHANNEL_WEBSITE foreign key (WEBSITE_ID)
      references CORE_WEBSITE (WEBSITE_ID) on delete restrict on update restrict;

alter table CMS_CHANNEL add constraint FK_CMSCHANNEL_CONFIG foreign key (CONFIG_ID)
      references CMS_CONFIG (CONFIG_ID) on delete restrict on update restrict;

alter table CMS_CHANNEL add constraint FK_CMSCHNL_CONTRI_GROUP foreign key (GROUP_CONTRI_ID)
      references CMS_MEMBER_GROUP (GROUP_ID) on delete restrict on update restrict;

alter table CMS_CHANNEL add constraint FK_CMSCHNL_VISIT_GROUP foreign key (GROUP_VISIT_ID)
      references CMS_MEMBER_GROUP (GROUP_ID) on delete restrict on update restrict;

alter table CMS_CHANNEL_ATTCHMENT add constraint FK_CMS_CHANNEL_ATTCHMENT foreign key (ATTACHMENT_ID)
      references CORE_ATTACHMENT (ATTACHMENT_ID) on delete restrict on update restrict;

alter table CMS_CHANNEL_ATTCHMENT add constraint FK_CMS_CHANNEL_ATTCHMENT2 foreign key (CHANNEL_ID)
      references CMS_CHANNEL (CHANNEL_ID) on delete restrict on update restrict;

alter table CMS_CHNL_MODEL add constraint FK_CHNLMODEL_WEBSITE foreign key (WEBSITE_ID)
      references CORE_WEBSITE (WEBSITE_ID) on delete restrict on update restrict;

alter table CMS_CHNL_MODEL_ITEM add constraint FK_CHNLMODELITEM_MODEL foreign key (MODEL_ID)
      references CMS_CHNL_MODEL (MODEL_ID) on delete restrict on update restrict;

alter table CMS_COMMENT add constraint FK_CCOMMENT_ADMIN foreign key (ADMIN_ID)
      references CMS_ADMIN (ADMIN_ID) on delete restrict on update restrict;

alter table CMS_COMMENT add constraint FK_CCOMMENT_MEMBER foreign key (MEMBER_ID)
      references CORE_MEMBER (MEMBER_ID) on delete restrict on update restrict;

alter table CMS_COMMENT add constraint FK_CCOMMENT_WEBSITE foreign key (WEBSITE_ID)
      references CORE_WEBSITE (WEBSITE_ID) on delete restrict on update restrict;

alter table CMS_CONFIG add constraint FK_CMSCONFIG_WEBSITE foreign key (CONFIG_ID)
      references CORE_WEBSITE (WEBSITE_ID) on delete restrict on update restrict;

alter table CMS_CONTENT_CTG add constraint FK_CTTCTG_WEBSITE foreign key (WEBSITE_ID)
      references CORE_WEBSITE (WEBSITE_ID) on delete restrict on update restrict;

alter table CMS_MEMBER add constraint FK_CMEMBER_MEMBER foreign key (MEMBER_ID)
      references CORE_MEMBER (MEMBER_ID) on delete restrict on update restrict;

alter table CMS_MEMBER add constraint FK_CMEMBER_MGROUP foreign key (GROUP_ID)
      references CMS_MEMBER_GROUP (GROUP_ID) on delete restrict on update restrict;

alter table CMS_MEMBER add constraint FK_CMEMBER_WEBSITE foreign key (WEBSITE_ID)
      references CORE_WEBSITE (WEBSITE_ID) on delete restrict on update restrict;

alter table CMS_MEMBER_GROUP add constraint FK_CMSGROUP_WEBSITE foreign key (WEBSITE_ID)
      references CORE_WEBSITE (WEBSITE_ID) on delete restrict on update restrict;

alter table CMS_RECOMMEND_GROUP add constraint FK_RGROUP_CHANNEL foreign key (CHANNEL_ID)
      references CMS_CHANNEL (CHANNEL_ID) on delete restrict on update restrict;

alter table CMS_RECOMMEND_GROUP add constraint FK_RGROUP_WEBSITE foreign key (WEBSITE_ID)
      references CORE_WEBSITE (WEBSITE_ID) on delete restrict on update restrict;

alter table CMS_RECOMMEND_ITEM add constraint FK_RITEM_RGOUP foreign key (RGROUP_ID)
      references CMS_RECOMMEND_GROUP (RGROUP_ID) on delete restrict on update restrict;

alter table CMS_RECOMMEND_ITEM add constraint FK_RITEM_WEBSITE foreign key (WEBSITE_ID)
      references CORE_WEBSITE (WEBSITE_ID) on delete restrict on update restrict;

alter table CMS_TOPIC add constraint FK_TOPIC_WEBSITE foreign key (WEBSITE_ID)
      references CORE_WEBSITE (WEBSITE_ID) on delete restrict on update restrict;

alter table CORE_ADMIN add constraint FK_ADMIN_USER foreign key (USER_ID)
      references CORE_USER (USER_ID) on delete restrict on update restrict;

alter table CORE_ADMIN add constraint FK_ADMIN_WEBSITE foreign key (WEBSITE_ID)
      references CORE_WEBSITE (WEBSITE_ID) on delete restrict on update restrict;

alter table CORE_ADMIN_FUNCTION add constraint FK_CORE_ADMIN_FUNCTION foreign key (FUNCTION_ID)
      references CORE_FUNCTION (FUNCTION_ID) on delete restrict on update restrict;

alter table CORE_ADMIN_FUNCTION add constraint FK_CORE_FUNCTION_ADMIN foreign key (ADMIN_ID)
      references CORE_ADMIN (ADMIN_ID) on delete restrict on update restrict;

alter table CORE_ADMIN_ROLE add constraint FK_CORE_ADMIN_ROLE foreign key (ROLE_ID)
      references CORE_ROLE (ROLE_ID) on delete restrict on update restrict;

alter table CORE_ADMIN_ROLE add constraint FK_CORE_ROLE_ADMIN foreign key (ADMIN_ID)
      references CORE_ADMIN (ADMIN_ID) on delete restrict on update restrict;

alter table CORE_ATTACHMENT add constraint FK_ATTACHEMENT_USER foreign key (USER_ID)
      references CORE_USER (USER_ID) on delete restrict on update restrict;

alter table CORE_ATTACHMENT add constraint FK_COREDOWNLOAD_WEBSITE foreign key (WEBSITE_ID)
      references CORE_WEBSITE (WEBSITE_ID) on delete restrict on update restrict;

alter table CORE_FUNCTION add constraint FK_PARENT foreign key (PARENT)
      references CORE_FUNCTION (FUNCTION_ID) on delete restrict on update restrict;

alter table CORE_MEMBER add constraint FK_MEMBER_USER foreign key (USER_ID)
      references CORE_USER (USER_ID) on delete restrict on update restrict;

alter table CORE_MEMBER add constraint FK_MEMBER_WEBSITE foreign key (WEBSITE_ID)
      references CORE_WEBSITE (WEBSITE_ID) on delete restrict on update restrict;

alter table CORE_PRIVATE_MSG add constraint FK_CORE_PRIVMSG_FROM foreign key (FROM_USER)
      references CORE_USER (USER_ID) on delete restrict on update restrict;

alter table CORE_PRIVATE_MSG add constraint FK_CORE_PRIVMSG_TO foreign key (TO_USER)
      references CORE_USER (USER_ID) on delete restrict on update restrict;

alter table CORE_PRIVATE_MSG_TEXT add constraint FK_CORE_PRIVTEXT_MSG foreign key (PRIVMSG_ID)
      references CORE_PRIVATE_MSG (PRIVMSG_ID) on delete restrict on update restrict;

alter table CORE_ROLE_FUNCTION add constraint FK_CORE_FUNCTION_ROLE foreign key (ROLE_ID)
      references CORE_ROLE (ROLE_ID) on delete restrict on update restrict;

alter table CORE_ROLE_FUNCTION add constraint FK_CORE_ROLE_FUNCTION foreign key (FUNCTION_ID)
      references CORE_FUNCTION (FUNCTION_ID) on delete restrict on update restrict;

alter table CORE_TPL_SOLUTION add constraint FK_TPLSOLUTION_WEBSITE foreign key (WEBSITE_ID)
      references CORE_WEBSITE (WEBSITE_ID) on delete restrict on update restrict;

alter table CORE_WEBSITE add constraint FK_PARENT_WEBSITE foreign key (PARENT)
      references CORE_WEBSITE (WEBSITE_ID) on delete restrict on update restrict;

alter table CORE_WEBSITE add constraint FK_WEBSITE_GLOBAL foreign key (GLOBAL_ID)
      references CORE_GLOBAL (GLOBAL_ID) on delete restrict on update restrict;

alter table DOWN_DOWNLOAD add constraint FK_DOWNLOAD_ATTACHMENT foreign key (ATTACHMENT_ID)
      references CORE_ATTACHMENT (ATTACHMENT_ID) on delete restrict on update restrict;

alter table DOWN_DOWNLOAD add constraint FK_DOWNLOAD_CHANNEL foreign key (CHANNEL_ID)
      references CMS_CHANNEL (CHANNEL_ID) on delete restrict on update restrict;

alter table DOWN_DOWNLOAD add constraint FK_DOWNLOAD_CHECK_ADMIN foreign key (ADMIN_CHECK)
      references CMS_ADMIN (ADMIN_ID) on delete restrict on update restrict;

alter table DOWN_DOWNLOAD add constraint FK_DOWNLOAD_CTTCTG foreign key (CTTCTG_ID)
      references CMS_CONTENT_CTG (CTTCTG_ID) on delete restrict on update restrict;

alter table DOWN_DOWNLOAD add constraint FK_DOWNLOAD_DISABLE_ADMIN foreign key (ADMIN_DISABLE)
      references CMS_ADMIN (ADMIN_ID) on delete restrict on update restrict;

alter table DOWN_DOWNLOAD add constraint FK_DOWNLOAD_INPUT_ADMIN foreign key (ADMIN_INPUT)
      references CMS_ADMIN (ADMIN_ID) on delete restrict on update restrict;

alter table DOWN_DOWNLOAD add constraint FK_DOWNLOAD_MEMBER foreign key (MEMEBE_ID)
      references CMS_MEMBER (MEMBER_ID) on delete restrict on update restrict;

alter table DOWN_DOWNLOAD add constraint FK_DOWNLOAD_MEMBERGROUP foreign key (GROUP_ID)
      references CMS_MEMBER_GROUP (GROUP_ID) on delete restrict on update restrict;

alter table DOWN_DOWNLOAD add constraint FK_DOWNLOAD_TYPE foreign key (DOWNTYPE_ID)
      references DOWN_TYPE (DOWNTYPE_ID) on delete restrict on update restrict;

alter table DOWN_DOWNLOAD add constraint FK_DOWNLOAD_WEBSITE foreign key (WEBSITE_ID)
      references CORE_WEBSITE (WEBSITE_ID) on delete restrict on update restrict;

alter table DOWN_DOWNLOAD_ATTACHMENT add constraint FK_DOWN_DOWNLOAD_ATTACHMENT foreign key (DOWNLOAD_ID)
      references DOWN_DOWNLOAD (DOWNLOAD_ID) on delete restrict on update restrict;

alter table DOWN_DOWNLOAD_ATTACHMENT add constraint FK_DOWN_DOWNLOAD_ATTACHMENT2 foreign key (ATTACHMENT_ID)
      references CORE_ATTACHMENT (ATTACHMENT_ID) on delete restrict on update restrict;

alter table DOWN_TYPE add constraint FK_DOWNTYPE_WEBSITE foreign key (WEBSITE_ID)
      references CORE_WEBSITE (WEBSITE_ID) on delete restrict on update restrict;


/*==============================================================*/
/* Table: VOTE_ITEM                                             */
/*==============================================================*/
create table VOTE_ITEM
(
   VOTEITEM_ID          bigint not null auto_increment,
   VTOPIC_ID            bigint not null,
   TITLE                varchar(255) comment '标题',
   DESCRIPTION          varchar(255) comment '描述',
   VOTE_COUNT           bigint comment '投票数量',
   PRIORITY             int not null comment '显示优先级',
   primary key (VOTEITEM_ID)
)
comment = "投票项";

/*==============================================================*/
/* Table: VOTE_RECORD                                           */
/*==============================================================*/
create table VOTE_RECORD
(
   VRECORD_ID           bigint not null auto_increment,
   VTOPIC_ID            bigint not null,
   MEMBER_ID            bigint,
   VOTE_TIME            datetime comment '投票时间',
   VOTE_IP              varchar(50) comment '投票IP',
   VOTE_COOKIE          char(32) comment '投票cookie',
   primary key (VRECORD_ID)
)
comment = "投票记录";

/*==============================================================*/
/* Table: VOTE_TOPIC                                            */
/*==============================================================*/
create table VOTE_TOPIC
(
   VTOPIC_ID            bigint not null auto_increment,
   WEBSITE_ID           bigint not null,
   TITLE                varchar(255) comment '标题',
   DESCRIPTION          varchar(255) comment '描述',
   TOTAL_COUNT          bigint comment '投票数量',
   START_TIME           datetime comment '开始时间',
   END_TIME             datetime comment '结束时间',
   REPEATE_HOUR         int comment '重复投票限制时间(单位小时)',
   MULTI_SELECT         int comment '最多可以选择几项',
   IS_RESTRICT_MEMBER   bool not null comment '是否限制会员ID',
   IS_RESTRICT_IP       bool not null comment '是否限制IP',
   IS_RESTRICT_COOKIE   bool not null comment '是否限制cookie',
   IS_CURRENT           bool not null comment '是否为最新投票',
   IS_DISABLED          bool not null comment '是否禁止投票',
   primary key (VTOPIC_ID)
)
comment = "投票主题";

alter table VOTE_ITEM add constraint FK_VITEM_TOPIC foreign key (VTOPIC_ID)
      references VOTE_TOPIC (VTOPIC_ID) on delete restrict on update restrict;

alter table VOTE_RECORD add constraint FK_VRECORD_GUEST foreign key (MEMBER_ID)
      references CORE_MEMBER (MEMBER_ID) on delete restrict on update restrict;

alter table VOTE_RECORD add constraint FK_VRECORD_TOPIC foreign key (VTOPIC_ID)
      references VOTE_TOPIC (VTOPIC_ID) on delete restrict on update restrict;

alter table VOTE_TOPIC add constraint FK_VTOPIC_WEBSITE foreign key (WEBSITE_ID)
      references CORE_WEBSITE (WEBSITE_ID) on delete restrict on update restrict;