

select * from Session

select * from [Group]

select s.id, s.GroupID, s.TimeSlotID, s.SessionNo, s.SessionDate, s.Room, s.LectureID, s.Status, g.GroupName, g.CourseID from Session as s Inner join [Group] as g
on s.GroupID = g.ID and s.LectureID='sonnt5'
where s.SessionDate = '2022-05-10'
order by s.TimeSlotID


select * from GroupStudent
where GroupID = 1

--Take attendance Screen <for a lecture(vd: sonnt5) in one day(vd: '2022-05-09')>:
select s.id, s.GroupID, s.TimeSlotID, s.SessionNo, s.SessionDate, s.Room, s.LectureID, s.Status, g.GroupName, g.CourseID 
from Session as s Inner join [Group] as g
on s.GroupID = g.ID and s.LectureID='sonnt5'
where s.SessionDate = '2022-05-09'
order by s.TimeSlotID


--Take attandance for a group <vd: GroupID = 1 (SE1623-PRJ301-Slot5)>
select * from GroupStudent as gs inner join Student as s
on gs.StudentID = s.ID
where GroupID = 1
