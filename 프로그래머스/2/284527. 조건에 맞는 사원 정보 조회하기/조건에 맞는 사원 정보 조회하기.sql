select sum(g.score) as score, e.emp_no, e.emp_name, e.position, e.email
from hr_employees e
join hr_grade g on g.emp_no = e.emp_no
where g.year = 2022
group by e.emp_no
order by score desc
limit 1