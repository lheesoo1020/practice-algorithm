select m.member_name, r.review_text, date_format(r.review_date, "%Y-%m-%d")
from member_profile as m
join rest_review as r
on m.member_id = r.member_id
where m.member_id in (
    select member_id
    from rest_review
    group by member_id
    having count(*) = (
        select max(review_count)
        from (select count(*) as review_count
                from rest_review
                group by member_id
                ) as tmp1
    )
)
order by r.review_date asc, r.review_text asc