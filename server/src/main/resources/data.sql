use school_management_v2;
insert into school_management_v2.roles(id, name)
    value (null, 'STUDENT');
insert into school_management_v2.roles(id, name)
    value (null, 'TEACHER');
insert into school_management_v2.roles(id, name)
    value (null, 'CHEF');
insert into school_management_v2.users(age, id, role_id, first_name, last_name)
values (20, null, 1, 'Yassir', 'Jeraidi');
insert into school_management_v2.departments(id, user_id, name)
    value (null, null, 'INFORMATIQUE');
insert into school_management_v2.filieres(id, department_id, name)
values (null, 1, 'GLAASRI');
insert into school_management_v2.modules (nbr_elements, filiere_id, id, name)
values (2, 1, null , 'JAVA');
insert into module_elements (id, module_id, name)
values (null , 1 , 'Spring Boot');
insert into module_elements (id, module_id, name)
values (null , 1 , 'Jakarta EE');

select *
from school_management_v2.users;
select *
from roles;

desc departments;
desc filieres;

truncate users;