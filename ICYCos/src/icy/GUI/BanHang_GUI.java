/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package icy.GUI;

import ICY.BUS.QLNV_BUS;
import ICY.DTO.QLNV_DTO;
import icy.BUS.BanHang_BUS;
import icy.BUS.CTKhuyenMai_BUS;
import icy.BUS.ChiTietHoaDon_BUS;
import icy.BUS.HoaDon_BUS;
import static icy.BUS.HoaDon_BUS.dshoadon;
import icy.BUS.NhapHang_BUS;
import icy.BUS.SanPham_BUS;
import icy.DTO.CTKhuyenMai_DTO;
import icy.DTO.ChiTietHoaDon_DTO;
import icy.DTO.HoaDon_DTO;
import icy.DTO.NhapHang_DTO;
import icy.DTO.SanPham_DTO;
import static icy.GUI.DangNhap_GUI.DN;
import static icy.GUI.DoanhThu_GUI.DT;
import static icy.GUI.HoSoNV_GUI.HS;
import static icy.GUI.HoTro_GUI.HT;
import static icy.GUI.HuongDan_GUI.HD;
import static icy.GUI.KhachHang_GUI.KH;
import static icy.GUI.KhuyenMai_GUI.KM;
import static icy.GUI.NhapHang_GUI.NH;
import static icy.GUI.QLNV_GUI.NV;
import static icy.GUI.SanPham_GUI.SP;
import static icy.GUI.ThongKe_GUI.TK;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author HP
 */
public class BanHang_GUI extends javax.swing.JFrame {
    DefaultTableModel model = new DefaultTableModel();
    DefaultTableModel modelGH = new DefaultTableModel();
    DefaultTableModel modelHD = new DefaultTableModel();
    DefaultTableModel modelCTHD = new DefaultTableModel();
    public static BanHang_GUI BH = new BanHang_GUI();
    SanPham_DTO dssp = new SanPham_DTO();
    BanHang_BUS bhbus = new BanHang_BUS();
    ChiTietHoaDon_DTO cthd = new ChiTietHoaDon_DTO();
    ChiTietHoaDon_BUS cthdbus = new ChiTietHoaDon_BUS();
    HoaDon_DTO hd = new HoaDon_DTO();
    HoaDon_BUS hdbus = new HoaDon_BUS();
    CTKhuyenMai_BUS kmbus =new CTKhuyenMai_BUS();
    QLNV_BUS nvbus = new QLNV_BUS();
    int d = 0;
    static int x = HoaDon_BUS.dshoadon.size() + 1;//Biến dùng gán Mã HD trong ds sản phẩm khi mua

    public BanHang_GUI() {
        initComponents();
        docdssp();
        DocCTHD();
        DocHoaDon();
        try {
            btnDonHang.setSelected(true);
        } catch (Exception ex) {
        }
    }

    public void docdssp() {
        if (BanHang_BUS.dssp == null) {
            bhbus.DocSPTonKho();
        }
        Vector hearder = new Vector();
        hearder.add("Mã SP");
        hearder.add("Tên SP");
        hearder.add("Còn lại");
        hearder.add("Giá bán");
        hearder.add("Hình ảnh");
        if (model.getRowCount() == 0) {
            model = new DefaultTableModel(hearder, 0);
        }
        for (SanPham_DTO sp : BanHang_BUS.dssp) {
            Vector row = new Vector();
            row.add(sp.MaSP);
            row.add(sp.TenSP);
            row.add(sp.SoLuong);
            row.add(sp.GiaBan);
            row.add(sp.HinhAnhSP);
            model.addRow(row);
            tblKho.setModel(model);
        }
    }

    public void DocCTHD() {
        if (ChiTietHoaDon_BUS.dshd == null) {
            cthdbus.DocCTHD();
        }
        //cập nhật Jtable
        Vector header = new Vector();
        header.add("Mã HD");
        header.add("Mã SP");//tên cột table
        header.add("Tên SP");
        header.add("Số lượng");
        header.add("Đơn giá");
        header.add("Thành tiền");
        if (modelCTHD.getRowCount() == 0) {
            modelCTHD = new DefaultTableModel(header, 0);
        }
        for (ChiTietHoaDon_DTO cthd : ChiTietHoaDon_BUS.dshd) {
            //nạp dữ liệu cho mỗi row
            Vector row = new Vector();
            row.add(cthd.MaHD);
            row.add(cthd.MaSP);
            row.add(cthd.TenSP);
            row.add(cthd.SoLuong);
            row.add(cthd.GiaBan);
            row.add(cthd.ThanhTien);
            modelCTHD.addRow(row); //thêm row dữ liệu vào model
            tblCTHD.setModel(modelCTHD);
        }
    }

    public void DocHoaDon() {
        if (HoaDon_BUS.dshoadon == null) {
            hdbus.DocHoaDon();
        }
        //cập nhật Jtable
        Vector header = new Vector();
        header.add("Mã HD");//tên cột table
        header.add("Ngày lập");
        header.add("Tổng tiền");
        if (modelHD.getRowCount() == 0) {
            modelHD = new DefaultTableModel(header, 0);
        }
        for (HoaDon_DTO hd : HoaDon_BUS.dshoadon) {
            //nạp dữ liệu cho mỗi row
            Vector row = new Vector();
            row.add(hd.MaHD);
            row.add(hd.NgayLap);
            row.add(hd.TongTien);
            modelHD.addRow(row); //thêm row dữ liệu vào model
            tblHoaDon.setModel(modelHD);
        }
    }
    String s = "";

    public boolean KiemTraGiaTri() {
        if (spnSoLuong.getValue().equals("0")) {
            s = "Chon SO Luong! \n";
            spnSoLuong.setBackground(Color.PINK);
        } else {
            spnSoLuong.setBackground(Color.white);
        }
        if (s.length() > 0) {
            return false;
        } else {
            return true;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jScrollPane2 = new javax.swing.JScrollPane();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jFrame1 = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnDangNhap = new javax.swing.JToggleButton();
        btnSanPham = new javax.swing.JToggleButton();
        btnkhuyenMai = new javax.swing.JToggleButton();
        btnNhanVien = new javax.swing.JToggleButton();
        btnKhachHang = new javax.swing.JToggleButton();
        btnDonHang = new javax.swing.JToggleButton();
        btnNhapHang = new javax.swing.JToggleButton();
        btnThongKe = new javax.swing.JToggleButton();
        btnDoanhThu = new javax.swing.JToggleButton();
        btnHoTro = new javax.swing.JToggleButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKho = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblGioHang = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        lbelAnh = new javax.swing.JLabel();
        btnThemGH = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        txtTenSP = new javax.swing.JTextField();
        txtGiaBan = new javax.swing.JTextField();
        spnSoLuong = new javax.swing.JSpinner();
        jPanel8 = new javax.swing.JPanel();
        txtKH = new javax.swing.JTextField();
        txtNV = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        txtTongPhiNhap = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtTienKhachDua = new javax.swing.JTextField();
        txtTienThua = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXuat = new javax.swing.JButton();
        cbbNV = new javax.swing.JComboBox<>();
        btnTienThua = new javax.swing.JButton();
        TienKhachCanTra = new javax.swing.JTextField();
        btnHienthiTen = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnThoat = new javax.swing.JButton();
        btnLienHe = new javax.swing.JButton();
        btnHuongDan = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblCTHD = new javax.swing.JTable();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel13 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        lbelAnhSP = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtTenKH = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtNhanVien = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtNgayLap = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtSL = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txtGia = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtThanhTien = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        btnThoat1 = new javax.swing.JButton();
        btnLienHe1 = new javax.swing.JButton();
        btnHuongDan1 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HỆ THỐNG QUẢN LÝ CỬA HÀNG MỸ PHẨM");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icy/HinhAnh_ICY/HinhAnhICY.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icy/HinhAnh_ICY/SLogan_ICY.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(197, 223, 234));

        btnDangNhap.setBackground(new java.awt.Color(255, 204, 204));
        buttonGroup1.add(btnDangNhap);
        btnDangNhap.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDangNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icy/HinhAnh_ICY/TrangChu/NguoiDung.png"))); // NOI18N
        btnDangNhap.setText(" Đăng nhập");
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });

        btnSanPham.setBackground(new java.awt.Color(255, 204, 204));
        buttonGroup1.add(btnSanPham);
        btnSanPham.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icy/HinhAnh_ICY/TrangChu/SanPham.png"))); // NOI18N
        btnSanPham.setText("Sản phẩm");
        btnSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSanPhamActionPerformed(evt);
            }
        });

        btnkhuyenMai.setBackground(new java.awt.Color(255, 204, 204));
        buttonGroup1.add(btnkhuyenMai);
        btnkhuyenMai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnkhuyenMai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icy/HinhAnh_ICY/TrangChu/KhuyenMai.png"))); // NOI18N
        btnkhuyenMai.setText("   Khuyến mãi");
        btnkhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkhuyenMaiActionPerformed(evt);
            }
        });

        btnNhanVien.setBackground(new java.awt.Color(255, 204, 204));
        buttonGroup1.add(btnNhanVien);
        btnNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icy/HinhAnh_ICY/TrangChu/NhanVien.png"))); // NOI18N
        btnNhanVien.setText("Nhân viên");
        btnNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanVienActionPerformed(evt);
            }
        });

        btnKhachHang.setBackground(new java.awt.Color(255, 204, 204));
        buttonGroup1.add(btnKhachHang);
        btnKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icy/HinhAnh_ICY/TrangChu/KhachHang.png"))); // NOI18N
        btnKhachHang.setText("  Khách hàng");
        btnKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhachHangActionPerformed(evt);
            }
        });

        btnDonHang.setBackground(new java.awt.Color(255, 204, 204));
        buttonGroup1.add(btnDonHang);
        btnDonHang.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDonHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icy/HinhAnh_ICY/TrangChu/DonHang.png"))); // NOI18N
        btnDonHang.setText("Đơn hàng");
        btnDonHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDonHangActionPerformed(evt);
            }
        });

        btnNhapHang.setBackground(new java.awt.Color(255, 204, 204));
        buttonGroup1.add(btnNhapHang);
        btnNhapHang.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNhapHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icy/HinhAnh_ICY/TrangChu/NhapHang.png"))); // NOI18N
        btnNhapHang.setText(" Nhập hàng");
        btnNhapHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapHangActionPerformed(evt);
            }
        });

        btnThongKe.setBackground(new java.awt.Color(255, 204, 204));
        buttonGroup1.add(btnThongKe);
        btnThongKe.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icy/HinhAnh_ICY/TrangChu/ThongKe.gif"))); // NOI18N
        btnThongKe.setText("Thống kê");
        btnThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeActionPerformed(evt);
            }
        });

        btnDoanhThu.setBackground(new java.awt.Color(255, 204, 204));
        buttonGroup1.add(btnDoanhThu);
        btnDoanhThu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDoanhThu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icy/HinhAnh_ICY/TrangChu/DoanhThu.png"))); // NOI18N
        btnDoanhThu.setText(" Doanh thu");
        btnDoanhThu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoanhThuActionPerformed(evt);
            }
        });

        btnHoTro.setBackground(new java.awt.Color(255, 204, 204));
        buttonGroup1.add(btnHoTro);
        btnHoTro.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHoTro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icy/HinhAnh_ICY/TrangChu/HoTro.png"))); // NOI18N
        btnHoTro.setText("Hỗ trợ");
        btnHoTro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoTroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnDangNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnkhuyenMai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
            .addComponent(btnDonHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnNhapHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnDoanhThu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnHoTro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnkhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnNhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnDoanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnHoTro, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 188, Short.MAX_VALUE))
        );

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(255, 255, 204));

        tblKho.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã SP", "Tên SP", "Còn Lại", "Giá", "Hình Ảnh"
            }
        ));
        tblKho.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKho);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Danh Sách Sản Phẩm");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setText("Giỏ Hàng");

        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã ĐH", "Mã SP", "Tên SP", "Số Lượng", "Giá", "Thành Tiền"
            }
        ));
        tblGioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGioHangMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblGioHang);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Chi Tiếc Sản Phẩm");

        lbelAnh.setText("Hình Ảnh");

        btnThemGH.setText("Thêm Vào Giỏ");
        btnThemGH.setToolTipText("");
        btnThemGH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemGHActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Mã Sản Phẩm");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Tên Sản Phẩm");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Giá");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Số Lượng");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtGiaBan, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                            .addComponent(txtTenSP)
                            .addComponent(txtMaSP)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(spnSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 39, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(spnSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(231, 231, 231));

        txtKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKHActionPerformed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel30.setText("Tổng Tiền Đơn Hàng");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Khách cần trả");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Hình thức thanh toán");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel20.setText("Tiền khách đưa");

        txtTienThua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienThuaActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel31.setText("Mã KH");

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel32.setText("Mã NV");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnXoa.setBackground(new java.awt.Color(231, 231, 231));
        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.setBorder(null);
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(231, 231, 231));
        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSua.setText("Sửa");
        btnSua.setToolTipText("");
        btnSua.setBorder(null);
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXuat.setBackground(new java.awt.Color(231, 231, 231));
        btnXuat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXuat.setText("Xuất Hóa Đơn");
        btnXuat.setBorder(null);
        btnXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatActionPerformed(evt);
            }
        });

        cbbNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbNVMouseClicked(evt);
            }
        });

        btnTienThua.setBackground(new java.awt.Color(255, 255, 153));
        btnTienThua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTienThua.setText("Tính");
        btnTienThua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTienThuaActionPerformed(evt);
            }
        });

        btnHienthiTen.setBackground(new java.awt.Color(255, 255, 153));
        btnHienthiTen.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHienthiTen.setText("Tên NV");
        btnHienthiTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHienthiTenActionPerformed(evt);
            }
        });

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton2.setBackground(new java.awt.Color(255, 255, 153));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setText("Tên KH");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                            .addComponent(jLabel30)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtTongPhiNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                            .addComponent(jLabel32)
                            .addGap(89, 89, 89)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jComboBox2, 0, 118, Short.MAX_VALUE)
                                .addComponent(cbbNV, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                            .addComponent(jLabel20)
                            .addGap(39, 39, 39)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtTienKhachDua)
                                .addGroup(jPanel8Layout.createSequentialGroup()
                                    .addComponent(btnXoa)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnSua)
                                    .addGap(11, 11, 11)))))
                    .addComponent(jLabel31))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnHienthiTen)
                                    .addComponent(jLabel5)
                                    .addComponent(jButton2)))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTienThua)))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTienThua, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                            .addComponent(txtNV)
                            .addComponent(TienKhachCanTra)
                            .addComponent(txtKH))
                        .addContainerGap())
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(btnXuat)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtKH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnHienthiTen)
                            .addComponent(txtNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel32)
                            .addComponent(cbbNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTongPhiNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)
                        .addComponent(TienKhachCanTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTienThua))
                .addGap(29, 29, 29)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoa)
                    .addComponent(btnSua)
                    .addComponent(btnXuat))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("Thông Tin Hóa Đơn");

        jPanel4.setBackground(new java.awt.Color(197, 223, 234));

        btnThoat.setBackground(new java.awt.Color(204, 204, 204));
        btnThoat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        btnLienHe.setBackground(new java.awt.Color(204, 204, 204));
        btnLienHe.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLienHe.setText("Liên hệ");
        btnLienHe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLienHeActionPerformed(evt);
            }
        });

        btnHuongDan.setBackground(new java.awt.Color(204, 204, 204));
        btnHuongDan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHuongDan.setText("Hướng dẫn");
        btnHuongDan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuongDanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnHuongDan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLienHe)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThoat)
                    .addComponent(btnLienHe)
                    .addComponent(btnHuongDan))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbelAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnThemGH)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(23, 23, 23))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(jLabel2)
                .addGap(272, 272, 272)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(206, 206, 206)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(212, 212, 212))
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(lbelAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnThemGH)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 39, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Bán Hàng", jPanel6);

        jPanel5.setBackground(new java.awt.Color(255, 255, 204));

        jTextField15.setText("jTextField15");
        jTextField15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField15ActionPerformed(evt);
            }
        });

        jPanel9.setBackground(new java.awt.Color(255, 255, 204));

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã ĐH", "Ngày Lập", "Tổng Tiền"
            }
        ));
        tblHoaDon.setGridColor(new java.awt.Color(153, 153, 153));
        tblHoaDon.setSelectionBackground(new java.awt.Color(255, 200, 245));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblHoaDon);

        tblCTHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã ĐH", "Mã SP", "Tên SP", "Số Lượng", "Giá", "Thành Tiền"
            }
        ));
        tblCTHD.setGridColor(new java.awt.Color(153, 153, 153));
        tblCTHD.setSelectionBackground(new java.awt.Color(255, 200, 245));
        tblCTHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCTHDMouseClicked(evt);
                tblCTHDChiTietCuaHDKhiClick(evt);
            }
        });
        jScrollPane5.setViewportView(tblCTHD);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setText("Thông Tin Đơn Hàng");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel21.setText("Chi Tiết Hóa Đơn");

        jTextField16.setText("jTextField15");
        jTextField16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField16ActionPerformed(evt);
            }
        });

        lbelAnhSP.setText("           ẢNH");

        jPanel10.setBackground(new java.awt.Color(255, 255, 204));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setText("Mã ĐH");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("Tên Khách Hàng");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setText("Nhân viên");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setText("Ngày lập");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setText("Tổng Tiền");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNgayLap)
                            .addComponent(txtTenKH)
                            .addComponent(txtMaHD, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                            .addComponent(txtNhanVien)))
                    .addComponent(jLabel18)
                    .addComponent(jLabel17)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(txtTongTien)))
                .addGap(0, 8, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(txtNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(98, 98, 98))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(txtNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel11.setBackground(new java.awt.Color(231, 231, 231));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel22.setText("Mã SP");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel23.setText("Tên SP");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel24.setText("Số Lượng");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel25.setText("Giá");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel26.setText("Thành tiền");

        jButton1.setBackground(new java.awt.Color(231, 231, 231));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setText("Cập nhật");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTen)
                            .addComponent(txtMa)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGia)
                            .addComponent(txtSL)))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtThanhTien)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(155, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(107, 107, 107))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24)
                    .addComponent(txtSL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25)
                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel12.setBackground(new java.awt.Color(197, 223, 234));

        btnThoat1.setBackground(new java.awt.Color(204, 204, 204));
        btnThoat1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThoat1.setText("Thoát");
        btnThoat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoat1ActionPerformed(evt);
            }
        });

        btnLienHe1.setBackground(new java.awt.Color(204, 204, 204));
        btnLienHe1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLienHe1.setText("Liên hệ");
        btnLienHe1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLienHe1ActionPerformed(evt);
            }
        });

        btnHuongDan1.setBackground(new java.awt.Color(204, 204, 204));
        btnHuongDan1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHuongDan1.setText("Hướng dẫn");
        btnHuongDan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuongDan1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnHuongDan1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLienHe1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnThoat1)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThoat1)
                    .addComponent(btnLienHe1)
                    .addComponent(btnHuongDan1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(464, 464, 464)
                                .addComponent(jLabel13))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel21)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel27)
                                .addGap(46, 46, 46)
                                .addComponent(lbelAnhSP, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jSeparator2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addGap(48, 48, 48)
                                        .addComponent(jLabel27))
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addComponent(lbelAnhSP, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(143, 143, 143)
                                .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel16)
                .addGap(501, 501, 501)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(476, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(198, 549, Short.MAX_VALUE))
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(jLabel16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Đơn Hàng", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1024, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed
        if (btnDangNhap.getText().equals(" Đăng nhập")) {
            DN.setVisible(true);
            DN.setLocationRelativeTo(null);
        } else {
            HS.setVisible(true);
            HS.setLocationRelativeTo(null);
        }
        QLNV_BUS busnv = new QLNV_BUS();
        for (QLNV_DTO nv : busnv.dsnv) {
            if (btnDangNhap.getText().equals(nv.Ten)) {
                HS.setTextHo(nv.Ho);
                HS.setTextTen(nv.Ten);
                HS.setTextGT(nv.GioiTinh);
                HS.setTextMaNV(nv.Ma);
                HS.setTextChucVu(nv.ChucVu);
                HS.setTextAnh(nv.anh);
            }
        }
    }//GEN-LAST:event_btnDangNhapActionPerformed
    public boolean checkQuyenQLGD() {
        for (QLNV_DTO nv : QLNV_BUS.dsnv) {
            if (btnDangNhap.getText().equals(nv.Ten)) {
                if (nv.ChucVu.equals("Quản lý") || nv.ChucVu.equals("Giám đốc")) {
                    return true;
                }
            }
        }
        return false;
    }
    private void btnSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSanPhamActionPerformed
        if (!btnDangNhap.getText().equals(" Đăng nhập")) {
            if (btnSanPham.isSelected() == true) {
                BH.setVisible(false);
                SP.setVisible(true);
                SP.setLocationRelativeTo(null);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Bạn không được sử dụng chức năng này!");
        }
    }//GEN-LAST:event_btnSanPhamActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_formMouseClicked
    public void showCTHDKhiClick(ArrayList<ChiTietHoaDon_DTO> ds) {
        //cập nhật Jtable
        Vector header = new Vector();
        header.add("Mã HD");
        header.add("Mã SP");//tên cột table
        header.add("Tên SP");
        header.add("Số lượng");
        header.add("Đơn giá");
        header.add("Thành tiền");
        DefaultTableModel mCTPN = new DefaultTableModel(header, 0);
        for (ChiTietHoaDon_DTO cthd : ds) {
            //nạp dữ liệu cho mỗi row
            Vector row = new Vector();
            row.add(cthd.MaHD);
            row.add(cthd.MaSP);
            row.add(cthd.TenSP);
            row.add(cthd.SoLuong);
            row.add(cthd.GiaBan);
            row.add(cthd.ThanhTien);
            mCTPN.addRow(row);
        }
        tblCTHD.setModel(mCTPN);
    }
    ArrayList<ChiTietHoaDon_DTO> dsKhiClick;
    private void btnNhapHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapHangActionPerformed
        if (!btnDangNhap.getText().equals(" Đăng nhập") && checkQuyenQLGD() == true) {
            if (btnNhapHang.isSelected() == true) {
                BH.setVisible(false);
                NH.setVisible(true);
                NH.setLocationRelativeTo(null);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Bạn không được sử dụng chức năng này!");
        }
    }//GEN-LAST:event_btnNhapHangActionPerformed

    private void btnkhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkhuyenMaiActionPerformed
        if (!btnDangNhap.getText().equals(" Đăng nhập")) {
            if (btnkhuyenMai.isSelected() == true) {
                BH.setVisible(false);
                KM.setVisible(true);
                KM.setLocationRelativeTo(null);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Bạn không được sử dụng chức năng này!");
        }
    }//GEN-LAST:event_btnkhuyenMaiActionPerformed

    private void btnKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhachHangActionPerformed
        if (!btnDangNhap.getText().equals(" Đăng nhập")) {
            if (btnKhachHang.isSelected() == true) {
                BH.setVisible(false);
                KH.setVisible(true);
                KH.setLocationRelativeTo(null);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Bạn không được sử dụng chức năng này!");
        }
    }//GEN-LAST:event_btnKhachHangActionPerformed

    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeActionPerformed
        if (!btnDangNhap.getText().equals(" Đăng nhập") && checkQuyenQLGD() == true) {
            if (btnThongKe.isSelected() == true) {
                BH.setVisible(false);
                TK.setVisible(true);
                TK.setLocationRelativeTo(null);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Bạn không được sử dụng chức năng này!");
        }
    }//GEN-LAST:event_btnThongKeActionPerformed

    private void btnDoanhThuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoanhThuActionPerformed
        if (!btnDangNhap.getText().equals(" Đăng nhập") && checkQuyenQLGD() == true) {
            if (btnDoanhThu.isSelected() == true) {
                DT.setVisible(true);
                DT.setLocationRelativeTo(null);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Bạn không được sử dụng chức năng này!");
        }
    }//GEN-LAST:event_btnDoanhThuActionPerformed

    private void btnHoTroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoTroActionPerformed
        if (!btnDangNhap.getText().equals(" Đăng nhập")) {
            if (btnHoTro.isSelected() == true) {
                BH.setVisible(false);
                HT.setVisible(true);
                HT.setLocationRelativeTo(null);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Bạn không được sử dụng chức năng này!");
        }
    }//GEN-LAST:event_btnHoTroActionPerformed

    private void btnNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhanVienActionPerformed
        if (!btnDangNhap.getText().equals(" Đăng nhập") && checkQuyenQLGD() == true) {
            if (btnNhanVien.isSelected() == true) {
                BH.setVisible(false);
                NV.setVisible(true);
                NV.setLocationRelativeTo(null);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Bạn không được sử dụng chức năng này!");
        }
    }//GEN-LAST:event_btnNhanVienActionPerformed

    private void btnDonHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDonHangActionPerformed

    }//GEN-LAST:event_btnDonHangActionPerformed

    private void btnHuongDanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuongDanActionPerformed
        if (btnHuongDan.isSelected() == true) {
            HD.setVisible(true);
            HD.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_btnHuongDanActionPerformed

    private void btnLienHeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLienHeActionPerformed
        JOptionPane.showMessageDialog(this, "Bạn vui lòng chọn chức năng hỗ trợ để liên hệ!");
    }//GEN-LAST:event_btnLienHeActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        BH.setVisible(false);
    }//GEN-LAST:event_btnThoatActionPerformed

    private void jTextField15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField15ActionPerformed

    private void btnThemGHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemGHActionPerformed
        int d=0;
        if (KiemTraGiaTri() == true) {
            cthd.MaHD = x;
            cthd.MaSP = txtMaSP.getText();
            cthd.TenSP = txtTenSP.getText();
            cthd.SoLuong = (int) spnSoLuong.getValue();
            cthd.GiaBan = Float.parseFloat(txtGiaBan.getText());
            if (CTKhuyenMai_BUS.dsctkm == null) {
                kmbus.DocDSCTKM();
            }
            for (CTKhuyenMai_DTO km : CTKhuyenMai_BUS.dsctkm ){
                if(km.masp.equals(cthd.MaSP)){
                    Float x = cthd.SoLuong * cthd.GiaBan * (Float.parseFloat(km.giamgia)/100);
                    cthd.ThanhTien= cthd.SoLuong * cthd.GiaBan -x;
                    d=d+1;
                    break;
                }
            }
            if(d==0){
                cthd.ThanhTien =cthd.SoLuong*cthd.GiaBan;
            }
            //Them vao arrayList tạm
            cthdbus.dsHoaDon.add(cthd);
            //cập nhật Jtable
            Vector header = new Vector();
            header.add("Mã HD");
            header.add("Mã SP");//tên cột table
            header.add("Tên SP");
            header.add("Số lượng");
            header.add("Giá");
            header.add("Thành tiền");
            if (modelGH.getRowCount() == 0) {
                modelGH = new DefaultTableModel(header, 0);
            }
            //nạp dữ liệu cho mỗi row
            Vector row = new Vector();
            row.add(cthd.MaHD);
            row.add(cthd.MaSP);
            row.add(cthd.TenSP);
            row.add(cthd.SoLuong);
            row.add(cthd.GiaBan);
            row.add(cthd.ThanhTien);
            modelGH.addRow(row); //thêm row dữ liệu vào model
            //nạp du lieu cua model vào jtable tblDSSV
            tblGioHang.setModel(modelGH);
            Float tam;
            if (txtTongPhiNhap.getText().equalsIgnoreCase("")) {
                tam = 0 + cthd.ThanhTien;
            } else {
                tam = Float.parseFloat(txtTongPhiNhap.getText()) + cthd.ThanhTien;
            }
            txtTongPhiNhap.setText(String.valueOf(tam));
            System.out.println(tam);
            JOptionPane.showMessageDialog(this, "thêm thành công!");
        } else {
            if (KiemTraGiaTri() == true) {
                JOptionPane.showMessageDialog(this, s.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
                s = "";
            }
        }
    }//GEN-LAST:event_btnThemGHActionPerformed

    private void tblGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGioHangMouseClicked
        int i = tblGioHang.getSelectedRow();
        TableModel gh = tblGioHang.getModel();
        if (i >= 0) {
            //--------Hiện ở danh sách hóa đơn nhập hàng---------
            txtMaSP.setText(gh.getValueAt(i, 1).toString());
            txtTenSP.setText(gh.getValueAt(i, 2).toString());
            spnSoLuong.setValue(gh.getValueAt(i, 3));
            txtGiaBan.setText(gh.getValueAt(i, 4).toString());
            //hiện ảnh
            for (SanPham_DTO sp : BanHang_BUS.dssp) {
                if (sp.MaSP.equals(gh.getValueAt(i, 1).toString())) {
                    String linkAnh = sp.HinhAnhSP;
                    lbelAnh.setIcon(bhbus.ResizeImage(String.valueOf(linkAnh), lbelAnh));
                }
            }
        }
    }//GEN-LAST:event_tblGioHangMouseClicked

    private void tblKhoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhoMouseClicked
        int i = tblKho.getSelectedRow();
        if (i >= 0) {
            SanPham_DTO sp = new SanPham_DTO();
            sp = bhbus.dssp.get(i);
            txtMaSP.setText(sp.MaSP);
            txtTenSP.setText(sp.TenSP);
            txtGiaBan.setText(sp.GiaBan);
            //hiện ảnh
            String linkAnh = sp.HinhAnhSP;
            lbelAnh.setIcon(bhbus.ResizeImage(String.valueOf(linkAnh), lbelAnh));
        }
    }//GEN-LAST:event_tblKhoMouseClicked

    private void txtKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKHActionPerformed

    private void txtTienThuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTienThuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTienThuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int i = tblGioHang.getSelectedRow();
        TableModel model = tblGioHang.getModel();
        Float oldThanhTien = Float.parseFloat(model.getValueAt(i, 5).toString());
        Float tam = Float.parseFloat(txtTongPhiNhap.getText()) - oldThanhTien;
        if (i == -1) {
            JOptionPane.showMessageDialog(this, "Bạn cần chọn sản phẩm để xóa!", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } else {
            int x = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa!");
            if (x == JOptionPane.YES_OPTION) {
                if (i >= 0) {
                    ChiTietHoaDon_BUS.dsHoaDon.remove(i);
                    modelGH.removeRow(i);
                    tblGioHang.setModel(modelGH);
                    txtTongPhiNhap.setText(String.valueOf(tam));
                }
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        //giu lai sp trc khi sua
        TableModel model = tblGioHang.getModel();
        Float oldThanhTien = Float.parseFloat(model.getValueAt(tblGioHang.getSelectedRow(), 5).toString());
        if (tblGioHang.getSelectedRow() >= 0) {
            cthd.SoLuong = (int) spnSoLuong.getValue();
            cthd.ThanhTien = cthd.SoLuong * cthd.GiaBan;
            modelGH.setValueAt(cthd.SoLuong, tblGioHang.getSelectedRow(), 3);
            modelGH.setValueAt(cthd.ThanhTien, tblGioHang.getSelectedRow(), 5);
            tblGioHang.setModel(modelGH);
            Float tam = Float.parseFloat(txtTongPhiNhap.getText()) - oldThanhTien + cthd.ThanhTien;
            txtTongPhiNhap.setText(String.valueOf(tam));
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatActionPerformed
        if (ChiTietHoaDon_BUS.dsHoaDon.size() > 0 == true) {
            d = HoaDon_BUS.dshoadon.size() + 1;
            hd.MaHD = String.valueOf(d);
            hd.TenKH = txtKH.getText();
            hd.TenNV = txtNV.getText();
            hd.NgayLap = String.valueOf(java.time.LocalDate.now());
            hd.TongTien = txtTongPhiNhap.getText();
            hdbus.NhapHD(hd);
            //cập nhật Jtable
            Vector header = new Vector();
            header.add("Mã HD");
            header.add("Ngày lập");//tên cột table
            header.add("Tổng tiền");
            if (modelHD.getRowCount() == 0) {
                modelHD = new DefaultTableModel(header, 0);
            }
            //nạp dữ liệu cho mỗi row
            Vector row = new Vector();
            row.add(hd.MaHD);
            row.add(hd.NgayLap);
            row.add(hd.TongTien);
            modelHD.addRow(row); //thêm row dữ liệu vào model
            //nạp du lieu cua model vào jtable
            tblHoaDon.setModel(modelHD);
            //-----------Sau khi ban thì ghi vào chi tiết hoa don------------/
            ChiTietHoaDon_DTO x;
            for (int i = 0; i < cthdbus.dsHoaDon.size(); i++) {
                x = new ChiTietHoaDon_DTO();
                x.MaHD = Integer.parseInt(modelGH.getValueAt(i, 0).toString());
                x.MaSP = modelGH.getValueAt(i, 1).toString();
                x.TenSP = modelGH.getValueAt(i, 2).toString();
                x.SoLuong = Integer.parseInt(modelGH.getValueAt(i, 3).toString());
                x.GiaBan = Float.parseFloat(modelGH.getValueAt(i, 4).toString());
                x.ThanhTien = Float.parseFloat(modelGH.getValueAt(i, 5).toString());
                cthdbus.them(x);
                //cập nhật Jtable
                Vector hea = new Vector();
                hea.add("Mã PN");
                hea.add("Mã SP");//tên cột table
                hea.add("Tên SP");
                hea.add("Số lượng");
                hea.add("Đơn giá");
                hea.add("Thành tiền");
                if (modelCTHD.getRowCount() == 0) {
                    modelCTHD = new DefaultTableModel(header, 0);
                }
                //nạp dữ liệu cho mỗi row
                Vector r = new Vector();
                r.add(x.MaHD);
                r.add(x.MaSP);
                r.add(x.TenSP);
                r.add(x.SoLuong);
                r.add(x.GiaBan);
                r.add(x.ThanhTien);
                modelCTHD.addRow(r); //thêm row dữ liệu vào model
            }
            //nạp du lieu cua model vào jtable
            tblCTHD.setModel(modelCTHD);
            //-----------Sau khi ban thì giam số lượng ở kho sản phẩm-----------/
            TableModel m = tblKho.getModel();
            TableModel mGH = tblGioHang.getModel();
            for (int k = 0; k < ChiTietHoaDon_BUS.dsHoaDon.size(); k++) {
                cthd.MaSP = mGH.getValueAt(k, 1).toString();
                for (int j = 0; j < BanHang_BUS.dssp.size(); j++) {
                    dssp.MaSP = m.getValueAt(j, 0).toString();
                    if (cthd.MaSP.equals(dssp.MaSP)) {
                        cthd.SoLuong = Integer.parseInt(mGH.getValueAt(k, 3).toString());
                        dssp.SoLuong = String.valueOf(Integer.parseInt(m.getValueAt(j, 2).toString()) - cthd.SoLuong);
                        bhbus.SuaSL(dssp);
                        m.setValueAt(dssp.SoLuong, j, 2);
                        tblKho.setModel(m);
                    }
                }
            }
            //-----------Xóa table tạm ở arrayList dsHoaDon------------------/
            ChiTietHoaDon_BUS.dsHoaDon.removeAll(ChiTietHoaDon_BUS.dsHoaDon);
            ((DefaultTableModel) tblGioHang.getModel()).setRowCount(0);
            txtTongPhiNhap.setText("");
            JOptionPane.showMessageDialog(this, "Nhập hàng thành công!");
        } else {
            if (ChiTietHoaDon_BUS.dsHoaDon.size() == 0) {
                JOptionPane.showMessageDialog(this, "Bán hàng thất bại do không có sản phẩm nào trong giỏ hàng");
            }
        }
    }//GEN-LAST:event_btnXuatActionPerformed

    private void cbbNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbNVMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_cbbNVMouseClicked

    private void btnTienThuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTienThuaActionPerformed
        // TODO add your handling code here:
        float x= Float.parseFloat(txtTienKhachDua.getText());
        float y=Float.parseFloat(TienKhachCanTra.getText());
        txtTienThua.setText(String.valueOf(x-y));

    }//GEN-LAST:event_btnTienThuaActionPerformed

    private void btnHienthiTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHienthiTenActionPerformed
        // TODO add your handling code here:
        for(QLNV_DTO nv:nvbus.dsnv){
            if(nv.Ma.equals(cbbNV.getSelectedItem().toString()))
            txtNV.setText(nv.Ho+" "+nv.Ten);
        }
    }//GEN-LAST:event_btnHienthiTenActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        int i = tblHoaDon.getSelectedRow();
        if (i >= 0) {
            hd = hdbus.dshoadon.get(i);
            //--------Hiện bên chi tiết phiếu nhập hàng---------
            txtMaHD.setText(hd.MaHD);
            txtTenKH.setText(hd.TenKH);
            txtNhanVien.setText(hd.TenNV);
            txtNgayLap.setText(hd.NgayLap);
            txtTongTien.setText(hd.TongTien);
            //-------------Hiện danh sách chi tiết sp đã mua khi click vào phiếu bán hàng-------//
            dsKhiClick=new ArrayList<ChiTietHoaDon_DTO>();
            for (ChiTietHoaDon_DTO cthd : ChiTietHoaDon_BUS.dshd) {
                if (String.valueOf(cthd.MaHD).equals(hd.MaHD)) {
                    dsKhiClick.add(cthd);
                }
            }
            showCTHDKhiClick(dsKhiClick);
        }
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void tblCTHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCTHDMouseClicked
        int i = tblCTHD.getSelectedRow();
        if (i >= 0) {
            cthd = ChiTietHoaDon_BUS.dshd.get(i);
            txtMa.setText(cthd.MaSP);
            txtTen.setText(cthd.TenSP);
            txtSL.setText(String.valueOf(cthd.SoLuong));
            txtGia.setText(String.valueOf(cthd.GiaBan));
            txtThanhTien.setText(String.valueOf(cthd.ThanhTien));
            //hiện ảnh
            for (SanPham_DTO sp : BanHang_BUS.dssp) {
                if (sp.MaSP.equals(cthd.MaSP)) {
                    String linkAnh = sp.HinhAnhSP;
                    lbelAnhSP.setIcon(bhbus.ResizeImage(String.valueOf(linkAnh), lbelAnhSP));
                }
            }
        }
    }//GEN-LAST:event_tblCTHDMouseClicked

    private void tblCTHDChiTietCuaHDKhiClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCTHDChiTietCuaHDKhiClick
        int i = tblCTHD.getSelectedRow();
        if (i >= 0) {
            cthd = dsKhiClick.get(i);
            txtMa.setText(cthd.MaSP);
            txtTen.setText(cthd.TenSP);
            txtSL.setText(String.valueOf(cthd.SoLuong));
            txtGia.setText(String.valueOf(cthd.GiaBan));
            txtThanhTien.setText(String.valueOf(cthd.ThanhTien));
            //hiện ảnh
            for (SanPham_DTO sp : BanHang_BUS.dssp) {
                if (sp.MaSP.equals(cthd.MaSP)) {
                    String linkAnh = sp.HinhAnhSP;
                    lbelAnhSP.setIcon(bhbus.ResizeImage(String.valueOf(linkAnh), lbelAnhSP));
                }
            }
        }
    }//GEN-LAST:event_tblCTHDChiTietCuaHDKhiClick

    private void jTextField16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField16ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        tblCTHD.setModel(modelCTHD);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnThoat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoat1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThoat1ActionPerformed

    private void btnLienHe1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLienHe1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLienHe1ActionPerformed

    private void btnHuongDan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuongDan1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHuongDan1ActionPerformed

    public void setTextTenDN(String s) {
        btnDangNhap.setText(s);
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                BH.setVisible(true);
                BH.setLocationRelativeTo(null);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TienKhachCanTra;
    private javax.swing.JToggleButton btnDangNhap;
    private javax.swing.JToggleButton btnDoanhThu;
    private javax.swing.JToggleButton btnDonHang;
    private javax.swing.JButton btnHienthiTen;
    private javax.swing.JToggleButton btnHoTro;
    private javax.swing.JButton btnHuongDan;
    private javax.swing.JButton btnHuongDan1;
    private javax.swing.JToggleButton btnKhachHang;
    private javax.swing.JButton btnLienHe;
    private javax.swing.JButton btnLienHe1;
    private javax.swing.JToggleButton btnNhanVien;
    private javax.swing.JToggleButton btnNhapHang;
    private javax.swing.JToggleButton btnSanPham;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThemGH;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnThoat1;
    private javax.swing.JToggleButton btnThongKe;
    private javax.swing.JButton btnTienThua;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXuat;
    private javax.swing.JToggleButton btnkhuyenMai;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbNV;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JLabel lbelAnh;
    private javax.swing.JLabel lbelAnhSP;
    private javax.swing.JSpinner spnSoLuong;
    private javax.swing.JTable tblCTHD;
    private javax.swing.JTable tblGioHang;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblKho;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtKH;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtNV;
    private javax.swing.JTextField txtNgayLap;
    private javax.swing.JTextField txtNhanVien;
    private javax.swing.JTextField txtSL;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JTextField txtThanhTien;
    private javax.swing.JTextField txtTienKhachDua;
    private javax.swing.JTextField txtTienThua;
    private javax.swing.JTextField txtTongPhiNhap;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables

}
