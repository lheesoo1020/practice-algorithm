select i.id, n.fish_name, i.length
from fish_info as i
join fish_name_info as n
on i.fish_type = n.fish_type
join (select fish_type, max(length) as max_length
     from fish_info
     group by fish_type) as t
on i.fish_type = t.fish_type and i.length = t.max_length
order by i.id
