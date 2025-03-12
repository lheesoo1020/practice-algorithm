select o.animal_id, o.name
from animal_outs as o
where o.animal_id not in (
    select i.animal_id
    from animal_ins as i)
order by o.animal_id asc