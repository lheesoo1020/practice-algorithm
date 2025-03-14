select i.animal_type, case when i.name is null then 'No name' else i.name end, i.sex_upon_intake
from animal_ins as i
order by i.animal_id