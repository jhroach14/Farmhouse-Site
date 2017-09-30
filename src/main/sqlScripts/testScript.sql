#This script is used to populate the db with test data

insert into users (username, password, enabled, email) values ('user', '1234', true, 'jhroach14@gmail.com');
insert into authorities (username, authority) values ('user', 'ROLE_ADMIN');

insert into photos (photo_path, thumb_path, photo_text) values ("/img/main-gallery1.jpg", "/img/thumb/main-gallery1.jpg", "mouseover text 1");
insert into photos (photo_path, thumb_path, photo_text) values ("/img/main-gallery2.jpg","/img/thumb/main-gallery2.jpg", "mouseover text 2");
insert into photos (photo_path, thumb_path, photo_text) values ("/img/main-gallery3.jpg", "/img/thumb/main-gallery3.jpg","mouseover text 3");
insert into photos (photo_path, thumb_path, photo_text) values ("/img/about-main.jpg", "/img/thumb/about-main.jpg","mouseover text 4");
insert into photos (photo_path, thumb_path, photo_text) values ("/img/about-minor.jpg", "/img/thumb/about-minor.jpg", "mouseover text 5");
insert into photos (photo_path, thumb_path, photo_text) values ("/img/section0-pic0.jpg","/img/thumb/section0-pic0.jpg","mouseover text 6");
insert into photos (photo_path, thumb_path, photo_text) values ("/img/section1-pic0.jpg", "/img/thumb/section1-pic0.jpg","mouseover text 7");
insert into photos (photo_path, thumb_path, photo_text) values ("/img/section2-pic0.jpg", "/img/thumb/section2-pic0.jpg","mouseover text 8");
insert into photos (photo_path, thumb_path, photo_text) values ("/img/registry-get-started.jpg","/img/thumb/registry-get-started.jpg", "Get Started");
insert into photos (photo_path, thumb_path, photo_text) values ("/img/chair.jpg", "/img/thumb/chair.jpg", "chair");


insert into home_page_photos (photo) value (1);
insert into home_page_photos (photo) value (2);
insert into home_page_photos (photo) value (3);

insert into blog_posts (post_title, post_date, post_type, post_text) values ("Title 1", NOW(), 0, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin in tristique turpis, sed pretium lacus. Suspendisse potenti. Pellentesque molestie tempus eros. Vivamus dapibus quis leo nec hendrerit. Vivamus pulvinar tellus sed mi aliquet, et molestie dolor blandit. Quisque vitae ullamcorper velit. Aliquam eros dui, sagittis at cursus id, faucibus ut odio. Nullam blandit mi a nisi facilisis, sed venenatis nunc efficitur. Pellentesque id sapien id magna vehicula placerat. Vestibulum accumsan fringilla metus sed euismod.");
insert into blog_posts (post_title, post_date, post_type, post_text) values ("Title 2", NOW(), 0, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin in tristique turpis, sed pretium lacus. Suspendisse potenti. Pellentesque molestie tempus eros. Vivamus dapibus quis leo nec hendrerit. Vivamus pulvinar tellus sed mi aliquet, et molestie dolor blandit. Quisque vitae ullamcorper velit. Aliquam eros dui, sagittis at cursus id, faucibus ut odio. Nullam blandit mi a nisi facilisis, sed venenatis nunc efficitur. Pellentesque id sapien id magna vehicula placerat. Vestibulum accumsan fringilla metus sed euismod.");
insert into blog_posts (post_title, post_date, post_type, post_text) values ("Title 3", NOW(), 0, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin in tristique turpis, sed pretium lacus. Suspendisse potenti. Pellentesque molestie tempus eros. Vivamus dapibus quis leo nec hendrerit. Vivamus pulvinar tellus sed mi aliquet, et molestie dolor blandit. Quisque vitae ullamcorper velit. Aliquam eros dui, sagittis at cursus id, faucibus ut odio. Nullam blandit mi a nisi facilisis, sed venenatis nunc efficitur. Pellentesque id sapien id magna vehicula placerat. Vestibulum accumsan fringilla metus sed euismod.");

insert into about_pages (store_season, store_days, store_hours, company_bio, phone_number, address, email, primary_photo, secondary_photo) values ("SUMMER","Monday-Saturday", "11:00am - 5:00pm","Lorem ipsum dolor sit amet, consectetur adipiscing elit.
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
                vulnera inponebat, eadem ille sanabat. Hoc est non modo cor non habere, sed ne palatum quidem.","770-410-112","12680 Crabapple Road, Milton GA 30004","Urbanfarmhousedesigns@yahoo.com", 4, 5);

insert into gallery_sections (section_title, section_text) values ("Section 1", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin in tristique turpis, sed pretium lacus. Suspendisse potenti. Pellentesque molestie tempus eros. Vivamus dapibus quis leo nec hendrerit.");
insert into gallery_sections (section_title, section_text) values ("Section 2", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin in tristique turpis, sed pretium lacus. Suspendisse potenti. Pellentesque molestie tempus eros. Vivamus dapibus quis leo nec hendrerit.");
insert into gallery_sections (section_title, section_text) values ("Section 3", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin in tristique turpis, sed pretium lacus. Suspendisse potenti. Pellentesque molestie tempus eros. Vivamus dapibus quis leo nec hendrerit.");

insert into gallery_section_photos (section_id, photo_id) values (1,6);
insert into gallery_section_photos (section_id, photo_id) values (2,7);
insert into gallery_section_photos (section_id, photo_id) values (3,8);

insert into services (service_title, service_text) values ("Event 1", "Quisque vitae ullamcorper velit. Aliquam eros dui, sagittis at cursus id, faucibus ut odio. Nullam blandit mi a nisi facilisis, sed venenatis nunc efficitur. Pellentesque id sapien id magna vehicula placerat. Vestibulum accumsan fringilla metus sed euismod");
insert into services (service_title, service_text) values ("Event 2", "Quisque vitae ullamcorper velit. Aliquam eros dui, sagittis at cursus id, faucibus ut odio. Nullam blandit mi a nisi facilisis, sed venenatis nunc efficitur. Pellentesque id sapien id magna vehicula placerat. Vestibulum accumsan fringilla metus sed euismod");
insert into services (service_title, service_text) values ("Event 3", "Quisque vitae ullamcorper velit. Aliquam eros dui, sagittis at cursus id, faucibus ut odio. Nullam blandit mi a nisi facilisis, sed venenatis nunc efficitur. Pellentesque id sapien id magna vehicula placerat. Vestibulum accumsan fringilla metus sed euismod");
insert into services (service_title, service_text) values ("Event 4", "Quisque vitae ullamcorper velit. Aliquam eros dui, sagittis at cursus id, faucibus ut odio. Nullam blandit mi a nisi facilisis, sed venenatis nunc efficitur. Pellentesque id sapien id magna vehicula placerat. Vestibulum accumsan fringilla metus sed euismod");
insert into services (service_title, service_text) values ("Event 5", "Quisque vitae ullamcorper velit. Aliquam eros dui, sagittis at cursus id, faucibus ut odio. Nullam blandit mi a nisi facilisis, sed venenatis nunc efficitur. Pellentesque id sapien id magna vehicula placerat. Vestibulum accumsan fringilla metus sed euismod");

insert into registry_pages (intro_text, main_photo) values ("GETTING STARTED", 9);

insert into registry_entry (recipient, description, code, email, phone) values ("John & Jane Smith", "It will be a fun wedding please bring a gift below", "1234", "jhroach14@gmail.com", "770-846-8529");
insert into registry_entry (recipient, description, code, email, phone) values ("Jake & Jill Smith", "It will not be a fun wedding please dont bring a gift below", "4321", "jhroach14@gmail.com", "770-846-8529");

insert into registry_item (price, title, description, photo) values (1.99, "chair 1", "a lovely chair", 10);
insert into registry_item (price, title, description, photo) values (2.99, "chair 2",  "a lovely chair", 10);
insert into registry_item (price, title, description, photo) values (3.99, "chair 3",  "a lovely chair", 10);
insert into registry_item (price, title, description, photo) values (400.99, "chair 4",  "an expensive lovely chair", 10);
insert into registry_item (price, title, description, photo) values (500.99, "chair 5",  "an expensive lovely chair", 10);

insert into entry_items (entry_id, item_id) values (1, 1);
insert into entry_items (entry_id, item_id) values (1, 2);
insert into entry_items (entry_id, item_id) values (1, 3);
insert into entry_items (entry_id, item_id) values (1, 4);
insert into entry_items (entry_id, item_id) values (2, 5);
insert into entry_items (entry_id, item_id) values (2, 2);
insert into entry_items (entry_id, item_id) values (2, 3);
insert into entry_items (entry_id, item_id) values (2, 4);

insert into inspire_pages(side_title, side_text) values ("Our Inspirations", "Qui autem de summo bono dissentit de tota philosophiae ratione dissentit. Memini me adesse P. Quod non faceret, si in voluptate summum bonum poneret.
                                                         Ita ne hoc quidem modo paria peccata sunt. Quae hic rei publicae
                                                         vulnera inponebat, eadem ille sanabat. Hoc est non modo cor non habere, sed ne palatum quidem.");

insert into interiors (address) value ("131 Herman St");
insert into interiors (address) value ("132 Herman St");
insert into interiors (address) value ("133 Herman St");

insert into interior_photos (interior_id, photo_id) values (1,1);
insert into interior_photos (interior_id, photo_id) values (1,2);
insert into interior_photos (interior_id, photo_id) values (1,3);
insert into interior_photos (interior_id, photo_id) values (1,4);
insert into interior_photos (interior_id, photo_id) values (1,5);
insert into interior_photos (interior_id, photo_id) values (1,6);
insert into interior_photos (interior_id, photo_id) values (1,7);
insert into interior_photos (interior_id, photo_id) values (2,1);
insert into interior_photos (interior_id, photo_id) values (2,2);
insert into interior_photos (interior_id, photo_id) values (2,3);
insert into interior_photos (interior_id, photo_id) values (2,4);
insert into interior_photos (interior_id, photo_id) values (2,5);
insert into interior_photos (interior_id, photo_id) values (2,6);
insert into interior_photos (interior_id, photo_id) values (2,7);