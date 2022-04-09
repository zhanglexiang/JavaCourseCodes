-- 创建用户表
create table s_user
(
    id               bigint auto_increment primary key,
    create_time          timestamp    default CURRENT_TIMESTAMP null comment '创建时间',
    update_time          timestamp    default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间',
    login_name       varchar(64)                          not null comment '用户名',
    name             varchar(64)                          null comment '姓名',
    password         varchar(255)                         not null comment '密码',
    salt             varchar(64)                          not null comment '密码加密串',
    register_ip      varchar(128)                         null comment '注册IP',
    email            varchar(128)                         null comment '邮箱',
    constraint login_name unique (login_name)
)  comment '用户信息表' charset = utf8;


-- 创建商品表
create table s_commodity
(
    id               bigint auto_increment primary key,
    create_time          timestamp    default CURRENT_TIMESTAMP null comment '创建时间',
    update_time          timestamp    default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间',
    name             varchar(64)                          null comment '商品名称'
)  comment '商品信息表' charset = utf8;


-- 创建订单表
create table s_order
(
    id               bigint auto_increment primary key,
    create_time          timestamp    default CURRENT_TIMESTAMP null comment '创建时间',
    update_time          timestamp    default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间',
    code             varchar(64)                          null comment '订单号',
    user_id            bigint(11)                             null comment '用户ID',
    order_status     int                                 null comment '订单状态 -2:已删除/-1:已关闭/0:待支付/1:已支付成功/2:已失效/3:回调异常',
    commodity_num     int                                 null comment '商品总数量',
    message          varchar(255)                        null comment '留言',
    pay_way          varchar(100)                        null comment '支付方式',
    pay_time         timestamp                           null comment '支付时间',
    original_sum     decimal(12, 2)                      null comment '订单原价',
    discount         decimal(12, 2)                      null comment '折扣',
    final_sum        decimal(12, 2)                      null comment '实付金额',
)  comment '订单表' charset = utf8;

-- 创建订单明细表
create table s_order_detail
(
    id               bigint auto_increment primary key,
    create_time          timestamp    default CURRENT_TIMESTAMP null comment '创建时间',
    update_time          timestamp    default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间',
    order_id            bigint(11)                             null comment '订单ID',
    commodity_num     int                                 null comment '商品数量',
    commodity_price  decimal(12, 2)                      null comment '商品单价',
    original_sum     decimal(12, 2)                      null comment '商品总价'
)  comment '订单明细表' charset = utf8;


