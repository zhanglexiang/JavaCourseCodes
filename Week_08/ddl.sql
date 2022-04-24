-- 创建订单表
create table s_order_0
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

create table s_order_1
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

create table s_order_2
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

create table s_order_3
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

create table s_order_4
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

create table s_order_5
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

create table s_order_6
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

create table s_order_7
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

create table s_order_8
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

create table s_order_9
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

create table s_order_10
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

create table s_order_11
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

create table s_order_12
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

create table s_order_13
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

create table s_order_14
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

create table s_order_15
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


insert into ds1.s_order_5(code, user_id) value ("D000001", 1);
insert into ds1.s_order_1(code, user_id) value ("D000002", 1);

insert into ds0.s_order_5(code, user_id) value ("D000003", 2);
insert into ds0.s_order_1(code, user_id) value ("D000004", 2);
