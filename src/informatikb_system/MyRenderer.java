/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package informatikb_system;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Oliver
 */
public class MyRenderer extends DefaultTableCellRenderer{
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
        Component c = super.getTableCellRendererComponent(table, value, hasFocus, hasFocus, row, column);
        
        if(table.getValueAt(row, column) != null)
        {
        c.setBackground(Color.getHSBColor(0.5583333F, 0.80F, 0.6F));
        c.setForeground(Color.white);
        }
        else
        {
            c.setBackground(table.getBackground());
        }
        return c;
    }
    
}
