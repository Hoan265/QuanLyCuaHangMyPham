/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package icy.GUI;
import ICY.BUS.QLNV_BUS;
import ICY.DTO.QLNV_DTO;
import icy.BUS.LoaiSP_BUS;
import icy.TrangChu_ICY;
import icy.BUS.SanPham_BUS;
import icy.DTO.LoaiSP_DTO;
import icy.DTO.SanPham_DTO;
import static icy.GUI.BanHang_GUI.BH;
import static icy.GUI.DangNhap_GUI.DN;
import static icy.GUI.DoanhThu_GUI.DT;
import static icy.GUI.HoSoNV_GUI.HS;
import static icy.GUI.HoTro_GUI.HT;
import static icy.GUI.HuongDan_GUI.HD;
import static icy.GUI.KhachHang_GUI.KH;
import static icy.GUI.KhuyenMai_GUI.KM;
import static icy.GUI.NhapHang_GUI.NH;
import static icy.GUI.QLNV_GUI.NV;
import static icy.GUI.ThongKe_GUI.TK;
import java.awt.Color;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 *
 * @author HP
 */
public class SanPham_GUI extends javax.swing.JFrame {
    DefaultTableModel model=new DefaultTableModel();
    public static SanPham_GUI SP=new SanPham_GUI();
    TrangChu_ICY tc=new TrangChu_ICY();
    SanPham_BUS bus=new SanPham_BUS();
    SanPham_DTO sp=new SanPham_DTO();
    DefaultTableModel modelLoai=new DefaultTableModel();
    LoaiSP_BUS busLoai=new LoaiSP_BUS();
    LoaiSP_DTO lsp=new LoaiSP_DTO();
    String linkAnh="C:\\IDE java\\NetBeans-13\\JaVa\\ICYCos\\src\\icy\\HinhAnh_ICY\\SanPham\\SPMacDinh";
    public SanPham_GUI() {
        initComponents();
       
        DocDuLieu();
        panelSanPham.setFocusable(true);
        DocLoai();
        try{
            btnSanPham.setSelected(true);
        }catch(Exception ex){
        }
    }
    public void DocDuLieu(){
        if (SanPham_BUS.dssp == null) {
            bus.DocSP();
        }
        //c???p nh???t Jtable
        Vector header = new Vector();
        header.add("M?? SP");//t??n c???t table
        header.add("T??n SP");
        header.add("Lo???i SP");
        header.add("Gi?? b??n");
        header.add("S??? l?????ng");
        header.add("????n v??? t??nh");
        header.add("H??nh ???nh");
        if (model.getRowCount() == 0) {
            model = new DefaultTableModel(header, 0);
        }
        for (SanPham_DTO sp : SanPham_BUS.dssp) {
            //n???p d??? li???u cho m???i row
            Vector row = new Vector();
            row.add(sp.MaSP);
            row.add(sp.TenSP);
            if (LoaiSP_BUS.dslsp == null) {
                busLoai.DocLSP();
            }
            for(LoaiSP_DTO lsp : LoaiSP_BUS.dslsp){
                if(lsp.MaLoaiSP.equals(sp.MaLoaiSP)){
                    row.add(lsp.TenLoai);
                }
            }
            row.add(sp.GiaBan);
            row.add(sp.SoLuong);
            row.add(sp.DonViTinh);
            row.add(sp.HinhAnhSP);
            model.addRow(row); //th??m row d??? li???u v??o model
            tblSanPham.setModel(model);
        }
    }
    public boolean maDuyNhat(String x){
        for(SanPham_DTO sp: bus.dssp){
            if(sp.MaSP.equalsIgnoreCase(x))
                return false;
        }
        return true;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jScrollPane2 = new javax.swing.JScrollPane();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jFrame1 = new javax.swing.JFrame();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
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
        jPanel4 = new javax.swing.JPanel();
        btnThoat = new javax.swing.JButton();
        btnLienHe = new javax.swing.JButton();
        btnHuongDan = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        panelSanPham = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        lbelChinhHinh = new javax.swing.JLabel();
        btnChinhHinh = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTenSP = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbbLoaiSP = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtGiaBan = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnCapNhap = new javax.swing.JButton();
        txtTim1 = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        cbbTim1 = new javax.swing.JComboBox<>();
        rbtnAnd = new javax.swing.JRadioButton();
        rbtnOr = new javax.swing.JRadioButton();
        rbtnGam = new javax.swing.JRadioButton();
        rbtnML = new javax.swing.JRadioButton();
        rbtnCai = new javax.swing.JRadioButton();
        txtSoDonVi = new javax.swing.JTextField();
        btnXuat = new javax.swing.JButton();
        btnNhap = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtGiaBan1 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtGiaBan2 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtSL1 = new javax.swing.JTextField();
        txtSL2 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        panelCTSP = new javax.swing.JPanel();
        lbelHinhAnh = new javax.swing.JLabel();
        lbeltenSP = new javax.swing.JLabel();
        lbelLoai = new javax.swing.JLabel();
        lbelGia = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextPane4 = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtThanhPhan = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtCongDung = new javax.swing.JTextPane();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblLoaiSP = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtMaLoai = new javax.swing.JTextField();
        txtTenLoai = new javax.swing.JTextField();
        btnThemLoai = new javax.swing.JButton();
        btnSuaLoai = new javax.swing.JButton();
        btnXoaLoai = new javax.swing.JButton();
        btnCapNhatLoai = new javax.swing.JButton();
        txtTimLoai = new javax.swing.JTextField();
        btnTimLoai = new javax.swing.JButton();
        cbbTimLoaiSP = new javax.swing.JComboBox<>();
        jScrollPane11 = new javax.swing.JScrollPane();
        txtThanhPhanLoai = new javax.swing.JTextPane();
        jScrollPane8 = new javax.swing.JScrollPane();
        txtCongDungLoai = new javax.swing.JTextPane();

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
        setTitle("H??? TH???NG QU???N L?? C???A H??NG M??? PH???M");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icy/HinhAnh_ICY/HinhAnhICY.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icy/HinhAnh_ICY/SLogan_ICY.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel3)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(197, 223, 234));

        btnDangNhap.setBackground(new java.awt.Color(255, 204, 204));
        buttonGroup1.add(btnDangNhap);
        btnDangNhap.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDangNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icy/HinhAnh_ICY/TrangChu/NguoiDung.png"))); // NOI18N
        btnDangNhap.setText(" ????ng nh???p");
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });

        btnSanPham.setBackground(new java.awt.Color(255, 204, 204));
        buttonGroup1.add(btnSanPham);
        btnSanPham.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icy/HinhAnh_ICY/TrangChu/SanPham.png"))); // NOI18N
        btnSanPham.setText("S???n ph???m");
        btnSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSanPhamActionPerformed(evt);
            }
        });

        btnkhuyenMai.setBackground(new java.awt.Color(255, 204, 204));
        buttonGroup1.add(btnkhuyenMai);
        btnkhuyenMai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnkhuyenMai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icy/HinhAnh_ICY/TrangChu/KhuyenMai.png"))); // NOI18N
        btnkhuyenMai.setText("   Khuy???n m??i");
        btnkhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkhuyenMaiActionPerformed(evt);
            }
        });

        btnNhanVien.setBackground(new java.awt.Color(255, 204, 204));
        buttonGroup1.add(btnNhanVien);
        btnNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icy/HinhAnh_ICY/TrangChu/NhanVien.png"))); // NOI18N
        btnNhanVien.setText("Nh??n vi??n");
        btnNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanVienActionPerformed(evt);
            }
        });

        btnKhachHang.setBackground(new java.awt.Color(255, 204, 204));
        buttonGroup1.add(btnKhachHang);
        btnKhachHang.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icy/HinhAnh_ICY/TrangChu/KhachHang.png"))); // NOI18N
        btnKhachHang.setText("  Kh??ch h??ng");
        btnKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKhachHangActionPerformed(evt);
            }
        });

        btnDonHang.setBackground(new java.awt.Color(255, 204, 204));
        buttonGroup1.add(btnDonHang);
        btnDonHang.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDonHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icy/HinhAnh_ICY/TrangChu/DonHang.png"))); // NOI18N
        btnDonHang.setText("????n h??ng");
        btnDonHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDonHangActionPerformed(evt);
            }
        });

        btnNhapHang.setBackground(new java.awt.Color(255, 204, 204));
        buttonGroup1.add(btnNhapHang);
        btnNhapHang.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNhapHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icy/HinhAnh_ICY/TrangChu/NhapHang.png"))); // NOI18N
        btnNhapHang.setText(" Nh???p h??ng");
        btnNhapHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapHangActionPerformed(evt);
            }
        });

        btnThongKe.setBackground(new java.awt.Color(255, 204, 204));
        buttonGroup1.add(btnThongKe);
        btnThongKe.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icy/HinhAnh_ICY/TrangChu/ThongKe.gif"))); // NOI18N
        btnThongKe.setText("Th???ng k??");
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
        btnHoTro.setText("H??? tr???");
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

        jPanel4.setBackground(new java.awt.Color(197, 223, 234));

        btnThoat.setBackground(new java.awt.Color(204, 204, 204));
        btnThoat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThoat.setText("Tho??t");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        btnLienHe.setBackground(new java.awt.Color(204, 204, 204));
        btnLienHe.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLienHe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icy/HinhAnh_ICY/TrangChu/LienHe.png"))); // NOI18N
        btnLienHe.setText("Li??n h???");
        btnLienHe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLienHeActionPerformed(evt);
            }
        });

        btnHuongDan.setBackground(new java.awt.Color(204, 204, 204));
        btnHuongDan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHuongDan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icy/HinhAnh_ICY/TrangChu/HuongDan.png"))); // NOI18N
        btnHuongDan.setText("H?????ng d???n");
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
                .addGap(21, 21, 21))
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

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "M?? SP", "T??n SP", "Lo???i SP", "Gi?? b??n", "S??? l?????ng", "????n v??? t??nh", "H??nh ???nh"
            }
        ));
        tblSanPham.setGridColor(new java.awt.Color(255, 204, 204));
        tblSanPham.setSelectionBackground(new java.awt.Color(255, 204, 204));
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
                TimKiemMouseClicked(evt);
                TimKiemNCMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSanPham);

        lbelChinhHinh.setBackground(new java.awt.Color(204, 204, 255));
        lbelChinhHinh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icy/HinhAnh_ICY/SanPham/SPMacDinh.jpg"))); // NOI18N
        lbelChinhHinh.setText("                              H??nh ???nh");

        btnChinhHinh.setBackground(new java.awt.Color(204, 204, 204));
        btnChinhHinh.setText("Ch???nh h??nh");
        btnChinhHinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChinhHinhActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("M?? s???n ph???m");

        txtMaSP.setForeground(new java.awt.Color(153, 153, 153));
        txtMaSP.setText("Nh???p m??");
        txtMaSP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMaSPFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMaSPFocusLost(evt);
            }
        });
        txtMaSP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMaSPKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("T??n s???n ph???m");

        txtTenSP.setForeground(new java.awt.Color(153, 153, 153));
        txtTenSP.setText("Nh???p t??n");
        txtTenSP.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTenSPFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTenSPFocusLost(evt);
            }
        });
        txtTenSP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTenSPKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Lo???i s???n ph???m");

        cbbLoaiSP.setBackground(new java.awt.Color(204, 204, 204));
        cbbLoaiSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ch???n", "Ch??m s??c da", "M??? ph???m ch???c n??ng", "Ch???ng n???ng", "L??m s???ch da", "Trang ??i???m", "Ch??a ph??n lo???i" }));
        cbbLoaiSP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbbLoaiSPKeyPressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Gi?? b??n");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("????n v??? t??nh");

        txtGiaBan.setForeground(new java.awt.Color(153, 153, 153));
        txtGiaBan.setText("Nh???p gi??");
        txtGiaBan.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtGiaBanFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtGiaBanFocusLost(evt);
            }
        });
        txtGiaBan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtGiaBanKeyPressed(evt);
            }
        });

        btnThem.setBackground(new java.awt.Color(204, 204, 204));
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThem.setText("Th??m");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(204, 204, 204));
        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSua.setText("S???a");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(204, 204, 204));
        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXoa.setText("X??a");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnCapNhap.setBackground(new java.awt.Color(204, 204, 204));
        btnCapNhap.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCapNhap.setText("c???p nh???t");
        btnCapNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhapActionPerformed(evt);
            }
        });

        btnTimKiem.setBackground(new java.awt.Color(204, 204, 204));
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icy/HinhAnh_ICY/TrangChu/TimKiem.png"))); // NOI18N
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        cbbTim1.setBackground(new java.awt.Color(204, 204, 204));
        cbbTim1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M?? SP", "T??n SP", "Gi?? b??n", "S??? l?????ng" }));

        buttonGroup2.add(rbtnAnd);
        rbtnAnd.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        rbtnAnd.setText("AND");

        buttonGroup2.add(rbtnOr);
        rbtnOr.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        rbtnOr.setText("OR");

        buttonGroup3.add(rbtnGam);
        rbtnGam.setText("gam");

        buttonGroup3.add(rbtnML);
        rbtnML.setText("ml");

        buttonGroup3.add(rbtnCai);
        rbtnCai.setText("C??i");

        txtSoDonVi.setForeground(new java.awt.Color(153, 153, 153));
        txtSoDonVi.setText("S??? ????n v???");
        txtSoDonVi.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtSoDonViFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSoDonViFocusLost(evt);
            }
        });

        btnXuat.setBackground(new java.awt.Color(204, 204, 204));
        btnXuat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXuat.setText("Xu???t");
        btnXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatActionPerformed(evt);
            }
        });

        btnNhap.setBackground(new java.awt.Color(204, 204, 204));
        btnNhap.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnNhap.setText("Nh???p");
        btnNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapActionPerformed(evt);
            }
        });

        jLabel13.setText("Gi?? b??n t??? :");

        txtGiaBan1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtGiaBan1KeyPressed(evt);
            }
        });

        jLabel15.setText("?????n :");

        jLabel16.setText("S??? l?????ng b???ng:");

        txtSL1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSL1KeyPressed(evt);
            }
        });

        jLabel19.setText("ho???c :");

        javax.swing.GroupLayout panelSanPhamLayout = new javax.swing.GroupLayout(panelSanPham);
        panelSanPham.setLayout(panelSanPhamLayout);
        panelSanPhamLayout.setHorizontalGroup(
            panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSanPhamLayout.createSequentialGroup()
                .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSanPhamLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8))
                        .addGap(38, 38, 38)
                        .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelSanPhamLayout.createSequentialGroup()
                                .addComponent(txtSoDonVi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbtnGam)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbtnML)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbtnCai)))
                        .addGap(71, 71, 71)
                        .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnThem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnXoa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCapNhap, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(38, 38, 38)
                        .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelSanPhamLayout.createSequentialGroup()
                                .addComponent(btnXuat)
                                .addGap(18, 18, 18)
                                .addComponent(btnNhap))
                            .addGroup(panelSanPhamLayout.createSequentialGroup()
                                .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rbtnAnd)
                                    .addComponent(rbtnOr))
                                .addGap(38, 38, 38)
                                .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(cbbTim1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16)))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 769, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSanPhamLayout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(btnChinhHinh)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelSanPhamLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelSanPhamLayout.createSequentialGroup()
                                .addComponent(txtTim1)
                                .addGap(12, 12, 12)
                                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelSanPhamLayout.createSequentialGroup()
                                .addComponent(lbelChinhHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(panelSanPhamLayout.createSequentialGroup()
                                .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelSanPhamLayout.createSequentialGroup()
                                        .addComponent(txtGiaBan1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel15))
                                    .addGroup(panelSanPhamLayout.createSequentialGroup()
                                        .addComponent(txtSL1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel19)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtGiaBan2)
                                    .addComponent(txtSL2))))
                        .addGap(25, 25, 25))))
        );
        panelSanPhamLayout.setVerticalGroup(
            panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSanPhamLayout.createSequentialGroup()
                .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(panelSanPhamLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbelChinhHinh, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnChinhHinh))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem)
                    .addComponent(txtTim1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbbTim1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua)
                    .addComponent(jLabel5)
                    .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtGiaBan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13)
                        .addComponent(jLabel15)
                        .addComponent(txtGiaBan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rbtnAnd)))
                .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSanPhamLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(cbbLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnXoa)))
                    .addGroup(panelSanPhamLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtSL1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSL2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)
                            .addComponent(rbtnOr))))
                .addGap(8, 8, 8)
                .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCapNhap)
                        .addComponent(btnXuat)
                        .addComponent(btnNhap))
                    .addGroup(panelSanPhamLayout.createSequentialGroup()
                        .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelSanPhamLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel8))
                            .addGroup(panelSanPhamLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rbtnCai)
                                    .addComponent(rbtnML)
                                    .addComponent(rbtnGam)
                                    .addComponent(txtSoDonVi))))))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("S???n ph???m", panelSanPham);

        lbelHinhAnh.setText("                         H??nh ???nh");

        lbeltenSP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbeltenSP.setText("          T??n s???n ph???m");

        lbelLoai.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbelLoai.setText("Lo???i s???n ph???m :");

        lbelGia.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbelGia.setText("Gi?? b??n :");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setText("C??ng d???ng :");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setText("Th??nh ph???n :");

        jTextPane4.setEditable(false);
        jTextPane4.setBorder(null);
        jTextPane4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextPane4.setText("Ch??ng t??i xin cam k???t v??? m???t ch???t l?????ng trong t???ng s???n ph???m. Ch??ng t??i tuy???t ?????i kh??ng b??n h??ng fake. h??ng k??m ch???t l?????ng. N???u qu?? kh??ch nh???n th???y h??ng l???i ho???c kh??ng ????ng nh?? trong cam k???t. Ch??ng t??i s??? ti???n h??nh cho ?????i tr??? v?? ho??n l???i ti???n 100%. S???n ph???m tr??n h??nh c?? th??? s??? h??i kh??c ngo??i ?????i do ??nh s??ng v?? g??c ????? l??c ch???p ???nh.");
        jScrollPane6.setViewportView(jTextPane4);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Khuy???n c??o :");

        jTextPane1.setEditable(false);
        jTextPane1.setBorder(null);
        jTextPane1.setText("????? xa t???m tay tr??? em.\n?????c k??? h?????ng d???n s??? d???ng tr?????c khi s??? d???ng.\nN???u c???n th??m th??ng tin, xin h???i ?? ki???n b??c s?? \nhay d?????c s?? chuy??n ng??nh th???m m?? ????? ???????c t?? v???n.");
        jScrollPane5.setViewportView(jTextPane1);

        txtThanhPhan.setEditable(false);
        txtThanhPhan.setBorder(null);
        jScrollPane3.setViewportView(txtThanhPhan);

        txtCongDung.setEditable(false);
        txtCongDung.setBorder(null);
        jScrollPane4.setViewportView(txtCongDung);

        javax.swing.GroupLayout panelCTSPLayout = new javax.swing.GroupLayout(panelCTSP);
        panelCTSP.setLayout(panelCTSPLayout);
        panelCTSPLayout.setHorizontalGroup(
            panelCTSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCTSPLayout.createSequentialGroup()
                .addComponent(lbelHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelCTSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCTSPLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(panelCTSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 737, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelCTSPLayout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jLabel14))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelCTSPLayout.createSequentialGroup()
                                .addGroup(panelCTSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelCTSPLayout.createSequentialGroup()
                                        .addGroup(panelCTSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbelGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lbelLoai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(27, 27, 27)
                                        .addComponent(jLabel17)
                                        .addGap(11, 11, 11))
                                    .addGroup(panelCTSPLayout.createSequentialGroup()
                                        .addComponent(jLabel18)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelCTSPLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(lbeltenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelCTSPLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6814, 6814, 6814))
        );
        panelCTSPLayout.setVerticalGroup(
            panelCTSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCTSPLayout.createSequentialGroup()
                .addGroup(panelCTSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCTSPLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lbeltenSP, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelCTSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbelLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17))
                        .addGroup(panelCTSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCTSPLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbelGia)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel18))
                            .addGroup(panelCTSPLayout.createSequentialGroup()
                                .addGap(184, 184, 184)
                                .addComponent(jLabel2))))
                    .addComponent(lbelHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelCTSPLayout.createSequentialGroup()
                        .addGroup(panelCTSPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelCTSPLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelCTSPLayout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Chi ti???t s???n ph???m", panelCTSP);

        tblLoaiSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "M?? lo???i", "T??n lo???i", "Th??nh ph???n", "C??ng d???ng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLoaiSP.setGridColor(new java.awt.Color(255, 204, 204));
        tblLoaiSP.setSelectionBackground(new java.awt.Color(255, 204, 204));
        tblLoaiSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLoaiSPMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblLoaiSP);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("M?? lo???i");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("T??n lo???i");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Th??nh ph???n");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("C??ng d???ng");

        txtMaLoai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaLoai.setForeground(new java.awt.Color(153, 153, 153));
        txtMaLoai.setText("Nh???p m?? lo???i");
        txtMaLoai.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMaLoaiFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMaLoaiFocusLost(evt);
            }
        });
        txtMaLoai.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMaLoaiKeyPressed(evt);
            }
        });

        txtTenLoai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTenLoai.setForeground(new java.awt.Color(153, 153, 153));
        txtTenLoai.setText("Nh???p t??n lo???i");
        txtTenLoai.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTenLoaiFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTenLoaiFocusLost(evt);
            }
        });
        txtTenLoai.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTenLoaiKeyPressed(evt);
            }
        });

        btnThemLoai.setBackground(new java.awt.Color(204, 204, 204));
        btnThemLoai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThemLoai.setText("Th??m");
        btnThemLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemLoaiActionPerformed(evt);
            }
        });

        btnSuaLoai.setBackground(new java.awt.Color(204, 204, 204));
        btnSuaLoai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSuaLoai.setText("S???a");
        btnSuaLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaLoaiActionPerformed(evt);
            }
        });

        btnXoaLoai.setBackground(new java.awt.Color(204, 204, 204));
        btnXoaLoai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXoaLoai.setText("X??a");
        btnXoaLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaLoaiActionPerformed(evt);
            }
        });

        btnCapNhatLoai.setBackground(new java.awt.Color(204, 204, 204));
        btnCapNhatLoai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCapNhatLoai.setText("C???p nh???t");
        btnCapNhatLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatLoaiActionPerformed(evt);
            }
        });

        txtTimLoai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnTimLoai.setBackground(new java.awt.Color(204, 204, 204));
        btnTimLoai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icy/HinhAnh_ICY/TrangChu/TimKiem.png"))); // NOI18N
        btnTimLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimLoaiActionPerformed(evt);
            }
        });

        cbbTimLoaiSP.setBackground(new java.awt.Color(204, 204, 204));
        cbbTimLoaiSP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbbTimLoaiSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M?? lo???i", "T??n lo???i" }));

        txtThanhPhanLoai.setForeground(new java.awt.Color(153, 153, 153));
        txtThanhPhanLoai.setText("Nh???p th??nh ph???n");
        txtThanhPhanLoai.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtThanhPhanLoaiFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtThanhPhanLoaiFocusLost(evt);
            }
        });
        txtThanhPhanLoai.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtThanhPhanLoaiKeyPressed(evt);
            }
        });
        jScrollPane11.setViewportView(txtThanhPhanLoai);

        txtCongDungLoai.setForeground(new java.awt.Color(153, 153, 153));
        txtCongDungLoai.setText("Nh???p c??ng d???ng");
        txtCongDungLoai.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCongDungLoaiFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCongDungLoaiFocusLost(evt);
            }
        });
        jScrollPane8.setViewportView(txtCongDungLoai);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(txtMaLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(txtTenLoai)
                                .addGap(126, 126, 126)))
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnXoaLoai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSuaLoai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThemLoai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCapNhatLoai, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbTimLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTimLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTimLoai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel11)
                                    .addComponent(txtMaLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(txtTenLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28))
                            .addComponent(jScrollPane11)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThemLoai)
                            .addComponent(txtTimLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTimLoai)
                            .addComponent(cbbTimLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addComponent(btnSuaLoai)))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btnXoaLoai)
                        .addGap(18, 18, 18)
                        .addComponent(btnCapNhatLoai))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        jTabbedPane1.addTab("Lo???i s???n ph???m", jPanel7);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 541, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed
        if (btnDangNhap.getText().equals(" ????ng nh???p")) {
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

    private void btnSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSanPhamActionPerformed
        
    }//GEN-LAST:event_btnSanPhamActionPerformed
    String sb="";
    public boolean KiemTraGiaTri(){
        if (txtMaSP.getText().equals("") || txtMaSP.getText().equals("Nh???p m??")) {
            sb="M?? s???n ph???m kh??ng ???????c ????? tr???ng! \n";
            txtMaSP.setBackground(Color.PINK);
        } else {
            txtMaSP.setBackground(Color.white);
        }
        if (txtTenSP.getText().equals("") || txtTenSP.getText().equals("Nh???p t??n")) {
            sb=sb+"T??n s???n ph???m kh??ng ???????c ????? tr???ng! \n";
            txtTenSP.setBackground(Color.PINK);
        } else {
            txtTenSP.setBackground(Color.white);
        }
        if (cbbLoaiSP.getSelectedItem().equals("Ch???n")) {
            sb=sb+"Vui l??ng ch???n lo???i s???n ph???m!\n";
            cbbLoaiSP.setBackground(Color.PINK);
        } else {
            cbbLoaiSP.setBackground(Color.white);
        }
        if (txtGiaBan.getText().equals("") || txtGiaBan.getText().equals("Nh???p gi??")) {
            sb=sb+"Gi?? b??n kh??ng ???????c ????? tr???ng! \n";
            txtGiaBan.setBackground(Color.PINK);
        } else {
            txtGiaBan.setBackground(Color.white);
        }
        if (txtSoDonVi.getText().equals("") || txtSoDonVi.getText().equals("S??? ????n v???")) {
            sb=sb+"S??? ????n v??? kh??ng ???????c ????? tr???ng! \n";
            txtSoDonVi.setBackground(Color.PINK);
        } else {
            txtSoDonVi.setBackground(Color.white);
        }
        if (sb.length() > 0) {
            return false;
        }else
        return true;
    }
    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if(maDuyNhat(txtMaSP.getText())==true && KiemTraGiaTri()==true){
        sp.MaSP = txtMaSP.getText();
        sp.TenSP = txtTenSP.getText();
        sp.TenLoai = cbbLoaiSP.getSelectedItem().toString();
        if (LoaiSP_BUS.dslsp == null) {
                busLoai.DocLSP();
        }
        for(LoaiSP_DTO lsp : busLoai.dslsp){
            if(sp.TenLoai.equals(lsp.TenLoai)){
                sp.MaLoaiSP=lsp.MaLoaiSP;
            }
        }
        sp.GiaBan = txtGiaBan.getText();
        sp.SoLuong="0";
        if(rbtnGam.isSelected()==true){
        sp.DonViTinh=txtSoDonVi.getText()+" gam";
        }else if(rbtnML.isSelected()==true){
            sp.DonViTinh=txtSoDonVi.getText()+" ml";
        }else{
            sp.DonViTinh=txtSoDonVi.getText()+" c??i";
        }
        sp.HinhAnhSP=linkAnh;
        bus.them(sp);
        //n???p d??? li???u cho m???i row
        Vector row = new Vector();
        row.add(sp.MaSP);
        row.add(sp.TenSP);
        row.add(sp.TenLoai);
        row.add(sp.GiaBan);
        row.add(sp.SoLuong);
        row.add(sp.DonViTinh);
        row.add(sp.HinhAnhSP);
        model.addRow(row); //th??m row d??? li???u v??o model
        //n???p du lieu cua model v??o jtable tblDSSV
        tblSanPham.setModel(model);
        JOptionPane.showMessageDialog(this,"th??m th??nh c??ng!");
        }else{
            if(maDuyNhat(txtMaSP.getText())==false)
                JOptionPane.showMessageDialog(this,"M?? s???n ph???m ???? t???n t???i!");
            else if(KiemTraGiaTri()==false){
                JOptionPane.showMessageDialog(this, sb.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
                sb="";
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed
    
    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        //giu lai sp trc khi sua
        SanPham_DTO old = bus.dssp.set(tblSanPham.getSelectedRow(), sp);
        if (tblSanPham.getSelectedRow()>=0){
        sp.TenSP = txtTenSP.getText();
        sp.TenLoai = cbbLoaiSP.getSelectedItem().toString();
        if (LoaiSP_BUS.dslsp == null) {
                busLoai.DocLSP();
        }
        for(LoaiSP_DTO lsp : busLoai.dslsp){
            if(sp.TenLoai.equals(lsp.TenLoai)){
                sp.MaLoaiSP=lsp.MaLoaiSP;
            }
        }
        sp.GiaBan = txtGiaBan.getText();
        if(rbtnGam.isSelected()==true){
        sp.DonViTinh=txtSoDonVi.getText()+" gam";
        }else if(rbtnML.isSelected()==true){
            sp.DonViTinh=txtSoDonVi.getText()+" ml";
        }else{
            sp.DonViTinh=txtSoDonVi.getText()+" c??i";
        }
        sp.HinhAnhSP=linkAnh;
        bus.sua(sp);
        //cap nh???p dssv
        model.setValueAt(sp.TenSP, tblSanPham.getSelectedRow(), 1);
        model.setValueAt(sp.TenLoai, tblSanPham.getSelectedRow(), 2);
        model.setValueAt(sp.GiaBan, tblSanPham.getSelectedRow(), 3);
        model.setValueAt(sp.DonViTinh, tblSanPham.getSelectedRow(), 5);
        model.setValueAt(sp.HinhAnhSP, tblSanPham.getSelectedRow(), 6);
        tblSanPham.setModel(model);
        }
    }//GEN-LAST:event_btnSuaActionPerformed
    
    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int i=tblSanPham.getSelectedRow();
        String ma=txtMaSP.getText();
        if (i == -1) {
            JOptionPane.showMessageDialog(this, "B???n c???n ch???n s???n ph???m ????? x??a!", "L???i", JOptionPane.ERROR_MESSAGE);
        } else {
            int x = JOptionPane.showConfirmDialog(this, "B???n c?? ch???c ch???n mu???n x??a!");
            if (x == JOptionPane.YES_OPTION) {
                if (i >= 0) {
                    bus.xoa(ma);
                    SanPham_BUS.dssp.remove(i);
                    model.removeRow(i);
                    tblSanPham.setModel(model);
                    linkAnh="C:\\IDE java\\NetBeans-13\\JaVa\\ICYCos\\src\\icy\\HinhAnh_ICY\\SanPham\\SPMacDinh";
                    lbelChinhHinh.setIcon(bus.ResizeImage(String.valueOf(linkAnh), lbelChinhHinh));
                }
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed
    
    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        //set l???i m??u txt khi click v??o
        txtMaSP.setForeground(new Color(0,0,0));
        txtSoDonVi.setForeground(new Color(0,0,0));
        txtTenSP.setForeground(new Color(0,0,0));
        txtGiaBan.setForeground(new Color(0,0,0));
        //-------------------------
        int  i=tblSanPham.getSelectedRow();
        if(i>=0){
            sp=bus.dssp.get(i); 
            //hi???n ??? s???n ph???m
            txtMaSP.setText(sp.MaSP);
            txtTenSP.setText(sp.TenSP);
            for(LoaiSP_DTO lsp :busLoai.dslsp){
                if(sp.MaLoaiSP.equals(lsp.MaLoaiSP)){
                    cbbLoaiSP.setSelectedItem(lsp.TenLoai);
                }
            }
            txtGiaBan.setText(sp.GiaBan);
            //g??n ?????a ch??? ???nh v?? hi???n ???nh khi click
            linkAnh=sp.HinhAnhSP;
            lbelChinhHinh.setIcon(bus.ResizeImage(String.valueOf(linkAnh), lbelChinhHinh));
            //Hi???n b??n chi ti???t s???n ph???m
            lbeltenSP.setText(sp.TenSP);
            for(LoaiSP_DTO lsp : busLoai.dslsp){
                if(lsp.MaLoaiSP.equals(sp.MaLoaiSP)){
                    lbelLoai.setText("Lo???i s???n ph???m : "+lsp.TenLoai);
                }
            }
            lbelGia.setText("Gi?? b??n : "+sp.GiaBan+" VN??");
            lbelHinhAnh.setIcon(bus.ResizeImage(String.valueOf(linkAnh), lbelChinhHinh));
            for(LoaiSP_DTO lsp : busLoai.dslsp){
                if(lsp.MaLoaiSP.equals(sp.MaLoaiSP)){
                    txtThanhPhan.setText(lsp.ThanhPhan);
                    txtCongDung.setText(lsp.CongDungSP);
                }
            }
            // contains gi??p t??m chu???i con c?? trong chu???i s
            //replace gi??p thay th??? k?? t??? trong chu???i s
            String s=sp.DonViTinh;
            if(s.contains("gam")==true){
                rbtnGam.setSelected(true);
                txtSoDonVi.setText(s.replace(" gam",""));
            }else if(s.contains("ml")==true){
                rbtnML.setSelected(true);
                txtSoDonVi.setText(s.replace(" ml",""));
            }else{
                rbtnCai.setSelected(true);
                txtSoDonVi.setText(s.replace(" c??i",""));
            }
        }
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void btnCapNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhapActionPerformed
        tblSanPham.setModel(model);
    }//GEN-LAST:event_btnCapNhapActionPerformed

    private void txtMaSPFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMaSPFocusGained
        if(txtMaSP.getText().trim().toLowerCase().equalsIgnoreCase("nh???p m??")){
            txtMaSP.setText("");
            txtMaSP.setForeground(new Color(0,0,0) );
        }
    }//GEN-LAST:event_txtMaSPFocusGained

    private void txtMaSPFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMaSPFocusLost
        if(txtMaSP.getText().trim().equals("") 
           || txtMaSP.getText().trim().toLowerCase().equals("nh???p m??")){
            txtMaSP.setText("Nh???p m??");
            txtMaSP.setForeground(new Color(135,135,135));
        }
    }//GEN-LAST:event_txtMaSPFocusLost
    
    private void btnChinhHinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChinhHinhActionPerformed
        try {
        //???????ng d???n ban ?????u khi click v??o btnChinhAnh
        JFileChooser f = new JFileChooser("C:\\IDE java\\NetBeans-13\\JaVa\\ICYCos\\src\\icy\\HinhAnh_ICY\\SanPham");
        f.setDialogTitle("Open");
        f.showOpenDialog(null);
        File fTenAnh = f.getSelectedFile();
        //g??n link khi ch???n ???nh tr??n btnChinhAnh
        linkAnh = fTenAnh.getAbsolutePath().replace("\\","\\\\");
        //resize l???i ???nh
        lbelChinhHinh.setIcon(bus.ResizeImage(String.valueOf(linkAnh), lbelChinhHinh));
        //xu???t ra link ???nh ????? c???n khi g???p bug
        System.out.println(linkAnh);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "b???n ch??a ch???n ???nh!");
            System.out.println(linkAnh);
        }
    }//GEN-LAST:event_btnChinhHinhActionPerformed

    private void txtSoDonViFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSoDonViFocusGained
        if(txtSoDonVi.getText().trim().toLowerCase().equalsIgnoreCase("s??? ????n v???")){
            txtSoDonVi.setText("");
            txtSoDonVi.setForeground(new Color(0,0,0) );
        }
    }//GEN-LAST:event_txtSoDonViFocusGained

    private void txtSoDonViFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSoDonViFocusLost
        if(txtSoDonVi.getText().trim().equals("") 
           || txtSoDonVi.getText().trim().toLowerCase().equals("s??? ????n v???")){
            txtSoDonVi.setText("S??? ????n v???");
            txtSoDonVi.setForeground(new Color(135,135,135));
        }
    }//GEN-LAST:event_txtSoDonViFocusLost
    public void DocLoai(){
        if (LoaiSP_BUS.dslsp == null) {
            busLoai.DocLSP();
        }
        //c???p nh???t Jtable
        Vector header = new Vector();
        header.add("M?? lo???i");//t??n c???t table
        header.add("T??n lo???i");
        header.add("Th??nh ph???n");
        header.add("C??ng d???ng");
        if (modelLoai.getRowCount() == 0) {
            modelLoai = new DefaultTableModel(header, 0);
        }
        for (LoaiSP_DTO lsp : LoaiSP_BUS.dslsp) {
            //n???p d??? li???u cho m???i row
            Vector row = new Vector();
            row.add(lsp.MaLoaiSP);
            row.add(lsp.TenLoai);
            row.add(lsp.ThanhPhan);
            row.add(lsp.CongDungSP);
            modelLoai.addRow(row); //th??m row d??? li???u v??o model
            tblLoaiSP.setModel(modelLoai);
        }
    }
    public boolean MaLoaiDuyNhat(String x){
        for(LoaiSP_DTO lsp: busLoai.dslsp){
            if(lsp.MaLoaiSP.equals(x))
                return false;
        }
        return true;
    }
    String sbLoai="";
    public boolean KiemTraGiaTriLoai(){
        if (txtMaLoai.getText().equals("") || txtMaLoai.getText().equals("Nh???p m?? lo???i")) {
            sbLoai="M?? lo???i kh??ng ???????c ????? tr???ng! \n";
            txtMaLoai.setBackground(Color.PINK);
        } else {
            txtMaLoai.setBackground(Color.white);
        }
        if (txtTenLoai.getText().equals("") || txtTenLoai.getText().equals("Nh???p t??n lo???i")) {
            sbLoai=sbLoai+"T??n lo???i kh??ng ???????c ????? tr???ng! \n";
            txtTenLoai.setBackground(Color.PINK);
        } else {
            txtTenLoai.setBackground(Color.white);
        }
        if (txtThanhPhanLoai.getText().equals("") || txtThanhPhanLoai.getText().equals("Nh???p th??nh ph???n")) {
            sbLoai=sbLoai+"Th??nh ph???n kh??ng ???????c ????? tr???ng! \n";
            txtThanhPhanLoai.setBackground(Color.PINK);
        } else {
            txtThanhPhanLoai.setBackground(Color.white);
        }
        if (txtCongDungLoai.getText().equals("") || txtCongDungLoai.getText().equals("Nh???p c??ng d???ng")) {
            sbLoai=sbLoai+"C??ng d???ng kh??ng ???????c ????? tr???ng! \n";
            txtCongDungLoai.setBackground(Color.PINK);
        } else {
            txtCongDungLoai.setBackground(Color.white);
        }
        if (sbLoai.length() > 0) {
            return false;
        }else
        return true;
    }
    private void btnThemLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemLoaiActionPerformed
        if(MaLoaiDuyNhat(txtMaLoai.getText())==true && KiemTraGiaTriLoai()==true){
        lsp.MaLoaiSP = txtMaLoai.getText().toUpperCase();
        lsp.TenLoai= txtTenLoai.getText();
        lsp.ThanhPhan = txtThanhPhanLoai.getText();
        lsp.CongDungSP = txtCongDungLoai.getText();
        busLoai.them(lsp);
        //n???p d??? li???u cho m???i row
        Vector row = new Vector();
        row.add(lsp.MaLoaiSP);
        row.add(lsp.TenLoai);
        row.add(lsp.ThanhPhan);
        row.add(lsp.CongDungSP);
        modelLoai.addRow(row); //th??m row d??? li???u v??o modelLoai
        //n???p du lieu cua model v??o tblLoaiSP
        tblLoaiSP.setModel(modelLoai);
        //th??m v??o cbb lo???i s???n ph???m ??? tblSanPham
        cbbLoaiSP.addItem(lsp.TenLoai);
        JOptionPane.showMessageDialog(this,"th??m th??nh c??ng!");
        }else{
            if(MaLoaiDuyNhat(txtMaSP.getText())==false)
                JOptionPane.showMessageDialog(this,"M?? lo???i ???? t???n t???i!");
            else if(KiemTraGiaTriLoai()==false){
                JOptionPane.showMessageDialog(this, sbLoai.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
                sbLoai="";
            }
        }
    }//GEN-LAST:event_btnThemLoaiActionPerformed
    
    private void btnSuaLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaLoaiActionPerformed
        LoaiSP_DTO old = busLoai.dslsp.set(tblLoaiSP.getSelectedRow(), lsp);
        String TenLoaiCu = old.TenLoai;
        if (tblLoaiSP.getSelectedRow() >= 0) {
            lsp.TenLoai = txtTenLoai.getText();
            lsp.ThanhPhan = txtThanhPhanLoai.getText();
            lsp.CongDungSP = txtCongDungLoai.getText();
            busLoai.sua(lsp);
            //cap nh???p dslsp
            modelLoai.setValueAt(lsp.TenLoai, tblLoaiSP.getSelectedRow(), 1);
            modelLoai.setValueAt(lsp.ThanhPhan, tblLoaiSP.getSelectedRow(), 2);
            modelLoai.setValueAt(lsp.CongDungSP, tblLoaiSP.getSelectedRow(), 3);
            tblLoaiSP.setModel(modelLoai);
            //s???a v??o cbb
            cbbLoaiSP.removeItem(TenLoaiCu);
            cbbLoaiSP.addItem(txtTenLoai.getText());
            // cap nhap du lieu o san pham
            TableModel m = tblSanPham.getModel();
            for (int i = 0; i < SanPham_BUS.dssp.size(); i++) {
                sp.TenLoai = m.getValueAt(i, 2).toString();
                if (sp.TenLoai.equals(TenLoaiCu)) {
                    sp.TenLoai = txtTenLoai.getText();
                    m.setValueAt(sp.TenLoai, i, 2);
                    tblSanPham.setModel(m);
                }
            }
        }
    }//GEN-LAST:event_btnSuaLoaiActionPerformed

    private void btnXoaLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaLoaiActionPerformed
        int i=tblLoaiSP.getSelectedRow();
        String ma=txtMaLoai.getText();
        LoaiSP_DTO old = busLoai.dslsp.set(tblLoaiSP.getSelectedRow(), lsp);
        String TenLoaiCu = old.TenLoai;
        if (i == -1) {
            JOptionPane.showMessageDialog(this, "B???n c???n ch???n lo???i s???n ph???m ????? x??a!", "L???i", JOptionPane.ERROR_MESSAGE);
        } else {
            int x = JOptionPane.showConfirmDialog(this, "B???n c?? ch???c ch???n mu???n x??a!");
            if (x == JOptionPane.YES_OPTION) {
                if (i >= 0) {
                    busLoai.xoa(ma);
                    LoaiSP_BUS.dslsp.remove(i);
                    modelLoai.removeRow(i);
                    //x??a ??? cbb lo???i sp ??? tblSanPham
                    cbbLoaiSP.removeItem(txtTenLoai.getText());
                    // cap nhap du lieu o san pham
                    TableModel m = tblSanPham.getModel();
                    for (int j = 0; j < SanPham_BUS.dssp.size(); j++) {
                        sp.TenLoai = m.getValueAt(j, 2).toString();
                        if (sp.TenLoai.equals(TenLoaiCu)) {
                            sp.MaLoaiSP="CPL";
                            sp.TenLoai = "Ch??a ph??n lo???i";
                            bus.sua(sp);
                            m.setValueAt(sp.TenLoai, j, 2);
                            tblSanPham.setModel(m);
                        }
                    }
                    tblLoaiSP.setModel(modelLoai);
                }
            }
        }
    }//GEN-LAST:event_btnXoaLoaiActionPerformed

    private void btnCapNhatLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatLoaiActionPerformed
        tblLoaiSP.setModel(modelLoai);
    }//GEN-LAST:event_btnCapNhatLoaiActionPerformed

    private void tblLoaiSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLoaiSPMouseClicked
        //set l???i m??u txt khi click v??o
        txtMaLoai.setForeground(new Color(0,0,0));
        txtTenLoai.setForeground(new Color(0,0,0));
        txtThanhPhanLoai.setForeground(new Color(0,0,0));
        txtCongDungLoai.setForeground(new Color(0,0,0));
        //-------------------------
        int  i=tblLoaiSP.getSelectedRow();
        if(i>=0){
            lsp=busLoai.dslsp.get(i); 
            //hi???n ??? lo???i s???n ph???m
            txtMaLoai.setText(lsp.MaLoaiSP);
            txtTenLoai.setText(lsp.TenLoai);
            txtThanhPhanLoai.setText(lsp.ThanhPhan);
            txtCongDungLoai.setText(lsp.CongDungSP);
        }
    }//GEN-LAST:event_tblLoaiSPMouseClicked

    private void txtTenSPFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTenSPFocusGained
        if(txtTenSP.getText().trim().toLowerCase().equalsIgnoreCase("nh???p t??n")){
            txtTenSP.setText("");
            txtTenSP.setForeground(new Color(0,0,0) );
        }
    }//GEN-LAST:event_txtTenSPFocusGained

    private void txtTenSPFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTenSPFocusLost
        if(txtTenSP.getText().trim().equals("") 
           || txtTenSP.getText().trim().toLowerCase().equals("nh???p t??n")){
            txtTenSP.setText("Nh???p t??n");
            txtTenSP.setForeground(new Color(135,135,135));
        }
    }//GEN-LAST:event_txtTenSPFocusLost

    private void txtGiaBanFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtGiaBanFocusGained
        if(txtGiaBan.getText().trim().toLowerCase().equalsIgnoreCase("nh???p gi??")){
            txtGiaBan.setText("");
            txtGiaBan.setForeground(new Color(0,0,0) );
        }
    }//GEN-LAST:event_txtGiaBanFocusGained

    private void txtGiaBanFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtGiaBanFocusLost
        if(txtGiaBan.getText().trim().equals("") 
           || txtGiaBan.getText().trim().toLowerCase().equals("nh???p gi??")){
            txtGiaBan.setText("Nh???p gi??");
            txtGiaBan.setForeground(new Color(135,135,135));
        }
    }//GEN-LAST:event_txtGiaBanFocusLost

    private void txtMaLoaiFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMaLoaiFocusGained
        if(txtMaLoai.getText().trim().toLowerCase().equalsIgnoreCase("nh???p m?? lo???i")){
            txtMaLoai.setText("");
            txtMaLoai.setForeground(new Color(0,0,0) );
        }
    }//GEN-LAST:event_txtMaLoaiFocusGained

    private void txtMaLoaiFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMaLoaiFocusLost
        if(txtMaLoai.getText().trim().equals("") 
           || txtMaLoai.getText().trim().toLowerCase().equals("nh???p m?? lo???i")){
            txtMaLoai.setText("Nh???p m?? lo???i");
            txtMaLoai.setForeground(new Color(135,135,135));
        }
    }//GEN-LAST:event_txtMaLoaiFocusLost

    private void txtTenLoaiFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTenLoaiFocusGained
        if(txtTenLoai.getText().trim().toLowerCase().equalsIgnoreCase("nh???p t??n lo???i")){
            txtTenLoai.setText("");
            txtTenLoai.setForeground(new Color(0,0,0) );
        }
    }//GEN-LAST:event_txtTenLoaiFocusGained

    private void txtTenLoaiFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTenLoaiFocusLost
        if(txtTenLoai.getText().trim().equals("") 
           || txtTenLoai.getText().trim().toLowerCase().equals("nh???p t??n lo???i")){
            txtTenLoai.setText("Nh???p t??n lo???i");
            txtTenLoai.setForeground(new Color(135,135,135));
        }
    }//GEN-LAST:event_txtTenLoaiFocusLost

    private void txtThanhPhanLoaiFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtThanhPhanLoaiFocusGained
        if(txtThanhPhanLoai.getText().trim().toLowerCase().equalsIgnoreCase("nh???p th??nh ph???n")){
            txtThanhPhanLoai.setText("");
            txtThanhPhanLoai.setForeground(new Color(0,0,0) );
        }
    }//GEN-LAST:event_txtThanhPhanLoaiFocusGained

    private void txtThanhPhanLoaiFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtThanhPhanLoaiFocusLost
        if(txtThanhPhanLoai.getText().trim().equals("") 
           || txtThanhPhanLoai.getText().trim().toLowerCase().equals("nh???p th??nh ph???n")){
            txtThanhPhanLoai.setText("Nh???p th??nh ph???n");
            txtThanhPhanLoai.setForeground(new Color(135,135,135));
        }
    }//GEN-LAST:event_txtThanhPhanLoaiFocusLost

    private void txtCongDungLoaiFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCongDungLoaiFocusGained
        if(txtCongDungLoai.getText().trim().toLowerCase().equalsIgnoreCase("nh???p c??ng d???ng")){
            txtCongDungLoai.setText("");
            txtCongDungLoai.setForeground(new Color(0,0,0) );
        }
    }//GEN-LAST:event_txtCongDungLoaiFocusGained

    private void txtCongDungLoaiFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCongDungLoaiFocusLost
        if(txtCongDungLoai.getText().trim().equals("") 
           || txtCongDungLoai.getText().trim().toLowerCase().equals("nh???p c??ng d???ng")){
            txtCongDungLoai.setText("Nh???p c??ng d???ng");
            txtCongDungLoai.setForeground(new Color(135,135,135));
        }
    }//GEN-LAST:event_txtCongDungLoaiFocusLost

    private void txtMaSPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaSPKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtTenSP.requestFocus();
        }
    }//GEN-LAST:event_txtMaSPKeyPressed

    private void txtTenSPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTenSPKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            cbbLoaiSP.requestFocus();
        }
    }//GEN-LAST:event_txtTenSPKeyPressed

    private void cbbLoaiSPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbbLoaiSPKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtGiaBan.requestFocus();
        }
    }//GEN-LAST:event_cbbLoaiSPKeyPressed

    private void txtGiaBanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGiaBanKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtSoDonVi.requestFocus();
        }
    }//GEN-LAST:event_txtGiaBanKeyPressed

    private void txtMaLoaiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaLoaiKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtTenLoai.requestFocus();
        }
    }//GEN-LAST:event_txtMaLoaiKeyPressed

    private void txtTenLoaiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTenLoaiKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtThanhPhanLoai.requestFocus();
        }
    }//GEN-LAST:event_txtTenLoaiKeyPressed

    private void txtThanhPhanLoaiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtThanhPhanLoaiKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtCongDungLoai.requestFocus();
        }
    }//GEN-LAST:event_txtThanhPhanLoaiKeyPressed
    public void showTimKiemLoai(ArrayList<LoaiSP_DTO> ds){
        //c???p nh???t Jtable
        Vector header = new Vector();
        header.add("M?? lo???i");//t??n c???t table
        header.add("T??n lo???i");
        header.add("Th??nh ph???n");
        header.add("C??ng d???ng");
        DefaultTableModel m = new DefaultTableModel(header, 0);
        for(LoaiSP_DTO lsp : ds){
            //n???p d??? li???u cho m???i row
            Vector row = new Vector();
            row.add(lsp.MaLoaiSP);
            row.add(lsp.TenLoai);
            row.add(lsp.ThanhPhan);
            row.add(lsp.CongDungSP);
            m.addRow(row); //th??m row d??? li???u v??o model
        }
        tblLoaiSP.setModel(m);
    }
    private void btnTimLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimLoaiActionPerformed
        busLoai.timKiemLoai(cbbTimLoaiSP,txtTimLoai.getText().toUpperCase());
        if(busLoai.kq.size()==0){
            JOptionPane.showMessageDialog(this,"Kh??ng t??m th???y!");
        }else{
            showTimKiemLoai(busLoai.kq);
            JOptionPane.showMessageDialog(this,"T??m th???y "+busLoai.kq.size()+" lo???i s???n ph???m");
        }
    }//GEN-LAST:event_btnTimLoaiActionPerformed
    public void showTimKiemSP(ArrayList<SanPham_DTO> ds){
        //c???p nh???t Jtable
        Vector header = new Vector();
        header.add("M?? SP");//t??n c???t table
        header.add("T??n SP");
        header.add("Lo???i SP");
        header.add("Gi?? b??n");
        header.add("S??? l?????ng");
        header.add("????n v??? t??nh");
        header.add("H??nh ???nh");
        DefaultTableModel m = new DefaultTableModel(header, 0);
        for(SanPham_DTO sp : ds){
            //n???p d??? li???u cho m???i row
            Vector row = new Vector();
            row.add(sp.MaSP);
            row.add(sp.TenSP);
            for(LoaiSP_DTO lsp : LoaiSP_BUS.dslsp){
                if(lsp.MaLoaiSP.equals(sp.MaLoaiSP)){
                    row.add(lsp.TenLoai);
                }
            }
            row.add(sp.GiaBan);
            row.add(sp.SoLuong);
            row.add(sp.DonViTinh);
            row.add(sp.HinhAnhSP);
            m.addRow(row); //th??m row d??? li???u v??o model
        }
        tblSanPham.setModel(m);
    }
    public int Chon_Loai_Tim(){
        if(rbtnAnd.isSelected()){
            return 0;
        }else if(rbtnOr.isSelected()){
            return 1;
        }else
            return -1;
    }
    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        if (Chon_Loai_Tim() == -1) {
            bus.timKiem(cbbTim1, txtTim1.getText().toUpperCase());
            if (bus.kq.size() == 0) {
                JOptionPane.showMessageDialog(this, "Kh??ng t??m th???y!");
            } else {
                showTimKiemSP(bus.kq);
                JOptionPane.showMessageDialog(this, "T??m th???y " + bus.kq.size() + " s???n ph???m");
            }
        }else if(Chon_Loai_Tim() == 0){
            bus.Tim_AND(txtGiaBan1.getText(), txtGiaBan2.getText());
            if (bus.kqNC.size() == 0) {
                JOptionPane.showMessageDialog(this, "Kh??ng t??m th???y!");
            } else {
                showTimKiemSP(bus.kqNC);
                JOptionPane.showMessageDialog(this, "T??m th???y " + bus.kqNC.size() + " s???n ph???m");
            }
        }else if(Chon_Loai_Tim() == 1){
            bus.Tim_OR(txtSL1.getText(), txtSL2.getText());
            if (bus.kqNC.size() == 0) {
                JOptionPane.showMessageDialog(this, "Kh??ng t??m th???y!");
            } else {
                showTimKiemSP(bus.kqNC);
                JOptionPane.showMessageDialog(this, "T??m th???y " + bus.kqNC.size() + " s???n ph???m");
            }
        }
        
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void TimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TimKiemMouseClicked
        if (Chon_Loai_Tim() == -1 && !txtTim1.getText().equals("")) {
            //set l???i m??u txt khi click v??o
            txtMaSP.setForeground(new Color(0, 0, 0));
            txtSoDonVi.setForeground(new Color(0, 0, 0));
            txtTenSP.setForeground(new Color(0, 0, 0));
            txtGiaBan.setForeground(new Color(0, 0, 0));
            //-------------------------
            int i = tblSanPham.getSelectedRow();
            if (i >= 0) {
                sp = bus.kq.get(i);
                //hi???n ??? s???n ph???m
                txtMaSP.setText(sp.MaSP);
                txtTenSP.setText(sp.TenSP);
                for (LoaiSP_DTO lsp : busLoai.dslsp) {
                    if (sp.MaLoaiSP.equals(lsp.MaLoaiSP)) {
                        cbbLoaiSP.setSelectedItem(lsp.TenLoai);
                    }
                }
                txtGiaBan.setText(sp.GiaBan);
                //g??n ?????a ch??? ???nh v?? hi???n ???nh khi click
                linkAnh = sp.HinhAnhSP;
                lbelChinhHinh.setIcon(bus.ResizeImage(String.valueOf(linkAnh), lbelChinhHinh));
                //Hi???n b??n chi ti???t s???n ph???m
                lbeltenSP.setText(sp.TenSP);
                for (LoaiSP_DTO lsp : busLoai.dslsp) {
                    if (lsp.MaLoaiSP.equals(sp.MaLoaiSP)) {
                        lbelLoai.setText("Lo???i s???n ph???m : " + lsp.TenLoai);
                    }
                }
                lbelGia.setText("Gi?? b??n : " + sp.GiaBan + " VN??");
                lbelHinhAnh.setIcon(bus.ResizeImage(String.valueOf(linkAnh), lbelChinhHinh));
                for (LoaiSP_DTO lsp : busLoai.dslsp) {
                    if (lsp.MaLoaiSP.equals(sp.MaLoaiSP)) {
                        txtThanhPhan.setText(lsp.ThanhPhan);
                        txtCongDung.setText(lsp.CongDungSP);
                    }
                }
                // contains gi??p t??m chu???i con c?? trong chu???i s
                //replace gi??p thay th??? k?? t??? trong chu???i s
                String s = sp.DonViTinh;
                if (s.contains("gam") == true) {
                    rbtnGam.setSelected(true);
                    txtSoDonVi.setText(s.replace(" gam", ""));
                } else if (s.contains("ml") == true) {
                    rbtnML.setSelected(true);
                    txtSoDonVi.setText(s.replace(" ml", ""));
                } else {
                    rbtnCai.setSelected(true);
                    txtSoDonVi.setText(s.replace(" c??i", ""));
                }
            }
        }
    }//GEN-LAST:event_TimKiemMouseClicked

    private void TimKiemNCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TimKiemNCMouseClicked
        if (Chon_Loai_Tim() == 0 || Chon_Loai_Tim() == 1) {
        //set l???i m??u txt khi click v??o
        txtMaSP.setForeground(new Color(0,0,0));
        txtSoDonVi.setForeground(new Color(0,0,0));
        txtTenSP.setForeground(new Color(0,0,0));
        txtGiaBan.setForeground(new Color(0,0,0));
        //-------------------------
        int  i=tblSanPham.getSelectedRow();
        if(i>=0){
            sp=bus.kqNC.get(i); 
            //hi???n ??? s???n ph???m
            txtMaSP.setText(sp.MaSP);
            txtTenSP.setText(sp.TenSP);
            for(LoaiSP_DTO lsp :busLoai.dslsp){
                if(sp.MaLoaiSP.equals(lsp.MaLoaiSP)){
                    cbbLoaiSP.setSelectedItem(lsp.TenLoai);
                }
            }
            txtGiaBan.setText(sp.GiaBan);
            //g??n ?????a ch??? ???nh v?? hi???n ???nh khi click
            linkAnh=sp.HinhAnhSP;
            lbelChinhHinh.setIcon(bus.ResizeImage(String.valueOf(linkAnh), lbelChinhHinh));
            //Hi???n b??n chi ti???t s???n ph???m
            lbeltenSP.setText(sp.TenSP);
            for(LoaiSP_DTO lsp : busLoai.dslsp){
                if(lsp.MaLoaiSP.equals(sp.MaLoaiSP)){
                    lbelLoai.setText("Lo???i s???n ph???m : "+lsp.TenLoai);
                }
            }
            lbelGia.setText("Gi?? b??n : "+sp.GiaBan+" VN??");
            lbelHinhAnh.setIcon(bus.ResizeImage(String.valueOf(linkAnh), lbelChinhHinh));
            for(LoaiSP_DTO lsp : busLoai.dslsp){
                if(lsp.MaLoaiSP.equals(sp.MaLoaiSP)){
                    txtThanhPhan.setText(lsp.ThanhPhan);
                    txtCongDung.setText(lsp.CongDungSP);
                }
            }
            // contains gi??p t??m chu???i con c?? trong chu???i s
            //replace gi??p thay th??? k?? t??? trong chu???i s
            String s=sp.DonViTinh;
            if(s.contains("gam")==true){
                rbtnGam.setSelected(true);
                txtSoDonVi.setText(s.replace(" gam",""));
            }else if(s.contains("ml")==true){
                rbtnML.setSelected(true);
                txtSoDonVi.setText(s.replace(" ml",""));
            }else{
                rbtnCai.setSelected(true);
                txtSoDonVi.setText(s.replace(" c??i",""));
            }
        }
        }
    }//GEN-LAST:event_TimKiemNCMouseClicked

    private void txtGiaBan1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGiaBan1KeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtGiaBan2.requestFocus();
        }
    }//GEN-LAST:event_txtGiaBan1KeyPressed

    private void txtSL1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSL1KeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER) {
            txtSL2.requestFocus();
        }
    }//GEN-LAST:event_txtSL1KeyPressed
//-----------------------Li??n k???t c??c ch???c n??ng----------------//
    private void btnNhapHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapHangActionPerformed
        if (!btnDangNhap.getText().equals(" ????ng nh???p") && checkQuyenQLGD() == true) {
            if (btnNhapHang.isSelected() == true) {
                SP.setVisible(false);
                NH.setVisible(true);
                NH.setLocationRelativeTo(null);
            }
        } else {
            JOptionPane.showMessageDialog(this, "B???n kh??ng ???????c s??? d???ng ch???c n??ng n??y!");
        }
    }//GEN-LAST:event_btnNhapHangActionPerformed

    private void btnHoTroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoTroActionPerformed
        if (!btnDangNhap.getText().equals(" ????ng nh???p")) {
            if (btnHoTro.isSelected() == true) {
                SP.setVisible(false);
                HT.setVisible(true);
                HT.setLocationRelativeTo(null);
            }
        } else {
            JOptionPane.showMessageDialog(this, "B???n kh??ng ???????c s??? d???ng ch???c n??ng n??y!");
        }
    }//GEN-LAST:event_btnHoTroActionPerformed
//-------------Nh???p v?? xu???t Excel-----------------------//
    private void btnXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatActionPerformed
        try {
            String s=JOptionPane.showInputDialog(this,"M???i nh???p t??n file c???n xu???t");
            XSSFWorkbook wb = new XSSFWorkbook();
            XSSFSheet sheet = wb.createSheet(s);
            XSSFRow row = null;
            Cell cell = null;
            row = sheet.createRow(3);
            
            cell=row.createCell(0,CellType.STRING);
            cell.setCellValue("MaSP");
            
            cell=row.createCell(1,CellType.STRING);
            cell.setCellValue("TenSP");
            
            cell=row.createCell(2,CellType.STRING);
            cell.setCellValue("LoaiSP");
            
            cell=row.createCell(3,CellType.STRING);
            cell.setCellValue("GiaBan");
            
            cell=row.createCell(4,CellType.STRING);
            cell.setCellValue("SoLuong");
            
            cell=row.createCell(5,CellType.STRING);
            cell.setCellValue("DonViTinh");
            
            cell=row.createCell(6,CellType.STRING);
            cell.setCellValue("HinhAnh");
            
            for(int i=0 ;i<SanPham_BUS.dssp.size();i++)
            {
                row =sheet.createRow(4+i);
                
                cell= row.createCell(0,CellType.STRING);
                cell.setCellValue(bus.dssp.get(i).getMaSP());
                
                cell= row.createCell(1,CellType.STRING);
                cell.setCellValue(bus.dssp.get(i).getTenSP());
                
                cell = row.createCell(2, CellType.STRING);
                for (LoaiSP_DTO lsp : LoaiSP_BUS.dslsp) {
                    if (lsp.MaLoaiSP.equals(bus.dssp.get(i).getMaLoaiSP())) {
                        cell.setCellValue(lsp.TenLoai);
                    }
                }

                cell= row.createCell(3,CellType.STRING);
                cell.setCellValue(bus.dssp.get(i).getGiaBan());
                
                cell= row.createCell(4,CellType.STRING);
                cell.setCellValue(bus.dssp.get(i).getSoLuong());
                
                cell= row.createCell(5,CellType.STRING);
                cell.setCellValue(bus.dssp.get(i).getDonViTinh());
                
                cell= row.createCell(6,CellType.STRING);
                cell.setCellValue(bus.dssp.get(i).getHinhAnhSP());

            }
            File f = new File("C:\\IDE java\\NetBeans-13\\JaVa\\ICYCos\\src\\icy\\FileExcel\\"+s+".xlsx");
            try {
                FileOutputStream fi = new FileOutputStream(f);
                wb.write(fi);
                JOptionPane.showInternalMessageDialog(null, "Xu???t th??nh c??ng!");
                fi.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnXuatActionPerformed

    private void btnNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapActionPerformed
        File excelFile;
        FileInputStream excelFIS = null;
        BufferedInputStream excelBIS = null;
        XSSFWorkbook excelImportToJTable = null;
        String defaultCurrentDirectoryPath = "C:\\IDE java\\NetBeans-13\\JaVa\\ICYCos\\src\\icy\\FileExcel";
        JFileChooser excelFileChooser = new JFileChooser(defaultCurrentDirectoryPath);
        excelFileChooser.setDialogTitle("Select Excel File");
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlsm");
        excelFileChooser.setFileFilter(fnef);
        int excelChooser = excelFileChooser.showOpenDialog(null);
        if (excelChooser == JFileChooser.APPROVE_OPTION) {
            try {
                excelFile = excelFileChooser.getSelectedFile();
                excelFIS = new FileInputStream(excelFile);
                excelBIS = new BufferedInputStream(excelFIS);
                excelImportToJTable = new XSSFWorkbook(excelBIS);
                XSSFSheet excelSheet = excelImportToJTable.getSheetAt(0);

                for (int i = 1; i <=excelSheet.getLastRowNum(); i++) {
                    SanPham_DTO sp=new SanPham_DTO();
                    XSSFRow excelRow = excelSheet.getRow(i);
                    sp.MaSP = excelRow.getCell(0).toString();
                    sp.TenSP = excelRow.getCell(1).toString();
                    for (LoaiSP_DTO lsp : LoaiSP_BUS.dslsp) {
                        if (lsp.TenLoai.equals(excelRow.getCell(2).toString())) {
                            sp.MaLoaiSP=lsp.MaLoaiSP;
                            sp.TenLoai = excelRow.getCell(2).toString();
                        }
                    }
                    sp.GiaBan = excelRow.getCell(3).toString();
                    sp.SoLuong = excelRow.getCell(4).toString();
                    sp.DonViTinh = excelRow.getCell(5).toString();
                    sp.HinhAnhSP = excelRow.getCell(6).toString();
                    if(excelRow.getCell(6).toString().isEmpty()){
                        sp.HinhAnhSP="";
                    }
                    bus.them(sp);
                    //n???p d??? li???u cho m???i row
                    Vector row = new Vector();
                    row.add(sp.MaSP);
                    row.add(sp.TenSP);
                    row.add(sp.TenLoai);
                    row.add(sp.GiaBan);
                    row.add(sp.SoLuong);
                    row.add(sp.DonViTinh);
                    row.add(sp.HinhAnhSP);
                    model.addRow(row);
                    tblSanPham.setModel(model);
                }
                JOptionPane.showMessageDialog(null, "Imported Th??nh c??ng !!.....");
            } catch (IOException iOException) {
                JOptionPane.showMessageDialog(null, iOException.getMessage());
            } finally {
                try {
                    if (excelFIS != null) {
                        excelFIS.close();
                    }
                    if (excelBIS != null) {
                        excelBIS.close();
                    }
                    if (excelImportToJTable != null) {
                        excelImportToJTable.close();
                    }
                } catch (IOException iOException) {
                    JOptionPane.showMessageDialog(null, iOException.getMessage());
                }
            }
        }
    }//GEN-LAST:event_btnNhapActionPerformed
public boolean checkQuyenQLGD() {
        for (QLNV_DTO nv : QLNV_BUS.dsnv) {
            if (btnDangNhap.getText().equals(nv.Ten)) {
                if (nv.ChucVu.equals("Qu???n l??") || nv.ChucVu.equals("Gi??m ?????c")) {
                    return true;
                }
            }
        }
        return false;
    }
    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeActionPerformed
        if (!btnDangNhap.getText().equals(" ????ng nh???p") && checkQuyenQLGD() == true) {
            if (btnThongKe.isSelected() == true) {
                SP.setVisible(false);
                TK.setVisible(true);
                TK.setLocationRelativeTo(null);
            }
        } else {
            JOptionPane.showMessageDialog(this, "B???n kh??ng ???????c s??? d???ng ch???c n??ng n??y!");
        }
    }//GEN-LAST:event_btnThongKeActionPerformed

    private void btnkhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkhuyenMaiActionPerformed
        if (!btnDangNhap.getText().equals(" ????ng nh???p")) {
            if (btnkhuyenMai.isSelected() == true) {
                SP.setVisible(false);
                KM.setVisible(true);
                KM.setLocationRelativeTo(null);
            }
        } else {
            JOptionPane.showMessageDialog(this, "B???n kh??ng ???????c s??? d???ng ch???c n??ng n??y!");
        }
    }//GEN-LAST:event_btnkhuyenMaiActionPerformed

    private void btnKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKhachHangActionPerformed
        if (!btnDangNhap.getText().equals(" ????ng nh???p")) {
            if (btnKhachHang.isSelected() == true) {
                SP.setVisible(false);
                KH.setVisible(true);
                KH.setLocationRelativeTo(null);
            }
        } else {
            JOptionPane.showMessageDialog(this, "B???n kh??ng ???????c s??? d???ng ch???c n??ng n??y!");
        }
    }//GEN-LAST:event_btnKhachHangActionPerformed

    private void btnDoanhThuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoanhThuActionPerformed
        if (!btnDangNhap.getText().equals(" ????ng nh???p") && checkQuyenQLGD() == true) {
            if (btnDoanhThu.isSelected() == true) {
                DT.setVisible(true);
                DT.setLocationRelativeTo(null);
            }
        } else {
            JOptionPane.showMessageDialog(this, "B???n kh??ng ???????c s??? d???ng ch???c n??ng n??y!");
        }
    }//GEN-LAST:event_btnDoanhThuActionPerformed

    private void btnLienHeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLienHeActionPerformed
        JOptionPane.showMessageDialog(this,"B???n vui l??ng ch???n ch???c n??ng h??? tr??? ????? li??n h???!");
    }//GEN-LAST:event_btnLienHeActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        SP.setVisible(false);
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnHuongDanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuongDanActionPerformed
         if(btnHuongDan.isSelected()==true){
            HD.setVisible(true);
            HD.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_btnHuongDanActionPerformed

    private void btnDonHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDonHangActionPerformed
        if (!btnDangNhap.getText().equals(" ????ng nh???p")) {
            if (btnDonHang.isSelected() == true) {
                SP.setVisible(false);
                BH.setVisible(true);
                BH.setLocationRelativeTo(null);
            }
        } else {
            JOptionPane.showMessageDialog(this, "B???n kh??ng ???????c s??? d???ng ch???c n??ng n??y!");
        }
    }//GEN-LAST:event_btnDonHangActionPerformed

    private void btnNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhanVienActionPerformed
        if (!btnDangNhap.getText().equals(" ????ng nh???p") && checkQuyenQLGD() == true) {
            if (btnNhanVien.isSelected() == true) {
                SP.setVisible(false);
                NV.setVisible(true);
                NV.setLocationRelativeTo(null);
            }
        } else {
            JOptionPane.showMessageDialog(this, "B???n kh??ng ???????c s??? d???ng ch???c n??ng n??y!");
        }
    }//GEN-LAST:event_btnNhanVienActionPerformed
    
    // ????? set l???i t??n ng ????ng nh???p v?? hi???n profile
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
            java.util.logging.Logger.getLogger(SanPham_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SanPham_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SanPham_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SanPham_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SP.setVisible(true);
                SP.setLocationRelativeTo(null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhap;
    private javax.swing.JButton btnCapNhatLoai;
    private javax.swing.JButton btnChinhHinh;
    private javax.swing.JToggleButton btnDangNhap;
    private javax.swing.JToggleButton btnDoanhThu;
    private javax.swing.JToggleButton btnDonHang;
    private javax.swing.JToggleButton btnHoTro;
    private javax.swing.JButton btnHuongDan;
    private javax.swing.JToggleButton btnKhachHang;
    private javax.swing.JButton btnLienHe;
    private javax.swing.JToggleButton btnNhanVien;
    private javax.swing.JButton btnNhap;
    private javax.swing.JToggleButton btnNhapHang;
    private javax.swing.JToggleButton btnSanPham;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnSuaLoai;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThemLoai;
    private javax.swing.JButton btnThoat;
    private javax.swing.JToggleButton btnThongKe;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnTimLoai;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoaLoai;
    private javax.swing.JButton btnXuat;
    private javax.swing.JToggleButton btnkhuyenMai;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JComboBox<String> cbbLoaiSP;
    private javax.swing.JComboBox<String> cbbTim1;
    private javax.swing.JComboBox<String> cbbTimLoaiSP;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane4;
    private javax.swing.JLabel lbelChinhHinh;
    private javax.swing.JLabel lbelGia;
    private javax.swing.JLabel lbelHinhAnh;
    private javax.swing.JLabel lbelLoai;
    private javax.swing.JLabel lbeltenSP;
    private javax.swing.JPanel panelCTSP;
    private javax.swing.JPanel panelSanPham;
    private javax.swing.JRadioButton rbtnAnd;
    private javax.swing.JRadioButton rbtnCai;
    private javax.swing.JRadioButton rbtnGam;
    private javax.swing.JRadioButton rbtnML;
    private javax.swing.JRadioButton rbtnOr;
    private javax.swing.JTable tblLoaiSP;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextPane txtCongDung;
    private javax.swing.JTextPane txtCongDungLoai;
    private javax.swing.JTextField txtGiaBan;
    private javax.swing.JTextField txtGiaBan1;
    private javax.swing.JTextField txtGiaBan2;
    private javax.swing.JTextField txtMaLoai;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtSL1;
    private javax.swing.JTextField txtSL2;
    private javax.swing.JTextField txtSoDonVi;
    private javax.swing.JTextField txtTenLoai;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JTextPane txtThanhPhan;
    private javax.swing.JTextPane txtThanhPhanLoai;
    private javax.swing.JTextField txtTim1;
    private javax.swing.JTextField txtTimLoai;
    // End of variables declaration//GEN-END:variables
}
