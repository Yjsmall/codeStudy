/**
 * 地址列表模块的声明
 */

/**
 * 数据特征
 */
#define NAME_LENGTH     30
#define ADDRESS_LENGTH  110 /* 运行出现的最长地址
#define PHONE_LENGTH    10   
#define MAX_ADDRESSES     1000 /* 出现的最多地址个数

/**
 * 接口函数
 * 给出一个名字,查找对应的地址
 */
char const *
lookup_address(char const *name);

/**
 * 给出一个名字,查找对应的电话号码
 */
char const *
lookup_phone(char const *name);