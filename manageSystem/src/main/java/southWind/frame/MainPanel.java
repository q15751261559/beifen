package southWind.frame;

import southWind.entity.User;
import southWind.entity.Vo.UserVo;
import southWind.factory.DaoFactory;
import southWind.utils.ResultEntity;
import sun.swing.table.DefaultTableCellHeaderRenderer;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.List;

public class MainPanel extends JFrame {
    private JPanel mainPanel;
    private JPanel centerPanel;
    private JPanel adminPanel;
    private JPanel memberPanel;
    private JPanel userPanel;
    private JPanel rewardPanel;
    private JPanel userTablePanel;
    private JPanel topPanel;
    private JButton 订单管理Button;
    private JButton 客户管理Button;
    private JButton 员工管理Button;
    private JTextField searchField;
    private JButton 搜索Button;
    private JButton 保存Button;
    private JButton 重置Button;
    String userName;
    String account;
    private final CardLayout c;

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
            c.show(centerPanel, "1");
            showMember();
        }
        if (userType==2) {
            c.show(centerPanel, "2");
            showUser();
        }
        搜索Button.addActionListener(e -> {
            String userName= searchField.getText().trim();
            List<UserVo> list= null;
            try {
                list=DaoFactory.getBasicUserDaoInstance().findBasicUserByUserName(userName);
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            }
            showUserTable(list);
        });
        重置Button.addActionListener(e -> {
            try {
                showUserTable(DaoFactory.getBasicUserDaoInstance().findBasicUserAll());
            } catch (SQLException throwable) {
                throwable.printStackTrace();
            };
        });
    }

    private void init() {
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
    }

    public static void main(String[] args) {

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
        centerPanel.removeAll();
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
        userTablePanel.removeAll();
        JTable table = new JTable();
        //表格数据模型
        DefaultTableModel model = new DefaultTableModel(){
            //除第一列外均可编辑
            public boolean isCellEditable(int row,int column)
            {
                if (column==0) {
                    return false;
                }else {
                    return true;
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
        head.setFont(new Font("楷体", Font.PLAIN, 16));
        //设置表格行高
        table.setRowHeight(35);
        //表格背景色
        table.setBackground(new Color(223, 241, 234));
        //表格内容居中
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, r);
        //表格加入滚动面板,水平垂直方向带滚动条
        JScrollPane scrollPane = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
//        对每个JList增加弹出菜单
        JPopupMenu jPopupMenu = new JPopupMenu();
        JMenuItem 保存 = new JMenuItem("保存");
        JMenuItem deleteItem = new JMenuItem("删除");
        jPopupMenu.add(保存);
        jPopupMenu.add(deleteItem);
        table.add(jPopupMenu);
        table.addMouseListener(new MouseListener(){
            public void mouseClicked(MouseEvent e) {
                // 点击几次，这里是双击事件
                if (e.getButton()==3) {
                    int right=table.rowAtPoint(e.getPoint());
                    System.out.println(right);
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




        保存Button.addActionListener(e -> {
            int row = table.getSelectedRow();
            System.out.println(row);
            User user=new User();
            int i=0;
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
        } );
        userTablePanel.add(scrollPane);
        userTablePanel.revalidate();
    }
}
