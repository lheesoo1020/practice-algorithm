select i.rest_id, i.rest_name, i.food_type, i.favorites, i.address, round(t.avg_score, 2) as score
from rest_info as i
join (select rest_id, avg(review_score) as avg_score
     from rest_review
     group by rest_id) as t
on i.rest_id = t.rest_id
where i.address like '서울%'
order by score desc, i.favorites desc