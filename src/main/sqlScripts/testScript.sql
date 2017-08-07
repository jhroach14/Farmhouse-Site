#This script is used to populate the db with test data

insert into users (username, password, enabled, email) values ('user', '1234', true, 'jhroach14@gmail.com');
insert into authorities (username, authority) values ('user', 'ROLE_ADMIN');

insert into photos (photo_path, photo_text) values ("/img/main-gallery1.jpg", "mouseover text 1");
insert into photos (photo_path, photo_text) values ("/img/main-gallery2.jpg", "mouseover text 2");
insert into photos (photo_path, photo_text) values ("/img/main-gallery3.jpg", "mouseover text 3");

insert into home_page_photos (photo) value (1);
insert into home_page_photos (photo) value (2);
insert into home_page_photos (photo) value (3);

insert into blog_posts (post_title, post_date, post_type, post_text) values ("Title 1", NOW(), 0, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin in tristique turpis, sed pretium lacus. Suspendisse potenti. Pellentesque molestie tempus eros. Vivamus dapibus quis leo nec hendrerit. Vivamus pulvinar tellus sed mi aliquet, et molestie dolor blandit. Quisque vitae ullamcorper velit. Aliquam eros dui, sagittis at cursus id, faucibus ut odio. Nullam blandit mi a nisi facilisis, sed venenatis nunc efficitur. Pellentesque id sapien id magna vehicula placerat. Vestibulum accumsan fringilla metus sed euismod.");
insert into blog_posts (post_title, post_date, post_type, post_text) values ("Title 2", NOW(), 0, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin in tristique turpis, sed pretium lacus. Suspendisse potenti. Pellentesque molestie tempus eros. Vivamus dapibus quis leo nec hendrerit. Vivamus pulvinar tellus sed mi aliquet, et molestie dolor blandit. Quisque vitae ullamcorper velit. Aliquam eros dui, sagittis at cursus id, faucibus ut odio. Nullam blandit mi a nisi facilisis, sed venenatis nunc efficitur. Pellentesque id sapien id magna vehicula placerat. Vestibulum accumsan fringilla metus sed euismod.");
insert into blog_posts (post_title, post_date, post_type, post_text) values ("Title 3", NOW(), 0, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin in tristique turpis, sed pretium lacus. Suspendisse potenti. Pellentesque molestie tempus eros. Vivamus dapibus quis leo nec hendrerit. Vivamus pulvinar tellus sed mi aliquet, et molestie dolor blandit. Quisque vitae ullamcorper velit. Aliquam eros dui, sagittis at cursus id, faucibus ut odio. Nullam blandit mi a nisi facilisis, sed venenatis nunc efficitur. Pellentesque id sapien id magna vehicula placerat. Vestibulum accumsan fringilla metus sed euismod.");

