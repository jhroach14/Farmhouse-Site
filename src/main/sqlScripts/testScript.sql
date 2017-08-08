#This script is used to populate the db with test data

insert into users (username, password, enabled, email) values ('user', '1234', true, 'jhroach14@gmail.com');
insert into authorities (username, authority) values ('user', 'ROLE_ADMIN');

insert into photos (photo_path, photo_text) values ("/img/main-gallery1.jpg", "mouseover text 1");
insert into photos (photo_path, photo_text) values ("/img/main-gallery2.jpg", "mouseover text 2");
insert into photos (photo_path, photo_text) values ("/img/main-gallery3.jpg", "mouseover text 3");
insert into photos (photo_path, photo_text) values ("/img/about-main.jpg", "mouseover text 4");
insert into photos (photo_path, photo_text) values ("/img/about-minor.jpg", "mouseover text 5");


insert into home_page_photos (photo) value (1);
insert into home_page_photos (photo) value (2);
insert into home_page_photos (photo) value (3);

insert into blog_posts (post_title, post_date, post_type, post_text) values ("Title 1", NOW(), 0, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin in tristique turpis, sed pretium lacus. Suspendisse potenti. Pellentesque molestie tempus eros. Vivamus dapibus quis leo nec hendrerit. Vivamus pulvinar tellus sed mi aliquet, et molestie dolor blandit. Quisque vitae ullamcorper velit. Aliquam eros dui, sagittis at cursus id, faucibus ut odio. Nullam blandit mi a nisi facilisis, sed venenatis nunc efficitur. Pellentesque id sapien id magna vehicula placerat. Vestibulum accumsan fringilla metus sed euismod.");
insert into blog_posts (post_title, post_date, post_type, post_text) values ("Title 2", NOW(), 0, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin in tristique turpis, sed pretium lacus. Suspendisse potenti. Pellentesque molestie tempus eros. Vivamus dapibus quis leo nec hendrerit. Vivamus pulvinar tellus sed mi aliquet, et molestie dolor blandit. Quisque vitae ullamcorper velit. Aliquam eros dui, sagittis at cursus id, faucibus ut odio. Nullam blandit mi a nisi facilisis, sed venenatis nunc efficitur. Pellentesque id sapien id magna vehicula placerat. Vestibulum accumsan fringilla metus sed euismod.");
insert into blog_posts (post_title, post_date, post_type, post_text) values ("Title 3", NOW(), 0, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin in tristique turpis, sed pretium lacus. Suspendisse potenti. Pellentesque molestie tempus eros. Vivamus dapibus quis leo nec hendrerit. Vivamus pulvinar tellus sed mi aliquet, et molestie dolor blandit. Quisque vitae ullamcorper velit. Aliquam eros dui, sagittis at cursus id, faucibus ut odio. Nullam blandit mi a nisi facilisis, sed venenatis nunc efficitur. Pellentesque id sapien id magna vehicula placerat. Vestibulum accumsan fringilla metus sed euismod.");

insert into about_pages (store_hours, company_bio, phone_number, address, email, primary_photo, secondary_photo) values ("SUMMER<br/>Monday-Saturday<br/>11:00am - 5:00pm","Lorem ipsum dolor sit amet, consectetur adipiscing elit.
                Hoc est non modo cor non habere, sed ne palatum quidem.
                Quid ergo aliud intellegetur nisi uti ne quae pars naturae neglegatur?
                Neque enim disputari sine reprehensione nec cum iracundia aut pertinacia recte disputari potest.
                A mene tu? Videsne quam sit magna dissensio?
                Ita enim vivunt quidam, ut eorum vita refellatur oratio.
                Obsecro, inquit, Torquate, haec dicit Epicurus?
                Duo Reges: constructio interrete. Omnia contraria, quos etiam insanos esse vultis.
                Satis est ad hoc responsum.

                Qui autem de summo bono dissentit de tota philosophiae ratione dissentit.
                Memini me adesse P. Quod non faceret, si in voluptate summum bonum poneret.
                Ita ne hoc quidem modo paria peccata sunt. Quae hic rei publicae
                vulnera inponebat, eadem ille sanabat. Hoc est non modo cor non habere, sed ne palatum quidem.","770-410-112","12680 Crabapple Road, Milton GA 30004","Urbanfarmhousedesigns@yahoo.com", 4, 5)