SET search_path TO sales;

insert into company(name, email, created, description)
values ('Company_name', 'company_email', current_timestamp, 'company_description');

insert into users(username, email, name, password, role, status, created, updated, company_id)
values ('user', 'user_email', 'name','$2a$12$D1.ICUpw.7hYZnfml9LL4OHg6SImjzyd8ZIEWl/1tiY3WtQsFWRI6', 'USER', 'ACTIVE', current_timestamp, current_timestamp, 1);

insert into category(name, description)
values ('Category_name', 'category_description');

insert into item(name, description, created, category_id)
values ('item_name', 'item_description', current_timestamp, 1);

insert into position(item_id, company_id, created_by, created, amount, min_amount)
values (1, 1, 1, current_timestamp, 0.1, 0.01);