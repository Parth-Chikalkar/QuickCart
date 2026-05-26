package UI.CustomerPages;

import Controllers.OrderController;
import Controllers.ProductController;
import Models.Product;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.List;

public class Customer extends JPanel {

    private JTable table;
    private int id;

    public Customer(int id) {

        this.id = id;

        setLayout(new BorderLayout());

        JLabel title =
                new JLabel("Customer Dashboard for Customer No " + id);

        title.setHorizontalAlignment(SwingConstants.CENTER);

        add(title, BorderLayout.NORTH);

        List<Product> list =
                new ProductController().getAllProducts();

        String[] cols = {
                "Product Name",
                "Description",
                "Price",
                "Quantity",
                "Order"
        };

        Object[][] data = new Object[list.size()][5];

        for (int i = 0; i < list.size(); i++) {

            Product p = list.get(i);

            data[i][0] = p.getName();
            data[i][1] = p.getDescription();
            data[i][2] = p.getPrice();
            data[i][3] = "1";
            data[i][4] = "Order";
        }

        table = new JTable(data, cols);

        table.setRowHeight(30);

        // ORDER BUTTON
        table.getColumn("Order")
                .setCellRenderer(new ButtonRenderer());

        table.getColumn("Order")
                .setCellEditor(new ButtonEditor(new JCheckBox()));

        JScrollPane pane = new JScrollPane(table);

        add(pane, BorderLayout.CENTER);
    }

    // BUTTON RENDERER
    class ButtonRenderer extends JButton
            implements TableCellRenderer {

        public ButtonRenderer() {

            setText("Order");
        }

        @Override
        public Component getTableCellRendererComponent(
                JTable table,
                Object value,
                boolean isSelected,
                boolean hasFocus,
                int row,
                int column) {

            return this;
        }
    }

    // BUTTON EDITOR
    class ButtonEditor extends DefaultCellEditor {

        JButton button;

        public ButtonEditor(JCheckBox checkBox) {

            super(checkBox);

            button = new JButton("Order");

            button.addActionListener(e -> {

                int row = table.getSelectedRow();

                String productName =
                        table.getValueAt(row, 0).toString();

                String quantity =
                        table.getValueAt(row, 3).toString();
                     String description = table.getValueAt(row, 2).toString();

                boolean bool = new OrderController().addOrder(productName,description,Integer.parseInt(quantity));
                if(bool){
                    JOptionPane.showMessageDialog(null,"Order Place Sucessfully !");
                }
                else{
                    JOptionPane.showMessageDialog(null,"Ordering Failed due to some Internal of Logical Error ");
                }

            });
        }

        @Override
        public Component getTableCellEditorComponent(
                JTable table,
                Object value,
                boolean isSelected,
                int row,
                int column) {

            return button;
        }

        @Override
        public Object getCellEditorValue() {

            return "Order";
        }
    }
}