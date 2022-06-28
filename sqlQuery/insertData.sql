
-- INSERT INTO Student table

declare @index int = 0
WHILE(@INDEX <= 100)
BEGIN
INSERT INTO [dbo].[Student]
           ([StudentName]
           ,[StudentDOB]
           ,[StudentGender])
     VALUES
           ('student_name_' + CAST(@index AS varchar(150))
           ,'2000-1-1'
           ,1)
SET @INDEX = @INDEX + 1;
END

--Add unique key constrain to Sesion (<Timeslot+SessionDate+Room> must be unique)
ALTER TABLE [Session]
ADD CONSTRAINT UC_Session UNIQUE (TimeSlotID, SessionDate, Room)

--Add session to Session table


declare @index_group int = 1

while(@index_group<=(select Count(ID) from [Group]))
BEGIN

	declare @index_session int = 1
	

	select * into #temp_group from [Group] 
	--select * from #temp_group 


	declare @numOfSlot int = (SELECT c.NumOfSlot from [Group] as g inner join Course as c
	ON g.CourseID = c.ID
	WHERE g.ID = @index_group)
	WHILE(@index_session <= @numOfSlot)
	BEGIN
	INSERT INTO [dbo].[Session]
			   ([GroupID]
			   ,[TimeSlotID]
			   ,[SessionNo]
			   ,[SessionDate]
			   ,[Room]
			   ,[LectureID]
			   ,[Status])
		 VALUES
			   (<GroupID, int,>
			   ,<TimeSlotID, int,>
			   ,<SessionNo, int,>
			   ,<SessionDate, date,>
			   ,<Room, varchar(20),>
			   ,<LectureID, varchar(20),>
			   ,<Status, bit,>)

	SET @index_session = @index_session + 1;
	END

	delete #temp_group

	SET @index_group = @index_group + 1;
END




