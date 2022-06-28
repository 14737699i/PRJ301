

select * from Session

select * from [Group]

select s.id, s.GroupID, s.TimeSlotID, s.SessionNo, s.SessionDate, s.Room, s.LectureID, s.Status, g.GroupName, g.CourseID from Session as s Inner join [Group] as g
on s.GroupID = g.ID and s.LectureID='sonnt5'

select * from GroupStudent
where GroupID = 1

--