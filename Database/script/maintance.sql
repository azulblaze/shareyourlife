select * from users

insert into admins(account,name,password) values('andy_chen','Andy Chen','chen1983');

select * from admins


select distinct(id_tags),t.* from tags_rel tr left join tags t on tr.id_tags=t.id
		where tr.account='solzhang' and name like'%ио%' order by tr.id desc limit 0,2


select a.*, c.* from (
select distinct a.* from tags a, tags_rel b 
where a.id = b.id_tags  and b.account = 'andy'
order by b.id desc ) a, 
(select id_tags, count(*) as picture_count from tags_rel group by id_tags order by id desc ) c
where a.id = c.id_tags