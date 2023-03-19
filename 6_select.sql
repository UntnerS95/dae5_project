set search_path to tms;

select * from motorcycle order by number asc;
select * from track;

select * from track_details_view order by name asc, id asc;
select * from driver_motorcycle_view order by username asc;

select * from points inner join police_control on points.number = police_control.point_id;
select * from points left join police_control on points.number = police_control.point_id;
select * from points inner join radartrap on points.number = radartrap.point_id;
select * from points left join radartrap on points.number = radartrap.point_id;