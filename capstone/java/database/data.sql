BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users(username, password_hash,role, first_name, last_name, email, phone) VALUES ('DemoLandlord', '$2a$10$WJkaxU4xbismiufFOwZBmu6X21d8imD6Ca3pKUY9d.cVPOnSGIDt2', 'ROLE_LANDLORD', 'Lan', 'Dlord', 'landlord@gmail.com', '5559201254');

COMMIT TRANSACTION;
