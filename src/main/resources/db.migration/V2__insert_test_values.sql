SET search_path TO sales;

insert into company(name, email, created, description)
values ('FirstLocationTestValue');

insert into users(username, email, name, role, created, updated, company_id)
values ('FirstLocationTestValue');

insert into category(name, parent_category, description)
values ('FirstLocationTestValue');

insert into item(name, description, created, category_id)
values ('FirstLocationTestValue');

insert into position(item_id, company_id, created_by, created, amount, min_amount)
values ('FirstLocationTestValue');

