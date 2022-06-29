
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

--Add unique key constrain to Session (<GroupID+SessionNo> and <TimeSlot + SessionDate + Room> must be unique)

ALTER TABLE [Session]
ADD CONSTRAINT UC_SessionNoOfGroup UNIQUE (GroupID, SessionNo)

ALTER TABLE [Session]
ADD CONSTRAINT UC_SpaceTime UNIQUE (TimeSlotID, SessionDate, Room)


--Add session to Session table

/*declare @index_group int = 1

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
END*/


 -- 1. Add session for groupID = 1, <SE1623, PRJ301, sonnt5, slot 5-2,4,6>
	-- session for slot 5-2
	declare @index_session int = 1
	declare @index_sessionNo int = 1
	declare @date date = '2022-05-09'

	WHILE(@index_session <= 10)
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
			   (1
			   ,5
			   ,@index_sessionNo
			   ,@date
			   ,'DE-C202'
			   ,'sonnt5'
			   ,0)

	SET @index_session = @index_session + 1;
	SET @index_sessionNo = @index_sessionNo + 3;
	SET @date = DATEADD(day, 7, @date)
	END
	-- session for slot 5-3 
	declare @index_session int = 1
	declare @index_sessionNo int = 2
	declare @date date = '2022-05-11'

	WHILE(@index_session <= 10)
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
			   (1
			   ,5
			   ,@index_sessionNo
			   ,@date
			   ,'DE-C202'
			   ,'sonnt5'
			   ,0)

	SET @index_session = @index_session + 1;
	SET @index_sessionNo = @index_sessionNo + 3;
	SET @date = DATEADD(day, 7, @date)
	END

	-- session for slot 5-5 
	declare @index_session int = 1
	declare @index_sessionNo int = 3
	declare @date date = '2022-05-13'

	WHILE(@index_session <= 9)
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
			   (1
			   ,5
			   ,@index_sessionNo
			   ,@date
			   ,'DE-C202'
			   ,'sonnt5'
			   ,0)

	SET @index_session = @index_session + 1;
	SET @index_sessionNo = @index_sessionNo + 3;
	SET @date = DATEADD(day, 7, @date)
	END

 -- 2. Add session for groupID = 6, <SE1627, PRJ301, sonnt5, slot 1-2,4,6>
	-- session for slot 1-2
	declare @index_session int = 1
	declare @index_sessionNo int = 1
	declare @date date = '2022-05-09'

	WHILE(@index_session <= 10)
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
			   (1
			   ,1
			   ,@index_sessionNo
			   ,@date
			   ,'DE-C202'
			   ,'sonnt5'
			   ,0)

	SET @index_session = @index_session + 1;
	SET @index_sessionNo = @index_sessionNo + 3;
	SET @date = DATEADD(day, 7, @date)
	END
	-- session for slot 1-3 
	declare @index_session int = 1
	declare @index_sessionNo int = 2
	declare @date date = '2022-05-11'

	WHILE(@index_session <= 10)
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
			   (1
			   ,1
			   ,@index_sessionNo
			   ,@date
			   ,'DE-C202'
			   ,'sonnt5'
			   ,0)

	SET @index_session = @index_session + 1;
	SET @index_sessionNo = @index_sessionNo + 3;
	SET @date = DATEADD(day, 7, @date)
	END

	-- session for slot 1-5 
	declare @index_session int = 1
	declare @index_sessionNo int = 3
	declare @date date = '2022-05-13'

	WHILE(@index_session <= 9)
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
			   (1
			   ,1
			   ,@index_sessionNo
			   ,@date
			   ,'DE-C202'
			   ,'sonnt5'
			   ,0)

	SET @index_session = @index_session + 1;
	SET @index_sessionNo = @index_sessionNo + 3;
	SET @date = DATEADD(day, 7, @date)
	END

-- 3. Add session for groupID = 8, <SE1654, DBI202, sonnt5, slot 2-2,4,6>
-- session for slot 2-2
	declare @index_session int = 1
	declare @index_sessionNo int = 1
	declare @date date = '2022-05-09'

	WHILE(@index_session <= 10)
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
			   (8
			   ,2
			   ,@index_sessionNo
			   ,@date
			   ,'DE-C203'
			   ,'sonnt5'
			   ,0)

	SET @index_session = @index_session + 1;
	SET @index_sessionNo = @index_sessionNo + 3;
	SET @date = DATEADD(day, 7, @date)
	END
	-- session for slot 2-3 
	declare @index_session int = 1
	declare @index_sessionNo int = 2
	declare @date date = '2022-05-11'

	WHILE(@index_session <= 10)
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
			   (8
			   ,2
			   ,@index_sessionNo
			   ,@date
			   ,'DE-C203'
			   ,'sonnt5'
			   ,0)

	SET @index_session = @index_session + 1;
	SET @index_sessionNo = @index_sessionNo + 3;
	SET @date = DATEADD(day, 7, @date)
	END

	-- session for slot 2-5 
	declare @index_session int = 1
	declare @index_sessionNo int = 3
	declare @date date = '2022-05-13'

	WHILE(@index_session <= 9)
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
			   (8
			   ,2
			   ,@index_sessionNo
			   ,@date
			   ,'DE-C203'
			   ,'sonnt5'
			   ,0)

	SET @index_session = @index_session + 1;
	SET @index_sessionNo = @index_sessionNo + 3;
	SET @date = DATEADD(day, 7, @date)
	END

-- 3. Add session for groupID = 9, <SE1628, PRJ301, sonnt5, slot 1,2 - 3 and 1-5>
	--Add slot 1,2 - 3
	declare @index_session int = 1
	declare @index_sessionNo int = 1
	declare @date date = '2022-05-10'

	WHILE(@index_session <= 20)
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
			   (9
			   ,1
			   ,@index_sessionNo
			   ,@date
			   ,'DE-C204'
			   ,'sonnt5'
			   ,0)

	SET @index_session = @index_session + 1;
	SET @index_sessionNo = @index_sessionNo + 1;

	INSERT INTO [dbo].[Session]
			   ([GroupID]
			   ,[TimeSlotID]
			   ,[SessionNo]
			   ,[SessionDate]
			   ,[Room]
			   ,[LectureID]
			   ,[Status])
		 VALUES
			   (9
			   ,2
			   ,@index_sessionNo
			   ,@date
			   ,'DE-C204'
			   ,'sonnt5'
			   ,0)
	SET @index_session = @index_session + 1;
	SET @index_sessionNo = @index_sessionNo + 2;
	SET @date = DATEADD(day, 7, @date)

	END
	--Add slot 1 - 5
	declare @index_session int = 1
	declare @index_sessionNo int = 3
	declare @date date = '2022-05-12'

	WHILE(@index_session <= 9)
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
			   (9
			   ,1
			   ,@index_sessionNo
			   ,@date
			   ,'DE-C204'
			   ,'sonnt5'
			   ,0)
	SET @index_session = @index_session + 1;
	SET @index_sessionNo = @index_sessionNo + 3;
	SET @date = DATEADD(day, 7, @date)
	END



