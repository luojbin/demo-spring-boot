drop table if exists clazz;
drop table if exists score;
drop table if exists student;

create table clazz
(
    id             int(10)     not null primary key,
    class_name     varchar(30) null ,
    student_amount int(10)
);


create table score
(
    id         int(10)     not null primary key,
    student_id int(10)     null,
    course     varchar(10) null,
    score      int(10)     null
);

	create table student
(
    id           int(10)     not null primary key,
    clazz_id     int(10)     null,
    student_name varchar(20) null,
    age          int(10)     null,
    address      varchar(50) null
);

INSERT INTO clazz (id, class_name, student_amount) VALUES (1, '终极一班', 5);
INSERT INTO clazz (id, class_name, student_amount) VALUES (2, '木叶第七班', 3);
INSERT INTO clazz (id, class_name, student_amount) VALUES (3, '三年二班', 3);

INSERT INTO score (id, student_id, course, score) VALUES (111, 11, '嘴遁', 79);
INSERT INTO score (id, student_id, course, score) VALUES (112, 11, '平底锅', 89);
INSERT INTO score (id, student_id, course, score) VALUES (121, 12, '石中剑', 99);
INSERT INTO score (id, student_id, course, score) VALUES (122, 12, '亚里士多德', 87);
INSERT INTO score (id, student_id, course, score) VALUES (123, 12, '哲学', 89);
INSERT INTO score (id, student_id, course, score) VALUES (131, 13, '语文', 87);
INSERT INTO score (id, student_id, course, score) VALUES (132, 13, '数学', 87);
INSERT INTO score (id, student_id, course, score) VALUES (141, 14, '英语', 78);
INSERT INTO score (id, student_id, course, score) VALUES (142, 14, '语文', 97);
INSERT INTO score (id, student_id, course, score) VALUES (151, 15, '语文', 89);
INSERT INTO score (id, student_id, course, score) VALUES (211, 21, '影分身', 87);
INSERT INTO score (id, student_id, course, score) VALUES (212, 21, '色诱术', 95);
INSERT INTO score (id, student_id, course, score) VALUES (213, 21, '螺旋丸', 79);
INSERT INTO score (id, student_id, course, score) VALUES (221, 22, '写轮眼', 75);
INSERT INTO score (id, student_id, course, score) VALUES (222, 22, '千鸟', 85);
INSERT INTO score (id, student_id, course, score) VALUES (231, 23, '大力王', 94);
INSERT INTO score (id, student_id, course, score) VALUES (232, 23, '医学', 79);
INSERT INTO score (id, student_id, course, score) VALUES (233, 23, '理发', 87);
INSERT INTO score (id, student_id, course, score) VALUES (311, 31, '双截棍', 89);
INSERT INTO score (id, student_id, course, score) VALUES (312, 31, '青花瓷', 88);
INSERT INTO score (id, student_id, course, score) VALUES (321, 32, '作文', 99);
INSERT INTO score (id, student_id, course, score) VALUES (322, 32, '诗歌', 79);
INSERT INTO score (id, student_id, course, score) VALUES (323, 32, '音乐', 74);
INSERT INTO score (id, student_id, course, score) VALUES (331, 33, '跳舞', 83);
INSERT INTO score (id, student_id, course, score) VALUES (332, 33, '唱歌', 83);
INSERT INTO score (id, student_id, course, score) VALUES (333, 33, '旅游', 93);

INSERT INTO student (id, clazz_id, student_name, age, address) VALUES (11, 1, '汪大东', 18, '台湾');
INSERT INTO student (id, clazz_id, student_name, age, address) VALUES (12, 1, '亚瑟王', 19, '新疆');
INSERT INTO student (id, clazz_id, student_name, age, address) VALUES (13, 1, '丁小雨', 22, '广东');
INSERT INTO student (id, clazz_id, student_name, age, address) VALUES (14, 1, '吴尊', 23, '文莱');
INSERT INTO student (id, clazz_id, student_name, age, address) VALUES (15, 1, '唐禹哲', 21, '福建');
INSERT INTO student (id, clazz_id, student_name, age, address) VALUES (21, 2, '鸣人', 17, '妙木山');
INSERT INTO student (id, clazz_id, student_name, age, address) VALUES (22, 2, '佐助', 16, '宇智波');
INSERT INTO student (id, clazz_id, student_name, age, address) VALUES (23, 2, '春野樱', 15, '木叶村');
INSERT INTO student (id, clazz_id, student_name, age, address) VALUES (31, 3, '周杰伦', 22, '秋名山');
INSERT INTO student (id, clazz_id, student_name, age, address) VALUES (32, 3, '方文山', 22, '台北');
INSERT INTO student (id, clazz_id, student_name, age, address) VALUES (33, 3, '蔡依林', 22, '台北101');