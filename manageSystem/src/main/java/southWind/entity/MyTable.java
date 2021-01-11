package southWind.entity;

import javax.swing.*;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.ArrayList;

public class MyTable extends JTable {
    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;
    public  void  aaaa() {
        MyTable table = new MyTable();
        final String[] columnNames = new String[]{"","序号"};
        DefaultTableModel defaultTableModel = new DefaultTableModel(new String[][]{}, columnNames);
        String[] values = new String[] { "5", "2", "3" };//这是下拉框的元素 由于是下拉框，这里必须是string数组传入
        String[] value1 = new String[] { "3", "2", "1" };
        String[] value2 = new String[] { "7", "8", "1" };
        table.setModel(defaultTableModel);
        defaultTableModel.addRow(new Object[]{"1",values});//将下拉框元素传入table的tablemodel中
        defaultTableModel.addRow(new Object[]{"2",value1});
        defaultTableModel.addRow(new Object[]{"3",value2});
        MyComboBoxEditor myComboBoxEditor=new MyComboBoxEditor();
        myComboBoxEditor.addCellEditorListener(new CellEditorListener() {
            @Override
            public void editingStopped(ChangeEvent e) {
                myComboBoxEditor.getCellEditorValue();
            }

            @Override
            public void editingCanceled(ChangeEvent e) {

            }
        });
        table.getColumnModel().getColumn(1).setCellEditor(myComboBoxEditor);
        comboxRenderer comboxRenderer=new comboxRenderer();

        table.getColumnModel().getColumn(1).setCellRenderer(comboxRenderer);
        comboxRenderer.addItemListener(e -> {
            System.out.println(111);
        });
        JScrollPane jp=new JScrollPane(table);
        jp.setViewportView(table);
        jp.setSize(400,300);
        JFrame jf=new JFrame();
        jf.getContentPane().add(jp);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(400,300);
        jf.setVisible(true);
    }

    public static class MyComboBoxEditor extends AbstractCellEditor implements TableCellEditor {
        public JComboBox box;
        Object Gvalue;
        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            String[] values = (String[])value;
            Gvalue=value;
            box =new JComboBox(values);
            return box;
        }
        @Override
        public String[] getCellEditorValue() {
            ArrayList<String> StringList=new ArrayList<>();
            StringList.add((String)box.getSelectedItem());
            String [] args =(String[]) Gvalue;
            for(int i=0;i<args.length;i++)
            {
                if(!args[i].equals(box.getSelectedItem())){
                    StringList.add(args[i]);
                }
            }
            String[] strings= StringList.toArray(new  String[args.length]);
            return strings;
        }
    }
    public static class comboxRenderer extends JComboBox implements TableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            String[] values = (String[])value ;
            JComboBox box=new JComboBox(values);
            return box;
        }
    }
    public static void main(String[] args) {
        MyTable table = new MyTable();
        table.aaaa();
    }
}
