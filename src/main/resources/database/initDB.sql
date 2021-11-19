create table if not exists TypeGame(
	id_type serial primary key,
	TypeGame varchar(100)
);

create table if not exists Table_Games(
	id_game serial primary key,
	name_game varchar(230),
	describe_game varchar(230),
	filename_photo varchar(240),
	price int,
	typegame_id int,
	foreign key (typegame_id) references typegame(id_type)
);
create table if not exists feedback(
	id_fd serial primary key,
	id_tbgame int,
	name_client varchar(240),
	soname_client varchar(240),
	email_client varchar(240),
	mark int,
	foreign key (id_tbgame) references table_games(id_game)
);

create table if not exists Roles(
	id_role serial,
	role_user varchar(240) primary key
);
create table if not exists Usr(
	id_user serial primary key,
	username varchar(240),
	name_user varchar(240),
	soname_user varchar(240),
	email varchar(240),
	password_user varchar(240),
	role_user varchar(240),
	foreign key (role_user) references Roles(role_user)

);

create table if not exists card(
		id_card serial primary key,
		id_user int references usr(id_user)
);

create table if not exists  card_product(
	id_card int references card(id_card) ON DELETE CASCADE,
	id_game int references table_games(id_game) ON DELETE CASCADE,
	date_add date
);

create table if not exists  ContactUs(
	id_ct serial primary key,
	name_ct varchar(240),
	soname_ct varchar(240),
	email_ct varchar(240),
	phone_ct varchar(240),
	date_send date
);

 create table if not exists  checkout_order(
	id_c_or serial primary key,
	id_card_pr int references card(id_card),
	name_client varchar(240),
	soname_client varchar(240),
	email_client varchar(240),
	phone_client varchar(240),
	summa_order int,
	date_order date
 );