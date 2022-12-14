USE [ICY]
GO
/****** Object:  Table [dbo].[ChiTietHoaDon]    Script Date: 10/7/2022 10:07:50 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHoaDon](
	[MaHD] [nvarchar](max) NULL,
	[MaSP] [nvarchar](max) NULL,
	[TenSP] [nvarchar](max) NULL,
	[SoLuong] [nvarchar](max) NULL,
	[GiaBan] [nvarchar](max) NULL,
	[ThanhTien] [nvarchar](max) NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietPhieuNhap]    Script Date: 10/7/2022 10:07:51 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietPhieuNhap](
	[MaPN] [nvarchar](max) NULL,
	[MaSP] [nvarchar](max) NULL,
	[TenSP] [nvarchar](max) NULL,
	[SoLuong] [nvarchar](max) NULL,
	[DonGia] [nvarchar](max) NULL,
	[ThanhTien] [nvarchar](max) NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CTKhuyenMai]    Script Date: 10/7/2022 10:07:51 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CTKhuyenMai](
	[MACT] [nvarchar](50) NULL,
	[MAKM] [nvarchar](50) NULL,
	[MASP] [nvarchar](max) NULL,
	[NOIDUNG] [nvarchar](max) NULL,
	[NOIDUNGCT] [nvarchar](max) NULL,
	[GIAMGIA] [nvarchar](max) NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 10/7/2022 10:07:51 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[MaHD] [nvarchar](max) NULL,
	[TenKH] [nvarchar](max) NULL,
	[TenNV] [nvarchar](max) NULL,
	[NgayLap] [nvarchar](max) NULL,
	[TongTien] [nvarchar](max) NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 10/7/2022 10:07:51 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[MAKH] [nvarchar](50) NULL,
	[HoLot] [nvarchar](50) NULL,
	[Ten] [nvarchar](50) NULL,
	[SoDienThoai] [nvarchar](50) NULL,
	[SoNha] [nvarchar](max) NULL,
	[Duong] [nvarchar](max) NULL,
	[Phuong] [nvarchar](max) NULL,
	[Quan] [nvarchar](max) NULL,
	[ThanhPho] [nvarchar](max) NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhuyenMai]    Script Date: 10/7/2022 10:07:51 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhuyenMai](
	[MAKM] [nvarchar](max) NULL,
	[TEN] [nvarchar](max) NULL,
	[NGAYBD] [nvarchar](max) NULL,
	[THANGBD] [nvarchar](max) NULL,
	[NAMBD] [nvarchar](max) NULL,
	[NGAYKT] [nvarchar](max) NULL,
	[THANGKT] [nvarchar](max) NULL,
	[NAMKT] [nvarchar](max) NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LoaiSanPham]    Script Date: 10/7/2022 10:07:51 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiSanPham](
	[MaLoai] [nvarchar](max) NULL,
	[TenLoai] [nvarchar](max) NULL,
	[ThanhPhan] [nvarchar](max) NULL,
	[CongDung] [nvarchar](max) NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Luong]    Script Date: 10/7/2022 10:07:51 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Luong](
	[MaNV] [nvarchar](max) NULL,
	[LuongCB] [nvarchar](max) NULL,
	[PhuCapAnUong] [nvarchar](max) NULL,
	[PhuCapXangXe] [nvarchar](max) NULL,
	[PhuCapDienThoai] [nvarchar](max) NULL,
	[Thuong] [nvarchar](max) NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NguoiDung]    Script Date: 10/7/2022 10:07:51 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NguoiDung](
	[Ma] [nvarchar](max) NULL,
	[TaiKhoan] [nvarchar](max) NULL,
	[MatKhau] [nvarchar](max) NULL,
	[ChucVu] [nvarchar](max) NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhaCungCap]    Script Date: 10/7/2022 10:07:51 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhaCungCap](
	[MaNCC] [nvarchar](max) NULL,
	[TenNCC] [nvarchar](max) NULL,
	[DiaChi] [nvarchar](max) NULL,
	[SDT] [nvarchar](max) NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NVIEN1]    Script Date: 10/7/2022 10:07:51 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NVIEN1](
	[Ma] [nvarchar](max) NULL,
	[Ho] [nvarchar](max) NULL,
	[Ten] [nvarchar](max) NULL,
	[GioiTinh] [nvarchar](max) NULL,
	[ChucVu] [nvarchar](max) NULL,
	[NgaySinh] [nvarchar](max) NULL,
	[ThangSinh] [nvarchar](max) NULL,
	[NamSinh] [nvarchar](max) NULL,
	[DiaChi] [nvarchar](max) NULL,
	[SDT] [nvarchar](max) NULL,
	[Email] [nvarchar](max) NULL,
	[Luong] [nvarchar](max) NULL,
	[Anh] [nvarchar](max) NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhieuNhap]    Script Date: 10/7/2022 10:07:51 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuNhap](
	[MaPN] [nvarchar](max) NULL,
	[MaNCC] [nvarchar](max) NULL,
	[MaNV] [nvarchar](max) NULL,
	[NgayLap] [nvarchar](max) NULL,
	[TongTien] [nvarchar](max) NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 10/7/2022 10:07:51 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[MaSP] [nvarchar](50) NULL,
	[TenSP] [nvarchar](50) NULL,
	[LoaiSP] [nvarchar](50) NULL,
	[GiaBan] [nvarchar](50) NULL,
	[SoLuong] [nvarchar](50) NULL,
	[DonViTinh] [nvarchar](50) NULL,
	[HinhAnh] [nvarchar](150) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ThamSoChung]    Script Date: 10/7/2022 10:07:51 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ThamSoChung](
	[TenKhoHang] [nvarchar](max) NULL,
	[TenPhieuNhap] [nvarchar](max) NULL,
	[ThongTinSanPham] [nvarchar](max) NULL,
	[ThongTinPhieuNhap] [nvarchar](max) NULL,
	[Ma] [nvarchar](max) NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
INSERT [dbo].[CTKhuyenMai] ([MACT], [MAKM], [MASP], [NOIDUNG], [NOIDUNGCT], [GIAMGIA]) VALUES (N'CT1', N'KM1', N'SP1', N'SIÊU PHẨM SALE UPTO 83% - ĐẠI TIỆC MUA 1 TẶNG 1 - ĐỒNG GIÁ CHỈ #1K', N'Chúc mừng ngày Quốc tế phụ nữ 08.03, với mong muốn một nửa thế giới luôn hạnh phúc, tự tin và xinh đẹp. Sammi mang đến cho bạn chương trình ưu đãi cực khủng.

👉 Đại tiệc SALE UPTO 83% với sự góp mặt của nhiều thương hiệu đình đám như: Skin1004, Some By Mi, Dear Klairs, Maybelline, BBIA, L’Oréal, By Wishtrend, Nacific, I’m From, Cetaphil, Fox,....

👉 Ngày hội MUA 1 TẶNG 1 từ các thương hiệu makeup cùng skincare cực đỉnh như Lemonade, Silky Girl, Cocoon, Bio Essence,...

👉 Hòa mình vào cơn mưa ĐỒNG GIÁ CHỈ #1K với TOP mặt nạ dưỡng da, bông tẩy trang, giấy thấm dầu,.....', N'83')
INSERT [dbo].[CTKhuyenMai] ([MACT], [MAKM], [MASP], [NOIDUNG], [NOIDUNGCT], [GIAMGIA]) VALUES (N'CT2', N'KM2', N'SP7', N'Mua 1 tặng 1', N'Đến ngay ICY vào thứ 4 để được hưởng ưu đãi duy nhất, đặc biệt Mua 1 tặng 1:

- Mua 1 sản phẩm tặng 1 sản phẩm tương tự

------------  

Điều kiện áp dụng:

- Chương trình áp dụng vào thứ 4 hàng tuần tại tất cả các cửa hàng ICY.

- Chỉ áp dụng cho đơn hàng dưới 100,000đ.

- Không áp dụng vào Lễ Tết', N'1-1')
INSERT [dbo].[CTKhuyenMai] ([MACT], [MAKM], [MASP], [NOIDUNG], [NOIDUNGCT], [GIAMGIA]) VALUES (N'CT3', N'KM2', N'SP4', N'Mua 1 tặng 1', N'Đến ngay ICY vào thứ 4 để được hưởng ưu đãi duy nhất, đặc biệt Mua 1 tặng 1:

- Mua 1 sản phẩm tặng 1 sản phẩm tương tự

------------  

Điều kiện áp dụng:

- Chương trình áp dụng vào thứ 4 hàng tuần tại tất cả các cửa hàng ICY.

- Chỉ áp dụng cho đơn hàng dưới 100,000đ.

- Không áp dụng vào Lễ Tết', N'1-1')
INSERT [dbo].[CTKhuyenMai] ([MACT], [MAKM], [MASP], [NOIDUNG], [NOIDUNGCT], [GIAMGIA]) VALUES (N'CT4', N'KM3', N'SP5', N'GIẢM 40% KHI ORDER QUA APP/WEBSITE ICY', N'Điều kiện áp dụng:
-          Không áp dụng cho đơn hàng trên 500.000đ

-          Không áp dụng với các khuyến mãi khác.

-          Mã giảm 40% áp dụng mỗi tuần 1 lần cho mỗi khách hàng.

----------------', N'40')
INSERT [dbo].[CTKhuyenMai] ([MACT], [MAKM], [MASP], [NOIDUNG], [NOIDUNGCT], [GIAMGIA]) VALUES (N'CT5', N'KM3', N'SP6', N'GIẢM 40% KHI ORDER QUA APP/WEBSITE ICY', N'Điều kiện áp dụng:
-          Không áp dụng cho đơn hàng trên 500.000đ

-          Không áp dụng với các khuyến mãi khác.

-          Mã giảm 40% áp dụng mỗi tuần 1 lần cho mỗi khách hàng.

----------------', N'40')
INSERT [dbo].[CTKhuyenMai] ([MACT], [MAKM], [MASP], [NOIDUNG], [NOIDUNGCT], [GIAMGIA]) VALUES (N'CT6', N'KM4', N'SP11', N'SALE UPTO 75% - ĐỒNG GIÁ #9K #19K #29K #79K #99K - MUA 1 TẶNG 1', N'Mùa hè đã đến, hãy trở nên xinh đẹp và rạng ngời hơn với loạt HOT DEAL giá giảm sâu chỉ có tại SammiShop:

👉 SALE cực SHOCK lên đến 75% đến từ các thương hiệu hàng đầu như: Dear Klairs, Skin1004, Some By Mi, By Wishtrend, Cosrx, Dr.G, 9 Wishes, JM Solution, Maybelline, L’Oréal, Cetaphil, Axis-Y, Dr.G, Lemonade, MAC,….

👉 Bão DEAL MUA 1 TẶNG 1 cùng loạt skincare như kem chống nắng, sữa rửa mặt, nước hoa hồng, tinh chất, tẩy tế bào chết... và các ITEM MAKEUP như bảng mắt, chì kẻ mày, chuốt mi, kẻ mắt với những thThis is some textỏi son “trendy” của năm.

👉 Mua sắm thả ga với đại tiệc đồng giá 9K - 19K - 29K - 79K - 99K (áp dụng hóa đơn từ 199K).

👉 Ngoài ra, với mỗi hóa đơn có một số sản phẩm nhất định bạn còn được tặng ngay chì kẻ mày Horus trị giá #66K.

👉 Săn hàng chính hãng giá tốt ngay tại SammiShop! Chốt đơn nhanh, nhận quà liền tay nha các tín đồ làm đẹp ơi!', N'75')
INSERT [dbo].[CTKhuyenMai] ([MACT], [MAKM], [MASP], [NOIDUNG], [NOIDUNGCT], [GIAMGIA]) VALUES (N'CT7', N'KM4', N'SP17', N'SALE UPTO 75% - ĐỒNG GIÁ #9K #19K #29K #79K #99K - MUA 1 TẶNG 1', N'Mùa hè đã đến, hãy trở nên xinh đẹp và rạng ngời hơn với loạt HOT DEAL giá giảm sâu chỉ có tại SammiShop:

👉 SALE cực SHOCK lên đến 75% đến từ các thương hiệu hàng đầu như: Dear Klairs, Skin1004, Some By Mi, By Wishtrend, Cosrx, Dr.G, 9 Wishes, JM Solution, Maybelline, L’Oréal, Cetaphil, Axis-Y, Dr.G, Lemonade, MAC,….

👉 Bão DEAL MUA 1 TẶNG 1 cùng loạt skincare như kem chống nắng, sữa rửa mặt, nước hoa hồng, tinh chất, tẩy tế bào chết... và các ITEM MAKEUP như bảng mắt, chì kẻ mày, chuốt mi, kẻ mắt với những thThis is some textỏi son “trendy” của năm.

👉 Mua sắm thả ga với đại tiệc đồng giá 9K - 19K - 29K - 79K - 99K (áp dụng hóa đơn từ 199K).

👉 Ngoài ra, với mỗi hóa đơn có một số sản phẩm nhất định bạn còn được tặng ngay chì kẻ mày Horus trị giá #66K.

👉 Săn hàng chính hãng giá tốt ngay tại SammiShop! Chốt đơn nhanh, nhận quà liền tay nha các tín đồ làm đẹp ơi!', N'75')
INSERT [dbo].[CTKhuyenMai] ([MACT], [MAKM], [MASP], [NOIDUNG], [NOIDUNGCT], [GIAMGIA]) VALUES (N'CT8', N'KM4', N'SP20', N'SALE UPTO 75% - ĐỒNG GIÁ #9K #19K #29K #79K #99K - MUA 1 TẶNG 1', N'Mùa hè đã đến, hãy trở nên xinh đẹp và rạng ngời hơn với loạt HOT DEAL giá giảm sâu chỉ có tại SammiShop:

👉 SALE cực SHOCK lên đến 75% đến từ các thương hiệu hàng đầu như: Dear Klairs, Skin1004, Some By Mi, By Wishtrend, Cosrx, Dr.G, 9 Wishes, JM Solution, Maybelline, L’Oréal, Cetaphil, Axis-Y, Dr.G, Lemonade, MAC,….

👉 Bão DEAL MUA 1 TẶNG 1 cùng loạt skincare như kem chống nắng, sữa rửa mặt, nước hoa hồng, tinh chất, tẩy tế bào chết... và các ITEM MAKEUP như bảng mắt, chì kẻ mày, chuốt mi, kẻ mắt với những thThis is some textỏi son “trendy” của năm.

👉 Mua sắm thả ga với đại tiệc đồng giá 9K - 19K - 29K - 79K - 99K (áp dụng hóa đơn từ 199K).

👉 Ngoài ra, với mỗi hóa đơn có một số sản phẩm nhất định bạn còn được tặng ngay chì kẻ mày Horus trị giá #66K.

👉 Săn hàng chính hãng giá tốt ngay tại SammiShop! Chốt đơn nhanh, nhận quà liền tay nha các tín đồ làm đẹp ơi!', N'75')
GO
INSERT [dbo].[KhachHang] ([MAKH], [HoLot], [Ten], [SoDienThoai], [SoNha], [Duong], [Phuong], [Quan], [ThanhPho]) VALUES (N'KH1', N'Trần Thị Hạ', N'Long', N'0124567889', N'487/9', N'Kênh Tân Hóa', N'Hòa Thạnh', N'Tân Phú', N'Thành phố Hồ Chí Minh')
INSERT [dbo].[KhachHang] ([MAKH], [HoLot], [Ten], [SoDienThoai], [SoNha], [Duong], [Phuong], [Quan], [ThanhPho]) VALUES (N'KH2', N'Đặng Thị Mỹ', N'Ly', N'0123456789', N'123A', N'11B', N'Phú Trung', N'Bình Thạnh', N'Thành phố Hồ Chí Minh')
INSERT [dbo].[KhachHang] ([MAKH], [HoLot], [Ten], [SoDienThoai], [SoNha], [Duong], [Phuong], [Quan], [ThanhPho]) VALUES (N'KH3', N'Trần', N'Long', N'0914725836', N'1A', N'Vĩnh Lộc', N'Tây Thạnh', N'Bình Thạnh', N'Thành phố Hà Nội')
INSERT [dbo].[KhachHang] ([MAKH], [HoLot], [Ten], [SoDienThoai], [SoNha], [Duong], [Phuong], [Quan], [ThanhPho]) VALUES (N'KH4', N'Nguyễn Thu', N'Hà', N'0245789361', N'95', N'Nguyễn Thị Minh Khai', N'2', N'2', N'Thành phố Hồ Chí Minh')
INSERT [dbo].[KhachHang] ([MAKH], [HoLot], [Ten], [SoDienThoai], [SoNha], [Duong], [Phuong], [Quan], [ThanhPho]) VALUES (N'KH5', N'Phan Văn', N'Hoàn', N'023456719', N'18B', N'Hoàng Sa', N'Trí Trung', N'2', N'Thành phố Hồ Chí Minh')
INSERT [dbo].[KhachHang] ([MAKH], [HoLot], [Ten], [SoDienThoai], [SoNha], [Duong], [Phuong], [Quan], [ThanhPho]) VALUES (N'KH6', N'Nguyễn Văn', N'Xoài', N'0245678931', N'123/7/8A', N'Nguyễn Văn Cừ', N'6', N'5', N'Thành phố Hồ Chí Minh')
INSERT [dbo].[KhachHang] ([MAKH], [HoLot], [Ten], [SoDienThoai], [SoNha], [Duong], [Phuong], [Quan], [ThanhPho]) VALUES (N'KH7', N'Nguyễn Thị', N'Cóc', N'0111223344', N'1A', N'Trần Phú', N'Tây Thạnh', N'5', N'Thành phố Hồ Chí Minh')
INSERT [dbo].[KhachHang] ([MAKH], [HoLot], [Ten], [SoDienThoai], [SoNha], [Duong], [Phuong], [Quan], [ThanhPho]) VALUES (N'KH8', N'Nguyễn Quang', N'Ổi', N'0023456789', N'1b', N'Hòa Bình', N'Phú Trung', N'Tân Phú', N'Hà Nội')
INSERT [dbo].[KhachHang] ([MAKH], [HoLot], [Ten], [SoDienThoai], [SoNha], [Duong], [Phuong], [Quan], [ThanhPho]) VALUES (N'KH9', N'Tạ Quang', N'Bửu', N'0123456123', N'15D', N'Cộng Hòa', N'1', N'1', N'TNghệ An')
INSERT [dbo].[KhachHang] ([MAKH], [HoLot], [Ten], [SoDienThoai], [SoNha], [Duong], [Phuong], [Quan], [ThanhPho]) VALUES (N'KH10', N'Nguyễn Văn', N'A', N'0213456789', N'24/7/9A', N'An Dương Vương', N'5', N'5', N'Thành phố Hồ Chí Minh')
INSERT [dbo].[KhachHang] ([MAKH], [HoLot], [Ten], [SoDienThoai], [SoNha], [Duong], [Phuong], [Quan], [ThanhPho]) VALUES (N'KH11', N'Nguyễn Thị', N'B', N'0456789123', N'24/8/19/5', N'Nguyễn Văn Cừ', N'5', N'5', N'Thành phố Hồ Chí Minh')
INSERT [dbo].[KhachHang] ([MAKH], [HoLot], [Ten], [SoDienThoai], [SoNha], [Duong], [Phuong], [Quan], [ThanhPho]) VALUES (N'KH12', N'Hồ Quang', N'Đạt', N'0123110023', N'25/8/7/111', N'Hòa Lò', N'3', N'12', N'Hà Nội')
INSERT [dbo].[KhachHang] ([MAKH], [HoLot], [Ten], [SoDienThoai], [SoNha], [Duong], [Phuong], [Quan], [ThanhPho]) VALUES (N'KH13', N'Nguyễn Yến', N'Nhi', N'0145678912', N'12A', N'Bình Minh', N'7', N'8', N'Nghệ An')
INSERT [dbo].[KhachHang] ([MAKH], [HoLot], [Ten], [SoDienThoai], [SoNha], [Duong], [Phuong], [Quan], [ThanhPho]) VALUES (N'KH14', N'Phan Diễm', N'Quỳnh', N'0234567144', N'22/4/7', N'Hội An', N'4', N'1', N'Hà Nội')
INSERT [dbo].[KhachHang] ([MAKH], [HoLot], [Ten], [SoDienThoai], [SoNha], [Duong], [Phuong], [Quan], [ThanhPho]) VALUES (N'KH15', N'Hồ Quỳnh', N'Hương', N'0231456741', N'15A', N'Hòa Bình', N'5', N'3', N'Thành phố Hồ Chí Minh')
INSERT [dbo].[KhachHang] ([MAKH], [HoLot], [Ten], [SoDienThoai], [SoNha], [Duong], [Phuong], [Quan], [ThanhPho]) VALUES (N'KH16', N'Mai Hồng', N'Ngọc', N'0741256894', N'23/7/88', N'Trường Sa', N'2', N'Gò Vấp', N'Thành phố Hồ Chí Minh')
INSERT [dbo].[KhachHang] ([MAKH], [HoLot], [Ten], [SoDienThoai], [SoNha], [Duong], [Phuong], [Quan], [ThanhPho]) VALUES (N'KH17', N'Nguyễn Thị', N'Mận', N'0456789417', N'12A', N'Cộng Hòa', N'1', N'Tân Bình', N'Thành phố Hồ Chí Minh')
INSERT [dbo].[KhachHang] ([MAKH], [HoLot], [Ten], [SoDienThoai], [SoNha], [Duong], [Phuong], [Quan], [ThanhPho]) VALUES (N'KH18', N'Nguyễn Ngọc', N'Sáng', N'04123567894', N'4/7/1/2', N'QL1A', N'Tây Thạnh', N'Tân Phú', N'Thành phố Hồ Chí Minh')
INSERT [dbo].[KhachHang] ([MAKH], [HoLot], [Ten], [SoDienThoai], [SoNha], [Duong], [Phuong], [Quan], [ThanhPho]) VALUES (N'KH19', N'Nguyễn Ngọc', N'Giàu', N'0987456123', N'2/1/2', N'Nguyễn Trãi', N'5', N'5', N'Thành phố Hồ Chí Minh')
INSERT [dbo].[KhachHang] ([MAKH], [HoLot], [Ten], [SoDienThoai], [SoNha], [Duong], [Phuong], [Quan], [ThanhPho]) VALUES (N'KH20', N'Hồ văn', N'Sáng', N'0714235689', N'25A', N'Nguyễn Bỉnh Khiêm', N'1', N'1', N'Thành phố Hồ Chí Minh')
GO
INSERT [dbo].[KhuyenMai] ([MAKM], [TEN], [NGAYBD], [THANGBD], [NAMBD], [NGAYKT], [THANGKT], [NAMKT]) VALUES (N'KM1', N'HAPPY WOMENS DAY 08.03', N'03', N'03', N'2022', N'13', N'03', N'2022')
INSERT [dbo].[KhuyenMai] ([MAKM], [TEN], [NGAYBD], [THANGBD], [NAMBD], [NGAYKT], [THANGKT], [NAMKT]) VALUES (N'KM2', N'THỨ 2 MUA 1 TẶNG 1', N'09', N'04', N'2022', N'09', N'05', N'2022')
INSERT [dbo].[KhuyenMai] ([MAKM], [TEN], [NGAYBD], [THANGBD], [NAMBD], [NGAYKT], [THANGKT], [NAMKT]) VALUES (N'KM3', N'ƯU ĐÃI 40%', N'13', N'08', N'2022', N'13', N'09', N'2022')
INSERT [dbo].[KhuyenMai] ([MAKM], [TEN], [NGAYBD], [THANGBD], [NAMBD], [NGAYKT], [THANGKT], [NAMKT]) VALUES (N'KM4', N'CHÀO HÈ NĂNG ĐỘNG', N'17', N'03', N'2022', N'31', N'03', N'2022')
GO
INSERT [dbo].[LoaiSanPham] ([MaLoai], [TenLoai], [ThanhPhan], [CongDung]) VALUES (N'CSD', N'Chăm sóc da', N'Ceramides, Dimethicone, Retinoids, Kojic Acid, Hyaluronic Acid, Salicylic Acid, Vitamin C, Benzoyl Peroxide.', N'Không chỉ đơn thuần giữ vai trò làm đẹp mà còn giúp làn da sinh màng bảo vệ chống lại quá trình ô xy hóa sản sinh mụn, tăng sức đề kháng cho làn da trước các tác động môi trường, hỗ trợ quá trình chống ô xy hóa')
INSERT [dbo].[LoaiSanPham] ([MaLoai], [TenLoai], [ThanhPhan], [CongDung]) VALUES (N'MPCN', N'Mỹ phẩm chức năng', N'Hyaluronic Acid (HA), Vitamin A (Retinol), Vitamin B (Niacinamide), Vitamin C, Salicylic Acid (BHA), Glycolic Acid, Lactic Acid (AHA), Coenzyme Q10, Matrixyl 3000.', N'Ngoài có chức năng nuôi dưỡng, chăm sóc da như mĩ phẩm bình thường thì mĩ phẩm chức năng còn giúpđiều trị; hỗ trợ điều trị các bệnh lý về da: vẩy nến, chàm, mụn, nám. Xử lý các vấn đề như mụn, viêm da cơ địa, nám, lão hoá , chàm,  di ứng vô cùng hiệu quả.')
INSERT [dbo].[LoaiSanPham] ([MaLoai], [TenLoai], [ThanhPhan], [CongDung]) VALUES (N'CN', N'Chống nắng', N'Tinosorb S và M, Mexoryl SX, Oxybenzone, Avobenzone, Titanium dioxide, Kẽm oxit, PABA và propamine salicylate PABA', N'Giúp bạn ngăn ngừa sạm nám và quá trình lão hóa da sớm, duy trì độ ẩm cho da, và nhất là giảm nguy cơ ung thư da')
INSERT [dbo].[LoaiSanPham] ([MaLoai], [TenLoai], [ThanhPhan], [CongDung]) VALUES (N'LSD', N'Làm sạch da', N'ALOE VERA, ARGAN OIL, BETA-HYDROXY ACID (BHA), CAFFEINE, COENZYME Q10 (COQ10) ,EMOLLIENT.', N'Giúp loại bỏ đi bụi bẩn, vi khuẩn, làm sạch sâu cho da, tạo sự thoáng mát, nhẹ nhàng cho da, tránh được các tình trạng gây bí lỗ chân lông, ngăn ngừa các bệnh về da liễu như tàn nhang, nổi mẩn đó, dị ứng, kích ứng da và tránh sự lão hóa da.')
INSERT [dbo].[LoaiSanPham] ([MaLoai], [TenLoai], [ThanhPhan], [CongDung]) VALUES (N'TD', N'Trang điểm', N'Chất nền, chất nhũ hoa, chất làm đặc, hoạt chất, chất làm mềm, chất tạo màu, chất bảo quản, các chất làm mờ và làm sáng, mùi hương.', N'Giúp phái đẹp khắc phục được nhược điểm, tự tin khi đối diện với những người xung quanh. Giúp điều chỉnh vóc hình khuôn mặt mà bạn yêu thích nhất tự tin nhất.')
GO
INSERT [dbo].[Luong] ([MaNV], [LuongCB], [PhuCapAnUong], [PhuCapXangXe], [PhuCapDienThoai], [Thuong]) VALUES (N'GD00', N'10000000', N'730000', N'200000', N'200000', N'2000000')
INSERT [dbo].[Luong] ([MaNV], [LuongCB], [PhuCapAnUong], [PhuCapXangXe], [PhuCapDienThoai], [Thuong]) VALUES (N'GD01', N'10000000', N'730000', N'200000', N'200000', N'2000000')
INSERT [dbo].[Luong] ([MaNV], [LuongCB], [PhuCapAnUong], [PhuCapXangXe], [PhuCapDienThoai], [Thuong]) VALUES (N'GD02', N'10000000', N'730000', N'200000', N'200000', N'2000000')
INSERT [dbo].[Luong] ([MaNV], [LuongCB], [PhuCapAnUong], [PhuCapXangXe], [PhuCapDienThoai], [Thuong]) VALUES (N'QLNV', N'7000000', N'730000', N'200000', N'200000', N'2000000')
INSERT [dbo].[Luong] ([MaNV], [LuongCB], [PhuCapAnUong], [PhuCapXangXe], [PhuCapDienThoai], [Thuong]) VALUES (N'QLSP', N'7000000', N'730000', N'200000', N'200000', N'2000000')
INSERT [dbo].[Luong] ([MaNV], [LuongCB], [PhuCapAnUong], [PhuCapXangXe], [PhuCapDienThoai], [Thuong]) VALUES (N'QLHD', N'70000000', N'730000', N'200000', N'200000', N'2000000')
INSERT [dbo].[Luong] ([MaNV], [LuongCB], [PhuCapAnUong], [PhuCapXangXe], [PhuCapDienThoai], [Thuong]) VALUES (N'GD03', N'10000000', N'730000', N'200000', N'200000', N'2000000')
GO
INSERT [dbo].[NguoiDung] ([Ma], [TaiKhoan], [MatKhau], [ChucVu]) VALUES (N'GD01', N'hoan', N'123', N'Giám đốc')
INSERT [dbo].[NguoiDung] ([Ma], [TaiKhoan], [MatKhau], [ChucVu]) VALUES (N'GD02', N'lam', N'123', N'Giám đốc')
INSERT [dbo].[NguoiDung] ([Ma], [TaiKhoan], [MatKhau], [ChucVu]) VALUES (N'GD00', N'ly', N'123', N'Giám đốc')
INSERT [dbo].[NguoiDung] ([Ma], [TaiKhoan], [MatKhau], [ChucVu]) VALUES (N'QLNV', N'nhanvien', N'123', N'Quản lý nhân viên')
INSERT [dbo].[NguoiDung] ([Ma], [TaiKhoan], [MatKhau], [ChucVu]) VALUES (N'QLSP', N'sanpham', N'123', N'Quản lý sản phẩm')
INSERT [dbo].[NguoiDung] ([Ma], [TaiKhoan], [MatKhau], [ChucVu]) VALUES (N'QLHD', N'hoadon', N'123', N'Quản lý hóa đơn')
INSERT [dbo].[NguoiDung] ([Ma], [TaiKhoan], [MatKhau], [ChucVu]) VALUES (N'GD03', N'long', N'123', N'GIám đốc')
GO
INSERT [dbo].[NVIEN1] ([Ma], [Ho], [Ten], [GioiTinh], [ChucVu], [NgaySinh], [ThangSinh], [NamSinh], [DiaChi], [SDT], [Email], [Luong], [Anh]) VALUES (N'GD00', N'Đặng Thị Mỹ', N'Ly', N'Nữ', N'Giám đốc', N'10', N'02', N'1989', N'Huế', N'347876987', N'myylyy@gmail.com', N'70000000', N'C:\\Users\\Quan Phat Vinh Thanh\\Documents\\NetBeansProjects\\sql\\src\\Anh\\GD00.PNG')
INSERT [dbo].[NVIEN1] ([Ma], [Ho], [Ten], [GioiTinh], [ChucVu], [NgaySinh], [ThangSinh], [NamSinh], [DiaChi], [SDT], [Email], [Luong], [Anh]) VALUES (N'GD01', N'Phan Văn', N'Hoàn', N'Nam', N'Giám đốc', N'26', N'05', N'1999', N'TP.HCM', N'6577823450', N'hoann@gmail.com', N'70000000', N'C:\\Users\\Quan Phat Vinh Thanh\\Documents\\NetBeansProjects\\sql\\src\\Anh\\BV01.PNG')
INSERT [dbo].[NVIEN1] ([Ma], [Ho], [Ten], [GioiTinh], [ChucVu], [NgaySinh], [ThangSinh], [NamSinh], [DiaChi], [SDT], [Email], [Luong], [Anh]) VALUES (N'GD02', N'Ngô Kiều', N'Lam', N'Nữ', N'Giám đốc', N'01', N'12', N'1990', N'TP.HCM', N'0098753621', N'lamm@gmail.com', N'70000000', N'C:\\Users\\Quan Phat Vinh Thanh\\Documents\\NetBeansProjects\\sql\\src\\Anh\\BV02.PNG')
INSERT [dbo].[NVIEN1] ([Ma], [Ho], [Ten], [GioiTinh], [ChucVu], [NgaySinh], [ThangSinh], [NamSinh], [DiaChi], [SDT], [Email], [Luong], [Anh]) VALUES (N'QLNV', N'Hoàng Khánh ', N'Linh', N'Nữ', N'Quản lý nhân viên', N'10', N'02', N'1989', N'Huế', N'347876987', N'khanhlinh@gmail.com', N'5000000', N'C:\\Users\\Quan Phat Vinh Thanh\\Documents\\NetBeansProjects\\sql\\src\\Anh\\them2.PNG')
INSERT [dbo].[NVIEN1] ([Ma], [Ho], [Ten], [GioiTinh], [ChucVu], [NgaySinh], [ThangSinh], [NamSinh], [DiaChi], [SDT], [Email], [Luong], [Anh]) VALUES (N'QLSP', N'Nguyễn Khánh ', N'Huy', N'Nam', N'Quản lý sản phẩm', N'16', N'01', N'1995', N'TP.HCM', N'6577823450', N'khanhhuy@gmail.com', N'5000000', N'C:\\Users\\Quan Phat Vinh Thanh\\Documents\\NetBeansProjects\\sql\\src\\Anh\\them10.PNG')
INSERT [dbo].[NVIEN1] ([Ma], [Ho], [Ten], [GioiTinh], [ChucVu], [NgaySinh], [ThangSinh], [NamSinh], [DiaChi], [SDT], [Email], [Luong], [Anh]) VALUES (N'QLHD', N'Văn Viết ', N'Nam', N'Nam', N'Quản lý hóa đơn', N'21', N'12', N'1993', N'TP.HCM', N'0098753621', N'vietnam@gmail.com', N'5000000', N'C:\\Users\\Quan Phat Vinh Thanh\\Documents\\NetBeansProjects\\sql\\src\\Anh\\them8.PNG')
INSERT [dbo].[NVIEN1] ([Ma], [Ho], [Ten], [GioiTinh], [ChucVu], [NgaySinh], [ThangSinh], [NamSinh], [DiaChi], [SDT], [Email], [Luong], [Anh]) VALUES (N'GD04', N'Trần Thị Hạ', N'Long', N'Nữ', N'GIám đốc', N'22', N'3', N'1998', N'TP.HCM', N'0123827363', N'longggg@gmail.com', N'70000000', NULL)
GO
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [LoaiSP], [GiaBan], [SoLuong], [DonViTinh], [HinhAnh]) VALUES (N'NRK', N'Mặt nạ Naruko', N'Chăm sóc da', N'30000', N'5', N'25 ml', N'C:\\IDE java\\NetBeans-13\\JaVa\\ICYCos\\src\\icy\\HinhAnh_ICY\\SanPham\\MatNa_NRK.jpg')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [LoaiSP], [GiaBan], [SoLuong], [DonViTinh], [HinhAnh]) VALUES (N'EL', N'Xịt khoáng Evoluderm', N'Chăm sóc da', N'259000', N'2', N'400 ml', N'C:\\IDE java\\NetBeans-13\\JaVa\\ICYCos\\src\\icy\\HinhAnh_ICY\\SanPham\\XitKhoang_EL.jpg')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [LoaiSP], [GiaBan], [SoLuong], [DonViTinh], [HinhAnh]) VALUES (N'SP', N'Sữa dưỡng da Simple', N'Chăm sóc da', N'168000', N'3', N'125 ml', N'C:\\IDE java\\NetBeans-13\\JaVa\\ICYCos\\src\\icy\\HinhAnh_ICY\\SanPham\\SuaDuongDa_SP.jpg')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [LoaiSP], [GiaBan], [SoLuong], [DonViTinh], [HinhAnh]) VALUES (N'PCL', N'Kem dưỡng da Peacholic', N'Chăm sóc da', N'450000', N'2', N'100 ml', N'C:\\IDE java\\NetBeans-13\\JaVa\\ICYCos\\src\\icy\\HinhAnh_ICY\\SanPham\\KemDuongDa_PCL.jpg')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [LoaiSP], [GiaBan], [SoLuong], [DonViTinh], [HinhAnh]) VALUES (N'KR', N'Kem dưỡng ẩm Klairs', N'Chăm sóc da', N'360000', N'5', N'60 ml', N'C:\\IDE java\\NetBeans-13\\JaVa\\ICYCos\\src\\icy\\HinhAnh_ICY\\SanPham\\KemDuongAm_KR.jpg')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [LoaiSP], [GiaBan], [SoLuong], [DonViTinh], [HinhAnh]) VALUES (N'MGD', N'Gel trị mụn Megadou', N'Mỹ phẩm chức năng', N'106000', N'3', N'19 gam', N'C:\\IDE java\\NetBeans-13\\JaVa\\ICYCos\\src\\icy\\HinhAnh_ICY\\SanPham\\GelTriMun_MGD.jpg')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [LoaiSP], [GiaBan], [SoLuong], [DonViTinh], [HinhAnh]) VALUES (N'OB', N'Nước cân bằng da OBagi', N'Mỹ phẩm chức năng', N'8800000', N'6', N'48 ml', N'C:\\IDE java\\NetBeans-13\\JaVa\\ICYCos\\src\\icy\\HinhAnh_ICY\\SanPham\\NuocCanBangDa_OB.jpg')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [LoaiSP], [GiaBan], [SoLuong], [DonViTinh], [HinhAnh]) VALUES (N'RP', N'Gel rửa mặt Roche-Posay', N'Mỹ phẩm chức năng', N'175000', N'2', N'50 ml', N'C:\\IDE java\\NetBeans-13\\JaVa\\ICYCos\\src\\icy\\HinhAnh_ICY\\SanPham\\GelRuaMat_RP.jpg')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [LoaiSP], [GiaBan], [SoLuong], [DonViTinh], [HinhAnh]) VALUES (N'DE', N'gel ngừa mụn Decumar', N'Mỹ phẩm chức năng', N'77000', N'3', N'20 gam', N'C:\\IDE java\\NetBeans-13\\JaVa\\ICYCos\\src\\icy\\HinhAnh_ICY\\SanPham\\GelNguaMun_De.jpg')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [LoaiSP], [GiaBan], [SoLuong], [DonViTinh], [HinhAnh]) VALUES (N'COS', N'Miếng dán mụn Cosrx', N'Mỹ phẩm chức năng', N'7000', N'20', N'1 cái', N'C:\\IDE java\\NetBeans-13\\JaVa\\ICYCos\\src\\icy\\HinhAnh_ICY\\SanPham\\MiengDanMun_Cos.jpg')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [LoaiSP], [GiaBan], [SoLuong], [DonViTinh], [HinhAnh]) VALUES (N'TPL', N'Kem chống nắng Peacholic', N'Chống nắng', N'760000', N'2', N'60 ml', N'C:\\IDE java\\NetBeans-13\\JaVa\\ICYCos\\src\\icy\\HinhAnh_ICY\\SanPham\\KemChongNang_TPL.jpg')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [LoaiSP], [GiaBan], [SoLuong], [DonViTinh], [HinhAnh]) VALUES (N'SL', N'Sữa chống nắng Sunplay', N'Chống nắng', N'182000', N'3', N'55 gam', N'C:\\IDE java\\NetBeans-13\\JaVa\\ICYCos\\src\\icy\\HinhAnh_ICY\\SanPham\\SuaChongNang_SL.jpg')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [LoaiSP], [GiaBan], [SoLuong], [DonViTinh], [HinhAnh]) VALUES (N'FD', N'Gel chống nắng Fixderma', N'Chống nắng', N'243000', N'5', N'75 gam', N'C:\\IDE java\\NetBeans-13\\JaVa\\ICYCos\\src\\icy\\HinhAnh_ICY\\SanPham\\GelChongNang_FD.jpg')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [LoaiSP], [GiaBan], [SoLuong], [DonViTinh], [HinhAnh]) VALUES (N'TO', N'Tẩy tế bào chết The Ordinary', N'Làm sạch da', N'285000', N'2', N'30 ml', N'C:\\IDE java\\NetBeans-13\\JaVa\\ICYCos\\src\\icy\\HinhAnh_ICY\\SanPham\\TayTeBaoChet_TO.jpg')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [LoaiSP], [GiaBan], [SoLuong], [DonViTinh], [HinhAnh]) VALUES (N'CE', N'Sữa rửa mặt Cetaphil', N'Làm sạch da', N'271000', N'5', N'500 ml', N'C:\\IDE java\\NetBeans-13\\JaVa\\ICYCos\\src\\icy\\HinhAnh_ICY\\SanPham\\SuaRuaMat_CE.jpg')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [LoaiSP], [GiaBan], [SoLuong], [DonViTinh], [HinhAnh]) VALUES (N'DP', N'Dầu tẩy trang Peacholic', N'Làm sạch da', N'160000', N'2', N'50 ml', N'C:\\IDE java\\NetBeans-13\\JaVa\\ICYCos\\src\\icy\\HinhAnh_ICY\\SanPham\\DauTayTrang_DP.jpg')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [LoaiSP], [GiaBan], [SoLuong], [DonViTinh], [HinhAnh]) VALUES (N'TM', N'Gel kẻ mắt Tony Moly', N'Trang điểm', N'130000', N'2', N'4 gam', N'C:\\IDE java\\NetBeans-13\\JaVa\\ICYCos\\src\\icy\\HinhAnh_ICY\\SanPham\\SonLi_3C.jpg')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [LoaiSP], [GiaBan], [SoLuong], [DonViTinh], [HinhAnh]) VALUES (N'MTF', N'Chì kẻ mắt Merzy', N'Trang điểm', N'134000', N'1', N'0.5 gam', N'C:\\IDE java\\NetBeans-13\\JaVa\\ICYCos\\src\\icy\\HinhAnh_ICY\\SanPham\\ChiKeMat_MTF.jpg')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [LoaiSP], [GiaBan], [SoLuong], [DonViTinh], [HinhAnh]) VALUES (N'3C', N'Son lì 3CE', N'Trang điểm', N'347000', N'6', N'3.5 gam', N'C:\\IDE java\\NetBeans-13\\JaVa\\ICYCos\\src\\icy\\HinhAnh_ICY\\SanPham\\SonLi_3C.jpg')
INSERT [dbo].[SanPham] ([MaSP], [TenSP], [LoaiSP], [GiaBan], [SoLuong], [DonViTinh], [HinhAnh]) VALUES (N'EH', N'Phấn mắt Etude Hause', N'Trang điểm', N'300000', N'2', N'1 cái', N'C:\\IDE java\\NetBeans-13\\JaVa\\ICYCos\\src\\icy\\HinhAnh_ICY\\SanPham\\PhanMat_EH.jpg')
GO
INSERT [dbo].[ThamSoChung] ([TenKhoHang], [TenPhieuNhap], [ThongTinSanPham], [ThongTinPhieuNhap], [Ma]) VALUES (N'Kho hàng', N'Tên phiếu nhập', N'Thông tin sản phẩm', N'Thông tin phiếu nhập', N'1')
GO
