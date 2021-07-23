# 182. 查找重复的电子邮箱
select distinct a.Email from Person a, Person b where a.Email=b.Email and a.id!=b.id

select Email from Person group by email having count(email) > 1