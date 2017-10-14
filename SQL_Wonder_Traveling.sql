USE master
GO
IF DB_ID ('WonderTravelling') is not null
   Drop database [WonderTravelling]
	GO
	Create database [WonderTravelling]
	Go

   USE [WonderTravelling]
GO


/****** Object:  Table [dbo].[Car]    Script Date: 7/18/2017 11:52:43 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Car](
	[CarID] [int] IDENTITY(1,1) NOT NULL,
	[CarName] [varchar](50) NULL,
	[CarImage] [varchar](100) NULL,
	[CarTrasmission] [varchar](100) NULL,
	[CarAirConditioning] [bit] NULL,
	[CarDoors] [tinyint] NULL,
	[CarSeats] [tinyint] NULL,
	[CarStatus] [bit] NULL, /* active, deactive*/
	[CarPrice] [float] NULL,
	[CarGPS] [bit] NULL,
	[CarPushChair] [bit] NULL,
	[LicensePlate] [varchar](50) NULL
	
 CONSTRAINT [PK_Car] PRIMARY KEY CLUSTERED 
(
	[CarID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO



/****** Object:  Table [dbo].[CarBookedDetailID]    Script Date: 7/18/2017 11:52:43 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO



CREATE TABLE [dbo].[CarBooked](
	[CarBookedID] [int] IDENTITY(1,1)  NOT NULL,
	[CarID] [int] NULL, 
	[CustomerID] [int] NULL,
	[CreatedDate] [datetime] NULL,
	[PromotionCode] [varchar](20) null,
	[CarRecieveDate] [datetime] not null,
	[CarReturnCaDate] [datetime] not null,
	[CarRealityDate] [datetime] not null,
	[Price] [float] null,
	[Extra] [float] null,
	[Code] [varchar](20) null,
	[Payment] [tinyint] not null, /* (1) : direct, (2) : card*/
	[Quantity] [int] not null,
	[Deposit] [float] not null,
	[CarBookedStatus] [tinyint] null,  /* Status: (1)pending, approved(2), returned(3), cancel(4)*/
 CONSTRAINT [PK_CarBookedID] PRIMARY KEY CLUSTERED 
(
	[CarBookedID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO


/****** Object:  Table [dbo].[CustomerUser]    Script Date: 7/18/2017 11:52:43 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[CustomerUser](
	[CustomerID] [int] IDENTITY(1,1) NOT NULL,
	[FullName] [nvarchar](50) NULL,
	[Password] [varchar](20) NULL,
	[CustomerUsername] [varchar](50) NULL,	
	[Phone] [varchar](20) NULL,
	[Email] [nvarchar](50) NULL,
	[RoleID] [int] NULL,
	[Status] [bit] NOT NULL
 CONSTRAINT [PK_CustomerUser] PRIMARY KEY CLUSTERED 
(
	[CustomerID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]




CREATE TABLE [dbo].[CustomerList](
	[CusID] [int] IDENTITY(1,1) NOT NULL,
	[FullName] [nvarchar](50) NULL,
	[Sex] [bit] NULL, /****** 1 : Male (True), 0 : Female (False)******/
	[DateOfBirth] [Datetime] NULL,
	[CustomerID] [int],
	[TourBookedID] varchar(20) ---******* NEW ****** ---
 CONSTRAINT [PK_CustomerList] PRIMARY KEY CLUSTERED 
(
	[CusID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO


/****** Object:  Table [dbo].[Promotion]    Script Date: 7/18/2017 11:52:43 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Promotion](
	[PromotionID] [int] IDENTITY(1,1) NOT NULL,
	[PromotionCode] [varchar](20) NULL,
	[StartDate] [datetime] NULL,
	[EndDate] [datetime] NULL,
	[Status] [tinyint] not null /*(1): available (2): disable*/
 CONSTRAINT [PK_Promotion] PRIMARY KEY CLUSTERED 
(
	[PromotionID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO


/****** Object:  Table [dbo].[Review]    Script Date: 7/18/2017 11:52:43 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Review](
	[ReviewID] [int] IDENTITY(1,1) NOT NULL,
	[CustomerID] [int] NULL,
	[CarID] [int] NULL,
	[TourID] [varchar](50) NULL,
	[CreatedDate] [datetime] NULL,
 CONSTRAINT [PK_Review] PRIMARY KEY CLUSTERED 
(
	[ReviewID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO


/****** Object:  Table [dbo].[ReviewDetail]    Script Date: 7/18/2017 11:52:43 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ReviewDetail](
	[ReviewDetailID] [int] IDENTITY(1,1) NOT NULL,
	[Content] [nvarchar](300) NULL,
	[Rating] [tinyint] NULL,
	[ReviewID] [int] NULL,
	[CarID] [int] NULL,
	[TourID] [varchar](50) NULL,
 CONSTRAINT [PK_ReviewDetail] PRIMARY KEY CLUSTERED 
(
	[ReviewDetailID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO

/****** Object:  Table [dbo].[Comment]    Script Date: 7/18/2017 11:52:43 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Comment](
	[CommentID] [int] IDENTITY(1,1) NOT NULL,
	[Content] [nvarchar](300) NULL,
	[CustomerID] [int] NULL,
	[CarID] [int] NULL,
	[TourID] [varchar](50) NULL,
	[CreatedDate] [datetime] NULL,
 CONSTRAINT [PK_Comment] PRIMARY KEY CLUSTERED 
(
	[CommentID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO


/****** Object:  Table [dbo].[Role]    Script Date: 7/18/2017 11:52:43 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Role](
	[RoleID] [int] IDENTITY(1,1) NOT NULL,
	[RoleName] [varchar](20) NULL,
 CONSTRAINT [PK_Role] PRIMARY KEY CLUSTERED 
(
	[RoleID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO


/****** Object:  Table [dbo].[Schedule]    Script Date: 7/18/2017 11:52:43 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Schedule](
	[ScheduleID] [int] IDENTITY(1,1) NOT NULL,
	[Summary] [nvarchar](300) NULL,
	[Content] [nvarchar](max) NULL,
	[Image1] [varchar](200) NULL,
	[Image2] [varchar](200) NULL,
	[Image3] [varchar](200) NULL,
	[Image4] [varchar](200) NULL,
	[Image5] [varchar](200) NULL,
	[TourID] [varchar](50) NULL,
 CONSTRAINT [PK_Schedule] PRIMARY KEY CLUSTERED 
(
	[ScheduleID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO


/****** Object:  Table [dbo].[TourBookedDetail]    Script Date: 7/18/2017 11:52:43 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO




CREATE TABLE [dbo].[TourCategory](
	[TourCategoryID] [int] IDENTITY(1,1),
	[TourCategoryName] [nvarchar](50) NULL,
	[Destination] [nvarchar](max) NULL,
 CONSTRAINT [PK_TourCategory] PRIMARY KEY CLUSTERED 
(
	[TourCategoryID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]



GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TourDetail]    Script Date: 7/18/2017 11:52:43 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO


CREATE TABLE [dbo].[Tours](

	[TourID] [varchar](50) primary key NOT NULL,
	[TourTitle] [nvarchar](50) NULL,
	[EvenTourPrice] [float] NULL,
	[OddTourPrice] [float] NULL,
	[DepatureDay] [varchar](MAX) NULL,
	[HotelRank] [tinyint] NULL,
	[DepaturePoint] [nvarchar](100) NULL,
	[HeadingTo] [nvarchar](50) NULL, /*CỘT ĐƯỢC THÊM*/
	[Transportation] [tinyint] NULL, /*(1) Air Plane, (2) Bus*/
	[Duration] [tinyint] NULL,
	[Tickets] [tinyint] NULL,
	[Status] [bit] NULL, /*Status: active (True), deactive (False)*/
	[TourCategoryID] [int] NULL,
	[Image] [varchar] (100) NULL,
	[CreatedDate] datetime NULL
 )
GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Tours]    Script Date: 7/18/2017 11:52:43 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO


CREATE TABLE [dbo].[TourBooked](
	[TourBookedID] varchar(20) primary key,
	ISGroup bit,
	DepartureDate Datetime,
	[NumberOfAdult] [tinyint] NULL,
	[NumberOfKid] [tinyint] NULL,
	[NumberOfBaby] [tinyint] NULL,
	[NumberOfPeople] [tinyint] NULL,
	[IndividualRoom] [tinyint] NULL,
	[Transportation] [tinyint] NULL,
	[Status] [tinyint] null,  /* Status: (1)pending, departing(2), completed(3), cancel(4)*/
	[CustomerID] [int] NULL,
	[CreatedDate] [datetime] NULL,
	[PromotionID] [int] null,
	[TourID] [varchar](50) NULL,
	[IsNew] bit NULL
) 

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[TourCategory]    Script Date: 7/18/2017 11:52:43 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO


/**TABLE EXTENDED**********************************/
CREATE TABLE [dbo].[TourBookedSub](
	[TourBookedSubID] [INT] IDENTITY(1,1) primary key,
	[DepartureDate] [Datetime] NULL,
	[NumberOfAdult] [tinyint] NULL,
	[NumberOfKid] [tinyint] NULL,
	[NumberOfBaby] [tinyint] NULL,
	[NumberOfPeople] [tinyint] NULL,
	[IndividualRoom] [tinyint] NULL,
	[Transportation] [tinyint] NULL,
	[Status] [tinyint] null, /* Status: (1)pending, departing(2), completed(3), cancel(4)*/
	[CustomerID] [int] NULL,
	[CreatedDate] [datetime] NULL,
	[TourBookedID] [varchar](20) null,
	[TourID] [varchar](50) NULL,
	[IsNew] bit NULL
) 

/*===============================================================================================================================
===============================================================================================================================
===============================================================================================================================
===============================================================================================================================
===============================================================================================================================
===============================================================================================================================
===============================================================================================================================
===============================================================================================================================
*/


/*----------------------------------------------------Role---------------------------------------------------------------------*/

insert into Role values 
('admin'),
('moderator'),
('user'),
('smod'),
('guest')
go

/*----------------------------------------------------Customer User---------------------------------------------------------------------*/
insert into CustomerUser values
/*1*/('john', '123', 'John', '1212121212', 'john@email.com', 3, 1),
/*2*/('alex', '123', 'Alex', '2323232323', 'alex@email.com', 3, 1),
/*3*/('mary', '123', 'Mary', '3434343434', 'mary@email.com', 3, 1),
/*4*/('alan', '123', 'Alan', '4545454545', 'alan@email.com', 3, 1),
/*5*/('kary', '123', 'Kary', '5656565656', 'kary@email.com', 3, 1),

/*6*/('Duong Dinh Vu', '123', 'vu', '1212121212', 'vu@email.com', 4, 1),
/*7*/('Pham Dang Khoa', '123', 'khoa', '2323232323', 'alex@email.com', 3, 1),

/*8*/('Mackenzie Brown', '123', 'Brown', '1212121212', 'Brown@email.com', 1, 1),
/*9*/('Brady Ellison', '123', 'Ellison', '1212121212', 'Ellison@email.com', 1, 1),
/*10*/('Zach Garrett ', '123', 'Zach', '1212121212', 'Zach@email.com', 1, 1),
/*11*/('Jake Kaminski', '123', 'Kaminski', '1212121212', 'Kaminski@email.com', 1, 1),
/*12*/('Phillip Chew', '123', 'Chew', '1212121212', 'Chew@email.com', 1, 1),
/*13*/('Eva Lee', '123', 'Lee', '1212121212', 'Lee@email.com', 1, 1),
/*14*/('Paula Lynn Obanana', '123', 'Obanana', '1212121212', 'Obanana@email.com', 1, 1),
/*15*/('Sattawat Pongnairat', '123', 'Pongnairat', '1212121212', 'Pongnairat@email.com', 1, 1),
/*16*/('Howard Shu', '123', 'Shu', '1212121212', 'Shu@email.com', 1, 1),
/*17*/('Jamie Subandhi', '123', 'Subandhi', '1212121212', 'Subandhi@email.com', 1, 1),
/*18*/('Iris Wang', '123', 'Wang', '1212121212', 'Wang@email.com', 1, 1),
/*19*/('Seimone Augustus', '123', 'Augustus', '1212121212', 'Augustus@email.com', 1, 1),
/*20*/('Sue Bird', '123', 'Brid', '1212121212', 'Brid@email.com', 1, 1),
/*21*/('Tamika Catchings ', '123', 'Tamika', '1212121212', 'Tamika@email.com', 1, 1),
/*22*/('Tina Charles', '123', 'Charles', '1212121212', 'Charles@email.com', 1, 1),
/*23*/('Elene Delle Donne', '123', 'Donne', '1212121212', 'Donne@email.com', 1, 1),
/*24*/('Sylvia Fowles', '123', 'Fowles', '1212121212', 'Fowles@email.com', 1, 1),
/*25*/('Brittney Griner', '123', 'Griner', '1212121212', 'Griner@email.com', 1, 1),
/*26*/('Angel McCoughtry', '123', 'McCoughtry', '1212121212', 'McCoughtry@email.com', 1, 1),
/*27*/('Maya Moore', '123', 'Moore', '1212121212', 'Moore@email.com', 1, 1),
/*28*/('Breanna Stewart', '123', 'Stewart', '1212121212', 'Stewart@email.com', 1, 1),
/*29*/('Diana Taurasi', '123', 'Taurasi', '1212121212', 'Taurasi@email.com', 1, 1),
/*30*/('Lindsay Whalen', '123', 'Whalen', '1212121212', 'Whalen@email.com', 1, 1),
/*31*/('Carmelo Anthony', '123', 'Anthony', '1212121212', 'Anthony@email.com', 1, 1),
/*32*/('Harrison Barnes', '123', 'Barnes', '1212121212', 'Barnes@email.com', 1, 1),
/*33*/('Jimmy Butler', '123', 'Butler', '1212121212', 'Butler@email.com', 1, 1),
/*34*/('DeMarcus Cousins', '123', 'Cousins', '1212121212', 'Cousins@email.com', 1, 1),
/*35*/('DeMar DeRozan', '123', 'DeRozan', '1212121212', 'DeRozan@email.com', 1, 1),
/*36*/('Kevin Durant', '123', 'Durant', '1212121212', 'Durant@email.com', 1, 1),
/*37*/('Paul George', '123', 'George', '1212121212', 'George@email.com', 1, 1),
/*38*/('Draymond Green', '123', 'Green', '1212121212', 'Green@email.com', 1, 1),
/*39*/('Kyrie Irving ', '123', 'Irving', '1212121212', 'Irving@email.com', 1, 1),
/*40*/('DeAndre Jordan ', '123', 'Jordan', '1212121212', 'Jordan@email.com', 1, 1),
/*41*/('Kyle Lowry', '123', 'Lowry', '1212121212', 'Lowry@email.com', 1, 1),
/*42*/('Klay Thompson', '123', 'Thompson', '1212121212', 'Thompson@email.com', 1, 1),
/*43*/('Phil Dalhausser', '123', 'Dalhausser', '1212121212', 'Dalhausser@email.com', 1, 1),
/*44*/('Lauren Fendrick', '123', 'Fendrick', '1212121212', 'Fendrick@email.com', 1, 1),
/*45*/('Jake Gibb', '123', 'Gibb', '1212121212', 'Gibb@email.com', 1, 1),
/*46*/('Nick Lucena', '123', 'Lucena', '1212121212', 'Lucena@email.com', 1, 1),
/*47*/('April Ross', '123', 'Ross', '1212121212', 'Ross@email.com', 1, 1)
go

/*----------------------------------------------------Customer List Data---------------------------------------------------------------------*/
insert into CustomerList values
/*1*/('Mackenzie Brown', 1, '01-01-1992', 11, 'TB001'),
/*2*/('Christian Pulistic', 1, '01-01-1992', 11, 'TB001'),
/*3*/('Clint Dempsey', 1, '01-01-1992', 11, 'TB001'),
/*4*/('Tim Howard', 1, '01-01-1992', 11, 'TB001'),
/*5*/('John Anthony Brooks', 1, '01-01-1992', 11, 'TB001'),
/*6*/('Booby Wood', 0, '01-01-1992', 11, 'TB001'),
/*7*/('Michael Bradley', 1, '01-01-1992', 11, 'TB001'),
/*8*/('Landon Donovan', 1, '01-01-1992', 11, 'TB001'),
/*9*/('Fabian Johnson', 1, '01-01-1992', 11, 'TB001'),
/*10*/('Jozy Altidore', 0, '01-01-1992', 11, 'TB001'),
/*11*/('Brady Ellison', 0, '01-01-1992', 12, 'TB002'),
/*12*/('Geoff Cameron', 0, '01-01-1992', 12, 'TB002'),
/*13*/('DeAndre Yedlin', 0, '01-01-1992', 12, 'TB002'),
/*14*/('Brad Guzan', 1, '01-01-1992', 12, 'TB002'),
/*15*/('Paul Ariola', 0, '01-01-1992', 12, 'TB002'),
/*16*/('Julian Green', 0, '01-01-1992', 12, 'TB002'),
/*17*/('Tim Ream', 1, '01-01-1992', 12, 'TB002'),
/*18*/('Alex Morgan', 1, '01-01-1992', 12, 'TB002'),
/*19*/('Rubio Rubin', 0, '01-01-1992', 12, 'TB002'),
/*20*/('Timothy Chandler', 1, '01-01-1992', 12, 'TB002'),
/*21*/('Zach Garrett', 0, '01-01-1992', 13, 'TB003'),
/*22*/('DarMarcus Beasley', 0, '01-01-1992', 13, 'TB003'),
/*23*/('Aron Johannsson', 1, '01-01-1992', 13, 'TB003'),
/*24*/('Omar Gonzalez', 0, '01-01-1992', 13, 'TB003'),
/*25*/('Daniel Williams', 1, '01-01-1992', 13, 'TB003'),
/*26*/('Eric Lichaj', 1, '01-01-1992', 13, 'TB003'),
/*27*/('Matt Miazga', 0, '01-01-1992', 13, 'TB003'),
/*28*/('Carli Lloyd', 0, '01-01-1992', 13, 'TB003'),
/*29*/('Venture Alvarado', 1, '01-01-1992', 13, 'TB003'),
/*30*/('Emerson Hyndman', 0, '01-01-1992', 13, 'TB003'),
/*31*/('Jake Kaminski', 0, '01-01-1992', 14, 'TB004'),
/*32*/('Alejandro Bedoya', 1, '01-01-1992', 14, 'TB004'),
/*33*/('Jermaine Jones', 1, '01-01-1992', 14, 'TB004'),
/*34*/('Terrence Boyd', 0, '01-01-1992', 14, 'TB004'),
/*35*/('Jorge Villafana', 1, '01-01-1992', 14, 'TB004'),
/*36*/('Chris Wondolowski', 0, '01-01-1992', 14, 'TB004'),
/*37*/('Joe Corona', 0, '01-01-1992', 14, 'TB004'),
/*38*/('Bruce Arena', 0, '01-01-1992', 14, 'TB004'),
/*39*/('Mikkel Diskerud', 1, '01-01-1992', 14, 'TB004'),
/*40*/('Edgar Castillo', 1, '01-01-1992', 14, 'TB004'),
/*41*/('Phillip Chew', 0, '01-01-1992', 15, 'TB025'),
/*42*/('Francisco', 1, '01-01-1992', 15, 'TB025'),
/*43*/('Haji Wright', 0, '01-01-1992', 15, 'TB025'),
/*44*/('Kellyn Acosta', 0, '01-01-1992', 15, 'TB025'),
/*45*/('Juan', 1, '01-01-1992', 15, 'TB025'),
/*46*/('Agudelo', 0, '01-01-1992', 15, 'TB025'),
/*47*/('Freddy Adu', 1, '01-01-1992', 15, 'TB025'),
/*48*/('Perry Kitchen', 0, '01-01-1992', 15, 'TB025'),
/*49*/('Michael Orozco', 0, '01-01-1992', 15, 'TB025'),
/*50*/('Jonathan Bornstein', 1, '01-01-1992', 15, 'TB025'),
/*51*/('Nguyen Van A', 1, '01-01-1992', 39, 'TB025'),
/*52*/('Nguyen Van B', 1, '01-01-1992', 39, 'TB025'),
/*53*/('Nguyen Van C', 1, '01-01-1992', 39, 'TB025'),
/*54*/('Nguyen Van D', 1, '01-01-1992', 39, 'TB025'),
/*55*/('Nguyen Van E', 1, '01-01-1992', 39, 'TB025')
go


insert into CustomerList values 
('Tran Hoang Dinh', 1, '02-02-1995', 17, 'TB040'),
('Tran Hoang Anh', 1, '02-02-1995', 17, 'TB040'),
('Tran Quang Cap', 1, '02-02-1995', 17, 'TB040'),
('Tran Vi Vu', 1, '02-02-1995', 17, 'TB040'),
('Tran Nguyen Ngoc uyen', 0, '02-02-1997', 17, 'TB040'),
('Tran Ngoc Anh', 1, '02-02-1995', 17, 'TB040'),
('Hoang Tu Oanh', 0, '02-02-1994', 17, 'TB040'),
('Tran Van Quy', 1, '02-02-1995', 17, 'TB040'),
('Ngo Quang', 1, '02-02-1995', 17, 'TB040'),
('Ngo Ngoc Loi', 0, '02-02-1995', 17, 'TB040'),
('Tran Van Anh', 1, '02-02-1998', 17, 'TB040')
go


/*===============================================Tour Category Data===============================================================*/

insert into TourCategory values 
('Southern Tour', 'Phu Quoc, Vung Tau, Tien Giang, Can Tho'),
('Highlands Tour', 'Da Lat, Buon Me, Pleiku, Kon Tum')
go


 /*===============================================Tours Data===============================================================*/



insert into tours values
('PHUQUOC01', 'Phu Quoc Tour 3 Days 2 Nights', 250, 300, '28-08-2017, 30-08-2017, 06-09-2017, 08-09-2017, 20-09-2017, 19-09-2017, 25-09-2017, 16-10-2017', 2, 'Ho Chi Minh City', 'Phu Quoc', 1, 3, 45, 1, 1,'PhuQuoc01.jpg','2017-09-01'),
('VUNGTAU01', 'Vung Tau Tour 2 Days 1 Night', 150, 170, '28-08-2017, 10-10-2017, 11-10-2017, 29-10-2017, 30-10-2017', 2, 'Ho Chi Minh City', 'Vung Tau', 2, 2, 45, 1, 1,'VungTau01.jpg','2017-09-02'),
('TIENGIANG01', 'Tien Giang Tour 3 Days 2 Nights', 150, 180, '28-08-2017, 05-09-2017, 10-10-2017, 08-09-2017, 11-09-2017', 2, 'Ho Chi Minh City', 'Tien Giang', 1, 3, 45, 1, 1,'TienGiang01.jpg','2017-08-31'),
('CANTHO01', 'Can Tho Tour 2 Days 1 Night', 250, 280, '28-08-2017, 12-10-2017, 13-10-2017, 27-10-2017, 28-10-2017', 2, 'Ho Chi Minh City', 'Can Tho', 2, 2, 45, 1, 1,'CanTho01.jpg','2017-08-30'),
('DALAT01', 'Da Lat Tour 3 Days 2 Nights', 250, 300, '28-08-2017, 11-09-2017, 12-09-2017, 14-10-2017, 26-10-2017', 2, 'Ho Chi Minh City', 'Da Lat', 2, 3, 45, 1, 2,'DaLat01.jpg','2017-08-28')
go



 /*===============================================Schedule Data===============================================================*/
insert into Schedule values

 /*--------------------------------- Tour Tphcm - Phu Quoc---------------------------------*/
(N'Day 1: Ho Chi Minh City – Phu Quoc', '<strong> Morning </strong>: Tourists of Ben Nghe Tours welcome you
  At Tan Son Nhat Airport, take a flight to Phu Quoc. Car pick you up at the yard
  Fly to the hotel to check in, bathing.
 <strong> Afternoon </strong>: Pick up your car to visit the East Island:
  Ham Ninh Fishing Village: Ancient fishing village of the people on the island, where tourists have
 Can buy dried seafood, fresh, souvenirs here with cheap price.
 Suoi Tranh: Beautiful stream originating from Ham Ninh mountain.
 Suoi Da pepper garden: Learn about how to grow pepper in the garden, pepper floating Phu Quoc
 the sound of beads, black and spicy.
 Khai Hoan Sauce Factory: Learn how to make the anchovy fish sauce
 local and foreign language in the traditional way of Phu Quoc people with
 very high nutrient content.
 Sim wine: The wine is made from ripe simian fruit. Meet and chat with
 The first person to make wine sim paint at the establishment of Seven Gao sim.
 Su Muon Pagoda: The beautiful ancient pagoda with airy, calm space.
 On the way back, we visit Dinh Cau, cultural symbols, beliefs
 Phu Quoc fishermen.
 <strong> Evening </strong>: You have dinner, free to relax or explore
 Ngoc Island at night, visit Dinh Cau night market,
 Buy small gifts to save memories Phu Quoc tour.', 'PhuQuoc_Schedule01.jpg','', '', '', '', 'PHUQUOC01'),


(N'Day 2: Discover Phu Quoc Pearl Island', '<strong> Morning </strong>: Have breakfast, then car to start exploring Nam Ngoc Island:
Vietnamese-Vietnamese Pearl: You learn the culture process of pearls.
Cay Dua Coconut: War relics.
Group lunch at the restaurant.
<strong> Afternoon </strong>: Car take you to Sao beach, one of the most beautiful beach in Phu Quoc with white sand beach,
  smooth, long straight, visitors will be immersed in the blue sea cool.
+ On the way to visit the guests, visit An Thoi port cluster, watching the bustle of fishermen,
  Take photo An Thoi archipelago.
<strong> Evening</strong>: Go back to the hotel, take a bath, relax and have dinner, self-discovery or can join the fishing program (expenses excluded)', 'PhuQuoc_Schedule02.jpg','', '', '', '', 'PHUQUOC01'),


(N'Day 3: Phu Quoc Island – Ho Chi Minh City', '<strong> Morning </strong>: Have breakfast, free shopping at Duong Dong Market. Delegation check hotel, car
  You go to Phu Quoc airport for flight back to Ho Chi Minh City.
<strong> Noon </strong>: Arrive at Tan Son Nhat Airport, Ben Nghe Tourism Division, parting Phu Quoc Tour.','PhuQuoc_Schedule03.jpg', '', '', '', '', 'PHUQUOC01'),

 /*--------------------------------- Tour Tphcm - Vung tau---------------------------------*/
(N'Day 1: Ho Chi Minh City - Vung Tau', '
<strong>This morning</strong> at 8am you will be met at your hotel by our tour guide and driver for the 2 hour drive south to the resort town of Vung Tau.
 On arrival check into your hotel then spend the afternoon touring the city.
  Visit the White Villa,
   the impressive Statue of Jesus, the harbor and famous Back Beach. 
  <strong> In the evening</strong> you have the opportunity to try some of the town’s famous
    seafood at one of its lively local restaurants GanhHao or Cay Bang restaurant.
	 (Seafood meals will be arranged on requests) / Lunch and dinner is not included. Overnight at the hotel',
 'VungTau_Schedule01.jpg','', '', '', '', 'VUNGTAU01'),

(N'Day 2 :Vung Tau – Ho chi minh city (Breakfast)', '
<strong>The morning</strong> is free to relax on the beach or by the pool or explore more of Vung Tau.
 After lunch (not included) return to Ho Chi Minh City to arrive mid afternoon where the tour ends. Breakfast included.'
, 'VungTau_Schedule02.jpg','', '', '', '', 'VUNGTAU01'),

 /*--------------------------------- Tour Tphcm - Tien Giang---------------------------------*/

(N'Day 1: Ho Chi Minh - Tien Giang - Ben Tre', N'
 <strong>Morning:</strong>Upon arrival at Tan Son Nhat airport , our tour guide and car will pick you up  then transfer for hotel check-in。
 Breakfast in hotel. We leave Saigon behind and head to Vietnam rice basket of Mekong Delta. We will pass through idyllic, rural scenes until we arrive at My Tho, a peaceful town on the bank of the Mekong River.'
, 'TienGiang_Schedule01.jpg','', '', '', '','TIENGIANG01'),

(N'Day 2: Tien Giang - My Tho', N'
	<strong>Next</strong> we will have a boat ride on the Mekong, visit Local homes and Orchards, a Coconut candy workshop, a Honey bee farm,
	 take a sampan ride on palm-shaded creeks, try a taste of seasonal fruit and honey tea and enjoy a performance of traditional Southern singing.
After lunch, we back to  Sai Gon ,go to visit visit the Reunification Palace, formerly known as the Presidential Palace that was the
 sight of South Vietnam surrender in April 1975. Walk down to see Notre Dame Cathedral and General Post Office which are beautiful examples
  of architecture from the French colonial period. Back to hotel for a little of rest.
<strong>In the evening</strong>, we go to explore “ Ben Thanh market”, the place to go for your night shopping and late supper. You’ll find contemporary clothing,
 men and ladies shoes, Crumpler bags, sunglasses, , souvenirs from Vietnam and a lot more. As for food, the Ben Thanh night market won’t disappoint
  with a wide range of Vietnamese food from the north and all the way down south.',
 'TienGiang_Schedule02.jpg','', '', '', '', 'TIENGIANG01'),

 /*--------------------------------- Tour Tphcm - Can Tho---------------------------------*/
(N'Day 1: Ho Chi Minh City – Tien Giang – Ben Tre – Can Tho', '<strong> Morning </ strong>: Car and guide tour Ben Nghe welcome delegation from Ho Chi Minh City to Tien Giang,
 Opening Tour Can Tho. To Trung Luong, you enjoy specialties My Tho tasty, tourists visit the famous land of the Southern Period,
  Also known as My Tho Dai Pho. Crossing Tien River, tourists visit traditional coconut candy village, bee keeping center ... horse ride on the highway
   small meandering winding, watching the village coconut shade coconut trees in Ben Tre, sit rowing boat explore the life of the river west.
<strong> Afternoon </ strong>: Through Can Tho Bridge, visit ancient house Binh Thuy, built in 1870, typical architecture of the South, home has five rooms,
 The carved wood paneling is delicate, skillful, with orchid garden and 40 years old cactus, also called Kim Lăng Trụ, 8 meters in height, set a record.
  Highest in Vietnam. <br>
<strong> Evening </ strong>: Car to delegation to Ninh Kieu wharf, located at the confluence of Hau River, Tay Do tourist first, tourists roam, enjoy coffee in Thuy Ta restaurant along the river. .
 Have dinner with Southern dishes on Can Tho cruise and listen to the sweet melody of the river. You can freely go Tay Do night market knife, or Cai Khe new urban area, to explore the bustling, crowded night of Can Tho.', 'CanTho_Schedule01.jpg','', '', '', '', 'CANTHO01'),

  ('Day 2: Cai Rang - My Thuan - Sai Gon', '<strong> Morning </ strong>: Depart for Cai Rang Floating Market, one of the largest floating markets in the Mekong Delta.
    South, Western specialties. Go down the Hau River, take you to My Khanh tourist garden, visit the ancient house of the council, watch pig racing, relax in the garden.
<strong> Afternoon </ strong>: Take the delegation via Can Tho (Can Tho city), My Thuan suspension bridge (Vinh Long province) along Highway 1A to Sai Gon - Trung Luong highway back to Sai Gòn. Car to the delegation arrived at the original pickup point, Ben Nghe Tourism farewell, end Can Tho Tour', 'CanTho_Schedule02.jpg','', '', '', '', 'CANTHO01'),

  /*--------------------------------- Tour Tphcm - Da Lat---------------------------------*/
 ('Day 1: Ho Chi Minh – Bao Loc – Đa Lat', '<strong> Morning </ strong>: Car and tour guide Ben Nghe welcome the delegation, departure Da Lat tour.
  You have breakfast in Dong Nai. To Tp. Bao Loc, car to visit Dambri Falls, one of the beautiful and majestic waterfall in Bao Loc.
   You have lunch at the resort. <br>
<strong> Afternoon </ strong>: Car take you over Preen Pass, in the center of Dalat city to get room, relax, enjoy the cold air of the highland city.
<strong> Evening </ strong>: After dinner, you walk around Da Lat at night, enjoy delicious dishes at night markets, coffee flavor mountain coffee at Thuy Ta, drink milk
 Hot soybeans, double bicycles, horse drawn carts to admire Xuan Huong Lake and feel the typical cold of Dalat.', 'DaLat_Schedule01.jpg','', '', '', '', 'DALAT01'),
 ('Day 2: Du Lich Da Lat – Thung Lung Vang', '<strong> Morning </ strong>: After breakfast, drive through the fields of flowers and vegetables of the suburbs of Da Lat to take you.
  Visit the Golden Valley Resort, a unique architectural complex with waterfalls, lakes, mountains ... You visit the Church of the Domain de Marie, a unique architecture on the hill Mai Anh, the ending. harmonious combination of Western architecture and folk architecture of the ethnic minorities in the Central Highlands. You have lunch, rest at the hotel. <br>
 <strong> Afternoon </ strong>: Pick up the delegation to find Bao Dai Palace, the home of the last king of Vietnam. Guests continue to visit the City Garden, where convergence full of species in Da Lat. <br>
<strong> Evening </ strong>: After dinner, you can attend gong music night, drink wine, use barbecue, cultural exchange with the Central Highlands.', 'DaLat_Schedule02.jpg','', '', '', '', 'DALAT01'),

(N'Day 3: Da Lat – Ho Chi Minh City', '<strong> Morning </ strong>: Breakfast, check out hotel. Delegation of Truc Lam Zen Monastery, Yen Tu Truc Lam Zen Monastery,
  the most famous Dalat. Guests continue to visit the romantic Tuyen Lam Lake or cable car through Robin Hill, panoramic view of Da Lat city. Goodbye
   Thousands of flowers, depart to Ho Chi Minh City. Go to Bao Loc city, you have lunch, enjoy specialty tea, coffee, shopping at Tam Chau tea. <br>
<strong> Afternoon </ strong>: Car and tour guide Ben Nghe to the delegation of the original pickup point, farewell to you, the end of Da Lat tour.', 'DaLat_Schedule03.jpg','', '', '', '', 'DALAT01')
go




/*----------------------------------------Car Data------------------------------------------------------------*/
insert into Car values
/*1*/('Subaru BRZ','assets/images/cars/subaru_brz.jpg','manual',1,2,2,1,200,1,0,'51F53403'),
/*2*/('Subaru BRZ STI','assets/images/cars/subaru_brz.jpg','manual',1,2,2,1,300,1,0,'52F53423'),
/*3*/('Porsche 911 (993)','assets/images/cars/porsche-911.jpg','manual',1,2,2,1,300,1,0,'52E53403'),
/*4*/('Toyota Innova 2017','assets/images/cars/toyota-innova-2.jpg','automatic',1,4,7,1,800,1,1,'21C53403'),
/*5*/('Chevrolet Express Passenger','assets/images/cars/chev_exp.jpg','automatic',1,4,12,1,800,1,1,'21F54503'),
/*6*/('Chevrolet Tahoe 2015','assets/images/cars/chev-tah.jpg','automatic',1,3,7,1,500,1,1,'21F54303'),
/*7*/('Toyota Innova 2014','assets/images/cars/toyota-innova-1.jpg','automatic',1,4,7,1,800,1,1,'31A53603'),
/*8*/('Nissan NV Passenger Van','assets/images/cars/nis-nv.jpg','automatic',1,4,12,1,700,1,1,'11E43503'),
/*9*/('Porsche 911 (911)','assets/images/cars/porsche-911.jpg','manual',1,2,2,1,400,1,0,'41F63453'),
/*10*/('Toyota Innova 2012','assets/images/cars/toyota-innova.jpg','automatic',1,4,7,1,600,1,1,'31F63703'),
/*11*/('Chevrolet Traverse','assets/images/cars/chev-trav.jpg','automatic',1,4,7,1,600,1,1,'51F35403'),
/*12*/('Mercedes-Benz Sprinter Passenger Van','assets/images/cars/merc-sprinter.jpg','automatic',1,4,12,1,800,1,1,'51E54303'),
/*13*/('Chevrolet Tahoe','assets/images/cars/chev-tah.jpg','automatic',1,3,7,1,800,1,1,'51F53304'),
/*14*/('Toyota Innova 2015','assets/images/cars/toyota-innova.jpg','automatic',1,4,7,1,800,1,1,'31F53403'),
/*15*/('Chevrolet Traverse 2014','assets/images/cars/chev-trav.jpg','automatic',1,4,7,1,400,1,1,'51F53439'),
/*16*/('Mercedes-Benz Passenger Van','assets/images/cars/merc-sprinter.jpg','automatic',1,4,12,1,600,1,1,'41F54303'),
/*17*/('Chevrolet Express Passenger Van','assets/images/cars/chev_exp.jpg','automatic',1,4,12,1,800,1,1,'31F54503'),
/*18*/('Toyota Innova 2013','assets/images/cars/toyota-innova.jpg','automatic',1,4,7,1,800,1,1,'21F53403'),
/*19*/('Nissan NV 3500 Passenger Van','assets/images/cars/nis-nv.jpg','automatic',1,4,12,1,820,1,1,'41F53304'),
/*20*/('Toyota Innova 2016','assets/images/cars/toyota-innova-2.jpg','automatic',1,4,7,1,800,1,1,'11F63403'),
/*21*/('Ford Transit Passenger','assets/images/cars/ford-trans.jpg','automatic',1,4,15,1,700,1,1,'21F50433'),
/*22*/('Ford Transit Passenger Wagon','assets/images/cars/ford-trans.jpg','automatic',1,4,15,1,800,1,1,'53EF53340'),
/*23*/('Huyndai Aero Space','assets/images/cars/huy-aero.jpg','automatic',1,2,45,1,900,1,1,'21S35403'),
/*24*/('Huyndai County','assets/images/cars/Huy-County.jpg','automatic',1,4,24,1,800,1,1,'23F53503'),
/*25*/('Toyota Coaster','assets/images/cars/toyota-coaster.jpg','automatic',1,4,24,1,700,1,1,'271F43403'),
/*26*/('Huyndai Universe','assets/images/cars/huy-uni.jpg','automatic',1,2,45,1,900,1,1,'11E53503'),
/*27*/('Huyndai Universe GT','assets/images/cars/huy-uni.jpg','automatic',1,2,45,1,900,1,1,'31D53403'),
/*28*/('Ford Transit Passenger Wagon 2017','assets/images/cars/ford-trans.jpg','automatic',1,4,15,1,900,1,1,'23E53403'),
/*29*/('Huyndai Aero Space GT','assets/images/cars/huy-aero.jpg','automatic',1,2,45,1,1000,1,1,'51S13043')

go



/*----------------------------------------Car Booked Data------------------------------------------------------------*/
insert into CarBooked values
---- Pending
(14,11,'10/20/2017','ABC123','10/22/2017','10/28/2017','10/28/2017',4800,0,123456789987,2,1,960,1),
(15,15,'10/24/2017','DAR123','10/25/2017','10/29/2017','10/29/2017',3200,0,0,1,2,640,1),
(16,17,'10/30/2017','CAD456','11/02/2017','11/04/2017','11/04/2017',1200,0,987654321123,2,1,240,1),
---- Approved
(17,12,'10/21/2017','ABC123','10/22/2017','10/28/2017','10/28/2017',4800,0,0,1,1,960,2),
(18,16,'10/20/2017','GHA999','10/21/2017','10/23/2017','10/23/2017',4800,0,234567890984,2,3,960,2),
---- Returned
(18,13,'07/30/2017','ABC123','08/02/2017','08/08/2017','08/08/2017',4800,0,246808642137,2,1,960,3),
(19,18,'06/20/2017','HAM981','06/20/2017','06/24/2017','06/25/2017',6560,500,135790975314,2,2,1312,3),
(20,19,'05/20/2017','GHA999','05/22/2017','05/28/2017','05/29/2017',4800,500,0,1,1,960,3),
---- Cancel
(21,14,'06/20/2017','ABC123','06/22/2017','06/28/2017','06/28/2017',4200,0,0,1,1,840,4),
(21,21,'08/20/2017','HAM981','08/22/2017','08/28/2017','08/28/2017',4200,0,0,1,1,840,4)
go

/*----------------------------------------Tour Booked Data------------------------------------------------------------*/
insert into TourBooked values
----Group Tour - Pending (1)
('TB001', 1, '10-30-2017', 35, 10, 0, 45, 0, 1, 1, 11,'08-01-2017', 1, 'VUNGTAU01', 0),
('TB002', 1, '10-29-2017', 30, 10, 0, 40, 0, 1, 1, 12,'08-02-2017', 1, 'VUNGTAU01', 0),
('TB003', 1, '10-28-2017', 30, 9,0, 39, 0, 1, 1, 13,'08-03-2017', 1, 'CANTHO01', 0),
('TB004', 1, '10-27-2017', 42, 0, 0, 42, 0, 1, 1, 14,'08-04-2017', 1, 'CANTHO01', 1),
('TB005', 1, '10-26-2017', 20, 20, 3, 43, 0,1, 1, 15,'08-05-2017', 1, 'DALAT01', 1),
---Group Tour - Departing (2)
('TB006', 1, '08-28-2017', 30, 10, 0, 40, 0, 1, 2, 16,'08-06-2017', 1, 'DALAT01', 0),
('TB007', 1, '08-28-2017', 32, 10, 0, 42, 0, 1, 2, 17,'08-07-2017', 1, 'PHUQUOC01', 0),
('TB008', 1, '08-28-2017', 31, 10, 0, 41, 0, 1, 2, 18,'08-08-2017', 1, 'PHUQUOC01', 0),
('TB009', 1, '08-28-2017', 25, 18, 0, 43, 0, 1, 2, 19,'08-09-2017', 1,'TIENGIANG01', 0),
('TB010', 1, '08-28-2017', 24, 10, 5, 39, 0, 1, 2,20,'08-10-2017', 1, 'TIENGIANG01', 0),
---Group Tour - Completed (3)
('TB011', 1, '08-19-2017', 40, 0, 0, 40, 0, 1, 3, 21,'08-11-2017', 1, 'VUNGTAU01', 0),
('TB012', 1, '08-18-2017', 39, 0, 0, 39, 0, 1, 3, 22,'08-12-2017', 1, 'VUNGTAU01', 0),
('TB013', 1, '08-18-2017', 40, 0, 0, 40, 0, 1, 3, 23,'08-13-2017', 1, 'DALAT01', 0),
('TB014', 1, '08-27-2017', 42, 0, 0, 42, 0, 1, 3, 24,'08-14-2017', 1, 'DALAT01', 0),
('TB015', 1, '08-16-2017', 40, 0, 0, 40, 0, 1, 3,25,'08-15-2017', 1, 'VUNGTAU01', 0),
---Group Tour - Cancel (4)
('TB016', 1, '08-15-2017', 41, 0, 0, 41, 0, 1, 4, 26,'08-16-2017', 1, 'VUNGTAU01', 0),
('TB017', 1, '09-12-2017', 37, 0, 0, 37, 0, 1, 4, 27,'08-17-2017', 1, 'DALAT01', 0),
('TB018', 1, '09-11-2017', 40, 0, 0, 40, 0, 1, 4, 28,'08-18-2017', 1, 'DALAT01', 0),
('TB019', 1, '09-05-2017', 40, 0, 0, 40, 0, 1, 4, 29,'08-19-2017', 1, 'TIENGIANG01', 0),
('TB020', 1, '10-10-2017', 41, 0, 0, 41, 0, 1, 4, 30,'08-20-2017', 1, 'TIENGIANG01', 0),

----Odd Tour - Pending (1)
('TB021', 0, '10-10-2017', 18, 7, 5, 30, 0, 1, 1, 31,'08-21-2017', 1, 'VUNGTAU01', 1),
('TB022', 0, '10-11-2017', 20, 10, 5, 35, 0, 1, 1, 32,'08-22-2017', 1, 'VUNGTAU01', 1),
('TB023', 0, '10-12-2017', 20, 10, 3, 33, 0, 1, 1, 33,'08-23-2017', 1, 'CANTHO01', 0),
('TB024', 0, '10-13-2017', 30, 0, 0, 30, 0, 1, 1, 34,'08-24-2017', 1, 'CANTHO01', 0),
('TB025', 0, '10-14-2017', 20, 9, 0, 29, 0, 1, 1, 35,'08-25-2017', 1, 'DALAT01', 0),
---Odd Tour - Departing (2)
('TB026', 0, '08-28-2017', 20, 3, 2, 25, 0, 1, 2, 24,'08-26-2017', 1, 'DALAT01', 0), 
('TB027', 0, '08-28-2017', 20, 0, 2, 22, 0, 1, 2, 23,'08-27-2017', 1, 'PHUQUOC01', 0),
('TB028', 0, '08-28-2017', 20, 10, 0, 30, 0, 1, 2, 22,'08-28-2017', 1, 'PHUQUOC01', 0), 
('TB029', 0, '08-28-2017', 30, 3, 0, 33, 0, 1, 2, 21,'08-29-2017', 1, 'TIENGIANG01', 0), 
('TB030', 0, '08-28-2017', 30,1, 0, 31, 0, 1, 2,20,'08-30-2017', 1, 'TIENGIANG01', 0), 
---Odd Tour - Completed (3)
('TB031', 0, '08-19-2017', 40, 0, 0, 40, 0, 1, 3, 19,'09-01-2017', 1, 'VUNGTAU01', 0), 
('TB032', 0, '08-18-2017', 45, 0, 0, 45, 0, 1, 3, 18,'09-02-2017', 1, 'VUNGTAU01', 0), 
('TB033', 0, '08-18-2017', 30, 5, 5, 40, 0, 1, 3, 17,'09-03-2017', 1, 'DALAT01', 0), 
('TB034', 0, '08-27-2017', 42, 0, 0, 42, 0, 1, 3, 16,'09-04-2017', 1, 'DALAT01', 0), 
('TB035', 0, '08-16-2017', 40, 0, 0, 40, 0, 1, 3, 15,'09-05-2017', 1, 'VUNGTAU01', 0), 
---Odd Tour - Cancel (4)
('TB036', 0, '08-15-2017', 21, 0, 0, 21, 0, 1, 4, 26,'09-06-2017', 1, 'VUNGTAU01', 0), 
('TB037', 0, '09-12-2017', 21, 6, 0, 27, 0, 1, 4, 27,'09-07-2017', 1, 'DALAT01', 0), 
('TB038', 0, '09-11-2017', 30, 0, 0, 30, 0, 1, 4, 28,'09-08-2017', 1, 'DALAT01', 0), 
('TB039', 0, '09-05-2017', 15, 8, 5, 28, 0, 1, 4, 29,'09-09-2017', 1, 'TIENGIANG01', 0), 
('TB040', 0, '10-10-2017', 20, 2, 0, 22, 0, 1, 4, 30,'09-10-2017', 1, 'TIENGIANG01', 0) 
go

/*----------------------------------------Tour Booked Sub Data------------------------------------------------------------*/

insert into TourBookedSub values
--------------PENDING (1)
('10-10-2017', 15, 0, 0, 15, 0, 1, 1, 30, '08-11-2017', 'TB036', 'VUNGTAU01', 0),
('10-10-2017',15, 0, 0, 15, 0, 1, 1, 31, '08-12-2017', 'TB036', 'VUNGTAU01', 0),
('10-10-2017',10, 0, 0, 10, 0, 1, 1, 32, '08-12-2017', 'TB036', 'VUNGTAU01', 0),

('10-11-2017',15, 0, 0, 15, 0, 1, 1, 29, '08-22-2017', 'TB022', 'VUNGTAU01', 0),
('10-11-2017',14, 0, 0, 14, 0, 1, 1, 33, '08-23-2017', 'TB022', 'VUNGTAU01', 0),
('10-11-2017',6, 0, 0, 6, 0, 1, 1, 34, '08-23-2017', 'TB022', 'VUNGTAU01', 0),

('10-12-2017',13, 0, 0, 13, 0, 1, 1, 28, '08-26-2017', 'TB023', 'CANTHO01', 1),
('10-12-2017',10, 0, 0, 10, 0, 1, 1, 35, '08-27-2017', 'TB023', 'CANTHO01', 1),
('10-12-2017', 10, 0, 0, 10, 0, 1, 1, 36, '08-28-2017', 'TB023', 'CANTHO01', 1),

('10-13-2017', 10, 0, 0, 10, 0, 1, 1, 26, '08-21-2017', 'TB024', 'CANTHO01', 0),
('10-13-2017', 10, 0, 0, 10, 0, 1, 1, 37, '08-22-2017', 'TB024', 'CANTHO01', 0),
('10-13-2017', 10,0, 0, 10, 0, 1, 1, 38, '08-23-2017', 'TB024', 'CANTHO01', 0),

('10-14-2017', 9, 0, 0, 9, 0, 1, 1, 15, '08-19-2017', 'TB025', 'DALAT01', 0),
('10-14-2017', 12, 0, 0, 12, 0, 1, 1, 39, '08-20-2017', 'TB025', 'DALAT01', 0),
('10-14-2017', 8, 0, 0, 8, 0, 1, 1, 40, '08-21-2017', 'TB025', 'DALAT01', 0),

--------------DEPARTING (2)
('08-28-2017', 6, 0, 0, 6, 0, 1, 2, 24, '08-12-2017', 'TB026', 'DALAT01', 0),
('08-28-2017', 7, 0, 0, 7, 0, 1, 2, 41, '08-13-2017', 'TB026', 'DALAT01', 0),
('08-28-2017', 12, 0, 0, 12, 0, 1, 2, 42, '08-14-2017', 'TB026', 'DALAT01', 0),

('08-28-2017', 12, 0, 0, 12, 0, 1, 2, 23, '08-10-2017', 'TB027', 'PHUQUOC01', 0),
('08-28-2017', 10, 0, 0, 10, 0, 1, 2, 43, '08-11-2017', 'TB027', 'PHUQUOC01', 0),

('08-28-2017', 10, 0, 0, 10, 0, 1, 2, 22, '08-15-2017', 'TB028', 'PHUQUOC01', 0),
('08-28-2017', 10, 0, 0, 10, 0, 1, 2, 44, '08-16-2017', 'TB028', 'PHUQUOC01', 0),
('08-28-2017', 10 ,0, 0, 10, 0, 1, 2, 45, '08-17-2017', 'TB028', 'PHUQUOC01', 0),

('08-28-2017', 13, 0, 0, 13, 0, 1, 2, 21, '08-17-2017', 'TB029', 'TIENGIANG01', 0),
('08-28-2017', 11, 0, 0, 11, 0, 1, 2, 46, '08-18-2017', 'TB029', 'TIENGIANG01', 0),
('08-28-2017', 9, 0, 0, 9, 0, 1, 2, 47, '08-19-2017', 'TB029', 'TIENGIANG01', 0),

('08-28-2017', 11, 0, 0, 11, 0, 1, 2, 20, '08-16-2017','TB030', 'TIENGIANG01', 0),



--------------COMPLETED (3)
('08-19-2017', 17, 0, 0, 17, 0, 1, 3, 19, '08-15-2017', 'TB031', 'VUNGTAU01', 0),
('08-19-2017', 14, 0, 0, 14, 0, 1, 3, 20, '08-16-2017', 'TB031', 'VUNGTAU01', 0),
('08-19-2017', 9, 0, 0, 9, 0, 1, 3, 21, '08-17-2017', 'TB031', 'VUNGTAU01', 0),

('08-18-2017', 12, 0, 0, 12, 0, 1, 3, 18,'08-14-2017', 'TB032', 'VUNGTAU01', 0),
('08-18-2017', 16, 0, 0, 16, 0, 1, 3, 22,'08-15-2017', 'TB032', 'VUNGTAU01', 0),
('08-18-2017', 11, 0, 0, 11, 0, 1, 3, 23,'08-16-2017', 'TB032', 'VUNGTAU01', 0),

('08-18-2017', 15, 0, 0, 15, 0,1, 3, 17, '08-14-2017', 'TB033', 'DALAT01', 0),
('08-18-2017', 10, 0, 0, 10, 0,1, 3, 24, '08-15-2017', 'TB033', 'DALAT01', 0),
('08-18-2017', 15, 0, 0, 15, 0,1, 3, 25, '08-16-2017', 'TB033', 'DALAT01', 0),

('08-27-2017', 12, 0, 0, 12, 0, 1, 3, 16, '08-12-2017', 'TB034', 'DALAT01', 0),
('08-27-2017', 15, 0, 0, 15, 0, 1, 3, 26, '08-14-2017', 'TB034', 'DALAT01', 0),
('08-27-2017', 15, 0, 0, 15, 0, 1, 3, 27, '08-17-2017', 'TB034', 'DALAT01', 0),

('08-16-2017', 15, 0, 0, 15, 0, 1, 3, 15, '08-11-2017', 'TB035', 'VUNGTAU01', 0),
('08-16-2017', 10, 0, 0, 10, 0, 1, 3, 28, '08-12-2017', 'TB035', 'VUNGTAU01', 0),
('08-16-2017', 15, 0, 0, 15, 0, 1, 3, 29, '08-13-2017', 'TB035', 'VUNGTAU01', 0),

--------------CANCEL (4)
('08-15-2017', 11, 0, 0, 11, 0, 1, 4, 26, '08-11-2017', 'TB036', 'VUNGTAU01', 0),
('08-15-2017', 10, 0, 0, 10, 0, 1, 4, 25, '08-12-2017', 'TB036', 'VUNGTAU01', 0),

('09-12-2017', 14, 0, 0, 14, 0, 1, 4, 27, '09-03-2017', 'TB037', 'DALAT01', 0),
('09-12-2017', 13, 0, 0, 13, 0, 1, 4, 29, '09-04-2017', 'TB037', 'DALAT01', 0),

('09-11-2017', 15, 0, 0, 15, 0, 1, 4, 28, '08-30-2017', 'TB038', 'DALAT01', 0),
('09-11-2017', 15, 0, 0, 15, 0, 1, 4, 30, '08-31-2017', 'TB038', 'DALAT01', 0),

('09-05-2017', 18, 0, 0, 18, 0, 1, 4, 29, '08-29-2017', 'TB039', 'TIENGIANG01', 0),
('09-05-2017', 10, 0, 0, 10, 0, 1, 4, 39, '09-01-2017', 'TB039', 'TIENGIANG01', 0),

('10-10-2017', 11, 0, 0, 11, 0, 1, 4, 30, '09-01-2017', 'TB040', 'TIENGIANG01', 0),
('10-10-2017', 11, 0, 0, 11, 0, 1, 4, 17, '09-02-2017', 'TB040', 'TIENGIANG01', 0)
go

/*----------------------------------------Promotion Data------------------------------------------------------------*/
insert into Promotion values
/*1*/('ABC123','12/14/2017','12/29/2017',1),
/*2*/('DAR123','04/27/2017','07/29/2017',2),
/*3*/('CAD456','04/14/2017','04/29/2017',2),
/*4*/('GHA999','12/14/2017','12/29/2017',1),
/*5*/('HAM981','12/14/2017','12/29/2017',1)
go
/*----------------------------------------Review Data------------------------------------------------------------*/
insert into Review values
(1,1,'DALAT01', '07/13/2017'),
(2,2,'DALAT01', '12/13/2013'),
(3,3,'DALAT01', '07/13/2015'),
(4,4,'DALAT01', '01/27/2016'),
(5,5,'DALAT01', '02/25/2016')
go
/*----------------------------------------Review Detail Data------------------------------------------------------------*/


insert into ReviewDetail values
(N'Nothing',2,1,1,'DALAT01'), 
(N'Nothing',4,2,2,'DALAT01'), 
(N'Nothing',2,1,3,'DALAT01'), 
(N'Nothing',5,1,4,'DALAT01'), 
(N'Nothing',2,1,5,'DALAT01')
go 


/*========================================Comment Data==========================================================================*/

insert into Comment values
(N'Very good',1,1,'DALAT01','09-01-2017'), 
(N'Interesting tour',4,2,'DALAT01','09-02-2017'), 
(N'Need more tour',2,1,'DALAT01','09-03-2017'), 
(N'Great tour',5,1,'DALAT01','09-04-2017'), 
(N'Fanstatic time',2,1,'DALAT01','09-05-2017')
go 

/*==========================================================================================================================================*/


/*  Customer ----> Role */
ALTER TABLE [dbo].[CustomerUser]  WITH CHECK ADD  CONSTRAINT [FK_CustomerUser_Role] FOREIGN KEY([RoleID])
REFERENCES [dbo].[Role] ([RoleID])
GO
ALTER TABLE [dbo].[CustomerUser] CHECK CONSTRAINT [FK_CustomerUser_Role]
GO

/*  Customer List ----> Customer */
ALTER TABLE [dbo].[CustomerList]  WITH CHECK ADD  CONSTRAINT [FK_CustomerList_CustomerUser] FOREIGN KEY([CustomerID])
REFERENCES [dbo].[CustomerUser] ([CustomerID])
GO
ALTER TABLE [dbo].[CustomerList] CHECK CONSTRAINT [FK_CustomerList_CustomerUser]
GO

/*  Customer List ----> TorBooked */
ALTER TABLE [dbo].[CustomerList]  WITH CHECK ADD  CONSTRAINT [FK_CustomerList_TourBooked] FOREIGN KEY([TourBookedID])
REFERENCES [dbo].[TourBooked] ([TourBookedID])
GO
ALTER TABLE [dbo].[CustomerList] CHECK CONSTRAINT [FK_CustomerList_TourBooked]
GO

/*  Review ----> Customer */
ALTER TABLE [dbo].[Review]  WITH CHECK ADD  CONSTRAINT [FK_Review_CustomerUser] FOREIGN KEY([CustomerID])
REFERENCES [dbo].[CustomerUser] ([CustomerID])
GO
ALTER TABLE [dbo].[Review] CHECK CONSTRAINT [FK_Review_CustomerUser]
GO

/*  Review ----> Car */
ALTER TABLE [dbo].[Review]  WITH CHECK ADD  CONSTRAINT [FK_Review_Car] FOREIGN KEY([CarID])
REFERENCES [dbo].Car ([CarID])
GO
ALTER TABLE [dbo].[Review] CHECK CONSTRAINT [FK_Review_Car]
GO

/*  Review ----> Tours */
ALTER TABLE [dbo].[Review]  WITH CHECK ADD  CONSTRAINT [FK_Review_Tours] FOREIGN KEY([TourID])
REFERENCES [dbo].Tours ([TourID])
GO
ALTER TABLE [dbo].[Review] CHECK CONSTRAINT [FK_Review_Car]
GO

/*  Review Detail ----> Car */
ALTER TABLE [dbo].[ReviewDetail]  WITH CHECK ADD  CONSTRAINT [FK_ReviewDetail_Car] FOREIGN KEY([CarID])
REFERENCES [dbo].[Car] ([CarID])
GO
ALTER TABLE [dbo].[ReviewDetail] CHECK CONSTRAINT [FK_ReviewDetail_Car]
GO

/*  Review Detail ----> Review */
ALTER TABLE [dbo].[ReviewDetail]  WITH CHECK ADD  CONSTRAINT [FK_ReviewDetail_Review] FOREIGN KEY([ReviewID])
REFERENCES [dbo].[Review] ([ReviewID])
GO
ALTER TABLE [dbo].[ReviewDetail] CHECK CONSTRAINT [FK_ReviewDetail_Review]
GO

/*****/

/********************Comment ------>Customer */
ALTER TABLE [dbo].[Comment]  WITH CHECK ADD  CONSTRAINT [FK_Comment_CustomerUser] FOREIGN KEY([CustomerID])
REFERENCES [dbo].[CustomerUser] ([CustomerID])
GO
ALTER TABLE [dbo].[Comment] CHECK CONSTRAINT [FK_Comment_CustomerUser]
GO


/********************Comment ------>Car  */
ALTER TABLE [dbo].[Comment]  WITH CHECK ADD  CONSTRAINT [FK_Comment_Car] FOREIGN KEY([CarID])
REFERENCES [dbo].[Car] ([CarID])
GO
ALTER TABLE [dbo].[Comment] CHECK CONSTRAINT [FK_Comment_Car]
GO

/********************Comment ------>Tour */

ALTER TABLE [dbo].[Comment]  WITH CHECK ADD  CONSTRAINT [FK_Comment_Tours] FOREIGN KEY([TourID])
REFERENCES [dbo].[Tours] ([TourID])
GO
ALTER TABLE [dbo].[Comment] CHECK CONSTRAINT [FK_Comment_Tours]
GO

/*  Car Booked ----> Customer */
ALTER TABLE [dbo].[CarBooked]  WITH CHECK ADD  CONSTRAINT [FK_CarBooked_CustomerUser] FOREIGN KEY([CustomerID])
REFERENCES [dbo].[CustomerUser] ([CustomerID])
GO
ALTER TABLE [dbo].[CarBooked] CHECK CONSTRAINT [FK_CarBooked_CustomerUser]
GO



/*****/

/*****/
/*  Car Booked----> Car */
ALTER TABLE [dbo].[CarBooked]  WITH CHECK ADD  CONSTRAINT [FK_CarBooked_Car] FOREIGN KEY([CarID])
REFERENCES [dbo].[Car] ([CarID])
GO
ALTER TABLE [dbo].[CarBooked] CHECK CONSTRAINT [FK_CarBooked_Car]
GO


/*****/
/*  Tour Booked ----> Promotion */
ALTER TABLE [dbo].[TourBooked]  WITH CHECK ADD  CONSTRAINT [FK_TourBooked_Promotion] FOREIGN KEY([PromotionID])
REFERENCES [dbo].[Promotion] ([PromotionID])
GO
ALTER TABLE [dbo].[TourBooked] CHECK CONSTRAINT [FK_TourBooked_Promotion]
GO

/*  Review Detail ----> Tour */
ALTER TABLE [dbo].[ReviewDetail]  WITH CHECK ADD  CONSTRAINT [FK_ReviewDetail_Tours] FOREIGN KEY([TourID])
REFERENCES [dbo].[Tours] ([TourID])
GO
ALTER TABLE [dbo].[ReviewDetail] CHECK CONSTRAINT [FK_ReviewDetail_Tours]
GO

/*  Schedule ----> Tour */
ALTER TABLE [dbo].[Schedule]  WITH CHECK ADD  CONSTRAINT [FK_Schedule_Tours] FOREIGN KEY([TourID])
REFERENCES [dbo].[Tours] ([TourID])
GO
ALTER TABLE [dbo].[Schedule] CHECK CONSTRAINT [FK_Schedule_Tours]
GO

/*  Tour Booked ----> Tour */
ALTER TABLE [dbo].[TourBooked]  WITH CHECK ADD  CONSTRAINT [FK_TourBooked_Tours] FOREIGN KEY([TourID])
REFERENCES [dbo].[Tours] ([TourID])
GO
ALTER TABLE [dbo].[TourBooked] CHECK CONSTRAINT [FK_TourBooked_Tours]
GO

/*  Tour Booked ----> Customer */
ALTER TABLE [dbo].[TourBooked]  WITH CHECK ADD  CONSTRAINT [FK_TourBooked_CustomerUser] FOREIGN KEY([CustomerID])
REFERENCES [dbo].[CustomerUser] ([CustomerID])
GO
ALTER TABLE [dbo].[TourBooked] CHECK CONSTRAINT [FK_TourBooked_CustomerUser]
GO
/*****/

/*  Tour Booked Sub----> Customer */
ALTER TABLE [dbo].[TourBookedSub]  WITH CHECK ADD  CONSTRAINT [FK_TourBookedSub_Tours] FOREIGN KEY([TourID])
REFERENCES [dbo].[Tours] ([TourID])
GO
ALTER TABLE [dbo].[TourBookedSub] CHECK CONSTRAINT [FK_TourBookedSub_Tours]
GO

/****/
/*  Tour Booked Sub----> Tour Booked */
ALTER TABLE [dbo].[TourBookedSub]  WITH CHECK ADD  CONSTRAINT [FK_TourBookedSub_TourBooked] FOREIGN KEY([TourBookedID])
REFERENCES [dbo].[TourBooked] ([TourBookedID])
GO
ALTER TABLE [dbo].[TourBookedSub] CHECK CONSTRAINT [FK_TourBookedSub_TourBooked]
GO

/****/
/*  Tour Booked Sub----> Customer*/
ALTER TABLE [dbo].[TourBookedSub]  WITH CHECK ADD  CONSTRAINT [FK_TourBookedSub_CustomerUser] FOREIGN KEY([CustomerID])
REFERENCES [dbo].[CustomerUser] ([CustomerID])
GO
ALTER TABLE [dbo].[TourBookedSub] CHECK CONSTRAINT [FK_TourBookedSub_CustomerUser]
GO

/*  Tour ---> Tour Category */
ALTER TABLE [dbo].[Tours]  WITH CHECK ADD  CONSTRAINT [FK_Tours_TourCategory] FOREIGN KEY([TourCategoryID])
REFERENCES [dbo].[TourCategory] ([TourCategoryID])
GO
ALTER TABLE [dbo].[Tours] CHECK CONSTRAINT [FK_Tours_TourCategory]
GO

