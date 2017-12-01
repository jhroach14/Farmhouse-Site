# noinspection SqlNoDataSourceInspectionForFile

/*Author: James Roach.
This is the script used to build the main database for the site
 */

/*-----Tables for spring user managment-----*/
/*users also used as a data entity*/
create table users(
    id int auto_increment not null,
    username varchar(256),
    password varchar(256),
    enabled boolean,
    email varchar(256),

    primary key(id)
);

create table authorities (
    username varchar(256),
    authority varchar(256) /*authority correlates to level of access to the site*/
);

/*-----entity tables-----*/
/*Photo collection storage*/
create table photos(
    id int auto_increment not null,
    photo_path varchar(1028) not null,
    thumb_path varchar(1028) not null,
    photo_text varchar(256),/*mouse over text*/

    primary key (id)
);

/*home page entity. jpa repo no entity*/
create table home_page_photos(
    id int auto_increment not null,
    photo int not null,

    primary key (id),

    constraint pht1_hmpg_fk foreign key (photo) references photos(id)
);

/*Most recent blog posts pulled */
create table blog_posts(
    id int auto_increment not null,
    post_title varchar(128) not null,
    post_date datetime not null,
    post_type int not null, /*0=text only, 1=Photo, 2=video*/
    post_text varchar(16384), /*text post = main content, Photo or video = subtext*/
    data_path varchar(1028), /*Photo or video data path*/

    primary key (id)
);

create table inspire_pages(
    id int auto_increment not null,
    side_title varchar(64) not null,
    side_text varchar(4096) not null,

    primary key (id)

);

/*about page entities*/
create table about_pages(
    id int auto_increment not null,
    store_season varchar(64) not null,
    store_days varchar(64) not null,
    store_hours varchar(64) not null,
    company_bio varchar(16384) not null,
    phone_number varchar(32) not null,
    address varchar(256) not null,
    email varchar(64) not null,
    primary_photo int not null,
    secondary_photo int not null,

    primary key (id),

    constraint abtp_photo_fk foreign key (primary_photo) references photos(id),
    constraint abtp_photo2_fk foreign key (secondary_photo) references photos(id)
);

/*service page entities*/
create table services(
    id int auto_increment not null,
    service_title varchar(128) not null,
    service_text varchar(4096) not null,

    primary key (id)
);

/*many photos for many services requries link table*/
create table service_photos(
    service_id int not null,
    photo_id int not null,

    primary key (service_id, photo_id),

    constraint srvc_pht_fk foreign key (service_id) references services(id),
    constraint pht_srvc_fk foreign key (photo_id) references photos(id)
);

create table interiors (
    id int auto_increment not null,
    address varchar(256) not null,

    primary key (id)
);

/*many photos for many interiors requries link table*/
create table interior_photos(
    interior_id int not null,
    photo_id int not null,

    primary key (interior_id, photo_id),

    constraint intr_pht_fk foreign key (interior_id) references interiors(id),
    constraint pht_intr_fk foreign key (photo_id) references photos(id)
);

/*registry page entities*/
create table registry_pages(
    id int auto_increment not null,
    intro_text varchar(1028) not null,
    main_photo int not null,

    primary key (id),

    constraint reg_photo_fk foreign key (main_photo) references photos(id)
);
/*each wedding registered gets an entry with a code*/
create table registry_entry(
    id int auto_increment not null,
    recipient varchar (128) not null,
    description varchar (4096),
    code varchar (32) not null,
    email varchar(256) not null,
    phone varchar(256) not null,

    primary key (id)
);
/*each item availiable in the registry gets an item entry*/
create table registry_item(
    id int auto_increment not null,
    price double not null,
    title varchar(128) not null,
    description varchar(4096),
    photo int not null,

    primary key (id),

    constraint reg_it_pht_fk foreign key (photo) references photos(id)
);
/*entries are linked to items via link table*/
create table entry_items(
    entry_id int not null,
    item_id int not null,

    primary key (entry_id, item_id),

    constraint entry_it_fk foreign key (entry_id) references registry_entry(id),
    constraint it_entry_fk foreign key (item_id) references registry_item(id)
);

/*gallery page entities*/
create table gallery_sections(
    id int auto_increment not null,
    section_title varchar(256) not null,
    section_text varchar(4096),

    primary key (id)
);

create table gallery_section_photos(
    section_id int not null,
    photo_id int not null,

    primary key (section_id, photo_id),

    constraint sect_pht_fk foreign key (section_id) references gallery_sections(id),
    constraint pht_sect_fk foreign key (photo_id) references photos(id)
);

create table events(
    id int auto_increment not null,
    name varchar(256) not null,
    description varchar(4096) not null,
    photo int,

    primary key (id),

    constraint evnt_pht_fk foreign key (photo) references photos(id)
);

/*many photos for many events requries link table*/
create table event_photos(
    event_id int not null,
    photo_id int not null,

    primary key (event_id, photo_id),

    constraint evnt_phts_fk foreign key (event_id) references events(id),
    constraint phts_evnt_fk foreign key (photo_id) references photos(id)
);




