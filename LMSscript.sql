Create Database  If not exists `LMS_directory`;
Use `LMS_directory`;

--
-- Table structure for table `Users`
--

Drop Table if exists `users`;

-- create the users table

Create table users(
id bigint auto_increment primary key,
first_name varchar(45) not null,
last_name varchar(45) not null ,
email varchar(45) unique not null ,
phone_no varchar(15) ,
unique_code varchar(50) unique not null);

----- insert values in user table

INSERT INTO users (id, first_name, last_name, email, phone_no, unique_code) VALUES
(1,'Leslie','Andrews','leslie@gamil.com', '9834567810','LA567'),
(2,'Emma','Baumgarten','emma@gmail.com','9876543290','JS456'),
(3,'Avani','Gupta','avani@gmail.com','7865346754','AG789'),
(4,'Yuri','Petrov','yuri@gmail.com','8856782345','YP345'),
(5,'Juan','Vega','juan@gmail.com','7890674543','JV202');



------ create the teams table
Create table Teams
(
id bigint auto_increment primary key ,
team_name varchar(100) unique,
team_lead varchar(100)
);


----- insert values in teams table 

Insert into Teams (id , team_name , team_lead) values
(1,'Alpha','Juan vega'),
(2,'Beta','Avani Gupta'),
(3,'Gamma','Leslie Andrews');


------- create the leaves table

create table Leaves(
id bigint auto_increment primary key ,
leave_type varchar(100),
start_date date,
end_date date,
user_id bigint , 
foreign key (user_id) references Users(id));

------- insert into leaves table

Insert into Leaves (id , leave_type,start_date,end_date,user_id) values
(1,'Sick leave','2024-08-16','2024-08-16' ,5),
(2,'Casual leave','2024-07-02','2024-07-05',3),
(3,'Matrenity leave','2024-10-01','2024-12-31',4),
(4,'Patrenity leave','2024-11-01','2024-11-07',2),
(5,'Annual leave','2024-08-01','2024-08-10',1);

--------- create the userteam  table

create table User_Teams
      (
		
         user_id bigint not null ,
         team_id bigint not null ,
         primary key(user_id,team_id ),
         foreign key (user_id) references Users(id),
         foreign key (team_id) references Teams(id)
     );

----- insert into user_team

Insert into User_Teams( user_id ,team_id) values
(1,1),
(2,2),
(2,3),
(2,1),
(3,2);


