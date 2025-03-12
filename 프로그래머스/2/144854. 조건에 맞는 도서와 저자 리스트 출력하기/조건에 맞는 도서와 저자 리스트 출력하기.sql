select b.book_id, a.author_name, date_format(b.published_date, '%Y-%m-%d') as published_date
from book as b natural join author as a
where category = '경제'
order by published_date asc