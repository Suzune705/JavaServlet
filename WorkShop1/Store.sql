create table users (
    user_id int primary key ,
	account varchar(50) not null unique ,
    password varchar(50) not null,
    role varchar(20) not null check (role in ('manager', 'employee'))
);



create table employees (
    employee_id varchar(20),
    name nvarchar(50) not null,
    phone varchar(20),
    age int check (age > 18),
);

insert into users (user_id, account, password, role) values
(1, 'Ha Thi Hai', '123', 'manager'),
(2, 'Luong Thi Hieu', '123', 'employee');


insert into employees (employee_id, name, phone, age) values
('EM1', 'nguyen van anh', '0901234567', 24),
('EM2', 'tran thi bao', '0902345678', 22),
('EM3', 'le van trang', '0903456789', 28),
('EM4', 'pham thi danh', '0904567890', 26),
('EM5', 'hoang van manh', '0905678901', 30),
('EM6', 'ngo thi thuy', '0906789012', 21),
('EM7', 'doan van hieu', '0907890123', 27),
('EM8', 'vu thi ha', '0908901234', 25);

select * from employees