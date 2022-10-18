/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package icy.GUI;

import ICY.BUS.DangKy_BUS;
import ICY.BUS.QLNV_BUS;
import ICY.DTO.Luong_DTO;
import ICY.DTO.QLNV_DTO;
import icy.GUI.*;
import static icy.GUI.BanHang_GUI.BH;
import static icy.GUI.DangKy.DK;
import static icy.GUI.DangNhap_GUI.DN;
import static icy.GUI.DoanhThu_GUI.DT;
import static icy.GUI.HoSoNV_GUI.HS;
import static icy.GUI.HoTro_GUI.HT;
import static icy.GUI.HuongDan_GUI.HD;
import static icy.GUI.KhachHang_GUI.KH;
import static icy.GUI.KhuyenMai_GUI.KM;
import static icy.GUI.NhapHang_GUI.NH;
import static icy.GUI.SanPham_GUI.SP;
import static icy.GUI.ThongKe_GUI.TK;
import icy.TrangChu_ICY;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.apache.commons.collections4.comparators.ComparableComparator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.Document;

/**
 *
 * @author HP
 */
public class QLNV_GUI extends javax.swing.JFrame {
    public static QLNV_GUI NV = new QLNV_GUI();
    public static QuanLyTK TK = new QuanLyTK();
    static HoSoNV_GUI HS = new HoSoNV_GUI();
    static ArrayList<QLNV_DTO> dsnv = new ArrayList<>();
    static ArrayList<Luong_DTO> dsluong = new ArrayList<>();
    DefaultTableModel model = new DefaultTableModel();
    DefaultTableModel model1 = new DefaultTableModel();
    DefaultTableModel model2 = new DefaultTableModel();
    DefaultTableModel model3 = new DefaultTableModel();
    QLNV_BUS bus = new QLNV_BUS();
    DangKy_BUS busdk = new DangKy_BUS();
    QLNV_DTO nv = new QLNV_DTO();
    String link = "";

    public QLNV_GUI() {
        initComponents();
        DocDuLieu();
        DocDSLUONG();
        panGT.setVisible(false);
        panTuoi.setVisible(false);
        panAndOr.setVisible(false);
        //btnSuaLuong.setVisible(false);
        lbThongbao.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    public void DocDuLieu() {
        QLNV_BUS bus = new QLNV_BUS();
        if (QLNV_BUS.dsnv == null) {
            bus.docDSNV();
        }

        Vector header = new Vector();
        header.add("Mã");
        header.add("Họ");
        header.add("Tên");
        header.add("Giới tính");
        header.add("Chức vụ");
        header.add("Ngày sinh");
        header.add("Địa chỉ");
        header.add("SDT");
        header.add("Email");
        header.add("Lương");
        
        model = new DefaultTableModel(header, 0);
        // }
        for (QLNV_DTO nv : QLNV_BUS.dsnv) {
            Vector row = new Vector();
            row.add(nv.Ma);
            row.add(nv.Ho);
            row.add(nv.Ten);
            row.add(nv.GioiTinh);
            row.add(nv.ChucVu);
            row.add(nv.NgaySinh + "/" + nv.ThangSinh + "/" + nv.NamSinh);
            row.add(nv.DiaChi);
            row.add(nv.SDT);
            row.add(nv.Email);
            //row.add(nv.anh);
            row.add(nv.Luong);
            model.addRow(row);

        }
        table.setModel(model);
    }

    public void DocDSLUONG() {
        QLNV_BUS bus = new QLNV_BUS();
        if (QLNV_BUS.dsluong == null) {
            bus.docDSLUONG();
        }

        Vector header = new Vector();
        header.add("Mã nhân viên");
        header.add("Lương cơ bản");
        header.add("Phụ cấp ăn uống");
        header.add("Phụ cấp xăng xe");
        header.add("Phụ cấp phụ cấp điện thoại");
        header.add("Thưởng");
       // header.add("Ngày vào làm");
        

        //if (model.getRowCount() == 0) {
        model2 = new DefaultTableModel(header, 0);
        // }
        for (Luong_DTO luong : QLNV_BUS.dsluong) {
            Vector row = new Vector();
            row.add(luong.MaNV);
            row.add(luong.LuongCB);
            row.add(luong.PhuCapanUong);
            row.add(luong.PhuCapXangXe);
            row.add(luong.PhuCapDienThoai);
            row.add(luong.thuong);
            model2.addRow(row);

        }
        tableLuong.setModel(model2);
    }

    public ImageIcon ResizeImage(String ImagePath) {
        ImageIcon myIcon = new ImageIcon(ImagePath);
        Image img = myIcon.getImage();
        Image newimg = img.getScaledInstance(lbAnh.getWidth(), lbAnh.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newimg);
        return image;
    }

    public void showDSNV(ArrayList<QLNV_DTO> ds) {
        Vector header = new Vector();
        header.add("Mã ");
        header.add("Họ ");
        header.add("Tên");
        header.add("Giới tính");
        header.add("Chức vụ");
        header.add("Ngày sinh");
        header.add("Địa chỉ ");
        header.add("SDT");
        header.add("Email");
        header.add("Lương");
        if (model1.getRowCount() == 0) {
            model1 = new DefaultTableModel(header, 0);
        }

        for (QLNV_DTO nv : ds) {
            Vector row = new Vector();
            row.add(nv.Ma);
            row.add(nv.Ho);
            row.add(nv.Ten);
            row.add(nv.GioiTinh);
            row.add(nv.ChucVu);
            row.add(nv.NgaySinh + "/" + nv.ThangSinh + "/" + nv.NamSinh);
            row.add(nv.DiaChi);
            row.add(nv.SDT);
            row.add(nv.Email);
            // row.add(nv.Email);

            row.add(String.valueOf(nv.Luong));
            //row.add(nv.anh);
            model1.addRow(row);

        }
        table.setModel(model1);

    }

    public void ShowDSLUONG(ArrayList<Luong_DTO> ds) {

        Vector header = new Vector();
        header.add("Mã nhân viên ");
        header.add("Lương cơ bản ");
        header.add("Phụ cấp ăn uống");
        header.add("Phụ cấp xăng xe");
        header.add("Phụ cấp điện thoại");
        header.add("Thưởng");

        if (model2.getRowCount() == 0) {
            model2 = new DefaultTableModel(header, 0);
        }
        for (Luong_DTO luong : ds) {
            Vector row = new Vector();
            row.add(luong.MaNV);
            row.add(luong.LuongCB);
            row.add(luong.PhuCapanUong);
            row.add(luong.PhuCapXangXe);
            row.add(luong.PhuCapDienThoai);
            row.add(luong.thuong);
            model2.addRow(row);
        }

        tableLuong.setModel(model2);

    }

    public void DSLUONG(ArrayList<Luong_DTO> ds) {

        Vector header = new Vector();
        header.add("Mã nhân viên ");
        header.add("Lương cơ bản ");
        header.add("Phụ cấp ăn uống");
        header.add("Phụ cấp xăng xe");
        header.add("Phụ cấp điện thoại");
        header.add("Thưởng");

        if (model3.getRowCount() == 0) {
            model3 = new DefaultTableModel(header, 0);
        }

        for (Luong_DTO luong : ds) {
            Vector row = new Vector();
            row.add(luong.MaNV);
            row.add(luong.LuongCB);
            row.add(luong.PhuCapanUong);
            row.add(luong.PhuCapXangXe);
            row.add(luong.PhuCapDienThoai);
            row.add(luong.thuong);
            model3.addRow(row);
        }
        tableLuong.setModel(model3);

    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jScrollPane2 = new javax.swing.JScrollPane();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jFrame1 = new javax.swing.JFrame();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        buttonGroup7 = new javax.swing.ButtonGroup();
        buttonGroup8 = new javax.swing.ButtonGroup();
        buttonGroup9 = new javax.swing.ButtonGroup();
        buttonGroup10 = new javax.swing.ButtonGroup();
        buttonGroup11 = new javax.swing.ButtonGroup();
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
        txtTuoiO1 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        txtMa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtHo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        rdbtnNam = new javax.swing.JRadioButton();
        rdbtnNu = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        cbbThang = new javax.swing.JComboBox<>();
        cbbNgay = new javax.swing.JComboBox<>();
        cbbNam = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cbbChucVu = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnInDS = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        cbbTimCB = new javax.swing.JComboBox<>();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        panTuoi = new javax.swing.JPanel();
        txtTu = new javax.swing.JTextField();
        lbDen = new javax.swing.JLabel();
        txtDen = new javax.swing.JTextField();
        lbTu = new javax.swing.JLabel();
        panAndOr = new javax.swing.JPanel();
        rdbtnAND = new javax.swing.JRadioButton();
        rdbtnOR = new javax.swing.JRadioButton();
        panGT = new javax.swing.JPanel();
        rdbtnNuTK = new javax.swing.JRadioButton();
        rdbtnNamTK = new javax.swing.JRadioButton();
        lbTimKiem = new javax.swing.JLabel();
        btnLamMoi = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnThoat = new javax.swing.JButton();
        btnLienHe = new javax.swing.JButton();
        btnHuongDan = new javax.swing.JButton();
        lbAnh = new javax.swing.JLabel();
        btnAnh = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btnTK = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        lbAnhNV = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableLuong = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtLuongCB = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtPhuCapAnUong = new javax.swing.JTextField();
        txtPhuCapXangXe = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtPhuCapDT = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtThuong = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        lbHo = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        lbChucVu = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        lbGT = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnLamMoiLuong = new javax.swing.JButton();
        btnSuaLuong = new javax.swing.JButton();
        btnThemLuong = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        lbThongbao = new javax.swing.JLabel();
        ds = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        btnThoat3 = new javax.swing.JButton();
        btnLienHe3 = new javax.swing.JButton();
        btnHuongDan3 = new javax.swing.JButton();
        Tong = new javax.swing.JLabel();
        lbtongLuong = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jRadioButton4 = new javax.swing.JRadioButton();
        jRadioButton5 = new javax.swing.JRadioButton();
        jPanel10 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        btnThoat2 = new javax.swing.JButton();
        btnLienHe2 = new javax.swing.JButton();
        btnHuongDan2 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        lbAnhNV1 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        btnThem1 = new javax.swing.JButton();
        btnXoa1 = new javax.swing.JButton();
        btnSua1 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
        );

        jPanel2.setBackground(new java.awt.Color(197, 223, 234));

        btnDangNhap.setBackground(new java.awt.Color(255, 204, 204));
        buttonGroup1.add(btnDangNhap);
        btnDangNhap.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDangNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icy/HinhAnh_ICY/TrangChu/NguoiDung.png"))); // NOI18N
        btnDangNhap.setText("Đăng nhập");
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
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.setMinimumSize(new java.awt.Dimension(117, 97));

        txtTuoiO1.setBackground(new java.awt.Color(231, 231, 231));
        txtTuoiO1.setPreferredSize(new java.awt.Dimension(1030, 508));

        jPanel8.setBackground(new java.awt.Color(231, 231, 231));
        jPanel8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtMa.setForeground(new java.awt.Color(204, 204, 204));
        txtMa.setText("Nhập mã");
        txtMa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMaFocusLost(evt);
            }
        });
        txtMa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaActionPerformed(evt);
            }
        });
        txtMa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMaKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Mã");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Họ");

        txtHo.setForeground(new java.awt.Color(204, 204, 204));
        txtHo.setText("Nhập họ");
        txtHo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtHoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtHoFocusLost(evt);
            }
        });
        txtHo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtHoKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Tên");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Giới tính");

        txtTen.setForeground(new java.awt.Color(204, 204, 204));
        txtTen.setText("Nhập tên");
        txtTen.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTenFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTenFocusLost(evt);
            }
        });
        txtTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenActionPerformed(evt);
            }
        });
        txtTen.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTenKeyPressed(evt);
            }
        });

        buttonGroup10.add(rdbtnNam);
        rdbtnNam.setText("Nam");
        rdbtnNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbtnNamActionPerformed(evt);
            }
        });

        buttonGroup10.add(rdbtnNu);
        rdbtnNu.setText("Nữ");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Ngày sinh");

        cbbThang.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        cbbThang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", " " }));
        cbbThang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbbThangKeyPressed(evt);
            }
        });

        cbbNgay.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        cbbNgay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        cbbNgay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbbNgayKeyPressed(evt);
            }
        });

        cbbNam.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        cbbNam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1989", "1999", "2000", "2001" }));
        cbbNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbNamActionPerformed(evt);
            }
        });
        cbbNam.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbbNamKeyPressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Chức vụ");

        cbbChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Giám đốc", "Nhân viên bán hàng", "Quản lý", " ", " " }));
        cbbChucVu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbbChucVuKeyPressed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Địa chỉ");

        txtDiaChi.setForeground(new java.awt.Color(204, 204, 204));
        txtDiaChi.setText("Nhập địa chỉ");
        txtDiaChi.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDiaChiFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDiaChiFocusLost(evt);
            }
        });
        txtDiaChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiaChiActionPerformed(evt);
            }
        });
        txtDiaChi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDiaChiKeyPressed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("SDT");

        txtSDT.setForeground(new java.awt.Color(204, 204, 204));
        txtSDT.setText("Nhập số điện thoại");
        txtSDT.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSDTFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSDTFocusLost(evt);
            }
        });
        txtSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSDTActionPerformed(evt);
            }
        });
        txtSDT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSDTKeyPressed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Email");

        txtEmail.setForeground(new java.awt.Color(204, 204, 204));
        txtEmail.setText("Nhập email");
        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailFocusLost(evt);
            }
        });
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEmailKeyPressed(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(231, 231, 231));
        jPanel7.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(231, 231, 231), new java.awt.Color(231, 231, 231), new java.awt.Color(231, 231, 231), new java.awt.Color(231, 231, 231)));

        btnSua.setBackground(new java.awt.Color(231, 231, 231));
        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icy/HinhAnh_ICY/TrangChu/maintenance.png"))); // NOI18N
        btnSua.setText("SỬA");
        btnSua.setBorder(null);
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(231, 231, 231));
        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icy/HinhAnh_ICY/TrangChu/Xoa1.png"))); // NOI18N
        btnXoa.setText("XÓA");
        btnXoa.setBorder(null);
        btnXoa.setPreferredSize(new java.awt.Dimension(24, 16));
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnInDS.setBackground(new java.awt.Color(231, 231, 231));
        btnInDS.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnInDS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icy/HinhAnh_ICY/TrangChu/printer.png"))); // NOI18N
        btnInDS.setText("XUẤT ");
        btnInDS.setBorder(null);
        btnInDS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInDSActionPerformed(evt);
            }
        });

        btnThem.setBackground(new java.awt.Color(231, 231, 231));
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icy/HinhAnh_ICY/TrangChu/add2.png"))); // NOI18N
        btnThem.setText("THÊM");
        btnThem.setBorder(null);
        btnThem.setPreferredSize(new java.awt.Dimension(24, 16));
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(204, 204, 204));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icy/HinhAnh_ICY/TrangChu/re.png"))); // NOI18N
        jButton3.setBorder(null);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(btnInDS, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInDS, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8))
        );

        jPanel9.setBackground(new java.awt.Color(231, 231, 231));
        jPanel9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(231, 231, 231), new java.awt.Color(231, 231, 231), new java.awt.Color(231, 231, 231), new java.awt.Color(231, 231, 231)));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        jLabel13.setText("Tìm kiếm");

        cbbTimCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã", "Họ", "Tên", "Giới tính", "Độ tuổi", "Chức vụ", "Mã - Chức vụ", " ", " ", " " }));
        cbbTimCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbTimCBActionPerformed(evt);
            }
        });

        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyPressed(evt);
            }
        });

        btnTimKiem.setBackground(new java.awt.Color(204, 204, 204));
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icy/HinhAnh_ICY/TrangChu/tim.png"))); // NOI18N
        btnTimKiem.setBorder(null);
        btnTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTimKiemMouseClicked(evt);
            }
        });
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        panTuoi.setBackground(new java.awt.Color(231, 231, 231));

        lbDen.setBackground(new java.awt.Color(231, 231, 231));
        lbDen.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbDen.setText("Đến");

        lbTu.setBackground(new java.awt.Color(231, 231, 231));
        lbTu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbTu.setText("Từ");

        javax.swing.GroupLayout panTuoiLayout = new javax.swing.GroupLayout(panTuoi);
        panTuoi.setLayout(panTuoiLayout);
        panTuoiLayout.setHorizontalGroup(
            panTuoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panTuoiLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTu, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbDen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDen, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panTuoiLayout.setVerticalGroup(
            panTuoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(panTuoiLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panTuoiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTu)
                    .addComponent(txtTu, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDen)
                    .addComponent(txtDen, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );

        panAndOr.setBackground(new java.awt.Color(231, 231, 231));

        buttonGroup6.add(rdbtnAND);
        rdbtnAND.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        rdbtnAND.setText("AND");
        rdbtnAND.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbtnANDActionPerformed(evt);
            }
        });

        buttonGroup6.add(rdbtnOR);
        rdbtnOR.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        rdbtnOR.setText("OR");
        rdbtnOR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbtnORActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panAndOrLayout = new javax.swing.GroupLayout(panAndOr);
        panAndOr.setLayout(panAndOrLayout);
        panAndOrLayout.setHorizontalGroup(
            panAndOrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panAndOrLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rdbtnAND)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(rdbtnOR)
                .addContainerGap())
        );
        panAndOrLayout.setVerticalGroup(
            panAndOrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panAndOrLayout.createSequentialGroup()
                .addGroup(panAndOrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbtnAND)
                    .addComponent(rdbtnOR, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        panGT.setBackground(new java.awt.Color(231, 231, 231));

        buttonGroup5.add(rdbtnNuTK);
        rdbtnNuTK.setText("Nữ");
        rdbtnNuTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbtnNuTKActionPerformed(evt);
            }
        });

        buttonGroup5.add(rdbtnNamTK);
        rdbtnNamTK.setText("Nam");
        rdbtnNamTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbtnNamTKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panGTLayout = new javax.swing.GroupLayout(panGT);
        panGT.setLayout(panGTLayout);
        panGTLayout.setHorizontalGroup(
            panGTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panGTLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rdbtnNamTK)
                .addGap(18, 18, 18)
                .addComponent(rdbtnNuTK)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        panGTLayout.setVerticalGroup(
            panGTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panGTLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panGTLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbtnNamTK, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdbtnNuTK))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panGT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(panTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(panAndOr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbTimCB, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(cbbTimCB, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panAndOr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panGT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        lbTimKiem.setBackground(new java.awt.Color(255, 255, 204));
        lbTimKiem.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        lbTimKiem.setForeground(new java.awt.Color(255, 0, 0));
        lbTimKiem.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnLamMoi.setBackground(new java.awt.Color(204, 204, 204));
        btnLamMoi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLamMoi.setForeground(new java.awt.Color(255, 255, 255));
        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icy/HinhAnh_ICY/TrangChu/tailai1.png"))); // NOI18N
        btnLamMoi.setBorder(null);
        btnLamMoi.setPreferredSize(new java.awt.Dimension(24, 16));
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(3, 3, 3)
                                .addComponent(rdbtnNam)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdbtnNu))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel8))
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtHo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(27, 27, 27)
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel8Layout.createSequentialGroup()
                                                .addComponent(jLabel11)
                                                .addGap(18, 18, 18)
                                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                                    .addComponent(jLabel10)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel8Layout.createSequentialGroup()
                                                    .addComponent(jLabel9)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(jPanel8Layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addGap(3, 3, 3)
                                                .addComponent(cbbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(cbbThang, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(1, 1, 1)
                                        .addComponent(cbbNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cbbNam, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(212, 212, 212))))
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(4, 4, 4))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtHo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel9)
                                        .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel10)
                                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5)))
                                .addGap(1, 1, 1)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6)
                                        .addComponent(rdbtnNam, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(rdbtnNu))
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel7)
                                            .addComponent(cbbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)))
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(cbbThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel12.setText("QUẢN    LÝ    NHÂN    VIÊN");

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
        btnLienHe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icy/HinhAnh_ICY/TrangChu/LienHe.png"))); // NOI18N
        btnLienHe.setText("Liên hệ");
        btnLienHe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLienHeActionPerformed(evt);
            }
        });

        btnHuongDan.setBackground(new java.awt.Color(204, 204, 204));
        btnHuongDan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHuongDan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icy/HinhAnh_ICY/TrangChu/HuongDan.png"))); // NOI18N
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
                .addComponent(btnThoat)
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
                .addContainerGap(13, Short.MAX_VALUE))
        );

        lbAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icy/HinhAnh_ICY/u1.png"))); // NOI18N

        btnAnh.setBackground(new java.awt.Color(231, 231, 231));
        btnAnh.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        btnAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icy/HinhAnh_ICY/TrangChu/image.png"))); // NOI18N
        btnAnh.setText("CHỌN ẢNH ");
        btnAnh.setBorder(null);
        btnAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnhActionPerformed(evt);
            }
        });

        table.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9"
            }
        ));
        table.setGridColor(new java.awt.Color(0, 153, 255));
        table.setSelectionBackground(new java.awt.Color(153, 204, 255));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
                TimKiemcoBan(evt);
                TimkiemNC(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        btnTK.setBackground(new java.awt.Color(231, 231, 231));
        btnTK.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTK.setForeground(new java.awt.Color(0, 51, 255));
        btnTK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icy/HinhAnh_ICY/TrangChu/next24ps.png"))); // NOI18N
        btnTK.setText("Quản lý tài khoản");
        btnTK.setBorder(null);
        btnTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout txtTuoiO1Layout = new javax.swing.GroupLayout(txtTuoiO1);
        txtTuoiO1.setLayout(txtTuoiO1Layout);
        txtTuoiO1Layout.setHorizontalGroup(
            txtTuoiO1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, txtTuoiO1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(txtTuoiO1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(txtTuoiO1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(txtTuoiO1Layout.createSequentialGroup()
                        .addComponent(btnTK, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(238, 238, 238)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(txtTuoiO1Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(20, 20, 20))
                    .addGroup(txtTuoiO1Layout.createSequentialGroup()
                        .addGroup(txtTuoiO1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(txtTuoiO1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(btnAnh))
                            .addComponent(lbAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1)
                        .addGap(14, 14, 14))))
        );
        txtTuoiO1Layout.setVerticalGroup(
            txtTuoiO1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtTuoiO1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(txtTuoiO1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTK, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(txtTuoiO1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(txtTuoiO1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(lbAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAnh))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jTabbedPane1.addTab("Thông tin nhân viên", txtTuoiO1);

        jPanel6.setBackground(new java.awt.Color(225, 225, 225));

        lbAnhNV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icy/HinhAnh_ICY/u1.png"))); // NOI18N

        tableLuong.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tableLuong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã NV", "Lương cơ bản", "Phụ cấp ăn uống", "Phụ cấp xăng xe", "Phụ cấp điện thoại", "Thưởng"
            }
        ));
        tableLuong.setGridColor(new java.awt.Color(0, 204, 255));
        tableLuong.setSelectionBackground(new java.awt.Color(153, 204, 255));
        tableLuong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableLuongMouseClicked(evt);
                DSLuongM(evt);
            }
        });
        jScrollPane3.setViewportView(tableLuong);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setText("Mã Nhân viên");

        txtMaNV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMaNVKeyPressed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setText("Lương cơ bản");

        txtLuongCB.setForeground(new java.awt.Color(204, 204, 204));
        txtLuongCB.setText("Nhập lương cơ bản");
        txtLuongCB.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtLuongCBFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtLuongCBFocusLost(evt);
            }
        });
        txtLuongCB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLuongCBKeyPressed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setText("Phụ cấp ăn uống");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setText("Phụ cấp xăng xe");

        txtPhuCapAnUong.setForeground(new java.awt.Color(204, 204, 204));
        txtPhuCapAnUong.setText("Nhập phụ cấp ăn uống");
        txtPhuCapAnUong.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPhuCapAnUongFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPhuCapAnUongFocusLost(evt);
            }
        });
        txtPhuCapAnUong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPhuCapAnUongKeyPressed(evt);
            }
        });

        txtPhuCapXangXe.setForeground(new java.awt.Color(204, 204, 204));
        txtPhuCapXangXe.setText("Nhập phụ cấp xăng xe");
        txtPhuCapXangXe.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPhuCapXangXeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPhuCapXangXeFocusLost(evt);
            }
        });
        txtPhuCapXangXe.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPhuCapXangXeKeyPressed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setText("Phụ cấp điện thoại");

        txtPhuCapDT.setForeground(new java.awt.Color(204, 204, 204));
        txtPhuCapDT.setText("Nhập phụ cấp điện thoại");
        txtPhuCapDT.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPhuCapDTFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPhuCapDTFocusLost(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setText("Thưởng");

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel22.setText("Họ tên : ");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel26.setText("Chức vụ :");

        lbChucVu.setBackground(new java.awt.Color(255, 255, 255));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel28.setText("Giới tính :");

        jPanel5.setBackground(new java.awt.Color(231, 231, 231));

        btnLamMoiLuong.setBackground(new java.awt.Color(231, 231, 231));
        btnLamMoiLuong.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLamMoiLuong.setForeground(new java.awt.Color(255, 255, 255));
        btnLamMoiLuong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icy/HinhAnh_ICY/TrangChu/tailai1.png"))); // NOI18N
        btnLamMoiLuong.setBorder(null);
        btnLamMoiLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiLuongActionPerformed(evt);
            }
        });

        btnSuaLuong.setBackground(new java.awt.Color(231, 231, 231));
        btnSuaLuong.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSuaLuong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icy/HinhAnh_ICY/TrangChu/maintenance.png"))); // NOI18N
        btnSuaLuong.setText("SỬA");
        btnSuaLuong.setBorder(null);
        btnSuaLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaLuongActionPerformed(evt);
            }
        });

        btnThemLuong.setBackground(new java.awt.Color(231, 231, 231));
        btnThemLuong.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThemLuong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icy/HinhAnh_ICY/TrangChu/add2.png"))); // NOI18N
        btnThemLuong.setText("THÊM");
        btnThemLuong.setBorder(null);
        btnThemLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemLuongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnLamMoiLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(btnSuaLuong)
                .addGap(31, 31, 31)
                .addComponent(btnThemLuong)
                .addGap(15, 15, 15))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLamMoiLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnThemLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSuaLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        lbThongbao.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbThongbao.setForeground(new java.awt.Color(255, 0, 0));
        lbThongbao.setText("Vui lòng thêm chi tiết cho nhân viên này");

        ds.setBackground(new java.awt.Color(231, 231, 231));
        ds.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ds.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icy/HinhAnh_ICY/TrangChu/re.png"))); // NOI18N
        ds.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dsActionPerformed(evt);
            }
        });

        jPanel15.setBackground(new java.awt.Color(197, 223, 234));

        btnThoat3.setBackground(new java.awt.Color(204, 204, 204));
        btnThoat3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThoat3.setText("Thoát");
        btnThoat3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoat3ActionPerformed(evt);
            }
        });

        btnLienHe3.setBackground(new java.awt.Color(204, 204, 204));
        btnLienHe3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLienHe3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icy/HinhAnh_ICY/TrangChu/LienHe.png"))); // NOI18N
        btnLienHe3.setText("Liên hệ");
        btnLienHe3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLienHe3ActionPerformed(evt);
            }
        });

        btnHuongDan3.setBackground(new java.awt.Color(204, 204, 204));
        btnHuongDan3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHuongDan3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icy/HinhAnh_ICY/TrangChu/HuongDan.png"))); // NOI18N
        btnHuongDan3.setText("Hướng dẫn");
        btnHuongDan3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuongDan3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnHuongDan3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLienHe3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnThoat3)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThoat3)
                    .addComponent(btnLienHe3)
                    .addComponent(btnHuongDan3))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        Tong.setFont(new java.awt.Font("Segoe UI", 3, 16)); // NOI18N
        Tong.setText("Tổng Lương:");

        lbtongLuong.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lbtongLuong.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel25.setText("Lọc:");

        buttonGroup9.add(jRadioButton4);
        jRadioButton4.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jRadioButton4.setText("Từ bé đến lớn");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        buttonGroup9.add(jRadioButton5);
        jRadioButton5.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jRadioButton5.setText("Từ lớn đến bé");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(lbAnhNV, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addGap(35, 35, 35)
                                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(lbHo, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                                        .addComponent(jLabel28)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(lbGT, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addGap(38, 38, 38)
                                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel22)
                                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                                        .addComponent(jLabel26)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(lbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addComponent(ds, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbThongbao, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(jLabel25)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jRadioButton4)))
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel15)
                                                .addComponent(jLabel14))
                                            .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addComponent(jLabel16)
                                                .addGap(25, 25, 25)
                                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(txtPhuCapAnUong, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(txtLuongCB, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(29, 29, 29)
                                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                            .addGroup(jPanel6Layout.createSequentialGroup()
                                                                .addComponent(jLabel17)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(txtPhuCapXangXe, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(jPanel6Layout.createSequentialGroup()
                                                                .addComponent(jLabel18)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(txtPhuCapDT, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(jPanel6Layout.createSequentialGroup()
                                                                .addComponent(jLabel19)
                                                                .addGap(64, 64, 64)
                                                                .addComponent(txtThuong))))
                                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                                        .addComponent(Tong)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(lbtongLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addGap(0, 19, Short.MAX_VALUE))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jRadioButton5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jScrollPane3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20))
                    .addComponent(jPanel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel17)
                                .addComponent(txtPhuCapXangXe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel14)
                                .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtLuongCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18)
                                    .addComponent(txtPhuCapDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19)
                                    .addComponent(txtThuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPhuCapAnUong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel16)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Tong)
                            .addComponent(lbtongLuong))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22)
                                    .addComponent(lbHo, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel26)
                                    .addComponent(lbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(lbGT, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel28))))
                            .addComponent(lbAnhNV, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ds)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbThongbao, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel25)
                                .addComponent(jRadioButton4)
                                .addComponent(jRadioButton5)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Chi tiết nhân viên", jPanel6);

        jPanel13.setBackground(new java.awt.Color(197, 223, 234));

        btnThoat2.setBackground(new java.awt.Color(204, 204, 204));
        btnThoat2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThoat2.setText("Thoát");
        btnThoat2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoat2ActionPerformed(evt);
            }
        });

        btnLienHe2.setBackground(new java.awt.Color(204, 204, 204));
        btnLienHe2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLienHe2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icy/HinhAnh_ICY/TrangChu/LienHe.png"))); // NOI18N
        btnLienHe2.setText("Liên hệ");
        btnLienHe2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLienHe2ActionPerformed(evt);
            }
        });

        btnHuongDan2.setBackground(new java.awt.Color(204, 204, 204));
        btnHuongDan2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHuongDan2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icy/HinhAnh_ICY/TrangChu/HuongDan.png"))); // NOI18N
        btnHuongDan2.setText("Hướng dẫn");
        btnHuongDan2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuongDan2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnHuongDan2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLienHe2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnThoat2)
                .addGap(21, 21, 21))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThoat2)
                    .addComponent(btnLienHe2)
                    .addComponent(btnHuongDan2))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        lbAnhNV1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icy/HinhAnh_ICY/myly 2.jpg"))); // NOI18N

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel23.setText("Họ tên : ");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel21.setText("Mã Nhân viên");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel29.setText("Giới tính :");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel27.setText("Chức vụ :");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel30.setText("Mã ca làm:");

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel31.setText("Ngày làm");

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel32.setText("Buổi:");

        jPanel14.setBackground(new java.awt.Color(231, 231, 231));
        jPanel14.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnThem1.setBackground(new java.awt.Color(231, 231, 231));
        btnThem1.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        btnThem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icy/HinhAnh_ICY/TrangChu/add2.png"))); // NOI18N
        btnThem1.setText("THÊM");
        btnThem1.setBorder(null);
        btnThem1.setPreferredSize(new java.awt.Dimension(24, 16));
        btnThem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem1ActionPerformed(evt);
            }
        });

        btnXoa1.setBackground(new java.awt.Color(231, 231, 231));
        btnXoa1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnXoa1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icy/HinhAnh_ICY/TrangChu/Xoa1.png"))); // NOI18N
        btnXoa1.setText("XÓA");
        btnXoa1.setBorder(null);
        btnXoa1.setPreferredSize(new java.awt.Dimension(24, 16));
        btnXoa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoa1ActionPerformed(evt);
            }
        });

        btnSua1.setBackground(new java.awt.Color(231, 231, 231));
        btnSua1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSua1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icy/HinhAnh_ICY/TrangChu/maintenance.png"))); // NOI18N
        btnSua1.setText("SỬA");
        btnSua1.setBorder(null);
        btnSua1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSua1ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(231, 231, 231));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icy/HinhAnh_ICY/TrangChu/re.png"))); // NOI18N
        jButton6.setText("FRESH");
        jButton6.setBorder(null);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThem1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSua1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSua1, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                    .addComponent(btnThem1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnXoa1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTextField1.setText("jTextField1");

        jTextField2.setText("jTextField2");

        jTextField3.setText("jTextField3");

        jTextField4.setText("jTextField4");

        jTextField5.setText("jTextField5");

        jTextField6.setText("jTextField6");

        jTextField7.setText("jTextField7");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        jLabel24.setText("LỌC:");

        jRadioButton1.setText("Ca chiều");

        jRadioButton2.setText("Ca sáng");

        jRadioButton3.setText("Ca tối");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbAnhNV1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addGap(35, 35, 35)
                        .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(jLabel29)
                            .addComponent(jLabel27))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2)
                            .addComponent(jTextField3)
                            .addComponent(jTextField4))))
                .addGap(22, 22, 22)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31)
                            .addComponent(jLabel32)
                            .addComponent(jLabel24))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(31, 31, 31))
                                .addGroup(jPanel12Layout.createSequentialGroup()
                                    .addComponent(jTextField6)
                                    .addGap(30, 30, 30)))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jRadioButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jRadioButton3)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbAnhNV1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel12Layout.createSequentialGroup()
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel23)
                                .addComponent(jLabel30)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(9, 9, 9)
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel21)
                                .addComponent(jLabel31)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(9, 9, 9)
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel29)
                                .addComponent(jLabel32)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(9, 9, 9)
                            .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel27)
                                    .addComponent(jLabel24))
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jRadioButton2)
                                    .addComponent(jRadioButton1)
                                    .addComponent(jRadioButton3))))))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setGridColor(new java.awt.Color(0, 153, 204));
        jTable1.setSelectionBackground(new java.awt.Color(153, 204, 255));
        jScrollPane4.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 986, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 21, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Ca làm", jPanel10);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 5, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed
        if (btnDangNhap.getText().equals("Đăng nhập")) {
            DN.setVisible(true);
        } else {
            HS.setVisible(true);
            HS.setLocationRelativeTo(null);
        }
        for (QLNV_DTO nv : bus.dsnv) {
            if (btnDangNhap.getText().equals(nv.Ten)) {
                HS.setTextEmail(nv.Email);
                HS.setTextDiaChi(nv.DiaChi);
                HS.setTextTen(nv.Ho+" "+nv.Ten);
                HS.setTextGT(nv.GioiTinh);
                HS.setTextMaNV(nv.Ma);
                HS.setTextChucVu(nv.ChucVu);
                HS.setTextAnh(nv.anh);
                HS.setTextNgaySinh(nv.NgaySinh+"/"+nv.ThangSinh+"/"+nv.NamSinh);
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
                NV.setVisible(false);
                SP.setVisible(true);
                SP.setLocationRelativeTo(null);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Bạn không được sử dụng chức năng này!");
        }
    }//GEN-LAST:event_btnSanPhamActionPerformed

    private void tabpaneTrangChuAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tabpaneTrangChuAncestorAdded
        if (btnSanPham.isSelected() == true) {
            //tabpaneTrangChu
        }
    }//GEN-LAST:event_tabpaneTrangChuAncestorAdded

    private void btnkhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkhuyenMaiActionPerformed
        if (!btnDangNhap.getText().equals(" Đăng nhập")) {
            if (btnkhuyenMai.isSelected() == true) {
                NV.setVisible(false);
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
                NV.setVisible(false);
                KH.setVisible(true);
                KH.setLocationRelativeTo(null);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Bạn không được sử dụng chức năng này!");
        }
    }//GEN-LAST:event_btnKhachHangActionPerformed

    private void btnDonHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDonHangActionPerformed
        if (!btnDangNhap.getText().equals(" Đăng nhập")) {
            if (btnDonHang.isSelected() == true) {
                NV.setVisible(false);
                BH.setVisible(true);
                BH.setLocationRelativeTo(null);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Bạn không được sử dụng chức năng này!");
        }
    }//GEN-LAST:event_btnDonHangActionPerformed

    private void btnNhapHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapHangActionPerformed
        if (!btnDangNhap.getText().equals(" Đăng nhập") && checkQuyenQLGD() == true) {
            if (btnNhapHang.isSelected() == true) {
                NV.setVisible(false);
                NH.setVisible(true);
                NH.setLocationRelativeTo(null);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Bạn không được sử dụng chức năng này!");
        }
    }//GEN-LAST:event_btnNhapHangActionPerformed

    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeActionPerformed
        if (!btnDangNhap.getText().equals(" Đăng nhập") && checkQuyenQLGD() == true) {
            if (btnThongKe.isSelected() == true) {
                NV.setVisible(false);
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
                NV.setVisible(false);
                HT.setVisible(true);
                HT.setLocationRelativeTo(null);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Bạn không được sử dụng chức năng này!");
        }
    }//GEN-LAST:event_btnHoTroActionPerformed

    private void btnNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhanVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNhanVienActionPerformed

    private void dsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dsActionPerformed
        btnSuaLuong.setVisible(true);
        if (QLNV_BUS.DSLuongM != null) {
            QLNV_BUS.DSLuongM.clear();
        }
        for (int i = model2.getRowCount() - 1; i >= 0; i--) {

            model2.removeRow(i);
        }
        ShowDSLUONG(bus.dsluong);
        lbAnhNV.setIcon(ResizeImage("C:\\IDE java\\NetBeans-13\\JaVa\\ICYCos\\src\\icy\\HinhAnh_ICY\\AnhNV\\login3.PNG"));
        lbHo.setText("");
        lbChucVu.setText("");
        lbGT.setText("");
    }//GEN-LAST:event_dsActionPerformed

    private void btnThemLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemLuongActionPerformed
        btnSuaLuong.setVisible(true);
        Luong_DTO luong = new Luong_DTO();
        luong.MaNV = txtMaNV.getText();
        luong.PhuCapXangXe = txtPhuCapXangXe.getText();
        luong.PhuCapanUong = txtPhuCapAnUong.getText();
        luong.PhuCapDienThoai = txtPhuCapDT.getText();
        luong.LuongCB = txtLuongCB.getText();
        luong.thuong = txtThuong.getText();
        if(!txtMa.getText().equals(txtMaNV.getText()))
        JOptionPane.showConfirmDialog(this, "Mã nhân viên không tồn tại,xin vui lòng kiểm tra lại thông tin!!!");
        else if(bus.KtrIDLuong(txtMaNV.getText())==false){
            JOptionPane.showConfirmDialog(this, "Mã nhân viên không hợp lệ!!!");
        }
        else{
            bus.ThemLuong(luong);
            dsluong.add(luong);
            ShowDSLUONG(bus.dsluong);
            JOptionPane.showConfirmDialog(this, "Thêm thành công");

        }
    }//GEN-LAST:event_btnThemLuongActionPerformed

    private void btnSuaLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaLuongActionPerformed
        // TODO add your handling code here:
        //dieu kien
        Luong_DTO luong = new Luong_DTO();
        luong.MaNV = txtMaNV.getText();
        luong.LuongCB = txtLuongCB.getText();
        luong.PhuCapanUong = txtPhuCapAnUong.getText();
        luong.PhuCapXangXe = txtPhuCapAnUong.getText();
        luong.PhuCapDienThoai = txtPhuCapDT.getText();
        luong.thuong = txtThuong.getText();
        bus.suaLuong(luong);
        Luong_DTO old = bus.dsluong.set(tableLuong.getSelectedRow(), luong);
        model2.setValueAt(luong.MaNV, tableLuong.getSelectedRow(), 0);
        model2.setValueAt(luong.LuongCB, tableLuong.getSelectedRow(), 1);
        model2.setValueAt(luong.PhuCapanUong, tableLuong.getSelectedRow(), 2);
        model2.setValueAt(luong.PhuCapXangXe, tableLuong.getSelectedRow(), 3);
        model2.setValueAt(luong.PhuCapDienThoai, tableLuong.getSelectedRow(), 4);
        model2.setValueAt(luong.thuong, tableLuong.getSelectedRow(), 5);
        tableLuong.setModel(model2);

        JOptionPane.showConfirmDialog(null, "Sửa thành công");
        txtMaNV.setText("");
        txtPhuCapAnUong.setText("");
        txtPhuCapXangXe.setText("");
        txtPhuCapDT.setText("");
        txtLuongCB.setText("");
    }//GEN-LAST:event_btnSuaLuongActionPerformed

    private void btnLamMoiLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiLuongActionPerformed
        // TODO add your handling code here:
        // tableLuong.setModel(model2);
        txtMaNV.setText("");
        txtLuongCB.setText("");
        txtPhuCapAnUong.setText("");
        txtPhuCapXangXe.setText("");
        txtPhuCapDT.setText("");
        txtThuong.setText("");
    }//GEN-LAST:event_btnLamMoiLuongActionPerformed

    private void txtPhuCapDTFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPhuCapDTFocusLost
        // TODO add your handling code here:
        if (txtPhuCapDT.getText().trim().equals("") || txtPhuCapAnUong.getText().trim().toLowerCase().equals("nhập phụ cấp điện thoại")) {
            txtPhuCapDT.setText("Nhập phụ cấp điện thoại");
            txtPhuCapDT.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtPhuCapDTFocusLost

    private void txtPhuCapDTFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPhuCapDTFocusGained
        // TODO add your handling code here:
        if (txtPhuCapDT.getText().trim().toLowerCase().equals("nhập phụ cấp điện thoại")) {
            txtPhuCapDT.setText("");
        }
        txtPhuCapDT.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_txtPhuCapDTFocusGained

    private void txtPhuCapXangXeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhuCapXangXeKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtPhuCapDT.requestFocus();
        }
    }//GEN-LAST:event_txtPhuCapXangXeKeyPressed

    private void txtPhuCapXangXeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPhuCapXangXeFocusLost
        // TODO add your handling code here:
        if (txtPhuCapXangXe.getText().trim().equals("") || txtPhuCapAnUong.getText().trim().toLowerCase().equals("nhập phụ cấp xăng xe")) {
            txtPhuCapXangXe.setText("Nhập phụ cấp xăng xe");
            txtPhuCapXangXe.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtPhuCapXangXeFocusLost

    private void txtPhuCapXangXeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPhuCapXangXeFocusGained
        // TODO add your handling code here:
        if (txtPhuCapXangXe.getText().trim().toLowerCase().equals("nhập phụ cấp xăng xe")) {
            txtPhuCapXangXe.setText("");
        }
        txtPhuCapXangXe.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_txtPhuCapXangXeFocusGained

    private void txtPhuCapAnUongKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPhuCapAnUongKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtPhuCapXangXe.requestFocus();
        }
    }//GEN-LAST:event_txtPhuCapAnUongKeyPressed

    private void txtPhuCapAnUongFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPhuCapAnUongFocusLost
        // TODO add your handling code here:
        if (txtPhuCapAnUong.getText().trim().equals("") || txtPhuCapAnUong.getText().trim().toLowerCase().equals("nhập phụ cấp ăn uống")) {
            txtPhuCapAnUong.setText("Nhập phụ cấp ăn uống");
            txtPhuCapAnUong.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtPhuCapAnUongFocusLost

    private void txtPhuCapAnUongFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPhuCapAnUongFocusGained
        // TODO add your handling code here:
        if (txtPhuCapAnUong.getText().trim().toLowerCase().equals("nhập phụ cấp ăn uống")) {
            txtPhuCapAnUong.setText("");
        }
        txtPhuCapAnUong.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_txtPhuCapAnUongFocusGained

    private void txtLuongCBKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLuongCBKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtPhuCapAnUong.requestFocus();
        }
    }//GEN-LAST:event_txtLuongCBKeyPressed

    private void txtLuongCBFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLuongCBFocusLost
        // TODO add your handling code here:
        if (txtLuongCB.getText().trim().equals("") || txtLuongCB.getText().trim().toLowerCase().equals("nhập lương cơ bản")) {
            txtLuongCB.setText("Nhập lương cơ bản");
            txtLuongCB.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtLuongCBFocusLost

    private void txtLuongCBFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtLuongCBFocusGained
        // TODO add your handling code here:]
        if (txtLuongCB.getText().trim().toLowerCase().equals("nhập lương cơ bản")) {
            txtLuongCB.setText("");
        }
        txtLuongCB.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_txtLuongCBFocusGained

    private void txtMaNVKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaNVKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtLuongCB.requestFocus();
        }
    }//GEN-LAST:event_txtMaNVKeyPressed

    private void tableLuongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableLuongMouseClicked
        txtMaNV.setForeground(new Color(0, 0, 0));
        txtPhuCapAnUong.setForeground(new Color(0, 0, 0));
        txtPhuCapDT.setForeground(new Color(0, 0, 0));
        txtPhuCapXangXe.setForeground(new Color(0, 0, 0));
        txtThuong.setForeground(new Color(0, 0, 0));
        txtLuongCB.setForeground(new Color(0, 0, 0));
        int i = tableLuong.getSelectedRow();
        if (i >= 0) {
            Luong_DTO luong = new Luong_DTO();
            luong = bus.dsluong.get(i);
            txtLuongCB.setText(luong.LuongCB);
            txtPhuCapAnUong.setText(luong.PhuCapanUong);
            txtPhuCapDT.setText(luong.PhuCapDienThoai);
            txtThuong.setText(luong.thuong);
            txtPhuCapXangXe.setText(luong.PhuCapXangXe);
            txtMaNV.setText(luong.MaNV);
            lbtongLuong.setText(String.valueOf(Integer.parseInt(luong.LuongCB)+Integer.parseInt(luong.PhuCapDienThoai)+Integer.parseInt(luong.PhuCapXangXe)+Integer.parseInt(luong.PhuCapanUong)+Integer.parseInt(luong.thuong)));
            for (QLNV_DTO nv : bus.dsnv) {
                if (nv.Ma.equals(luong.MaNV)) {
                    lbAnhNV.setIcon(ResizeImage(String.valueOf(nv.anh)));
                    lbChucVu.setText(nv.ChucVu);
                    lbHo.setText(nv.Ho + " " + nv.Ten);
                    lbGT.setText(nv.GioiTinh);
                }
            }
        }
    }//GEN-LAST:event_tableLuongMouseClicked

    private void DSLuongM(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DSLuongM
        // TODO add your handling code here:
        txtMa.setForeground(new Color(0, 0, 0));
        txtHo.setForeground(new Color(0, 0, 0));
        txtTen.setForeground(new Color(0, 0, 0));
        txtSDT.setForeground(new Color(0, 0, 0));
        txtDiaChi.setForeground(new Color(0, 0, 0));
        txtEmail.setForeground(new Color(0, 0, 0));
        txtMaNV.setForeground(new Color(0, 0, 0));
        txtPhuCapAnUong.setForeground(new Color(0, 0, 0));
        txtPhuCapDT.setForeground(new Color(0, 0, 0));
        txtPhuCapXangXe.setForeground(new Color(0, 0, 0));
        txtThuong.setForeground(new Color(0, 0, 0));
        txtLuongCB.setForeground(new Color(0, 0, 0));
        int i = tableLuong.getSelectedRow();
        int d = 0;
        if (i >= 0) {
            Luong_DTO luong = new Luong_DTO();
            luong = bus.DSLuongM.get(i);
            for (QLNV_DTO nv : bus.dsnv) {
                for (Luong_DTO luong1 : bus.DSLuongM) {
                    if (nv.Ma.equals(luong.MaNV)) {
                        lbHo.setText(nv.Ho + " " + nv.Ten);
                        lbChucVu.setText(nv.ChucVu);
                        lbGT.setText(nv.GioiTinh);
                        txtLuongCB.setText(luong1.LuongCB);
                        txtPhuCapAnUong.setText(luong1.PhuCapanUong);
                        txtPhuCapDT.setText(luong1.PhuCapDienThoai);
                        txtPhuCapXangXe.setText(luong1.PhuCapXangXe);
                        txtThuong.setText(luong1.thuong);
                        txtMaNV.setText(luong1.MaNV);
                        lbAnhNV.setIcon(ResizeImage(String.valueOf(nv.anh)));
                        lbtongLuong.setText(String.valueOf(Integer.parseInt(luong.LuongCB)+Integer.parseInt(luong.PhuCapDienThoai)+Integer.parseInt(luong.PhuCapXangXe)+Integer.parseInt(luong.PhuCapanUong)+Integer.parseInt(luong.thuong)));

                    }

                }
            }
        }
    }//GEN-LAST:event_DSLuongM

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        txtMa.setText("");
        txtHo.setText("");
        txtTen.setText("");
        txtDiaChi.setText("");
        txtSDT.setText("");
        txtEmail.setText("");
        lbAnh.setIcon(ResizeImage("C:\\Users\\Quan Phat Vinh Thanh\\Documents\\NetBeansProjects\\sql\\src\\icy\\HinhAnh_ICY\\u1.PNG"));
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        btnSuaLuong.setVisible(false);
        txtMa.setForeground(new Color(0, 0, 0));
        txtHo.setForeground(new Color(0, 0, 0));
        txtTen.setForeground(new Color(0, 0, 0));
        txtSDT.setForeground(new Color(0, 0, 0));
        txtDiaChi.setForeground(new Color(0, 0, 0));
        txtEmail.setForeground(new Color(0, 0, 0));
        txtMaNV.setForeground(new Color(0, 0, 0));
        txtPhuCapAnUong.setForeground(new Color(0, 0, 0));
        txtPhuCapDT.setForeground(new Color(0, 0, 0));
        txtPhuCapXangXe.setForeground(new Color(0, 0, 0));
        txtThuong.setForeground(new Color(0, 0, 0));
        txtLuongCB.setForeground(new Color(0, 0, 0));
        int i = table.getSelectedRow();
        if (i >= 0) {
            QLNV_DTO nv = new QLNV_DTO();
            nv = bus.dsnv.get(i);
            bus.DSLuongM = bus.DSLUONG(nv.Ma);
            for (int j = model2.getRowCount() - 1; j >= 0; j--) {
                model2.removeRow(j);
            }
            ShowDSLUONG(bus.DSLuongM);
            txtMa.setText(nv.Ma);
            txtHo.setText(nv.Ho);
            txtTen.setText(nv.Ten);
            if (nv.GioiTinh.equals("Nữ")) {
                rdbtnNu.setSelected(true);
            } else {
                rdbtnNam.setSelected(true);
            }
            cbbChucVu.setSelectedItem(nv.ChucVu);
            cbbNgay.setSelectedItem(nv.NgaySinh);
            cbbThang.setSelectedItem(nv.ThangSinh);
            cbbNam.setSelectedItem(nv.NamSinh);
            txtDiaChi.setText(nv.DiaChi);
            txtSDT.setText(nv.SDT);
            txtEmail.setText(nv.Email);
            link = nv.anh;
            lbAnh.setIcon(ResizeImage(String.valueOf(link)));
            lbHo.setText(nv.Ho + " " + nv.Ten);
            lbAnhNV.setIcon(ResizeImage(String.valueOf(link)));
            lbChucVu.setText(nv.ChucVu);
            lbGT.setText(nv.GioiTinh);

            for (Luong_DTO luong : bus.dsluong) {

                if (nv.Ma.equals(luong.MaNV)) {
                    txtLuongCB.setText(luong.LuongCB);
                    txtMaNV.setText(nv.Ma);
                    txtPhuCapAnUong.setText(luong.PhuCapanUong);
                    txtPhuCapXangXe.setText(luong.PhuCapXangXe);
                    txtPhuCapDT.setText(luong.PhuCapDienThoai);
                    txtThuong.setText(luong.thuong);
                    lbtongLuong.setText(String.valueOf(Integer.parseInt(luong.LuongCB)+Integer.parseInt(luong.PhuCapDienThoai)+Integer.parseInt(luong.PhuCapXangXe)+Integer.parseInt(luong.PhuCapanUong)+Integer.parseInt(luong.thuong)));

                }

            }

        }
        if(bus.DSLuongM.size()==0){
            lbThongbao.setVisible(true);
            txtPhuCapAnUong.setText("");
            txtPhuCapDT.setText("");
            txtPhuCapXangXe.setText("");
            txtThuong.setText("");
            txtLuongCB.setText("");
            txtMaNV.setText(txtMa.getText());
        }
    }//GEN-LAST:event_tableMouseClicked

    private void TimKiemcoBan(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TimKiemcoBan
        txtMa.setForeground(new Color(0, 0, 0));
        txtHo.setForeground(new Color(0, 0, 0));
        txtTen.setForeground(new Color(0, 0, 0));
        txtSDT.setForeground(new Color(0, 0, 0));
        txtDiaChi.setForeground(new Color(0, 0, 0));
        txtEmail.setForeground(new Color(0, 0, 0));
        //txtLuong.setForeground(new Color(0, 0, 0));
        txtMaNV.setForeground(new Color(0, 0, 0));
        txtPhuCapAnUong.setForeground(new Color(0, 0, 0));
        txtPhuCapDT.setForeground(new Color(0, 0, 0));
        txtPhuCapXangXe.setForeground(new Color(0, 0, 0));
        txtThuong.setForeground(new Color(0, 0, 0));
        txtLuongCB.setForeground(new Color(0, 0, 0));
        int i = table.getSelectedRow();
        if (i >= 0) {
            QLNV_DTO nv = new QLNV_DTO();
            nv = bus.kq.get(i);
            bus.DSLuongM = bus.DSLUONG(nv.Ma);
            for (int j = model2.getRowCount() - 1; j >= 0; j--) {
                model2.removeRow(j);
            }
            ShowDSLUONG(bus.DSLuongM);
            txtMa.setText(nv.Ma);
            txtHo.setText(nv.Ho);
            txtTen.setText(nv.Ten);
            if (nv.GioiTinh.equals("Nữ")) {
                rdbtnNu.setSelected(true);
            } else {
                rdbtnNam.setSelected(true);
                // rdbtnNu.setSelected(false);
            }
            cbbChucVu.setSelectedItem(nv.ChucVu);
            cbbNgay.setSelectedItem(nv.NgaySinh);
            cbbThang.setSelectedItem(nv.ThangSinh);
            cbbNam.setSelectedItem(nv.NamSinh);
            txtDiaChi.setText(nv.DiaChi);
            txtSDT.setText(nv.SDT);
            txtEmail.setText(nv.Email);
            //txtLuong.setText(String.valueOf(nv.Luong));
            link = nv.anh;
            lbAnh.setIcon(ResizeImage(String.valueOf(link)));
            lbHo.setText(nv.Ho + " " + nv.Ten);

            lbAnhNV.setIcon(ResizeImage(String.valueOf(link)));
            lbChucVu.setText(nv.ChucVu);
            lbGT.setText(nv.GioiTinh);
            for (Luong_DTO luong : bus.dsluong) {
                if (nv.Ma.equals(luong.MaNV)) {
                    txtLuongCB.setText(luong.LuongCB);
                    txtMaNV.setText(luong.MaNV);
                    txtPhuCapAnUong.setText(luong.PhuCapanUong);
                    txtPhuCapXangXe.setText(luong.PhuCapXangXe);
                    txtPhuCapDT.setText(luong.PhuCapDienThoai);
                    txtThuong.setText(luong.thuong);
                }
            }
        }
    }//GEN-LAST:event_TimKiemcoBan

    private void TimkiemNC(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TimkiemNC
        txtMa.setForeground(new Color(0, 0, 0));
        txtHo.setForeground(new Color(0, 0, 0));
        txtTen.setForeground(new Color(0, 0, 0));
        txtSDT.setForeground(new Color(0, 0, 0));
        txtDiaChi.setForeground(new Color(0, 0, 0));
        txtEmail.setForeground(new Color(0, 0, 0));
        //txtLuong.setForeground(new Color(0, 0, 0));
        txtMaNV.setForeground(new Color(0, 0, 0));
        txtPhuCapAnUong.setForeground(new Color(0, 0, 0));
        txtPhuCapDT.setForeground(new Color(0, 0, 0));
        txtPhuCapXangXe.setForeground(new Color(0, 0, 0));
        txtThuong.setForeground(new Color(0, 0, 0));
        txtLuongCB.setForeground(new Color(0, 0, 0));
        int i = table.getSelectedRow();
        if (i >= 0) {
            QLNV_DTO nv = new QLNV_DTO();
            nv = bus.kqNC.get(i);
            bus.DSLuongM = bus.DSLUONG(nv.Ma);
            for (int j = model2.getRowCount() - 1; j >= 0; j--) {
                model2.removeRow(j);
            }
            ShowDSLUONG(bus.DSLuongM);
            txtMa.setText(nv.Ma);
            txtHo.setText(nv.Ho);
            txtTen.setText(nv.Ten);
            if (nv.GioiTinh.equals("Nữ")) {
                rdbtnNu.setSelected(true);
            } else {
                rdbtnNam.setSelected(true);
                // rdbtnNu.setSelected(false);
            }
            cbbChucVu.setSelectedItem(nv.ChucVu);
            cbbNgay.setSelectedItem(nv.NgaySinh);
            cbbThang.setSelectedItem(nv.ThangSinh);
            cbbNam.setSelectedItem(nv.NamSinh);
            txtDiaChi.setText(nv.DiaChi);
            txtSDT.setText(nv.SDT);
            txtEmail.setText(nv.Email);
            //txtLuong.setText(String.valueOf(nv.Luong));
            link = nv.anh;
            lbAnh.setIcon(ResizeImage(String.valueOf(link)));
            lbHo.setText(nv.Ho + " " + nv.Ten);

            lbAnhNV.setIcon(ResizeImage(String.valueOf(link)));
            lbChucVu.setText(nv.ChucVu);
            lbGT.setText(nv.GioiTinh);
            for (Luong_DTO luong : bus.dsluong) {
                if (nv.Ma.equals(luong.MaNV)) {
                    txtLuongCB.setText(luong.LuongCB);
                    txtMaNV.setText(luong.MaNV);
                    txtPhuCapAnUong.setText(luong.PhuCapanUong);
                    txtPhuCapXangXe.setText(luong.PhuCapXangXe);
                    txtPhuCapDT.setText(luong.PhuCapDienThoai);
                    txtThuong.setText(luong.thuong);
                }
            }
        }
    }//GEN-LAST:event_TimkiemNC

    private void btnAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnhActionPerformed
        // TODO add your handling code here:
        try {
            JFileChooser f = new JFileChooser("C:\\IDE java\\NetBeans-13\\JaVa\\ICYCos\\src\\icy\\HinhAnh_ICY");
            f.setDialogTitle("Open");
            f.showOpenDialog(null);
            File ftenanh = f.getSelectedFile();
            link = ftenanh.getAbsolutePath().replace("\\", "\\\\");
                //if(link !=null)
                lbAnh.setIcon(ResizeImage(String.valueOf(link)));
                System.out.println("link");

                System.out.println("Chua nhap anh");

            } catch (Exception e) {
                System.out.println("Chua chon anh");
                System.out.println(link);
            }
    }//GEN-LAST:event_btnAnhActionPerformed

    private void btnHuongDanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuongDanActionPerformed
        if(btnHuongDan.isSelected()==true){
            HD.setVisible(true);
            HD.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_btnHuongDanActionPerformed

    private void btnLienHeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLienHeActionPerformed
        JOptionPane.showMessageDialog(this,"Bạn vui lòng chọn chức năng hỗ trợ để liên hệ!");
    }//GEN-LAST:event_btnLienHeActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        NV.setVisible(false);
    }//GEN-LAST:event_btnThoatActionPerformed

    private void rdbtnNamTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbtnNamTKActionPerformed

        bus.kq = bus.timTheoGioiTinh("Nam");
        if (bus.kq.size() == 0) {
            JOptionPane.showConfirmDialog(null, "Không tìm thấy nhân viên");
        } else {
            for (int i = model1.getRowCount() - 1; i >= 0; i--) {
                model1.removeRow(i);
            }
            showDSNV(bus.kq);
            lbTimKiem.setText("Tìm thây " + bus.kq.size() + " Nhân Viên");
        }
    }//GEN-LAST:event_rdbtnNamTKActionPerformed

    private void rdbtnNuTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbtnNuTKActionPerformed
        // TODO add your handling code here:
        bus.kq = bus.timTheoGioiTinh("Nữ");
        if (bus.kq.size() == 0) {
            JOptionPane.showConfirmDialog(null, "Không tìm thấy nhân viên");
        } else {
            for (int i = model1.getRowCount() - 1; i >= 0; i--) {
                model1.removeRow(i);
            }
            showDSNV(bus.kq);
            lbTimKiem.setText("Tìm thây " + bus.kq.size() + " Nhân Viên");
        }
    }//GEN-LAST:event_rdbtnNuTKActionPerformed

    private void rdbtnORActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbtnORActionPerformed
        // TODO add your handling code here:
        if (txtTu.getText().equals("") || txtDen.getText().equals(""))
        JOptionPane.showConfirmDialog(null, "Mời nhập thông tin để tìm kiếm");
        else {
            bus.kqNC = bus.TimMaorChucVu(txtTu.getText(), txtDen.getText());
            if (bus.kqNC.size() == 0) {
                JOptionPane.showConfirmDialog(null, "Không tìm thấy nhân viên");
            } else {
                for (int i = model1.getRowCount() - 1; i >= 0; i--) {
                    model1.removeRow(i);
                }
                showDSNV(bus.kqNC);
                lbTimKiem.setText("Tìm thây " + bus.kqNC.size() + " Nhân Viên");
            }
        }
    }//GEN-LAST:event_rdbtnORActionPerformed

    private void rdbtnANDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbtnANDActionPerformed
        // TODO add your handling code here:
        if (txtTu.getText().equals("") || txtDen.getText().equals(""))
        JOptionPane.showConfirmDialog(null, "Mời nhập thông tin để tìm kiếm");
        else {
            bus.kqNC = bus.TimMavaChucVu(txtTu.getText(), txtDen.getText());
            if (bus.kqNC.size() == 0) {
                JOptionPane.showConfirmDialog(null, "Không tìm thấy nhân viên");
                table.setModel(model);
                lbTimKiem.setText("");
            } else {
                for (int i = model1.getRowCount() - 1; i >= 0; i--) {
                    model1.removeRow(i);
                }
                showDSNV(bus.kqNC);
                lbTimKiem.setText("Tìm thây " + bus.kqNC.size() + " Nhân Viên");
            }
        }
    }//GEN-LAST:event_rdbtnANDActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed

        if (cbbTimCB.getSelectedItem().equals("Mã")) {
            bus.kq = bus.timTheoMa(txtTimKiem.getText());
        }
        if (cbbTimCB.getSelectedItem().equals("Họ")) {
            bus.kq = bus.timTheoHo(txtTimKiem.getText());
        }
        if (cbbTimCB.getSelectedItem().equals("Tên")) {
            bus.kq = bus.timTheoTen(txtTimKiem.getText());
        }
        if (cbbTimCB.getSelectedItem().equals("Chức vụ")) {
            bus.kq = bus.timTheoChucVu(txtTimKiem.getText());
        }
        if (cbbTimCB.getSelectedItem().equals("Email")) {
            bus.kq = bus.timTheoEmail(txtTimKiem.getText());
        }

        if (cbbTimCB.getSelectedItem().equals("Độ tuổi")) {
            int a = Integer.parseInt(txtTu.getText());
            int b = Integer.parseInt(txtDen.getText());

            bus.kq = bus.timTheoDoTuoi(a, b);
        }
        if (bus.kq.size() == 0) {
            JOptionPane.showMessageDialog(this, "KHÔNG TÌM THẤY!!");
            table.setModel(model);
            lbTimKiem.setText(" ");
        } else {
            for (int i = model1.getRowCount() - 1; i >= 0; i--) {
                model1.removeRow(i);
            }
        }
        showDSNV(bus.kq);
        lbTimKiem.setText("Tìm thây " + bus.kq.size() + " Nhân Viên");
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTimKiemMouseClicked
        // TODO add your handling code here:
        int i = table.getSelectedRow();
        if (i >= 0) {
            QLNV_DTO nv = new QLNV_DTO();
            nv = bus.kq.get(i);
            txtMa.setText(nv.Ma);
            txtHo.setText(nv.Ho);
            txtTen.setText(nv.Ten);
            if (nv.GioiTinh.equals("Nữ")) {
                rdbtnNu.setSelected(true);

            } else {
                rdbtnNam.setSelected(true);
            }
            cbbChucVu.setSelectedItem(nv.ChucVu);
            cbbNgay.setSelectedItem(nv.NgaySinh);
            cbbThang.setSelectedItem(nv.ThangSinh);
            cbbNam.setSelectedItem(nv.NamSinh);
            txtDiaChi.setText(nv.DiaChi);
            txtSDT.setText(nv.SDT);
            txtEmail.setText(nv.Email);
            link = nv.anh;
            lbAnh.setIcon(ResizeImage(String.valueOf(link)));
        }
    }//GEN-LAST:event_btnTimKiemMouseClicked

    private void txtTimKiemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER) {
            //cbbTimNC1.requestFocus();
        }
    }//GEN-LAST:event_txtTimKiemKeyPressed

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void cbbTimCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbTimCBActionPerformed
        // TODO add your handling code here:
        if (cbbTimCB.getSelectedItem().equals("Giới tính")) {
            txtTimKiem.setVisible(false);
            panTuoi.setVisible(false);
            panGT.setVisible(true);
            panAndOr.setVisible(false);
            btnTimKiem.setVisible(false);
        } else if (cbbTimCB.getSelectedItem().equals("Độ tuổi")) {
            txtTimKiem.setVisible(false);
            panTuoi.setVisible(true);
            lbTu.setText("Từ");
            lbDen.setText("Đến");
            panGT.setVisible(false);
            panAndOr.setVisible(false);
            txtTu.setText("");
            txtDen.setText("");
            btnTimKiem.setVisible(true);
        } else if (cbbTimCB.getSelectedItem().equals("Mức lương")) {
            txtTimKiem.setVisible(false);
            panTuoi.setVisible(true);
            lbTu.setText("Từ");
            lbDen.setText("Đến");
            txtTu.setText("");
            txtDen.setText("");
            panGT.setVisible(false);
            panAndOr.setVisible(false);
            btnTimKiem.setVisible(true);
        } else if (cbbTimCB.getSelectedItem().equals("Mã - Chức vụ")) {
            txtTimKiem.setVisible(false);
            panTuoi.setVisible(true);
            lbTu.setText("Mã");
            lbDen.setText("Chức vụ");
            txtTu.setText("");
            txtDen.setText("");
            panAndOr.setVisible(true);
            panGT.setVisible(false);
            btnTimKiem.setVisible(false);
        } else {
            panGT.setVisible(false);
            panTuoi.setVisible(false);
            txtTimKiem.setVisible(true);
            panAndOr.setVisible(false);
            btnTimKiem.setVisible(true);
        }
    }//GEN-LAST:event_cbbTimCBActionPerformed

    private void txtEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyPressed

    }//GEN-LAST:event_txtEmailKeyPressed

    private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusLost
        // TODO add your handling code here:
        if (txtEmail.getText().trim().equals("") || txtTen.getText().trim().toLowerCase().equals("nhập email")) {
            txtEmail.setText("Nhập email");
            txtEmail.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtEmailFocusLost

    private void txtEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusGained
        // TODO add your handling code here:
        if (txtEmail.getText().trim().toLowerCase().equals("nhập email")) {
            txtEmail.setText("");
        }
        txtEmail.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_txtEmailFocusGained

    private void txtSDTKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSDTKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtEmail.requestFocus();
        }
    }//GEN-LAST:event_txtSDTKeyPressed

    private void txtSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSDTActionPerformed

    private void txtSDTFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSDTFocusLost
        // TODO add your handling code here:
        if (txtSDT.getText().trim().equals("") || txtTen.getText().trim().toLowerCase().equals("nhập số điện thoại")) {
            txtSDT.setText("Nhập số điện thoại");
            txtSDT.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtSDTFocusLost

    private void txtSDTFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSDTFocusGained
        // TODO add your handling code here:
        if (txtSDT.getText().trim().toLowerCase().equals("nhập số điện thoại")) {
            txtSDT.setText("");
        }
        txtSDT.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_txtSDTFocusGained

    private void txtDiaChiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDiaChiKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtSDT.requestFocus();
        }
    }//GEN-LAST:event_txtDiaChiKeyPressed

    private void txtDiaChiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiaChiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiaChiActionPerformed

    private void txtDiaChiFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDiaChiFocusLost
        // TODO add your handling code here:
        if (txtDiaChi.getText().trim().equals("") || txtTen.getText().trim().toLowerCase().equals("nhập địa chỉ")) {
            txtDiaChi.setText("Nhập địa chỉ");
            txtDiaChi.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtDiaChiFocusLost

    private void txtDiaChiFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDiaChiFocusGained
        // TODO add your handling code here:
        if (txtDiaChi.getText().trim().toLowerCase().equals("nhập địa chỉ")) {
            txtDiaChi.setText("");
        }
        txtDiaChi.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_txtDiaChiFocusGained

    private void cbbChucVuKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbbChucVuKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER) {
            cbbNgay.requestFocus();
        }
    }//GEN-LAST:event_cbbChucVuKeyPressed

    private void cbbNamKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbbNamKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtDiaChi.requestFocus();
        }
    }//GEN-LAST:event_cbbNamKeyPressed

    private void cbbNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbNamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbNamActionPerformed

    private void cbbNgayKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbbNgayKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER) {
            cbbThang.requestFocus();
        }
    }//GEN-LAST:event_cbbNgayKeyPressed

    private void cbbThangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbbThangKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER) {
            cbbNam.requestFocus();
        }
    }//GEN-LAST:event_cbbThangKeyPressed

    private void txtTenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTenKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER) {
            cbbChucVu.requestFocus();
        }
    }//GEN-LAST:event_txtTenKeyPressed

    private void txtTenFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTenFocusLost
        // TODO add your handling code here:
        if (txtTen.getText().trim().equals("") || txtTen.getText().trim().toLowerCase().equals("nhập tên")) {
            txtTen.setText("Nhập tên");
            txtTen.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtTenFocusLost

    private void txtTenFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTenFocusGained
        // TODO add your handling code here:
        if (txtTen.getText().trim().toLowerCase().equals("nhập tên")) {
            txtTen.setText("");
        }
        txtTen.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_txtTenFocusGained

    private void txtHoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHoKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtTen.requestFocus();
        }
    }//GEN-LAST:event_txtHoKeyPressed

    private void txtHoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHoFocusLost
        // TODO add your handling code here:
        if (txtHo.getText().trim().equals("") || txtHo.getText().trim().toLowerCase().equals("nhập họ")) {
            txtHo.setText("Nhập họ");
            txtHo.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtHoFocusLost

    private void txtHoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHoFocusGained
        // TODO add your handling code here:
        if (txtHo.getText().trim().toLowerCase().equals("nhập họ")) {
            txtHo.setText("");
        }
        txtHo.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_txtHoFocusGained

    private void txtMaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtHo.requestFocus();
        }
    }//GEN-LAST:event_txtMaKeyPressed

    private void txtMaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaActionPerformed

    private void txtMaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMaFocusLost
        // TODO add your handling code here:
        if (txtMa.getText().trim().equals("") || txtTen.getText().trim().toLowerCase().equals("nhập mã")) {
            txtMa.setText("Nhập mã");
            txtMa.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_txtMaFocusLost

    private void txtMaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMaFocusGained
        // TODO add your handling code here:
        if (txtMa.getText().trim().toLowerCase().equals("nhập mã")) {
            txtMa.setText("");
        }
        txtMa.setForeground(new Color(0, 0, 0));
    }//GEN-LAST:event_txtMaFocusGained

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (QLNV_BUS.kq != null) {
            QLNV_BUS.kq.clear();
        }
        table.setModel(model);
        lbTimKiem.setText("");
        txtDen.setText("");
        txtTu.setText("");
        txtTimKiem.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        if (bus.KtrID(txtMa.getText()) == true) {
            QLNV_DTO nv = new QLNV_DTO();
            nv.Ma = txtMa.getText();
            nv.Ho = txtHo.getText();
            nv.Ten = txtTen.getText();
            if (rdbtnNam.isSelected()) {
                nv.setGioiTinh("Nam");
            } else// if(rdbtnNam.isSelected())
            {
                nv.setGioiTinh("Nữ");
            }
            nv.ChucVu = cbbChucVu.getSelectedItem().toString();
            nv.NgaySinh = cbbNgay.getSelectedItem().toString();
            nv.ThangSinh = cbbThang.getSelectedItem().toString();
            nv.NamSinh = cbbNam.getSelectedItem().toString();
            nv.DiaChi = txtDiaChi.getText();
            nv.SDT = txtSDT.getText();
            nv.Email = txtEmail.getText();
            nv.anh = link;

            bus.themNV(nv);
            dsnv.add(nv);

            Vector header = new Vector();
            header.add("Mã nhân vien");//tua de cot cua jtable
            header.add("Họ ");
            header.add("Tên");
            header.add("Giới tính");//tua de cot cua jtable
            header.add("Chức vụ");
            header.add("Ngày sinh");
            header.add("Tháng sinh");
            header.add("Năm sinh");
            header.add("Địa chỉ ");
            header.add("SDT");
            header.add("Email");
            header.add("Lương");

            if (model.getRowCount() == 0) {
                model = new DefaultTableModel(header, 0);
            }
            Vector row = new Vector();
            row.add(nv.Ma);
            row.add(nv.Ho);
            row.add(nv.Ten);
            row.add(nv.GioiTinh);
            row.add(nv.ChucVu);
            row.add(nv.NgaySinh + "/" + nv.ThangSinh + "/" + nv.NamSinh);
            row.add(nv.DiaChi);
            row.add(nv.SDT);
            row.add(nv.Email);
            row.add(String.valueOf(nv.Luong));
            model.addRow(row);
            table.setModel(model);
            JOptionPane.showConfirmDialog(this, "Thêm thành công");
        } else {
            JOptionPane.showConfirmDialog(this, "Mã nhân viên đã tônf tại");
            txtMa.setText("");
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnInDSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInDSActionPerformed
        // TODO add your handling code here:
        try {
            String s=JOptionPane.showInputDialog(this,"Mời nhập tên file cần xuất");
            XSSFWorkbook wb = new XSSFWorkbook();
            XSSFSheet sheet = wb.createSheet(s);
            XSSFRow row = null;
            Cell cell = null;
            row = sheet.createRow(3);

            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("Ma");

            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("Ho");

            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("Ten");

            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("GioiTinh");

            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("Chucvu");

            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue("Ngaysinh");

            cell = row.createCell(6, CellType.STRING);
            cell.setCellValue("Diachi");

            cell = row.createCell(7, CellType.STRING);
            cell.setCellValue("SDT");

            cell = row.createCell(8, CellType.STRING);
            cell.setCellValue("Email");

            cell = row.createCell(9, CellType.STRING);
            cell.setCellValue("Luong");

            for (int i = 0; i < bus.dsnv.size(); i++) {
                row = sheet.createRow(4 + i);

                cell = row.createCell(0, CellType.STRING);
                cell.setCellValue(bus.dsnv.get(i).getMa());

                cell = row.createCell(1, CellType.STRING);
                cell.setCellValue(bus.dsnv.get(i).getHo());

                cell = row.createCell(2, CellType.STRING);
                cell.setCellValue(bus.dsnv.get(i).getTen());

                cell = row.createCell(3, CellType.STRING);
                cell.setCellValue(bus.dsnv.get(i).getGioiTinh());

                cell = row.createCell(4, CellType.STRING);
                cell.setCellValue(bus.dsnv.get(i).getChucVu());

                cell = row.createCell(5, CellType.STRING);
                cell.setCellValue(bus.dsnv.get(i).getNgaySinh() + "/" + bus.dsnv.get(i).getThangSinh() + "/" + bus.dsnv.get(i).getNamSinh());

                cell = row.createCell(6, CellType.STRING);
                cell.setCellValue(bus.dsnv.get(i).getDiaChi());

                cell = row.createCell(7, CellType.STRING);
                cell.setCellValue(bus.dsnv.get(i).getSDT());

                cell = row.createCell(8, CellType.STRING);
                cell.setCellValue(bus.dsnv.get(i).getEmail());

                cell = row.createCell(9, CellType.STRING);
                cell.setCellValue(bus.dsnv.get(i).getLuong());

            }
            File f = new File("C:\\IDE java\\NetBeans-13\\JaVa\\ICYCos\\src\\icy\\FileExcel\\"+s+".xlsx");
                try {
                    FileOutputStream fi = new FileOutputStream(f);
                    wb.write(fi);

                    JOptionPane.showConfirmDialog(null, "Thanh cong");
                    fi.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
    }//GEN-LAST:event_btnInDSActionPerformed

    private void btnTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTKActionPerformed
        //DK.setTextX(txtMa.getText());
        //DK.setTextY(cbbChucVu.getSelectedItem().toString());
        //DK.setVisible(true);
        //DK.setLocationRelativeTo(null);
          TK.setVisible(true);
        
    }//GEN-LAST:event_btnTKActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed

        lbThongbao.setVisible(false);
        String ma = txtMa.getText();
        int i = table.getSelectedRow();
        String y;
        if (i >= 0) {
            bus.xoa(ma);
            model.removeRow(i);
            table.setModel(model);
            lbAnh.setIcon(ResizeImage("C:\\IDE java\\NetBeans-13\\JaVa\\ICYCos\\src\\icy\\HinhAnh_ICY\\AnhNV\\login3.PNG"));
            QLNV_BUS.dsnv.remove(i);
            bus.xoaLuong(ma);

            for (int j = model2.getRowCount() - 1; j >= 0; j--) {

                model2.removeRow(j);
            }
            QLNV_BUS.dsluong.remove(i);
            ShowDSLUONG(QLNV_BUS.dsluong);
        }
        JOptionPane.showConfirmDialog(null, "Xoá thành cong");
        txtMaNV.setText("");
        txtThuong.setText("");
        txtPhuCapXangXe.setText("");
        txtPhuCapDT.setText("");
        txtLuongCB.setText("");
        txtPhuCapAnUong.setText("");
        txtDiaChi.setText("");
        txtHo.setText("");
        txtSDT.setText("");
        txtMa.setText("");
        txtTen.setText("");
        txtEmail.setText("");
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        int i = table.getSelectedRow();
        if (i >= 0) {
            QLNV_DTO nv = new QLNV_DTO();
            nv.Ma = txtMa.getText();
            nv.Ho = txtHo.getText();
            nv.Ten = txtTen.getText();
            if (rdbtnNam.isSelected()) {
                nv.setGioiTinh("Nam");
            } else if (rdbtnNu.isSelected()) {
                nv.setGioiTinh("Nữ");
            }
            nv.ChucVu = cbbChucVu.getSelectedItem().toString();
            nv.NgaySinh = cbbNgay.getSelectedItem().toString();
            nv.ThangSinh = cbbThang.getSelectedItem().toString();
            nv.NamSinh = cbbNam.getSelectedItem().toString();
            nv.DiaChi = txtDiaChi.getText();
            nv.SDT = txtSDT.getText();
            nv.Email = txtEmail.getText();
            nv.anh = link;
            bus.sua(nv);
            JOptionPane.showConfirmDialog(null, "Sửa thành công");
            QLNV_DTO old = bus.dsnv.set(i, nv);
            model.setValueAt(nv.Ma, i, 0);
            model.setValueAt(nv.Ho, i, 1);
            model.setValueAt(nv.Ten, i, 2);
            model.setValueAt(nv.GioiTinh, i, 3);
            model.setValueAt(nv.ChucVu, i, 4);
            model.setValueAt(nv.NgaySinh + "/" + nv.ThangSinh + "/" + nv.NamSinh, i, 5);
            model.setValueAt(nv.DiaChi, i, 6);
            model.setValueAt(nv.SDT, i, 7);
            model.setValueAt(nv.Email, i, 8);
            model.setValueAt(nv.Luong, i, 9);
            lbAnh.setIcon(ResizeImage(String.valueOf(link)));
            table.setModel(model);
        }
        //  }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnThoat2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoat2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThoat2ActionPerformed

    private void btnLienHe2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLienHe2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLienHe2ActionPerformed

    private void btnHuongDan2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuongDan2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHuongDan2ActionPerformed

    private void btnThem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThem1ActionPerformed

    private void btnXoa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoa1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXoa1ActionPerformed

    private void btnSua1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSua1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSua1ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void rdbtnNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbtnNamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdbtnNamActionPerformed

    private void txtTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenActionPerformed

    private void btnThoat3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoat3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThoat3ActionPerformed

    private void btnLienHe3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLienHe3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLienHe3ActionPerformed

    private void btnHuongDan3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuongDan3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHuongDan3ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        // TODO add your handling code here:
        // Collections.sort(bus.dsluong,(a,b) ->(double)(a.getLuongCB().compareTo(b.getLuongCB())));
       /* Collections.sort(bus.dsluong,new Comparator<Luong_DTO>(){
            @Override
            public int compare(Luong_DTO o1, Luong_DTO o2) {
                return 
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        
            
        }
        
         System.out.println(bus.dsluong);
         ShowDSLUONG(bus.dsluong);
        */
    }//GEN-LAST:event_jRadioButton4ActionPerformed
    public void setTextTenDN(String s){
        btnDangNhap.setText(s);
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TrangChu_ICY.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrangChu_ICY.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrangChu_ICY.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrangChu_ICY.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NV.setVisible(true);
                NV.setLocationRelativeTo(null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Tong;
    private javax.swing.JButton btnAnh;
    private javax.swing.JToggleButton btnDangNhap;
    private javax.swing.JToggleButton btnDoanhThu;
    private javax.swing.JToggleButton btnDonHang;
    private javax.swing.JToggleButton btnHoTro;
    private javax.swing.JButton btnHuongDan;
    private javax.swing.JButton btnHuongDan2;
    private javax.swing.JButton btnHuongDan3;
    private javax.swing.JButton btnInDS;
    private javax.swing.JToggleButton btnKhachHang;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnLamMoiLuong;
    private javax.swing.JButton btnLienHe;
    private javax.swing.JButton btnLienHe2;
    private javax.swing.JButton btnLienHe3;
    private javax.swing.JToggleButton btnNhanVien;
    private javax.swing.JToggleButton btnNhapHang;
    private javax.swing.JToggleButton btnSanPham;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnSua1;
    private javax.swing.JButton btnSuaLuong;
    private javax.swing.JButton btnTK;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThem1;
    private javax.swing.JButton btnThemLuong;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnThoat2;
    private javax.swing.JButton btnThoat3;
    private javax.swing.JToggleButton btnThongKe;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoa1;
    private javax.swing.JToggleButton btnkhuyenMai;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup10;
    private javax.swing.ButtonGroup buttonGroup11;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.ButtonGroup buttonGroup7;
    private javax.swing.ButtonGroup buttonGroup8;
    private javax.swing.ButtonGroup buttonGroup9;
    private javax.swing.JComboBox<String> cbbChucVu;
    private javax.swing.JComboBox<String> cbbNam;
    private javax.swing.JComboBox<String> cbbNgay;
    private javax.swing.JComboBox<String> cbbThang;
    private javax.swing.JComboBox<String> cbbTimCB;
    private javax.swing.JButton ds;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
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
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
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
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JLabel lbAnh;
    private javax.swing.JLabel lbAnhNV;
    private javax.swing.JLabel lbAnhNV1;
    private javax.swing.JLabel lbChucVu;
    private javax.swing.JLabel lbDen;
    private javax.swing.JLabel lbGT;
    private javax.swing.JLabel lbHo;
    private javax.swing.JLabel lbThongbao;
    private javax.swing.JLabel lbTimKiem;
    private javax.swing.JLabel lbTu;
    private javax.swing.JLabel lbtongLuong;
    private javax.swing.JPanel panAndOr;
    private javax.swing.JPanel panGT;
    private javax.swing.JPanel panTuoi;
    private javax.swing.JRadioButton rdbtnAND;
    private javax.swing.JRadioButton rdbtnNam;
    private javax.swing.JRadioButton rdbtnNamTK;
    private javax.swing.JRadioButton rdbtnNu;
    private javax.swing.JRadioButton rdbtnNuTK;
    private javax.swing.JRadioButton rdbtnOR;
    private javax.swing.JTable table;
    private javax.swing.JTable tableLuong;
    private javax.swing.JTextField txtDen;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHo;
    private javax.swing.JTextField txtLuongCB;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtPhuCapAnUong;
    private javax.swing.JTextField txtPhuCapDT;
    private javax.swing.JTextField txtPhuCapXangXe;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTen;
    private javax.swing.JTextField txtThuong;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTu;
    private javax.swing.JPanel txtTuoiO1;
    // End of variables declaration//GEN-END:variables
}
