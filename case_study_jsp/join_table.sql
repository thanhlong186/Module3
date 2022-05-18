use casestudy_jsp;

select e.employee_id,
e.employee_name,
e.employee_birthday,
e.employee_id_card,
e.employee_salary,
e.employee_phone,
e.employee_email,
e.employee_address,
p.position_name,
ed.education_degree_name,
d.division_name,
e.username 
from employee e
join position p on e.position_id = p.position_id
join education_degree ed on e.education_degree_id = ed.education_degree_id
join division d on e.division_id = d.division_id;

select s.service_id ,
s.service_code,
s.service_name,
s.service_area,
s.service_cost,
s.service_max_people,
rt.rent_type_name,
st.service_type_name,
s.standard_room,
s.description_ohter_convenience,	
s.pool_area,
s.number_of_floor
from service s
join service_type st on s.service_type_id = st.service_type_id
join rent_type rt on s.rent_type_id = rt.rent_type_id
