package southWind.frame;

import southWind.connent.TxtThread;
import southWind.connent.TimeThread;
import southWind.entity.LoginAdmin;
import southWind.entity.LoginMember;
import southWind.entity.LoginUser;
import southWind.factory.ServiceFactory;
import southWind.utils.ResultEntity;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

/**
 * @ClassName AdminFrame
 * @Description TODO
 * @Author
 * @Date 2020/12/29
 **/

public class AdminFrame extends JFrame{
    private JPanel mainPanel;
    private JTextField accountFiled;
    private JPasswordField passwordFiled;
    private JButton loginBtn;
    private JButton resetBtn;
    private JLabel txtLabel;
   private JLabel timeLabel;
    private ImageIcon ico;
    private JLabel label;

    public AdminFrame(){
        //时间线程
//        TimeThread timeThread = new TimeThread();
//
//        timeThread.setTimeLabel(timeLabel);
//        timeThread.start();
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }catch(Exception e) {
            System.out.println(e);
        }
        this.setTitle("用户登录");
        this.setContentPane(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(390,300);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        loginBtn.addActionListener(e->{
            //user是1，member是2
            String account=accountFiled.getText().trim();
            String password=new String(passwordFiled.getPassword()).trim();
            ResultEntity resultEntity=ServiceFactory.getAdminServiceInstance().adminLogin(account,password);
            ResultEntity resultEntity1=ServiceFactory.getMemberServiceInstance().memberLogin(account,password);
            ResultEntity resultEntity2=ServiceFactory.getUserServiceInstance().userLogin(account,password);
            if(resultEntity.getCode()==0){
                JOptionPane.showMessageDialog(mainPanel,resultEntity.getMessage());
                this.dispose();
                new MainPanel(resultEntity);
            }
            if(resultEntity2.getCode()==1) {
                JOptionPane.showMessageDialog(mainPanel,resultEntity2.getMessage());
                this.dispose();
                new MainPanel(resultEntity2);
            }
            if(resultEntity1.getCode()==2){
                JOptionPane.showMessageDialog(mainPanel,resultEntity1.getMessage());
                this.dispose();
                new MainPanel(resultEntity1);
            }
            if(resultEntity.getCode()!=0&&resultEntity1.getCode()!=2&&resultEntity2.getCode()!=1)
            {
                JOptionPane.showMessageDialog(mainPanel,"请检查您的帐号或密码");
                accountFiled.setText("");
                passwordFiled.setText("");
            }

        });
        resetBtn.addActionListener(e->{
            accountFiled.setText("");
            passwordFiled.setText("");
        });
    }
    public static void main(String[] args) {
         new AdminFrame();
    }
}
