

select * from Session

select * from [Group]

select s.id, s.GroupID, s.TimeSlotID, s.SessionNo, s.SessionDate, s.Room, s.LectureID, s.Status, g.GroupName, g.CourseID from Session as s Inner join [Group] as g
on s.GroupID = g.ID and s.LectureID='sonnt5'
where s.SessionDate = '2022-05-10'
order by s.TimeSlotID


select * from GroupStudent
where GroupID = 1

--Take attendance Screen <for a lecture(vd: sonnt5) in one day(vd: '2022-05-09')>:
select s.id, s.GroupID, g.GroupName, g.CourseID, s.TimeSlotID, s.SessionNo, s.SessionDate, s.Room, s.LectureID, s.Status  
from Session as s Inner join [Group] as g
on s.GroupID = g.ID and s.LectureID='sonnt5'
where s.SessionDate = '2022-05-09'
order by s.TimeSlotID


--Take attandance for a group <vd: SessionID=6 GroupID = 1 (SE1623-PRJ301-Slot5)>

select * from Session 
where ID = 64

	--if status = 0, load groupStudent by groupID in session, 

	select gs.GroupID, gs.StudentID, s.StudentName from GroupStudent as gs inner join Student as s
	on gs.StudentID = s.ID
	where GroupID = 1

	--else load exist data from AttendanceReport by SessionID
	select * from AttendanceReport
	where SessionID = 64



--Weekly TimeTable
	select s.id, s.GroupID,g.GroupName, g.CourseID, s.TimeSlotID, s.SessionNo, s.SessionDate, s.Room, s.LectureID, s.Status
	from Session as s Inner join [Group] as g 
	on s.GroupID = g.ID and s.LectureID='sonnt5'
	where s.SessionDate >= '2022-05-09' AND s.SessionDate<= '2022-05-15'
	order by s.SessionDate, TimeSlotID

--select s.id, s.GroupID,g.GroupName, g.CourseID, s.TimeSlotID, s.SessionNo, s.SessionDate, s.Room, s.LectureID, s.Status, t.StartTime, t.EndTime
--from Session as s Inner join [Group] as g 
--on s.GroupID = g.ID and s.LectureID='sonnt5'
--Inner join TimeSlot as t
--on s.TimeSlotID = t.ID
--where s.SessionDate >= '2022-05-09' AND s.SessionDate<= '2022-05-15'
--order by s.SessionDate
--Attandance Report

select g.id, g.GroupName, g.CourseID, c.CourseName from [Group] as g inner join Course as c 
on g.CourseID = c.ID
where LectureID = 'sonnt5'

--select ID from Session
--where GroupID = 1
--order by SessionDate

select * from AttendanceReport
where SessionID in (select ID from Session
where GroupID = 1)



--Demo
select * from Session
where SessionDate = '2022-05-09' and LectureID='sonnt5'
order by TimeSlotID