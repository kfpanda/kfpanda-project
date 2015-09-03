/*==============================================================*/
/* Database name:  Database_1                                   */
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2015/9/2 14:53:31                            */
/*==============================================================*/


/*==============================================================*/
/* Table: corps                                                 */
/*==============================================================*/
create table corps
(
   id                   bigint not null auto_increment,
   createtime           timestamp not null default CURRENT_TIMESTAMP,
   name                 varchar(100) not null,
   manager              varchar(50),
   captain              varchar(50),
   member               varchar(100),
   best                 varchar(10),
   primary key (id)
);

/*==============================================================*/
/* Index: corps_id_idx                                          */
/*==============================================================*/
create unique index corps_id_idx on corps
(
   id
);

/*==============================================================*/
/* Index: corps_createtime_idx                                  */
/*==============================================================*/
create unique index corps_createtime_idx on corps
(
   createtime
);

/*==============================================================*/
/* Table: game                                                  */
/*==============================================================*/
create table game
(
   id                   bigint not null auto_increment,
   createtime           timestamp not null default CURRENT_TIMESTAMP,
   cnname               varchar(100),
   enname               varchar(70),
   nkname               varchar(70),
   developer            varchar(100),
   agent                varchar(100),
   type                 varchar(1),
   `desc`               varchar(1000),
   version              varchar(20),
   primary key (id)
);

/*==============================================================*/
/* Index: game_id_idx                                           */
/*==============================================================*/
create unique index game_id_idx on game
(
   id
);

/*==============================================================*/
/* Index: game_createtime_idx                                   */
/*==============================================================*/
create unique index game_createtime_idx on game
(
   createtime
);

/*==============================================================*/
/* Table: hotagainst                                            */
/*==============================================================*/
create table hotagainst
(
   id                   bigint not null auto_increment,
   createtime           timestamp not null default CURRENT_TIMESTAMP,
   pid1                 bigint not null,
   pid2                 bigint not null,
   occupation1          varchar(50) not null,
   occupation2          varchar(50) not null,
   cards1               varchar(50) not null,
   cards2               varchar(50) not null,
   result               varchar(50),
   frist                varchar(50),
   round                varchar(50),
   hid                  bigint not null,
   primary key (id)
);

/*==============================================================*/
/* Index: hotagainst_id_idx                                     */
/*==============================================================*/
create unique index hotagainst_id_idx on hotagainst
(
   id
);

/*==============================================================*/
/* Index: hotagainst_createtime_idx                             */
/*==============================================================*/
create unique index hotagainst_createtime_idx on hotagainst
(
   createtime
);

/*==============================================================*/
/* Table: hotsite                                               */
/*==============================================================*/
create table hotsite
(
   id                   bigint not null auto_increment,
   createtime           timestamp not null default CURRENT_TIMESTAMP,
   name                 varchar(100),
   startdate            timestamp,
   enddate              timestamp,
   address              varchar(100),
   playernum            int,
   rule                 varchar(50),
   registration         varchar(100),
   bonus                varchar(100),
   intro                varchar(500),
   result               varchar(100),
   mid                  bigint not null,
   primary key (id)
);

alter table hotsite comment '一个游戏一张赛站表。赛站是具体的一个活动。';

/*==============================================================*/
/* Index: hotsite_id_idx                                        */
/*==============================================================*/
create unique index hotsite_id_idx on hotsite
(
   id
);

/*==============================================================*/
/* Index: hotsite_createtime_idx                                */
/*==============================================================*/
create unique index hotsite_createtime_idx on hotsite
(
   createtime
);

/*==============================================================*/
/* Table: `match`                                               */
/*==============================================================*/
create table `match`
(
   id                   bigint not null auto_increment,
   createtime           timestamp not null default CURRENT_TIMESTAMP,
   name                 varchar(100),
   holder               varchar(100),
   size                 varchar(10),
   cycle                int,
   level                varchar(5),
   type                 varchar(10),
   gid                  bigint,
   primary key (id)
);

/*==============================================================*/
/* Index: match_id_idx                                          */
/*==============================================================*/
create unique index match_id_idx on `match`
(
   id
);

/*==============================================================*/
/* Index: match_createtime_idx                                  */
/*==============================================================*/
create unique index match_createtime_idx on `match`
(
   createtime
);

/*==============================================================*/
/* Table: people                                                */
/*==============================================================*/
create table people
(
   id                   bigint not null auto_increment,
   createtime           timestamp not null default CURRENT_TIMESTAMP,
   updatetime           timestamp not null,
   name                 varchar(30),
   age                  int,
   country               varchar(40),
   sex                  tinyint,
   college              varchar(120),
   primary key (id)
);

/*==============================================================*/
/* Index: people_id_idx                                         */
/*==============================================================*/
create unique index people_id_idx on people
(
   id
);

/*==============================================================*/
/* Index: people_createtime_idx                                 */
/*==============================================================*/
create unique index people_createtime_idx on people
(
   createtime
);

/*==============================================================*/
/* Table: player                                                */
/*==============================================================*/
create table player
(
   id                   bigint not null auto_increment,
   createtime           timestamp not null default CURRENT_TIMESTAMP,
   cnname               varchar(50),
   enname               varchar(30),
   gamebest             varchar(10),
   Favourite            varchar(100),
   pid                  bigint,
   gid                  bigint,
   primary key (id)
);

/*==============================================================*/
/* Index: player_id_idx                                         */
/*==============================================================*/
create unique index player_id_idx on player
(
   id
);

/*==============================================================*/
/* Index: player_createtime_idx                                 */
/*==============================================================*/
create unique index player_createtime_idx on player
(
   createtime
);

/*==============================================================*/
/* Table: player_corps                                          */
/*==============================================================*/
create table player_corps
(
   id                   bigint not null auto_increment,
   pid                  bigint not null,
   cid                  bigint not null,
   primary key (id)
);

/*==============================================================*/
/* Index: player_corps_id_idx                                   */
/*==============================================================*/
create unique index player_corps_id_idx on player_corps
(
   id
);

/*==============================================================*/
/* Index: player_corps_pid_cid_idx                              */
/*==============================================================*/
create unique index player_corps_pid_cid_idx on player_corps
(
   pid,
   cid
);

/*==============================================================*/
/* Table: player_hotsite                                        */
/*==============================================================*/
create table player_hotsite
(
   id                   bigint not null auto_increment,
   hid                  bigint not null,
   piid                 bigint not null,
   primary key (id)
);

alter table player_hotsite comment '选手赛站中间表，一个选手可以参加多个赛站；一个赛站有多个选手参加。';

/*==============================================================*/
/* Index: player_hotsite_id_idx                                 */
/*==============================================================*/
create unique index player_hotsite_id_idx on player_hotsite
(
   id
);

/*==============================================================*/
/* Index: player_hotsite_pid_hid_idx                            */
/*==============================================================*/
create unique index player_hotsite_pid_hid_idx on player_hotsite
(
   hid,
   piid
);

alter table hotagainst add constraint FK_hotagainst_hotsite_hid foreign key (hid)
      references hotsite (id) on delete restrict on update restrict;

alter table hotsite add constraint FK_hotsite_match_mid foreign key (mid)
      references `match` (id) on delete restrict on update restrict;

alter table `match` add constraint FK_match_game_gid foreign key (gid)
      references game (id) on delete restrict on update restrict;

alter table player add constraint FK_player_game_gid foreign key (gid)
      references game (id) on delete restrict on update restrict;

alter table player add constraint FK_player_people_pid foreign key (pid)
      references people (id) on delete restrict on update restrict;

alter table player_corps add constraint FK_player_corps_cid foreign key (cid)
      references corps (id) on delete restrict on update restrict;

alter table player_corps add constraint FK_player_corps_pid foreign key (pid)
      references player (id) on delete restrict on update restrict;

alter table player_hotsite add constraint FK_player_hotsite_hid foreign key (hid)
      references hotsite (id) on delete restrict on update restrict;

alter table player_hotsite add constraint FK_player_hotsite_pid foreign key (piid)
      references player (id) on delete restrict on update restrict;

