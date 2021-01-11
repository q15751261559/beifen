package southWind.frame;

import southWind.entity.MyTable;
import southWind.entity.Protect;
import southWind.entity.User;
import southWind.entity.Vo.UserVo;
import southWind.entity.order;
import southWind.factory.DaoFactory;
import southWind.utils.ResultEntity;
import sun.swing.table.DefaultTableCellHeaderRenderer;

import javax.swing.*;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.*;
import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MainPanel extends JFrame {
    private JPanel mainPanel;
    private JPanel centerPanel;
    private JPanel adminPanel;
    private JPanel memberPanel;
    private JPanel userPanel;
    private JPanel rewardPanel;
    private JPanel TablePanel;
    private JPanel topPanel;
    private JButton 订单管理Button;
    private JButton 客户管理Button;
    private JButton 员工管理Button;
    private JTextField searchField;
    private JButton 搜索Button;
    private JButton 保存全部Button;
    private JButton 重置Button;
    private JPanel orderPanel;
    private JButton 新增Button;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JPanel addUserPanel;
    private JTextField userNameField;
    private JTextField userPhoneField;
    private JTextField userAddressField;
    private JButton 新增客户Button;
    private JLabel userNameUnderLabel;
    String userName;
    String account;
    private final CardLayout c;
    private MyTable table;
    private String type;
    private String user_type;


    public static void main(String[] args) {
        ResultEntity resultEntity=ResultEntity.builder()
                .code(0)
                .build();
        new MainPanel(resultEntity);
    }
    public MainPanel(ResultEntity resultEntity){
        int userType=resultEntity.getCode();
        account=resultEntity.getUserAccount();
        userName=resultEntity.getUserName();
        this.setTitle(userName);
        init();
        c=new CardLayout();
        centerPanel.setLayout(c);
        centerPanel.add("0", adminPanel);
        centerPanel.add("1", memberPanel);
        centerPanel.add("2", userPanel);
        centerPanel.add("3", rewardPanel);
        if (userType==0) {
            user_type="管理员登录";
            c.show(centerPanel, "0");
            List<UserVo> list= null;
            try {
                list = DaoFactory.getBasicUserDaoInstance().findBasicUserAll();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            showUserTable(list);
        }
        if (userType==1) {
            user_type="客户登录";
            c.show(centerPanel, "0");
            System.out.println(resultEntity.getUserId());
            新增Button.setVisible(false);
            保存全部Button.setVisible(false);
            searchField.setVisible(false);
            重置Button.setVisible(false);
            搜索Button.setVisible(false);
            员工管理Button.setVisible(false);
            List<UserVo> list= null;
            try {
                list=DaoFactory.getBasicUserDaoInstance().findBasicUserByUserId(resultEntity.getUserId());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            showUserTable(list);
        }
        客户管理Button.addActionListener(e -> {
            List<UserVo> list= null;
            if (user_type.equals("客户登录")){
                try {
                    list=DaoFactory.getBasicUserDaoInstance().findBasicUserByUserId(resultEntity.getUserId());
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
                showUserTable(list);
            }
            if (user_type.equals("管理员登录")) {
                try {
                    list = DaoFactory.getBasicUserDaoInstance().findBasicUserAll();
                } catch (SQLException c) {
                    c.printStackTrace();
                }
                showUserTable(list);
            }
        });
        订单管理Button.addActionListener(e -> {
            if (user_type.equals("客户登录"))
            {
                try {
                    showOrderTable(DaoFactory.getBasicUserDaoInstance().findBasicOrderByOrderId(resultEntity.getUserId()));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            if (user_type.equals("管理员登录")) {
                try {
                    showOrderTable(DaoFactory.getBasicUserDaoInstance().findBasicOrderAll());
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        搜索Button.addActionListener(e -> {
            String Name= searchField.getText().trim();
            if(type.equals("客户")) {
                List<UserVo> list = null;
                try {
                    list = DaoFactory.getBasicUserDaoInstance().findBasicUserByUserName(Name);
                } catch (SQLException throwable) {
                    throwable.printStackTrace();
                }
                showUserTable(list);
            }
            if (type.equals("订单"))
            {
                List<order> list = null;
                try {
                    list = DaoFactory.getBasicUserDaoInstance().findBasicOrderByOrderName(Name);
                } catch (SQLException throwable) {
                    throwable.printStackTrace();
                }
                showOrderTable(list);
            }
        });
        保存全部Button.addActionListener(e -> {
            if (type.equals("客户")) {
                int row = table.getRowCount();
                for (int i = 0; i < row; i++) {
                    User user = new User();
                    user.setUserId(table.getValueAt(i, 0).toString());
                    user.setUserName(table.getValueAt(i, 1).toString());
                    user.setUserPhone(table.getValueAt(i, 2).toString());
                    user.setUserAddress(table.getValueAt(i, 3).toString());
                    user.setUserCredit(table.getValueAt(i, 4).toString());
                    System.out.println(user.getUserId() + user.getUserName() + user.getUserPhone() + user.getUserAddress() + user.getUserCredit());
                    try {
                        DaoFactory.getUserManagementDaoInstance().updateUser(user);
                    } catch (SQLException throwable) {
                        JOptionPane.showMessageDialog(this, "保存出错");
                        throwable.printStackTrace();
                    }
                }
                JOptionPane.showMessageDialog(this, "保存成功");
            }
            if (type.equals("订单"))
            {
                int row = table.getRowCount();
                for (int i = 0; i < row; i++) {
                    order order = new order();
                    order.setOrderId(table.getValueAt(i, 0).toString());
                    order.setOrderProductId(table.getValueAt(i, 4).toString());
                    try {
                        DaoFactory.getUserManagementDaoInstance().updateOrder(order);
                    } catch (SQLException throwable) {
                        JOptionPane.showMessageDialog(this, "保存出错");
                        throwable.printStackTrace();
                    }
                }
                JOptionPane.showMessageDialog(this, "保存成功");
            }
        } );
        重置Button.addActionListener(e -> {
            if (type.equals("客户")) {
                List<UserVo> list = null;
                try {
                    list = DaoFactory.getBasicUserDaoInstance().findBasicUserAll();
                } catch (SQLException c) {
                    c.printStackTrace();
                }
                showUserTable(list);
            }
            if (type.equals("订单"))
            {
                try {
                    showOrderTable(DaoFactory.getBasicUserDaoInstance().findBasicOrderAll());
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        新增Button.addActionListener(e -> {
            boolean visible=addUserPanel.isVisible();
            if(!visible)
            {
                leftPanel.setPreferredSize(new Dimension(200,this.getHeight()-100));
            }else {
                leftPanel.setPreferredSize(new Dimension(0,this.getHeight()-100));
            }
            addUserPanel.setVisible(!visible);
        });
        userNameField.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                userNameField.setText("");
            }
        });
        userPhoneField.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                userPhoneField.setText("");
            }
        });
        userAddressField.addFocusListener(new FocusAdapter() {
            public void focusGained(FocusEvent e) {
                userAddressField.setText("");
            }
        });
        新增客户Button.addActionListener(e -> {
            User user=new User();
            String userName=userNameField.getText().trim();
            String userPhone=userPhoneField.getText().trim();
            String address=userAddressField.getText().trim();
            if (userName.equals("")||userPhone.equals("")||address.equals("")||userName.equals("新增客户姓名")||userPhone.equals("新增客户联系方式")||address.equals("新增客户地址"))
            {
                JOptionPane.showMessageDialog(this,"输入不能为空");
            }
            else {
                user.setUserName(userNameField.getText().trim());
                user.setUserPhone(userPhoneField.getText().trim());
                user.setUserAddress(userAddressField.getText().trim());
                try {
                    DaoFactory.getUserManagementDaoInstance().insertUser(user);
                    JOptionPane.showMessageDialog(this, "新增成功");
                } catch (SQLException throwable) {
                    throwable.printStackTrace();
                }
                try {
                    showUserTable(DaoFactory.getBasicUserDaoInstance().findBasicUserAll());
                } catch (SQLException throwable) {
                    throwable.printStackTrace();
                }
            }
        });
    }
    private void init() {
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
    }


    private void showMember()
    {
        centerPanel.removeAll();
        JPanel twoPanel=new JPanel();
        JLabel label=new JLabel();
        label.setText("员工");
        twoPanel.add(label);
        centerPanel.add(twoPanel);
        //刷新主体内容面板
        centerPanel.revalidate();
    }
    private void showUser()
    {
        centerPanel.removeAll();
        JPanel tPanel=new JPanel();
        JLabel label=new JLabel();
        label.setText("用户");
        tPanel.add(label);
        centerPanel.add(tPanel);
        //刷新主体内容面板
        centerPanel.revalidate();
    }

    private void showFour()
    {
        centerPanel.removeAll();
        JPanel fPanel=new JPanel();
        JLabel label=new JLabel();
        label.setText("4号卡片");
        fPanel.add(label);
        centerPanel.add(fPanel);
        //刷新主体内容面板
        centerPanel.revalidate();
    }

    private void showAdmin() {
        //移除原有数据
        TablePanel.removeAll();
        //从Service层获取到所有院系列表
//        List<Department> departmentList = ServiceFactory.getDepartmentServiceInstance().selectAll();
        //获取总数
//        int len = departmentList.size();
//        //根据院系总数删除行数（每行放4个）
//        int row = len % 4 == 0 ? len / 4 : len / 4 + 1;
//        //创建一个网格布局，每行4列，指定水平和垂直间距
//        GridLayout gridLayout = new GridLayout(row, 4,  15, 15);
//        centerPanel.setLayout(gridLayout);
//        for (Department department : departmentList) {
//            //给每个院系对象创建一个面板
//            JPanel dePanel = new JPanel();
//            //设置合适大小
//            dePanel.setPreferredSize(new Dimension(200, 200));
//            //将院系名称设置给面板标题
//            dePanel.setBorder(BorderFactory.createTitledBorder(department.getDepartmentName()));
//            dePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 10));
//            JLabel nameLabel = new JLabel(department.getDepartmentName());
//            //新建一个JLabel标签,用来放置院系logo，并指定大小
//            JLabel logoLabel = new JLabel("<html><img src='" + department.getLogo() + "' width='500' height='500'/></html>");
//            //占位空白标签
//            JLabel blankLabel = new JLabel();
//            //新建一个删除按钮
//            JButton delBtn = new JButton("删除");
//
//            //指令返回数据库
//            delBtn.addActionListener(e -> {
//                Integer id = department.getId();
//                System.out.println(id);
//                ServiceFactory.delectDepartmentSerivceInstance().delectDep(id);
//                JOptionPane.showMessageDialog(null, "删除成功");
//                showDepartments();
//            });
//
//            //院系名称标签加入院系面板
//            dePanel.add(nameLabel);
////            按钮加入院系面板
//            dePanel.add(delBtn);
//            //图标标签加入院系面板
//            dePanel.add(logoLabel);
//            //院系面板加入主体内容面板
        JPanel dePanel=new JPanel();
        JLabel label=new JLabel();
        label.setText("管理员");
        dePanel.add(label);
            centerPanel.add(dePanel);
            //刷新主体内容面板
            centerPanel.revalidate();
    }
    private void showUserTable(List<UserVo> List){
        if (user_type.equals("管理员登录")) {
            新增Button.setVisible(true);
        }
        type="客户";
        新增Button.setText("新增客户(切换显示)");
        TablePanel.removeAll();
        table = new MyTable();
        //表格数据模型
        DefaultTableModel model = new DefaultTableModel(){
            //除第一列外均可编辑
            public boolean isCellEditable(int row,int column)
            {
                if (user_type.equals("客户登录"))
                {
                    return false;
                }
                else {
                    if (column == 0) {
                        return false;
                    } else {
                        return true;
                    }
                }
            }
        };
        table.setModel(model);
        model.setColumnIdentifiers(new String[]{"客户编号", "客户姓名", "联系方式", "联系地址", "信用度"});
        for (UserVo user : List) {
            Object[] object = new Object[]{user.getId(), user.getName(), user.getPhone(), user.getAddress(), user.getCredit()};
            model.addRow(object);
        }
        //获得表头
        JTableHeader head = table.getTableHeader();
        //表头居中
        DefaultTableCellHeaderRenderer hr = new DefaultTableCellHeaderRenderer();
        hr.setHorizontalAlignment(JLabel.CENTER);
        head.setDefaultRenderer(hr);
        //设置表头大小
        head.setPreferredSize(new Dimension(head.getWidth(), 40));
        //设置表头字体
        head.setFont(new Font("宋体", Font.PLAIN, 16));
        //设置表格行高
        table.setRowHeight(35);
        //表格背景色
        table.setBackground(new Color(176, 195, 222));
        //表格内容居中
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, r);
        //表格加入滚动面板,水平垂直方向带滚动条
        JScrollPane scrollPane = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
//      对每个JList增加弹出菜单
        JPopupMenu jPopupMenu = new JPopupMenu();
        JMenuItem baocun = new JMenuItem("保存当前行");
        JMenuItem deleteItem = new JMenuItem("删除");
        JMenuItem userOrder = new JMenuItem("查看选中用户订单");
        userOrder.addActionListener(e -> {
            int row = table.getSelectedRow();
            String userId= (String) table.getValueAt(row,0);
            List<order> orders=null;
            if (row==-1)
            {
                JOptionPane.showMessageDialog(this,"选中数据才能查看");
            }else {
                try {
                    orders=DaoFactory.getBasicUserDaoInstance().findBasicOrderByOrderId(userId);
                    showOrderTable(orders);
                } catch (SQLException throwable) {
                    throwable.printStackTrace();
                }
            }
        });
        jPopupMenu.add(userOrder);
        jPopupMenu.add(baocun);
        baocun.addActionListener(e -> {
            int row = table.getSelectedRow();
            System.out.println(row);
            User user=new User();
            if (row==-1)
            {
                JOptionPane.showMessageDialog(this,"选中数据才能保存");
            }else {
                user.setUserId(table.getValueAt(row,0).toString());
                user.setUserName(table.getValueAt(row, 1).toString());
                user.setUserPhone(table.getValueAt(row, 2).toString());
                user.setUserAddress(table.getValueAt(row, 3).toString());
                user.setUserCredit(table.getValueAt(row,4).toString());
                System.out.println(user.getUserId()+user.getUserName()+user.getUserPhone()+user.getUserAddress()+user.getUserCredit());
                try {
                    DaoFactory.getUserManagementDaoInstance().updateUser(user);
                    JOptionPane.showMessageDialog(this,"保存成功");
                } catch (SQLException throwable) {
                    throwable.printStackTrace();
                }
            }
        });
        deleteItem.addActionListener(e -> {
            int row = table.getSelectedRow();
            User user=new User();
            if (row==-1)
            {
                JOptionPane.showMessageDialog(this,"选中数据才能删除");
            }else {
                user.setUserId(table.getValueAt(row,0).toString());
                System.out.println(user.getUserId());
                try {
                    DaoFactory.getUserManagementDaoInstance().removeUser(user);
                    model.removeRow(row);
                    JOptionPane.showMessageDialog(this,"删除成功");
                } catch (SQLException throwable) {
                    throwable.printStackTrace();
                }
            }
        });
        jPopupMenu.add(deleteItem);
        table.add(jPopupMenu);
        table.addMouseListener(new MouseListener(){
            public void mouseClicked(MouseEvent e) {
                if(user_type.equals("管理员登录")) {
                    if (e.getButton() == 3) {
                        int right = table.rowAtPoint(e.getPoint());
                        System.out.println(right);
                        table.setRowSelectionInterval(right, right);
                        jPopupMenu.show(table, e.getX() + 15, e.getY() + 10);
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
            });
        TablePanel.add(scrollPane);
        TablePanel.revalidate();
    }
    private void showOrderTable(List<order> List)
    {
        新增Button.setVisible(false);
        type="订单";
        新增Button.setText("新增订单(切换显示)");
        TablePanel.removeAll();
        table = new MyTable();
        //表格数据模型
        DefaultTableModel model = new DefaultTableModel(){
            //只有第六列可以编辑
            public boolean isCellEditable(int row,int column)
            {
                if (user_type.equals("客户登录"))
                {
                    return false;
                }
                else {
                    if (column == 5) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        };
        table.setModel(model);
        model.setColumnIdentifiers(new String[]{"订单编号","客户编号","客户姓名","信用度","产品编号","产品名称","生产日期","产品类型","价格","购买时间"});
        //获得所有产品的集合
        List<Protect> protects=null;
        try {
            protects=DaoFactory.getBasicUserDaoInstance().findBasicProtectAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ArrayList<String> value=new ArrayList<>();
        for (Protect protect : protects)
        {
            value.add(protect.getProtectName());
        }

        for (order order : List) {
//          订单的当前产品为首选
            String[] str=value.toArray(new String[value.size()]);
            for (int i=0;i<str.length;i++)
            {
                String protectsName;
                if (order.getOrderProductName().equals(str[i]))
                {
                    protectsName=str[0];
                    str[0]=str[i];
                    str[i]=protectsName;
                }
            }
//            System.out.println(Arrays.toString((String[]) str));
            Object[] object = new Object[]{order.getOrderId(),order.getUserId(),order.getUserName(),order.getUserCredit(),
            order.getOrderProductId(),str,order.getProductDatetime(),order.getProductType(),order.getPrice(),order.getOrderDatetime()};
//            System.out.println(Arrays.toString((String[]) object[1]));
            model.addRow(object);
            System.out.println(Arrays.toString((String[]) table.getValueAt(model.getRowCount()-1,5)));
        }
//        order order1=order.builder()
//                .orderId(rs.getString("订单编号"))
//                .userId(rs.getString("客户编号"))
//                .userName(rs.getString("客户姓名"))
//                .userCredit(rs.getString("信用度"))
//                .orderProductId(rs.getString("产品编号"))
//                .orderProductName(rs.getString("产品名称"))
//                .productDatetime(rs.getTimestamp("生产日期"))
//                .productType(rs.getString("产品类型"))
//                .price(rs.getString("价格"))
//                .orderDatetime(rs.getTimestamp("购买时间"))
//                .build();
//        String[] values = new String[] { "5", "2", "3" };//这是下拉框的元素 由于是下拉框，这里必须是string数组传入
//        String[] value1 = new String[] { "3", "2", "1" };
//        String[] value2 = new String[] { "7", "8", "1" };
//        Object[] object1 = new Object[]{"111",values};
//        Object[] object2 = new Object[]{"111",value1};
//        Object[] object3 = new Object[]{"111",value2};
//        System.out.println(Arrays.toString((String[]) object1[1]));
//        System.out.println(Arrays.toString((String[]) object2[1]));
//        System.out.println(Arrays.toString((String[]) object3[1]));
//        model.addRow(object1);
//        model.addRow(object2);
//        model.addRow(object3);

        //重写jtable内插入下拉框
        MyTable.MyComboBoxEditor myComboBoxEditor=new MyTable.MyComboBoxEditor();
//        设置下拉框的改变事件
        java.util.List<Protect> finalProtects = protects;
        myComboBoxEditor.addCellEditorListener(new CellEditorListener() {
            @Override
            public void editingStopped(ChangeEvent e) {
                String[] strS=myComboBoxEditor.getCellEditorValue();
                int row=table.getSelectedRow();
                for (Protect protect : finalProtects)
                {
                    if (strS[0].equals(protect.getProtectName()))
                    {
                        model.setValueAt(protect.getProtectId(),row,4);
                        model.setValueAt(protect.getCreateTime(),row,6);
                        model.setValueAt(protect.getProtectType(),row,7);
                        model.setValueAt(protect.getPrice(),row,8);
                    }
                }
            }

            @Override
            public void editingCanceled(ChangeEvent e) {

            }
        });
        table.getColumnModel().getColumn(5).setCellEditor(myComboBoxEditor);
        MyTable.comboxRenderer comboxRenderer=new MyTable.comboxRenderer();
        table.getColumnModel().getColumn(5).setCellRenderer(comboxRenderer);
        //获得表头
        JTableHeader head = table.getTableHeader();
        //表头居中
        DefaultTableCellHeaderRenderer hr = new DefaultTableCellHeaderRenderer();
        hr.setHorizontalAlignment(JLabel.CENTER);
        head.setDefaultRenderer(hr);
        //设置表头大小
        head.setPreferredSize(new Dimension(head.getWidth(), 40));
        //设置表头字体
        head.setFont(new Font("宋体", Font.PLAIN, 16));
        //设置表格行高
        table.setRowHeight(35);
        //表格背景色
        table.setBackground(new Color(176, 195, 222));
        //表格内容居中
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, r);
        //表格加入滚动面板,水平垂直方向带滚动条
        JScrollPane scrollPane = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
//      对每个JList增加弹出菜单
        JPopupMenu jPopupMenu = new JPopupMenu();
        JMenuItem baocun = new JMenuItem("保存当前行");
        JMenuItem deleteItem = new JMenuItem("删除");
        jPopupMenu.add(baocun);
        baocun.addActionListener(e -> {
            int row = table.getSelectedRow();
            order order=new order();
            if (row==-1)
            {
                JOptionPane.showMessageDialog(this,"选中数据才能保存");
            }else {
                order.setOrderId(table.getValueAt(row,0).toString());
                order.setOrderProductId(table.getValueAt(row,4).toString());
                try {
                    DaoFactory.getUserManagementDaoInstance().updateOrder(order);
                    JOptionPane.showMessageDialog(this,"保存成功");
                } catch (SQLException throwable) {
                    throwable.printStackTrace();
                }
            }
        });
        deleteItem.addActionListener(e -> {
            int row = table.getSelectedRow();
            User user=new User();
            if (row==-1)
            {
                JOptionPane.showMessageDialog(this,"选中数据才能删除");
            }else {
                user.setUserId(table.getValueAt(row,0).toString());
                System.out.println(user.getUserId());
                try {
                    DaoFactory.getUserManagementDaoInstance().removeUser(user);
                    model.removeRow(row);
                    JOptionPane.showMessageDialog(this,"删除成功");
                } catch (SQLException throwable) {
                    throwable.printStackTrace();
                }
            }
        });
        jPopupMenu.add(deleteItem);
            table.add(jPopupMenu);
        table.addMouseListener(new MouseListener(){
            public void mouseClicked(MouseEvent e) {
                if(user_type.equals("管理员登录")) {
                    if (e.getButton() == 3) {
                        int right = table.rowAtPoint(e.getPoint());
                        System.out.println(right);
                        table.setRowSelectionInterval(right, right);
                        jPopupMenu.show(table, e.getX() + 15, e.getY() + 10);
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        TablePanel.add(scrollPane);
        TablePanel.revalidate();
    }

}
