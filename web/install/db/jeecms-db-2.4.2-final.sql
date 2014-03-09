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
   NEXT_ID              bigint comment '��һƪ',
   PRE_ID               bigint comment '��һƪ',
   GROUP_ID             bigint comment '���������Ա��',
   CHANNEL_ID           bigint not null comment '��ĿID',
   MEMBER_ID            bigint comment '¼���Ա',
   ADMIN_CHECK          bigint comment '��˹���Ա',
   ADMIN_DISABLE        bigint comment '���ù���Ա',
   ADMIN_INPUT          bigint comment '¼�����Ա',
   TITLE                varchar(255) comment '���±���',
   SHORT_TITLE          varchar(255) comment '��̱��⣨������Ŀ����ҳ������',
   TITLE_COLOR          varchar(10) comment '������ɫ',
   TITLE_IMG            varchar(100) comment '���±�������ͼ',
   CONTENT_IMG          varchar(100) comment '��������ͼ',
   DESCRIPTION          varchar(255) comment '��������',
   TAGS                 varchar(255) comment '��ǣ����ƹؼ���',
   AUTHOR               varchar(100) comment '����',
   ORIGIN               varchar(100) comment '��Դ',
   SORT_DATE            datetime not null comment '�������ڣ�ͨ���ö�ʱ�������',
   RELEASE_DATE         datetime not null comment '�������ڣ�����Ϊ���ã�',
   RELEASE_SYS_DATE     datetime not null comment '�������ڣ�ϵͳ���ڣ�',
   CHECK_TIME           datetime comment '����ͨ��ʱ��',
   DISABLE_TIME         datetime comment '����ʱ��',
   VISIT_TOTAL          bigint not null default 0 comment '�ܹ����ʴ���',
   VISIT_TODAY          bigint not null default 0 comment '������ʴ���',
   VISIT_WEEK           bigint not null default 0 comment '�������ش���',
   VISIT_MONTH          bigint not null default 0 comment '�������ش���',
   VISIT_QUARTER        bigint not null default 0 comment '�������ش���',
   VISIT_YEAR           bigint not null default 0 comment '�������ش���',
   STAT_DATE            date comment 'ͳ��ʱ��',
   OUTER_URL            varchar(255) comment '�ⲿ����',
   CONTENT_RES_PATH     varchar(200) comment '�������ݵ���Դ·��',
   PAGE_COUNT           int comment '������ҳ��',
   TPL_CONTENT          varchar(100) comment 'ָ��ģ��',
   CHECK_STEP           int not null default 0 comment '��˼���',
   TOP_LEVEL            int not null default 0 comment '�ö�����',
   COMMENT_COUNT        int not null default 0 comment '��������',
   CHECK_OPINION        varchar(255) comment '������',
   RELATED_IDS          varchar(255) comment '�������ID',
   HAS_TITLEIMG         bool not null default 0 comment '�Ƿ��б���ͼƬ',
   ALLOW_COMMENT        bool not null default 1 comment '�Ƿ���������',
   IS_BOLD              bool not null default 0 comment '�Ƿ�Ӵ�',
   IS_DRAFT             bool not null default 0 comment '�Ƿ�ݸ�',
   IS_RECOMMEND         bool not null default 0 comment '�Ƿ��Ƽ�',
   IS_CHECK             bool not null default 1 comment '�Ƿ����',
   IS_DISABLED          bool not null default 0 comment '�Ƿ����',
   IS_REJECT            bool not null default 0 comment '�Ƿ񲵻�',
   PARAM1               varchar(255) comment '�����������1',
   PARAM2               varchar(255) comment '�����������2',
   PARAM3               varchar(255) comment '�����������3',
   DEF_STRING_1         varchar(255) comment '�Զ����ַ���1',
   DEF_STRING_2         varchar(255) comment '�Զ����ַ���2',
   DEF_STRING_3         varchar(255) comment '�Զ����ַ���3',
   DEF_STRING_4         varchar(255) comment '�Զ����ַ���4',
   DEF_STRING_5         varchar(255) comment '�Զ����ַ���5',
   DEF_STRING_6         varchar(255) comment '�Զ����ַ���6',
   DEF_STRING_7         varchar(255) comment '�Զ����ַ���7',
   DEF_STRING_8         varchar(255) comment '�Զ����ַ���8',
   DEF_STRING_9         varchar(255) comment '�Զ����ַ���9',
   DEF_LONG_1           bigint comment '�Զ��峤����1',
   DEF_LONG_2           bigint comment '�Զ��峤����1',
   DEF_LONG_3           bigint comment '�Զ��峤����1',
   DEF_LONG_4           bigint comment '�Զ��峤����1',
   DEF_LONG_5           bigint comment '�Զ��峤����1',
   DEF_MONEY1           numeric(12,2) comment '�Զ�����1',
   DEF_MONEY2           numeric(12,2) comment '�Զ�����2',
   DEF_MONEY3           numeric(12,2) comment '�Զ�����3',
   DEF_DATE1            datetime comment '�Զ�������1',
   DEF_DATE2            datetime comment '�Զ�������2',
   DEF_DATE3            datetime comment '�Զ�������3',
   DEF_BOOL1            bool comment '�Զ��岼��1',
   DEF_BOOL2            bool comment '�Զ��岼��2',
   DEF_BOOL3            bool comment '�Զ��岼��3',
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
   MSG_NEED_CHECK       bool default 0 comment '���԰��Ƿ���Ҫ���',
   MSG_IS_OPEN          bool default 1 comment '���԰��Ƿ񿪷�',
   MSG_ANONYMITY        varchar(20) default '��������' comment '���԰�������������',
   MSG_MAX_SIZE         int default 16384 comment '���԰����Դ�С(�ֽ�)',
   primary key (CONFIG_ID)
)
comment = "����ϵͳ���ñ�";

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
   TITLE                varchar(200) comment '���Ա���',
   CONTENT_MEMBER       longtext comment '��������',
   CONTENT_ADMIN        longtext comment '�ظ�����',
   EMAIL                varchar(100) comment '��������',
   PHONE                varchar(100) comment '��ϵ�绰',
   QQ                   varchar(50) comment 'QQ',
   IP                   varchar(20) comment '����IP',
   CREATE_TIME          datetime comment '����ʱ��',
   REPLY_TIME           datetime comment '�ظ�ʱ��',
   IS_CHECK             bool not null comment '�Ƿ����',
   IS_RECOMMEND         bool not null comment '�Ƿ��Ƽ�',
   IS_DISABLED          bool not null comment '�Ƿ����',
   primary key (MSG_ID)
)
comment = "���԰�����";

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
comment = "�������";

/*==============================================================*/
/* Table: CMS_ADMIN                                             */
/*==============================================================*/
create table CMS_ADMIN
(
   ADMIN_ID             bigint not null,
   WEBSITE_ID           bigint not null,
   CHECK_RIGHT          int not null default 0 comment '��˼��𣨵ڼ���',
   IS_SELF_ONLY         bool not null default 0 comment 'ֻ�����޸��Լ�������',
   primary key (ADMIN_ID)
)
comment = "jeecms����Ա";

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
   GROUP_CONTRI_ID      bigint comment 'Ͷ���Ա��',
   GROUP_VISIT_ID       bigint comment '���ʻ�Ա��',
   PARENT               bigint comment '����Ŀ',
   MODEL_ID             bigint not null comment 'ģ��',
   SYS_TYPE             varchar(20) not null comment 'ϵͳ����',
   PATH                 varchar(100) comment '��Ŀ·��',
   LFT                  int not null default 1 comment '�����',
   RGT                  int not null default 2 comment '���ұ�',
   NAME                 varchar(100) comment '��Ŀ����',
   CONTENT              longtext comment '��Ŀ����',
   TITLE_IMG            varchar(100) comment '��Ŀ����ͼ',
   CONTENT_IMG          varchar(100) comment '��Ŀ����ͼ',
   TPL_INDEX            varchar(100) comment '��Ŀҳģ��·��',
   TPL_CONTENT          varchar(100) comment '����ҳģ��·��',
   TITLE                varchar(255) comment 'TITLE',
   KEYWORDS             varchar(255) comment 'KEYWORDS',
   DESCRIPTION          varchar(255) comment 'DESCRIPTION',
   DOC_COUNT            int not null default 0 comment '�ĵ�����',
   VISIT_TOTAL          bigint comment '�ܹ����ʴ���',
   VISIT_TODAY          bigint comment '������ʴ���',
   STAT_DATE            date comment 'ͳ������',
   OUTER_URL            varchar(255) comment '�ⲿ����',
   PRIORITY             int not null default 10 comment '��Ŀ����˳��',
   HAS_TITLEIMG         bool not null default 0 comment '�Ƿ��б���ͼƬ',
   HAS_CHILD            bool not null default 1 comment '�Ƿ�������ӽڵ�',
   IS_DISPLAY           bool not null default 1 comment '�Ƿ���ʾ',
   PARAM1               varchar(255) comment '��Ŀ�������1',
   PARAM2               varchar(255) comment '��Ŀ�������2',
   PARAM3               varchar(255) comment '��Ŀ�������3',
   DEF_STRING_1         varchar(255) comment '�Զ����ַ���1',
   DEF_STRING_2         varchar(255) comment '�Զ����ַ���2',
   DEF_STRING_3         varchar(255) comment '�Զ����ַ���3',
   DEF_STRING_4         varchar(255) comment '�Զ����ַ���4',
   DEF_STRING_5         varchar(255) comment '�Զ����ַ���5',
   DEF_STRING_6         varchar(255) comment '�Զ����ַ���6',
   DEF_STRING_7         varchar(255) comment '�Զ����ַ���7',
   DEF_STRING_8         varchar(255) comment '�Զ����ַ���8',
   DEF_STRING_9         varchar(255) comment '�Զ����ַ���9',
   DEF_LONG_1           bigint comment '�Զ��峤����1',
   DEF_LONG_2           bigint comment '�Զ��峤����1',
   DEF_LONG_3           bigint comment '�Զ��峤����1',
   DEF_LONG_4           bigint comment '�Զ��峤����1',
   DEF_LONG_5           bigint comment '�Զ��峤����1',
   DEF_MONEY1           numeric(12,2) comment '�Զ�����1',
   DEF_MONEY2           numeric(12,2) comment '�Զ�����2',
   DEF_MONEY3           numeric(12,2) comment '�Զ�����3',
   DEF_DATE1            datetime comment '�Զ�������1',
   DEF_DATE2            datetime comment '�Զ�������2',
   DEF_DATE3            datetime comment '�Զ�������3',
   DEF_BOOL1            bool comment '�Զ��岼��1',
   DEF_BOOL2            bool comment '�Զ��岼��2',
   DEF_BOOL3            bool comment '�Զ��岼��3',
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
   SYS_TYPE             varchar(20) comment 'ϵͳ����',
   NAME                 varchar(100) comment 'ģ������',
   SHORT_NAME           varchar(20) comment '���',
   TPL_PREFIX_CHANNEL   varchar(20) comment '��Ŀģ��ǰ׺',
   TPL_PREFIX_CONTENT   varchar(20) comment '����ģ��ǰ׺',
   PRIORITY             int not null default 10 comment '����˳��',
   IS_DISPLAY           bool not null default 1 comment '�Ƿ���ʾ',
   HAS_CHILD            bool not null default 1 comment '�Ƿ����������Ŀ',
   primary key (MODEL_ID)
)
comment = "��Ŀģ��";

/*==============================================================*/
/* Table: CMS_CHNL_MODEL_ITEM                                   */
/*==============================================================*/
create table CMS_CHNL_MODEL_ITEM
(
   MITEM_ID             bigint not null auto_increment,
   MODEL_ID             bigint not null,
   MITEM_TYPE           int not null default 1 comment 'ģ��������',
   NAME                 varchar(100) not null comment '������',
   LABEL                varchar(100) comment 'LABEL����',
   HELP                 varchar(255) comment '������Ϣ',
   DATA_TYPE            int comment '��������',
   INPUT_TYPE           int comment '������',
   INPUT_SIZE           int comment '�����size',
   INPUT_WIDTH          int comment 'select���',
   TEXTAREA_COLS        int comment '�ı�������',
   TEXTAREA_ROWS        int comment '�ı�������',
   DEF_VALUE            varchar(255) comment 'Ĭ��ֵ',
   OPTION_VALUE         varchar(255) comment '��ѡ��',
   PRIORITY             int not null comment '����˳��',
   IS_PREDEFINE         bool not null default 0 comment '�Ƿ�Ԥ����',
   IS_CHECKED           bool not null default 1 comment '�Ƿ�ѡ��',
   primary key (MITEM_ID)
)
comment = "��Ŀģ�Ͷ���";

/*==============================================================*/
/* Table: CMS_COMMENT                                           */
/*==============================================================*/
create table CMS_COMMENT
(
   COMMENT_ID           bigint not null auto_increment,
   WEBSITE_ID           bigint not null,
   MEMBER_ID            bigint,
   REF_DOC_ID           bigint not null comment '�ĵ�����ID',
   REF_DOC_TYPE         char(4) not null comment '�ĵ�����',
   ADMIN_ID             bigint,
   TITLE                varchar(200) comment '����',
   CONTENT_MEMBER       longtext comment '��Ա��������',
   CONTENT_ADMIN        longtext comment '����Ա�ظ�����',
   CREATE_TIME          datetime comment '����ʱ��',
   REPLAY_TIME          datetime comment '�ظ�ʱ��',
   IP                   varchar(50) comment '������IP',
   IS_CHECK             bool not null comment '�Ƿ����',
   IS_RECOMMEND         bool not null comment '�Ƿ��Ƽ�',
   IS_DISABLED          bool not null comment '�Ƿ����',
   primary key (COMMENT_ID)
)
comment = "jeecms���۱�";

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
   CHECK_COUNT          int not null default 0 comment '������Ҫ��˵Ĵ���',
   DEFAULT_SYSTEM       varchar(20) not null default 'article' comment 'Ĭ��ϵͳ',
   COMMENT_NEED_CHECK   bool not null default 0 comment '�����Ƿ���Ҫ���',
   COMMENT_NEED_LOGIN   bool not null default 0 comment '�����Ƿ���Ҫ��¼',
   COMMENT_SORT         bool not null default 1 comment '��������ʽ(0:����,1:����)',
   COMMENT_MAX_LENGTH   int not null default 16384 comment '��������ֽ�',
   REGISTER_STATUS      int default 1 comment 'ע�᷽ʽ(0���ر�ע�᣻1������ע�᣻2������ע��)',
   REGISTER_GROUP       bigint comment 'Ĭ�ϻ�Ա��ID',
   REGISTER_RULE        longtext comment '�������ʹ��Э��',
   AUTO_REGISTER        bool default 1 comment '�Ƿ��Զ�ע�ᣨ����ϵͳע����ڱ�ϵͳע�ᣩ',
   DEF_ARTICLE_MODEL    bigint comment 'Ĭ������ģ��',
   DEF_DOWNLOAD_MODEL   bigint comment 'Ĭ������ģ��',
   IS_CACHE_HOMEPAGE    bool not null default 0 comment '�Ƿ񻺴���ҳ',
   IS_CACHE_CHANNEL     bool not null default 0 comment '�Ƿ񻺴���Ŀҳ',
   primary key (CONFIG_ID)
)
comment = "jeecms���ñ�";

/*==============================================================*/
/* Table: CMS_CONTENT_CTG                                       */
/*==============================================================*/
create table CMS_CONTENT_CTG
(
   CTTCTG_ID            bigint not null auto_increment,
   WEBSITE_ID           bigint not null,
   LABEL                varchar(20) not null comment '��ʶID',
   NAME                 varchar(50) comment '����',
   IMG_WIDTH            int default 139 comment '����ͼƬ���',
   IMG_HEIGHT           int default 139 comment '����ͼƬ�߶�',
   HAS_TITLEIMG         bool not null default 1 comment '�Ƿ��б���ͼƬ',
   IS_DISABLED          bool not null default 0 comment '�Ƿ����ʹ��',
   primary key (CTTCTG_ID)
)
comment = "JEECMS��������";

/*==============================================================*/
/* Table: CMS_MEMBER                                            */
/*==============================================================*/
create table CMS_MEMBER
(
   MEMBER_ID            bigint not null,
   WEBSITE_ID           bigint not null,
   GROUP_ID             bigint not null,
   SCORE                int not null default 0 comment '����',
   COUPON               int not null default 0 comment '�ㄻ',
   UPLOAD_STAT_DATE     date not null comment '�ϴ�ͳ������',
   UPLOAD_SIZE          int not null default 0 comment '�����ϴ���С',
   UPLOAD_TOTAL_SIZE    bigint not null default 0 comment '�ܹ��ϴ���С',
   IS_DISABLED          bool not null default 0 comment '�Ƿ����',
   primary key (MEMBER_ID)
)
comment = "jeecms��Ա";

/*==============================================================*/
/* Table: CMS_MEMBER_GROUP                                      */
/*==============================================================*/
create table CMS_MEMBER_GROUP
(
   GROUP_ID             bigint not null auto_increment,
   WEBSITE_ID           bigint not null,
   NAME                 varchar(100) comment '����',
   GROUP_LEVEL          int not null default 10 comment '��ȼ���Խ��Խ�ߣ�',
   DESCRIPTION          varchar(255) comment '����',
   UPLOAD_SIZE          int not null default 0 comment 'ÿ�������ϴ����ܴ�С',
   primary key (GROUP_ID)
)
comment = "jeecms�û���";

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
   SYS_TYPE             char(4) not null comment 'ϵͳ����',
   NAME                 varchar(50) comment '�Ƽ�����',
   DESCRIPTION          varchar(250) comment '����',
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
   SYS_TYPE             char(4) not null comment 'ϵͳ����',
   TITLE                varchar(250) comment '�Ƽ��ı���',
   DESCRIPTION          varchar(255) comment '�Ƽ�������',
   PIC_PATH             varchar(250) comment 'ͼƬ��ַ������url',
   URL                  varchar(250) comment '�Ƽ����ӣ�����url',
   COLOR                varchar(20) comment '�������ɫ',
   PRIORITY             int not null comment '���ȼ�����ʾ���Ⱥ�˳��',
   IS_CHECK             bool not null comment '�Ƿ����',
   primary key (RITEM_ID)
);

/*==============================================================*/
/* Table: CMS_TOPIC                                             */
/*==============================================================*/
create table CMS_TOPIC
(
   TOPIC_ID             bigint not null auto_increment,
   WEBSITE_ID           bigint not null,
   NAME                 varchar(150) not null comment '����',
   KEYWORDS             varchar(255) comment '�ؼ���',
   DESCRIPTION          varchar(255) comment '����',
   TITLE_IMG            varchar(100) comment '����ͼ',
   TPL_CHANNEL          varchar(100) comment 'ģ��',
   PRIORITY             int not null comment '����˳��',
   primary key (TOPIC_ID)
)
comment = "ר���";

/*==============================================================*/
/* Table: CORE_ADMIN                                            */
/*==============================================================*/
create table CORE_ADMIN
(
   ADMIN_ID             bigint not null auto_increment,
   WEBSITE_ID           bigint not null,
   USER_ID              bigint not null,
   CREATE_TIME          datetime not null comment '����ʱ��',
   IS_DISABLED          bool not null default 0 comment '�Ƿ����',
   primary key (ADMIN_ID)
)
comment = "���Ĺ���Ա";

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
   NAME                 varchar(50) comment '����',
   DESCRIPTION          varchar(255) comment '����',
   FILE_PATH            varchar(100) comment '�ļ�·��',
   FILE_NAME            varchar(50) comment '�ļ���',
   FILE_SIZE            bigint comment '�ļ���С���ֽڣ�',
   DOWN_COUNT           bigint comment '���ش���',
   OWNER_NAME           varchar(100) comment '����������',
   OWNER_URL            varchar(150) comment '������URL',
   OWNER_ID             bigint comment '�����߼�¼ID',
   OWNER_CTG            varchar(50) comment '���������',
   CREATE_TIME          datetime comment '����ʱ��',
   IS_FREE              bool not null default 1 comment '�Ƿ������������',
   IS_LOST              bool not null default 0 comment '�����Ƿ�ʧ',
   IS_PICTURE           bool default 1 comment '�Ƿ�ͼƬ',
   primary key (ATTACHMENT_ID)
)
comment = "������";

/*==============================================================*/
/* Table: CORE_FUNCTION                                         */
/*==============================================================*/
create table CORE_FUNCTION
(
   FUNCTION_ID          bigint not null auto_increment,
   PARENT               bigint comment '������',
   NAME                 varchar(100),
   URL                  varchar(200),
   FUNCS                longtext comment '�����б�����@�ָ�',
   DESCRIPTION          varchar(250),
   PRIORITY             int not null comment '���ܲ˵�����˳��',
   IS_MENU              bool not null comment '�Ƿ�Ϊ�˵�',
   primary key (FUNCTION_ID)
)
comment = "���ܱ�";

/*==============================================================*/
/* Table: CORE_GLOBAL                                           */
/*==============================================================*/
create table CORE_GLOBAL
(
   GLOBAL_ID            bigint not null,
   CONTEXT_PATH         varchar(20) not null default '' comment '����·��',
   PORT                 int not null default 80 comment '�˿ں�',
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
   NICK_NAME            varchar(50) comment '�ǳ�',
   CREATE_TIME          datetime not null comment '����ʱ��',
   PERSONAL_WEBSITE     varchar(100) comment '������վ',
   QQ                   varchar(100) comment 'QQ',
   MSN                  varchar(100) comment 'MSN',
   IS_DISABLED          bool not null default 0 comment '�Ƿ����',
   primary key (MEMBER_ID)
)
comment = "��Ա��";

/*==============================================================*/
/* Table: CORE_PRIVATE_MSG                                      */
/*==============================================================*/
create table CORE_PRIVATE_MSG
(
   PRIVMSG_ID           bigint not null,
   TO_USER              bigint not null comment '������',
   FROM_USER            bigint not null comment '������',
   MSG_TYPE             smallint not null default 1 comment '���ͣ�2���ѷ���1�����ģ�0��δ�ģ�',
   MSG_SUBJECT          varchar(255) comment '����',
   CREATE_TIME          datetime not null comment '����ʱ��',
   MSG_IP               varchar(20) not null default '' comment 'IP��ַ',
   primary key (PRIVMSG_ID)
)
comment = "���˶���Ϣ";

/*==============================================================*/
/* Table: CORE_PRIVATE_MSG_TEXT                                 */
/*==============================================================*/
create table CORE_PRIVATE_MSG_TEXT
(
   PRIVMSG_ID           bigint not null,
   MSG_TEXT             longtext comment '������Ϣ����',
   primary key (PRIVMSG_ID)
)
comment = "������Ϣ����";

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
comment = "��ɫ��";

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
comment = "ģ�巽����";

/*==============================================================*/
/* Table: CORE_USER                                             */
/*==============================================================*/
create table CORE_USER
(
   USER_ID              bigint not null auto_increment,
   LOGIN_NAME           varchar(50) not null comment '��¼��',
   REAL_NAME            varchar(50) comment '��ʵ����',
   PASSWORD             char(32) comment '����',
   EMAIL                varchar(100) not null comment '��������',
   UNREAD_MSG           int not null default 0 comment 'δ����Ϣ',
   FAX                  varchar(255) comment '����',
   TEL                  varchar(255) comment '�绰',
   MOBILE               varchar(255) comment '�ֻ�',
   ZIP                  varchar(20) comment '�ʱ�',
   COMEFROM             varchar(50) comment '����',
   ADDRESS              varchar(255) comment '��ϵ��ַ',
   GENDER               bool comment '�Ա�',
   BIRTHDAY             date comment '��������',
   CREATE_TIME          datetime comment '����ʱ��',
   LAST_LOGIN_TIME      datetime comment '����¼ʱ��',
   LAST_LOGIN_IP        varchar(50) comment '����¼IP',
   CURRENT_LOGIN_TIME   datetime comment '��ǰ��¼ʱ��',
   CURRENT_LOGIN_IP     varchar(50) comment '��ǰ��¼IP',
   LOGIN_COUNT          bigint default 0 comment '�ܹ���¼����',
   IS_DISABLED          bool not null default 0 comment '�Ƿ����',
   primary key (USER_ID),
   unique key AK_LOGIN_NAME (LOGIN_NAME),
   unique key AK_EMAIL (EMAIL)
)
comment = "ͳһ�û���";

/*==============================================================*/
/* Table: CORE_WEBSITE                                          */
/*==============================================================*/
create table CORE_WEBSITE
(
   WEBSITE_ID           bigint not null auto_increment,
   GLOBAL_ID            bigint not null,
   PARENT               bigint comment '��վ��',
   DOMAIN               varchar(50) not null comment '����',
   RES_PATH             varchar(20) not null comment '��Դ·��',
   LFT                  int not null default 1 comment '�����',
   RGT                  int not null default 2 comment '���ұ�',
   RES_DOMAIN           varchar(50) comment '��Դ��ַ',
   BASE_DOMAIN          varchar(50) comment '������',
   DOMAIN_ALIAS         varchar(250) comment '�ɴ�������������;�ָ�',
   NAME                 varchar(100) not null comment 'վ������',
   SHORT_NAME           varchar(20) comment '���',
   SUFFIX               varchar(20) default 'htm' comment '���ʺ�׺��������htm��asp��php��',
   CURRENT_SYSTEM       varchar(20) default 'jeecms' comment '��ǰϵͳ��jeecms,jeeshop,jeeforum��',
   COOKIE_KEY           varchar(20) default '_jeecms' comment 'ϵͳcookieʶ����',
   OWNER_NAME           varchar(100) default '' comment '��վӵ��������',
   OWNER_IDENTITY       varchar(100) default '' comment '��վӵ�������֤��',
   COMPANY              varchar(200) default '' comment '��˾����',
   COPYRIGHT            varchar(255) default '' comment '��Ȩ��Ϣ',
   RECORD_CODE          varchar(255) default '' comment '������',
   EMAIL                varchar(100) default '' comment '��վӵ���ߵ�������',
   PHONE_CODE           varchar(200) default '' comment '�绰����',
   MOBILE_CODE          varchar(200) default '' comment '�ֻ�����',
   CONTROL_FRONT_IPS    longtext comment 'ǰ̨������ʵ�IP',
   CONTROL_ADMIN_IPS    longtext comment '��̨������ʵ�IP',
   CONTROL_RESERVED     longtext comment '�û���Ϣ������',
   CONTROL_NAME_MINLEN  int not null default 4 comment '�û�����̼����ַ�',
   CREATE_TIME          datetime not null comment 'վ�㴴��ʱ��',
   EMAIL_CHARSET        varchar(20) default 'gbk' comment '�ʼ����ͱ���',
   EMAIL_HOSTNAME       varchar(50) default '' comment '�ʼ����ͷ�����',
   EMAIL_ACCOUNT        varchar(100) default '' comment '��վ�����˺�',
   EMAIL_USER_NAME      varchar(50) default '' comment '��վ��������',
   EMAIL_USER_ID        varchar(100) default '' comment '��վ�����¼��',
   EMAIL_USER_PWD       varchar(50) default '' comment '��վ��������',
   EMAIL_SUBJECT        varchar(255) default '' comment '�ʼ����⣨���⣩',
   EMAIL_CONTENT        longtext comment '�ʼ�����',
   CLOSE_REASON         varchar(255) default '��վ��ʱ�ر�' comment '�ر�ԭ��',
   IS_CLOSE             bool not null default 0 comment '�Ƿ�ر���վ����̨�Կɷ��ʣ�',
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
   ADMIN_INPUT          bigint comment '¼�����Ա',
   ADMIN_CHECK          bigint comment '��˹���Ա',
   ADMIN_DISABLE        bigint comment '���ù���Ա',
   TITLE                varchar(255) comment '����',
   SHORT_TITLE          varchar(255) comment '��̱���',
   TITLE_COLOR          varchar(10) comment '������ɫ',
   TITLE_IMG            varchar(100) comment '����ͼƬ',
   DESCRIPTION          varchar(255) comment '�������',
   TAGS                 varchar(255) comment '��ǣ��ؼ��֣�',
   AUTHOR               varchar(100) comment '����',
   RELEASE_DATE         datetime comment '�������ڣ�����Ϊ���ã�',
   RELEASE_SYS_DATE     datetime comment '�������ڣ�ϵͳ���ڣ�',
   CHECK_TIME           datetime comment '����ͨ��ʱ��',
   DISABLE_TIME         datetime comment '����ʱ��',
   VIEW_TOTAL           bigint not null default 0 comment '�������',
   VISIT_TOTAL          bigint not null default 0 comment '�ܹ����ش���',
   VISIT_TODAY          bigint not null default 0 comment '�������ش���',
   VISIT_WEEK           bigint not null default 0 comment '�������ش���',
   VISIT_MONTH          bigint not null default 0 comment '�������ش���',
   VISIT_QUARTER        bigint not null default 0 comment '�������ش���',
   VISIT_YEAR           bigint not null default 0 comment '�������ش���',
   STAT_DATE            date comment 'ͳ��ʱ��',
   OUTER_URL            varchar(255) comment '�ⲿ����',
   CONTENT_RES_PATH     varchar(200) comment '��Դ·��',
   TPL_CONTENT          varchar(100) comment 'ָ��ģ��',
   CHECK_STEP           int comment '��˼���',
   CHECK_OPINION        varchar(255) comment '������',
   TOP_LEVEL            int default 0 comment '�ö�����',
   HOMEPAGE             varchar(100) comment '������ҳ',
   DEMO_URL             varchar(100) comment 'ϵͳ��ʾ',
   CONTACT              varchar(100) comment '��ϵ��ʽ',
   ENVIRONMENT          varchar(255) comment '���л���',
   EVALUATION           int comment '�������',
   FILE_TYPE            varchar(20) comment '�ļ�����',
   FILE_SIZE            bigint comment '�ļ���С',
   DOWN_COUNT           bigint comment '���ش���',
   COMMENT_COUNT        int not null default 0 comment '��������',
   CONTENT              longtext comment '��ϸ��Ϣ',
   HAS_TITLEIMG         bool not null default 0 comment '�Ƿ��б���ͼƬ',
   IS_BOLD              bool not null default 0 comment '�Ƿ�Ӵ�',
   IS_DRAFT             bool not null default 0 comment '�Ƿ�ݸ�',
   IS_RECOMMEND         bool not null default 0 comment '�Ƿ��Ƽ�',
   IS_CHECK             bool not null default 1 comment '�Ƿ����',
   IS_REJECT            bool not null default 0 comment '�Ƿ񲵻�',
   IS_DISABLED          bool not null default 0 comment '�Ƿ����',
   PARAM1               varchar(255) comment '�����������1',
   PARAM2               varchar(255) comment '�����������2',
   PARAM3               varchar(255) comment '�����������3',
   DEF_STRING_1         varchar(255) comment '�Զ����ַ���1',
   DEF_STRING_2         varchar(255) comment '�Զ����ַ���2',
   DEF_STRING_3         varchar(255) comment '�Զ����ַ���3',
   DEF_STRING_4         varchar(255) comment '�Զ����ַ���4',
   DEF_STRING_5         varchar(255) comment '�Զ����ַ���5',
   DEF_STRING_6         varchar(255) comment '�Զ����ַ���6',
   DEF_STRING_7         varchar(255) comment '�Զ����ַ���7',
   DEF_STRING_8         varchar(255) comment '�Զ����ַ���8',
   DEF_STRING_9         varchar(255) comment '�Զ����ַ���9',
   DEF_LONG_1           bigint comment '�Զ��峤����1',
   DEF_LONG_2           bigint comment '�Զ��峤����1',
   DEF_LONG_3           bigint comment '�Զ��峤����1',
   DEF_LONG_4           bigint comment '�Զ��峤����1',
   DEF_LONG_5           bigint comment '�Զ��峤����1',
   DEF_MONEY1           numeric(12,2) comment '�Զ�����1',
   DEF_MONEY2           numeric(12,2) comment '�Զ�����2',
   DEF_MONEY3           numeric(12,2) comment '�Զ�����3',
   DEF_DATE1            datetime comment '�Զ�������1',
   DEF_DATE2            datetime comment '�Զ�������2',
   DEF_DATE3            datetime comment '�Զ�������3',
   DEF_BOOL1            bool comment '�Զ��岼��1',
   DEF_BOOL2            bool comment '�Զ��岼��2',
   DEF_BOOL3            bool comment '�Զ��岼��3',
   primary key (DOWNLOAD_ID)
)
comment = "���ر�";

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
   NAME                 varchar(100) comment '����',
   DESCRIPTION          varchar(255) comment '����',
   PRIORITY             int comment '����˳��',
   IS_DISABLED          bool not null default 0 comment '�Ƿ����',
   primary key (DOWNTYPE_ID)
)
comment = "������ͣ����������������⣩";

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
   TITLE                varchar(255) comment '����',
   DESCRIPTION          varchar(255) comment '����',
   VOTE_COUNT           bigint comment 'ͶƱ����',
   PRIORITY             int not null comment '��ʾ���ȼ�',
   primary key (VOTEITEM_ID)
)
comment = "ͶƱ��";

/*==============================================================*/
/* Table: VOTE_RECORD                                           */
/*==============================================================*/
create table VOTE_RECORD
(
   VRECORD_ID           bigint not null auto_increment,
   VTOPIC_ID            bigint not null,
   MEMBER_ID            bigint,
   VOTE_TIME            datetime comment 'ͶƱʱ��',
   VOTE_IP              varchar(50) comment 'ͶƱIP',
   VOTE_COOKIE          char(32) comment 'ͶƱcookie',
   primary key (VRECORD_ID)
)
comment = "ͶƱ��¼";

/*==============================================================*/
/* Table: VOTE_TOPIC                                            */
/*==============================================================*/
create table VOTE_TOPIC
(
   VTOPIC_ID            bigint not null auto_increment,
   WEBSITE_ID           bigint not null,
   TITLE                varchar(255) comment '����',
   DESCRIPTION          varchar(255) comment '����',
   TOTAL_COUNT          bigint comment 'ͶƱ����',
   START_TIME           datetime comment '��ʼʱ��',
   END_TIME             datetime comment '����ʱ��',
   REPEATE_HOUR         int comment '�ظ�ͶƱ����ʱ��(��λСʱ)',
   MULTI_SELECT         int comment '������ѡ����',
   IS_RESTRICT_MEMBER   bool not null comment '�Ƿ����ƻ�ԱID',
   IS_RESTRICT_IP       bool not null comment '�Ƿ�����IP',
   IS_RESTRICT_COOKIE   bool not null comment '�Ƿ�����cookie',
   IS_CURRENT           bool not null comment '�Ƿ�Ϊ����ͶƱ',
   IS_DISABLED          bool not null comment '�Ƿ��ֹͶƱ',
   primary key (VTOPIC_ID)
)
comment = "ͶƱ����";

alter table VOTE_ITEM add constraint FK_VITEM_TOPIC foreign key (VTOPIC_ID)
      references VOTE_TOPIC (VTOPIC_ID) on delete restrict on update restrict;

alter table VOTE_RECORD add constraint FK_VRECORD_GUEST foreign key (MEMBER_ID)
      references CORE_MEMBER (MEMBER_ID) on delete restrict on update restrict;

alter table VOTE_RECORD add constraint FK_VRECORD_TOPIC foreign key (VTOPIC_ID)
      references VOTE_TOPIC (VTOPIC_ID) on delete restrict on update restrict;

alter table VOTE_TOPIC add constraint FK_VTOPIC_WEBSITE foreign key (WEBSITE_ID)
      references CORE_WEBSITE (WEBSITE_ID) on delete restrict on update restrict;