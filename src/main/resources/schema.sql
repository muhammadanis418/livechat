
    create table chat_message (
        id bigint not null auto_increment,
        timestamp datetime(6),
        content varchar(255),
        session_id varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table chat_session (
        created_at datetime(6),
        session_id varchar(255) not null,
        status varchar(255),
        user_id varchar(255),
        primary key (session_id)
    ) engine=InnoDB;

    alter table chat_message 
       add constraint FKgtjn4wh83q8ohixkwcotpoob9 
       foreign key (session_id) 
       references chat_session (session_id);

    create table chat_message (
        id bigint not null auto_increment,
        timestamp datetime(6),
        content varchar(255),
        session_id varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table chat_session (
        created_at datetime(6),
        session_id varchar(255) not null,
        status varchar(255),
        user_id varchar(255),
        primary key (session_id)
    ) engine=InnoDB;

    alter table chat_message 
       add constraint FKgtjn4wh83q8ohixkwcotpoob9 
       foreign key (session_id) 
       references chat_session (session_id);

    create table chat_message (
        id bigint not null auto_increment,
        timestamp datetime(6),
        content varchar(255),
        session_id varchar(255) not null,
        primary key (id)
    ) engine=InnoDB;

    create table chat_session (
        created_at datetime(6),
        session_id varchar(255) not null,
        status varchar(255),
        user_id varchar(255),
        primary key (session_id)
    ) engine=InnoDB;

    alter table chat_message 
       add constraint FKgtjn4wh83q8ohixkwcotpoob9 
       foreign key (session_id) 
       references chat_session (session_id);
